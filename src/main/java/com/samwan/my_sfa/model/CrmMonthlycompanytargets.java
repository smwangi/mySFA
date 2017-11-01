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
@Table(name = "CRM_MONTHLYCOMPANYTARGETS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmMonthlycompanytargets.findAll", query = "SELECT c FROM CrmMonthlycompanytargets c")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByTargetId", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.targetId = :targetId")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByJanuary", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.january = :january")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByFebruary", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.february = :february")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByMarch", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.march = :march")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByApril", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.april = :april")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByMay", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.may = :may")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByJune", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.june = :june")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByJuly", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.july = :july")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByAugust", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.august = :august")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findBySeptember", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.september = :september")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByOctober", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.october = :october")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByNovember", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.november = :november")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByDecember", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.december = :december")
    , @NamedQuery(name = "CrmMonthlycompanytargets.findByMtargetId", query = "SELECT c FROM CrmMonthlycompanytargets c WHERE c.mtargetId = :mtargetId")})
public class CrmMonthlycompanytargets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TARGET_ID")
    private BigInteger targetId;
    @Column(name = "JANUARY")
    private BigInteger january;
    @Column(name = "FEBRUARY")
    private BigInteger february;
    @Column(name = "MARCH")
    private BigInteger march;
    @Column(name = "APRIL")
    private BigInteger april;
    @Column(name = "MAY")
    private BigInteger may;
    @Column(name = "JUNE")
    private BigInteger june;
    @Column(name = "JULY")
    private BigInteger july;
    @Column(name = "AUGUST")
    private BigInteger august;
    @Column(name = "SEPTEMBER")
    private BigInteger september;
    @Column(name = "OCTOBER")
    private BigInteger october;
    @Column(name = "NOVEMBER")
    private BigInteger november;
    @Column(name = "DECEMBER")
    private BigInteger december;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MTARGET_ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal mtargetId;

    public CrmMonthlycompanytargets() {
    }

    public CrmMonthlycompanytargets(BigDecimal mtargetId) {
        this.mtargetId = mtargetId;
    }

    public BigInteger getTargetId() {
        return targetId;
    }

    public void setTargetId(BigInteger targetId) {
        this.targetId = targetId;
    }

    public BigInteger getJanuary() {
        return january;
    }

    public void setJanuary(BigInteger january) {
        this.january = january;
    }

    public BigInteger getFebruary() {
        return february;
    }

    public void setFebruary(BigInteger february) {
        this.february = february;
    }

    public BigInteger getMarch() {
        return march;
    }

    public void setMarch(BigInteger march) {
        this.march = march;
    }

    public BigInteger getApril() {
        return april;
    }

    public void setApril(BigInteger april) {
        this.april = april;
    }

    public BigInteger getMay() {
        return may;
    }

    public void setMay(BigInteger may) {
        this.may = may;
    }

    public BigInteger getJune() {
        return june;
    }

    public void setJune(BigInteger june) {
        this.june = june;
    }

    public BigInteger getJuly() {
        return july;
    }

    public void setJuly(BigInteger july) {
        this.july = july;
    }

    public BigInteger getAugust() {
        return august;
    }

    public void setAugust(BigInteger august) {
        this.august = august;
    }

    public BigInteger getSeptember() {
        return september;
    }

    public void setSeptember(BigInteger september) {
        this.september = september;
    }

    public BigInteger getOctober() {
        return october;
    }

    public void setOctober(BigInteger october) {
        this.october = october;
    }

    public BigInteger getNovember() {
        return november;
    }

    public void setNovember(BigInteger november) {
        this.november = november;
    }

    public BigInteger getDecember() {
        return december;
    }

    public void setDecember(BigInteger december) {
        this.december = december;
    }

    public BigDecimal getMtargetId() {
        return mtargetId;
    }

    public void setMtargetId(BigDecimal mtargetId) {
        this.mtargetId = mtargetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mtargetId != null ? mtargetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmMonthlycompanytargets)) {
            return false;
        }
        CrmMonthlycompanytargets other = (CrmMonthlycompanytargets) object;
        if ((this.mtargetId == null && other.mtargetId != null) || (this.mtargetId != null && !this.mtargetId.equals(other.mtargetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmMonthlycompanytargets[ mtargetId=" + mtargetId + " ]";
    }
    
}
