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
@Table(name = "linestubes")
@NamedQueries({
    @NamedQuery(name = "Linestubes.findAll", query = "SELECT l FROM Linestubes l"),
    @NamedQuery(name = "Linestubes.findByLinestubesid", query = "SELECT l FROM Linestubes l WHERE l.linestubesid = :linestubesid"),
    @NamedQuery(name = "Linestubes.findByLinestubesname", query = "SELECT l FROM Linestubes l WHERE l.linestubesname = :linestubesname"),
    @NamedQuery(name = "Linestubes.findByActive", query = "SELECT l FROM Linestubes l WHERE l.active = :active"),
    @NamedQuery(name = "Linestubes.findByCreatedby", query = "SELECT l FROM Linestubes l WHERE l.createdby = :createdby"),
    @NamedQuery(name = "Linestubes.findByCreateddate", query = "SELECT l FROM Linestubes l WHERE l.createddate = :createddate"),
    @NamedQuery(name = "Linestubes.findByUpdatedby", query = "SELECT l FROM Linestubes l WHERE l.updatedby = :updatedby"),
    @NamedQuery(name = "Linestubes.findByUpdateddate", query = "SELECT l FROM Linestubes l WHERE l.updateddate = :updateddate")})
public class Linestubes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "linestubesid")
    private Integer linestubesid;
    @Basic(optional = false)
    @Column(name = "linestubesname")
    private int linestubesname;
    @Column(name = "active")
    private Integer active;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "linestubes")
    private List<Patientlinestubes> patientlinestubesList;

    public Linestubes() {
    }

    public Linestubes(Integer linestubesid) {
        this.linestubesid = linestubesid;
    }

    public Linestubes(Integer linestubesid, int linestubesname, int createdby) {
        this.linestubesid = linestubesid;
        this.linestubesname = linestubesname;
        this.createdby = createdby;
    }

    public Integer getLinestubesid() {
        return linestubesid;
    }

    public void setLinestubesid(Integer linestubesid) {
        this.linestubesid = linestubesid;
    }

    public int getLinestubesname() {
        return linestubesname;
    }

    public void setLinestubesname(int linestubesname) {
        this.linestubesname = linestubesname;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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

    public List<Patientlinestubes> getPatientlinestubesList() {
        return patientlinestubesList;
    }

    public void setPatientlinestubesList(List<Patientlinestubes> patientlinestubesList) {
        this.patientlinestubesList = patientlinestubesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linestubesid != null ? linestubesid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linestubes)) {
            return false;
        }
        Linestubes other = (Linestubes) object;
        if ((this.linestubesid == null && other.linestubesid != null) || (this.linestubesid != null && !this.linestubesid.equals(other.linestubesid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Linestubes[ linestubesid=" + linestubesid + " ]";
    }
    
}
