package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name="suburbtrend")
public class SuburbTrendEntity {
    private int id;
    private TrendTypeEntity trendType;
    private double value;
    private Date startDate;
    private Date endDate;
    private SuburbEntity suburb;

    public SuburbTrendEntity() {
    }

    public SuburbTrendEntity(int id, TrendTypeEntity trendType, double value, Date startDate, Date endDate, SuburbEntity suburb) {
        this.id = id;
        this.trendType = trendType;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
        this.suburb = suburb;
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

    @ManyToOne
    @JoinColumn(name = "TrendTypeID")
    public TrendTypeEntity getTrendType() {
        return trendType;
    }

    public void setTrendType(TrendTypeEntity trendType) {
        this.trendType = trendType;
    }

    @Column(name = "VALUE")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Column(name = "Start_dttm")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "End_dttm")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToOne
    @JoinColumn(name = "SuburbID")
    public SuburbEntity getSuburb() {
        return suburb;
    }

    public void setSuburb(SuburbEntity suburb) {
        this.suburb = suburb;
    }
}
