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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Laptop
 */
@Entity
@Table(name = "ventilatormode")
@NamedQueries({
    @NamedQuery(name = "Ventilatormode.findAll", query = "SELECT v FROM Ventilatormode v")})
public class Ventilatormode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ventilatormodeid")
    private Integer ventilatormodeid;
    @Column(name = "ventilatormode")
    private String ventilatormode;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventilatormode")
    private List<Patientventilator> patientventilatorList;

    public Ventilatormode() {
    }

    public Ventilatormode(Integer ventilatormodeid) {
        this.ventilatormodeid = ventilatormodeid;
    }

    public Ventilatormode(Integer ventilatormodeid, int createdby) {
        this.ventilatormodeid = ventilatormodeid;
        this.createdby = createdby;
    }

    public Integer getVentilatormodeid() {
        return ventilatormodeid;
    }

    public void setVentilatormodeid(Integer ventilatormodeid) {
        this.ventilatormodeid = ventilatormodeid;
    }

    public String getVentilatormode() {
        return ventilatormode;
    }

    public void setVentilatormode(String ventilatormode) {
        this.ventilatormode = ventilatormode;
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

    public List<Patientventilator> getPatientventilatorList() {
        return patientventilatorList;
    }

    public void setPatientventilatorList(List<Patientventilator> patientventilatorList) {
//        this.patientventilatorList = patientventilatorList;
        if (this.patientventilatorList == null)
        {
            this.patientventilatorList = new ArrayList<>();
        }
        if (patientventilatorList != null)
        {
            this.patientventilatorList.clear();
            this.patientventilatorList.addAll(patientventilatorList);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventilatormodeid != null ? ventilatormodeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventilatormode)) {
            return false;
        }
        Ventilatormode other = (Ventilatormode) object;
        if ((this.ventilatormodeid == null && other.ventilatormodeid != null) || (this.ventilatormodeid != null && !this.ventilatormodeid.equals(other.ventilatormodeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Ventilatormode[ ventilatormodeid=" + ventilatormodeid + " ]";
    }
    
}
