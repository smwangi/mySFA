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
@Table(name = "CRM_ACCOUNTCATEGORIES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmAccountcategories.findAll", query = "SELECT c FROM CrmAccountcategories c")
    , @NamedQuery(name = "CrmAccountcategories.findByCategoryId", query = "SELECT c FROM CrmAccountcategories c WHERE c.categoryId = :categoryId")
    , @NamedQuery(name = "CrmAccountcategories.findByCName", query = "SELECT c FROM CrmAccountcategories c WHERE c.cName = :cName")
    , @NamedQuery(name = "CrmAccountcategories.findByCDescription", query = "SELECT c FROM CrmAccountcategories c WHERE c.cDescription = :cDescription")
    , @NamedQuery(name = "CrmAccountcategories.findByIsactive", query = "SELECT c FROM CrmAccountcategories c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmAccountcategories.findByIsdeleted", query = "SELECT c FROM CrmAccountcategories c WHERE c.isdeleted = :isdeleted")})
public class CrmAccountcategories implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORY_ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal categoryId;
    @Size(max = 20)
    @Column(name = "C_NAME", length = 20)
    private String cName;
    @Size(max = 300)
    @Column(name = "C_DESCRIPTION", length = 300)
    private String cDescription;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmAccountcategories() {
    }

    public CrmAccountcategories(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription(String cDescription) {
        this.cDescription = cDescription;
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
        if (!(object instanceof CrmAccountcategories)) {
            return false;
        }
        CrmAccountcategories other = (CrmAccountcategories) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmAccountcategories[ categoryId=" + categoryId + " ]";
    }
    
}
