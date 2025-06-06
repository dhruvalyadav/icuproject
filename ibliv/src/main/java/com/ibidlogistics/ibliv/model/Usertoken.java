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
 * @author Jayraj Malge
 */
@Entity
@Table(name = "usertoken")
@NamedQueries({
    @NamedQuery(name = "Usertoken.findAll", query = "SELECT u FROM Usertoken u"),
    @NamedQuery(name = "Usertoken.findByUsertokenid", query = "SELECT u FROM Usertoken u WHERE u.usertokenid = :usertokenid"),
    @NamedQuery(name = "Usertoken.findByToken", query = "SELECT u FROM Usertoken u WHERE u.token = :token"),
    @NamedQuery(name = "Usertoken.findByFcmtoken", query = "SELECT u FROM Usertoken u WHERE u.fcmtoken = :fcmtoken"),
    @NamedQuery(name = "Usertoken.findByDatetime", query = "SELECT u FROM Usertoken u WHERE u.datetime = :datetime")})
public class Usertoken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usertokenid")
    private Integer usertokenid;
    @Column(name = "token")
    private String token;
    @Column(name = "fcmtoken")
    private String fcmtoken;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "user", referencedColumnName = "userid")
    @ManyToOne
    private User user;

    public Usertoken() {
    }

    public Usertoken(Integer usertokenid) {
        this.usertokenid = usertokenid;
    }

    public Integer getUsertokenid() {
        return usertokenid;
    }

    public void setUsertokenid(Integer usertokenid) {
        this.usertokenid = usertokenid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFcmtoken() {
        return fcmtoken;
    }

    public void setFcmtoken(String fcmtoken) {
        this.fcmtoken = fcmtoken;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usertokenid != null ? usertokenid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertoken)) {
            return false;
        }
        Usertoken other = (Usertoken) object;
        if ((this.usertokenid == null && other.usertokenid != null) || (this.usertokenid != null && !this.usertokenid.equals(other.usertokenid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Usertoken[ usertokenid=" + usertokenid + " ]";
    }
    
}
