package kaya.yakup.questapp.services;

import kaya.yakup.questapp.entities.PostEntity;
import kaya.yakup.questapp.requests.PostCreateRequest;
import kaya.yakup.questapp.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IPostService {
   public abstract List<PostEntity> findAllPosts(Optional<Long> userID);

   PostEntity findPostById(Long postID);

   PostEntity createOnePost(PostCreateRequest newPost);

   PostEntity updateOnePost(Long postID, PostUpdateRequest updatePost);

   void deleteOnePost(Long postID);
}
