
INSERT INTO users (username, email, created_at) VALUES
                                                    ('alice', 'alice@example.com', '2024-09-01 10:00:00'),
                                                    ('bob', 'bob@example.com', '2024-09-02 11:00:00'),
                                                    ('carol', 'carol@example.com', '2024-09-03 12:00:00');

INSERT INTO media (title, media_type, duration) VALUES
                                                    ('Inception', 'Movie', '02:28:00'),
                                                    ('The Matrix', 'Movie', '02:16:00'),
                                                    ('Breaking Bad', 'TV Show', '00:47:00');

INSERT INTO playback_history (user_id, media_id, played_at, progress) VALUES
                                                                          (1, 1, '2024-09-01 12:00:00', 120),
                                                                          (2, 2, '2024-09-02 13:00:00', 50),
                                                                          (3, 3, '2024-09-03 14:00:00', 10);
