package com.github.manimovassagh.blog.repository;

import com.github.manimovassagh.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post,Long> {
}
