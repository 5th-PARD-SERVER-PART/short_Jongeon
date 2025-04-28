package pard.server.com.hw4.user.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.server.com.hw4.user.userEntity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
