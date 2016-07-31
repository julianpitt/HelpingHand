package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name = "trendtype")
public class TrendTypeEntity {
    private int id;
    private String trendTypeCode;
    private String trendDesc;
    private Date createdDate;

    public TrendTypeEntity() {
    }

    public TrendTypeEntity(int id, String trendTypeCode, String trendDesc, Date createdDate) {
        this.id = id;
        this.trendTypeCode = trendTypeCode;
        this.trendDesc = trendDesc;
        this.createdDate = createdDate;
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

    @Column(name = "TrendTypeCode")
    public String getTrendTypeCode() {
        return trendTypeCode;
    }

    public void setTrendTypeCode(String trendTypeCode) {
        this.trendTypeCode = trendTypeCode;
    }

    @Column(name = "TrendTypeDesc")
    public String getTrendDesc() {
        return trendDesc;
    }

    public void setTrendDesc(String trendDesc) {
        this.trendDesc = trendDesc;
    }

    @Column(name = "Create_dttm")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
