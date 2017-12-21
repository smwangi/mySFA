/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smwangi
 */
@Entity
@Table(name = "OPPORTUNITIES")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opportunities.findAll", query = "SELECT c FROM Opportunities c")
    , @NamedQuery(name = "Opportunities.findByOpportunityId", query = "SELECT c FROM Opportunities c WHERE c.opportunityId = :opportunityId")
    , @NamedQuery(name = "Opportunities.findByOName", query = "SELECT c FROM Opportunities c WHERE c.oName = :oName")
    , @NamedQuery(name = "Opportunities.findByAccountIdFk", query = "SELECT c FROM Opportunities c WHERE c.accountIdFk = :accountIdFk")
    , @NamedQuery(name = "Opportunities.findByOAmount", query = "SELECT c FROM Opportunities c WHERE c.oAmount = :oAmount")
    , @NamedQuery(name = "Opportunities.findByOType", query = "SELECT c FROM Opportunities c WHERE c.oType = :oType")
    , @NamedQuery(name = "Opportunities.findByOEclosedate", query = "SELECT c FROM Opportunities c WHERE c.oEclosedate = :oEclosedate")
    , @NamedQuery(name = "Opportunities.findByOLeadsource", query = "SELECT c FROM Opportunities c WHERE c.oLeadsource = :oLeadsource")
    , @NamedQuery(name = "Opportunities.findByONextstep", query = "SELECT c FROM Opportunities c WHERE c.oNextstep = :oNextstep")
    , @NamedQuery(name = "Opportunities.findByOAssignedto", query = "SELECT c FROM Opportunities c WHERE c.oAssignedto = :oAssignedto")
    , @NamedQuery(name = "Opportunities.findByOSalestage", query = "SELECT c FROM Opportunities c WHERE c.oSalestage = :oSalestage")
    , @NamedQuery(name = "Opportunities.findByOProbability", query = "SELECT c FROM Opportunities c WHERE c.oProbability = :oProbability")
    , @NamedQuery(name = "Opportunities.findByOContact", query = "SELECT c FROM Opportunities c WHERE c.oContact = :oContact")
    , @NamedQuery(name = "Opportunities.findByDateadded", query = "SELECT c FROM Opportunities c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "Opportunities.findByAddedby", query = "SELECT c FROM Opportunities c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "Opportunities.findByIsactive", query = "SELECT c FROM Opportunities c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "Opportunities.findByIsdeleted", query = "SELECT c FROM Opportunities c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "Opportunities.findByVisitId", query = "SELECT c FROM Opportunities c WHERE c.visitId = :visitId")
    , @NamedQuery(name = "Opportunities.findByIsconverted", query = "SELECT c FROM Opportunities c WHERE c.isconverted = :isconverted")
    , @NamedQuery(name = "Opportunities.findByProductId", query = "SELECT c FROM Opportunities c WHERE c.productId = :productId")
    , @NamedQuery(name = "Opportunities.findByCountryId", query = "SELECT c FROM Opportunities c WHERE c.countryId = :countryId")
    , @NamedQuery(name = "Opportunities.findBySectorId", query = "SELECT c FROM Opportunities c WHERE c.sectorId = :sectorId")
    , @NamedQuery(name = "Opportunities.findByODescription", query = "SELECT c FROM Opportunities c WHERE c.oDescription = :oDescription")})
public class Opportunities implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPPORTUNITY_ID", nullable = false, precision = 0, scale = -127)
    private Long opportunityId;
    @Size(max = 100)
    @Column(name = "O_NAME", length = 100)
    private String oName;
    @Column(name = "ACCOUNT_ID_FK")
    private BigInteger accountIdFk;
    @Size(max = 20)
    @Column(name = "O_AMOUNT", length = 20)
    private String oAmount;
    @Column(name = "O_TYPE")
    private BigInteger oType;
    @Column(name = "O_ECLOSEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oEclosedate;
    @Column(name = "O_LEADSOURCE")
    private BigInteger oLeadsource;
    @Size(max = 255)
    @Column(name = "O_NEXTSTEP", length = 255)
    private String oNextstep;
    @Column(name = "O_ASSIGNEDTO")
    private BigInteger oAssignedto;
    @Column(name = "O_SALESTAGE")
    private BigInteger oSalestage;
    @Size(max = 20)
    @Column(name = "O_PROBABILITY", length = 20)
    private String oProbability;
    @Column(name = "O_CONTACT")
    private BigInteger oContact;
    @Lob
    @Column(name = "O_DESCRIPTIONXXX")
    private String oDescriptionxxx;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Column(name = "VISIT_ID")
    private BigInteger visitId;
    @Column(name = "ISCONVERTED")
    private BigInteger isconverted;
    @Column(name = "PRODUCT_ID")
    private BigInteger productId;
    @Column(name = "COUNTRY_ID")
    private BigInteger countryId;
    @Column(name = "SECTOR_ID")
    private BigInteger sectorId;
    @Size(max = 4000)
    @Column(name = "O_DESCRIPTION", length = 4000)
    private String oDescription;

    public Opportunities() {
    }

    public Opportunities(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public Long getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public BigInteger getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(BigInteger accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    public String getOAmount() {
        return oAmount;
    }

    public void setOAmount(String oAmount) {
        this.oAmount = oAmount;
    }

    public BigInteger getOType() {
        return oType;
    }

    public void setOType(BigInteger oType) {
        this.oType = oType;
    }

    public Date getOEclosedate() {
        return oEclosedate;
    }

    public void setOEclosedate(Date oEclosedate) {
        this.oEclosedate = oEclosedate;
    }

    public BigInteger getOLeadsource() {
        return oLeadsource;
    }

    public void setOLeadsource(BigInteger oLeadsource) {
        this.oLeadsource = oLeadsource;
    }

    public String getONextstep() {
        return oNextstep;
    }

    public void setONextstep(String oNextstep) {
        this.oNextstep = oNextstep;
    }

    public BigInteger getOAssignedto() {
        return oAssignedto;
    }

    public void setOAssignedto(BigInteger oAssignedto) {
        this.oAssignedto = oAssignedto;
    }

    public BigInteger getOSalestage() {
        return oSalestage;
    }

    public void setOSalestage(BigInteger oSalestage) {
        this.oSalestage = oSalestage;
    }

    public String getOProbability() {
        return oProbability;
    }

    public void setOProbability(String oProbability) {
        this.oProbability = oProbability;
    }

    public BigInteger getOContact() {
        return oContact;
    }

    public void setOContact(BigInteger oContact) {
        this.oContact = oContact;
    }

    public String getODescriptionxxx() {
        return oDescriptionxxx;
    }

    public void setODescriptionxxx(String oDescriptionxxx) {
        this.oDescriptionxxx = oDescriptionxxx;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public BigInteger getAddedby() {
        return addedby;
    }

    public void setAddedby(BigInteger addedby) {
        this.addedby = addedby;
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

    public BigInteger getVisitId() {
        return visitId;
    }

    public void setVisitId(BigInteger visitId) {
        this.visitId = visitId;
    }

    public BigInteger getIsconverted() {
        return isconverted;
    }

    public void setIsconverted(BigInteger isconverted) {
        this.isconverted = isconverted;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public BigInteger getCountryId() {
        return countryId;
    }

    public void setCountryId(BigInteger countryId) {
        this.countryId = countryId;
    }

    public BigInteger getSectorId() {
        return sectorId;
    }

    public void setSectorId(BigInteger sectorId) {
        this.sectorId = sectorId;
    }

    public String getODescription() {
        return oDescription;
    }

    public void setODescription(String oDescription) {
        this.oDescription = oDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opportunityId != null ? opportunityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opportunities)) {
            return false;
        }
        Opportunities other = (Opportunities) object;
        if ((this.opportunityId == null && other.opportunityId != null) || (this.opportunityId != null && !this.opportunityId.equals(other.opportunityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.Opportunities[ opportunityId=" + opportunityId + " ]";
    }
    
}
