package com.adl.main.utility;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ImageConfigFaqs implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		exposeDirectory(registry,"faqs-image");
	}
	private void exposeDirectory(ResourceHandlerRegistry registry, String directori) {
		// TODO Auto-generated method stub
		Path uploadDirPath=Paths.get(directori);
		String uploadPath=uploadDirPath.toFile().getAbsolutePath();
		
		if(directori.startsWith("../")) {
			directori = directori.replace("../", "");
		}
		registry.addResourceHandler("/"+ directori +"/**").addResourceLocations("file:/" + uploadPath + "/");
	}

}
