package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name="govstate")
public class StateEntity {

    private int id;
    private String stateName;
    private double latitude;
    private double longtitude;
    private int zoom;

    public StateEntity() { }

    public StateEntity(int id, String stateName, double latitude, double longtitude, int zoom) {
        this.id = id;
        this.stateName = stateName;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.zoom = zoom;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name ="StateName")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Column(name ="Latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(name ="Longitude")
    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Column(name ="Zoom")
    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }
}
