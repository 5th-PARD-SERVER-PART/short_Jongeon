package pard.server.com.hw4.user.userController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pard.server.com.hw4.user.userRequest.UserSignUpDto;
import pard.server.com.hw4.user.userService.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public void userSignUp(@RequestBody UserSignUpDto userSignUpDto){
        userService.userSignUp(userSignUpDto);
    }

}
