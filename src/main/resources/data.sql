

INSERT INTO users (username, email, created_at) VALUES
                                                    ('david', 'david@example.com', '2024-09-04 09:00:00'),
                                                    ('emma', 'emma@example.com', '2024-09-05 10:00:00'),
                                                    ('frank', 'frank@example.com', '2024-09-06 11:00:00'),
                                                    ('grace', 'grace@example.com', '2024-09-07 12:00:00'),
                                                    ('hannah', 'hannah@example.com', '2024-09-08 13:00:00');


INSERT INTO media (title, media_type, duration, release_date) VALUES
                                                                  ('The Dark Knight', 'Movie', '02:32:00', '2008-07-18'),
                                                                  ('Interstellar', 'Movie', '02:49:00', '2014-11-07'),
                                                                  ('Stranger Things', 'TV Show', '00:50:00', '2016-07-15'),
                                                                  ('Black Mirror', 'TV Show', '01:00:00', '2011-12-04'),
                                                                  ('Inception', 'Movie', '02:28:00', '2010-07-16');


INSERT INTO playback_history (user_id, media_id, played_at, progress) VALUES
                                                                          (1, 4, '2024-09-04 15:00:00', 150),
                                                                          (2, 5, '2024-09-05 16:00:00', 75),
                                                                          (3, 1, '2024-09-06 17:00:00', 30),
                                                                          (4, 2, '2024-09-07 18:00:00', 45),
                                                                          (5, 3, '2024-09-08 19:00:00', 60),
                                                                          (1, 3, '2024-09-09 20:00:00', 85),
                                                                          (2, 4, '2024-09-10 21:00:00', 110),
                                                                          (3, 5, '2024-09-11 22:00:00', 40),
                                                                          (4, 1, '2024-09-12 23:00:00', 90),
                                                                          (5, 2, '2024-09-13 00:00:00', 20);
