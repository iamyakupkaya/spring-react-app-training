package kaya.yakup.questapp.services;

import kaya.yakup.questapp.entities.CommentEntity;
import kaya.yakup.questapp.requests.CommentCreateRequest;
import kaya.yakup.questapp.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    public abstract List<CommentEntity> getAllComments(Optional<Long> userID, Optional<Long> postID);

    CommentEntity findCommentById(Long commentID);

    CommentEntity createOneComment(CommentCreateRequest newComment);

    CommentEntity updateCommentById(Long commentID, CommentUpdateRequest updateComment);

    void deleteCommentById(Long commentID);
}
