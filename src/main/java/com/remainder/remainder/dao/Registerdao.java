package com.remainder.remainder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.remainder.remainder.entities.Signup;

public interface Registerdao extends JpaRepository<Signup, String> {

	Signup findByUsername(String username);
	
}


