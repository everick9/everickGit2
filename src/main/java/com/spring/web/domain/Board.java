package com.spring.web.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author USER
 *
 */
@Entity
public class Board {
	
	@Id
	private int bbsno;
    private String wname;
    private String subject;
    private String content;
    private String passwd;
    private int readcnt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdt;

	public int getBbsno() {
		return bbsno;
	}

	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public Date getRegdt() {
		return regdt;
	}

	public void setRegdt(Date regdt) {
		this.regdt = regdt;
	}
	
	
	
}
