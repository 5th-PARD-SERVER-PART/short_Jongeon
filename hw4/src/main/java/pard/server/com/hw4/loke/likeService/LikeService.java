package pard.server.com.hw4.loke.likeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.server.com.hw4.loke.likeEntity.Loke;
import pard.server.com.hw4.loke.likeRepo.LikeRepo;
import pard.server.com.hw4.loke.likeRequest.UserAndPostId;
import pard.server.com.hw4.post.postEntity.Post;
import pard.server.com.hw4.post.postRepo.PostRepo;
import pard.server.com.hw4.user.userEntity.User;
import pard.server.com.hw4.user.userRepo.UserRepo;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepo likeRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public void clickLike(UserAndPostId userAndPostId){
        Post post = postRepo.findById(userAndPostId.getPost_id()).orElseThrow();
        User user = userRepo.findById(userAndPostId.getUser_id()).orElseThrow();
        Loke like = likeRepo.findByPost_IdAndUser_Id(userAndPostId.getPost_id(), userAndPostId.getUser_id()).orElse(null);

        if(like == null){
            like = Loke.builder()
                    .user(user)
                    .post(post)
                    .build();
            likeRepo.save(like);
        }else{
            likeRepo.delete(like);
        }
    }
}
