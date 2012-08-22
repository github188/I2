package com.bullx.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DataMmxn entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "data_mmxn", catalog = "bullx_i2")
public class DataMmxn implements java.io.Serializable {

	// Fields

	private Long dataId;
	private Integer lnInst;
	private Timestamp dataTime;
	private Double amp;
	private Integer ampAlm;
	private String recordWave;

	// Constructors

	/** default constructor */
	public DataMmxn() {
	}

	/** minimal constructor */
	public DataMmxn(Integer lnInst, Timestamp dataTime) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
	}

	/** full constructor */
	public DataMmxn(Integer lnInst, Timestamp dataTime, Double amp,
			Integer ampAlm, String recordWave) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
		this.amp = amp;
		this.ampAlm = ampAlm;
		this.recordWave = recordWave;
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

	@Column(name = "Data_Time", nullable = false, length = 19)
	public Timestamp getDataTime() {
		return this.dataTime;
	}

	public void setDataTime(Timestamp dataTime) {
		this.dataTime = dataTime;
	}

	@Column(name = "Amp", precision = 22, scale = 0)
	public Double getAmp() {
		return this.amp;
	}

	public void setAmp(Double amp) {
		this.amp = amp;
	}

	@Column(name = "AmpAlm")
	public Integer getAmpAlm() {
		return this.ampAlm;
	}

	public void setAmpAlm(Integer ampAlm) {
		this.ampAlm = ampAlm;
	}

	@Column(name = "RecordWave", length = 320)
	public String getRecordWave() {
		return this.recordWave;
	}

	public void setRecordWave(String recordWave) {
		this.recordWave = recordWave;
	}

}