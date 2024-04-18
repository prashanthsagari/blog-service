package com.example.blogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogservice.model.Blog;
import com.example.blogservice.service.BlogService;

@RestController
public class BlogController {

	@Autowired
	BlogService blogService;

	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs() {
		return new ResponseEntity<List<Blog>>(blogService.getAllBlogs(), HttpStatus.OK);
	}

	@GetMapping("/blog/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
		return new ResponseEntity<Blog>(blogService.getBlogById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/blog/{id}")
	public ResponseEntity<Blog> DeleteBlogById(@PathVariable Long id) {
		return new ResponseEntity<Blog>(blogService.deleteBlog(id), HttpStatus.OK);
	}
	
	@PatchMapping("/blog/{id}")
	public ResponseEntity<Blog> updateBlogById(@PathVariable Long id) {
		return new ResponseEntity<Blog>(blogService.updateBlog(id), HttpStatus.OK);
	}

	@PostMapping("/blog")
	public ResponseEntity<Blog> addBook(@RequestBody Blog blog) {
		return new ResponseEntity<Blog>(blogService.addBlog(blog), HttpStatus.OK);
	}

}
