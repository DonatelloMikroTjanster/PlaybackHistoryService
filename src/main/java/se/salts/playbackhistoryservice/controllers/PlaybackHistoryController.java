package se.salts.playbackhistoryservice.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.salts.playbackhistoryservice.entities.Media;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import se.salts.playbackhistoryservice.services.PlaybackHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/playback-history")
public class PlaybackHistoryController {

    private final PlaybackHistoryService playbackHistoryService;

    public PlaybackHistoryController(PlaybackHistoryService playbackHistoryService) {
        this.playbackHistoryService = playbackHistoryService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API fungerar!");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPlaybackHistoryForUser(@PathVariable Long userId) {
        try {
            List<PlaybackHistory> playbackHistories = playbackHistoryService.getPlaybackHistoryForUser(userId);
            if (playbackHistories.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(playbackHistories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fel vid hämtning av playback history: " + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}/most-played")
    public ResponseEntity<?> getMostPlayedMediaForUser(@PathVariable Long userId) {
        try {
            List<Media> mostPlayedMedia = playbackHistoryService.getMostPlayedMediaForUser(userId);
            if (mostPlayedMedia.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(mostPlayedMedia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fel vid hämtning av mest spelade media: " + e.getMessage());
        }
    }

}
