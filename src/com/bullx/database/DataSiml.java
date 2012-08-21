package com.bullx.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DataSiml entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "data_siml", catalog = "bullx_i2")
public class DataSiml implements java.io.Serializable {

	// Fields

	private Long dataId;
	private Integer lnInst;
	private Timestamp dataTime;
	private Double h2ppm;
	private Double n2ppm;
	private Double coppm;
	private Double co2ppm;
	private Double ch4ppm;
	private Double c2h2ppm;
	private Double c2h4ppm;
	private Double c2h6ppm;
	private Double o2ppm;
	private Double mst;
	private Double hydrocarbon;
	private Double cmbuGas;
	private Integer h2alm;
	private Integer c2h2alm;

	// Constructors

	/** default constructor */
	public DataSiml() {
	}

	/** minimal constructor */
	public DataSiml(Integer lnInst, Timestamp dataTime) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
	}

	/** full constructor */
	public DataSiml(Integer lnInst, Timestamp dataTime, Double h2ppm,
			Double n2ppm, Double coppm, Double co2ppm, Double ch4ppm,
			Double c2h2ppm, Double c2h4ppm, Double c2h6ppm, Double o2ppm,
			Double mst, Double hydrocarbon, Double cmbuGas, Integer h2alm,
			Integer c2h2alm) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
		this.h2ppm = h2ppm;
		this.n2ppm = n2ppm;
		this.coppm = coppm;
		this.co2ppm = co2ppm;
		this.ch4ppm = ch4ppm;
		this.c2h2ppm = c2h2ppm;
		this.c2h4ppm = c2h4ppm;
		this.c2h6ppm = c2h6ppm;
		this.o2ppm = o2ppm;
		this.mst = mst;
		this.hydrocarbon = hydrocarbon;
		this.cmbuGas = cmbuGas;
		this.h2alm = h2alm;
		this.c2h2alm = c2h2alm;
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

	@Column(name = "Data_time", nullable = false, length = 0)
	public Timestamp getDataTime() {
		return this.dataTime;
	}

	public void setDataTime(Timestamp dataTime) {
		this.dataTime = dataTime;
	}

	@Column(name = "H2ppm", precision = 22, scale = 0)
	public Double getH2ppm() {
		return this.h2ppm;
	}

	public void setH2ppm(Double h2ppm) {
		this.h2ppm = h2ppm;
	}

	@Column(name = "N2ppm", precision = 22, scale = 0)
	public Double getN2ppm() {
		return this.n2ppm;
	}

	public void setN2ppm(Double n2ppm) {
		this.n2ppm = n2ppm;
	}

	@Column(name = "COppm", precision = 22, scale = 0)
	public Double getCoppm() {
		return this.coppm;
	}

	public void setCoppm(Double coppm) {
		this.coppm = coppm;
	}

	@Column(name = "CO2ppm", precision = 22, scale = 0)
	public Double getCo2ppm() {
		return this.co2ppm;
	}

	public void setCo2ppm(Double co2ppm) {
		this.co2ppm = co2ppm;
	}

	@Column(name = "CH4ppm", precision = 22, scale = 0)
	public Double getCh4ppm() {
		return this.ch4ppm;
	}

	public void setCh4ppm(Double ch4ppm) {
		this.ch4ppm = ch4ppm;
	}

	@Column(name = "C2H2ppm", precision = 22, scale = 0)
	public Double getC2h2ppm() {
		return this.c2h2ppm;
	}

	public void setC2h2ppm(Double c2h2ppm) {
		this.c2h2ppm = c2h2ppm;
	}

	@Column(name = "C2H4ppm", precision = 22, scale = 0)
	public Double getC2h4ppm() {
		return this.c2h4ppm;
	}

	public void setC2h4ppm(Double c2h4ppm) {
		this.c2h4ppm = c2h4ppm;
	}

	@Column(name = "C2H6ppm", precision = 22, scale = 0)
	public Double getC2h6ppm() {
		return this.c2h6ppm;
	}

	public void setC2h6ppm(Double c2h6ppm) {
		this.c2h6ppm = c2h6ppm;
	}

	@Column(name = "O2ppm", precision = 22, scale = 0)
	public Double getO2ppm() {
		return this.o2ppm;
	}

	public void setO2ppm(Double o2ppm) {
		this.o2ppm = o2ppm;
	}

	@Column(name = "Mst", precision = 22, scale = 0)
	public Double getMst() {
		return this.mst;
	}

	public void setMst(Double mst) {
		this.mst = mst;
	}

	@Column(name = "Hydrocarbon", precision = 22, scale = 0)
	public Double getHydrocarbon() {
		return this.hydrocarbon;
	}

	public void setHydrocarbon(Double hydrocarbon) {
		this.hydrocarbon = hydrocarbon;
	}

	@Column(name = "CmbuGas", precision = 22, scale = 0)
	public Double getCmbuGas() {
		return this.cmbuGas;
	}

	public void setCmbuGas(Double cmbuGas) {
		this.cmbuGas = cmbuGas;
	}

	@Column(name = "H2Alm")
	public Integer getH2alm() {
		return this.h2alm;
	}

	public void setH2alm(Integer h2alm) {
		this.h2alm = h2alm;
	}

	@Column(name = "C2H2Alm")
	public Integer getC2h2alm() {
		return this.c2h2alm;
	}

	public void setC2h2alm(Integer c2h2alm) {
		this.c2h2alm = c2h2alm;
	}

}