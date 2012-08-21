package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConfigLnMmxn entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_ln_mmxn", catalog = "bullx_i2")
public class ConfigLnMmxn implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private Integer isUse;
	private String lnInst;
	private Double ampTh;
	private Double locateX;
	private Double locateY;

	// Constructors

	/** default constructor */
	public ConfigLnMmxn() {
	}

	/** minimal constructor */
	public ConfigLnMmxn(Integer isUse, String lnInst) {
		this.isUse = isUse;
		this.lnInst = lnInst;
	}

	/** full constructor */
	public ConfigLnMmxn(Integer isUse, String lnInst, Double ampTh,
			Double locateX, Double locateY) {
		this.isUse = isUse;
		this.lnInst = lnInst;
		this.ampTh = ampTh;
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

	@Column(name = "LN_inst", nullable = false, length = 45)
	public String getLnInst() {
		return this.lnInst;
	}

	public void setLnInst(String lnInst) {
		this.lnInst = lnInst;
	}

	@Column(name = "AmpTh", precision = 22, scale = 0)
	public Double getAmpTh() {
		return this.ampTh;
	}

	public void setAmpTh(Double ampTh) {
		this.ampTh = ampTh;
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