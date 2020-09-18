package com.asurint.interview.exercise.sluggenerator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asurint.interview.exercise.sluggenerator.model.Url;
import com.asurint.interview.exercise.sluggenerator.service.UrlService;

/**
 * 
 * @author daniyal
 * 
 *         This class will have the url mapping of the exposed APIs
 *
 */

@Controller
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	@GetMapping("/index")
	public String welcome() {
		return "index";
	}

	@PostMapping("/redirectSlug")
	public String findUrl(HttpServletResponse response,@RequestParam("slug") String slug,Model model) {
		Url urlObj = null;
		String message = "";
		String location="";
		try {
			urlObj = urlService.findOneBySlug(slug);
			location = urlObj.getUrl();
		} catch (Exception exception) {
			message = "No Slug Found "+ exception.getMessage();
			model.addAttribute("msg", message);
			location="/index";
					
			
			
		}
		return "redirect:" + location;

		
	}
	
	@PostMapping("/addUrl")
	public String addUrl(HttpServletRequest request, Model model,@RequestParam("desc") String desc, @RequestParam("url") String url) {
		String message = "";
		try {
			Url urlObj  = urlService.saveUrl(desc, url);
			model.addAttribute("slug", urlObj.getSlug());
			model.addAttribute("desc", urlObj.getDesc());
			model.addAttribute("url", urlObj.getUrl());
			message ="slug generated successfully";
			model.addAttribute("msg", message);
			
		}catch(Exception exception) {
			model.addAttribute("msg", exception.getMessage());
		}
		return "viewSlug";
	}
	
	@GetMapping("/error")
	public String error(HttpServletRequest request,Model model) {
		return "error";
	}
}
