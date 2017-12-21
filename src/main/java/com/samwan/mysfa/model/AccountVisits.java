/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Entity(name = "AccountVisits")
@Table(name = "AccountVisits")
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "AccountVisits.findAll", query = "SELECT c FROM AccountVisits c")
//    , @NamedQuery(name = "AccountVisits.findByVisitId", query = "SELECT c FROM AccountVisits c WHERE c.visitId = :visitId")
//    , @NamedQuery(name = "AccountVisits.findByAccountIdFk", query = "SELECT c FROM AccountVisits c WHERE c.accountIdFk = :accountIdFk")
//    , @NamedQuery(name = "AccountVisits.findByVisitreason", query = "SELECT c FROM AccountVisits c WHERE c.visitreason = :visitreason")
//    , @NamedQuery(name = "AccountVisits.findByStartdate", query = "SELECT c FROM AccountVisits c WHERE c.startdate = :startdate")
//    , @NamedQuery(name = "AccountVisits.findByVisitlead", query = "SELECT c FROM AccountVisits c WHERE c.visitlead = :visitlead")
//    , @NamedQuery(name = "AccountVisits.findByVisitothers", query = "SELECT c FROM AccountVisits c WHERE c.visitothers = :visitothers")
//    , @NamedQuery(name = "AccountVisits.findByAddedby", query = "SELECT c FROM AccountVisits c WHERE c.addedby = :addedby")
//    , @NamedQuery(name = "AccountVisits.findByDateadded", query = "SELECT c FROM AccountVisits c WHERE c.dateadded = :dateadded")
//    , @NamedQuery(name = "AccountVisits.findByIsactive", query = "SELECT c FROM AccountVisits c WHERE c.isactive = :isactive")
//    , @NamedQuery(name = "AccountVisits.findByIsdeleted", query = "SELECT c FROM AccountVisits c WHERE c.isdeleted = :isdeleted")
//    , @NamedQuery(name = "AccountVisits.findByVisitdescription", query = "SELECT c FROM AccountVisits c WHERE c.visitdescription = :visitdescription")
//    , @NamedQuery(name = "AccountVisits.findByEnddate", query = "SELECT c FROM AccountVisits c WHERE c.enddate = :enddate")
//    , @NamedQuery(name = "AccountVisits.findByVColor", query = "SELECT c FROM AccountVisits c WHERE c.vColor = :vColor")
//    , @NamedQuery(name = "AccountVisits.findByIspostphoned", query = "SELECT c FROM AccountVisits c WHERE c.ispostphoned = :ispostphoned")
//    , @NamedQuery(name = "AccountVisits.findByActivityStatus", query = "SELECT c FROM AccountVisits c WHERE c.activityStatus = :activityStatus")
})
public class AccountVisits implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISIT_ID", nullable = false, precision = 0, scale = -127)
    private Long visitId;
    @Column(name = "ACCOUNT_ID_FK")
    private BigInteger accountIdFk;
    @Size(max = 255)
    @Column(name = "VISITREASON", length = 255)
    private String visitreason;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "VISITLEAD")
    private BigInteger visitlead;
    @Size(max = 20)
    @Column(name = "VISITOTHERS", length = 20)
    private String visitothers;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Size(max = 255)
    @Column(name = "VISITDESCRIPTION", length = 255)
    private String visitdescription;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Size(max = 20)
    @Column(name = "V_COLOR", length = 20)
    private String vColor;
    @Column(name = "ISPOSTPHONED")
    private BigInteger ispostphoned;
    @Column(name = "ACTIVITY_STATUS")
    private BigInteger activityStatus;
    @Lob
    @Column(name = "UPDATES")
    private String updates;
    @Lob
    @Column(name = "PRESENT")
    private String present;

    public AccountVisits() {
    }

    public AccountVisits(Long visitId) {
        this.visitId = visitId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public BigInteger getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(BigInteger accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    public String getVisitreason() {
        return visitreason;
    }

    public void setVisitreason(String visitreason) {
        this.visitreason = visitreason;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public BigInteger getVisitlead() {
        return visitlead;
    }

    public void setVisitlead(BigInteger visitlead) {
        this.visitlead = visitlead;
    }

    public String getVisitothers() {
        return visitothers;
    }

    public void setVisitothers(String visitothers) {
        this.visitothers = visitothers;
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

    public String getVisitdescription() {
        return visitdescription;
    }

    public void setVisitdescription(String visitdescription) {
        this.visitdescription = visitdescription;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getVColor() {
        return vColor;
    }

    public void setVColor(String vColor) {
        this.vColor = vColor;
    }

    public BigInteger getIspostphoned() {
        return ispostphoned;
    }

    public void setIspostphoned(BigInteger ispostphoned) {
        this.ispostphoned = ispostphoned;
    }

    public BigInteger getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(BigInteger activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getUpdates() {
        return updates;
    }

    public void setUpdates(String updates) {
        this.updates = updates;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitId != null ? visitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountVisits)) {
            return false;
        }
        AccountVisits other = (AccountVisits) object;
        if ((this.visitId == null && other.visitId != null) || (this.visitId != null && !this.visitId.equals(other.visitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.AccountVisits[ visitId=" + visitId + " ]";
    }
    
}
