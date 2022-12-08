package com.github.manimovassagh.blog.service.impl;

import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.PostDTO;
import com.github.manimovassagh.blog.repository.PostRepository;
import com.github.manimovassagh.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {

        //convert DTO to Entity

        Post post = mapToEntity(postDTO);

        //save to repository
        Post savedPost = postRepository.save(post);

        //convert Entity to DTO
        PostDTO postDtoResponse = mapToDTO(post);
        return postDtoResponse;


    }


    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> listOfPosts = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        return listOfPosts;
    }


    private PostDTO mapToDTO(Post post){
        PostDTO postDTO=new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        return postDTO;
    }

    private Post mapToEntity(PostDTO postDTO){
       Post post=new Post();
       post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        return post;
    }



}
