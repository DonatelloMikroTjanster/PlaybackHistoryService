package se.salts.playbackhistoryservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.salts.playbackhistoryservice.entities.Media;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import se.salts.playbackhistoryservice.entities.User;
import se.salts.playbackhistoryservice.repositories.MediaRepository;
import se.salts.playbackhistoryservice.repositories.PlaybackHistoryRepository;
import se.salts.playbackhistoryservice.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaybackHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(PlaybackHistoryService.class);

    private final PlaybackHistoryRepository playbackHistoryRepository;
    private final UserRepository userRepository;
    private final MediaRepository mediaRepository;

    @Autowired
    public PlaybackHistoryService(
            PlaybackHistoryRepository playbackHistoryRepository,
            UserRepository userRepository,
            MediaRepository mediaRepository) {
        this.playbackHistoryRepository = playbackHistoryRepository;
        this.userRepository = userRepository;
        this.mediaRepository = mediaRepository;
    }

    @Transactional
    public PlaybackHistory createPlaybackHistory(PlaybackHistory playbackHistory) {
        User user = playbackHistory.getUser();
        if (user == null || userRepository.findById(user.getId()).isEmpty()) {
            String errorMsg = "User not found: " + user;
            logger.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }

        Media media = playbackHistory.getMedia();
        if (media == null || mediaRepository.findById(media.getId()).isEmpty()) {
            String errorMsg = "Media not found: " + media;
            logger.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }

        return playbackHistoryRepository.save(playbackHistory);
    }

    @Transactional(readOnly = true)
    public List<PlaybackHistory> getPlaybackHistoryForUser(Long userId) {
        logger.info("Hämtar playback history för användare: {}", userId);
        try {
            List<PlaybackHistory> playbackHistories = playbackHistoryRepository.findByUserId(userId);
            if (playbackHistories.isEmpty()) {
                logger.info("Inga playback history-poster hittades för användare: {}", userId);
            } else {
                logger.info("Antal playback history-poster hittade för användare {}: {}", userId, playbackHistories.size());
            }
            return playbackHistories;
        } catch (Exception e) {
            logger.error("Misslyckades med att hämta playback history för användare {}: ", userId, e);
            throw new RuntimeException("Fel vid hämtning av playback history", e);
        }
    }

    @Transactional(readOnly = true)
    public Optional<PlaybackHistory> getMostPlayedMediaForUser(Long userId) {
        logger.info("Hämtar mest spelade media för användare: {}", userId);
        try {
            Optional<PlaybackHistory> mostPlayedMedia = playbackHistoryRepository.findMostPlayedMediaByUserId(userId);
            if (mostPlayedMedia.isPresent()) {
                logger.info("Mest spelade media för användare {}: {}", userId, mostPlayedMedia.get());
            } else {
                logger.info("Ingen mest spelade media hittades för användare: {}", userId);
            }
            return mostPlayedMedia;
        } catch (Exception e) {
            logger.error("Misslyckades med att hämta mest spelade media för användare {}: ", userId, e);
            throw new RuntimeException("Fel vid hämtning av mest spelade media", e);
        }
    }
}
