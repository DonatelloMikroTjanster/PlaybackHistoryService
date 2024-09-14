package se.salts.playbackhistoryservice.services;

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
        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<PlaybackHistory> histories = playbackHistoryRepository.findMostPlayedByUserId(userId, pageable);
            return histories.stream()
                    .map(PlaybackHistory::getMedia)
                    .filter(Objects::nonNull)
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Fel vid hämtning av mest spelade media", e);
        }
    }

    @Transactional(readOnly = true)
    public List<PlaybackHistory> getPlaybackHistoryForUser(Long userId) {
        try {
            return playbackHistoryRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException("Fel vid hämtning av playback history", e);
        }
    }

    @Transactional
    public PlaybackHistory createPlaybackHistory(PlaybackHistory playbackHistory) {
        try {
            User user = playbackHistory.getUser();
            Media media = playbackHistory.getMedia();

            if (user == null || userRepository.findById(user.getId()).isEmpty()) {
                throw new IllegalArgumentException("User not found");
            }
            if (media == null || mediaRepository.findById(media.getId()).isEmpty()) {
                throw new IllegalArgumentException("Media not found");
            }

            return playbackHistoryRepository.save(playbackHistory);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Fel vid skapande av playback history", e);
        }
    }
}
