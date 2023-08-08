package com.remainder.remainder.response;

public class ApiResponse {
    private boolean status;
    private String message;
    private Long id;
    
    public ApiResponse(boolean status, String message, Long id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }
	public boolean isStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Long getId() {
		return id;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
