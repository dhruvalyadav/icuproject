/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jayraj Malge
 */
@Entity
@Table(name = "patientsosmedication")
@NamedQueries({
    @NamedQuery(name = "Patientsosmedication.findAll", query = "SELECT p FROM Patientsosmedication p"),
    @NamedQuery(name = "Patientsosmedication.findByPatientsosmedicationid", query = "SELECT p FROM Patientsosmedication p WHERE p.patientsosmedicationid = :patientsosmedicationid"),
    @NamedQuery(name = "Patientsosmedication.findByIndication", query = "SELECT p FROM Patientsosmedication p WHERE p.indication = :indication"),
    @NamedQuery(name = "Patientsosmedication.findByDrug", query = "SELECT p FROM Patientsosmedication p WHERE p.drug = :drug"),
    @NamedQuery(name = "Patientsosmedication.findByDose", query = "SELECT p FROM Patientsosmedication p WHERE p.dose = :dose"),
    @NamedQuery(name = "Patientsosmedication.findByRoute", query = "SELECT p FROM Patientsosmedication p WHERE p.route = :route"),
    @NamedQuery(name = "Patientsosmedication.findByTime", query = "SELECT p FROM Patientsosmedication p WHERE p.time = :time"),
    @NamedQuery(name = "Patientsosmedication.findByTelephoneverbal", query = "SELECT p FROM Patientsosmedication p WHERE p.telephoneverbal = :telephoneverbal"),
    @NamedQuery(name = "Patientsosmedication.findByCreatedby", query = "SELECT p FROM Patientsosmedication p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patientsosmedication.findByCreateddate", query = "SELECT p FROM Patientsosmedication p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patientsosmedication.findByUpdatedby", query = "SELECT p FROM Patientsosmedication p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Patientsosmedication.findByUpdateddate", query = "SELECT p FROM Patientsosmedication p WHERE p.updateddate = :updateddate")})
public class Patientsosmedication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientsosmedicationid")
    private Integer patientsosmedicationid;
    @Column(name = "indication")
    private String indication;
    @Column(name = "drug")
    private String drug;
    @Column(name = "dose")
    private String dose;
    @Column(name = "route")
    private String route;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "telephoneverbal")
    private String telephoneverbal;
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
    @JoinColumn(name = "patient", referencedColumnName = "patientid")
    @ManyToOne(optional = false)
    private Patient patient;
    @JoinColumn(name = "administeredby", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User administeredby;
    @JoinColumn(name = "orderedbydoctor", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User orderedbydoctor;

    public Patientsosmedication() {
    }

    public Patientsosmedication(Integer patientsosmedicationid) {
        this.patientsosmedicationid = patientsosmedicationid;
    }

    public Patientsosmedication(Integer patientsosmedicationid, int createdby) {
        this.patientsosmedicationid = patientsosmedicationid;
        this.createdby = createdby;
    }

    public Integer getPatientsosmedicationid() {
        return patientsosmedicationid;
    }

    public void setPatientsosmedicationid(Integer patientsosmedicationid) {
        this.patientsosmedicationid = patientsosmedicationid;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTelephoneverbal() {
        return telephoneverbal;
    }

    public void setTelephoneverbal(String telephoneverbal) {
        this.telephoneverbal = telephoneverbal;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getAdministeredby() {
        return administeredby;
    }

    public void setAdministeredby(User administeredby) {
        this.administeredby = administeredby;
    }

    public User getOrderedbydoctor() {
        return orderedbydoctor;
    }

    public void setOrderedbydoctor(User orderedbydoctor) {
        this.orderedbydoctor = orderedbydoctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientsosmedicationid != null ? patientsosmedicationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientsosmedication)) {
            return false;
        }
        Patientsosmedication other = (Patientsosmedication) object;
        if ((this.patientsosmedicationid == null && other.patientsosmedicationid != null) || (this.patientsosmedicationid != null && !this.patientsosmedicationid.equals(other.patientsosmedicationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientsosmedication[ patientsosmedicationid=" + patientsosmedicationid + " ]";
    }
    
}
