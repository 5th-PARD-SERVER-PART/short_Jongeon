package pard.server.com.hw4.user.userRequest;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserSignUpDto {
    private String userName;
    private String userPassword;
}
