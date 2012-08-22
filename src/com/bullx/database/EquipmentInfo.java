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
 * EquipmentInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "equipment_info", catalog = "bullx_i2")
public class EquipmentInfo implements java.io.Serializable {

	// Fields

	private String eqId;
	private String eqType;
	private String eqName;
	private Set<ConfigIed> configIeds = new HashSet<ConfigIed>(0);

	// Constructors

	/** default constructor */
	public EquipmentInfo() {
	}

	/** minimal constructor */
	public EquipmentInfo(String eqId) {
		this.eqId = eqId;
	}

	/** full constructor */
	public EquipmentInfo(String eqId, String eqType, String eqName,
			Set<ConfigIed> configIeds) {
		this.eqId = eqId;
		this.eqType = eqType;
		this.eqName = eqName;
		this.configIeds = configIeds;
	}

	// Property accessors
	@Id
	@Column(name = "EQ_ID", unique = true, nullable = false, length = 17)
	public String getEqId() {
		return this.eqId;
	}

	public void setEqId(String eqId) {
		this.eqId = eqId;
	}

	@Column(name = "EQ_TYPE", length = 20)
	public String getEqType() {
		return this.eqType;
	}

	public void setEqType(String eqType) {
		this.eqType = eqType;
	}

	@Column(name = "EQ_NAME", length = 20)
	public String getEqName() {
		return this.eqName;
	}

	public void setEqName(String eqName) {
		this.eqName = eqName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipmentInfo")
	public Set<ConfigIed> getConfigIeds() {
		return this.configIeds;
	}

	public void setConfigIeds(Set<ConfigIed> configIeds) {
		this.configIeds = configIeds;
	}

}