package com.example.recognition.face.bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryByImageModelWithPageRequest {
	private Integer pageNo;
	private Integer pageSize;
	private String personLibId;
	private String modelData;
	private String imageUrl;
	private String imageData;
	private Integer maxResults;
	private Float minSimilarity;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getPersonLibId() {
		return personLibId;
	}

	public void setPersonLibId(String personLibId) {
		this.personLibId = personLibId;
	}

	public String getModelData() {
		return modelData;
	}

	public void setModelData(String modelData) {
		this.modelData = modelData;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public Float getMinSimilarity() {
		return minSimilarity;
	}

	public void setMinSimilarity(Float minSimilarity) {
		this.minSimilarity = minSimilarity;
	}
}
