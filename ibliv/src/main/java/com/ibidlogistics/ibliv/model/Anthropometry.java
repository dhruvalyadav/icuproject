package com.ibidlogistics.ibliv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "anthropometry")
public class Anthropometry
{

    @Basic(optional = false)
    @Column(name = "createdby")
    private int createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "updateddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateddate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anthropometryid")
    private Integer anthropometryId;

    @ManyToOne
    @JoinColumn(name = "patient", nullable = false)
    @JsonBackReference("patien-anthropometryList")
    private Patient patient;

    @Column(name = "weight", precision = 20, scale = 6)
    private BigDecimal weight;

    @Column(name = "height", precision = 20, scale = 6)
    private BigDecimal height;

    @Column(name = "bmi", precision = 20, scale = 6)
    private BigDecimal bmi;

    @Column(name = "bsaboyd", precision = 20, scale = 6)
    private BigDecimal bsaBoyd;

    @Column(name = "updatedby")
    private Integer updatedBy;

    // Getters and Setters
    public Integer getAnthropometryId()
    {
        return anthropometryId;
    }

    public void setAnthropometryId(Integer anthropometryId)
    {
        this.anthropometryId = anthropometryId;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public BigDecimal getWeight()
    {
        return weight;
    }

    public void setWeight(BigDecimal weight)
    {
        this.weight = weight;
    }

    public BigDecimal getHeight()
    {
        return height;
    }

    public void setHeight(BigDecimal height)
    {
        this.height = height;
    }

    public BigDecimal getBmi()
    {
        return bmi;
    }

    public void setBmi(BigDecimal bmi)
    {
        this.bmi = bmi;
    }

    public BigDecimal getBsaBoyd()
    {
        return bsaBoyd;
    }

    public void setBsaBoyd(BigDecimal bsaBoyd)
    {
        this.bsaBoyd = bsaBoyd;
    }

    public Integer getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public Anthropometry()
    {
    }

    public int getCreatedby()
    {
        return createdby;
    }

    public void setCreatedby(int createdby)
    {
        this.createdby = createdby;
    }

    public Date getCreateddate()
    {
        return createddate;
    }

    public void setCreateddate(Date createddate)
    {
        this.createddate = createddate;
    }

    public Date getUpdateddate()
    {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate)
    {
        this.updateddate = updateddate;
    }
}
