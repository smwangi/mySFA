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
@Table(name = "CRM_COMPANYTARGETS_SECTOR")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmCompanytargetsSector.findAll", query = "SELECT c FROM CrmCompanytargetsSector c")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByTargetId", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.targetId = :targetId")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByCountryIdFk", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.countryIdFk = :countryIdFk")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByTYear", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.tYear = :tYear")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByTSector", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.tSector = :tSector")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByTAmount", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.tAmount = :tAmount")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByAddedby", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByDateadded", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByIsactive", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByIsdeleted", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "CrmCompanytargetsSector.findByTargetIdFk", query = "SELECT c FROM CrmCompanytargetsSector c WHERE c.targetIdFk = :targetIdFk")})
public class CrmCompanytargetsSector implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TARGET_ID", nullable = false, precision = 0, scale = -127)
    private Long targetId;
    @Column(name = "COUNTRY_ID_FK")
    private BigInteger countryIdFk;
    @Size(max = 20)
    @Column(name = "T_YEAR", length = 20)
    private String tYear;
    @Column(name = "T_SECTOR")
    private BigInteger tSector;
    @Size(max = 20)
    @Column(name = "T_AMOUNT", length = 20)
    private String tAmount;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Column(name = "TARGET_ID_FK")
    private BigInteger targetIdFk;

    public CrmCompanytargetsSector() {
    }

    public CrmCompanytargetsSector(Long targetId) {
        this.targetId = targetId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public BigInteger getCountryIdFk() {
        return countryIdFk;
    }

    public void setCountryIdFk(BigInteger countryIdFk) {
        this.countryIdFk = countryIdFk;
    }

    public String getTYear() {
        return tYear;
    }

    public void setTYear(String tYear) {
        this.tYear = tYear;
    }

    public BigInteger getTSector() {
        return tSector;
    }

    public void setTSector(BigInteger tSector) {
        this.tSector = tSector;
    }

    public String getTAmount() {
        return tAmount;
    }

    public void setTAmount(String tAmount) {
        this.tAmount = tAmount;
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

    public BigInteger getTargetIdFk() {
        return targetIdFk;
    }

    public void setTargetIdFk(BigInteger targetIdFk) {
        this.targetIdFk = targetIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (targetId != null ? targetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmCompanytargetsSector)) {
            return false;
        }
        CrmCompanytargetsSector other = (CrmCompanytargetsSector) object;
        if ((this.targetId == null && other.targetId != null) || (this.targetId != null && !this.targetId.equals(other.targetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmCompanytargetsSector[ targetId=" + targetId + " ]";
    }
    
}
