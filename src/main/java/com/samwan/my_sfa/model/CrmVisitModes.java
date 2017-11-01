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
@Table(name = "CRM_VISIT_MODES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmVisitModes.findAll", query = "SELECT c FROM CrmVisitModes c")
    , @NamedQuery(name = "CrmVisitModes.findByModeId", query = "SELECT c FROM CrmVisitModes c WHERE c.modeId = :modeId")
    , @NamedQuery(name = "CrmVisitModes.findByName", query = "SELECT c FROM CrmVisitModes c WHERE c.name = :name")
    , @NamedQuery(name = "CrmVisitModes.findByDescription", query = "SELECT c FROM CrmVisitModes c WHERE c.description = :description")
    , @NamedQuery(name = "CrmVisitModes.findByIsactive", query = "SELECT c FROM CrmVisitModes c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmVisitModes.findByAddedby", query = "SELECT c FROM CrmVisitModes c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmVisitModes.findByDateadded", query = "SELECT c FROM CrmVisitModes c WHERE c.dateadded = :dateadded")})
public class CrmVisitModes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODE_ID", nullable = false, precision = 0, scale = -127)
    private Long modeId;
    @Size(max = 150)
    @Column(name = "NAME", length = 150)
    private String name;
    @Size(max = 200)
    @Column(name = "DESCRIPTION", length = 200)
    private String description;
    @Column(name = "ISACTIVE")
    private Short isactive;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;

    public CrmVisitModes() {
    }

    public CrmVisitModes(Long modeId) {
        this.modeId = modeId;
    }

    public Long getModeId() {
        return modeId;
    }

    public void setModeId(Long modeId) {
        this.modeId = modeId;
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

    public Short getIsactive() {
        return isactive;
    }

    public void setIsactive(Short isactive) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modeId != null ? modeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmVisitModes)) {
            return false;
        }
        CrmVisitModes other = (CrmVisitModes) object;
        if ((this.modeId == null && other.modeId != null) || (this.modeId != null && !this.modeId.equals(other.modeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmVisitModes[ modeId=" + modeId + " ]";
    }
    
}
