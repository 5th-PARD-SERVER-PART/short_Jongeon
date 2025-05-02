package pard.server.com.hw4.user.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pard.server.com.hw4.user.userEntity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
