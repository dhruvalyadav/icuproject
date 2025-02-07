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
 * @author Laptop
 */
@Entity
@Table(name = "roleaccess")
@NamedQueries({
    @NamedQuery(name = "Roleaccess.findAll", query = "SELECT r FROM Roleaccess r")})
public class Roleaccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roleaccessid")
    private Integer roleaccessid;
    @Column(name = "ionicmenu")
    private Integer ionicmenu;
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
    @JoinColumn(name = "menu", referencedColumnName = "menuid")
    @ManyToOne
    private Menudetails menu;
    @JoinColumn(name = "role", referencedColumnName = "roleid")
    @ManyToOne(optional = false)
    private Role role;

    public Roleaccess() {
    }

    public Roleaccess(Integer roleaccessid) {
        this.roleaccessid = roleaccessid;
    }

    public Roleaccess(Integer roleaccessid, int createdby) {
        this.roleaccessid = roleaccessid;
        this.createdby = createdby;
    }

    public Integer getRoleaccessid() {
        return roleaccessid;
    }

    public void setRoleaccessid(Integer roleaccessid) {
        this.roleaccessid = roleaccessid;
    }

    public Integer getIonicmenu() {
        return ionicmenu;
    }

    public void setIonicmenu(Integer ionicmenu) {
        this.ionicmenu = ionicmenu;
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

    public Menudetails getMenu() {
        return menu;
    }

    public void setMenu(Menudetails menu) {
        this.menu = menu;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleaccessid != null ? roleaccessid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roleaccess)) {
            return false;
        }
        Roleaccess other = (Roleaccess) object;
        if ((this.roleaccessid == null && other.roleaccessid != null) || (this.roleaccessid != null && !this.roleaccessid.equals(other.roleaccessid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibidlogistics.ibliv.model.Roleaccess[ roleaccessid=" + roleaccessid + " ]";
    }
    
}
