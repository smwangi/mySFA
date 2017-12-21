/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

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
@Table(name = "COUNTRIES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")
    , @NamedQuery(name = "Countries.findByCountryId", query = "SELECT c FROM Countries c WHERE c.countryId = :countryId")
    , @NamedQuery(name = "Countries.findByCName", query = "SELECT c FROM Countries c WHERE c.cName = :cName")
    , @NamedQuery(name = "Countries.findByIsactive", query = "SELECT c FROM Countries c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "Countries.findByIsdeleted", query = "SELECT c FROM Countries c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "Countries.findByIso2", query = "SELECT c FROM Countries c WHERE c.iso2 = :iso2")
    , @NamedQuery(name = "Countries.findByIso3", query = "SELECT c FROM Countries c WHERE c.iso3 = :iso3")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COUNTRY_ID", nullable = false, precision = 0, scale = -127)
    private Long countryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "C_NAME", nullable = false, length = 20)
    private String cName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIVE", nullable = false)
    private BigInteger isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDELETED", nullable = false)
    private BigInteger isdeleted;
    @Size(max = 20)
    @Column(name = "ISO2", length = 20)
    private String iso2;
    @Size(max = 20)
    @Column(name = "ISO3", length = 20)
    private String iso3;

    public Countries() {
    }

    public Countries(Long countryId) {
        this.countryId = countryId;
    }

    public Countries(Long countryId, String cName, BigInteger isactive, BigInteger isdeleted) {
        this.countryId = countryId;
        this.cName = cName;
        this.isactive = isactive;
        this.isdeleted = isdeleted;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
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

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.Countries[ countryId=" + countryId + " ]";
    }
    
}
