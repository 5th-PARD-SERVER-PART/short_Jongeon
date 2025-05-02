package pard.server.com.hw4.loke.likeRequest;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class UserAndPostId {
    private Long user_id;
    private Long post_id;
}

