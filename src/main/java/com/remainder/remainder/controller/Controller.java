package com.remainder.remainder.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.remainder.remainder.entities.Signup;
import com.remainder.remainder.response.ApiResponse;
import com.remainder.remainder.services.Service;
import jakarta.validation.Valid;

@RestController
public class Controller {
    @Autowired
    private Service service;
   
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> addDetails(@Valid @RequestBody Signup signup, BindingResult result) {
        // Check for validation errors
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : errors) {
                errorMsg.append(error.getDefaultMessage()).append("\n");
            }
            ApiResponse errorResponse = new ApiResponse(false, errorMsg.toString(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        // Proceed with saving the data if there are no validation errors
        Signup savedSignup = service.addDetails(signup);
        ApiResponse successResponse = new ApiResponse(true, "Successful", savedSignup.getId());
        return ResponseEntity.ok(successResponse);
    }
        
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        boolean isAuthenticated = service.authenticateUser(username, password);
        if (isAuthenticated) {
            // Fetch the user ID based on the username
            Long userId = service.getUserIdByUsername(username);
            ApiResponse successResponse = new ApiResponse(true, "Login successful", userId);
            return ResponseEntity.ok(successResponse);
        } else {
            ApiResponse errorResponse = new ApiResponse(false, "Invalid username or password", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
