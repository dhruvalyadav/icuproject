
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
@Table(name = "patientadmission")
@NamedQueries({
    @NamedQuery(name = "Patientadmission.findAll", query = "SELECT p FROM Patientadmission p"),
    @NamedQuery(name = "Patientadmission.findByPatientadmissionid", query = "SELECT p FROM Patientadmission p WHERE p.patientadmissionid = :patientadmissionid"),
        @NamedQuery(name = "Patientadmission.findByPatient", query = "SELECT p FROM Patientadmission p WHERE p.patient.patientid = :patientid"),
    @NamedQuery(name = "Patientadmission.findByAdmissiondate", query = "SELECT p FROM Patientadmission p WHERE p.admissiondate = :admissiondate"),
    @NamedQuery(name = "Patientadmission.findByIcuadmissiondate", query = "SELECT p FROM Patientadmission p WHERE p.icuadmissiondate = :icuadmissiondate"),
    @NamedQuery(name = "Patientadmission.findByCreatedby", query = "SELECT p FROM Patientadmission p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Patientadmission.findByCreateddate", query = "SELECT p FROM Patientadmission p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Patientadmission.findByUpdatedby", query = "SELECT p FROM Patientadmission p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Patientadmission.findByUpdateddate", query = "SELECT p FROM Patientadmission p WHERE p.updateddate = :updateddate")})
public class Patientadmission implements Serializable {

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
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "patientadmission")
    private List<Patientdaysheet> patientdaysheetList;*/
    @JoinColumn(name = "icu", referencedColumnName = "icuid")
    @ManyToOne(optional = false)
    private Icu icu;
    @JoinColumn(name = "patient", referencedColumnName = "patientid")
    @ManyToOne(optional = false)
    private Patient patient;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "patientadmission")
    private List<Patientmedicationchart> patientmedicationchartList;*/

    public Patientadmission() {
    }

    public Patientadmission(Integer patientadmissionid) {
        this.patientadmissionid = patientadmissionid;
    }

    public Patientadmission(Integer patientadmissionid, int createdby) {
        this.patientadmissionid = patientadmissionid;
        this.createdby = createdby;
    }

    public Integer getPatientadmissionid() {
        return patientadmissionid;
    }

    public void setPatientadmissionid(Integer patientadmissionid) {
        this.patientadmissionid = patientadmissionid;
    }

    public Date getAdmissiondate() {
        return admissiondate;
    }

    public void setAdmissiondate(Date admissiondate) {
        this.admissiondate = admissiondate;
    }

    public Date getIcuadmissiondate() {
        return icuadmissiondate;
    }

    public void setIcuadmissiondate(Date icuadmissiondate) {
        this.icuadmissiondate = icuadmissiondate;
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

    /*public List<Patientdaysheet> getPatientdaysheetList() {
        return patientdaysheetList;
    }

    public void setPatientdaysheetList(List<Patientdaysheet> patientdaysheetList) {
        this.patientdaysheetList = patientdaysheetList;
    }*/

    public Icu getIcu() {
        return icu;
    }

    public void setIcu(Icu icu) {
        this.icu = icu;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /*public List<Patientmedicationchart> getPatientmedicationchartList() {
        return patientmedicationchartList;
    }

    public void setPatientmedicationchartList(List<Patientmedicationchart> patientmedicationchartList) {
        this.patientmedicationchartList = patientmedicationchartList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientadmissionid != null ? patientadmissionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientadmission)) {
            return false;
        }
        Patientadmission other = (Patientadmission) object;
        if ((this.patientadmissionid == null && other.patientadmissionid != null) || (this.patientadmissionid != null && !this.patientadmissionid.equals(other.patientadmissionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Patientadmission[ patientadmissionid=" + patientadmissionid + " ]";
    }
    
}
