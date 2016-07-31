package org.govhack.helpinghand.dataservice.data;

import org.govhack.helpinghand.utils.Constants;
import org.govhack.helpinghand.utils.Reviews;

/**
 * Created by James on 30-Jul-16.
 */
public class DataUsageItem {
    private Reviews reviews = new Reviews();
    public DataUsageItem() {
        this.lat = Constants.DEFAULT_LATITUDE;
        this.lng = Constants.DEFAULT_LONGTITUDE;
        this.zone = 5;
        this.value = 0d;
        this.type = "";
        this.riceReview = reviews.getReview();
    }

    public DataUsageItem(double lng, double lat, int zone, double value, String type) {
        this.lng = lng;
        this.lat = lat;
        this.zone = zone;
        this.value = value;
        this.type = type;
        this.riceReview = reviews.getReview();
    }

    private double lng;
    private double lat;
    private int zone;
    private double value;
    private String riceReview;
    private String type;

    public String getRiceReview() {
        return riceReview;
    }

    public void setRiceReview(String riceReview) {
        this.riceReview = riceReview;
    }
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
