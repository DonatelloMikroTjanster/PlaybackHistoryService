package se.salts.playbackhistoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.salts.playbackhistoryservice.entities.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
