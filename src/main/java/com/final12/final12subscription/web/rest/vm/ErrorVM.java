package com.final12.final12subscription.web.rest.vm;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ErrorVM implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime timestamp;

	private Integer status;

	private String error;

	private String message;

	private Object trace;

	@JsonInclude(Include.NON_NULL)
	private Map<String, Object> violations;

	private String path;

	public ErrorVM(HttpStatus httpStatus) {
		timestamp = LocalDateTime.now();
		status = httpStatus.value();
		error = httpStatus.getReasonPhrase();
	}

	public void addViolation(String key, Object value) {
		if (violations == null) {
			violations = new HashMap<>();
		}
		
		violations.put(key, value);
	}
}
