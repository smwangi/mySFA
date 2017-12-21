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
@Table(name = "SYSTEM_MENUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemMenus.findAll", query = "SELECT c FROM SystemMenus c")
    , @NamedQuery(name = "SystemMenus.findByMenuId", query = "SELECT c FROM SystemMenus c WHERE c.menuId = :menuId")
    , @NamedQuery(name = "SystemMenus.findByModuleIdFk", query = "SELECT c FROM SystemMenus c WHERE c.moduleIdFk = :moduleIdFk")
    , @NamedQuery(name = "SystemMenus.findByMName", query = "SELECT c FROM SystemMenus c WHERE c.mName = :mName")
    , @NamedQuery(name = "SystemMenus.findByMUrl", query = "SELECT c FROM SystemMenus c WHERE c.mUrl = :mUrl")
    , @NamedQuery(name = "SystemMenus.findByMGroupAccess", query = "SELECT c FROM SystemMenus c WHERE c.mGroupAccess = :mGroupAccess")
    , @NamedQuery(name = "SystemMenus.findByIsactive", query = "SELECT c FROM SystemMenus c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "SystemMenus.findByIsdeleted", query = "SELECT c FROM SystemMenus c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "SystemMenus.findByMActive", query = "SELECT c FROM SystemMenus c WHERE c.mActive = :mActive")})
public class SystemMenus implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENU_ID", nullable = false, precision = 0, scale = -127)
    private Long menuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODULE_ID_FK", nullable = false)
    private BigInteger moduleIdFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "M_NAME", nullable = false, length = 255)
    private String mName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "M_URL", nullable = false, length = 100)
    private String mUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "M_GROUP_ACCESS", nullable = false, length = 45)
    private String mGroupAccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIVE", nullable = false)
    private BigInteger isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDELETED", nullable = false)
    private BigInteger isdeleted;
    @Size(max = 255)
    @Column(name = "M_ACTIVE", length = 255)
    private String mActive;

    public SystemMenus() {
    }

    public SystemMenus(Long menuId) {
        this.menuId = menuId;
    }

    public SystemMenus(Long menuId, BigInteger moduleIdFk, String mName, String mUrl, String mGroupAccess, BigInteger isactive, BigInteger isdeleted) {
        this.menuId = menuId;
        this.moduleIdFk = moduleIdFk;
        this.mName = mName;
        this.mUrl = mUrl;
        this.mGroupAccess = mGroupAccess;
        this.isactive = isactive;
        this.isdeleted = isdeleted;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public BigInteger getModuleIdFk() {
        return moduleIdFk;
    }

    public void setModuleIdFk(BigInteger moduleIdFk) {
        this.moduleIdFk = moduleIdFk;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMUrl() {
        return mUrl;
    }

    public void setMUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getMGroupAccess() {
        return mGroupAccess;
    }

    public void setMGroupAccess(String mGroupAccess) {
        this.mGroupAccess = mGroupAccess;
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

    public String getMActive() {
        return mActive;
    }

    public void setMActive(String mActive) {
        this.mActive = mActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemMenus)) {
            return false;
        }
        SystemMenus other = (SystemMenus) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.SystemMenus[ menuId=" + menuId + " ]";
    }
    
}
