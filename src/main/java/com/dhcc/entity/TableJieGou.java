package com.dhcc.entity;

import java.util.List;

public class TableJieGou {
    private String name;
    private List<FiledJieGou> filedJieGouList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FiledJieGou> getFiledJieGouList() {
        return filedJieGouList;
    }

    public void setFiledJieGouList(List<FiledJieGou> filedJieGouList) {
        this.filedJieGouList = filedJieGouList;
    }
}
