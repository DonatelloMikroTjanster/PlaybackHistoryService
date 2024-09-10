package se.salts.playbackhistoryservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.salts.playbackhistoryservice.entities.PlaybackHistory;
import se.salts.playbackhistoryservice.services.PlaybackHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/playback-history")
public class PlaybackHistoryController {

    private final PlaybackHistoryService playbackHistoryService;

    @Autowired
    public PlaybackHistoryController(PlaybackHistoryService playbackHistoryService) {
        this.playbackHistoryService = playbackHistoryService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaybackHistory>> getPlaybackHistoryForUser(@PathVariable Long userId) {
        List<PlaybackHistory> playbackHistories = playbackHistoryService.getPlaybackHistoryForUser(userId);
        if (playbackHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(playbackHistories);
    }

    @PostMapping
    public ResponseEntity<PlaybackHistory> createPlaybackHistory(@RequestBody PlaybackHistory playbackHistory) {
        PlaybackHistory createdPlaybackHistory = playbackHistoryService.createPlaybackHistory(playbackHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlaybackHistory);
    }
}
