package pard.server.com.pardshort.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pard.server.com.pardshort.post.entity.Post;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAllByTag(String tag);

    @Query("SELECT DISTINCT p.tag FROM Post p")
    List<String> findDistinctTags();


}


