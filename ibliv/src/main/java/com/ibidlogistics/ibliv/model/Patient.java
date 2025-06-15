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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jayraj Malge
 */
@Entity
@Table(name = "patient")
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findAllOrderBy", query = "SELECT p FROM Patient p ORDER BY p.patientname ASC"),
    @NamedQuery(name = "Patient.findByPatientid", query = "SELECT p FROM Patient p WHERE p.patientid = :patientid"),
    @NamedQuery(name = "Patient.findByPatientname", query = "SELECT p FROM Patient p WHERE p.patientname = :patientname"),
    @NamedQuery(name = "Patient.findByDob", query = "SELECT p FROM Patient p WHERE p.dob = :dob"),
    @NamedQuery(name = "Patient.findByAge", query = "SELECT p FROM Patient p WHERE p.age = :age"),
    @NamedQuery(name = "Patient.findBySex", query = "SELECT p FROM Patient p WHERE p.sex = :sex"),
    @NamedQuery(name = "Patient.findByAddress", query = "SELECT p FROM Patient p WHERE p.address = :address"),
    @NamedQuery(name = "Patient.findByContact", query = "SELECT p FROM Patient p WHERE p.contact = :contact"),
    @NamedQuery(name = "Patient.findByActive", query = "SELECT p FROM Patient p WHERE p.active = :active"),
    @NamedQuery(name = "Patient.findByCreatedby", query = "SELECT p FROM Patient p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patient.findByCreateddate", query = "SELECT p FROM Patient p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patient.findByUpdatedby", query = "SELECT p FROM Patient p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name= "Patient.findByPatientsimilarName",query = "SELECT p FROM Patient p WHERE p.patientname LIKE LOWER(CONCAT('%', :patientname, '%'))"),
    @NamedQuery(name = "Patient.findByUpdateddate", query = "SELECT p FROM Patient p WHERE p.updateddate = :updateddate"),
    @NamedQuery(name= "Patient.DeleteByPatientid",query = "DELETE FROM Patient p WHERE p.patientid = :patientid"),

})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientid")
    private Integer patientid;
    @Column(name = "patientname")
    private String patientname;
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "age")
    private Integer age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;
    @Column(name = "active")
    private Integer active;
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
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Anthropometry> anthropometryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientadmission> patientadmissionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientinfusion> patientinfusionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientivfluid> patientivfluidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientsosmedication> patientsosmedicationList;*/

    public Patient() {
    }

    public Patient(Integer patientid) {
        this.patientid = patientid;
    }

    public Patient(Integer patientid, int createdby) {
        this.patientid = patientid;
        this.createdby = createdby;
    }

    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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

    /*public List<Anthropometry> getAnthropometryList() {
        return anthropometryList;
    }

    public void setAnthropometryList(List<Anthropometry> anthropometryList) {
        this.anthropometryList = anthropometryList;
    }

    public List<Patientadmission> getPatientadmissionList() {
        return patientadmissionList;
    }

    public void setPatientadmissionList(List<Patientadmission> patientadmissionList) {
        this.patientadmissionList = patientadmissionList;
    }

    public List<Patientinfusion> getPatientinfusionList() {
        return patientinfusionList;
    }

    public void setPatientinfusionList(List<Patientinfusion> patientinfusionList) {
        this.patientinfusionList = patientinfusionList;
    }

    public List<Patientivfluid> getPatientivfluidList() {
        return patientivfluidList;
    }

    public void setPatientivfluidList(List<Patientivfluid> patientivfluidList) {
        this.patientivfluidList = patientivfluidList;
    }

    public List<Patientsosmedication> getPatientsosmedicationList() {
        return patientsosmedicationList;
    }

    public void setPatientsosmedicationList(List<Patientsosmedication> patientsosmedicationList) {
        this.patientsosmedicationList = patientsosmedicationList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientid != null ? patientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientid == null && other.patientid != null) || (this.patientid != null && !this.patientid.equals(other.patientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patient[ patientid=" + patientid + " ]";
    }
    
}
