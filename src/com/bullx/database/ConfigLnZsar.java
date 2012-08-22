package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConfigLnZsar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_ln_zsar", catalog = "bullx_i2")
public class ConfigLnZsar implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private Integer isUse;
	private Integer lnInst;
	private Double totAth;
	private Double risAth;
	private Double locateX;
	private Double locateY;

	// Constructors

	/** default constructor */
	public ConfigLnZsar() {
	}

	/** minimal constructor */
	public ConfigLnZsar(Integer isUse, Integer lnInst) {
		this.isUse = isUse;
		this.lnInst = lnInst;
	}

	/** full constructor */
	public ConfigLnZsar(Integer isUse, Integer lnInst, Double totAth,
			Double risAth, Double locateX, Double locateY) {
		this.isUse = isUse;
		this.lnInst = lnInst;
		this.totAth = totAth;
		this.risAth = risAth;
		this.locateX = locateX;
		this.locateY = locateY;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Primary_Id", unique = true, nullable = false)
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

	@Column(name = "TotATh", precision = 22, scale = 0)
	public Double getTotAth() {
		return this.totAth;
	}

	public void setTotAth(Double totAth) {
		this.totAth = totAth;
	}

	@Column(name = "RisATh", precision = 22, scale = 0)
	public Double getRisAth() {
		return this.risAth;
	}

	public void setRisAth(Double risAth) {
		this.risAth = risAth;
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