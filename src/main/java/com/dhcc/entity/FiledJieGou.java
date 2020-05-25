package com.dhcc.entity;
public class FiledJieGou {
    private  String 字段名称;
    private  String 类型;
    private  String 说明;

    public String get字段名称() {
        return 字段名称;
    }

    public void set字段名称(String 字段名称) {
        this.字段名称 = 字段名称;
    }

    public String get类型() {
        return 类型;
    }

    public void set类型(String 类型) {
        this.类型 = 类型;
    }

    public String get说明() {
        return 说明;
    }

    public void set说明(String 说明) {
        this.说明 = 说明;
    }

    @Override
    public String toString() {
        return "FiledJieGou{" +
                "字段名称='" + 字段名称 + '\'' +
                ", 类型='" + 类型 + '\'' +
                ", 说明='" + 说明 + '\'' +
                '}';
    }
}
