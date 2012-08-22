package com.bullx.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileManagement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "file_management", catalog = "bullx_i2")
public class FileManagement implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private String filename;
	private String version;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public FileManagement() {
	}

	/** full constructor */
	public FileManagement(String filename, String version, Timestamp time) {
		this.filename = filename;
		this.version = version;
		this.time = time;
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

	@Column(name = "FILENAME", nullable = false, length = 15)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "VERSION", nullable = false, length = 15)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "TIME", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}