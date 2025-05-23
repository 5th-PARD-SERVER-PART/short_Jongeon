package pard.server.com.pardshort.post.responseDto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class ResponseDto {
    private String tag;
    private String content;
    private String question;
}
