package pard.server.com.pardshort.post.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pard.server.com.pardshort.post.entity.Post;
import pard.server.com.pardshort.post.requestDto.RequestDto;
import pard.server.com.pardshort.post.responseDto.ResponseDto;
import pard.server.com.pardshort.post.responseDto.TagsDto;
import pard.server.com.pardshort.post.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping()
    public void createPost(@RequestBody RequestDto requestDto){
        postService.createPost(requestDto);
    }

    @GetMapping("/{tag}")
    public List<ResponseDto> readPostsBySubject(@PathVariable String tag){
        return postService.readPostsBySubject(tag);
    }

    @GetMapping("/tags")
    public TagsDto readTags(){
        return postService.readTags();
    }
}
