package com.example.blogservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogservice.model.Blog;
import com.example.blogservice.model.BlogRepository;
import com.example.blogservice.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	
	
	@Autowired BlogRepository blogRepository;


	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	@Override
	public Blog getBlogById(Long blogId) {
		return blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not exist."));
	}

	@Override
	public Blog addBlog(Blog blog) {
		return blogRepository.save(blog);
	}
	
	
	@Override
	public Blog deleteBlog(Long blogId) {
		Blog blog = getBlogById(blogId);
		blogRepository.delete(blog);
		return blog;
	}
	
	@Override
	public Blog updateBlog(Long blogId) {
		Blog blog = getBlogById(blogId);
		blogRepository.save(blog);
		return blog;
	}



}
