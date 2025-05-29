package pard.server.com.pardshort.post.responseDto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class TagsDto {
    private Long count;
    private List<String> tags;
}
