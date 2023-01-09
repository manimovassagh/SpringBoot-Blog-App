package com.github.manimovassagh.blog.controller;


import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.PostDTO;
import com.github.manimovassagh.blog.payload.PostDtoV2;
import com.github.manimovassagh.blog.payload.PostResponse;
import com.github.manimovassagh.blog.service.serviceInterface.PostService;
import com.github.manimovassagh.blog.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(value = "http://localhost:3000/**")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/v1/posts")
    @CrossOrigin
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping("/api/v1/posts")
    @CrossOrigin
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // get post by id
    @GetMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }


    /**
     * versioning with gitHub style sample for version 4
     * @param id
     * @return
     */
    @GetMapping(value = "/api/posts/{id}",produces = "application/vnd.mani.v4+json")
    public ResponseEntity<PostDTO> getPostByIdWithGithubVersion(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }





    // get post by id
    @GetMapping("/api/v2/posts/{id}")
    public ResponseEntity<PostDtoV2> getPostByIdV2(@PathVariable(name = "id") long id){

       PostDTO postDto = postService.getPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setComments(postDto.getComments());
        postDtoV2.setContent(postDto.getContent());
        postDtoV2.setDescription(postDto.getDescription());
        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Spring boot");
        tags.add("AWS");
        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);


    }

    // get post by id with parameter versioning
    @GetMapping(value = "/api/posts/{id}",params = "version=2")
    public ResponseEntity<PostDtoV2> getPostByIdV2WithParams(@PathVariable(name = "id") long id){

        PostDTO postDto = postService.getPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setComments(postDto.getComments());
        postDtoV2.setContent(postDto.getContent());
        postDtoV2.setDescription(postDto.getDescription());
        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Spring boot");
        tags.add("AWS");
        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);

    }

    // get post by id with header versioning
    @GetMapping(value = "/api/posts/{id}",headers = "X-API-VERSION=3")
    public ResponseEntity<PostDtoV2> getPostByIdV2WithHeaderVersioning(@PathVariable(name = "id") long id){

        PostDTO postDto = postService.getPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setComments(postDto.getComments());
        postDtoV2.setContent(postDto.getContent());
        postDtoV2.setDescription(postDto.getDescription());
        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Spring boot");
        tags.add("AWS");
        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);

    }

    // update post by id rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDto, @PathVariable(name = "id") long id){

        PostDTO postResponse = postService.updatePost(postDto, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // delete post rest api
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){

        postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }



    @GetMapping("/api/v1/posts/search")
    public ResponseEntity<List<Post>> searchPost(@RequestParam String query) {
       List<Post> posts= postService.searchPost(query);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}

