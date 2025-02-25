package com.ggrdiego.api_spring_boot.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant timestamp;
	private Integer status;
	private String error;
	private String messsage;
	private String path;
	
	public StandardError() {
		
	}

	public StandardError(Instant timestamp, Integer status, String error, String messsage, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.messsage = messsage;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
