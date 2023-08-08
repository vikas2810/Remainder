package com.remainder.remainder.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.remainder.remainder.dao.Registerdao;
import com.remainder.remainder.entities.Signup;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {	
	@Autowired
	private Registerdao registerdao;	
	public ServiceImpl() {		
			}
	@Override
	public List<Signup> getDetails() {		
		return registerdao.findAll();
	}	
	public Signup addDetails(Signup signup) {
		return registerdao.save(signup);
	}
	@Override
	public boolean authenticateUser(String username, String password) {
	    List<Signup> users = registerdao.findAll();
	    for (Signup user : users) {
	        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	            return true;
	        }
	    }
	    return false;
	}
	@Override
	public Long getUserIdByUsername(String username) {
        Signup user = registerdao.findByUsername(username);
        return (user != null) ? user.getId() : null;
	}

}
