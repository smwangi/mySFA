/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.model;

import java.io.Serializable;
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
@Table(name = "CRM_COLORS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmColors.findAll", query = "SELECT c FROM CrmColors c")
    , @NamedQuery(name = "CrmColors.findByColorId", query = "SELECT c FROM CrmColors c WHERE c.colorId = :colorId")
    , @NamedQuery(name = "CrmColors.findByCName", query = "SELECT c FROM CrmColors c WHERE c.cName = :cName")})
public class CrmColors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COLOR_ID", nullable = false, length = 20)
    private String colorId;
    @Size(max = 20)
    @Column(name = "C_NAME", length = 20)
    private String cName;

    public CrmColors() {
    }

    public CrmColors(String colorId) {
        this.colorId = colorId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colorId != null ? colorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmColors)) {
            return false;
        }
        CrmColors other = (CrmColors) object;
        if ((this.colorId == null && other.colorId != null) || (this.colorId != null && !this.colorId.equals(other.colorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmColors[ colorId=" + colorId + " ]";
    }
    
}
