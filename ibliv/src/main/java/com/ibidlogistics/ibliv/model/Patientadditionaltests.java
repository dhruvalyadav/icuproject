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
@Table(name = "patientadditionaltests")
@NamedQueries({
    @NamedQuery(name = "Patientadditionaltests.findAll", query = "SELECT p FROM Patientadditionaltests p")})
public class Patientadditionaltests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientadditionaltestsid")
    private Integer patientadditionaltestsid;
    @Column(name = "ambulation")
    private String ambulation;
    @Column(name = "incentivespirometry")
    private String incentivespirometry;
    @Column(name = "belt")
    private String belt;
    @Column(name = "dressing")
    private String dressing;
    @Column(name = "trachettsectretion")
    private String trachettsectretion;
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
    @JoinColumn(name = "patientdaysheet", referencedColumnName = "patientdaysheetid")
    @ManyToOne(optional = false)
    private Patientdaysheet patientdaysheet;
    @JoinColumn(name = "physiothearpy", referencedColumnName = "physiothearpyid")
    @ManyToOne(optional = false)
    private Physiothearpy physiothearpy;

    public Patientadditionaltests() {
    }

    public Patientadditionaltests(Integer patientadditionaltestsid) {
        this.patientadditionaltestsid = patientadditionaltestsid;
    }

    public Patientadditionaltests(Integer patientadditionaltestsid, int createdby) {
        this.patientadditionaltestsid = patientadditionaltestsid;
        this.createdby = createdby;
    }

    public Integer getPatientadditionaltestsid() {
        return patientadditionaltestsid;
    }

    public void setPatientadditionaltestsid(Integer patientadditionaltestsid) {
        this.patientadditionaltestsid = patientadditionaltestsid;
    }

    public String getAmbulation() {
        return ambulation;
    }

    public void setAmbulation(String ambulation) {
        this.ambulation = ambulation;
    }

    public String getIncentivespirometry() {
        return incentivespirometry;
    }

    public void setIncentivespirometry(String incentivespirometry) {
        this.incentivespirometry = incentivespirometry;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public String getTrachettsectretion() {
        return trachettsectretion;
    }

    public void setTrachettsectretion(String trachettsectretion) {
        this.trachettsectretion = trachettsectretion;
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

    public Patientdaysheet getPatientdaysheet() {
        return patientdaysheet;
    }

    public void setPatientdaysheet(Patientdaysheet patientdaysheet) {
        this.patientdaysheet = patientdaysheet;
    }

    public Physiothearpy getPhysiothearpy() {
        return physiothearpy;
    }

    public void setPhysiothearpy(Physiothearpy physiothearpy) {
        this.physiothearpy = physiothearpy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientadditionaltestsid != null ? patientadditionaltestsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientadditionaltests)) {
            return false;
        }
        Patientadditionaltests other = (Patientadditionaltests) object;
        if ((this.patientadditionaltestsid == null && other.patientadditionaltestsid != null) || (this.patientadditionaltestsid != null && !this.patientadditionaltestsid.equals(other.patientadditionaltestsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientadditionaltests[ patientadditionaltestsid=" + patientadditionaltestsid + " ]";
    }
    
}
