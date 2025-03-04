/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "icu")
@NamedQueries({
    @NamedQuery(name = "Icu.findAll", query = "SELECT i FROM Icu i")})
public class Icu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "icuid")
    private Integer icuid;
    @Column(name = "name")
    private String name;
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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "icu")
    private List<Patientadmission> patientadmissionList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "icu")
    private List<Shiftrmonurse> shiftrmonurseList;

    public Icu() {
    }

    public Icu(Integer icuid) {
        this.icuid = icuid;
    }

    public Icu(Integer icuid, int createdby) {
        this.icuid = icuid;
        this.createdby = createdby;
    }

    public Integer getIcuid() {
        return icuid;
    }

    public void setIcuid(Integer icuid) {
        this.icuid = icuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Patientadmission> getPatientadmissionList() {
        return patientadmissionList;
    }

    public void setPatientadmissionList(List<Patientadmission> patientadmissionList) {
//        this.patientadmissionList = patientadmissionList;
        if(this.patientadmissionList==null) this.patientadmissionList=new ArrayList<>();
        if(patientadmissionList!=null)
        {
            this.patientadmissionList.clear();
            this.patientadmissionList.addAll(patientadmissionList);
        }
    }

    public List<Shiftrmonurse> getShiftrmonurseList() {
        return shiftrmonurseList;
    }

    public void setShiftrmonurseList(List<Shiftrmonurse> shiftrmonurseList) {
//        this.shiftrmonurseList = shiftrmonurseList;
        if(this.shiftrmonurseList==null) this.shiftrmonurseList=new ArrayList<>();
        if(shiftrmonurseList!=null)
        {
            this.shiftrmonurseList.clear();
            this.shiftrmonurseList.addAll(shiftrmonurseList);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (icuid != null ? icuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Icu)) {
            return false;
        }
        Icu other = (Icu) object;
        if ((this.icuid == null && other.icuid != null) || (this.icuid != null && !this.icuid.equals(other.icuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Icu[ icuid=" + icuid + " ]";
    }
    
}
