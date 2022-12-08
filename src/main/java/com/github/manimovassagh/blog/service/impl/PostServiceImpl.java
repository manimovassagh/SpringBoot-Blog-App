package com.github.manimovassagh.blog.service.impl;

import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.PostDTO;
import com.github.manimovassagh.blog.repository.PostRepository;
import com.github.manimovassagh.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public PostDTO createPost(PostDTO postDTO) {

        //convert DTO to Entity
        Post post= new Post();
        post.setId(postDTO.getId());
        post.setTitle(post.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        Post savedPost = postRepository.save(post);
        //convert Entity to DTO
        PostDTO postDTOResponse= new PostDTO();
        postDTOResponse.setId(post.getId());
        postDTOResponse.setTitle(post.getTitle());
        postDTOResponse.setDescription(post.getDescription());
        postDTOResponse.setContent(post.getContent());
        return postDTOResponse;


    }
}
