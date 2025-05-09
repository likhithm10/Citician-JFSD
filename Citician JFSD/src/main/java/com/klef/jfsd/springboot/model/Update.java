package com.klef.jfsd.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "update_table")  
public class Update {

	 @Id
	 @Column(name = "update_id", length = 10, nullable = false, unique = true)
	 private String updateId;
	
    @Column(name = "subject", length = 100, nullable = false)
    private String subject;

    @Column(name = "area/constituency", length = 100, nullable = false)
    private String areaconstituency;
    
    @Column(name = "mp/mla", nullable = false)
    private String mpmla;
    
    @Column(name = "politicianid", nullable = false)
    private String politicianid;

    @Column(name = "update_content", nullable = false)
    private String update;
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @Column(name = "remarks", length = 500)
    private String remarks;

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAreaconstituency() {
		return areaconstituency;
	}

	public void setAreaconstituency(String areaconstituency) {
		this.areaconstituency = areaconstituency;
	}

	public String getMpmla() {
		return mpmla;
	}

	public void setMpmla(String mpmla) {
		this.mpmla = mpmla;
	}

	public String getPoliticianid() {
		return politicianid;
	}

	public void setPoliticianid(String politicianid) {
		this.politicianid = politicianid;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
