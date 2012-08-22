package com.bullx.database;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ConfigCac entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config_cac", catalog = "bullx_i2")
public class ConfigCac implements java.io.Serializable {

	// Fields

	private String cacId;
	private String cacIp;
	private String cagip;
	private Double operTemp;
	private Integer dataPeriod;
	private Integer heartbeatPeriod;
	private Set<ConfigIed> configIeds = new HashSet<ConfigIed>(0);

	// Constructors

	/** default constructor */
	public ConfigCac() {
	}

	/** minimal constructor */
	public ConfigCac(String cacId, String cacIp, String cagip, Double operTemp,
			Integer dataPeriod, Integer heartbeatPeriod) {
		this.cacId = cacId;
		this.cacIp = cacIp;
		this.cagip = cagip;
		this.operTemp = operTemp;
		this.dataPeriod = dataPeriod;
		this.heartbeatPeriod = heartbeatPeriod;
	}

	/** full constructor */
	public ConfigCac(String cacId, String cacIp, String cagip, Double operTemp,
			Integer dataPeriod, Integer heartbeatPeriod,
			Set<ConfigIed> configIeds) {
		this.cacId = cacId;
		this.cacIp = cacIp;
		this.cagip = cagip;
		this.operTemp = operTemp;
		this.dataPeriod = dataPeriod;
		this.heartbeatPeriod = heartbeatPeriod;
		this.configIeds = configIeds;
	}

	// Property accessors
	@Id
	@Column(name = "CAC_ID", unique = true, nullable = false, length = 17)
	public String getCacId() {
		return this.cacId;
	}

	public void setCacId(String cacId) {
		this.cacId = cacId;
	}

	@Column(name = "CAC_IP", nullable = false, length = 15)
	public String getCacIp() {
		return this.cacIp;
	}

	public void setCacIp(String cacIp) {
		this.cacIp = cacIp;
	}

	@Column(name = "CAGIP", nullable = false, length = 15)
	public String getCagip() {
		return this.cagip;
	}

	public void setCagip(String cagip) {
		this.cagip = cagip;
	}

	@Column(name = "OPER_Temp", nullable = false, precision = 22, scale = 0)
	public Double getOperTemp() {
		return this.operTemp;
	}

	public void setOperTemp(Double operTemp) {
		this.operTemp = operTemp;
	}

	@Column(name = "DATA_PERIOD", nullable = false)
	public Integer getDataPeriod() {
		return this.dataPeriod;
	}

	public void setDataPeriod(Integer dataPeriod) {
		this.dataPeriod = dataPeriod;
	}

	@Column(name = "HEARTBEAT_PERIOD", nullable = false)
	public Integer getHeartbeatPeriod() {
		return this.heartbeatPeriod;
	}

	public void setHeartbeatPeriod(Integer heartbeatPeriod) {
		this.heartbeatPeriod = heartbeatPeriod;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "configCac")
	public Set<ConfigIed> getConfigIeds() {
		return this.configIeds;
	}

	public void setConfigIeds(Set<ConfigIed> configIeds) {
		this.configIeds = configIeds;
	}

}