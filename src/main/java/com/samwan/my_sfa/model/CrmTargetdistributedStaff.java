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
@Table(name = "CRM_TARGETDISTRIBUTED_STAFF")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmTargetdistributedStaff.findAll", query = "SELECT c FROM CrmTargetdistributedStaff c")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByDistributionId", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.distributionId = :distributionId")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByProductId", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.productId = :productId")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByStaffId", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.staffId = :staffId")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByTAmount", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.tAmount = :tAmount")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByAddedby", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByDateadded", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByIsactive", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmTargetdistributedStaff.findByIsdeleted", query = "SELECT c FROM CrmTargetdistributedStaff c WHERE c.isdeleted = :isdeleted")})
public class CrmTargetdistributedStaff implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISTRIBUTION_ID", nullable = false, precision = 0, scale = -127)
    private Long distributionId;
    @Column(name = "PRODUCT_ID")
    private BigInteger productId;
    @Column(name = "STAFF_ID")
    private BigInteger staffId;
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

    public CrmTargetdistributedStaff() {
    }

    public CrmTargetdistributedStaff(Long distributionId) {
        this.distributionId = distributionId;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public BigInteger getStaffId() {
        return staffId;
    }

    public void setStaffId(BigInteger staffId) {
        this.staffId = staffId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distributionId != null ? distributionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmTargetdistributedStaff)) {
            return false;
        }
        CrmTargetdistributedStaff other = (CrmTargetdistributedStaff) object;
        if ((this.distributionId == null && other.distributionId != null) || (this.distributionId != null && !this.distributionId.equals(other.distributionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmTargetdistributedStaff[ distributionId=" + distributionId + " ]";
    }
    
}
