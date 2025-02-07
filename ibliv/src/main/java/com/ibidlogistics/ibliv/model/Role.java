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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Laptop
 */
@Entity
@Table(name = "role")
@NamedQueries(
{
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
})
public class Role implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roleid")
    private Integer roleid;
    @Column(name = "name")
    private String name;
    @Column(name = "rolecode")
    private String rolecode;
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Integer active;
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
    @JoinColumn(name = "division", referencedColumnName = "divisionid")
    @ManyToOne
    private Division division;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Roleaccess> roleaccessList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Userrole> userroleList;

    public Role()
    {
    }

    public Role(Integer roleid)
    {
        this.roleid = roleid;
    }

    public Role(Integer roleid, int createdby)
    {
        this.roleid = roleid;
        this.createdby = createdby;
    }

    public Integer getRoleid()
    {
        return roleid;
    }

    public void setRoleid(Integer roleid)
    {
        this.roleid = roleid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRolecode()
    {
        return rolecode;
    }

    public void setRolecode(String rolecode)
    {
        this.rolecode = rolecode;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getActive()
    {
        return active;
    }

    public void setActive(Integer active)
    {
        this.active = active;
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

    public Division getDivision()
    {
        return division;
    }

    public void setDivision(Division division)
    {
        this.division = division;
    }

    public List<Roleaccess> getRoleaccessList()
    {
        return roleaccessList;
    }

    public void setRoleaccessList(List<Roleaccess> roleaccessList)
    {
//        this.roleaccessList = roleaccessList;
        if (this.roleaccessList == null)
        {
            this.roleaccessList = new ArrayList<>();
        }
        if (roleaccessList != null)
        {
            this.roleaccessList.clear();
            this.roleaccessList.addAll(roleaccessList);
        }
    }

    public List<Userrole> getUserroleList()
    {
        return userroleList;
    }

    public void setUserroleList(List<Userrole> userroleList)
    {
//        this.userroleList = userroleList;
        if (this.userroleList == null)
        {
            this.userroleList = new ArrayList<>();
        }
        if (userroleList != null)
        {
            this.userroleList.clear();
            this.userroleList.addAll(userroleList);
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role))
        {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.ibidlogistics.ibliv.model.Role[ roleid=" + roleid + " ]";
    }

}
