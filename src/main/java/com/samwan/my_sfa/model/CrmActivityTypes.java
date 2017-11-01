/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smwangi
 */
@Entity
@Table(name = "CRM_ACTIVITY_TYPES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmActivityTypes.findAll", query = "SELECT c FROM CrmActivityTypes c")
    , @NamedQuery(name = "CrmActivityTypes.findByTypeId", query = "SELECT c FROM CrmActivityTypes c WHERE c.typeId = :typeId")
    , @NamedQuery(name = "CrmActivityTypes.findByName", query = "SELECT c FROM CrmActivityTypes c WHERE c.name = :name")
    , @NamedQuery(name = "CrmActivityTypes.findByDescription", query = "SELECT c FROM CrmActivityTypes c WHERE c.description = :description")
    , @NamedQuery(name = "CrmActivityTypes.findByIsactive", query = "SELECT c FROM CrmActivityTypes c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmActivityTypes.findByAddedby", query = "SELECT c FROM CrmActivityTypes c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmActivityTypes.findByDateadded", query = "SELECT c FROM CrmActivityTypes c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmActivityTypes.findByActivityType", query = "SELECT c FROM CrmActivityTypes c WHERE c.activityType = :activityType")})
public class CrmActivityTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TYPE_ID", nullable = false, precision = 0, scale = -127)
    private Long typeId;
    @Size(max = 200)
    @Column(name = "NAME", length = 200)
    private String name;
    @Size(max = 300)
    @Column(name = "DESCRIPTION", length = 300)
    private String description;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ACTIVITY_TYPE")
    private BigInteger activityType;

    public CrmActivityTypes() {
    }

    public CrmActivityTypes(Long typeId) {
        this.typeId = typeId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getIsactive() {
        return isactive;
    }

    public void setIsactive(BigInteger isactive) {
        this.isactive = isactive;
    }

    public BigInteger getAddedby() {
        return addedby;
    }

    public void setAddedby(BigInteger addedby) {
        this.addedby = addedby;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public BigInteger getActivityType() {
        return activityType;
    }

    public void setActivityType(BigInteger activityType) {
        this.activityType = activityType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmActivityTypes)) {
            return false;
        }
        CrmActivityTypes other = (CrmActivityTypes) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmActivityTypes[ typeId=" + typeId + " ]";
    }
    
}
