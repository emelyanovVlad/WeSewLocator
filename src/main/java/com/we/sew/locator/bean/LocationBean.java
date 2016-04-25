package com.we.sew.locator.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Vladyslav_Yemelianov
 */
public class LocationBean {
    @NotBlank
    private String name;

    private double latitude;

    private double longtitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
}
