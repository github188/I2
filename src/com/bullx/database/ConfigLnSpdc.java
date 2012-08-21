package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConfigLnSpdc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_ln_spdc", catalog = "bullx_i2")
public class ConfigLnSpdc implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private Integer isUse;
	private Integer lnInst;
	private Double paDschTh;
	private Double locateX;
	private Double locateY;

	// Constructors

	/** default constructor */
	public ConfigLnSpdc() {
	}

	/** minimal constructor */
	public ConfigLnSpdc(Integer isUse, Integer lnInst) {
		this.isUse = isUse;
		this.lnInst = lnInst;
	}

	/** full constructor */
	public ConfigLnSpdc(Integer isUse, Integer lnInst, Double paDschTh,
			Double locateX, Double locateY) {
		this.isUse = isUse;
		this.lnInst = lnInst;
		this.paDschTh = paDschTh;
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

	@Column(name = "PaDschTh", precision = 22, scale = 0)
	public Double getPaDschTh() {
		return this.paDschTh;
	}

	public void setPaDschTh(Double paDschTh) {
		this.paDschTh = paDschTh;
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