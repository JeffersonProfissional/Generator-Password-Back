package com.beehome.model;

import java.time.LocalDateTime;

import com.beehome.dto.GeneratorPasswordDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "password_history")
public class GeneratorPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "VARCHAR(20)")
    @NotBlank()
    private String password;
    
    @NotBlank()
    private LocalDateTime generatedAt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
    
    public GeneratorPasswordDTO toDTO() {
        return new GeneratorPasswordDTO(this.password, this.generatedAt);
    }
}