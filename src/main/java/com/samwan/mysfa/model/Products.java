/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

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
@Table(name = "PRODUCTS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT c FROM Products c")
    , @NamedQuery(name = "Products.findByProductId", query = "SELECT c FROM Products c WHERE c.productId = :productId")
    , @NamedQuery(name = "Products.findByPName", query = "SELECT c FROM Products c WHERE c.pName = :pName")
    , @NamedQuery(name = "Products.findByPDetails", query = "SELECT c FROM Products c WHERE c.pDetails = :pDetails")
    , @NamedQuery(name = "Products.findByPLaunch", query = "SELECT c FROM Products c WHERE c.pLaunch = :pLaunch")
    , @NamedQuery(name = "Products.findByAddedby", query = "SELECT c FROM Products c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "Products.findByDateadded", query = "SELECT c FROM Products c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "Products.findByIsactive", query = "SELECT c FROM Products c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "Products.findByIsdeleted", query = "SELECT c FROM Products c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "Products.findByPManager", query = "SELECT c FROM Products c WHERE c.pManager = :pManager")
    , @NamedQuery(name = "Products.findByPOwner", query = "SELECT c FROM Products c WHERE c.pOwner = :pOwner")
    , @NamedQuery(name = "Products.findByPCategory", query = "SELECT c FROM Products c WHERE c.pCategory = :pCategory")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_ID", nullable = false, precision = 0, scale = -127)
    private Long productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "P_NAME", nullable = false, length = 450)
    private String pName;
    @Size(max = 2000)
    @Column(name = "P_DETAILS", length = 2000)
    private String pDetails;
    @Column(name = "P_LAUNCH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pLaunch;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Column(name = "P_MANAGER")
    private BigInteger pManager;
    @Column(name = "P_OWNER")
    private BigInteger pOwner;
    @Column(name = "P_CATEGORY")
    private BigInteger pCategory;

    public Products() {
    }

    public Products(Long productId) {
        this.productId = productId;
    }

    public Products(Long productId, String pName) {
        this.productId = productId;
        this.pName = pName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPDetails() {
        return pDetails;
    }

    public void setPDetails(String pDetails) {
        this.pDetails = pDetails;
    }

    public Date getPLaunch() {
        return pLaunch;
    }

    public void setPLaunch(Date pLaunch) {
        this.pLaunch = pLaunch;
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

    public BigInteger getPManager() {
        return pManager;
    }

    public void setPManager(BigInteger pManager) {
        this.pManager = pManager;
    }

    public BigInteger getPOwner() {
        return pOwner;
    }

    public void setPOwner(BigInteger pOwner) {
        this.pOwner = pOwner;
    }

    public BigInteger getPCategory() {
        return pCategory;
    }

    public void setPCategory(BigInteger pCategory) {
        this.pCategory = pCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.Products[ productId=" + productId + " ]";
    }
    
}
