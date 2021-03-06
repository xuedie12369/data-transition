package com.dhcc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.dhcc.entity.FiledJieGou;
import com.dhcc.entity.FinishedData;
import com.dhcc.entity.hb.TT_LR_COMPANY;
import com.dhcc.util.MyCsvUtil;
import org.apache.poi.ss.formula.functions.Rows;
import sun.security.util.ArrayUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 匹配设置字段描述信息 {
    public static List<String> getFilePath(String basePath) {
        String[] list = new File(basePath).list();
        return Arrays.asList(list);
    }

    public static void main(String[] args) {
        String resourceRoot = "C:\\Users\\孙\\Desktop\\原信息\\";
//        List<String> finames = getFilePath(resourceRoot);
        List<String> finames =new ArrayList<>();
        finames.add("1.csv");

        for (String fileName :
                finames) {

            List<CsvRow> resourceDatas = MyCsvUtil.getDataByPath(resourceRoot + fileName);
            String tempName=resourceDatas.get(0).get(0);
            resourceDatas.remove(0);
            resourceDatas.remove(0);
            List resourceList = toTT_LR_COMPANY(resourceDatas);
            HashMap<String, List> map=null;
            try {
                 map = (HashMap<String, List>) resourceList.stream().collect(Collectors.toMap(TT_LR_COMPANY::get字段名, a -> a));

            }catch (Exception e){
                System.out.println(fileName);
            }


            List<CsvRow> targetDatas = MyCsvUtil.getDataByPath("D:\\all - 副本\\" + fileName);
            targetDatas.remove(0);
            targetDatas.remove(0);

            List<TT_LR_COMPANY> targetList = toTarTT_LR_COMPANY(targetDatas);
            HashMap<String, List> finalMap = map;
            targetList.forEach(p -> {
                TT_LR_COMPANY tt_lr_company = (TT_LR_COMPANY) finalMap.get(p.get字段名());
                if (tt_lr_company != null) {
                    p.set备注(tt_lr_company.get备注());
                    p.set字段描述(tt_lr_company.get字段描述());
                }
            });

            StringBuilder stringBuilder = new StringBuilder("表名称：" + tempName);
            List<List<String>> rows = new ArrayList<>();
            rows.add(CollUtil.newArrayList("表名称：" + fileName + "\r\n"));
            rows.add(CollUtil.newArrayList("字段名称", "类型", "字段描述", "备注"));
            targetList.forEach(p -> {
//                stringBuilder.append(p.get字段名() + "," + p.get字段类型() + "," + p.get字段描述() + "," + p.get备注() + "\r\n");

                List<String> row1 = CollUtil.newArrayList(p.get字段名(), p.get字段类型(), p.get字段描述(), p.get备注());
                rows.add(row1);
            });

//            MyCsvUtil.writFile1(stringBuilder.toString(), "D:\\final\\" + fileName);
            MyCsvUtil.writerXlsx("D:\\final\\", fileName, rows);
        }


    }


    public static List toTarTT_LR_COMPANY(List<CsvRow> datas) {
        List list = new ArrayList<TT_LR_COMPANY>(datas.size());
        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            TT_LR_COMPANY tt_lr_company = new TT_LR_COMPANY();
            tt_lr_company.set字段名(object[0].toString().trim().toUpperCase());
            tt_lr_company.set字段类型(object[1].toString().trim());
            list.add(tt_lr_company);
        }
        return list;
    }

    public static List toTT_LR_COMPANY(List<CsvRow> datas) {
        List list = new ArrayList<TT_LR_COMPANY>(datas.size());
        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            TT_LR_COMPANY tt_lr_company = new TT_LR_COMPANY();
            tt_lr_company.set字段名(object[0].toString().trim().toUpperCase());
            tt_lr_company.set字段描述(object[1].toString().trim());
            tt_lr_company.set备注(object[2].toString().trim());
            list.add(tt_lr_company);
        }
        return list;
    }
}
