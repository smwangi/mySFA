/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "EMAIL_LOGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailLogs.findAll", query = "SELECT c FROM EmailLogs c")
    , @NamedQuery(name = "EmailLogs.findByLogId", query = "SELECT c FROM EmailLogs c WHERE c.logId = :logId")
    , @NamedQuery(name = "EmailLogs.findBySubject", query = "SELECT c FROM EmailLogs c WHERE c.subject = :subject")
    , @NamedQuery(name = "EmailLogs.findByResponseText", query = "SELECT c FROM EmailLogs c WHERE c.responseText = :responseText")
    , @NamedQuery(name = "EmailLogs.findByDateadded", query = "SELECT c FROM EmailLogs c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "EmailLogs.findByResponseCode", query = "SELECT c FROM EmailLogs c WHERE c.responseCode = :responseCode")})
public class EmailLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOG_ID", nullable = false, precision = 0, scale = -127)
    private Long logId;
    @Lob
    @Column(name = "RECIPIENT")
    private String recipient;
    @Size(max = 400)
    @Column(name = "SUBJECT", length = 400)
    private String subject;
    @Lob
    @Column(name = "CONTENT")
    private String content;
    @Size(max = 200)
    @Column(name = "RESPONSE_TEXT", length = 200)
    private String responseText;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Size(max = 20)
    @Column(name = "RESPONSE_CODE", length = 20)
    private String responseCode;

    public EmailLogs() {
    }

    public EmailLogs(Long logId) {
        this.logId = logId;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailLogs)) {
            return false;
        }
        EmailLogs other = (EmailLogs) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.EmailLogs[ logId=" + logId + " ]";
    }
    
}
