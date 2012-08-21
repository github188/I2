package com.bullx.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DataSenv entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "data_senv", catalog = "bullx_i2")
public class DataSenv implements java.io.Serializable {

	// Fields

	private Long dataId;
	private Integer lnInst;
	private Timestamp dataTime;
	private Double envTmp;
	private Double envHum;

	// Constructors

	/** default constructor */
	public DataSenv() {
	}

	/** minimal constructor */
	public DataSenv(Integer lnInst, Timestamp dataTime) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
	}

	/** full constructor */
	public DataSenv(Integer lnInst, Timestamp dataTime, Double envTmp,
			Double envHum) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
		this.envTmp = envTmp;
		this.envHum = envHum;
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

	@Column(name = "EnvTmp", precision = 22, scale = 0)
	public Double getEnvTmp() {
		return this.envTmp;
	}

	public void setEnvTmp(Double envTmp) {
		this.envTmp = envTmp;
	}

	@Column(name = "EnvHum", precision = 22, scale = 0)
	public Double getEnvHum() {
		return this.envHum;
	}

	public void setEnvHum(Double envHum) {
		this.envHum = envHum;
	}

}