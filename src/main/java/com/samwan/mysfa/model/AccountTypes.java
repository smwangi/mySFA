/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

import java.io.Serializable;
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
@Table(name = "AccountTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountTypes.findAll", query = "SELECT c FROM AccountTypes c")
    , @NamedQuery(name = "AccountTypes.findByAccountTypeId", query = "SELECT c FROM AccountTypes c WHERE c.accountTypeId = :accountTypeId")
    , @NamedQuery(name = "AccountTypes.findByAType", query = "SELECT c FROM AccountTypes c WHERE c.aType = :aType")
    , @NamedQuery(name = "AccountTypes.findByIsactive", query = "SELECT c FROM AccountTypes c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "AccountTypes.findByIsdeleted", query = "SELECT c FROM AccountTypes c WHERE c.isdeleted = :isdeleted")})
public class AccountTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_TYPE_ID", nullable = false, precision = 0, scale = -127)
    private Long accountTypeId;
    @Size(max = 20)
    @Column(name = "A_TYPE", length = 20)
    private String aType;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public AccountTypes() {
    }

    public AccountTypes(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAType() {
        return aType;
    }

    public void setAType(String aType) {
        this.aType = aType;
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
        hash += (accountTypeId != null ? accountTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountTypes)) {
            return false;
        }
        AccountTypes other = (AccountTypes) object;
        if ((this.accountTypeId == null && other.accountTypeId != null) || (this.accountTypeId != null && !this.accountTypeId.equals(other.accountTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.AccountTypes[ accountTypeId=" + accountTypeId + " ]";
    }
    
}
