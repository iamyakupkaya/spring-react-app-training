package kaya.yakup.questapp.configs;

import kaya.yakup.questapp.entities.CommentEntity;
import kaya.yakup.questapp.entities.PostEntity;
import kaya.yakup.questapp.entities.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityConfig {

    @Bean
    public UserEntity getUserEntity(){
        return new UserEntity();
    }
    @Bean
    public PostEntity getPostEntity(){
        return new PostEntity();
    }

    @Bean
    public CommentEntity getCommentEntity(){
        return new CommentEntity();
    }
}
