package kaya.yakup.questapp.services.Implementations;

import kaya.yakup.questapp.configs.EntityConfig;
import kaya.yakup.questapp.entities.CommentEntity;
import kaya.yakup.questapp.entities.PostEntity;
import kaya.yakup.questapp.entities.UserEntity;
import kaya.yakup.questapp.repositories.CommentRepository;
import kaya.yakup.questapp.requests.CommentCreateRequest;
import kaya.yakup.questapp.requests.CommentUpdateRequest;
import kaya.yakup.questapp.services.ICommentService;
import kaya.yakup.questapp.services.IPostService;
import kaya.yakup.questapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    private CommentRepository commentRepository;
    private IUserService userService;
    private IPostService postService;
    private EntityConfig entityConfig;

    public CommentServiceImpl() {
    }

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, IUserService userService, IPostService postService, EntityConfig entityConfig) {
        this.commentRepository = commentRepository;
        this.userService=userService;
        this.postService = postService;
        this.entityConfig = entityConfig;
    }
    // Implementation Methods

    @Override
    public List<CommentEntity> getAllComments(Optional<Long> userID, Optional<Long> postID) {
        System.out.println(userID);
        if(userID.isPresent() && postID.isPresent()){
           return commentRepository.findByUserEntityIdAndPostEntityId(userID.get(), postID.get());
        }
        else if (userID.isPresent()) {
            return commentRepository.findByUserEntityId(userID.get());
        } else if (postID.isPresent()) {
            return commentRepository.findByPostEntityId(postID.get());
        }
        else {
            return commentRepository.findAll();
        }
    }

    // Implementation Methods
    @Override
    public CommentEntity findCommentById(Long commentID) {
        return commentRepository.findById(commentID).orElse(null);
    }

    @Override
    public CommentEntity createOneComment(CommentCreateRequest newComment) {
        UserEntity user = userService.findUserById(newComment.getUserId());
        PostEntity post = postService.findPostById(newComment.getPostId());
        if(user != null && post != null){
           CommentEntity commentEntityToSave = entityConfig.getCommentEntity();
           commentEntityToSave.setId(newComment.getId());
           commentEntityToSave.setText(newComment.getText());
           commentEntityToSave.setPostEntity(post);
           commentEntityToSave.setUserEntity(user);
            return commentRepository.save(commentEntityToSave);
        }
        else
            return null;
    }

    @Override
    public CommentEntity updateCommentById(Long commentID, CommentUpdateRequest updateComment) {
        Optional<CommentEntity> comment = commentRepository.findById(commentID);
        if(comment.isPresent()){
            CommentEntity commentToUpdate = comment.get();
            commentToUpdate.setText(updateComment.getText());
            return commentRepository.save(commentToUpdate);
        }
        else
        return null;
    }

    @Override
    public void deleteCommentById(Long commentID) {
        commentRepository.deleteById(commentID);
    }

    // GETTERs and SETTERs

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
