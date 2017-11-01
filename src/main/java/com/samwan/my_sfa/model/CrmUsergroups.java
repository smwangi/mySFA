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
@Table(name = "CRM_USERGROUPS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmUsergroups.findAll", query = "SELECT c FROM CrmUsergroups c")
    , @NamedQuery(name = "CrmUsergroups.findByGroupId", query = "SELECT c FROM CrmUsergroups c WHERE c.groupId = :groupId")
    , @NamedQuery(name = "CrmUsergroups.findByGName", query = "SELECT c FROM CrmUsergroups c WHERE c.gName = :gName")
    , @NamedQuery(name = "CrmUsergroups.findByIsactive", query = "SELECT c FROM CrmUsergroups c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmUsergroups.findByIsdeleted", query = "SELECT c FROM CrmUsergroups c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "CrmUsergroups.findByCountryIdFk", query = "SELECT c FROM CrmUsergroups c WHERE c.countryIdFk = :countryIdFk")})
public class CrmUsergroups implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUP_ID", nullable = false, precision = 0, scale = -127)
    private Long groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "G_NAME", nullable = false, length = 20)
    private String gName;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Column(name = "COUNTRY_ID_FK")
    private BigInteger countryIdFk;

    public CrmUsergroups() {
    }

    public CrmUsergroups(Long groupId) {
        this.groupId = groupId;
    }

    public CrmUsergroups(Long groupId, String gName) {
        this.groupId = groupId;
        this.gName = gName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
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
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmUsergroups)) {
            return false;
        }
        CrmUsergroups other = (CrmUsergroups) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmUsergroups[ groupId=" + groupId + " ]";
    }
    
}
