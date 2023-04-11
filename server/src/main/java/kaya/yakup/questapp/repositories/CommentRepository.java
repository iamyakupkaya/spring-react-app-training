package kaya.yakup.questapp.repositories;

import kaya.yakup.questapp.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
