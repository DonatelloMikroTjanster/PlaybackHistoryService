package se.salts.playbackhistoryservice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "media_type", nullable = false)
    private String mediaType;

    @Column(name = "duration")
    private String duration;

    @Column(name = "release_date")
    private LocalDate releaseDate = LocalDate.now();

    public Media() {}

    public Media(Long id, String title, String mediaType, String duration, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.mediaType = mediaType;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
