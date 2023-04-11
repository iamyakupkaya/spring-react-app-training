package kaya.yakup.questapp.repositories;

import kaya.yakup.questapp.entities.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
}
