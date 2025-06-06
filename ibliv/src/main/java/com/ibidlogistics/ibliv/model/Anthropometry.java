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
 * @author Jayraj Malge
 */
@Entity
@Table(name = "anthropometry")
@NamedQueries({
    @NamedQuery(name = "Anthropometry.findAll", query = "SELECT a FROM Anthropometry a"),
    @NamedQuery(name = "Anthropometry.findByAnthropometryid", query = "SELECT a FROM Anthropometry a WHERE a.anthropometryid = :anthropometryid"),
    @NamedQuery(name = "Anthropometry.findByWeight", query = "SELECT a FROM Anthropometry a WHERE a.weight = :weight"),
    @NamedQuery(name = "Anthropometry.findByHeight", query = "SELECT a FROM Anthropometry a WHERE a.height = :height"),
    @NamedQuery(name = "Anthropometry.findByBmi", query = "SELECT a FROM Anthropometry a WHERE a.bmi = :bmi"),
    @NamedQuery(name = "Anthropometry.findByBsaboyd", query = "SELECT a FROM Anthropometry a WHERE a.bsaboyd = :bsaboyd"),
    @NamedQuery(name = "Anthropometry.findByCreatedby", query = "SELECT a FROM Anthropometry a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Anthropometry.findByCreateddate", query = "SELECT a FROM Anthropometry a WHERE a.createddate = :createddate"),
    @NamedQuery(name = "Anthropometry.findByUpdatedby", query = "SELECT a FROM Anthropometry a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "Anthropometry.findByPatientname", query = "SELECT a FROM Anthropometry a WHERE a.patient.patientname LIKE LOWER(CONCAT('%', :patientname, '%'))"),
    @NamedQuery(name = "Anthropometry.findByUpdateddate", query = "SELECT a FROM Anthropometry a WHERE a.updateddate = :updateddate")})
public class Anthropometry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anthropometryid")
    private Integer anthropometryid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private BigDecimal weight;
    @Column(name = "height")
    private BigDecimal height;
    @Column(name = "bmi")
    private BigDecimal bmi;
    @Column(name = "bsaboyd")
    private BigDecimal bsaboyd;
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
    @JoinColumn(name = "patient", referencedColumnName = "patientid")
    @ManyToOne(optional = false)
    private Patient patient;

    public Anthropometry() {
    }

    public Anthropometry(Integer anthropometryid) {
        this.anthropometryid = anthropometryid;
    }

    public Anthropometry(Integer anthropometryid, int createdby) {
        this.anthropometryid = anthropometryid;
        this.createdby = createdby;
    }

    public Integer getAnthropometryid() {
        return anthropometryid;
    }

    public void setAnthropometryid(Integer anthropometryid) {
        this.anthropometryid = anthropometryid;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public BigDecimal getBsaboyd() {
        return bsaboyd;
    }

    public void setBsaboyd(BigDecimal bsaboyd) {
        this.bsaboyd = bsaboyd;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anthropometryid != null ? anthropometryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anthropometry)) {
            return false;
        }
        Anthropometry other = (Anthropometry) object;
        if ((this.anthropometryid == null && other.anthropometryid != null) || (this.anthropometryid != null && !this.anthropometryid.equals(other.anthropometryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Anthropometry[ anthropometryid=" + anthropometryid + " ]";
    }
    
}
