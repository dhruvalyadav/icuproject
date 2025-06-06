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
@Table(name = "applicationversion")
@NamedQueries({
    @NamedQuery(name = "Applicationversion.findAll", query = "SELECT a FROM Applicationversion a"),
    @NamedQuery(name = "Applicationversion.findByVersionid", query = "SELECT a FROM Applicationversion a WHERE a.versionid = :versionid"),
    @NamedQuery(name = "Applicationversion.findByVersionnumber", query = "SELECT a FROM Applicationversion a WHERE a.versionnumber = :versionnumber"),
    @NamedQuery(name = "Applicationversion.findByActive", query = "SELECT a FROM Applicationversion a WHERE a.active = :active"),
    @NamedQuery(name = "Applicationversion.findByCreatedby", query = "SELECT a FROM Applicationversion a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Applicationversion.findByCreateddate", query = "SELECT a FROM Applicationversion a WHERE a.createddate = :createddate"),
    @NamedQuery(name = "Applicationversion.findByUpdatedby", query = "SELECT a FROM Applicationversion a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "Applicationversion.findByUpdateddate", query = "SELECT a FROM Applicationversion a WHERE a.updateddate = :updateddate")})
public class Applicationversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "versionid")
    private Integer versionid;
    @Column(name = "versionnumber")
    private String versionnumber;
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

    public Applicationversion() {
    }

    public Applicationversion(Integer versionid) {
        this.versionid = versionid;
    }

    public Applicationversion(Integer versionid, int createdby) {
        this.versionid = versionid;
        this.createdby = createdby;
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }

    public String getVersionnumber() {
        return versionnumber;
    }

    public void setVersionnumber(String versionnumber) {
        this.versionnumber = versionnumber;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (versionid != null ? versionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicationversion)) {
            return false;
        }
        Applicationversion other = (Applicationversion) object;
        if ((this.versionid == null && other.versionid != null) || (this.versionid != null && !this.versionid.equals(other.versionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Applicationversion[ versionid=" + versionid + " ]";
    }
    
}
