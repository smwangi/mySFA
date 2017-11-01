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
@Table(name = "CRM_OPPORTUNITYSOURCES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmOpportunitysources.findAll", query = "SELECT c FROM CrmOpportunitysources c")
    , @NamedQuery(name = "CrmOpportunitysources.findBySourceId", query = "SELECT c FROM CrmOpportunitysources c WHERE c.sourceId = :sourceId")
    , @NamedQuery(name = "CrmOpportunitysources.findBySName", query = "SELECT c FROM CrmOpportunitysources c WHERE c.sName = :sName")
    , @NamedQuery(name = "CrmOpportunitysources.findByIsactive", query = "SELECT c FROM CrmOpportunitysources c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmOpportunitysources.findByIsdeleted", query = "SELECT c FROM CrmOpportunitysources c WHERE c.isdeleted = :isdeleted")})
public class CrmOpportunitysources implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOURCE_ID", nullable = false, precision = 0, scale = -127)
    private Long sourceId;
    @Size(max = 20)
    @Column(name = "S_NAME", length = 20)
    private String sName;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmOpportunitysources() {
    }

    public CrmOpportunitysources(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
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
        hash += (sourceId != null ? sourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmOpportunitysources)) {
            return false;
        }
        CrmOpportunitysources other = (CrmOpportunitysources) object;
        if ((this.sourceId == null && other.sourceId != null) || (this.sourceId != null && !this.sourceId.equals(other.sourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmOpportunitysources[ sourceId=" + sourceId + " ]";
    }
    
}
