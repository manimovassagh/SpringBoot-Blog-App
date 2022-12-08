package com.github.manimovassagh.blog.service.impl;

import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.PostDTO;
import com.github.manimovassagh.blog.repository.PostRepository;
import com.github.manimovassagh.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {

        //convert DTO to Entity

        Post post = mapFromDTO(postDTO);

        //save to repository
        Post savedPost = postRepository.save(post);

        //convert Entity to DTO
        PostDTO postDtoResponse = mapToDTO(post);
        return postDtoResponse;


    }


    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
       return null;
    }


    private PostDTO mapToDTO(Post post){
        PostDTO postDTO=new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        return postDTO;
    }

    private Post mapFromDTO(PostDTO postDTO){
       Post post=new Post();
       post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        return post;
    }



}
