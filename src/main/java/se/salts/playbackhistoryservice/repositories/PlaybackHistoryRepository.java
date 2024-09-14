package se.salts.playbackhistoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaybackHistoryRepository extends JpaRepository<PlaybackHistory, Long> {
    List<PlaybackHistory> findByUserId(Long userId);

    @Query("SELECT ph FROM PlaybackHistory ph WHERE ph.user.id = :userId ORDER BY COUNT(ph.media) DESC")
    Optional<PlaybackHistory> findMostPlayedByUserId(Long userId);

    Optional<PlaybackHistory> findMostPlayedMediaByUserId(Long userId);
}

