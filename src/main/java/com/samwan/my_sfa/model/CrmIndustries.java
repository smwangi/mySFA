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
@Table(name = "CRM_INDUSTRIES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmIndustries.findAll", query = "SELECT c FROM CrmIndustries c")
    , @NamedQuery(name = "CrmIndustries.findByIndustryId", query = "SELECT c FROM CrmIndustries c WHERE c.industryId = :industryId")
    , @NamedQuery(name = "CrmIndustries.findByIName", query = "SELECT c FROM CrmIndustries c WHERE c.iName = :iName")
    , @NamedQuery(name = "CrmIndustries.findByIsactive", query = "SELECT c FROM CrmIndustries c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmIndustries.findByIsdeleted", query = "SELECT c FROM CrmIndustries c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "CrmIndustries.findByColor", query = "SELECT c FROM CrmIndustries c WHERE c.color = :color")
    , @NamedQuery(name = "CrmIndustries.findByBgcolor", query = "SELECT c FROM CrmIndustries c WHERE c.bgcolor = :bgcolor")})
public class CrmIndustries implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INDUSTRY_ID", nullable = false, precision = 0, scale = -127)
    private Long industryId;
    @Size(max = 200)
    @Column(name = "I_NAME", length = 200)
    private String iName;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Size(max = 20)
    @Column(name = "COLOR", length = 20)
    private String color;
    @Size(max = 20)
    @Column(name = "BGCOLOR", length = 20)
    private String bgcolor;

    public CrmIndustries() {
    }

    public CrmIndustries(Long industryId) {
        this.industryId = industryId;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public String getIName() {
        return iName;
    }

    public void setIName(String iName) {
        this.iName = iName;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (industryId != null ? industryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmIndustries)) {
            return false;
        }
        CrmIndustries other = (CrmIndustries) object;
        if ((this.industryId == null && other.industryId != null) || (this.industryId != null && !this.industryId.equals(other.industryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmIndustries[ industryId=" + industryId + " ]";
    }
    
}
