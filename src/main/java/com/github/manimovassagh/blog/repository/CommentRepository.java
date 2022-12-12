package com.github.manimovassagh.blog.repository;

import com.github.manimovassagh.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
