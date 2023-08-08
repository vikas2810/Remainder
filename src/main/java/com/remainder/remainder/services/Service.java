package com.remainder.remainder.services;

import java.util.List;

import com.remainder.remainder.entities.Signup;

public interface Service {
 
	public List<Signup> getDetails();
	public Signup addDetails(Signup signup);
    public boolean authenticateUser(String username, String password);
	public Long getUserIdByUsername(String username);
}
