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
@Table(name = "patientivfluid")
@NamedQueries({
    @NamedQuery(name = "Patientivfluid.findAll", query = "SELECT p FROM Patientivfluid p"),
    @NamedQuery(name = "Patientivfluid.findByPatientivfluidid", query = "SELECT p FROM Patientivfluid p WHERE p.patientivfluidid = :patientivfluidid"),
    @NamedQuery(name = "Patientivfluid.findByRate", query = "SELECT p FROM Patientivfluid p WHERE p.rate = :rate"),
    @NamedQuery(name = "Patientivfluid.findByPatientANDCreatedate", query = "SELECT p FROM Patientivfluid p WHERE p.createddate = :createddate AND p.patient.patientid = :patientid ORDER BY p.patientivfluidid ASC"),
    @NamedQuery(name = "Patientivfluid.findByAdditionaldrugs", query = "SELECT p FROM Patientivfluid p WHERE p.additionaldrugs = :additionaldrugs"),
    @NamedQuery(name = "Patientivfluid.findByCreatedby", query = "SELECT p FROM Patientivfluid p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patientivfluid.findByCreateddate", query = "SELECT p FROM Patientivfluid p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patientivfluid.findByUpdatedby", query = "SELECT p FROM Patientivfluid p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Patientivfluid.findByUpdateddate", query = "SELECT p FROM Patientivfluid p WHERE p.updateddate = :updateddate")})
public class Patientivfluid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientivfluidid")
    private Integer patientivfluidid;
    @Column(name = "rate")
    private String rate;
    @Column(name = "additionaldrugs")
    private String additionaldrugs;
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
    @JoinColumn(name = "ivfluid", referencedColumnName = "ivfluidid")
    @ManyToOne(optional = false)
    private Ivfluid ivfluid;
    @JoinColumn(name = "patient", referencedColumnName = "patientid")
    @ManyToOne(optional = false)
    private Patient patient;

    public Patientivfluid() {
    }

    public Patientivfluid(Integer patientivfluidid) {
        this.patientivfluidid = patientivfluidid;
    }

    public Patientivfluid(Integer patientivfluidid, int createdby) {
        this.patientivfluidid = patientivfluidid;
        this.createdby = createdby;
    }

    public Integer getPatientivfluidid() {
        return patientivfluidid;
    }

    public void setPatientivfluidid(Integer patientivfluidid) {
        this.patientivfluidid = patientivfluidid;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAdditionaldrugs() {
        return additionaldrugs;
    }

    public void setAdditionaldrugs(String additionaldrugs) {
        this.additionaldrugs = additionaldrugs;
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

    public Ivfluid getIvfluid() {
        return ivfluid;
    }

    public void setIvfluid(Ivfluid ivfluid) {
        this.ivfluid = ivfluid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientivfluidid != null ? patientivfluidid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientivfluid)) {
            return false;
        }
        Patientivfluid other = (Patientivfluid) object;
        if ((this.patientivfluidid == null && other.patientivfluidid != null) || (this.patientivfluidid != null && !this.patientivfluidid.equals(other.patientivfluidid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientivfluid[ patientivfluidid=" + patientivfluidid + " ]";
    }
    
}
