package com.generation.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    
}