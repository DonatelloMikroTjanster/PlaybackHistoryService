
INSERT INTO users (username, email, created_at) VALUES
                                                    ('david.martin', 'david.martin@gmail.com', '2024-09-04 09:00:00'),
                                                    ('emma_smith', 'emma.smith@hotmail.com', '2024-09-05 10:00:00'),
                                                    ('frank_jones', 'frank.jones@yahoo.com', '2024-09-06 11:00:00'),
                                                    ('grace.brown', 'grace.brown@outlook.com', '2024-09-07 12:00:00'),
                                                    ('hannah_johnson', 'hannah.johnson@live.com', '2024-09-08 13:00:00');


INSERT INTO media (title, media_type, duration, release_date) VALUES
                                                                  ('Shape of You', 'Song', '00:03:53', '2017-01-06'),
                                                                  ('Blinding Lights', 'Song', '00:03:20', '2019-11-29'),
                                                                  ('Rolling in the Deep', 'Song', '00:03:48', '2010-11-29'),
                                                                  ('Uptown Funk', 'Song', '00:04:30', '2014-11-10'),
                                                                  ('Someone Like You', 'Song', '00:04:45', '2011-01-24');


INSERT INTO playback_history (user_id, media_id, played_at, progress) VALUES
                                                                          (1, 1, '2024-09-04 15:00:00', 150),
                                                                          (2, 2, '2024-09-05 16:00:00', 75),
                                                                          (3, 3, '2024-09-06 17:00:00', 30),
                                                                          (4, 4, '2024-09-07 18:00:00', 45),
                                                                          (5, 5, '2024-09-08 19:00:00', 60),
                                                                          (1, 2, '2024-09-09 20:00:00', 85),
                                                                          (2, 3, '2024-09-10 21:00:00', 110),
                                                                          (3, 4, '2024-09-11 22:00:00', 40),
                                                                          (4, 5, '2024-09-12 23:00:00', 90),
                                                                          (5, 1, '2024-09-13 00:00:00', 20);
