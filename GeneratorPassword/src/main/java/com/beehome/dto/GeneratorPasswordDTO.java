package com.beehome.dto;

import java.time.LocalDateTime;

public class GeneratorPasswordDTO {
	private String password;
    private LocalDateTime dateTime;
    
    public GeneratorPasswordDTO( String password, LocalDateTime dateTime) {
        this.password = password;
        this.dateTime = dateTime;
    }
    
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
