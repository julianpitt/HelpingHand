package org.govhack.helpinghand.api.request;

/**
 * Created by James on 30-Jul-16.
 */
public class UsageRequest extends BaseRequest {
    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(long longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public int getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(int zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public UsageRequest(double longtitude, double latitude, int zoomLevel, String type) {
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.zoomLevel = zoomLevel;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    private String type;
    private double latitude;
    private double longtitude;
    private int zoomLevel;
}
