package com.ibidlogistics.ibliv.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient implements Serializable
{

    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "createdby")
    private int createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "updateddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateddate;
    @JsonManagedReference("patien-anthropometryList")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient", orphanRemoval = true)
    private List<Anthropometry> anthropometryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientadmission> patientadmissionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientinfusion> patientinfusionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientivfluid> patientivfluidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Patientsosmedication> patientsosmedicationList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientid")
    private Integer patientId;

    @Column(name = "patientname", length = 50)
    private String patientName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex", length = 50)
    private String sex;

    @Column(name = "address", length = 2000)
    private String address;

    @Column(name = "contact", length = 50)
    private String contact;

    @Column(name = "active")
    private Integer active;

    @Column(name = "updatedby")
    private Integer updatedBy;

    // Getters and Setters
    public Integer getPatientId()
    {
        return patientId;
    }

    public void setPatientId(Integer patientId)
    {
        this.patientId = patientId;
    }

    public String getPatientname()
    {
        return patientName;
    }

    public void setPatientname(String patientName)
    {
        this.patientName = patientName;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public Integer getActive()
    {
        return active;
    }

    public void setActive(Integer active)
    {
        this.active = active;
    }

    public Integer getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public Patient()
    {
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
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

    public List<Anthropometry> getAnthropometryList()
    {
        return anthropometryList;
    }

    public void setAnthropometryList(List<Anthropometry> anthropometryList)
    {
//        this.anthropometryList = anthropometryList;
        if(this.anthropometryList==null) this.anthropometryList=new ArrayList<>();
        if(anthropometryList!=null)
        {
            this.anthropometryList.clear();
            this.anthropometryList.addAll(anthropometryList);
        }
    }

    public List<Patientadmission> getPatientadmissionList()
    {
        return patientadmissionList;
    }

    public void setPatientadmissionList(List<Patientadmission> patientadmissionList)
    {
//        this.patientadmissionList = patientadmissionList;
        if(this.patientadmissionList==null) this.patientadmissionList=new ArrayList<>();
        if(patientadmissionList!=null)
        {
            this.patientadmissionList.clear();
            this.patientadmissionList.addAll(patientadmissionList);
        }

    }

    public List<Patientinfusion> getPatientinfusionList()
    {
        return patientinfusionList;
    }

    public void setPatientinfusionList(List<Patientinfusion> patientinfusionList)
    {
//        this.patientinfusionList = patientinfusionList;
        if(this.patientinfusionList==null) this.patientinfusionList=new ArrayList<>();
        if(patientinfusionList!=null)
        {
            this.patientinfusionList.clear();
            this.patientinfusionList.addAll(patientinfusionList);
        }
    }

    public List<Patientivfluid> getPatientivfluidList()
    {
        return patientivfluidList;
    }

    public void setPatientivfluidList(List<Patientivfluid> patientivfluidList)
    {
//        this.patientivfluidList = patientivfluidList;
        if(this.patientivfluidList==null) this.patientivfluidList=new ArrayList<>();
        if(patientivfluidList!=null)
        {
            this.patientivfluidList.clear();
            this.patientivfluidList.addAll(patientivfluidList);
        }
    }

    public List<Patientsosmedication> getPatientsosmedicationList()
    {
        return patientsosmedicationList;
    }

    public void setPatientsosmedicationList(List<Patientsosmedication> patientsosmedicationList)
    {
//        this.patientsosmedicationList = patientsosmedicationList;
        if(this.patientsosmedicationList==null) this.patientsosmedicationList=new ArrayList<>();
        if(patientsosmedicationList!=null)
        {
            this.patientsosmedicationList.clear();
            this.patientsosmedicationList.addAll(patientsosmedicationList);
        }
    }
}
