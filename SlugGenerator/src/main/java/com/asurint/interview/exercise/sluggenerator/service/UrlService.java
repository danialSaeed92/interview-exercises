package com.asurint.interview.exercise.sluggenerator.service;

import org.springframework.stereotype.Service;

import com.asurint.interview.exercise.sluggenerator.model.Url;

/**
 * This interface is responsible for having all the business logic for URL Object
 * @author daniyal
 *
 */
@Service
public interface UrlService {

	/**
	 * This method will persist the URL object
	 * @param desc
	 * @param url
	 * @return
	 */
	Url saveUrl(String desc ,String url);
	
	
	
	/**
	 * Find url by generated slug
	 * @param slug
	 * @return
	 */
	Url findOneBySlug(String slug);
}
