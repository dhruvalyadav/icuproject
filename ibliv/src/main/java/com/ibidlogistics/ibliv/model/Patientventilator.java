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
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Laptop
 */
@Entity
@Table(name = "patientventilator")
@NamedQueries({
    @NamedQuery(name = "Patientventilator.findAll", query = "SELECT p FROM Patientventilator p")})
public class Patientventilator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientventilatorid")
    private Integer patientventilatorid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fio2")
    private BigDecimal fio2;
    @Column(name = "peepcpap")
    private BigDecimal peepcpap;
    @Column(name = "rate")
    private BigDecimal rate;
    @Column(name = "tv")
    private BigDecimal tv;
    @Column(name = "ppeak")
    private BigDecimal ppeak;
    @Column(name = "mv")
    private BigDecimal mv;
    @Column(name = "spo2")
    private BigDecimal spo2;
    @Column(name = "cuffpressure")
    private BigDecimal cuffpressure;
    @Column(name = "epap")
    private BigDecimal epap;
    @Column(name = "peakinsppressure")
    private BigDecimal peakinsppressure;
    @Column(name = "plateaupressure")
    private BigDecimal plateaupressure;
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
    @JoinColumn(name = "ventilatormode", referencedColumnName = "ventilatormodeid")
    @ManyToOne(optional = false)
    private Ventilatormode ventilatormode;

    public Patientventilator() {
    }

    public Patientventilator(Integer patientventilatorid) {
        this.patientventilatorid = patientventilatorid;
    }

    public Patientventilator(Integer patientventilatorid, int createdby) {
        this.patientventilatorid = patientventilatorid;
        this.createdby = createdby;
    }

    public Integer getPatientventilatorid() {
        return patientventilatorid;
    }

    public void setPatientventilatorid(Integer patientventilatorid) {
        this.patientventilatorid = patientventilatorid;
    }

    public BigDecimal getFio2() {
        return fio2;
    }

    public void setFio2(BigDecimal fio2) {
        this.fio2 = fio2;
    }

    public BigDecimal getPeepcpap() {
        return peepcpap;
    }

    public void setPeepcpap(BigDecimal peepcpap) {
        this.peepcpap = peepcpap;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getTv() {
        return tv;
    }

    public void setTv(BigDecimal tv) {
        this.tv = tv;
    }

    public BigDecimal getPpeak() {
        return ppeak;
    }

    public void setPpeak(BigDecimal ppeak) {
        this.ppeak = ppeak;
    }

    public BigDecimal getMv() {
        return mv;
    }

    public void setMv(BigDecimal mv) {
        this.mv = mv;
    }

    public BigDecimal getSpo2() {
        return spo2;
    }

    public void setSpo2(BigDecimal spo2) {
        this.spo2 = spo2;
    }

    public BigDecimal getCuffpressure() {
        return cuffpressure;
    }

    public void setCuffpressure(BigDecimal cuffpressure) {
        this.cuffpressure = cuffpressure;
    }

    public BigDecimal getEpap() {
        return epap;
    }

    public void setEpap(BigDecimal epap) {
        this.epap = epap;
    }

    public BigDecimal getPeakinsppressure() {
        return peakinsppressure;
    }

    public void setPeakinsppressure(BigDecimal peakinsppressure) {
        this.peakinsppressure = peakinsppressure;
    }

    public BigDecimal getPlateaupressure() {
        return plateaupressure;
    }

    public void setPlateaupressure(BigDecimal plateaupressure) {
        this.plateaupressure = plateaupressure;
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

    public Ventilatormode getVentilatormode() {
        return ventilatormode;
    }

    public void setVentilatormode(Ventilatormode ventilatormode) {
        this.ventilatormode = ventilatormode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientventilatorid != null ? patientventilatorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientventilator)) {
            return false;
        }
        Patientventilator other = (Patientventilator) object;
        if ((this.patientventilatorid == null && other.patientventilatorid != null) || (this.patientventilatorid != null && !this.patientventilatorid.equals(other.patientventilatorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientventilator[ patientventilatorid=" + patientventilatorid + " ]";
    }
    
}
