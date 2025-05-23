package pard.server.com.pardshort.post.requestDto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class RequestDto {
    private String question;
    private String tag;
    private String content;
}
