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
@Table(name = "CRM_SALES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmSales.findAll", query = "SELECT c FROM CrmSales c")
    , @NamedQuery(name = "CrmSales.findBySaleId", query = "SELECT c FROM CrmSales c WHERE c.saleId = :saleId")
    , @NamedQuery(name = "CrmSales.findByAccountId", query = "SELECT c FROM CrmSales c WHERE c.accountId = :accountId")
    , @NamedQuery(name = "CrmSales.findByProductId", query = "SELECT c FROM CrmSales c WHERE c.productId = :productId")
    , @NamedQuery(name = "CrmSales.findBySAmount", query = "SELECT c FROM CrmSales c WHERE c.sAmount = :sAmount")
    , @NamedQuery(name = "CrmSales.findBySDate", query = "SELECT c FROM CrmSales c WHERE c.sDate = :sDate")
    , @NamedQuery(name = "CrmSales.findBySaleby", query = "SELECT c FROM CrmSales c WHERE c.saleby = :saleby")
    , @NamedQuery(name = "CrmSales.findByAddedby", query = "SELECT c FROM CrmSales c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmSales.findByDateadded", query = "SELECT c FROM CrmSales c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmSales.findByIsactive", query = "SELECT c FROM CrmSales c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmSales.findByIsdeleted", query = "SELECT c FROM CrmSales c WHERE c.isdeleted = :isdeleted")})
public class CrmSales implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALE_ID", nullable = false, precision = 0, scale = -127)
    private Long saleId;
    @Column(name = "ACCOUNT_ID")
    private BigInteger accountId;
    @Column(name = "PRODUCT_ID")
    private BigInteger productId;
    @Size(max = 20)
    @Column(name = "S_AMOUNT", length = 20)
    private String sAmount;
    @Column(name = "S_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sDate;
    @Column(name = "SALEBY")
    private BigInteger saleby;
    @Lob
    @Column(name = "S_DETAILS")
    private String sDetails;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmSales() {
    }

    public CrmSales(Long saleId) {
        this.saleId = saleId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public String getSAmount() {
        return sAmount;
    }

    public void setSAmount(String sAmount) {
        this.sAmount = sAmount;
    }

    public Date getSDate() {
        return sDate;
    }

    public void setSDate(Date sDate) {
        this.sDate = sDate;
    }

    public BigInteger getSaleby() {
        return saleby;
    }

    public void setSaleby(BigInteger saleby) {
        this.saleby = saleby;
    }

    public String getSDetails() {
        return sDetails;
    }

    public void setSDetails(String sDetails) {
        this.sDetails = sDetails;
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
        hash += (saleId != null ? saleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmSales)) {
            return false;
        }
        CrmSales other = (CrmSales) object;
        if ((this.saleId == null && other.saleId != null) || (this.saleId != null && !this.saleId.equals(other.saleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmSales[ saleId=" + saleId + " ]";
    }
    
}
