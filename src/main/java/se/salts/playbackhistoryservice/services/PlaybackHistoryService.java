package se.salts.playbackhistoryservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import se.salts.playbackhistoryservice.repositories.PlaybackHistoryRepository;

import java.util.List;

@Service
public class PlaybackHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(PlaybackHistoryService.class);

    private final PlaybackHistoryRepository playbackHistoryRepository;

    @Autowired
    public PlaybackHistoryService(PlaybackHistoryRepository playbackHistoryRepository) {
        this.playbackHistoryRepository = playbackHistoryRepository;
    }

    @Transactional
    public PlaybackHistory createPlaybackHistory(PlaybackHistory playbackHistory) {
        logger.info("Creating playback history for user: {}", playbackHistory.getUser().getId());
        return playbackHistoryRepository.save(playbackHistory);
    }

    public List<PlaybackHistory> getPlaybackHistoryForUser(Long userId) {
        logger.info("Retrieving playback history for user: {}", userId);
        return playbackHistoryRepository.findByUserId(userId);
    }
}
