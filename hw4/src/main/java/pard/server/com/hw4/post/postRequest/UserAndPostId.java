package pard.server.com.hw4.post.postRequest;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class UserAndPostId {
    private Long user_id;
    private Long post_id;
}
