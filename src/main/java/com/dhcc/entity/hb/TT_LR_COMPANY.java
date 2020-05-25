package com.dhcc.entity.hb;

public class TT_LR_COMPANY {
    private String 字段名="";
    private String 字段类型="";

    private String 字段描述="";
    private String 备注="";

    public String get字段类型() {
        return 字段类型;
    }

    public void set字段类型(String 字段类型) {
        this.字段类型 = 字段类型;
    }

    public String get字段名() {
        return 字段名;
    }

    public void set字段名(String 字段名) {
        this.字段名 = 字段名;
    }

    public String get字段描述() {
        return 字段描述;
    }

    public void set字段描述(String 字段描述) {
        this.字段描述 = 字段描述;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }

    @Override
    public String toString() {
        return "TT_LR_COMPANY{" +
                "字段名='" + 字段名 + '\'' +
                ", 字段类型='" + 字段类型 + '\'' +
                ", 字段描述='" + 字段描述 + '\'' +
                ", 备注='" + 备注 + '\'' +
                '}';
    }
}
