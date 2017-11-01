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
@Table(name = "CRM_COMPANYDEPARTMENTS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmCompanydepartments.findAll", query = "SELECT c FROM CrmCompanydepartments c")
    , @NamedQuery(name = "CrmCompanydepartments.findByDepartmentId", query = "SELECT c FROM CrmCompanydepartments c WHERE c.departmentId = :departmentId")
    , @NamedQuery(name = "CrmCompanydepartments.findByDName", query = "SELECT c FROM CrmCompanydepartments c WHERE c.dName = :dName")
    , @NamedQuery(name = "CrmCompanydepartments.findByIsactive", query = "SELECT c FROM CrmCompanydepartments c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmCompanydepartments.findByIsdeleted", query = "SELECT c FROM CrmCompanydepartments c WHERE c.isdeleted = :isdeleted")})
public class CrmCompanydepartments implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPARTMENT_ID", nullable = false, precision = 0, scale = -127)
    private Long departmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "D_NAME", nullable = false, length = 200)
    private String dName;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;

    public CrmCompanydepartments() {
    }

    public CrmCompanydepartments(Long departmentId) {
        this.departmentId = departmentId;
    }

    public CrmCompanydepartments(Long departmentId, String dName) {
        this.departmentId = departmentId;
        this.dName = dName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
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
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmCompanydepartments)) {
            return false;
        }
        CrmCompanydepartments other = (CrmCompanydepartments) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmCompanydepartments[ departmentId=" + departmentId + " ]";
    }
    
}
