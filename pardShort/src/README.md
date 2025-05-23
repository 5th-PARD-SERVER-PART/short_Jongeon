# Post API 명세서

---

## 1. 포스트 생성

* **URL**: `/post`
* **Method**: `POST`
* **Request Body**:

```json
{
  "question": "오늘 무엇을 배웠나요",
  "tag": "논리설계",
  "content": "재밌는거"
}
```

* **Response**: `200 OK` 또는 `201 Created`

---

## 2. 태그로 포스트 조회

* **URL**: `/post/{tag}`
* **Method**: `GET`
* **Response**:

```json
[
  {
    "tag": "논리설계",
    "content": "ㅇ",
    "question": "수업 내용을 내가 직접 설명한다면 어떻게 말할까?"
  },
  {
    "tag": "논리설계",
    "content": "사랑해요 이 한마디",
    "question": "수업 내용을 내가 직접 설명한다면 어떻게 말할까?"
  }
]
```

---

package pard.server.com.pardshort.post.entity;

```
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor @Builder
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @CreationTimestamp
    private Timestamp timestamp;

    private String tag;
    private String content;
    private String question;
    private static int count = 0;

    public static void plusCount(){
        count ++;
    }
}
```

저의 누추한 Entity입니다.
tag, content question등 있습니다.


```
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;

    public void createPost(RequestDto requestDto){
        Post post = Post.builder()
                .tag(requestDto.getTag())
                .content(requestDto.getContent())
                .question(requestDto.getQuestion())
                .build();

        Post.plusCount();
        postRepo.save(post);
    }

    public List<ResponseDto> readPostsBySubject(String tag){
        List<Post> posts= postRepo.findAllByTag(tag);

        return posts.stream().map(
                post -> ResponseDto.builder()
                        .content(post.getContent())
                        .question(post.getQuestion())
                        .tag(post.getTag())
                        .build()).toList();
    }
}
```

저의 service 정보를 받아 RequestDto에 담아 저장합니다.
또 readPostsBySubject를 통해 과목명에 따른 ResponseDto들을 반환합니다.

