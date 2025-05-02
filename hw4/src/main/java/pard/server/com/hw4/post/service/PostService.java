package pard.server.com.hw4.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.server.com.hw4.post.postEntity.Post;
import pard.server.com.hw4.post.postRepo.PostRepo;
import pard.server.com.hw4.post.postRequest.CreatePostDto;
import pard.server.com.hw4.post.postRequest.PatchRequest;
import pard.server.com.hw4.post.postResponse.PostsResponseDto;
import pard.server.com.hw4.user.userEntity.User;
import pard.server.com.hw4.user.userRepo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public void createPost(CreatePostDto createPostDto){
        System.out.println(createPostDto.getUser_id() + "www");
        User u = userRepo.findById(createPostDto.getUser_id()).orElseThrow();
        System.out.println("wqeqwee" );
        Post p = Post.builder()
                .postContents(createPostDto.getContents())
                .user(u)
        .build();

        postRepo.save(p);
    }

    public List<PostsResponseDto> readPosts(Long userId){
        User user = userRepo.findById(userId).orElseThrow();
        List<Post> posts = postRepo.findAllByUser(user);
        List<PostsResponseDto> postDtos = posts.stream()
                .map(post -> PostsResponseDto.builder()
                        .post_id(post.getPost_id())
                        .postContents(post.getPostContents())
                        .postedTime(post.getPostedTime())
                        .build()).toList();

        return postDtos;
    }

    public void patchPost(Long postId, PatchRequest patchRequest){
        Post post = postRepo.findById(postId).orElseThrow();
        post.updateContents(patchRequest.getContents());
        postRepo.save(post);
    }

    public void deletePost(Long postId){
        Post post = postRepo.findById(postId).orElseThrow();
        postRepo.delete(post);
    }
}
