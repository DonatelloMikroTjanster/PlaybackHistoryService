package se.salts.playbackhistoryservice.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;

import java.util.List;

@Repository
public interface PlaybackHistoryRepository extends JpaRepository<PlaybackHistory, Long> {
    List<PlaybackHistory> findByUserId(Long userId);

    @Query("SELECT ph FROM PlaybackHistory ph WHERE ph.user.id = :userId ORDER BY ph.progress DESC")
    List<PlaybackHistory> findMostPlayedByUserId(Long userId, Pageable pageable);
}
