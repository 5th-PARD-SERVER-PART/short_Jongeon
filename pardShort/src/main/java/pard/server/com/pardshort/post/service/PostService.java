package pard.server.com.pardshort.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.server.com.pardshort.post.entity.Post;
import pard.server.com.pardshort.post.repository.PostRepo;
import pard.server.com.pardshort.post.requestDto.RequestDto;
import pard.server.com.pardshort.post.responseDto.ResponseDto;
import pard.server.com.pardshort.post.responseDto.TagsDto;

import java.util.ArrayList;
import java.util.List;

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




