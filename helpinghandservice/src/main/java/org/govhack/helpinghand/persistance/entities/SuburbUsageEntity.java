package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name="suburbusage")
public class SuburbUsageEntity {
    public SuburbUsageEntity() { }

    private int id;
    private UsageTypeEntity usageType;
    private double value;
    private SuburbEntity suburb;

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

    @ManyToOne
    @JoinColumn(name = "SuburbID")
    public SuburbEntity getSuburb() {
        return suburb;
    }

    public void setSuburb(SuburbEntity suburb) {
        this.suburb = suburb;
    }

    @Column(name="VALUE")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
