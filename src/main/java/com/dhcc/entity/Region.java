package com.dhcc.entity;

import java.util.Objects;

public class Region {

    private String district_code;

    private String district;
    private String city;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(district_code, region.district_code) &&
                Objects.equals(district, region.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(district_code, district);
    }
}
