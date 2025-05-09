package pard.server.com.hw4.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.server.com.hw4.loke.likeEntity.Loke;
import pard.server.com.hw4.loke.likeRepo.LikeRepo;
import pard.server.com.hw4.post.postEntity.Post;
import pard.server.com.hw4.post.postRepo.PostRepo;
import pard.server.com.hw4.post.postRequest.CreatePostDto;
import pard.server.com.hw4.post.postRequest.PatchRequest;
import pard.server.com.hw4.post.postRequest.UserAndPostId;
import pard.server.com.hw4.post.postResponse.PostsResponseDto;
import pard.server.com.hw4.user.userEntity.User;
import pard.server.com.hw4.user.userRepo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final LikeRepo likeRepo;

    public void createPost(CreatePostDto createPostDto){
        User u = userRepo.findById(createPostDto.getUser_id()).orElseThrow();
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
                        .post_id(post.getId())
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

    public void clickLike(UserAndPostId userAndPostId){
        User user = userRepo.findById(userAndPostId.getUser_id()).orElseThrow();
        Post post = postRepo.findById(userAndPostId.getPost_id()).orElseThrow();
        Loke like = likeRepo.findByPost_IdAndUser_Id(userAndPostId.getPost_id(), userAndPostId.getUser_id()).orElse(null);

        if(like == null){
            likeRepo.save(Loke.builder()
                            .post(post)
                            .user(user)
                    .build());
        }else{
            likeRepo.delete(like);
        }
    }
}
