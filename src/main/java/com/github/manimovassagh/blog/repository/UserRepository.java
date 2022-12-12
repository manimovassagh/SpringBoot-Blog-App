package com.github.manimovassagh.blog.repository;

import com.github.manimovassagh.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
