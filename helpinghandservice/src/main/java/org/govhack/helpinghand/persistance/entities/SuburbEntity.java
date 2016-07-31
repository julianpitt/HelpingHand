package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name="suburb")
public class SuburbEntity {
    private int id;
    private String suburbName;
    private String suburbDesc;
    private String postcode;
    private double latitude;
    private double longtitude;
    private int zoom;
    private LocalityEntity locality;

    public SuburbEntity() {}

    public SuburbEntity(int id, String suburbName, String suburbDesc, String postcode, double latitude, double longtitude, int zoom, LocalityEntity locality) {
        this.id = id;
        this.suburbName = suburbName;
        this.suburbDesc = suburbDesc;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.zoom = zoom;
        this.locality = locality;
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

    @Column(name="SuburbName")
    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    @Column(name="SuburbDesc")
    public String getSuburbDesc() {
        return suburbDesc;
    }

    public void setSuburbDesc(String suburbDesc) {
        this.suburbDesc = suburbDesc;
    }

    @Column(name="PostCode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name="Latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(name="Longitude")
    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Column(name = "Zoom")
    public int getZoom() { return zoom; }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    @ManyToOne
    @JoinColumn(name="LocalityID")
    public LocalityEntity getLocality() {
        return locality;
    }

    public void setLocality(LocalityEntity locality) {
        this.locality = locality;
    }
}
