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
@Table(name = "hourlyobservation")
@NamedQueries({
    @NamedQuery(name = "Hourlyobservation.findAll", query = "SELECT h FROM Hourlyobservation h")})
public class Hourlyobservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hourlyobservationid")
    private Integer hourlyobservationid;
    @Basic(optional = false)
    @Column(name = "timeslot")
    private int timeslot;
    @Column(name = "value")
    private Integer value;
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
    @JoinColumn(name = "vital", referencedColumnName = "vitalid")
    @ManyToOne(optional = false)
    private Vital vital;

    public Hourlyobservation() {
    }

    public Hourlyobservation(Integer hourlyobservationid) {
        this.hourlyobservationid = hourlyobservationid;
    }

    public Hourlyobservation(Integer hourlyobservationid, int timeslot, int createdby) {
        this.hourlyobservationid = hourlyobservationid;
        this.timeslot = timeslot;
        this.createdby = createdby;
    }

    public Integer getHourlyobservationid() {
        return hourlyobservationid;
    }

    public void setHourlyobservationid(Integer hourlyobservationid) {
        this.hourlyobservationid = hourlyobservationid;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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

    public Vital getVital() {
        return vital;
    }

    public void setVital(Vital vital) {
        this.vital = vital;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hourlyobservationid != null ? hourlyobservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hourlyobservation)) {
            return false;
        }
        Hourlyobservation other = (Hourlyobservation) object;
        if ((this.hourlyobservationid == null && other.hourlyobservationid != null) || (this.hourlyobservationid != null && !this.hourlyobservationid.equals(other.hourlyobservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Hourlyobservation[ hourlyobservationid=" + hourlyobservationid + " ]";
    }
    
}
