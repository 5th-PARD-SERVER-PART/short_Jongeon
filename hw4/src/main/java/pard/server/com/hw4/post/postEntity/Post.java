package pard.server.com.hw4.post.postEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pard.server.com.hw4.loke.likeEntity.Loke;
import pard.server.com.hw4.user.userEntity.User;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String postContents;

    @CreationTimestamp
    private Timestamp postedTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loke> likes;


    public void updateContents(String postContent){
        this.postContents = postContent;
    }

}
