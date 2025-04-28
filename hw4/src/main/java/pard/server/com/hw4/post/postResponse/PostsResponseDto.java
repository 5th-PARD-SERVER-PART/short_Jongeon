package pard.server.com.hw4.post.postResponse;

import lombok.*;

import java.sql.Timestamp;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class PostsResponseDto {
    private Long post_id;
    private String postContents;
    private Timestamp postedTime;
}
