package pard.server.com.pardshort.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.server.com.pardshort.post.entity.Post;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAllByTag(String tag);
}
