package com.remainder.remainder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
@Entity
public class Signup {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	    @NotEmpty(message = "Username cannot be empty")
	    private String username;

	    @Email(message = "Email address is not valid")
	    @NotEmpty(message = "Email cannot be empty")
	    private String email;

	    @NotEmpty(message = "Password cannot be empty")
	    @Size(min = 3, max = 10, message = "Password must be between 3 and 10 characters")
	    private String password;
	
	
	public Signup(Long id, @NotEmpty(message = "Username cannot be empty") String username,
				@Email(message = "Email address is not valid") @NotEmpty(message = "Email cannot be empty") String email,
				@NotEmpty(message = "Password cannot be empty") @Size(min = 3, max = 10, message = "Password must be between 3 and 10 characters") String password) {
			super();
			this.id = id;
			this.username = username;
			this.email = email;
			this.password = password;
		}
	public Signup() {
		super();
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Signup [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
}
