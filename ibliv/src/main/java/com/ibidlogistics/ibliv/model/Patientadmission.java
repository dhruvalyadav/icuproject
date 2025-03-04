/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "patientadmission")
@NamedQueries(
{
    @NamedQuery(name = "Patientadmission.findAll", query = "SELECT p FROM Patientadmission p")
})
public class Patientadmission implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientadmissionid")
    private Integer patientadmissionid;
    @Column(name = "admissiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissiondate;
    @Column(name = "icuadmissiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date icuadmissiondate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date icudischargedate;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientadmission")
    private List<Patientdaysheet> patientdaysheetList;
    @JoinColumn(name = "icu", referencedColumnName = "icuid")
    @ManyToOne(optional = false)
    private Icu icu;
    @JoinColumn(name = "patient", referencedColumnName = "patientid")
    @ManyToOne(optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientadmission")
    private List<Patientmedicationchart> patientmedicationchartList;

    public Patientadmission()
    {
    }

    public Patientadmission(Integer patientadmissionid)
    {
        this.patientadmissionid = patientadmissionid;
    }

    public Patientadmission(Integer patientadmissionid, int createdby)
    {
        this.patientadmissionid = patientadmissionid;
        this.createdby = createdby;
    }

    public Integer getPatientadmissionid()
    {
        return patientadmissionid;
    }

    public void setPatientadmissionid(Integer patientadmissionid)
    {
        this.patientadmissionid = patientadmissionid;
    }

    public Date getAdmissiondate()
    {
        return admissiondate;
    }

    public void setAdmissiondate(Date admissiondate)
    {
        this.admissiondate = admissiondate;
    }

    public Date getIcuadmissiondate()
    {
        return icuadmissiondate;
    }

    public void setIcuadmissiondate(Date icuadmissiondate)
    {
        this.icuadmissiondate = icuadmissiondate;
    }
    
     public Date getIcudischargedate()
    {
        return icudischargedate;
    }

    public void setIcudischargedate(Date icudischargedate)
    {
        this.icudischargedate = icudischargedate;
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

    public Integer getUpdatedby()
    {
        return updatedby;
    }

    public void setUpdatedby(Integer updatedby)
    {
        this.updatedby = updatedby;
    }

    public Date getUpdateddate()
    {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate)
    {
        this.updateddate = updateddate;
    }

    public List<Patientdaysheet> getPatientdaysheetList()
    {
        return patientdaysheetList;
    }

    public void setPatientdaysheetList(List<Patientdaysheet> patientdaysheetList)
    {
//        this.patientdaysheetList = patientdaysheetList;
        if (this.patientdaysheetList == null)
        {
            this.patientdaysheetList = new ArrayList<>();
        }
        if (patientdaysheetList != null)
        {
            this.patientdaysheetList.clear();
            this.patientdaysheetList.addAll(patientdaysheetList);
        }

    }

    public Icu getIcu()
    {
        return icu;
    }

    public void setIcu(Icu icu)
    {
        this.icu = icu;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public List<Patientmedicationchart> getPatientmedicationchartList()
    {
        return patientmedicationchartList;
    }

    public void setPatientmedicationchartList(List<Patientmedicationchart> patientmedicationchartList)
    {
//        this.patientmedicationchartList = patientmedicationchartList;
        if (this.patientmedicationchartList == null)
        {
            this.patientmedicationchartList = new ArrayList<>();
        }
        if (patientmedicationchartList != null)
        {
            this.patientmedicationchartList.clear();
            this.patientmedicationchartList.addAll(patientmedicationchartList);
        }

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (patientadmissionid != null ? patientadmissionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientadmission))
        {
            return false;
        }
        Patientadmission other = (Patientadmission) object;
        if ((this.patientadmissionid == null && other.patientadmissionid != null) || (this.patientadmissionid != null && !this.patientadmissionid.equals(other.patientadmissionid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        System.out.println(getPatient()+"=>"+getIcu());
        return "com.ibidlogistics.ibliv.model.Patientadmission[ patientadmissionid=" + patientadmissionid + " ]";
    }

}
