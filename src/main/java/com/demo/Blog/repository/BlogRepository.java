package com.demo.Blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.Blog.domain.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
    @Query("SELECT b FROM Blog b GROUP BY b.id ORDER BY b.created_at desc limit 1")
	public List<Blog> getNewestID();
}
