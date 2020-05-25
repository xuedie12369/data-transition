package com.dhcc.service;

import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.util.StrUtil;
import com.dhcc.entity.*;
import com.dhcc.util.MyCsvUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class 获得城市 {
    public static void main(String[] args) {

        StringBuilder stringBuilder=new StringBuilder();
        List<CsvRow> datas = MyCsvUtil.getData("district.csv");
        datas.remove(0);
        List<Districtc> districtcs = toDistrictc(datas);

        List<CsvRow> regionRows = MyCsvUtil.getData("region.csv");
        regionRows.remove(0);

        List<Region> regions = toRegion(regionRows);


        districtcs.forEach(p -> {


//            System.out.println( p.toString());
        });

        //气电煤数据
        List<CsvRow> csvRows = MyCsvUtil.getData("2019年全省农户情况汇总表.csv");
        csvRows.remove(0);
        List<FinishedData> finishedDatas = toFinished_Data(csvRows);
        AtomicInteger id= new AtomicInteger(802);

        finishedDatas.forEach(p -> {
            id.getAndIncrement();
            for (Region region :regions){
                if((region.getCity()+"市").equals(p.getShi())){
                    stringBuilder.append(" INSERT INTO `finished_data`(`id`, `year`, `city_name`, `qdm`, `ddm`, `total`, `district_code`) VALUES ("+id+", '2019', '"+region.getCity()+"', "+p.getQdm()+", "+p.getDdm()+", "+p.getTotal()+", "+region.getDistrict_code()+");\r\n  ");
                }
            }

        });
/*        finishedDatas.forEach(p -> {
           *//* for (Region region:regions)
            {
                if (region.getDistrict().equals(p.getXian())){
                    System.out.println(region.getDistrict_code());
                }

            }*//*
        try {
            Region region1 = regions.stream().filter(region -> region.getDistrict().contains(p.getXian())&&region.getCity().equals(p.getShi())).findFirst().get();
   *//*            Stream<Region> regionStream = regions.stream().filter(region -> region.getDistrict().contains(p.getXian()) && region.getCity().equals(p.getShi()));
               if (regionStream.count()>1){
                   System.out.println("错误+"+p.getXian());
               }*//*
            //               System.out.println(region1.getDistrict_code());

            id.getAndIncrement();
            stringBuilder.append(" INSERT INTO `finished_data`(`id`, `year`, `city_name`, `qdm`, `ddm`, `total`, `district_code`) VALUES ("+id+", '2019', '"+p.getXian()+"', "+p.getQdm()+", "+p.getDdm()+", "+p.getTotal()+", "+region1.getDistrict_code()+");\r\n  ");

        }catch (Exception e){
            System.out.println(p.getShi()+" , "+p.getXian());
        }
    });*/
        MyCsvUtil.writFile(stringBuilder.toString(),"市区.sql");

    }

    public static List<Region> toRegion(List<CsvRow> datas) {
        List list = new ArrayList<Region>(datas.size());
        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            String district_code = object[0].toString().trim();
            String district = object[1].toString().trim();
            String city = object[2].toString().trim();
            String type = object[3].toString().trim();

            Region region = new Region();
            region.setDistrict(district);
            region.setDistrict_code(district_code);
            region.setCity(city);
            region.setType(type);
         /*   if (!city.contains("市")){
                region.setCity(city+"市");
            }*/
         if (type.equals("CITY")){
             list.add(region);
         }
        }
        return list;
    }

    public static List<FinishedData> toFinished_Data(List<CsvRow> datas) {
        List list = new ArrayList<FinishedData>(datas.size());
        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            String shi = object[1].toString().trim();
            String xian = object[2].toString().trim();
            String qdm = object[3].toString().trim();
            String ddm_0 = object[4].toString().trim();
            String ddm_1 = object[5].toString().trim();
            String ddm_2 = object[6].toString().trim();
            Double ddm=0.0;
            if (StrUtil.isNotBlank(ddm_0)){
                ddm=ddm+Double.valueOf(ddm_0);
            }
            if (StrUtil.isNotBlank(ddm_1)){
                ddm=ddm+Double.valueOf(ddm_1);

            }
            if (StrUtil.isNotBlank(ddm_2)){
                ddm=ddm+Double.valueOf(ddm_2);
            }


            if (!xian.equals("小计")) {
                continue;
            }
            FinishedData finishedData = new FinishedData();
            finishedData.setShi(shi);
            finishedData.setXian(xian);

            if (StrUtil.isNotBlank(qdm)) {
                finishedData.setQdm(Double.valueOf(qdm)/10000.0);
            }

            finishedData.setDdm(Double.valueOf(ddm)/10000.0);
            finishedData.setTotal((finishedData.getDdm() + finishedData.getQdm()));

            list.add(finishedData);
        }
        return list;
    }

    public static List<Districtc> toDistrictc(List<CsvRow> datas) {
        List list = new ArrayList<Districtc>(datas.size());

        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            String id = object[0].toString().trim();
            String district_code = object[1].toString().trim();
            String district = object[2].toString().trim();
            Districtc districtc = new Districtc();
            districtc.setDistrict(district);
            districtc.setDistrict_code(district_code);
            districtc.setId(id);
            list.add(districtc);
        }
        return list;
    }


}
