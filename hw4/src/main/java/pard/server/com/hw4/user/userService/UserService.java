package pard.server.com.hw4.user.userService;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.server.com.hw4.user.userRepo.UserRepo;
import pard.server.com.hw4.user.userEntity.User;
import pard.server.com.hw4.user.userRequest.UserSignUpDto;

@Service
@RequiredArgsConstructor
@Builder
public class UserService {
    private final UserRepo userRepo;

    public void userSignUp(UserSignUpDto userSignUpDto){
        User u = User.builder()
                .name(userSignUpDto.getUserName())
                .password(userSignUpDto.getUserPassword())
                .build();
        userRepo.save(u);
    }
}
