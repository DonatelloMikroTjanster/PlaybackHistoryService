package se.salts.playbackhistoryservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import se.salts.playbackhistoryservice.services.PlaybackHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/playback-history")
public class PlaybackHistoryController {

    private final PlaybackHistoryService playbackHistoryService;

    public PlaybackHistoryController(PlaybackHistoryService playbackHistoryService) {
        this.playbackHistoryService = playbackHistoryService;
    }

    @GetMapping("/test")
    public String test() {
        return "API fungerar!";
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fel vid hämtning av playback history: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createPlaybackHistory(@RequestBody PlaybackHistory playbackHistory) {
        try {
            PlaybackHistory createdPlaybackHistory = playbackHistoryService.createPlaybackHistory(playbackHistory);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPlaybackHistory);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Ogiltigt indata: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fel vid skapande av playback history: " + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}/most-played")
    public ResponseEntity<?> getMostPlayedMediaForUser(@PathVariable Long userId) {
        try {
            Optional<PlaybackHistory> mostPlayed = playbackHistoryService.getMostPlayedMediaForUser(userId);
            return mostPlayed.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.noContent().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fel vid hämtning av mest spelade media: " + e.getMessage());
        }
    }
}
