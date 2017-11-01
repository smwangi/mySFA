/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smwangi
 */
@Entity
@Table(name = "CRM_COUNTIES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmCounties.findAll", query = "SELECT c FROM CrmCounties c")
    , @NamedQuery(name = "CrmCounties.findByCountyId", query = "SELECT c FROM CrmCounties c WHERE c.countyId = :countyId")
    , @NamedQuery(name = "CrmCounties.findByCountryIdFk", query = "SELECT c FROM CrmCounties c WHERE c.countryIdFk = :countryIdFk")
    , @NamedQuery(name = "CrmCounties.findByCName", query = "SELECT c FROM CrmCounties c WHERE c.cName = :cName")
    , @NamedQuery(name = "CrmCounties.findByIsactive", query = "SELECT c FROM CrmCounties c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmCounties.findByIsdeleted", query = "SELECT c FROM CrmCounties c WHERE c.isdeleted = :isdeleted")})
public class CrmCounties implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COUNTY_ID", nullable = false, precision = 0, scale = -127)
    private Long countyId;
    @Column(name = "COUNTRY_ID_FK")
    private BigInteger countryIdFk;
    @Size(max = 20)
    @Column(name = "C_NAME", length = 20)
    private String cName;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmCounties() {
    }

    public CrmCounties(Long countyId) {
        this.countyId = countyId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public BigInteger getCountryIdFk() {
        return countryIdFk;
    }

    public void setCountryIdFk(BigInteger countryIdFk) {
        this.countryIdFk = countryIdFk;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public BigInteger getIsactive() {
        return isactive;
    }

    public void setIsactive(BigInteger isactive) {
        this.isactive = isactive;
    }

    public BigInteger getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(BigInteger isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countyId != null ? countyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmCounties)) {
            return false;
        }
        CrmCounties other = (CrmCounties) object;
        if ((this.countyId == null && other.countyId != null) || (this.countyId != null && !this.countyId.equals(other.countyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmCounties[ countyId=" + countyId + " ]";
    }
    
}
