package com.asurint.interview.exercise.sluggenerator.service;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asurint.interview.exercise.sluggenerator.model.Url;
import com.asurint.interview.exercise.sluggenerator.repository.UrlRepository;

/**
 * 
 * @author daniyal
 * 
 * Implementation of URLService
 *
 */

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	UrlRepository urlRepo;
	private static final Pattern SPECIALCHAR = Pattern.compile("[^\\w-]");
	private static final Pattern SPACE = Pattern.compile("[\\s]");
	
	

	@Override
	public Url findOneBySlug(String slug) {
	
		return urlRepo.findOneBySlug(slug);
	}
	
	@Override
	public Url saveUrl(String desc ,String url) {
		
		Url urlObj = new Url();
		String slug = toSlug(desc);
		
		urlObj.setDesc(desc);
		urlObj.setSlug(slug);
		urlObj.setUrl(url);
		return urlRepo.save(urlObj);
	}
	
	
	
	
	/**
	 * This method will remove special characters and white spaces from the input string 
	 * and will replace 
	 * @->at
	 * &->and
	 * %->percent
	 * @param desc 
	 * @return generated Slug
	 */
	private String toSlug(String desc) {
		
		desc  = desc.replace("-", "");
		desc = desc.replace("&","and");
		desc = desc.replace("@", "at");
		desc = desc.replace("%","percent");
		
		String noSpace = SPACE.matcher(desc).replaceAll("-");
		String normalized = Normalizer.normalize(noSpace,Form.NFD);
		String slug = SPECIALCHAR.matcher(normalized).replaceAll("");
		
		return slug.toLowerCase(Locale.ENGLISH);
	}





	

}
