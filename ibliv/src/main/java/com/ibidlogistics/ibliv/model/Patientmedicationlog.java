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
 * @author Laptop
 */
@Entity
@Table(name = "patientmedicationlog")
@NamedQueries({
    @NamedQuery(name = "Patientmedicationlog.findAll", query = "SELECT p FROM Patientmedicationlog p")})
public class Patientmedicationlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientmedicationlogid")
    private Integer patientmedicationlogid;
    @Column(name = "drug")
    private String drug;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "dose")
    private String dose;
    @Column(name = "route")
    private String route;
    @Column(name = "Administrationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date administrationtime;
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
    @JoinColumn(name = "patientmedicationchart", referencedColumnName = "patientmedicationchartid")
    @ManyToOne(optional = false)
    private Patientmedicationchart patientmedicationchart;
    @JoinColumn(name = "administeredby", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User administeredby;

    public Patientmedicationlog() {
    }

    public Patientmedicationlog(Integer patientmedicationlogid) {
        this.patientmedicationlogid = patientmedicationlogid;
    }

    public Patientmedicationlog(Integer patientmedicationlogid, int createdby) {
        this.patientmedicationlogid = patientmedicationlogid;
        this.createdby = createdby;
    }

    public Integer getPatientmedicationlogid() {
        return patientmedicationlogid;
    }

    public void setPatientmedicationlogid(Integer patientmedicationlogid) {
        this.patientmedicationlogid = patientmedicationlogid;
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

    public Date getAdministrationtime() {
        return administrationtime;
    }

    public void setAdministrationtime(Date administrationtime) {
        this.administrationtime = administrationtime;
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

    public Patientmedicationchart getPatientmedicationchart() {
        return patientmedicationchart;
    }

    public void setPatientmedicationchart(Patientmedicationchart patientmedicationchart) {
        this.patientmedicationchart = patientmedicationchart;
    }

    public User getAdministeredby() {
        return administeredby;
    }

    public void setAdministeredby(User administeredby) {
        this.administeredby = administeredby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientmedicationlogid != null ? patientmedicationlogid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientmedicationlog)) {
            return false;
        }
        Patientmedicationlog other = (Patientmedicationlog) object;
        if ((this.patientmedicationlogid == null && other.patientmedicationlogid != null) || (this.patientmedicationlogid != null && !this.patientmedicationlogid.equals(other.patientmedicationlogid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientmedicationlog[ patientmedicationlogid=" + patientmedicationlogid + " ]";
    }
    
}
