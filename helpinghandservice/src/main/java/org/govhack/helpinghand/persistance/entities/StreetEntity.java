package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name="street")
public class StreetEntity {
    private int id;
    private String streetName;
    private String streetType;
    private String streetDesc;
    private double latitude;
    private double longtitude;
    private int zoom;
    private SuburbEntity suburbEntity;

    public StreetEntity() {}

    public StreetEntity(int id, String streetName, String streetType, String streetDesc, double latitude, double longtitude, int zoom, SuburbEntity suburbEntity) {
        this.id = id;
        this.streetName = streetName;
        this.streetType = streetType;
        this.streetDesc = streetDesc;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.zoom = zoom;
        this.suburbEntity = suburbEntity;
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

    @Column(name = "StreetName")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Column(name = "StreetType")
    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    @Column(name = "StreetDesc")
    public String getStreetDesc() {
        return streetDesc;
    }

    public void setStreetDesc(String streetDesc) {
        this.streetDesc = streetDesc;
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
    @JoinColumn(name = "SuburbID")
    public SuburbEntity getSuburbEntity() {
        return suburbEntity;
    }

    public void setSuburbEntity(SuburbEntity suburbEntity) {
        this.suburbEntity = suburbEntity;
    }
}
