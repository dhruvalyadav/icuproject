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
@Table(name = "vital")
@NamedQueries({
    @NamedQuery(name = "Vital.findAll", query = "SELECT v FROM Vital v"),
    @NamedQuery(name = "Vital.findByVitalid", query = "SELECT v FROM Vital v WHERE v.vitalid = :vitalid"),
    @NamedQuery(name = "Vital.findByVitalname", query = "SELECT v FROM Vital v WHERE v.vitalname = :vitalname"),
    @NamedQuery(name = "Vital.findByVitalcategory", query = "SELECT v FROM Vital v WHERE v.vitalcategory = :vitalcategory"),
    @NamedQuery(name = "Vital.findByActive", query = "SELECT v FROM Vital v WHERE v.active = :active"),
    @NamedQuery(name = "Vital.findByCategorysortorder", query = "SELECT v FROM Vital v WHERE v.categorysortorder = :categorysortorder"),
    @NamedQuery(name = "Vital.findBySortorder", query = "SELECT v FROM Vital v WHERE v.sortorder = :sortorder"),
    @NamedQuery(name = "Vital.findByCreatedby", query = "SELECT v FROM Vital v WHERE v.createdby = :createdby"),
    @NamedQuery(name = "Vital.findByCreateddate", query = "SELECT v FROM Vital v WHERE v.createddate = :createddate"),
    @NamedQuery(name = "Vital.findByUpdatedby", query = "SELECT v FROM Vital v WHERE v.updatedby = :updatedby"),
    @NamedQuery(name = "Vital.findByUpdateddate", query = "SELECT v FROM Vital v WHERE v.updateddate = :updateddate")})
public class Vital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vitalid")
    private Integer vitalid;
    @Column(name = "vitalname")
    private String vitalname;
    @Column(name = "vitalcategory")
    private String vitalcategory;
    @Column(name = "active")
    private Integer active;
    @Column(name = "categorysortorder")
    private Integer categorysortorder;
    @Column(name = "sortorder")
    private Integer sortorder;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vital")
    private List<Hourlyobservation> hourlyobservationList;

    public Vital() {
    }

    public Vital(Integer vitalid) {
        this.vitalid = vitalid;
    }

    public Vital(Integer vitalid, int createdby) {
        this.vitalid = vitalid;
        this.createdby = createdby;
    }

    public Integer getVitalid() {
        return vitalid;
    }

    public void setVitalid(Integer vitalid) {
        this.vitalid = vitalid;
    }

    public String getVitalname() {
        return vitalname;
    }

    public void setVitalname(String vitalname) {
        this.vitalname = vitalname;
    }

    public String getVitalcategory() {
        return vitalcategory;
    }

    public void setVitalcategory(String vitalcategory) {
        this.vitalcategory = vitalcategory;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCategorysortorder() {
        return categorysortorder;
    }

    public void setCategorysortorder(Integer categorysortorder) {
        this.categorysortorder = categorysortorder;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
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

    public List<Hourlyobservation> getHourlyobservationList() {
        return hourlyobservationList;
    }

    public void setHourlyobservationList(List<Hourlyobservation> hourlyobservationList) {
        this.hourlyobservationList = hourlyobservationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vitalid != null ? vitalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vital)) {
            return false;
        }
        Vital other = (Vital) object;
        if ((this.vitalid == null && other.vitalid != null) || (this.vitalid != null && !this.vitalid.equals(other.vitalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Vital[ vitalid=" + vitalid + " ]";
    }
    
}
