package pard.server.com.hw4.loke.likeController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pard.server.com.hw4.loke.likeRequest.UserAndPostId;
import pard.server.com.hw4.loke.likeService.LikeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeCotroller {
    private final LikeService likeService;

    @PatchMapping("")
    public void clickLike(@RequestBody UserAndPostId userAndPostId){
        likeService.clickLike(userAndPostId);
    }
}
