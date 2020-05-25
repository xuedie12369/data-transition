package com.dhcc.entity;

import java.util.Objects;

public class Districtc {
    private String id;
    private String district_code;
    private String district;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public Districtc(){

    }
    public Districtc(String id, String district_code, String district) {
        this.id = id;
        this.district_code = district_code;
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Districtc districtc = (Districtc) o;
        return Objects.equals(id, districtc.id) &&
                Objects.equals(district_code, districtc.district_code) &&
                Objects.equals(district, districtc.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, district_code, district);
    }

    @Override
    public String toString() {
        return "Districtc{" +
                "id='" + id + '\'' +
                ", district_code='" + district_code + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
