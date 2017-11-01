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
@Table(name = "CRM_COMPANYTARGETSQUARTERS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmCompanytargetsquarters.findAll", query = "SELECT c FROM CrmCompanytargetsquarters c")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByQuaterId", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.quaterId = :quaterId")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByTargetId", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.targetId = :targetId")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByQName", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.qName = :qName")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByQSdate", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.qSdate = :qSdate")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByQEdate", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.qEdate = :qEdate")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByAddedby", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByDateadded", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByIsactive", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByIsdeleted", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "CrmCompanytargetsquarters.findByTAmount", query = "SELECT c FROM CrmCompanytargetsquarters c WHERE c.tAmount = :tAmount")})
public class CrmCompanytargetsquarters implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUATER_ID", nullable = false, precision = 0, scale = -127)
    private Long quaterId;
    @Column(name = "TARGET_ID")
    private BigInteger targetId;
    @Size(max = 100)
    @Column(name = "Q_NAME", length = 100)
    private String qName;
    @Column(name = "Q_SDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date qSdate;
    @Column(name = "Q_EDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date qEdate;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Size(max = 20)
    @Column(name = "T_AMOUNT", length = 20)
    private String tAmount;

    public CrmCompanytargetsquarters() {
    }

    public CrmCompanytargetsquarters(Long quaterId) {
        this.quaterId = quaterId;
    }

    public Long getQuaterId() {
        return quaterId;
    }

    public void setQuaterId(Long quaterId) {
        this.quaterId = quaterId;
    }

    public BigInteger getTargetId() {
        return targetId;
    }

    public void setTargetId(BigInteger targetId) {
        this.targetId = targetId;
    }

    public String getQName() {
        return qName;
    }

    public void setQName(String qName) {
        this.qName = qName;
    }

    public Date getQSdate() {
        return qSdate;
    }

    public void setQSdate(Date qSdate) {
        this.qSdate = qSdate;
    }

    public Date getQEdate() {
        return qEdate;
    }

    public void setQEdate(Date qEdate) {
        this.qEdate = qEdate;
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

    public String getTAmount() {
        return tAmount;
    }

    public void setTAmount(String tAmount) {
        this.tAmount = tAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quaterId != null ? quaterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmCompanytargetsquarters)) {
            return false;
        }
        CrmCompanytargetsquarters other = (CrmCompanytargetsquarters) object;
        if ((this.quaterId == null && other.quaterId != null) || (this.quaterId != null && !this.quaterId.equals(other.quaterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmCompanytargetsquarters[ quaterId=" + quaterId + " ]";
    }
    
}
