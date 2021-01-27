package com.dhcc.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyCsvUtil {

    public static List<CsvRow> getData(String fileName) {
        String localFile = "D:\\" + fileName;
        File file = FileUtil.file(localFile);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在：" + localFile);
        }
        CsvReader reader = CsvUtil.getReader();
        CsvData data = reader.read(file, CharsetUtil.CHARSET_UTF_8);
        List<CsvRow> rows = data.getRows();
        return rows;
    }


    public static List<CsvRow> getDataByPath(String path) {
        File file = FileUtil.file(path);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在：" + path);
        }
        CsvReader reader = CsvUtil.getReader();
        CsvData data = reader.read(file, CharsetUtil.CHARSET_GBK);
        List<CsvRow> rows = data.getRows();
        return rows;
    }

    public static void writFile(String string, String fileName) {
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        String path = "D:\\" + fileName + ".sql";
        FileWriter writer = new FileWriter(path, CharsetUtil.CHARSET_UTF_8);
        writer.write(string);
        System.out.println("写入文件成功：" + path);
    }

    public static void writFile(String string, String fileName, String fileSuffix) {
        String path = "D:\\" + fileName + fileSuffix;
        FileWriter writer = new FileWriter(path, CharsetUtil.CHARSET_UTF_8);
        writer.write(string);
        System.out.println("写入文件成功：" + path);
    }

    public static void writFile1(String string, String path) {
        FileWriter writer = new FileWriter(path, CharsetUtil.CHARSET_UTF_8);
        writer.write(string);
        System.out.println("写入文件成功：" + path);
    }

    public static void main(String[] args) {
//        String str="INSERT INTO `radial_base_info`(`id`, `gmt_create`, `gmt_modified`, `CATEGORY`, `CITY`, `CODE`, `OLD_COMPANY_ID`, `COMPANY_ID`, `COMPANY_NAME`, `COUNTRY`, `DISTRICT`, `INDUSTRY_TYPE`, `KIND`, `LEAVE_FACTORY_ACTIVITY`, `LEAVE_FACTORY_DATE`, `LICENSE_NO`, `MANUFACTURE`, `NUCLIDE`, `PROVINCE`, `REMARK`, `STATUS`, `TAB`, `UPDATE_DATE`, `USE_PROVINCE`, `USE_TYPE`, `INSTANCEID`, `OPERATE_TYPE`, `USER_ID`, `BUSINESS_ID`, `CN_STATUS`, `RECYCLE_CODE`, `BE_END_STATUS`, `ISHISTORY`, `SPECIAL_FLAG`, `type`, `backup1`, `backup2`) VALUES" +
//                " (255295, '2020-06-17 20:50:41', '2020-06-17 20:50:41', '3', '廊坊市', 'GB87AB099603', 'old_689BB5E8558E106CE66228FC7AC49297_82647', '', '中国石油集团测井有限公司华北事业部廊坊测井项目部', '英国', '广阳区', '能源矿产地质勘查', '企业', '185000000000', '1987-04-28 00:00:00', '冀环辐证[S0416]', NULL, 'Am-241/Be', '河北省', NULL, '2', 'ZC021', '2018-03-30 11:07:02', NULL, '测井仪', '38B8799D53F19AD3B551E75F083D75A3', '放射源转让', 'fushechu1', '40288b955e523157015e5ee93baa1bc2', '使用', NULL, NULL, 1, NULL, 'ts', NULL, NULL);";

        合并excel();
    }


    public static void 合并excel() {
//        多个excel存放的目录
        String excelFileDir = "C:\\Users\\50196\\Documents\\WeChat Files\\nannan501968797\\FileStorage\\File\\2020-09\\124枚高风险移动放射源在线监控2020.09.01(1)\\124枚高风险移动放射源在线监控2020.09.01";
        String outPutDir = "D:\\";
        List<String> list = FileUtil.listFileNames(excelFileDir);
        List<String> filePaths = new ArrayList<>();


        list.forEach(fileName -> {
            filePaths.add(excelFileDir + "\\" + fileName);
        });

        List<String> all = new ArrayList<>();
        for (String filePath : filePaths) {
            ExcelReader reader = ExcelUtil.getReader(filePath);
            List<List<Object>> readAll = reader.read();

            List<List<String>> rows = new ArrayList<>();
            for (List<Object> objects : readAll) {
                if (objects.toString().equals("[-]")) {
                    continue;
                }
                if (objects.toString().equals("[序号, 编码, 核素, 出厂日期, 出厂活度（贝可）, 实时活度（贝可）, 标号, 类别, 用途, 状态, 工作场所, 来源, 审核人, 审核日期]")) {
                    continue;
                }
                all.add(objects.toString() + "," + FileUtil.getName(filePath));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (Object o : all) {
            String s = StrUtil.removeAll(o.toString(), '[', ']');
            stringBuilder.append(s);
            stringBuilder.append("\r\n");
        }
        File file = FileUtil.writeUtf8String(stringBuilder.toString(), outPutDir + "生成的csv.csv");
        System.out.println("文件合并完毕,合并后的路径：" + file.toString());

    }

    public static void writerXlsx(String path, String fileName, List<List<String>> rows) {
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        ExcelWriter writer = ExcelUtil.getWriter(path + fileName + ".xlsx");
        writer.write(rows, false);
        writer.setColumnWidth(0, 30);

        writer.setColumnWidth(1, 30);
        writer.setColumnWidth(2, 30);
        writer.setColumnWidth(3, 50);

        writer.close();

        System.out.println("写入文件成功：" + path + fileName + ".xlsx");

    }
}
