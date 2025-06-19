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
@Table(name = "ivfluid")
@NamedQueries({
    @NamedQuery(name = "Ivfluid.findAll", query = "SELECT i FROM Ivfluid i"),
    @NamedQuery(name = "Ivfluid.findAllOrderBy", query = "SELECT i FROM Ivfluid i ORDER BY i.ivfluidname ASC"),
    @NamedQuery(name = "Ivfluid.findByIvfluidid", query = "SELECT i FROM Ivfluid i WHERE i.ivfluidid = :ivfluidid"),
    @NamedQuery(name = "Ivfluid.findByIvfluidname", query = "SELECT i FROM Ivfluid i WHERE i.ivfluidname = :ivfluidname"),
    @NamedQuery(name = "Ivfluid.findByActive", query = "SELECT i FROM Ivfluid i WHERE i.active = :active"),
    @NamedQuery(name = "Ivfluid.findByCreatedby", query = "SELECT i FROM Ivfluid i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "Ivfluid.findByCreateddate", query = "SELECT i FROM Ivfluid i WHERE i.createddate = :createddate"),
    @NamedQuery(name = "Ivfluid.findByUpdatedby", query = "SELECT i FROM Ivfluid i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "Ivfluid.findByUpdateddate", query = "SELECT i FROM Ivfluid i WHERE i.updateddate = :updateddate")})
public class Ivfluid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ivfluidid")
    private Integer ivfluidid;
    @Basic(optional = false)
    @Column(name = "ivfluidname")
    private int ivfluidname;
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
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "ivfluid")
    private List<Patientivfluid> patientivfluidList;*/

    public Ivfluid() {
    }

    public Ivfluid(Integer ivfluidid) {
        this.ivfluidid = ivfluidid;
    }

    public Ivfluid(Integer ivfluidid, int ivfluidname, int createdby) {
        this.ivfluidid = ivfluidid;
        this.ivfluidname = ivfluidname;
        this.createdby = createdby;
    }

    public Integer getIvfluidid() {
        return ivfluidid;
    }

    public void setIvfluidid(Integer ivfluidid) {
        this.ivfluidid = ivfluidid;
    }

    public int getIvfluidname() {
        return ivfluidname;
    }

    public void setIvfluidname(int ivfluidname) {
        this.ivfluidname = ivfluidname;
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

    /*public List<Patientivfluid> getPatientivfluidList() {
        return patientivfluidList;
    }

    public void setPatientivfluidList(List<Patientivfluid> patientivfluidList) {
        this.patientivfluidList = patientivfluidList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ivfluidid != null ? ivfluidid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ivfluid)) {
            return false;
        }
        Ivfluid other = (Ivfluid) object;
        if ((this.ivfluidid == null && other.ivfluidid != null) || (this.ivfluidid != null && !this.ivfluidid.equals(other.ivfluidid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Ivfluid[ ivfluidid=" + ivfluidid + " ]";
    }
    
}
