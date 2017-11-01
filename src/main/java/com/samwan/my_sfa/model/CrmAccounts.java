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
@Table(name = "CRM_ACCOUNTS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmAccounts.findAll", query = "SELECT c FROM CrmAccounts c")
    , @NamedQuery(name = "CrmAccounts.findByAccountId", query = "SELECT c FROM CrmAccounts c WHERE c.accountId = :accountId")
    , @NamedQuery(name = "CrmAccounts.findByCountryIdFk", query = "SELECT c FROM CrmAccounts c WHERE c.countryIdFk = :countryIdFk")
    , @NamedQuery(name = "CrmAccounts.findByCountyIdFk", query = "SELECT c FROM CrmAccounts c WHERE c.countyIdFk = :countyIdFk")
    , @NamedQuery(name = "CrmAccounts.findByIndustryIdFk", query = "SELECT c FROM CrmAccounts c WHERE c.industryIdFk = :industryIdFk")
    , @NamedQuery(name = "CrmAccounts.findByAName", query = "SELECT c FROM CrmAccounts c WHERE c.aName = :aName")
    , @NamedQuery(name = "CrmAccounts.findByADescription", query = "SELECT c FROM CrmAccounts c WHERE c.aDescription = :aDescription")
    , @NamedQuery(name = "CrmAccounts.findByAEmail", query = "SELECT c FROM CrmAccounts c WHERE c.aEmail = :aEmail")
    , @NamedQuery(name = "CrmAccounts.findByAPhone", query = "SELECT c FROM CrmAccounts c WHERE c.aPhone = :aPhone")
    , @NamedQuery(name = "CrmAccounts.findByAWebsite", query = "SELECT c FROM CrmAccounts c WHERE c.aWebsite = :aWebsite")
    , @NamedQuery(name = "CrmAccounts.findByAPaddress", query = "SELECT c FROM CrmAccounts c WHERE c.aPaddress = :aPaddress")
    , @NamedQuery(name = "CrmAccounts.findByAAddress", query = "SELECT c FROM CrmAccounts c WHERE c.aAddress = :aAddress")
    , @NamedQuery(name = "CrmAccounts.findByAddedby", query = "SELECT c FROM CrmAccounts c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmAccounts.findByDateadded", query = "SELECT c FROM CrmAccounts c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmAccounts.findByIsactive", query = "SELECT c FROM CrmAccounts c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmAccounts.findByIsdeleted", query = "SELECT c FROM CrmAccounts c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "CrmAccounts.findByAccountTypeIdFk", query = "SELECT c FROM CrmAccounts c WHERE c.accountTypeIdFk = :accountTypeIdFk")
    , @NamedQuery(name = "CrmAccounts.findByAssignedto", query = "SELECT c FROM CrmAccounts c WHERE c.assignedto = :assignedto")
    , @NamedQuery(name = "CrmAccounts.findByRegionId", query = "SELECT c FROM CrmAccounts c WHERE c.regionId = :regionId")})
public class CrmAccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_ID", nullable = false, precision = 0, scale = -127)
    private Long accountId;
    @Column(name = "COUNTRY_ID_FK")
    private BigInteger countryIdFk;
    @Column(name = "COUNTY_ID_FK")
    private BigInteger countyIdFk;
    @Column(name = "INDUSTRY_ID_FK")
    private BigInteger industryIdFk;
    @Size(max = 300)
    @Column(name = "A_NAME", length = 300)
    private String aName;
    @Size(max = 355)
    @Column(name = "A_DESCRIPTION", length = 355)
    private String aDescription;
    @Size(max = 200)
    @Column(name = "A_EMAIL", length = 200)
    private String aEmail;
    @Size(max = 200)
    @Column(name = "A_PHONE", length = 200)
    private String aPhone;
    @Size(max = 100)
    @Column(name = "A_WEBSITE", length = 100)
    private String aWebsite;
    @Size(max = 255)
    @Column(name = "A_PADDRESS", length = 255)
    private String aPaddress;
    @Size(max = 255)
    @Column(name = "A_ADDRESS", length = 255)
    private String aAddress;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Column(name = "ACCOUNT_TYPE_ID_FK")
    private BigInteger accountTypeIdFk;
    @Column(name = "ASSIGNEDTO")
    private BigInteger assignedto;
    @Column(name = "REGION_ID")
    private BigInteger regionId;

    public CrmAccounts() {
    }

    public CrmAccounts(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigInteger getCountryIdFk() {
        return countryIdFk;
    }

    public void setCountryIdFk(BigInteger countryIdFk) {
        this.countryIdFk = countryIdFk;
    }

    public BigInteger getCountyIdFk() {
        return countyIdFk;
    }

    public void setCountyIdFk(BigInteger countyIdFk) {
        this.countyIdFk = countyIdFk;
    }

    public BigInteger getIndustryIdFk() {
        return industryIdFk;
    }

    public void setIndustryIdFk(BigInteger industryIdFk) {
        this.industryIdFk = industryIdFk;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public String getADescription() {
        return aDescription;
    }

    public void setADescription(String aDescription) {
        this.aDescription = aDescription;
    }

    public String getAEmail() {
        return aEmail;
    }

    public void setAEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getAPhone() {
        return aPhone;
    }

    public void setAPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getAWebsite() {
        return aWebsite;
    }

    public void setAWebsite(String aWebsite) {
        this.aWebsite = aWebsite;
    }

    public String getAPaddress() {
        return aPaddress;
    }

    public void setAPaddress(String aPaddress) {
        this.aPaddress = aPaddress;
    }

    public String getAAddress() {
        return aAddress;
    }

    public void setAAddress(String aAddress) {
        this.aAddress = aAddress;
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

    public BigInteger getAccountTypeIdFk() {
        return accountTypeIdFk;
    }

    public void setAccountTypeIdFk(BigInteger accountTypeIdFk) {
        this.accountTypeIdFk = accountTypeIdFk;
    }

    public BigInteger getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(BigInteger assignedto) {
        this.assignedto = assignedto;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmAccounts)) {
            return false;
        }
        CrmAccounts other = (CrmAccounts) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmAccounts[ accountId=" + accountId + " ]";
    }
    
}
