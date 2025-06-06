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
@Table(name = "patientlinestubes")
@NamedQueries({
    @NamedQuery(name = "Patientlinestubes.findAll", query = "SELECT p FROM Patientlinestubes p"),
    @NamedQuery(name = "Patientlinestubes.findByPatientlinestubesid", query = "SELECT p FROM Patientlinestubes p WHERE p.patientlinestubesid = :patientlinestubesid"),
    @NamedQuery(name = "Patientlinestubes.findByDateofinsertion", query = "SELECT p FROM Patientlinestubes p WHERE p.dateofinsertion = :dateofinsertion"),
    @NamedQuery(name = "Patientlinestubes.findBySite", query = "SELECT p FROM Patientlinestubes p WHERE p.site = :site"),
    @NamedQuery(name = "Patientlinestubes.findByCreatedby", query = "SELECT p FROM Patientlinestubes p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patientlinestubes.findByCreateddate", query = "SELECT p FROM Patientlinestubes p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patientlinestubes.findByUpdatedby", query = "SELECT p FROM Patientlinestubes p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Patientlinestubes.findByUpdateddate", query = "SELECT p FROM Patientlinestubes p WHERE p.updateddate = :updateddate")})
public class Patientlinestubes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientlinestubesid")
    private Integer patientlinestubesid;
    @Column(name = "dateofinsertion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofinsertion;
    @Column(name = "site")
    private String site;
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
    @JoinColumn(name = "linestubes", referencedColumnName = "linestubesid")
    @ManyToOne(optional = false)
    private Linestubes linestubes;
    @JoinColumn(name = "patientdaysheet", referencedColumnName = "patientdaysheetid")
    @ManyToOne(optional = false)
    private Patientdaysheet patientdaysheet;

    public Patientlinestubes() {
    }

    public Patientlinestubes(Integer patientlinestubesid) {
        this.patientlinestubesid = patientlinestubesid;
    }

    public Patientlinestubes(Integer patientlinestubesid, int createdby) {
        this.patientlinestubesid = patientlinestubesid;
        this.createdby = createdby;
    }

    public Integer getPatientlinestubesid() {
        return patientlinestubesid;
    }

    public void setPatientlinestubesid(Integer patientlinestubesid) {
        this.patientlinestubesid = patientlinestubesid;
    }

    public Date getDateofinsertion() {
        return dateofinsertion;
    }

    public void setDateofinsertion(Date dateofinsertion) {
        this.dateofinsertion = dateofinsertion;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public Linestubes getLinestubes() {
        return linestubes;
    }

    public void setLinestubes(Linestubes linestubes) {
        this.linestubes = linestubes;
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
        hash += (patientlinestubesid != null ? patientlinestubesid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientlinestubes)) {
            return false;
        }
        Patientlinestubes other = (Patientlinestubes) object;
        if ((this.patientlinestubesid == null && other.patientlinestubesid != null) || (this.patientlinestubesid != null && !this.patientlinestubesid.equals(other.patientlinestubesid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientlinestubes[ patientlinestubesid=" + patientlinestubesid + " ]";
    }
    
}
