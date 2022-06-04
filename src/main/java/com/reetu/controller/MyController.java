package com.reetu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Furniture;

@Controller
public class MyController {
	
	RestTemplate resttemplate=new RestTemplate();
	String URL="http://localhost:9797";
	
	@RequestMapping("/")
	public String returnpade() {
		return "index";
	}

	@RequestMapping("/addfurniture")
	public String addfurniture(@ModelAttribute Furniture f, MultipartFile image, Model m) {
		String API="/add";
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		LinkedMultiValueMap<String, Object> data=new LinkedMultiValueMap<>();
		data.add("Furniture", f);
		data.add("image", convert(image));
		
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity=new HttpEntity<>(data,header);
		ResponseEntity<String> result=resttemplate.postForEntity(URL+API, requestEntity, String.class);
		if(result.getStatusCode()==HttpStatus.OK) {
			m.addAttribute("status", "Successfully Added!");
		}else {
			m.addAttribute("status", "Aleady Exists!");
		}
		return "index";
		
	}
	
	//code for converting file into Filesystemresource
	public static FileSystemResource convert(MultipartFile file) {
		File convertf=new File(file.getOriginalFilename());
		try {
			convertf.createNewFile();
			FileOutputStream fos=new FileOutputStream(convertf);
			fos.write(file.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new FileSystemResource(convertf);
	}
	
	@ModelAttribute
	public void getallname(Model m) {
		String API="/getallname";
		List<String> allname=resttemplate.getForObject(URL+API, List.class);
		m.addAttribute("allname",allname);
		
	}
	
	@RequestMapping("/updatehere")
	public String update(@ModelAttribute Furniture f, MultipartFile image, Model m) {
		String API="/update";
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		LinkedMultiValueMap<String, Object> data=new LinkedMultiValueMap<>();
		data.add("Furniture", f);
		data.add("image", convert(image));
		
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity=new HttpEntity<>(data,header);
		ResponseEntity<String> sts=resttemplate.exchange(URL+API, HttpMethod.PUT, requestEntity, String.class);
		if(sts.getStatusCode()==HttpStatus.OK) {
			m.addAttribute("sts", "Successfully Updated!");
		}else {
			m.addAttribute("sts", "Something Went Wrong!");
		}
		
		API="/getall";
		List<Furniture> fn=resttemplate.getForObject(URL+API, List.class);
		m.addAttribute("furniture", fn);
		
		return "update";
	}
	
	@RequestMapping("/update")
	public String Update() {
		return "update";
	}
	
     @RequestMapping("/viewall")
	public Stringhttps://github.com/ReetuChauhann/SpringBootRESTful-furniture.git page(Model m) {
		String API="/getall";
		List<Furniture> f=resttemplate.getForObject(URL+API, List.class);
		m.addAttribute("furniture", f);
		return "viewall";
	
	}
	
//	@RequestMapping("/viewall")
//	public String page() {
//		return "viewall";
//	}
	
	@RequestMapping("/getimage")
	public void getimage(String name, HttpServletResponse response) {
		String API="/getimage/"+name;
		try {
			byte[] b=resttemplate.getForObject(URL+API, byte[].class);
			response.getOutputStream().write(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
