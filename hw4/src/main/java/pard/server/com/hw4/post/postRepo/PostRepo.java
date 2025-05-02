package pard.server.com.hw4.post.postRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pard.server.com.hw4.post.postEntity.Post;
import pard.server.com.hw4.user.userEntity.User;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);
}
