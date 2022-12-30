package com.github.manimovassagh.blog.repository;

import com.github.manimovassagh.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE " +
            "p.title LIKE CONCAT ('%',:query,'%')" +
            "OR p.description LIKE CONCAT ('%',:query,'%')")
    List<Post> searchPost(String query);

    //native query sample
    @Query(value = "SELECT * FROM Post p WHERE " +
            "p.title LIKE CONCAT ('%',:query,'%')" +
            "OR p.description LIKE CONCAT ('%',:query,'%')", nativeQuery = true)
    List<Post> searchPostNative(String query);
}
