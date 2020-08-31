package com.dhcc.service;

import cn.hutool.core.text.csv.CsvRow;
import com.dhcc.entity.Company;
import com.dhcc.entity.hb.TT_LR_COMPANY;
import com.dhcc.util.MyCsvUtil;

import java.util.ArrayList;
import java.util.List;

public class 生成公司经纬度信息 {
    public static void main(String[] args) {
        List<CsvRow> dataByPath = MyCsvUtil.getDataByPath("C:\\Users\\50196\\Desktop\\公司经纬度.csv");
        dataByPath.remove(0);

        List<Company> list = toCompany(dataByPath);
        StringBuilder stringBuilder=new StringBuilder();
        list.forEach(company -> {
            String sql="UPDATE company_info c SET c.LONGITUDE = "+company.getJd()+", c.LATITUDE = "+company.getWd()+"  WHERE c.`NAME` = '"+company.getName()+"';";
            stringBuilder.append(sql).append("\r\n");
        });
        System.out.println(stringBuilder);
    }
    static List<Company> toCompany(List<CsvRow> csvRows){
        List<Company> list=new ArrayList<>();
         for (CsvRow row : csvRows) {
            Object[] object = row.toArray();
            Company company = new Company();
            String name=object[0].toString();
            String jd=object[1].toString();
            String wd=object[2].toString();


             company.setName(name);
             company.setJd(jd);
             company.setWd(wd);
            list.add(company);
        }
        return list;
    }

}
