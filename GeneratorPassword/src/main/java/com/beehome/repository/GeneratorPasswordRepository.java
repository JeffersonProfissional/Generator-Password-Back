package com.beehome.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.beehome.model.GeneratorPassword;

@Repository
@EnableJpaRepositories
public interface GeneratorPasswordRepository extends JpaRepository<GeneratorPassword, Long> {
	
	@Autowired
    List<GeneratorPassword> findAllByOrderByGeneratedAtDesc();
}
