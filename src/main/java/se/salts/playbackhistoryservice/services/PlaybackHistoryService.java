package se.salts.playbackhistoryservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.salts.playbackhistoryservice.entities.Media;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import se.salts.playbackhistoryservice.entities.User;
import se.salts.playbackhistoryservice.repositories.MediaRepository;
import se.salts.playbackhistoryservice.repositories.PlaybackHistoryRepository;
import se.salts.playbackhistoryservice.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlaybackHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(PlaybackHistoryService.class);

    private final PlaybackHistoryRepository playbackHistoryRepository;
    private final UserRepository userRepository;
    private final MediaRepository mediaRepository;

    public PlaybackHistoryService(
            PlaybackHistoryRepository playbackHistoryRepository,
            UserRepository userRepository,
            MediaRepository mediaRepository) {
        this.playbackHistoryRepository = playbackHistoryRepository;
        this.userRepository = userRepository;
        this.mediaRepository = mediaRepository;
    }

    @Transactional(readOnly = true)
    public List<Media> getMostPlayedMediaForUser(Long userId) {
        logger.debug("Fetching most played media for user with ID: {}", userId);
        Pageable pageable = PageRequest.of(0, 10);
        List<PlaybackHistory> histories = playbackHistoryRepository.findMostPlayedByUserId(userId, pageable);
        List<Media> mediaList = histories.stream()
                .map(PlaybackHistory::getMedia)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
        logger.info("Found {} media entries for user with ID: {}", mediaList.size(), userId);
        return mediaList;
    }

    @Transactional(readOnly = true)
    public List<PlaybackHistory> getPlaybackHistoryForUser(Long userId) {
        logger.debug("Fetching playback history for user with ID: {}", userId);
        List<PlaybackHistory> playbackHistories = playbackHistoryRepository.findByUserId(userId);
        logger.info("Found {} playback history entries for user with ID: {}", playbackHistories.size(), userId);
        return playbackHistories;
    }

}
