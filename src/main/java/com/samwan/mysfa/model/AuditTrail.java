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
@Table(name = "AUDIT_TRAIL")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditTrail.findAll", query = "SELECT c FROM AuditTrail c")
    , @NamedQuery(name = "AuditTrail.findById", query = "SELECT c FROM AuditTrail c WHERE c.id = :id")
    , @NamedQuery(name = "AuditTrail.findByType", query = "SELECT c FROM AuditTrail c WHERE c.type = :type")
    , @NamedQuery(name = "AuditTrail.findByUserId", query = "SELECT c FROM AuditTrail c WHERE c.userId = :userId")
    , @NamedQuery(name = "AuditTrail.findByDescription", query = "SELECT c FROM AuditTrail c WHERE c.description = :description")
    , @NamedQuery(name = "AuditTrail.findByHostIp", query = "SELECT c FROM AuditTrail c WHERE c.hostIp = :hostIp")
    , @NamedQuery(name = "AuditTrail.findByLogDate", query = "SELECT c FROM AuditTrail c WHERE c.logDate = :logDate")
    , @NamedQuery(name = "AuditTrail.findByTrxId", query = "SELECT c FROM AuditTrail c WHERE c.trxId = :trxId")})
public class AuditTrail implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private Long id;
    @Size(max = 20)
    @Column(name = "TYPE", length = 20)
    private String type;
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;
    @Size(max = 45)
    @Column(name = "HOST_IP", length = 45)
    private String hostIp;
    @Column(name = "LOG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    @Column(name = "TRX_ID")
    private BigInteger trxId;

    public AuditTrail() {
    }

    public AuditTrail(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public BigInteger getTrxId() {
        return trxId;
    }

    public void setTrxId(BigInteger trxId) {
        this.trxId = trxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditTrail)) {
            return false;
        }
        AuditTrail other = (AuditTrail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.AuditTrail[ id=" + id + " ]";
    }
    
}
