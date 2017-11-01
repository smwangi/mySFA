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
@Table(name = "CRM_PRODUCTSCATEGORIES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmProductscategories.findAll", query = "SELECT c FROM CrmProductscategories c")
    , @NamedQuery(name = "CrmProductscategories.findByCategoryId", query = "SELECT c FROM CrmProductscategories c WHERE c.categoryId = :categoryId")
    , @NamedQuery(name = "CrmProductscategories.findByCategory", query = "SELECT c FROM CrmProductscategories c WHERE c.category = :category")
    , @NamedQuery(name = "CrmProductscategories.findByCatDescription", query = "SELECT c FROM CrmProductscategories c WHERE c.catDescription = :catDescription")
    , @NamedQuery(name = "CrmProductscategories.findByIsactive", query = "SELECT c FROM CrmProductscategories c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmProductscategories.findByIsdeleted", query = "SELECT c FROM CrmProductscategories c WHERE c.isdeleted = :isdeleted")})
public class CrmProductscategories implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORY_ID", nullable = false, precision = 0, scale = -127)
    private Long categoryId;
    @Size(max = 100)
    @Column(name = "CATEGORY", length = 100)
    private String category;
    @Size(max = 400)
    @Column(name = "CAT_DESCRIPTION", length = 400)
    private String catDescription;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmProductscategories() {
    }

    public CrmProductscategories(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
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
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmProductscategories)) {
            return false;
        }
        CrmProductscategories other = (CrmProductscategories) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmProductscategories[ categoryId=" + categoryId + " ]";
    }
    
}
