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
@Table(name = "consultantpatientvisit")
@NamedQueries({
    @NamedQuery(name = "Consultantpatientvisit.findAll", query = "SELECT c FROM Consultantpatientvisit c"),
    @NamedQuery(name = "Consultantpatientvisit.findByConsultantpatientvisitid", query = "SELECT c FROM Consultantpatientvisit c WHERE c.consultantpatientvisitid = :consultantpatientvisitid"),
    @NamedQuery(name = "Consultantpatientvisit.findByDatetime", query = "SELECT c FROM Consultantpatientvisit c WHERE c.datetime = :datetime"),
    @NamedQuery(name = "Consultantpatientvisit.findByCreatedby", query = "SELECT c FROM Consultantpatientvisit c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "Consultantpatientvisit.findByCreateddate", query = "SELECT c FROM Consultantpatientvisit c WHERE c.createddate = :createddate"),
    @NamedQuery(name = "Consultantpatientvisit.findByUpdatedby", query = "SELECT c FROM Consultantpatientvisit c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "Consultantpatientvisit.findByUpdateddate", query = "SELECT c FROM Consultantpatientvisit c WHERE c.updateddate = :updateddate")})
public class Consultantpatientvisit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consultantpatientvisitid")
    private Integer consultantpatientvisitid;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
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
    @JoinColumn(name = "doctor", referencedColumnName = "userid")
    @ManyToOne
    private User doctor;

    public Consultantpatientvisit() {
    }

    public Consultantpatientvisit(Integer consultantpatientvisitid) {
        this.consultantpatientvisitid = consultantpatientvisitid;
    }

    public Consultantpatientvisit(Integer consultantpatientvisitid, int createdby) {
        this.consultantpatientvisitid = consultantpatientvisitid;
        this.createdby = createdby;
    }

    public Integer getConsultantpatientvisitid() {
        return consultantpatientvisitid;
    }

    public void setConsultantpatientvisitid(Integer consultantpatientvisitid) {
        this.consultantpatientvisitid = consultantpatientvisitid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultantpatientvisitid != null ? consultantpatientvisitid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultantpatientvisit)) {
            return false;
        }
        Consultantpatientvisit other = (Consultantpatientvisit) object;
        if ((this.consultantpatientvisitid == null && other.consultantpatientvisitid != null) || (this.consultantpatientvisitid != null && !this.consultantpatientvisitid.equals(other.consultantpatientvisitid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Consultantpatientvisit[ consultantpatientvisitid=" + consultantpatientvisitid + " ]";
    }
    
}
