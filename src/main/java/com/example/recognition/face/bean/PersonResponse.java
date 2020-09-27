package com.example.recognition.face.bean;

public class PersonResponse {
	private String code;
	private String msg;
	private PersonPage data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public PersonPage getData() {
		return data;
	}

	public void setData(PersonPage data) {
		this.data = data;
	}

}
