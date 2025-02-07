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
@Table(name = "embolism")
@NamedQueries({
    @NamedQuery(name = "Embolism.findAll", query = "SELECT e FROM Embolism e")})
public class Embolism implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "embolismid")
    private Integer embolismid;
    @Column(name = "dvtrisk")
    private String dvtrisk;
    @Column(name = "anticoagulation")
    private String anticoagulation;
    @Column(name = "compression")
    private String compression;
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

    public Embolism() {
    }

    public Embolism(Integer embolismid) {
        this.embolismid = embolismid;
    }

    public Embolism(Integer embolismid, int createdby) {
        this.embolismid = embolismid;
        this.createdby = createdby;
    }

    public Integer getEmbolismid() {
        return embolismid;
    }

    public void setEmbolismid(Integer embolismid) {
        this.embolismid = embolismid;
    }

    public String getDvtrisk() {
        return dvtrisk;
    }

    public void setDvtrisk(String dvtrisk) {
        this.dvtrisk = dvtrisk;
    }

    public String getAnticoagulation() {
        return anticoagulation;
    }

    public void setAnticoagulation(String anticoagulation) {
        this.anticoagulation = anticoagulation;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (embolismid != null ? embolismid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Embolism)) {
            return false;
        }
        Embolism other = (Embolism) object;
        if ((this.embolismid == null && other.embolismid != null) || (this.embolismid != null && !this.embolismid.equals(other.embolismid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Embolism[ embolismid=" + embolismid + " ]";
    }
    
}
