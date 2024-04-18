package com.example.blogservice.service;

import java.util.List;

import com.example.blogservice.model.Blog;

public interface BlogService {

	public List<Blog> getAllBlogs();

	public Blog getBlogById(Long blogId);

	public Blog addBlog(Blog blog);
	
	public Blog deleteBlog(Long blogId);
	
	public Blog updateBlog(Long blogId);

}
