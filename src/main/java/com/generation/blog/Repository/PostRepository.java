package com.generation.blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    public List<Post> findAllByTitleContainingIgnoreCase(@Param("title") String title);
    
}