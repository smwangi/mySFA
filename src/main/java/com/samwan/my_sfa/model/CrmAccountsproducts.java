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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smwangi
 */
@Entity
@Table(name = "CRM_ACCOUNTSPRODUCTS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmAccountsproducts.findAll", query = "SELECT c FROM CrmAccountsproducts c")
    , @NamedQuery(name = "CrmAccountsproducts.findByAcproductId", query = "SELECT c FROM CrmAccountsproducts c WHERE c.acproductId = :acproductId")
    , @NamedQuery(name = "CrmAccountsproducts.findByAccountIdFk", query = "SELECT c FROM CrmAccountsproducts c WHERE c.accountIdFk = :accountIdFk")
    , @NamedQuery(name = "CrmAccountsproducts.findByProductId", query = "SELECT c FROM CrmAccountsproducts c WHERE c.productId = :productId")
    , @NamedQuery(name = "CrmAccountsproducts.findByAquireddate", query = "SELECT c FROM CrmAccountsproducts c WHERE c.aquireddate = :aquireddate")
    , @NamedQuery(name = "CrmAccountsproducts.findByAquiredby", query = "SELECT c FROM CrmAccountsproducts c WHERE c.aquiredby = :aquiredby")
    , @NamedQuery(name = "CrmAccountsproducts.findByAddedby", query = "SELECT c FROM CrmAccountsproducts c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmAccountsproducts.findByDateadded", query = "SELECT c FROM CrmAccountsproducts c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmAccountsproducts.findByIsactive", query = "SELECT c FROM CrmAccountsproducts c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmAccountsproducts.findByIsdeleted", query = "SELECT c FROM CrmAccountsproducts c WHERE c.isdeleted = :isdeleted")})
public class CrmAccountsproducts implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACPRODUCT_ID", nullable = false, precision = 0, scale = -127)
    private Long acproductId;
    @Column(name = "ACCOUNT_ID_FK")
    private BigInteger accountIdFk;
    @Column(name = "PRODUCT_ID")
    private BigInteger productId;
    @Column(name = "AQUIREDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aquireddate;
    @Column(name = "AQUIREDBY")
    private BigInteger aquiredby;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmAccountsproducts() {
    }

    public CrmAccountsproducts(Long acproductId) {
        this.acproductId = acproductId;
    }

    public Long getAcproductId() {
        return acproductId;
    }

    public void setAcproductId(Long acproductId) {
        this.acproductId = acproductId;
    }

    public BigInteger getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(BigInteger accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public Date getAquireddate() {
        return aquireddate;
    }

    public void setAquireddate(Date aquireddate) {
        this.aquireddate = aquireddate;
    }

    public BigInteger getAquiredby() {
        return aquiredby;
    }

    public void setAquiredby(BigInteger aquiredby) {
        this.aquiredby = aquiredby;
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
        hash += (acproductId != null ? acproductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmAccountsproducts)) {
            return false;
        }
        CrmAccountsproducts other = (CrmAccountsproducts) object;
        if ((this.acproductId == null && other.acproductId != null) || (this.acproductId != null && !this.acproductId.equals(other.acproductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmAccountsproducts[ acproductId=" + acproductId + " ]";
    }
    
}
