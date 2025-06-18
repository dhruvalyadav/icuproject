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
@Table(name = "userrole")
@NamedQueries({
    @NamedQuery(name = "Userrole.findAll", query = "SELECT u FROM Userrole u"),
    @NamedQuery(name = "Userrole.findByUserroleid", query = "SELECT u FROM Userrole u WHERE u.userroleid = :userroleid"),
    @NamedQuery(name = "Userrole.findByRolename", query = "SELECT u FROM Userrole u WHERE u.role.name = :name"),
    @NamedQuery(name = "Userrole.findByActive", query = "SELECT u FROM Userrole u WHERE u.active = :active"),
    @NamedQuery(name = "Userrole.findByCreatedby", query = "SELECT u FROM Userrole u WHERE u.createdby = :createdby"),
    @NamedQuery(name = "Userrole.findByCreateddate", query = "SELECT u FROM Userrole u WHERE u.createddate = :createddate"),
    @NamedQuery(name = "Userrole.findByUpdatedby", query = "SELECT u FROM Userrole u WHERE u.updatedby = :updatedby"),
    @NamedQuery(name = "Userrole.findByUpdateddate", query = "SELECT u FROM Userrole u WHERE u.updateddate = :updateddate")})
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userroleid")
    private Integer userroleid;
    @Basic(optional = false)
    @Column(name = "active")
    private int active;
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
    @JoinColumn(name = "role", referencedColumnName = "roleid")
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumn(name = "user", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User user;

    public Userrole() {
    }

    public Userrole(Integer userroleid) {
        this.userroleid = userroleid;
    }

    public Userrole(Integer userroleid, int active, int createdby) {
        this.userroleid = userroleid;
        this.active = active;
        this.createdby = createdby;
    }

    public Integer getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Integer userroleid) {
        this.userroleid = userroleid;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        hash += (userroleid != null ? userroleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userrole)) {
            return false;
        }
        Userrole other = (Userrole) object;
        if ((this.userroleid == null && other.userroleid != null) || (this.userroleid != null && !this.userroleid.equals(other.userroleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Userrole[ userroleid=" + userroleid + " ]";
    }
    
}
