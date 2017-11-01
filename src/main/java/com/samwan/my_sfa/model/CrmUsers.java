/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.model;

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
@Table(name = "CRM_USERS")//, catalog = "", schema = "TANGAZOLETUCRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmUsers.findAll", query = "SELECT c FROM CrmUsers c")
    , @NamedQuery(name = "CrmUsers.findByUserId", query = "SELECT c FROM CrmUsers c WHERE c.userId = :userId")
    , @NamedQuery(name = "CrmUsers.findByCountryIdFk", query = "SELECT c FROM CrmUsers c WHERE c.countryIdFk = :countryIdFk")
    , @NamedQuery(name = "CrmUsers.findByGroupIdFk", query = "SELECT c FROM CrmUsers c WHERE c.groupIdFk = :groupIdFk")
    , @NamedQuery(name = "CrmUsers.findByFirstname", query = "SELECT c FROM CrmUsers c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "CrmUsers.findByMiddlename", query = "SELECT c FROM CrmUsers c WHERE c.middlename = :middlename")
    , @NamedQuery(name = "CrmUsers.findByLastname", query = "SELECT c FROM CrmUsers c WHERE c.lastname = :lastname")
    , @NamedQuery(name = "CrmUsers.findByLogin", query = "SELECT c FROM CrmUsers c WHERE c.login = :login")
    , @NamedQuery(name = "CrmUsers.findByPass", query = "SELECT c FROM CrmUsers c WHERE c.pass = :pass")
    , @NamedQuery(name = "CrmUsers.findByEmailadd", query = "SELECT c FROM CrmUsers c WHERE c.emailadd = :emailadd")
    , @NamedQuery(name = "CrmUsers.findByMsdin", query = "SELECT c FROM CrmUsers c WHERE c.msdin = :msdin")
    , @NamedQuery(name = "CrmUsers.findByPhoto", query = "SELECT c FROM CrmUsers c WHERE c.photo = :photo")
    , @NamedQuery(name = "CrmUsers.findByAddedby", query = "SELECT c FROM CrmUsers c WHERE c.addedby = :addedby")
    , @NamedQuery(name = "CrmUsers.findByDateadded", query = "SELECT c FROM CrmUsers c WHERE c.dateadded = :dateadded")
    , @NamedQuery(name = "CrmUsers.findByModifiedby", query = "SELECT c FROM CrmUsers c WHERE c.modifiedby = :modifiedby")
    , @NamedQuery(name = "CrmUsers.findByDatemodified", query = "SELECT c FROM CrmUsers c WHERE c.datemodified = :datemodified")
    , @NamedQuery(name = "CrmUsers.findByLastlogin", query = "SELECT c FROM CrmUsers c WHERE c.lastlogin = :lastlogin")
    , @NamedQuery(name = "CrmUsers.findByIsactive", query = "SELECT c FROM CrmUsers c WHERE c.isactive = :isactive")
    , @NamedQuery(name = "CrmUsers.findByIsdeleted", query = "SELECT c FROM CrmUsers c WHERE c.isdeleted = :isdeleted")
    , @NamedQuery(name = "CrmUsers.findByGender", query = "SELECT c FROM CrmUsers c WHERE c.gender = :gender")
    , @NamedQuery(name = "CrmUsers.findByDepartmentIdFk", query = "SELECT c FROM CrmUsers c WHERE c.departmentIdFk = :departmentIdFk")
    , @NamedQuery(name = "CrmUsers.findByEmpnumber", query = "SELECT c FROM CrmUsers c WHERE c.empnumber = :empnumber")
    , @NamedQuery(name = "CrmUsers.findByJobtitle", query = "SELECT c FROM CrmUsers c WHERE c.jobtitle = :jobtitle")
    , @NamedQuery(name = "CrmUsers.findByActivityAlert", query = "SELECT c FROM CrmUsers c WHERE c.activityAlert = :activityAlert")})
public class CrmUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID", nullable = false, precision = 0, scale = -127)
    private Long userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COUNTRY_ID_FK", nullable = false)
    private BigInteger countryIdFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUP_ID_FK", nullable = false)
    private BigInteger groupIdFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRSTNAME", nullable = false, length = 20)
    private String firstname;
    @Size(max = 20)
    @Column(name = "MIDDLENAME", length = 20)
    private String middlename;
    @Size(max = 20)
    @Column(name = "LASTNAME", length = 20)
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOGIN", nullable = false, length = 20)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASS", nullable = false, length = 100)
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAILADD", nullable = false, length = 45)
    private String emailadd;
    @Size(max = 20)
    @Column(name = "MSDIN", length = 20)
    private String msdin;
    @Size(max = 100)
    @Column(name = "PHOTO", length = 100)
    private String photo;
    @Column(name = "ADDEDBY")
    private BigInteger addedby;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "MODIFIEDBY")
    private BigInteger modifiedby;
    @Column(name = "DATEMODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemodified;
    @Column(name = "LASTLOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
    @Column(name = "ISDELETED")
    private BigInteger isdeleted;
    @Size(max = 20)
    @Column(name = "GENDER", length = 20)
    private String gender;
    @Column(name = "DEPARTMENT_ID_FK")
    private BigInteger departmentIdFk;
    @Size(max = 20)
    @Column(name = "EMPNUMBER", length = 20)
    private String empnumber;
    @Size(max = 20)
    @Column(name = "JOBTITLE", length = 20)
    private String jobtitle;
    @Column(name = "ACTIVITY_ALERT")
    private BigInteger activityAlert;

    public CrmUsers() {
    }

    public CrmUsers(Long userId) {
        this.userId = userId;
    }

    public CrmUsers(Long userId, BigInteger countryIdFk, BigInteger groupIdFk, String firstname, String login, String pass, String emailadd) {
        this.userId = userId;
        this.countryIdFk = countryIdFk;
        this.groupIdFk = groupIdFk;
        this.firstname = firstname;
        this.login = login;
        this.pass = pass;
        this.emailadd = emailadd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigInteger getCountryIdFk() {
        return countryIdFk;
    }

    public void setCountryIdFk(BigInteger countryIdFk) {
        this.countryIdFk = countryIdFk;
    }

    public BigInteger getGroupIdFk() {
        return groupIdFk;
    }

    public void setGroupIdFk(BigInteger groupIdFk) {
        this.groupIdFk = groupIdFk;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmailadd() {
        return emailadd;
    }

    public void setEmailadd(String emailadd) {
        this.emailadd = emailadd;
    }

    public String getMsdin() {
        return msdin;
    }

    public void setMsdin(String msdin) {
        this.msdin = msdin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public BigInteger getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(BigInteger modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(Date datemodified) {
        this.datemodified = datemodified;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigInteger getDepartmentIdFk() {
        return departmentIdFk;
    }

    public void setDepartmentIdFk(BigInteger departmentIdFk) {
        this.departmentIdFk = departmentIdFk;
    }

    public String getEmpnumber() {
        return empnumber;
    }

    public void setEmpnumber(String empnumber) {
        this.empnumber = empnumber;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public BigInteger getActivityAlert() {
        return activityAlert;
    }

    public void setActivityAlert(BigInteger activityAlert) {
        this.activityAlert = activityAlert;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmUsers)) {
            return false;
        }
        CrmUsers other = (CrmUsers) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tl.tl_crm.model.CrmUsers[ userId=" + userId + " ]";
    }
    
}
