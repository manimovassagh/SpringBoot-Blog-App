package com.github.manimovassagh.blog.repository;

import com.github.manimovassagh.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
//name
    Optional<Role> findByName(String name);
}
