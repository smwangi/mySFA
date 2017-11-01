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
@Table(name = "CRM_REGIONS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmRegions.findAll", query = "SELECT c FROM CrmRegions c")
    , @NamedQuery(name = "CrmRegions.findByRegionId", query = "SELECT c FROM CrmRegions c WHERE c.regionId = :regionId")
    , @NamedQuery(name = "CrmRegions.findByRName", query = "SELECT c FROM CrmRegions c WHERE c.rName = :rName")
    , @NamedQuery(name = "CrmRegions.findByDateadded", query = "SELECT c FROM CrmRegions c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmRegions.findByIsactive", query = "SELECT c FROM CrmRegions c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmRegions.findByCountryId", query = "SELECT c FROM CrmRegions c WHERE c.countryId = :countryId")})
public class CrmRegions implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGION_ID", nullable = false, precision = 0, scale = -127)
    private Long regionId;
    @Size(max = 200)
    @Column(name = "R_NAME", length = 200)
    private String rName;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "COUNTRY_ID")
    private BigInteger countryId;

    public CrmRegions() {
    }

    public CrmRegions(Long regionId) {
        this.regionId = regionId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public BigInteger getIsactive() {
        return isactive;
    }

    public void setIsactive(BigInteger isactive) {
        this.isactive = isactive;
    }

    public BigInteger getCountryId() {
        return countryId;
    }

    public void setCountryId(BigInteger countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmRegions)) {
            return false;
        }
        CrmRegions other = (CrmRegions) object;
        if ((this.regionId == null && other.regionId != null) || (this.regionId != null && !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmRegions[ regionId=" + regionId + " ]";
    }
    
}
