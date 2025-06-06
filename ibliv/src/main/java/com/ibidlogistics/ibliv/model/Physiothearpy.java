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
@Table(name = "physiothearpy")
@NamedQueries({
    @NamedQuery(name = "Physiothearpy.findAll", query = "SELECT p FROM Physiothearpy p"),
    @NamedQuery(name = "Physiothearpy.findByPhysiothearpyid", query = "SELECT p FROM Physiothearpy p WHERE p.physiothearpyid = :physiothearpyid"),
    @NamedQuery(name = "Physiothearpy.findByPhysiothearpy", query = "SELECT p FROM Physiothearpy p WHERE p.physiothearpy = :physiothearpy"),
    @NamedQuery(name = "Physiothearpy.findByCreatedby", query = "SELECT p FROM Physiothearpy p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Physiothearpy.findByCreateddate", query = "SELECT p FROM Physiothearpy p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Physiothearpy.findByUpdatedby", query = "SELECT p FROM Physiothearpy p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Physiothearpy.findByUpdateddate", query = "SELECT p FROM Physiothearpy p WHERE p.updateddate = :updateddate")})
public class Physiothearpy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "physiothearpyid")
    private Integer physiothearpyid;
    @Basic(optional = false)
    @Column(name = "physiothearpy")
    private String physiothearpy;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "physiothearpy")
    private List<Patientadditionaltests> patientadditionaltestsList;

    public Physiothearpy() {
    }

    public Physiothearpy(Integer physiothearpyid) {
        this.physiothearpyid = physiothearpyid;
    }

    public Physiothearpy(Integer physiothearpyid, String physiothearpy, int createdby) {
        this.physiothearpyid = physiothearpyid;
        this.physiothearpy = physiothearpy;
        this.createdby = createdby;
    }

    public Integer getPhysiothearpyid() {
        return physiothearpyid;
    }

    public void setPhysiothearpyid(Integer physiothearpyid) {
        this.physiothearpyid = physiothearpyid;
    }

    public String getPhysiothearpy() {
        return physiothearpy;
    }

    public void setPhysiothearpy(String physiothearpy) {
        this.physiothearpy = physiothearpy;
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

    public List<Patientadditionaltests> getPatientadditionaltestsList() {
        return patientadditionaltestsList;
    }

    public void setPatientadditionaltestsList(List<Patientadditionaltests> patientadditionaltestsList) {
        this.patientadditionaltestsList = patientadditionaltestsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (physiothearpyid != null ? physiothearpyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Physiothearpy)) {
            return false;
        }
        Physiothearpy other = (Physiothearpy) object;
        if ((this.physiothearpyid == null && other.physiothearpyid != null) || (this.physiothearpyid != null && !this.physiothearpyid.equals(other.physiothearpyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Physiothearpy[ physiothearpyid=" + physiothearpyid + " ]";
    }
    
}
