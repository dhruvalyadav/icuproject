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
 * @author Laptop
 */
@Entity
@Table(name = "shiftrmonurse")
@NamedQueries({
    @NamedQuery(name = "Shiftrmonurse.findAll", query = "SELECT s FROM Shiftrmonurse s")})
public class Shiftrmonurse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shiftrmonurseid")
    private Integer shiftrmonurseid;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "shift")
    private int shift;
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
    @JoinColumn(name = "icu", referencedColumnName = "icuid")
    @ManyToOne(optional = false)
    private Icu icu;
    @JoinColumn(name = "rmo", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User rmo;
    @JoinColumn(name = "nurse", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User nurse;

    public Shiftrmonurse() {
    }

    public Shiftrmonurse(Integer shiftrmonurseid) {
        this.shiftrmonurseid = shiftrmonurseid;
    }

    public Shiftrmonurse(Integer shiftrmonurseid, int shift, int createdby) {
        this.shiftrmonurseid = shiftrmonurseid;
        this.shift = shift;
        this.createdby = createdby;
    }

    public Integer getShiftrmonurseid() {
        return shiftrmonurseid;
    }

    public void setShiftrmonurseid(Integer shiftrmonurseid) {
        this.shiftrmonurseid = shiftrmonurseid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
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

    public Icu getIcu() {
        return icu;
    }

    public void setIcu(Icu icu) {
        this.icu = icu;
    }

    public User getRmo() {
        return rmo;
    }

    public void setRmo(User rmo) {
        this.rmo = rmo;
    }

    public User getNurse() {
        return nurse;
    }

    public void setNurse(User nurse) {
        this.nurse = nurse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftrmonurseid != null ? shiftrmonurseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shiftrmonurse)) {
            return false;
        }
        Shiftrmonurse other = (Shiftrmonurse) object;
        if ((this.shiftrmonurseid == null && other.shiftrmonurseid != null) || (this.shiftrmonurseid != null && !this.shiftrmonurseid.equals(other.shiftrmonurseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Shiftrmonurse[ shiftrmonurseid=" + shiftrmonurseid + " ]";
    }
    
}
