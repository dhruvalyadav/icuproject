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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "patientdaysheet")
@NamedQueries({
    @NamedQuery(name = "Patientdaysheet.findAll", query = "SELECT p FROM Patientdaysheet p"),
    @NamedQuery(name = "Patientdaysheet.findByPatientdaysheetid", query = "SELECT p FROM Patientdaysheet p WHERE p.patientdaysheetid = :patientdaysheetid"),
    @NamedQuery(name = "Patientdaysheet.findByDate", query = "SELECT p FROM Patientdaysheet p WHERE p.date = :date"),
    @NamedQuery(name = "Patientdaysheet.findByCreatedby", query = "SELECT p FROM Patientdaysheet p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patientdaysheet.findByCreateddate", query = "SELECT p FROM Patientdaysheet p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patientdaysheet.findByUpdatedby", query = "SELECT p FROM Patientdaysheet p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Patientdaysheet.findByUpdateddate", query = "SELECT p FROM Patientdaysheet p WHERE p.updateddate = :updateddate")})
public class Patientdaysheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientdaysheetid")
    private Integer patientdaysheetid;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
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
    @JoinColumn(name = "patientadmission", referencedColumnName = "patientadmissionid")
    @ManyToOne(optional = false)
    private Patientadmission patientadmission;
    @JoinColumn(name = "consultant1", referencedColumnName = "userid")
    @ManyToOne
    private User consultant1;
    @JoinColumn(name = "consultant2", referencedColumnName = "userid")
    @ManyToOne
    private User consultant2;
    @JoinColumn(name = "consultant3", referencedColumnName = "userid")
    @ManyToOne
    private User consultant3;
    @JoinColumn(name = "intensivist", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User intensivist;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Patientlinestubes> patientlinestubesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Hourlyobservation> hourlyobservationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Rmonurselog> rmonurselogList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Consultantpatientvisit> consultantpatientvisitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Patientadditionaltests> patientadditionaltestsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Patientadditionalscores> patientadditionalscoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Embolism> embolismList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientdaysheet")
    private List<Patientventilator> patientventilatorList;*/

    public Patientdaysheet() {
    }

    public Patientdaysheet(Integer patientdaysheetid) {
        this.patientdaysheetid = patientdaysheetid;
    }

    public Patientdaysheet(Integer patientdaysheetid, int createdby) {
        this.patientdaysheetid = patientdaysheetid;
        this.createdby = createdby;
    }

    public Integer getPatientdaysheetid() {
        return patientdaysheetid;
    }

    public void setPatientdaysheetid(Integer patientdaysheetid) {
        this.patientdaysheetid = patientdaysheetid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Patientadmission getPatientadmission() {
        return patientadmission;
    }

    public void setPatientadmission(Patientadmission patientadmission) {
        this.patientadmission = patientadmission;
    }

    public User getConsultant1() {
        return consultant1;
    }

    public void setConsultant1(User consultant1) {
        this.consultant1 = consultant1;
    }

    public User getConsultant2() {
        return consultant2;
    }

    public void setConsultant2(User consultant2) {
        this.consultant2 = consultant2;
    }

    public User getConsultant3() {
        return consultant3;
    }

    public void setConsultant3(User consultant3) {
        this.consultant3 = consultant3;
    }

    public User getIntensivist() {
        return intensivist;
    }

    public void setIntensivist(User intensivist) {
        this.intensivist = intensivist;
    }

    /*public List<Patientlinestubes> getPatientlinestubesList() {
        return patientlinestubesList;
    }

    public void setPatientlinestubesList(List<Patientlinestubes> patientlinestubesList) {
        this.patientlinestubesList = patientlinestubesList;
    }

    public List<Hourlyobservation> getHourlyobservationList() {
        return hourlyobservationList;
    }

    public void setHourlyobservationList(List<Hourlyobservation> hourlyobservationList) {
        this.hourlyobservationList = hourlyobservationList;
    }

    public List<Rmonurselog> getRmonurselogList() {
        return rmonurselogList;
    }

    public void setRmonurselogList(List<Rmonurselog> rmonurselogList) {
        this.rmonurselogList = rmonurselogList;
    }

    public List<Consultantpatientvisit> getConsultantpatientvisitList() {
        return consultantpatientvisitList;
    }

    public void setConsultantpatientvisitList(List<Consultantpatientvisit> consultantpatientvisitList) {
        this.consultantpatientvisitList = consultantpatientvisitList;
    }

    public List<Patientadditionaltests> getPatientadditionaltestsList() {
        return patientadditionaltestsList;
    }

    public void setPatientadditionaltestsList(List<Patientadditionaltests> patientadditionaltestsList) {
        this.patientadditionaltestsList = patientadditionaltestsList;
    }

    public List<Patientadditionalscores> getPatientadditionalscoresList() {
        return patientadditionalscoresList;
    }

    public void setPatientadditionalscoresList(List<Patientadditionalscores> patientadditionalscoresList) {
        this.patientadditionalscoresList = patientadditionalscoresList;
    }

    public List<Embolism> getEmbolismList() {
        return embolismList;
    }

    public void setEmbolismList(List<Embolism> embolismList) {
        this.embolismList = embolismList;
    }

    public List<Patientventilator> getPatientventilatorList() {
        return patientventilatorList;
    }

    public void setPatientventilatorList(List<Patientventilator> patientventilatorList) {
        this.patientventilatorList = patientventilatorList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientdaysheetid != null ? patientdaysheetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientdaysheet)) {
            return false;
        }
        Patientdaysheet other = (Patientdaysheet) object;
        if ((this.patientdaysheetid == null && other.patientdaysheetid != null) || (this.patientdaysheetid != null && !this.patientdaysheetid.equals(other.patientdaysheetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientdaysheet[ patientdaysheetid=" + patientdaysheetid + " ]";
    }
    
}
