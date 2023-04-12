package kaya.yakup.questapp.repositories;

import kaya.yakup.questapp.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByUserEntityIdAndPostEntityId(Long userID, Long postID);
    List<CommentEntity> findByUserEntityId(Long userID);
    List<CommentEntity> findByPostEntityId(Long postID);
}
