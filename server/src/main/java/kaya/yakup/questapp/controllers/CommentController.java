package kaya.yakup.questapp.controllers;

import kaya.yakup.questapp.entities.CommentEntity;
import kaya.yakup.questapp.requests.CommentCreateRequest;
import kaya.yakup.questapp.requests.CommentUpdateRequest;
import kaya.yakup.questapp.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {
    private ICommentService commentService;

    public CommentController() {
    }

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }
    // HTTP GETs METHODs

    // get all comments
    @GetMapping
    public List<CommentEntity> getAllComments(@RequestParam(name="userId") Optional<Long> userID, @RequestParam(name = "postId") Optional<Long> postID){
        return commentService.getAllComments(userID, postID);
    }

    @GetMapping(value = "/{commentID}")
    public CommentEntity getCommentById(@PathVariable Long commentID){
        return commentService.findCommentById(commentID);
    }

    // HTTP POSTs METHODs
    @PostMapping
    public CommentEntity createOneComment(@RequestBody CommentCreateRequest newComment){
        return commentService.createOneComment(newComment);
    }

    // HTTP PUTs METHODs

    @PutMapping(value = "/{commentID}")
    public CommentEntity updateCommentById(@PathVariable Long commentID, @RequestBody CommentUpdateRequest updateComment){
        return commentService.updateCommentById(commentID, updateComment);
    }

    // HTTP DELETEs METHODs

    @DeleteMapping(value = "/{commentID}")
    public void deleteCommentById(@PathVariable Long commentID){
        commentService.deleteCommentById(commentID);
    }







    // GETTERs and SETTERs

    public ICommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(ICommentService commentService) {
        this.commentService = commentService;
    }
}
