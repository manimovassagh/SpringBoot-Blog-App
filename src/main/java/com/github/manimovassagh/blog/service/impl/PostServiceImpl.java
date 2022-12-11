package com.github.manimovassagh.blog.service.impl;

import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.exception.ResourceNotFoundException;
import com.github.manimovassagh.blog.payload.PostDTO;
import com.github.manimovassagh.blog.repository.PostRepository;
import com.github.manimovassagh.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }


    private PostDTO mapToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        return postDTO;
    }

    private Post mapToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        return post;
    }


}
