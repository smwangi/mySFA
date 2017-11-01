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
import javax.persistence.Lob;
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
@Table(name = "CRM_SALESTAGES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmSalestages.findAll", query = "SELECT c FROM CrmSalestages c")
    , @NamedQuery(name = "CrmSalestages.findByStageId", query = "SELECT c FROM CrmSalestages c WHERE c.stageId = :stageId")
    , @NamedQuery(name = "CrmSalestages.findByStage", query = "SELECT c FROM CrmSalestages c WHERE c.stage = :stage")
    , @NamedQuery(name = "CrmSalestages.findByIsactive", query = "SELECT c FROM CrmSalestages c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmSalestages.findByIsdeleted", query = "SELECT c FROM CrmSalestages c WHERE c.isdeleted = :isdeleted")})
public class CrmSalestages implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STAGE_ID", nullable = false, precision = 0, scale = -127)
    private Long stageId;
    @Size(max = 45)
    @Column(name = "STAGE", length = 45)
    private String stage;
    @Lob
    @Column(name = "S_DESCRIPTION")
    private String sDescription;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmSalestages() {
    }

    public CrmSalestages(Long stageId) {
        this.stageId = stageId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getSDescription() {
        return sDescription;
    }

    public void setSDescription(String sDescription) {
        this.sDescription = sDescription;
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
        hash += (stageId != null ? stageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmSalestages)) {
            return false;
        }
        CrmSalestages other = (CrmSalestages) object;
        if ((this.stageId == null && other.stageId != null) || (this.stageId != null && !this.stageId.equals(other.stageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmSalestages[ stageId=" + stageId + " ]";
    }
    
}
