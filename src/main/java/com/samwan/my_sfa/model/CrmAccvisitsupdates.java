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
@Entity
@Table(name = "CRM_ACCVISITSUPDATES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmAccvisitsupdates.findAll", query = "SELECT c FROM CrmAccvisitsupdates c")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByUpdateId", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.updateId = :updateId")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByVisitId", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.visitId = :visitId")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByAddedby", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByDateadded", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByIsactive", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByIsdeleted", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByActivityTypeId", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.activityTypeId = :activityTypeId")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByAccountId", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.accountId = :accountId")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByNextactionDate", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.nextactionDate = :nextactionDate")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByVisitmodeIdFk", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.visitmodeIdFk = :visitmodeIdFk")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByIspostphoned", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.ispostphoned = :ispostphoned")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByPostphonedDate", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.postphonedDate = :postphonedDate")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByParentId", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.parentId = :parentId")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByActivityStatus", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.activityStatus = :activityStatus")
    , @NamedQuery(name = "CrmAccvisitsupdates.findBySubject", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.subject = :subject")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByActivityDate", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.activityDate = :activityDate")
    , @NamedQuery(name = "CrmAccvisitsupdates.findByPresent", query = "SELECT c FROM CrmAccvisitsupdates c WHERE c.present = :present")})
public class CrmAccvisitsupdates implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPDATE_ID", nullable = false, precision = 0, scale = -127)
    private Long updateId;
    @Column(name = "VISIT_ID")
    private BigInteger visitId;
    @Lob
    @Column(name = "UPDATES")
    private String updates;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Column(name = "ACTIVITY_TYPE_ID")
    private BigInteger activityTypeId;
    @Column(name = "ACCOUNT_ID")
    private BigInteger accountId;
    @Lob
    @Column(name = "NEXTACTION")
    private String nextaction;
    @Column(name = "NEXTACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextactionDate;
    @Column(name = "VISITMODE_ID_FK")
    private BigInteger visitmodeIdFk;
    @Column(name = "ISPOSTPHONED")
    private BigInteger ispostphoned;
    @Column(name = "POSTPHONED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postphonedDate;
    @Lob
    @Column(name = "POSTPHONE_COMMENTS")
    private String postphoneComments;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "ACTIVITY_STATUS")
    private BigInteger activityStatus;
    @Size(max = 4000)
    @Column(name = "SUBJECT", length = 4000)
    private String subject;
    @Column(name = "ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityDate;
    @Size(max = 4000)
    @Column(name = "PRESENT", length = 4000)
    private String present;

    public CrmAccvisitsupdates() {
    }

    public CrmAccvisitsupdates(Long updateId) {
        this.updateId = updateId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public BigInteger getVisitId() {
        return visitId;
    }

    public void setVisitId(BigInteger visitId) {
        this.visitId = visitId;
    }

    public String getUpdates() {
        return updates;
    }

    public void setUpdates(String updates) {
        this.updates = updates;
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

    public BigInteger getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(BigInteger activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public String getNextaction() {
        return nextaction;
    }

    public void setNextaction(String nextaction) {
        this.nextaction = nextaction;
    }

    public Date getNextactionDate() {
        return nextactionDate;
    }

    public void setNextactionDate(Date nextactionDate) {
        this.nextactionDate = nextactionDate;
    }

    public BigInteger getVisitmodeIdFk() {
        return visitmodeIdFk;
    }

    public void setVisitmodeIdFk(BigInteger visitmodeIdFk) {
        this.visitmodeIdFk = visitmodeIdFk;
    }

    public BigInteger getIspostphoned() {
        return ispostphoned;
    }

    public void setIspostphoned(BigInteger ispostphoned) {
        this.ispostphoned = ispostphoned;
    }

    public Date getPostphonedDate() {
        return postphonedDate;
    }

    public void setPostphonedDate(Date postphonedDate) {
        this.postphonedDate = postphonedDate;
    }

    public String getPostphoneComments() {
        return postphoneComments;
    }

    public void setPostphoneComments(String postphoneComments) {
        this.postphoneComments = postphoneComments;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public BigInteger getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(BigInteger activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
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
        hash += (updateId != null ? updateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmAccvisitsupdates)) {
            return false;
        }
        CrmAccvisitsupdates other = (CrmAccvisitsupdates) object;
        if ((this.updateId == null && other.updateId != null) || (this.updateId != null && !this.updateId.equals(other.updateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmAccvisitsupdates[ updateId=" + updateId + " ]";
    }
    
}
