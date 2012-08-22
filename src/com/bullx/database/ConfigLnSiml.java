package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConfigLnSiml entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_ln_siml", catalog = "bullx_i2")
public class ConfigLnSiml implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private Integer isUse;
	private Integer lnInst;
	private Double h2th;
	private Double c2h2th;
	private Double locateX;
	private Double locateY;

	// Constructors

	/** default constructor */
	public ConfigLnSiml() {
	}

	/** minimal constructor */
	public ConfigLnSiml(Integer isUse, Integer lnInst) {
		this.isUse = isUse;
		this.lnInst = lnInst;
	}

	/** full constructor */
	public ConfigLnSiml(Integer isUse, Integer lnInst, Double h2th,
			Double c2h2th, Double locateX, Double locateY) {
		this.isUse = isUse;
		this.lnInst = lnInst;
		this.h2th = h2th;
		this.c2h2th = c2h2th;
		this.locateX = locateX;
		this.locateY = locateY;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Primary_ID", unique = true, nullable = false)
	public Integer getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}

	@Column(name = "Is_use", nullable = false)
	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	@Column(name = "LN_inst", nullable = false)
	public Integer getLnInst() {
		return this.lnInst;
	}

	public void setLnInst(Integer lnInst) {
		this.lnInst = lnInst;
	}

	@Column(name = "H2Th", precision = 22, scale = 0)
	public Double getH2th() {
		return this.h2th;
	}

	public void setH2th(Double h2th) {
		this.h2th = h2th;
	}

	@Column(name = "C2H2Th", precision = 22, scale = 0)
	public Double getC2h2th() {
		return this.c2h2th;
	}

	public void setC2h2th(Double c2h2th) {
		this.c2h2th = c2h2th;
	}

	@Column(name = "LocateX", precision = 22, scale = 0)
	public Double getLocateX() {
		return this.locateX;
	}

	public void setLocateX(Double locateX) {
		this.locateX = locateX;
	}

	@Column(name = "LocateY", precision = 22, scale = 0)
	public Double getLocateY() {
		return this.locateY;
	}

	public void setLocateY(Double locateY) {
		this.locateY = locateY;
	}

}