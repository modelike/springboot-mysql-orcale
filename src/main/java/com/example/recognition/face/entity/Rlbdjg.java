package com.example.recognition.face.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "rlbdjg")
public class Rlbdjg implements Serializable, Cloneable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -147532475088858670L;
	
	/** ID */
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String name;
	private String sfzId;
	private String ystp;//原始图片
	private String bdtp;//
	private Date time;
	private float similarity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSfzId() {
		return sfzId;
	}

	public void setSfzId(String sfz_id) {
		this.sfzId = sfz_id;
	}

	public String getYstp() {
		return ystp;
	}

	public void setYstp(String ystp) {
		this.ystp = ystp;
	}

	public String getBdtp() {
		return bdtp;
	}

	public void setBdtp(String bdtp) {
		this.bdtp = bdtp;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public float getSimilarity() {
		return similarity;
	}

	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}

}
