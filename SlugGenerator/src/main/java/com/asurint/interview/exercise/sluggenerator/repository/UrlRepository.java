package com.asurint.interview.exercise.sluggenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asurint.interview.exercise.sluggenerator.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	
	Url findOneBySlug(String slug);
	

}
