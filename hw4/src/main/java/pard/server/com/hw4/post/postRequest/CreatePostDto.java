package pard.server.com.hw4.post.postRequest;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class CreatePostDto {
    private String contents;
    private Long userId;
}
