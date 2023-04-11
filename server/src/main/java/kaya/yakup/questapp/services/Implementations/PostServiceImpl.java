package kaya.yakup.questapp.services.Implementations;

import kaya.yakup.questapp.entities.PostEntity;
import kaya.yakup.questapp.entities.UserEntity;
import kaya.yakup.questapp.repositories.PostRepository;
import kaya.yakup.questapp.requests.PostCreateRequest;
import kaya.yakup.questapp.requests.PostUpdateRequest;
import kaya.yakup.questapp.services.IPostService;
import kaya.yakup.questapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {

    private PostRepository postRepository;
    private IUserService userService;
    public PostServiceImpl() {
    }

    @Autowired
    public PostServiceImpl(PostRepository postRepository, IUserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public List<PostEntity> findAllPosts(Optional<Long> userID) {
        if(userID.isPresent()){
             return postRepository.findByUserEntityId(userID.get());

        }
        return postRepository.findAll();
    }

    @Override
    public PostEntity findPostById(Long postID) {
        return postRepository.findById(postID).orElse(null);
    }

    @Override
    public PostEntity createOnePost(PostCreateRequest newPost) {
        UserEntity user = userService.findUserById(newPost.getUserId());
        if(user == null){
            return null;
        }
        PostEntity toSave = new PostEntity();
        toSave.setId(newPost.getId());
        toSave.setTitle(newPost.getTitle());
        toSave.setText(newPost.getText());
        toSave.setUserEntity(user);

        return postRepository.save(toSave);
    }

    @Override
    public PostEntity updateOnePost(Long postID, PostUpdateRequest updatePost) {
        Optional<PostEntity> post = postRepository.findById(postID);
        //System.out.println(post); Optinal halde nesnenin referansı döner
        //System.out.println(post.get()); get ile nesnenin referansı döndürülür!
        if (post.isPresent()){
            PostEntity toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    @Override
    public void deleteOnePost(Long postID) {
        postRepository.deleteById(postID);
    }

    // GETTERs and SETTERs
    public PostRepository getPostRepository() {
        return postRepository;
    }

    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
