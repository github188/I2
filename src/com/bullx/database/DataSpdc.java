package com.bullx.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DataSpdc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "data_spdc", catalog = "bullx_i2")
public class DataSpdc implements java.io.Serializable {

	// Fields

	private Long dataId;
	private Integer lnInst;
	private Timestamp dataTime;
	private Double pdvalue;
	private Integer pdcount;
	private Integer pdposition;
	private Double acuPaDsch;
	private Double appPaDsch;
	private Double uhfPaDsch;
	private String paDschWave;
	private Integer paDschAlm;

	// Constructors

	/** default constructor */
	public DataSpdc() {
	}

	/** minimal constructor */
	public DataSpdc(Integer lnInst, Timestamp dataTime) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
	}

	/** full constructor */
	public DataSpdc(Integer lnInst, Timestamp dataTime, Double pdvalue,
			Integer pdcount, Integer pdposition, Double acuPaDsch,
			Double appPaDsch, Double uhfPaDsch, String paDschWave,
			Integer paDschAlm) {
		this.lnInst = lnInst;
		this.dataTime = dataTime;
		this.pdvalue = pdvalue;
		this.pdcount = pdcount;
		this.pdposition = pdposition;
		this.acuPaDsch = acuPaDsch;
		this.appPaDsch = appPaDsch;
		this.uhfPaDsch = uhfPaDsch;
		this.paDschWave = paDschWave;
		this.paDschAlm = paDschAlm;
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

	@Column(name = "PDValue", precision = 22, scale = 0)
	public Double getPdvalue() {
		return this.pdvalue;
	}

	public void setPdvalue(Double pdvalue) {
		this.pdvalue = pdvalue;
	}

	@Column(name = "PDCount")
	public Integer getPdcount() {
		return this.pdcount;
	}

	public void setPdcount(Integer pdcount) {
		this.pdcount = pdcount;
	}

	@Column(name = "PDPosition")
	public Integer getPdposition() {
		return this.pdposition;
	}

	public void setPdposition(Integer pdposition) {
		this.pdposition = pdposition;
	}

	@Column(name = "AcuPaDsch", precision = 22, scale = 0)
	public Double getAcuPaDsch() {
		return this.acuPaDsch;
	}

	public void setAcuPaDsch(Double acuPaDsch) {
		this.acuPaDsch = acuPaDsch;
	}

	@Column(name = "AppPaDsch", precision = 22, scale = 0)
	public Double getAppPaDsch() {
		return this.appPaDsch;
	}

	public void setAppPaDsch(Double appPaDsch) {
		this.appPaDsch = appPaDsch;
	}

	@Column(name = "UhfPaDsch", precision = 22, scale = 0)
	public Double getUhfPaDsch() {
		return this.uhfPaDsch;
	}

	public void setUhfPaDsch(Double uhfPaDsch) {
		this.uhfPaDsch = uhfPaDsch;
	}

	@Column(name = "PaDschWave", length = 320)
	public String getPaDschWave() {
		return this.paDschWave;
	}

	public void setPaDschWave(String paDschWave) {
		this.paDschWave = paDschWave;
	}

	@Column(name = "PaDschAlm")
	public Integer getPaDschAlm() {
		return this.paDschAlm;
	}

	public void setPaDschAlm(Integer paDschAlm) {
		this.paDschAlm = paDschAlm;
	}

}