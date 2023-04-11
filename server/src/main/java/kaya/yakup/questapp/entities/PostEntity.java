package kaya.yakup.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="posts")
public class PostEntity {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore //Json da ıgnore yani göz ardı edilmesini ve gösterilmemesini sağlar
    private UserEntity userEntity;
    private String title;
    @Lob // this annotastion for big data
    @Column(columnDefinition = "text") // we don't want VARCHAR
    private String text;

    public PostEntity() {
    }

    public PostEntity(UserEntity userEntity, String title, String text) {
        this.userEntity = userEntity;
        this.title = title;
        this.text = text;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
