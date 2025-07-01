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
@Table(name = "rmonurselog")
@NamedQueries({
    @NamedQuery(name = "Rmonurselog.findAll", query = "SELECT r FROM Rmonurselog r"),
    @NamedQuery(name = "Rmonurselog.findByRmonurselogid", query = "SELECT r FROM Rmonurselog r WHERE r.rmonurselogid = :rmonurselogid"),
    @NamedQuery(name = "Rmonurselog.findByDatetime", query = "SELECT r FROM Rmonurselog r WHERE r.datetime = :datetime"),
        @NamedQuery(name = "Rmonurselog.findByPatientdaysheet", query = "SELECT r FROM Rmonurselog r WHERE r.patientdaysheet.patientdaysheetid = :patientdaysheetid ORDER BY r.rmonurselogid ASC LIMIT 3"),
    @NamedQuery(name = "Rmonurselog.findByCreatedby", query = "SELECT r FROM Rmonurselog r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "Rmonurselog.findByCreateddate", query = "SELECT r FROM Rmonurselog r WHERE r.createddate = :createddate"),
    @NamedQuery(name = "Rmonurselog.findByUpdatedby", query = "SELECT r FROM Rmonurselog r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "Rmonurselog.findByUpdateddate", query = "SELECT r FROM Rmonurselog r WHERE r.updateddate = :updateddate")})
public class Rmonurselog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rmonurselogid")
    private Integer rmonurselogid;
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
    @JoinColumn(name = "rmonurse", referencedColumnName = "userid")
    @ManyToOne
    private User rmonurse;

    public Rmonurselog() {
    }

    public Rmonurselog(Integer rmonurselogid) {
        this.rmonurselogid = rmonurselogid;
    }

    public Rmonurselog(Integer rmonurselogid, int createdby) {
        this.rmonurselogid = rmonurselogid;
        this.createdby = createdby;
    }

    public Integer getRmonurselogid() {
        return rmonurselogid;
    }

    public void setRmonurselogid(Integer rmonurselogid) {
        this.rmonurselogid = rmonurselogid;
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

    public User getRmonurse() {
        return rmonurse;
    }

    public void setRmonurse(User rmonurse) {
        this.rmonurse = rmonurse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmonurselogid != null ? rmonurselogid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rmonurselog)) {
            return false;
        }
        Rmonurselog other = (Rmonurselog) object;
        if ((this.rmonurselogid == null && other.rmonurselogid != null) || (this.rmonurselogid != null && !this.rmonurselogid.equals(other.rmonurselogid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Rmonurselog[ rmonurselogid=" + rmonurselogid + " ]";
    }
    
}
