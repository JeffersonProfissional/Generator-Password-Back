package com.beehome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beehome.dto.GeneratorPasswordDTO;
import com.beehome.dto.PasswordRequestDTO;
import com.beehome.service.GeneratorPasswordService;

@RestController
@RequestMapping("/api")
public class GeneratorPasswordController {
	@Autowired
    public GeneratorPasswordService passwordService;

	@PostMapping(value = "/generate-password")
    public ResponseEntity<?> generatePassword(@RequestBody PasswordRequestDTO request) {
        String generatedPassword = passwordService.generatePassword(
                request.getLength(),
                request.isUpperCase(),
                request.isLowerCase(),
                request.isNumbers(),
                request.isSpecialChars()
        );

        return ResponseEntity.ok().body(new GeneratorPasswordDTO(generatedPassword, null));
	}
	
    @GetMapping("/password_history")
    public ResponseEntity<List<GeneratorPasswordDTO>> getPasswordHistory() {
        return ResponseEntity.ok().body(passwordService.getPasswordHistory());
    }
}
