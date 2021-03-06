/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CONTACTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
    , @NamedQuery(name = "Contacts.findByContactId", query = "SELECT c FROM Contacts c WHERE c.contactId = :contactId")
    , @NamedQuery(name = "Contacts.findByAccountIdFk", query = "SELECT c FROM Contacts c WHERE c.accountIdFk = :accountIdFk")
    , @NamedQuery(name = "Contacts.findByEmails", query = "SELECT c FROM Contacts c WHERE c.emails = :emails")
    , @NamedQuery(name = "Contacts.findByPhonenos", query = "SELECT c FROM Contacts c WHERE c.phonenos = :phonenos")
    , @NamedQuery(name = "Contacts.findByAddedby", query = "SELECT c FROM Contacts c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "Contacts.findByDateadded", query = "SELECT c FROM Contacts c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "Contacts.findByIsactive", query = "SELECT c FROM Contacts c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "Contacts.findByIsdeleted", query = "SELECT c FROM Contacts c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "Contacts.findByCName", query = "SELECT c FROM Contacts c WHERE c.cName = :cName")
    , @NamedQuery(name = "Contacts.findByCTitle", query = "SELECT c FROM Contacts c WHERE c.cTitle = :cTitle")})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTACT_ID", nullable = false, precision = 0, scale = -127)
    private Long contactId;
    @Column(name = "ACCOUNT_ID_FK")
    private BigInteger accountIdFk;
    @Size(max = 500)
    @Column(name = "EMAILS", length = 500)
    private String emails;
    @Size(max = 500)
    @Column(name = "PHONENOS", length = 500)
    private String phonenos;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Size(max = 100)
    @Column(name = "C_NAME", length = 100)
    private String cName;
    @Size(max = 200)
    @Column(name = "C_TITLE", length = 200)
    private String cTitle;

    public Contacts() {
    }

    public Contacts(Long contactId) {
        this.contactId = contactId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public BigInteger getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(BigInteger accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhonenos() {
        return phonenos;
    }

    public void setPhonenos(String phonenos) {
        this.phonenos = phonenos;
    }

    public BigInteger getAddedby() {
        return addedby;
    }

    public void setAddedby(BigInteger addedby) {
        this.addedby = addedby;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
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

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCTitle() {
        return cTitle;
    }

    public void setCTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samwan.my_sfa.model.Contacts[ contactId=" + contactId + " ]";
    }
    
}
