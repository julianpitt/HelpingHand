package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name="stateusage")
public class StateUsageEntity {
    private int id;
    private UsageTypeEntity usageType;
    private double value;
    private StateEntity state;

    public StateUsageEntity() {}

    public StateUsageEntity(int id, UsageTypeEntity usageType, double value, StateEntity state) {
        this.id = id;
        this.usageType = usageType;
        this.value = value;
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
    @JoinColumn(name = "UsageTypeID")
    public UsageTypeEntity getUsageType() {
        return usageType;
    }

    public void setUsageType(UsageTypeEntity usageType) {
        this.usageType = usageType;
    }

    @Column(name = "VALUE")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
