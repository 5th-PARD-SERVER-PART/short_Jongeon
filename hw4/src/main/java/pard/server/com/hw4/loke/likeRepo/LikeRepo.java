package pard.server.com.hw4.loke.likeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pard.server.com.hw4.loke.likeEntity.Loke;

import java.util.Optional;

@Repository
public interface LikeRepo extends JpaRepository<Loke, Long> {
    public Optional<Loke> findByPost_IdAndUser_Id(Long postId, Long userId);
}
