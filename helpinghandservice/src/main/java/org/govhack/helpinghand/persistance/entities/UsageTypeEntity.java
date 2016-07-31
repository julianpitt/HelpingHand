package org.govhack.helpinghand.persistance.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by James on 31-Jul-16.
 */
@Entity
@Table(name = "usagetype")
public class UsageTypeEntity {
    private int id;
    private String usageTypeCode;
    private String usageTypeDesc;
    private Date createdDate;
    private String archiveFlag;

    public UsageTypeEntity() {}

    public UsageTypeEntity(int id, String usageTypeCode, String usageTypeDesc, Date createdDate, String archiveFlag) {
        this.id = id;
        this.usageTypeCode = usageTypeCode;
        this.usageTypeDesc = usageTypeDesc;
        this.createdDate = createdDate;
        this.archiveFlag = archiveFlag;
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

    @Column(name = "UsageTypeCode")
    public String getUsageTypeCode() {
        return usageTypeCode;
    }

    public void setUsageTypeCode(String usageTypeCode) {
        this.usageTypeCode = usageTypeCode;
    }

    @Column(name = "UsageTypeDesc")
    public String getUsageTypeDesc() {
        return usageTypeDesc;
    }

    public void setUsageTypeDesc(String usageTypeDesc) {
        this.usageTypeDesc = usageTypeDesc;
    }

    @Column(name = "created_dttm")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "Archv_flag")
    public String getArchiveFlag() {
        return archiveFlag;
    }

    public void setArchiveFlag(String archiveFlag) {
        this.archiveFlag = archiveFlag;
    }
}