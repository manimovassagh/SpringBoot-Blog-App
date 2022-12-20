package com.github.manimovassagh.blog.service.impl;

import com.github.manimovassagh.blog.entity.Comment;
import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.exception.BlogApiException;
import com.github.manimovassagh.blog.exception.ResourceNotFoundException;
import com.github.manimovassagh.blog.payload.CommentDto;
import com.github.manimovassagh.blog.repository.CommentRepository;
import com.github.manimovassagh.blog.repository.PostRepository;
import com.github.manimovassagh.blog.service.serviceInterface.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ModelMapper mapper;

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);
        //retrieve Post Entity base on ID
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        //set post to comment entity
        comment.setPost(post);

        //save comment entity to database
        Comment generatedComment = commentRepository.save(comment);
        return mapToDto(generatedComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {

        //retrieve comments by Post ID
        List<Comment> comments = commentRepository.findByPostId(postId);
        //convert List of comment entities to comment DTO
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        //retrieve Post Entity base on ID
        Comment comment = getComment(postId, commentId);
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest) {
        //retrieve Post Entity base on ID
        Comment comment = getComment(postId, commentId);


        comment.setName(commentRequest.getName());
        comment.setBody(commentRequest.getBody());
        comment.setEmail(commentRequest.getEmail());
        Comment updatedComment = commentRepository.save(comment);
        return mapToDto(updatedComment);
    }


    @Override
    public void deleteComment(Long postId, Long commentId) {
        //retrieve Post Entity base on ID
        Comment comment = getComment(postId, commentId);
        commentRepository.delete(comment);
        return;
    }


    //TO PREVENT DUPLICATION REFACTORED TO SEPARATE FUNCTION
    private Comment getComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        //retrieve comment by ID
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to a post !!");
        }
        return comment;
    }
    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = mapper.map(comment, CommentDto.class);
        return commentDto;
    }


    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = mapper.map(commentDto,Comment.class);
        return comment;
    }


}
