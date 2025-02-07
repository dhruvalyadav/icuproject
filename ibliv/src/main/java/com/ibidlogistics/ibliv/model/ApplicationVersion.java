package com.ibidlogistics.ibliv.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "applicationversion")
public class ApplicationVersion {

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
	@Column(name = "versionid", nullable = false, updatable = false)
	private Integer versionId;

	@Column(name = "versionnumber", length = 50)
	private String versionNumber;

	@Column(name = "active")
	private Integer active;


	@Column(name = "updatedby")
	private Integer updatedBy;

	// Getters and Setters
	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}


	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public ApplicationVersion() {
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

    public Date getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }
}
