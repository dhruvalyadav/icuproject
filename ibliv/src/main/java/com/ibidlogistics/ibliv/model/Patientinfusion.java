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
@Table(name = "patientinfusion")
@NamedQueries({
    @NamedQuery(name = "Patientinfusion.findAll", query = "SELECT p FROM Patientinfusion p"),
    @NamedQuery(name = "Patientinfusion.findByPatientinfusionid", query = "SELECT p FROM Patientinfusion p WHERE p.patientinfusionid = :patientinfusionid"),
    @NamedQuery(name = "Patientinfusion.findByTime", query = "SELECT p FROM Patientinfusion p WHERE p.time = :time"),
    @NamedQuery(name = "Patientinfusion.findByFluidname", query = "SELECT p FROM Patientinfusion p WHERE p.fluidname = :fluidname"),
    @NamedQuery(name = "Patientinfusion.findByFluidvolume", query = "SELECT p FROM Patientinfusion p WHERE p.fluidvolume = :fluidvolume"),
    @NamedQuery(name = "Patientinfusion.findByIvmedication", query = "SELECT p FROM Patientinfusion p WHERE p.ivmedication = :ivmedication"),
    @NamedQuery(name = "Patientinfusion.findByDose", query = "SELECT p FROM Patientinfusion p WHERE p.dose = :dose"),
    @NamedQuery(name = "Patientinfusion.findByRate", query = "SELECT p FROM Patientinfusion p WHERE p.rate = :rate"),
    @NamedQuery(name = "Patientinfusion.findByStarttime", query = "SELECT p FROM Patientinfusion p WHERE p.starttime = :starttime"),
    @NamedQuery(name = "Patientinfusion.findByEndtime", query = "SELECT p FROM Patientinfusion p WHERE p.endtime = :endtime"),
    @NamedQuery(name = "Patientinfusion.findByCreatedby", query = "SELECT p FROM Patientinfusion p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patientinfusion.findByCreateddate", query = "SELECT p FROM Patientinfusion p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patientinfusion.findByUpdatedby", query = "SELECT p FROM Patientinfusion p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Patientinfusion.findByUpdateddate", query = "SELECT p FROM Patientinfusion p WHERE p.updateddate = :updateddate")})
public class Patientinfusion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientinfusionid")
    private Integer patientinfusionid;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "fluidname")
    private String fluidname;
    @Column(name = "fluidvolume")
    private String fluidvolume;
    @Column(name = "ivmedication")
    private String ivmedication;
    @Column(name = "dose")
    private String dose;
    @Column(name = "rate")
    private String rate;
    @Column(name = "starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
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
    @JoinColumn(name = "preparedby", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User preparedby;

    public Patientinfusion() {
    }

    public Patientinfusion(Integer patientinfusionid) {
        this.patientinfusionid = patientinfusionid;
    }

    public Patientinfusion(Integer patientinfusionid, int createdby) {
        this.patientinfusionid = patientinfusionid;
        this.createdby = createdby;
    }

    public Integer getPatientinfusionid() {
        return patientinfusionid;
    }

    public void setPatientinfusionid(Integer patientinfusionid) {
        this.patientinfusionid = patientinfusionid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFluidname() {
        return fluidname;
    }

    public void setFluidname(String fluidname) {
        this.fluidname = fluidname;
    }

    public String getFluidvolume() {
        return fluidvolume;
    }

    public void setFluidvolume(String fluidvolume) {
        this.fluidvolume = fluidvolume;
    }

    public String getIvmedication() {
        return ivmedication;
    }

    public void setIvmedication(String ivmedication) {
        this.ivmedication = ivmedication;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    public User getPreparedby() {
        return preparedby;
    }

    public void setPreparedby(User preparedby) {
        this.preparedby = preparedby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientinfusionid != null ? patientinfusionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientinfusion)) {
            return false;
        }
        Patientinfusion other = (Patientinfusion) object;
        if ((this.patientinfusionid == null && other.patientinfusionid != null) || (this.patientinfusionid != null && !this.patientinfusionid.equals(other.patientinfusionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientinfusion[ patientinfusionid=" + patientinfusionid + " ]";
    }
    
}
