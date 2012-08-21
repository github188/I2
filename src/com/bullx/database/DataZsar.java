package com.bullx.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DataZsar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "data_zsar", catalog = "bullx_i2")
public class DataZsar implements java.io.Serializable {

	// Fields

	private Integer dataId;
	private Integer lnInst;
	private Timestamp dataTime;
	private Double sysVol;
	private Double totA;
	private Double risA;
	private Integer actCount;
	private Timestamp lastActTime;
	private Integer alm;

	// Constructors

	/** default constructor */
	public DataZsar() {
	}

	/** minimal constructor */
	public DataZsar(Integer lnInst, Timestamp dataTime) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
	}

	/** full constructor */
	public DataZsar(Integer lnInst, Timestamp dataTime, Double sysVol,
			Double totA, Double risA, Integer actCount, Timestamp lastActTime,
			Integer alm) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
		this.sysVol = sysVol;
		this.totA = totA;
		this.risA = risA;
		this.actCount = actCount;
		this.lastActTime = lastActTime;
		this.alm = alm;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Data_ID", unique = true, nullable = false)
	public Integer getDataId() {
		return this.dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	@Column(name = "LN_inst", nullable = false)
	public Integer getLnInst() {
		return this.lnInst;
	}

	public void setLnInst(Integer lnInst) {
		this.lnInst = lnInst;
	}

	@Column(name = "Data_Time", nullable = false, length = 0)
	public Timestamp getDataTime() {
		return this.dataTime;
	}

	public void setDataTime(Timestamp dataTime) {
		this.dataTime = dataTime;
	}

	@Column(name = "SysVol", precision = 22, scale = 0)
	public Double getSysVol() {
		return this.sysVol;
	}

	public void setSysVol(Double sysVol) {
		this.sysVol = sysVol;
	}

	@Column(name = "TotA", precision = 22, scale = 0)
	public Double getTotA() {
		return this.totA;
	}

	public void setTotA(Double totA) {
		this.totA = totA;
	}

	@Column(name = "RisA", precision = 22, scale = 0)
	public Double getRisA() {
		return this.risA;
	}

	public void setRisA(Double risA) {
		this.risA = risA;
	}

	@Column(name = "ActCount")
	public Integer getActCount() {
		return this.actCount;
	}

	public void setActCount(Integer actCount) {
		this.actCount = actCount;
	}

	@Column(name = "LastActTime", length = 0)
	public Timestamp getLastActTime() {
		return this.lastActTime;
	}

	public void setLastActTime(Timestamp lastActTime) {
		this.lastActTime = lastActTime;
	}

	@Column(name = "Alm")
	public Integer getAlm() {
		return this.alm;
	}

	public void setAlm(Integer alm) {
		this.alm = alm;
	}

}