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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "patientmedicationchart")
@NamedQueries({
    @NamedQuery(name = "Patientmedicationchart.findAll", query = "SELECT p FROM Patientmedicationchart p"),
    @NamedQuery(name = "Patientmedicationchart.findByPatientmedicationchartid", query = "SELECT p FROM Patientmedicationchart p WHERE p.patientmedicationchartid = :patientmedicationchartid"),
    @NamedQuery(name = "Patientmedicationchart.findByDrug", query = "SELECT p FROM Patientmedicationchart p WHERE p.drug = :drug"),
    @NamedQuery(name = "Patientmedicationchart.findByDate", query = "SELECT p FROM Patientmedicationchart p WHERE p.date = :date"),
    @NamedQuery(name = "Patientmedicationchart.findByDose", query = "SELECT p FROM Patientmedicationchart p WHERE p.dose = :dose"),
    @NamedQuery(name = "Patientmedicationchart.findByRoute", query = "SELECT p FROM Patientmedicationchart p WHERE p.route = :route"),
    @NamedQuery(name = "Patientmedicationchart.findByFrequency", query = "SELECT p FROM Patientmedicationchart p WHERE p.frequency = :frequency"),
    @NamedQuery(name = "Patientmedicationchart.findByCreatedby", query = "SELECT p FROM Patientmedicationchart p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patientmedicationchart.findByCreateddate", query = "SELECT p FROM Patientmedicationchart p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patientmedicationchart.findByUpdatedby", query = "SELECT p FROM Patientmedicationchart p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Patientmedicationchart.findByUpdateddate", query = "SELECT p FROM Patientmedicationchart p WHERE p.updateddate = :updateddate")})
public class Patientmedicationchart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientmedicationchartid")
    private Integer patientmedicationchartid;
    @Column(name = "drug")
    private String drug;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "dose")
    private String dose;
    @Column(name = "route")
    private String route;
    @Column(name = "frequency")
    private String frequency;
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
    @JoinColumn(name = "patientadmission", referencedColumnName = "patientadmissionid")
    @ManyToOne(optional = false)
    private Patientadmission patientadmission;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientmedicationchart")
    private List<Patientmedicationlog> patientmedicationlogList;

    public Patientmedicationchart() {
    }

    public Patientmedicationchart(Integer patientmedicationchartid) {
        this.patientmedicationchartid = patientmedicationchartid;
    }

    public Patientmedicationchart(Integer patientmedicationchartid, int createdby) {
        this.patientmedicationchartid = patientmedicationchartid;
        this.createdby = createdby;
    }

    public Integer getPatientmedicationchartid() {
        return patientmedicationchartid;
    }

    public void setPatientmedicationchartid(Integer patientmedicationchartid) {
        this.patientmedicationchartid = patientmedicationchartid;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
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

    public Patientadmission getPatientadmission() {
        return patientadmission;
    }

    public void setPatientadmission(Patientadmission patientadmission) {
        this.patientadmission = patientadmission;
    }

    public List<Patientmedicationlog> getPatientmedicationlogList() {
        return patientmedicationlogList;
    }

    public void setPatientmedicationlogList(List<Patientmedicationlog> patientmedicationlogList) {
        this.patientmedicationlogList = patientmedicationlogList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientmedicationchartid != null ? patientmedicationchartid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientmedicationchart)) {
            return false;
        }
        Patientmedicationchart other = (Patientmedicationchart) object;
        if ((this.patientmedicationchartid == null && other.patientmedicationchartid != null) || (this.patientmedicationchartid != null && !this.patientmedicationchartid.equals(other.patientmedicationchartid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientmedicationchart[ patientmedicationchartid=" + patientmedicationchartid + " ]";
    }
    
}
