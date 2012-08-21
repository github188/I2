package com.bullx.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DataSimg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "data_simg", catalog = "bullx_i2")
public class DataSimg implements java.io.Serializable {

	// Fields

	private Long dataId;
	private Integer lnInst;
	private Timestamp dataTime;
	private Double pres;
	private Double den;
	private Double mst;
	private Double tmp;
	private Double dewTmp;
	private Integer denAlm;
	private Integer mstAlm;
	private Integer spls;

	// Constructors

	/** default constructor */
	public DataSimg() {
	}

	/** minimal constructor */
	public DataSimg(Integer lnInst, Timestamp dataTime) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
	}

	/** full constructor */
	public DataSimg(Integer lnInst, Timestamp dataTime, Double pres,
			Double den, Double mst, Double tmp, Double dewTmp, Integer denAlm,
			Integer mstAlm, Integer spls) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
		this.pres = pres;
		this.den = den;
		this.mst = mst;
		this.tmp = tmp;
		this.dewTmp = dewTmp;
		this.denAlm = denAlm;
		this.mstAlm = mstAlm;
		this.spls = spls;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Data_ID", unique = true, nullable = false)
	public Long getDataId() {
		return this.dataId;
	}

	public void setDataId(Long dataId) {
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

	@Column(name = "Pres", precision = 22, scale = 0)
	public Double getPres() {
		return this.pres;
	}

	public void setPres(Double pres) {
		this.pres = pres;
	}

	@Column(name = "Den", precision = 22, scale = 0)
	public Double getDen() {
		return this.den;
	}

	public void setDen(Double den) {
		this.den = den;
	}

	@Column(name = "Mst", precision = 22, scale = 0)
	public Double getMst() {
		return this.mst;
	}

	public void setMst(Double mst) {
		this.mst = mst;
	}

	@Column(name = "Tmp", precision = 22, scale = 0)
	public Double getTmp() {
		return this.tmp;
	}

	public void setTmp(Double tmp) {
		this.tmp = tmp;
	}

	@Column(name = "DewTmp", precision = 22, scale = 0)
	public Double getDewTmp() {
		return this.dewTmp;
	}

	public void setDewTmp(Double dewTmp) {
		this.dewTmp = dewTmp;
	}

	@Column(name = "DenAlm")
	public Integer getDenAlm() {
		return this.denAlm;
	}

	public void setDenAlm(Integer denAlm) {
		this.denAlm = denAlm;
	}

	@Column(name = "MstAlm")
	public Integer getMstAlm() {
		return this.mstAlm;
	}

	public void setMstAlm(Integer mstAlm) {
		this.mstAlm = mstAlm;
	}

	@Column(name = "SPLS")
	public Integer getSpls() {
		return this.spls;
	}

	public void setSpls(Integer spls) {
		this.spls = spls;
	}

}