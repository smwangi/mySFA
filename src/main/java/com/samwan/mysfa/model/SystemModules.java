/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

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
@Table(name = "SYSTEM_MODULES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemModules.findAll", query = "SELECT c FROM SystemModules c")
    , @NamedQuery(name = "SystemModules.findByModuleId", query = "SELECT c FROM SystemModules c WHERE c.moduleId = :moduleId")
    , @NamedQuery(name = "SystemModules.findByDisplayId", query = "SELECT c FROM SystemModules c WHERE c.displayId = :displayId")
    , @NamedQuery(name = "SystemModules.findByMName", query = "SELECT c FROM SystemModules c WHERE c.mName = :mName")
    , @NamedQuery(name = "SystemModules.findByMActive", query = "SELECT c FROM SystemModules c WHERE c.mActive = :mActive")
    , @NamedQuery(name = "SystemModules.findByMDirectory", query = "SELECT c FROM SystemModules c WHERE c.mDirectory = :mDirectory")
    , @NamedQuery(name = "SystemModules.findByMGroupAccess", query = "SELECT c FROM SystemModules c WHERE c.mGroupAccess = :mGroupAccess")
    , @NamedQuery(name = "SystemModules.findByMIcon", query = "SELECT c FROM SystemModules c WHERE c.mIcon = :mIcon")
    , @NamedQuery(name = "SystemModules.findByIsactive", query = "SELECT c FROM SystemModules c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "SystemModules.findByIsdeleted", query = "SELECT c FROM SystemModules c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "SystemModules.findByCountryIdFk", query = "SELECT c FROM SystemModules c WHERE c.countryIdFk = :countryIdFk")})
public class SystemModules implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODULE_ID", nullable = false, precision = 38, scale = 0)
    private Long moduleId;
    @Column(name = "DISPLAY_ID")
    private BigInteger displayId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "M_NAME", nullable = false, length = 45)
    private String mName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "M_ACTIVE", nullable = false, length = 20)
    private String mActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "M_DIRECTORY", nullable = false, length = 20)
    private String mDirectory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "M_GROUP_ACCESS", nullable = false, length = 45)
    private String mGroupAccess;
    @Size(max = 20)
    @Column(name = "M_ICON", length = 20)
    private String mIcon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIVE", nullable = false)
    private BigInteger isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDELETED", nullable = false)
    private BigInteger isdeleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COUNTRY_ID_FK", nullable = false)
    private BigInteger countryIdFk;

    public SystemModules() {
    }

    public SystemModules(Long moduleId) {
        this.moduleId = moduleId;
    }

    public SystemModules(Long moduleId, String mName, String mActive, String mDirectory, String mGroupAccess, BigInteger isactive, BigInteger isdeleted, BigInteger countryIdFk) {
        this.moduleId = moduleId;
        this.mName = mName;
        this.mActive = mActive;
        this.mDirectory = mDirectory;
        this.mGroupAccess = mGroupAccess;
        this.isactive = isactive;
        this.isdeleted = isdeleted;
        this.countryIdFk = countryIdFk;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public BigInteger getDisplayId() {
        return displayId;
    }

    public void setDisplayId(BigInteger displayId) {
        this.displayId = displayId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMActive() {
        return mActive;
    }

    public void setMActive(String mActive) {
        this.mActive = mActive;
    }

    public String getMDirectory() {
        return mDirectory;
    }

    public void setMDirectory(String mDirectory) {
        this.mDirectory = mDirectory;
    }

    public String getMGroupAccess() {
        return mGroupAccess;
    }

    public void setMGroupAccess(String mGroupAccess) {
        this.mGroupAccess = mGroupAccess;
    }

    public String getMIcon() {
        return mIcon;
    }

    public void setMIcon(String mIcon) {
        this.mIcon = mIcon;
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

    public BigInteger getCountryIdFk() {
        return countryIdFk;
    }

    public void setCountryIdFk(BigInteger countryIdFk) {
        this.countryIdFk = countryIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleId != null ? moduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemModules)) {
            return false;
        }
        SystemModules other = (SystemModules) object;
        if ((this.moduleId == null && other.moduleId != null) || (this.moduleId != null && !this.moduleId.equals(other.moduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.SystemModules[ moduleId=" + moduleId + " ]";
    }
    
}
