package se.salts.playbackhistoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.salts.playbackhistoryservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
