package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name="statetrend")
public class StateTrendEntity {
    private int id;
    private TrendTypeEntity trendType;
    private double value;
    private Date startDate;
    private Date endDate;
    private StateEntity state;

    public StateTrendEntity() {}

    public StateTrendEntity(int id, TrendTypeEntity trendType, double value, Date startDate, Date endDate, StateEntity state) {
        this.id = id;
        this.trendType = trendType;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
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
    @JoinColumn(name = "StateID")
    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }
}
