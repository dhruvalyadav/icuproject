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
@Table(name = "menudetails")
@NamedQueries(
{
    @NamedQuery(name = "Menudetails.findAll", query = "SELECT m FROM Menudetails m")
})
public class Menudetails implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menuid")
    private Integer menuid;
    @Basic(optional = false)
    @Column(name = "mainname")
    private String mainname;
    @Basic(optional = false)
    @Column(name = "subname")
    private String subname;
    @Column(name = "link")
    private String link;
    @Column(name = "classname")
    private String classname;
    @Column(name = "mainsort")
    private Integer mainsort;
    @Column(name = "subsort")
    private Integer subsort;
    @Basic(optional = false)
    @Column(name = "active")
    private int active;
    @Basic(optional = false)
    @Column(name = "ionicactive")
    private int ionicactive;
    @Column(name = "mainicon")
    private String mainicon;
    @Column(name = "subicon")
    private String subicon;
    @Column(name = "ionicdashboardicon")
    private String ionicdashboardicon;
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
    @OneToMany(mappedBy = "menu")
    private List<Roleaccess> roleaccessList;

    public Menudetails()
    {
    }

    public Menudetails(Integer menuid)
    {
        this.menuid = menuid;
    }

    public Menudetails(Integer menuid, String mainname, String subname, int active, int ionicactive, int createdby)
    {
        this.menuid = menuid;
        this.mainname = mainname;
        this.subname = subname;
        this.active = active;
        this.ionicactive = ionicactive;
        this.createdby = createdby;
    }

    public Integer getMenuid()
    {
        return menuid;
    }

    public void setMenuid(Integer menuid)
    {
        this.menuid = menuid;
    }

    public String getMainname()
    {
        return mainname;
    }

    public void setMainname(String mainname)
    {
        this.mainname = mainname;
    }

    public String getSubname()
    {
        return subname;
    }

    public void setSubname(String subname)
    {
        this.subname = subname;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getClassname()
    {
        return classname;
    }

    public void setClassname(String classname)
    {
        this.classname = classname;
    }

    public Integer getMainsort()
    {
        return mainsort;
    }

    public void setMainsort(Integer mainsort)
    {
        this.mainsort = mainsort;
    }

    public Integer getSubsort()
    {
        return subsort;
    }

    public void setSubsort(Integer subsort)
    {
        this.subsort = subsort;
    }

    public int getActive()
    {
        return active;
    }

    public void setActive(int active)
    {
        this.active = active;
    }

    public int getIonicactive()
    {
        return ionicactive;
    }

    public void setIonicactive(int ionicactive)
    {
        this.ionicactive = ionicactive;
    }

    public String getMainicon()
    {
        return mainicon;
    }

    public void setMainicon(String mainicon)
    {
        this.mainicon = mainicon;
    }

    public String getSubicon()
    {
        return subicon;
    }

    public void setSubicon(String subicon)
    {
        this.subicon = subicon;
    }

    public String getIonicdashboardicon()
    {
        return ionicdashboardicon;
    }

    public void setIonicdashboardicon(String ionicdashboardicon)
    {
        this.ionicdashboardicon = ionicdashboardicon;
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

    public List<Roleaccess> getRoleaccessList()
    {
        return roleaccessList;
    }

    public void setRoleaccessList(List<Roleaccess> roleaccessList)
    {
//        this.roleaccessList = roleaccessList;
        if(this.roleaccessList==null) this.roleaccessList=new ArrayList<>();
        if(roleaccessList!=null)
        {
            this.roleaccessList.clear();
            this.roleaccessList.addAll(roleaccessList);
        }
        
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (menuid != null ? menuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menudetails))
        {
            return false;
        }
        Menudetails other = (Menudetails) object;
        if ((this.menuid == null && other.menuid != null) || (this.menuid != null && !this.menuid.equals(other.menuid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.ibidlogistics.ibliv.model.Menudetails[ menuid=" + menuid + " ]";
    }

}
