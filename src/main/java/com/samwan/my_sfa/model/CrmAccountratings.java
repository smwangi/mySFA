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
@Table(name = "CRM_ACCOUNTRATINGS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmAccountratings.findAll", query = "SELECT c FROM CrmAccountratings c")
    , @NamedQuery(name = "CrmAccountratings.findByRatingId", query = "SELECT c FROM CrmAccountratings c WHERE c.ratingId = :ratingId")
    , @NamedQuery(name = "CrmAccountratings.findByRName", query = "SELECT c FROM CrmAccountratings c WHERE c.rName = :rName")
    , @NamedQuery(name = "CrmAccountratings.findByIsactive", query = "SELECT c FROM CrmAccountratings c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmAccountratings.findByIsdeleted", query = "SELECT c FROM CrmAccountratings c WHERE c.isdeleted = :isdeleted")})
public class CrmAccountratings implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATING_ID", nullable = false, precision = 0, scale = -127)
    private Long ratingId;
    @Size(max = 20)
    @Column(name = "R_NAME", length = 20)
    private String rName;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmAccountratings() {
    }

    public CrmAccountratings(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
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
        hash += (ratingId != null ? ratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmAccountratings)) {
            return false;
        }
        CrmAccountratings other = (CrmAccountratings) object;
        if ((this.ratingId == null && other.ratingId != null) || (this.ratingId != null && !this.ratingId.equals(other.ratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmAccountratings[ ratingId=" + ratingId + " ]";
    }
    
}
