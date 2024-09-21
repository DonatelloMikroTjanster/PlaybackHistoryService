package se.salts.playbackhistoryservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import se.salts.playbackhistoryservice.entities.Media;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import se.salts.playbackhistoryservice.repositories.MediaRepository;
import se.salts.playbackhistoryservice.repositories.PlaybackHistoryRepository;
import se.salts.playbackhistoryservice.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaybackHistoryServiceTest {

    @Mock
    private PlaybackHistoryRepository playbackHistoryRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MediaRepository mediaRepository;

    @InjectMocks
    private PlaybackHistoryService playbackHistoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPlaybackHistoryForUser_ReturnsHistory() {

        Long userId = 1L;
        List<PlaybackHistory> playbackHistories = new ArrayList<>();
        playbackHistories.add(new PlaybackHistory());
        when(playbackHistoryRepository.findByUserId(userId)).thenReturn(playbackHistories);

        List<PlaybackHistory> result = playbackHistoryService.getPlaybackHistoryForUser(userId);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(playbackHistoryRepository, times(1)).findByUserId(userId);
    }

    @Test
    void testGetMostPlayedMediaForUser_ReturnsMediaList() {
        Long userId = 1L;
        Pageable pageable = PageRequest.of(0, 10);
        List<PlaybackHistory> playbackHistories = new ArrayList<>();
        PlaybackHistory history1 = new PlaybackHistory();
        Media media1 = new Media();
        media1.setTitle("Test Media 1");
        history1.setMedia(media1);

        PlaybackHistory history2 = new PlaybackHistory();
        Media media2 = new Media();
        media2.setTitle("Test Media 2");
        history2.setMedia(media2);

        playbackHistories.add(history1);
        playbackHistories.add(history2);

        when(playbackHistoryRepository.findMostPlayedByUserId(userId, pageable)).thenReturn(playbackHistories);

        List<Media> result = playbackHistoryService.getMostPlayedMediaForUser(userId);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(playbackHistoryRepository, times(1)).findMostPlayedByUserId(userId, pageable);
    }

    @Test
    void testGetPlaybackHistoryForUser_ReturnsEmptyListWhenNoHistory() {

        Long userId = 1L;
        when(playbackHistoryRepository.findByUserId(userId)).thenReturn(new ArrayList<>());

        List<PlaybackHistory> result = playbackHistoryService.getPlaybackHistoryForUser(userId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(playbackHistoryRepository, times(1)).findByUserId(userId);
    }
}
