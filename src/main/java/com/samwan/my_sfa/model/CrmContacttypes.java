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
@Table(name = "CRM_CONTACTTYPES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmContacttypes.findAll", query = "SELECT c FROM CrmContacttypes c")
    , @NamedQuery(name = "CrmContacttypes.findByContactTypeId", query = "SELECT c FROM CrmContacttypes c WHERE c.contactTypeId = :contactTypeId")
    , @NamedQuery(name = "CrmContacttypes.findByCType", query = "SELECT c FROM CrmContacttypes c WHERE c.cType = :cType")
    , @NamedQuery(name = "CrmContacttypes.findByIsactive", query = "SELECT c FROM CrmContacttypes c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmContacttypes.findByIsdeleted", query = "SELECT c FROM CrmContacttypes c WHERE c.isdeleted = :isdeleted")})
public class CrmContacttypes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTACT_TYPE_ID", nullable = false, precision = 0, scale = -127)
    private Long contactTypeId;
    @Size(max = 20)
    @Column(name = "C_TYPE", length = 20)
    private String cType;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmContacttypes() {
    }

    public CrmContacttypes(Long contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public Long getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(Long contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getCType() {
        return cType;
    }

    public void setCType(String cType) {
        this.cType = cType;
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
        hash += (contactTypeId != null ? contactTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmContacttypes)) {
            return false;
        }
        CrmContacttypes other = (CrmContacttypes) object;
        if ((this.contactTypeId == null && other.contactTypeId != null) || (this.contactTypeId != null && !this.contactTypeId.equals(other.contactTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmContacttypes[ contactTypeId=" + contactTypeId + " ]";
    }
    
}
