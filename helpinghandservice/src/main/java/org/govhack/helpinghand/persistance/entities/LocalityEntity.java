package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name = "locality")
public class LocalityEntity {

    private int id;
    private String localityName;
    private String localityDesc;
    private double latitude;
    private double longtitude;
    private int zoom;
    private StateEntity state;

    public LocalityEntity() {}

    public LocalityEntity(int id, String localityName, String localityDesc, double latitude, double longtitude, int zoom, StateEntity state) {
        this.id = id;
        this.localityName = localityName;
        this.localityDesc = localityDesc;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.zoom = zoom;
        this.state = state;
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

    @Column(name = "LocalityName")
    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    @Column(name = "LocalityDesc")
    public String getLocalityDesc() {
        return localityDesc;
    }

    public void setLocalityDesc(String localityDesc) {
        this.localityDesc = localityDesc;
    }

    @Column(name = "Latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "Longitude")
    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Column(name = "Zoom")
    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    @ManyToOne
    @JoinColumn(name="StateID")
    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }
}
