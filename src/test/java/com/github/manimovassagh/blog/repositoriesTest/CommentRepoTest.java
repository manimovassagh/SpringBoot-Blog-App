package com.github.manimovassagh.blog.repositoriesTest;


import com.github.manimovassagh.blog.entity.Comment;
import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class CommentRepoTest {

    @Mock
    private JpaRepository<Comment, Long> jpaRepository;

    @InjectMocks
    private CommentRepository commentRepository;

    @Test
    public void testFindByPostId() {
        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setPost(new Post());

        Comment comment2 = new Comment();
        comment2.setId(2);
        comment2.setPost(new Post());

        List<Comment> comments = Arrays.asList(comment1, comment2);

        when(jpaRepository.findAll()).thenReturn(comments);

        List<Comment> result = commentRepository.findByPostId(1);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
    }
}
