package com.dhcc.entity;

import java.util.Objects;

public class FinishedData {

    private  String shi;
    private  String xian;

    private  Double qdm=0.0;
    private  Double ddm=0.0;
    private  Double total=0.0;


    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public Double getQdm() {
        return qdm;
    }

    public void setQdm(Double qdm) {
        this.qdm = qdm;
    }

    public Double getDdm() {
        return ddm;
    }

    public void setDdm(Double ddm) {
        this.ddm = ddm;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinishedData that = (FinishedData) o;
        return Objects.equals(shi, that.shi) &&
                Objects.equals(xian, that.xian) &&
                Objects.equals(qdm, that.qdm) &&
                Objects.equals(ddm, that.ddm) &&
                Objects.equals(total, that.total);
    }


    public FinishedData() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(shi, xian, qdm, ddm, total);
    }

    @Override
    public String toString() {
        return "FinishedData{" +
                "shi='" + shi + '\'' +
                ", xian='" + xian + '\'' +
                ", qdm=" + qdm +
                ", ddm=" + ddm +
                ", total=" + total +
                '}';
    }
}
