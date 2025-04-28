package pard.server.com.hw4.post.postController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pard.server.com.hw4.post.postRequest.CreatePostDto;
import pard.server.com.hw4.post.postRequest.PatchRequest;
import pard.server.com.hw4.post.postRequest.ReadPostsByUserId;
import pard.server.com.hw4.post.postResponse.PostsResponseDto;
import pard.server.com.hw4.post.service.PostService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public void createPost (@RequestBody CreatePostDto createPostDto){
        postService.createPost(createPostDto);
    }

    @GetMapping("")
    public List<PostsResponseDto> readPosts(@RequestBody ReadPostsByUserId readPostsByUserId){
        return postService.readPosts(readPostsByUserId);
    }

    @PatchMapping("/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody PatchRequest patchRequest){
        postService.patchPost(postId, patchRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }
}
