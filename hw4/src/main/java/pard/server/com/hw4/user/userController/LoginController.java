package pard.server.com.hw4.user.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginForm")
    public String login(){
        return "loginForm";
    }

    @GetMapping("/home")
    public String loginSucces(){
        return "home";
    }
}
