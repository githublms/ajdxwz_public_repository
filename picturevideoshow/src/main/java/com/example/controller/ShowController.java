package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/imageVideo")
public class ShowController {

	
	@Value("${show.image}")
	private String image;
	
	@Value("${show.video}")
	private String video;
	private final ResourceLoader resourceLoader;
	
	@Autowired
	public ShowController(ResourceLoader resourceLoader) {
		super();
		this.resourceLoader = resourceLoader;
	}
	
	private static final Logger log = LoggerFactory.getLogger(ShowController.class);

	@GetMapping("/show")
	public ResponseEntity show(@RequestParam("fileName") String fileName) {
		try {
			String file = "file:" + image + fileName;// 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
			log.info("===图片的地址{}===", file);
			return ResponseEntity.ok(resourceLoader.getResource(file));
		} catch (Exception e) {
			log.info("图片获取失败:{}", e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/videoshow")
	public ResponseEntity videoshow(@RequestParam("fileName") String fileName) {
		try {
			String file = "file:" + video + fileName;// 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
			log.info("===图片的地址{}===", file);
			return ResponseEntity.ok(resourceLoader.getResource(file));
		} catch (Exception e) {
			log.info("图片获取失败:{}", e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	
}
