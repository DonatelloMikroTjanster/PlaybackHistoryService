DROP TABLE IF EXISTS playback_history;
DROP TABLE IF EXISTS media;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE media (
                       media_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       media_type VARCHAR(50) NOT NULL,
                       duration TIME,
                       release_date DATE
);

CREATE TABLE playback_history (
                                  playback_history_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  user_id BIGINT NOT NULL,
                                  media_id BIGINT NOT NULL,
                                  played_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  progress INT,
                                  FOREIGN KEY (user_id) REFERENCES users(user_id),
                                  FOREIGN KEY (media_id) REFERENCES media(media_id)
);


INSERT INTO users (username, email) VALUES
                                        ('anna_svensson', 'anna.svensson@example.com'),
                                        ('erik_larsson', 'erik.larsson@example.com');

INSERT INTO media (title, media_type, duration, release_date) VALUES
                                                                  ('Come Together', 'MUSIC', '00:05:00', '2000-02-14'),
                                                                  ('Billie Jean', 'MUSIC', '00:02:50', '1990-08-24'),
                                                                  ('Tech Talk Episode 1', 'PODCAST', '00:03:25', '2005-11-30');

INSERT INTO playback_history (user_id, media_id, played_at, progress) VALUES
                                                                          (1, 1, '2024-01-10 14:00:00', 50),
                                                                          (2, 3, '2024-02-15 09:30:00', 75);
