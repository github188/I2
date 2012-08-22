package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConfigLnSenv entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_ln_senv", catalog = "bullx_i2")
public class ConfigLnSenv implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private Integer isUse;
	private Integer lnInst;
	private Double locateX;
	private Double locateY;

	// Constructors

	/** default constructor */
	public ConfigLnSenv() {
	}

	/** full constructor */
	public ConfigLnSenv(Integer isUse, Integer lnInst, Double locateX,
			Double locateY) {
		this.isUse = isUse;
		this.lnInst = lnInst;
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

	@Column(name = "LocateX", nullable = false, precision = 22, scale = 0)
	public Double getLocateX() {
		return this.locateX;
	}

	public void setLocateX(Double locateX) {
		this.locateX = locateX;
	}

	@Column(name = "LocateY", nullable = false, precision = 22, scale = 0)
	public Double getLocateY() {
		return this.locateY;
	}

	public void setLocateY(Double locateY) {
		this.locateY = locateY;
	}

}