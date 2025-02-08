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
@Table(name = "patientadditionalscores")
@NamedQueries({
    @NamedQuery(name = "Patientadditionalscores.findAll", query = "SELECT p FROM Patientadditionalscores p")})
public class Patientadditionalscores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientadditionalscoresid")
    private Integer patientadditionalscoresid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qsofa")
    private BigDecimal qsofa;
    @Column(name = "mews")
    private BigDecimal mews;
    @Column(name = "apacheiv")
    private BigDecimal apacheiv;
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

    public Patientadditionalscores() {
    }

    public Patientadditionalscores(Integer patientadditionalscoresid) {
        this.patientadditionalscoresid = patientadditionalscoresid;
    }

    public Patientadditionalscores(Integer patientadditionalscoresid, int createdby) {
        this.patientadditionalscoresid = patientadditionalscoresid;
        this.createdby = createdby;
    }

    public Integer getPatientadditionalscoresid() {
        return patientadditionalscoresid;
    }

    public void setPatientadditionalscoresid(Integer patientadditionalscoresid) {
        this.patientadditionalscoresid = patientadditionalscoresid;
    }

    public BigDecimal getQsofa() {
        return qsofa;
    }

    public void setQsofa(BigDecimal qsofa) {
        this.qsofa = qsofa;
    }

    public BigDecimal getMews() {
        return mews;
    }

    public void setMews(BigDecimal mews) {
        this.mews = mews;
    }

    public BigDecimal getApacheiv() {
        return apacheiv;
    }

    public void setApacheiv(BigDecimal apacheiv) {
        this.apacheiv = apacheiv;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientadditionalscoresid != null ? patientadditionalscoresid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientadditionalscores)) {
            return false;
        }
        Patientadditionalscores other = (Patientadditionalscores) object;
        if ((this.patientadditionalscoresid == null && other.patientadditionalscoresid != null) || (this.patientadditionalscoresid != null && !this.patientadditionalscoresid.equals(other.patientadditionalscoresid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientadditionalscores[ patientadditionalscoresid=" + patientadditionalscoresid + " ]";
    }
    
}
