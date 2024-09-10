package se.salts.playbackhistoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import java.util.List;

public interface PlaybackHistoryRepository extends JpaRepository<PlaybackHistory, Long> {
    List<PlaybackHistory> findByUserId(Long userId);
}

