package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ConfigIed entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_ied", catalog = "bullx_i2")
public class ConfigIed implements java.io.Serializable {

	// Fields

	private String primaryId;
	private EquipmentInfo equipmentInfo;
	private ConfigCac configCac;
	private String iedIp;
	private Boolean status;
	private Double operTemp;
	private Integer phase;
	private Integer isUse;
	private String iedName;
	private String iedNameCn;
	private String ldName;
	private String ldNameCn;
	private String lnPrefix;
	private String lnPrefixCn;
	private String lnClass;
	private String lnClassCn;
	private Integer lnInst;
	private String lnInstCn;
	private Integer smpProd;

	// Constructors

	/** default constructor */
	public ConfigIed() {
	}

	/** minimal constructor */
	public ConfigIed(String primaryId, EquipmentInfo equipmentInfo,
			ConfigCac configCac, String iedIp, Boolean status, Double operTemp,
			Integer phase, String ldNameCn, String lnPrefix, String lnPrefixCn,
			String lnClass, String lnClassCn, Integer lnInst, String lnInstCn,
			Integer smpProd) {
		this.primaryId = primaryId;
		this.equipmentInfo = equipmentInfo;
		this.configCac = configCac;
		this.iedIp = iedIp;
		this.status = status;
		this.operTemp = operTemp;
		this.phase = phase;
		this.ldNameCn = ldNameCn;
		this.lnPrefix = lnPrefix;
		this.lnPrefixCn = lnPrefixCn;
		this.lnClass = lnClass;
		this.lnClassCn = lnClassCn;
		this.lnInst = lnInst;
		this.lnInstCn = lnInstCn;
		this.smpProd = smpProd;
	}

	/** full constructor */
	public ConfigIed(String primaryId, EquipmentInfo equipmentInfo,
			ConfigCac configCac, String iedIp, Boolean status, Double operTemp,
			Integer phase, Integer isUse, String iedName, String iedNameCn,
			String ldName, String ldNameCn, String lnPrefix, String lnPrefixCn,
			String lnClass, String lnClassCn, Integer lnInst, String lnInstCn,
			Integer smpProd) {
		this.primaryId = primaryId;
		this.equipmentInfo = equipmentInfo;
		this.configCac = configCac;
		this.iedIp = iedIp;
		this.status = status;
		this.operTemp = operTemp;
		this.phase = phase;
		this.isUse = isUse;
		this.iedName = iedName;
		this.iedNameCn = iedNameCn;
		this.ldName = ldName;
		this.ldNameCn = ldNameCn;
		this.lnPrefix = lnPrefix;
		this.lnPrefixCn = lnPrefixCn;
		this.lnClass = lnClass;
		this.lnClassCn = lnClassCn;
		this.lnInst = lnInst;
		this.lnInstCn = lnInstCn;
		this.smpProd = smpProd;
	}

	// Property accessors
	@Id
	@Column(name = "Primary_ID", unique = true, nullable = false, length = 17)
	public String getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EQ_ID", nullable = false)
	public EquipmentInfo getEquipmentInfo() {
		return this.equipmentInfo;
	}

	public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAC_ID", nullable = false)
	public ConfigCac getConfigCac() {
		return this.configCac;
	}

	public void setConfigCac(ConfigCac configCac) {
		this.configCac = configCac;
	}

	@Column(name = "IED_IP", nullable = false, length = 15)
	public String getIedIp() {
		return this.iedIp;
	}

	public void setIedIp(String iedIp) {
		this.iedIp = iedIp;
	}

	@Column(name = "STATUS", nullable = false)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "OPER_Temp", nullable = false, precision = 22, scale = 0)
	public Double getOperTemp() {
		return this.operTemp;
	}

	public void setOperTemp(Double operTemp) {
		this.operTemp = operTemp;
	}

	@Column(name = "PHASE", nullable = false)
	public Integer getPhase() {
		return this.phase;
	}

	public void setPhase(Integer phase) {
		this.phase = phase;
	}

	@Column(name = "Is_use")
	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	@Column(name = "IED_name", length = 50)
	public String getIedName() {
		return this.iedName;
	}

	public void setIedName(String iedName) {
		this.iedName = iedName;
	}

	@Column(name = "IED_name_cn", length = 50)
	public String getIedNameCn() {
		return this.iedNameCn;
	}

	public void setIedNameCn(String iedNameCn) {
		this.iedNameCn = iedNameCn;
	}

	@Column(name = "LD_name", length = 50)
	public String getLdName() {
		return this.ldName;
	}

	public void setLdName(String ldName) {
		this.ldName = ldName;
	}

	@Column(name = "LD_name_cn", nullable = false, length = 50)
	public String getLdNameCn() {
		return this.ldNameCn;
	}

	public void setLdNameCn(String ldNameCn) {
		this.ldNameCn = ldNameCn;
	}

	@Column(name = "LN_prefix", nullable = false, length = 50)
	public String getLnPrefix() {
		return this.lnPrefix;
	}

	public void setLnPrefix(String lnPrefix) {
		this.lnPrefix = lnPrefix;
	}

	@Column(name = "LN_prefix_cn", nullable = false, length = 50)
	public String getLnPrefixCn() {
		return this.lnPrefixCn;
	}

	public void setLnPrefixCn(String lnPrefixCn) {
		this.lnPrefixCn = lnPrefixCn;
	}

	@Column(name = "LN_class", nullable = false, length = 50)
	public String getLnClass() {
		return this.lnClass;
	}

	public void setLnClass(String lnClass) {
		this.lnClass = lnClass;
	}

	@Column(name = "LN_class_cn", nullable = false, length = 50)
	public String getLnClassCn() {
		return this.lnClassCn;
	}

	public void setLnClassCn(String lnClassCn) {
		this.lnClassCn = lnClassCn;
	}

	@Column(name = "LN_inst", nullable = false)
	public Integer getLnInst() {
		return this.lnInst;
	}

	public void setLnInst(Integer lnInst) {
		this.lnInst = lnInst;
	}

	@Column(name = "LN_inst_cn", nullable = false, length = 50)
	public String getLnInstCn() {
		return this.lnInstCn;
	}

	public void setLnInstCn(String lnInstCn) {
		this.lnInstCn = lnInstCn;
	}

	@Column(name = "Smp_prod", nullable = false)
	public Integer getSmpProd() {
		return this.smpProd;
	}

	public void setSmpProd(Integer smpProd) {
		this.smpProd = smpProd;
	}

}