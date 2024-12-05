package com.beehome.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beehome.dto.GeneratorPasswordDTO;
import com.beehome.model.GeneratorPassword;
import com.beehome.repository.GeneratorPasswordRepository;

@Service
public class GeneratorPasswordService {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";
    
    @Autowired
    public GeneratorPasswordRepository passwordRepository;

    public String generatePassword(int length, boolean upperCase, boolean lowerCase, boolean numbers, boolean specialChars) {
    	if (length < 6 || length > 20) {
            throw new IllegalArgumentException("Password length must be between 6 and 20 characters.");
        }
    	
    	StringBuilder charPool = new StringBuilder();
    	if (upperCase) charPool.append(UPPER_CASE);
    	if (lowerCase) charPool.append(LOWER_CASE);
    	if (numbers) charPool.append(NUMBERS);
    	if (specialChars) charPool.append(SPECIAL_CHARS);
    	

    	if (charPool.length() == 0) {
    	    throw new IllegalArgumentException("At least one character type must be selected.");
    	}

    	SecureRandom random = new SecureRandom();
    	StringBuilder password = new StringBuilder();

    	if (upperCase) {
    	    password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
    	}
    	if (lowerCase) {
    	    password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
    	}
    	if (numbers) {
    	    password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
    	}
    	if (specialChars) {
    	    password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
    	}

    	String shuffledPassword = shuffleString(password.toString());
    	
        GeneratorPassword passwordEntity = new GeneratorPassword();
        passwordEntity.setPassword(shuffledPassword);
        passwordEntity.setGeneratedAt(LocalDateTime.now());
        passwordRepository.save(passwordEntity);

        return shuffledPassword;
    }
    
    private String shuffleString(String password) {
        Random random = new Random();
        StringBuilder shuffled = new StringBuilder(password);
        for (int i = password.length() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = shuffled.charAt(i);
            shuffled.setCharAt(i, shuffled.charAt(j));
            shuffled.setCharAt(j, temp);
        }
        return shuffled.toString();
    }
    
    public List<GeneratorPasswordDTO> getPasswordHistory() {
        return passwordRepository.findAllByOrderByGeneratedAtDesc()
                .stream()
                .map(GeneratorPassword::toDTO) 
                .collect(Collectors.toList());
    }

    
}
