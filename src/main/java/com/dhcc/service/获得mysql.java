package com.dhcc.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.dhcc.util.MyCsvUtil;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

public class 获得mysql {

    public static void main(String[] args) throws IOException {
        String filename = "";
        BufferedReader utf8Reader = FileUtil.getUtf8Reader("C:\\Users\\50196\\Desktop\\TT_LR_COMPANY.sql");
        StringBuilder stringBuilder=new StringBuilder();
        String contxt = null;
        while (StrUtil.isNotBlank( contxt=utf8Reader.readLine())){
            contxt=contxt.replace("\"", "`");
            contxt=contxt.replace("''",  "`");
            contxt=contxt.replace("TT_LR_COMPANY", "company_info");
            contxt=contxt.replace("TO_TIMESTAMP", "");
            contxt=contxt.replace(", 'SYYYY-MM-DD HH24:MI:SS:FF6'", "");


            contxt=contxt.replace("TO_DATE","");
            contxt=contxt.replace(", 'SYYYY-MM-DD HH24:MI:SS'","");
            stringBuilder.append(contxt+"\r\n");
        }
        System.out.println(stringBuilder);
        MyCsvUtil.writFile1(stringBuilder.toString(),"D:\\TT_LR_COMPANY.sql");
    }
}
