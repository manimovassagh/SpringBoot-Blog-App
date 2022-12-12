package com.github.manimovassagh.blog.repository;

import com.github.manimovassagh.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
