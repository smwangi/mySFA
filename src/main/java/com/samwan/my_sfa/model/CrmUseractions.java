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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smwangi
 */
@Entity
@Table(name = "CRM_USERACTIONS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmUseractions.findAll", query = "SELECT c FROM CrmUseractions c")
    , @NamedQuery(name = "CrmUseractions.findByActionId", query = "SELECT c FROM CrmUseractions c WHERE c.actionId = :actionId")
    , @NamedQuery(name = "CrmUseractions.findByGroupIdFk", query = "SELECT c FROM CrmUseractions c WHERE c.groupIdFk = :groupIdFk")
    , @NamedQuery(name = "CrmUseractions.findByMenuIdFk", query = "SELECT c FROM CrmUseractions c WHERE c.menuIdFk = :menuIdFk")
    , @NamedQuery(name = "CrmUseractions.findByCrecord", query = "SELECT c FROM CrmUseractions c WHERE c.crecord = :crecord")
    , @NamedQuery(name = "CrmUseractions.findByUrecord", query = "SELECT c FROM CrmUseractions c WHERE c.urecord = :urecord")
    , @NamedQuery(name = "CrmUseractions.findByDrecord", query = "SELECT c FROM CrmUseractions c WHERE c.drecord = :drecord")
    , @NamedQuery(name = "CrmUseractions.findByVrecord", query = "SELECT c FROM CrmUseractions c WHERE c.vrecord = :vrecord")})
public class CrmUseractions implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTION_ID", nullable = false, precision = 0, scale = -127)
    private Long actionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUP_ID_FK", nullable = false)
    private BigInteger groupIdFk;
    @Column(name = "MENU_ID_FK")
    private BigInteger menuIdFk;
    @Column(name = "CRECORD")
    private BigInteger crecord;
    @Column(name = "URECORD")
    private BigInteger urecord;
    @Column(name = "DRECORD")
    private BigInteger drecord;
    @Column(name = "VRECORD")
    private BigInteger vrecord;

    public CrmUseractions() {
    }

    public CrmUseractions(Long actionId) {
        this.actionId = actionId;
    }

    public CrmUseractions(Long actionId, BigInteger groupIdFk) {
        this.actionId = actionId;
        this.groupIdFk = groupIdFk;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public BigInteger getGroupIdFk() {
        return groupIdFk;
    }

    public void setGroupIdFk(BigInteger groupIdFk) {
        this.groupIdFk = groupIdFk;
    }

    public BigInteger getMenuIdFk() {
        return menuIdFk;
    }

    public void setMenuIdFk(BigInteger menuIdFk) {
        this.menuIdFk = menuIdFk;
    }

    public BigInteger getCrecord() {
        return crecord;
    }

    public void setCrecord(BigInteger crecord) {
        this.crecord = crecord;
    }

    public BigInteger getUrecord() {
        return urecord;
    }

    public void setUrecord(BigInteger urecord) {
        this.urecord = urecord;
    }

    public BigInteger getDrecord() {
        return drecord;
    }

    public void setDrecord(BigInteger drecord) {
        this.drecord = drecord;
    }

    public BigInteger getVrecord() {
        return vrecord;
    }

    public void setVrecord(BigInteger vrecord) {
        this.vrecord = vrecord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actionId != null ? actionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmUseractions)) {
            return false;
        }
        CrmUseractions other = (CrmUseractions) object;
        if ((this.actionId == null && other.actionId != null) || (this.actionId != null && !this.actionId.equals(other.actionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmUseractions[ actionId=" + actionId + " ]";
    }
    
}
