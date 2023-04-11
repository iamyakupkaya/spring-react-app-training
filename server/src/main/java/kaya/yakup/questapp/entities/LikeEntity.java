package kaya.yakup.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="likes")
//@Data // data from lombok. is a shortcut for @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class LikeEntity {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore //Json da ıgnore yani göz ardı edilmesini ve gösterilmemesini sağlar
    private UserEntity userEntity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore //Json da ıgnore yani göz ardı edilmesini ve gösterilmemesini sağlar
    private PostEntity postEntity;

    public LikeEntity() {
    }

    public LikeEntity(UserEntity userEntity, PostEntity postEntity) {
        this.userEntity = userEntity;
        this.postEntity = postEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public PostEntity getPostEntity() {
        return postEntity;
    }

    public void setPostEntity(PostEntity postEntity) {
        this.postEntity = postEntity;
    }
}
