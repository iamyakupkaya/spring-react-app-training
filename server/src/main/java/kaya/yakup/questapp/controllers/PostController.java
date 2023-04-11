package kaya.yakup.questapp.controllers;

import kaya.yakup.questapp.entities.PostEntity;
import kaya.yakup.questapp.requests.PostCreateRequest;
import kaya.yakup.questapp.requests.PostUpdateRequest;
import kaya.yakup.questapp.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/posts")
public class PostController {

    private IPostService postService;

    public PostController() {
    }

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostEntity> findAllPosts(@RequestParam Optional<Long> userID){
        System.out.println("Pst get içerisi");
        return postService.findAllPosts(userID);
    }
    @GetMapping(value = "/{postID}")
    public PostEntity findPostById(@PathVariable Long postID){
        return postService.findPostById(postID);
    }
    @PostMapping
    public PostEntity createOnePost(@RequestBody PostCreateRequest newPost){
        return postService.createOnePost(newPost);

    }
    @PutMapping(value = "/{postID}")
    public PostEntity updateOnePost(@PathVariable Long postID, @RequestBody PostUpdateRequest updatePost){
        return postService.updateOnePost(postID, updatePost);
    }
    @DeleteMapping(value = "/{postID}")
    public void deleteOnePost(@PathVariable Long postID){
        postService.deleteOnePost(postID);
    }
}
