package se.salts.playbackhistoryservice.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "playback_history")
public class PlaybackHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "media_id", nullable = false)
    private Media media;

    @Column(name = "played_at", nullable = false)
    private LocalDateTime playedAt;

    @Column(name = "progress", nullable = false)
    private Long progress;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    public PlaybackHistory() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
