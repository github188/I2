package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConfigLnSimg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_ln_simg", catalog = "bullx_i2")
public class ConfigLnSimg implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private Integer isUse;
	private Integer lnInst;
	private Double denTh;
	private Double mstTh;
	private Double locateX;
	private Double locateY;

	// Constructors

	/** default constructor */
	public ConfigLnSimg() {
	}

	/** minimal constructor */
	public ConfigLnSimg(Integer isUse, Integer lnInst) {
		this.isUse = isUse;
		this.lnInst = lnInst;
	}

	/** full constructor */
	public ConfigLnSimg(Integer isUse, Integer lnInst, Double denTh,
			Double mstTh, Double locateX, Double locateY) {
		this.isUse = isUse;
		this.lnInst = lnInst;
		this.denTh = denTh;
		this.mstTh = mstTh;
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

	@Column(name = "DenTh", precision = 22, scale = 0)
	public Double getDenTh() {
		return this.denTh;
	}

	public void setDenTh(Double denTh) {
		this.denTh = denTh;
	}

	@Column(name = "MstTh", precision = 22, scale = 0)
	public Double getMstTh() {
		return this.mstTh;
	}

	public void setMstTh(Double mstTh) {
		this.mstTh = mstTh;
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