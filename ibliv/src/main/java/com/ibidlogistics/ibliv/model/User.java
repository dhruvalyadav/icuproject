/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Laptop
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "id")
    private String id;
    @Column(name = "mobileno")
    private String mobileno;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private Integer active;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "createdby")
    private int createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "updatedby")
    private Integer updatedby;
    @Column(name = "updateddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateddate;
    @OneToMany(mappedBy = "consultant1")
    private List<Patientdaysheet> patientdaysheetList;
    @OneToMany(mappedBy = "consultant2")
    private List<Patientdaysheet> patientdaysheetList1;
    @OneToMany(mappedBy = "consultant3")
    private List<Patientdaysheet> patientdaysheetList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intensivist")
    private List<Patientdaysheet> patientdaysheetList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administeredby")
    private List<Patientmedicationlog> patientmedicationlogList;
    @OneToMany(mappedBy = "rmonurse")
    private List<Rmonurselog> rmonurselogList;
    @OneToMany(mappedBy = "doctor")
    private List<Consultantpatientvisit> consultantpatientvisitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmo")
    private List<Shiftrmonurse> shiftrmonurseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nurse")
    private List<Shiftrmonurse> shiftrmonurseList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preparedby")
    private List<Patientinfusion> patientinfusionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Userrole> userroleList;
    @OneToMany(mappedBy = "user")
    private List<Usertoken> usertokenList;
    @OneToMany(mappedBy = "user")
    private List<Resettoken> resettokenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administeredby")
    private List<Patientsosmedication> patientsosmedicationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderedbydoctor")
    private List<Patientsosmedication> patientsosmedicationList1;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public User(Integer userid, String name, String username, String password, int createdby) {
        this.userid = userid;
        this.name = name;
        this.username = username;
        this.password = password;
        this.createdby = createdby;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Integer getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    public List<Patientdaysheet> getPatientdaysheetList() {
        return patientdaysheetList;
    }

    public void setPatientdaysheetList(List<Patientdaysheet> patientdaysheetList) {
//        this.patientdaysheetList = patientdaysheetList;
        if (this.patientdaysheetList == null)
        {
            this.patientdaysheetList = new ArrayList<>();
        }
        if (patientdaysheetList != null)
        {
            this.patientdaysheetList.clear();
            this.patientdaysheetList.addAll(patientdaysheetList);
        }
    }

    public List<Patientdaysheet> getPatientdaysheetList1() {
        return patientdaysheetList1;
    }

    public void setPatientdaysheetList1(List<Patientdaysheet> patientdaysheetList1) {
//        this.patientdaysheetList1 = patientdaysheetList1;
        if (this.patientdaysheetList1 == null)
        {
            this.patientdaysheetList1 = new ArrayList<>();
        }
        if (patientdaysheetList1 != null)
        {
            this.patientdaysheetList1.clear();
            this.patientdaysheetList1.addAll(patientdaysheetList1);
        }
    }

    public List<Patientdaysheet> getPatientdaysheetList2() {
        return patientdaysheetList2;
    }

    public void setPatientdaysheetList2(List<Patientdaysheet> patientdaysheetList2) {
//        this.patientdaysheetList2 = patientdaysheetList2;
        if (this.patientdaysheetList2 == null)
        {
            this.patientdaysheetList2 = new ArrayList<>();
        }
        if (patientdaysheetList2 != null)
        {
            this.patientdaysheetList2.clear();
            this.patientdaysheetList2.addAll(patientdaysheetList2);
        }
    }

    public List<Patientdaysheet> getPatientdaysheetList3() {
        return patientdaysheetList3;
    }

    public void setPatientdaysheetList3(List<Patientdaysheet> patientdaysheetList3) {
//        this.patientdaysheetList3 = patientdaysheetList3;
        if (this.patientdaysheetList3 == null)
        {
            this.patientdaysheetList3 = new ArrayList<>();
        }
        if (patientdaysheetList3 != null)
        {
            this.patientdaysheetList3.clear();
            this.patientdaysheetList3.addAll(patientdaysheetList3);
        }
    }

    public List<Patientmedicationlog> getPatientmedicationlogList() {
        return patientmedicationlogList;
    }

    public void setPatientmedicationlogList(List<Patientmedicationlog> patientmedicationlogList) {
//        this.patientmedicationlogList = patientmedicationlogList;
        if (this.patientmedicationlogList == null)
        {
            this.patientmedicationlogList = new ArrayList<>();
        }
        if (patientmedicationlogList != null)
        {
            this.patientmedicationlogList.clear();
            this.patientmedicationlogList.addAll(patientmedicationlogList);
        }
    }

    public List<Rmonurselog> getRmonurselogList() {
        return rmonurselogList;
    }

    public void setRmonurselogList(List<Rmonurselog> rmonurselogList) {
//        this.rmonurselogList = rmonurselogList;
        if (this.rmonurselogList == null)
        {
            this.rmonurselogList = new ArrayList<>();
        }
        if (rmonurselogList != null)
        {
            this.rmonurselogList.clear();
            this.rmonurselogList.addAll(rmonurselogList);
        }
    }

    public List<Consultantpatientvisit> getConsultantpatientvisitList() {
        return consultantpatientvisitList;
    }

    public void setConsultantpatientvisitList(List<Consultantpatientvisit> consultantpatientvisitList) {
//        this.consultantpatientvisitList = consultantpatientvisitList;
        if (this.consultantpatientvisitList == null)
        {
            this.consultantpatientvisitList = new ArrayList<>();
        }
        if (consultantpatientvisitList != null)
        {
            this.consultantpatientvisitList.clear();
            this.consultantpatientvisitList.addAll(consultantpatientvisitList);
        }
    }

    public List<Shiftrmonurse> getShiftrmonurseList() {
        return shiftrmonurseList;
    }

    public void setShiftrmonurseList(List<Shiftrmonurse> shiftrmonurseList) {
//        this.shiftrmonurseList = shiftrmonurseList;
        if (this.shiftrmonurseList == null)
        {
            this.shiftrmonurseList = new ArrayList<>();
        }
        if (shiftrmonurseList != null)
        {
            this.shiftrmonurseList.clear();
            this.shiftrmonurseList.addAll(shiftrmonurseList);
        }
    }

    public List<Shiftrmonurse> getShiftrmonurseList1() {
        return shiftrmonurseList1;
    }

    public void setShiftrmonurseList1(List<Shiftrmonurse> shiftrmonurseList1) {
//        this.shiftrmonurseList1 = shiftrmonurseList1;
        if (this.shiftrmonurseList1 == null)
        {
            this.shiftrmonurseList1 = new ArrayList<>();
        }
        if (shiftrmonurseList1 != null)
        {
            this.shiftrmonurseList1.clear();
            this.shiftrmonurseList1.addAll(shiftrmonurseList1);
        }
    }

    public List<Patientinfusion> getPatientinfusionList() {
        return patientinfusionList;
    }

    public void setPatientinfusionList(List<Patientinfusion> patientinfusionList) {
//        this.patientinfusionList = patientinfusionList;
        if (this.patientinfusionList == null)
        {
            this.patientinfusionList = new ArrayList<>();
        }
        if (patientinfusionList != null)
        {
            this.patientinfusionList.clear();
            this.patientinfusionList.addAll(patientinfusionList);
        }
    }

    public List<Userrole> getUserroleList() {
        return userroleList;
    }

    public void setUserroleList(List<Userrole> userroleList) {
//        this.userroleList = userroleList;
        if (this.userroleList == null)
        {
            this.userroleList = new ArrayList<>();
        }
        if (userroleList != null)
        {
            this.userroleList.clear();
            this.userroleList.addAll(userroleList);
        }
    }

    public List<Usertoken> getUsertokenList() {
        return usertokenList;
    }

    public void setUsertokenList(List<Usertoken> usertokenList) {
//        this.usertokenList = usertokenList;
        if (this.usertokenList == null)
        {
            this.usertokenList = new ArrayList<>();
        }
        if (usertokenList != null)
        {
            this.usertokenList.clear();
            this.usertokenList.addAll(usertokenList);
        }
    }

    public List<Resettoken> getResettokenList() {
        return resettokenList;
    }

    public void setResettokenList(List<Resettoken> resettokenList) {
//        this.resettokenList = resettokenList;
        if (this.resettokenList == null)
        {
            this.resettokenList = new ArrayList<>();
        }
        if (resettokenList != null)
        {
            this.resettokenList.clear();
            this.resettokenList.addAll(resettokenList);
        }
    }

    public List<Patientsosmedication> getPatientsosmedicationList() {
        return patientsosmedicationList;
    }

    public void setPatientsosmedicationList(List<Patientsosmedication> patientsosmedicationList) {
//        this.patientsosmedicationList = patientsosmedicationList;
        if (this.patientsosmedicationList == null)
        {
            this.patientsosmedicationList = new ArrayList<>();
        }
        if (patientsosmedicationList != null)
        {
            this.patientsosmedicationList.clear();
            this.patientsosmedicationList.addAll(patientsosmedicationList);
        }
    }

    public List<Patientsosmedication> getPatientsosmedicationList1() {
        return patientsosmedicationList1;
    }

    public void setPatientsosmedicationList1(List<Patientsosmedication> patientsosmedicationList1) {
//        this.patientsosmedicationList1 = patientsosmedicationList1;
        if (this.patientsosmedicationList1 == null)
        {
            this.patientsosmedicationList1 = new ArrayList<>();
        }
        if (patientsosmedicationList1 != null)
        {
            this.patientsosmedicationList1.clear();
            this.patientsosmedicationList1.addAll(patientsosmedicationList1);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.User[ userid=" + userid + " ]";
    }
    
}
