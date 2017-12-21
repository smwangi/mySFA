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
@Table(name = "OpportunityTypes")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpportunityTypes.findAll", query = "SELECT c FROM OpportunityTypes c")
    , @NamedQuery(name = "OpportunityTypes.findByTypeId", query = "SELECT c FROM OpportunityTypes c WHERE c.typeId = :typeId")
    , @NamedQuery(name = "OpportunityTypes.findByType", query = "SELECT c FROM OpportunityTypes c WHERE c.type = :type")
    , @NamedQuery(name = "OpportunityTypes.findByIsactive", query = "SELECT c FROM OpportunityTypes c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "OpportunityTypes.findByIsdeleted", query = "SELECT c FROM OpportunityTypes c WHERE c.isdeleted = :isdeleted")})
public class OpportunityTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TYPE_ID", nullable = false, precision = 0, scale = -127)
    private Long typeId;
    @Size(max = 200)
    @Column(name = "TYPE", length = 200)
    private String type;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public OpportunityTypes() {
    }

    public OpportunityTypes(Long typeId) {
        this.typeId = typeId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpportunityTypes)) {
            return false;
        }
        OpportunityTypes other = (OpportunityTypes) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.OpportunityTypes[ typeId=" + typeId + " ]";
    }
    
}
