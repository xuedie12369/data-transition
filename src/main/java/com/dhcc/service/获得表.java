package com.dhcc.service;

import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.CharsetUtil;
import com.dhcc.entity.FiledJieGou;
import com.dhcc.entity.TableJieGou;
import com.dhcc.util.MyCsvUtil;
import org.apache.ibatis.annotations.Param;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class 获得表 {
    public static void main(String[] args) {
//        List<CsvRow> datas = MyCsvUtil.getData("all.csv");

        List<CsvRow> datas = MyCsvUtil.getData("TT_LR_COMPANY.csv");
//
//
      HashMap<String, List<FiledJieGou>> hashMap = toTableJieGou1(datas);
//        HashMap<String, List<FiledJieGou>> hashMap= toTableJieGou1(datas);
        hashMap.forEach((key, value) -> {
            System.out.println("key=" + key + ",value=" + value);

        });
        for (Object k :
                hashMap.keySet()) {
            StringBuilder stringBuilder = new StringBuilder("表名称：" + k + "\r\n");
            stringBuilder.append("字段名称,类型,说明\r\n");
            List<FiledJieGou> filedJieGouList = hashMap.get(k);
            filedJieGouList.forEach(p -> {
                stringBuilder.append(p.get字段名称() + "," + p.get类型() + "," + p.get说明()+"\r\n");
            });
            MyCsvUtil.writFile1(stringBuilder.toString(), "D:\\all\\"+k + ".csv");
        }
    }
    public static HashMap toTableJieGou1(List<CsvRow> datas) {
        List list = new ArrayList<TableJieGou>(datas.size());
        List<FiledJieGou> filedJieGouList = new ArrayList<>();
        HashMap<String, List<FiledJieGou>> hashMap = new HashMap<>();
        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            String hang = object[0].toString().trim();
            String[] split = hang.split(": ");
            FiledJieGou filedJieGou = new FiledJieGou();
            filedJieGou.set字段名称(split[0].trim());
            filedJieGou.set类型(split[1].trim().replace(",","，"));
            filedJieGou.set说明("");
            filedJieGouList.add(filedJieGou);
        }
        hashMap.put("TT_LR_COMPANY",filedJieGouList);
        return hashMap;
    }
    public static HashMap toTableJieGou(List<CsvRow> datas) {
        List list = new ArrayList<TableJieGou>(datas.size());
        TableJieGou tableJieGou = null;
        List<FiledJieGou> filedJieGouList = new ArrayList<>();
        HashMap<String, List<FiledJieGou>> hashMap = new HashMap<>();
        String tableName = "TT_LR_PERSON_DOSAGE";

        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            String hang = object[0].toString().trim();
            String[] split = hang.split(": ");
            if (split.length == 1) {
                List<FiledJieGou> filedJieGouList1 = new ArrayList<>();
                filedJieGouList1.addAll(filedJieGouList);
                hashMap.put(tableName, filedJieGouList1);
                filedJieGouList.clear();
                tableName = split[0].trim();
                continue;
            }

            FiledJieGou filedJieGou = new FiledJieGou();
            filedJieGou.set字段名称(split[0].trim());
            filedJieGou.set类型(split[1].trim().replace(",","，"));
            filedJieGou.set说明("");
            filedJieGouList.add(filedJieGou);
        }
        return hashMap;
    }
}
