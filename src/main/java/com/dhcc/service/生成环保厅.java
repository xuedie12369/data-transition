package com.dhcc.service;

import cn.hutool.core.text.csv.CsvRow;
import com.dhcc.entity.Districtc;
import com.dhcc.entity.hb.FinishedData;
import com.dhcc.entity.hb.ServerResponse;
import com.dhcc.util.MyCsvUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class 生成环保厅 {
    public static void main(String[] args) {
        List<CsvRow> dataByPath = MyCsvUtil.getDataByPath("C:\\Users\\50196\\Desktop\\清洁能源全省.csv");
        dataByPath.remove(0);

    }

    @RequestMapping("/queryLeft")
    public ServerResponse  hello() {
        List<CsvRow> dataByPath = MyCsvUtil.getDataByPath("C:\\Users\\50196\\Desktop\\清洁能源全省.csv");
        dataByPath.remove(0);
        List<FinishedData> finishedData = toDistrictc(dataByPath);
        return ServerResponse.createBySuccess(finishedData);
    }

    public static List<FinishedData> toDistrictc(List<CsvRow> datas) {
        List list = new ArrayList<FinishedData>(datas.size());

        for (CsvRow row : datas) {
            Object[] object = row.toArray();
            String year = object[0].toString().trim();
            String total = object[1].toString().trim();
            FinishedData finishedData = new FinishedData();
            finishedData.setYear(year);
            finishedData.setTotal(Float.valueOf(total));
            list.add(finishedData);
        }
        return list;
    }

}
