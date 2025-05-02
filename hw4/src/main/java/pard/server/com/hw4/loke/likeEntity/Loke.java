package pard.server.com.hw4.loke.likeEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.server.com.hw4.post.postEntity.Post;
import pard.server.com.hw4.user.userEntity.User;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long like_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
