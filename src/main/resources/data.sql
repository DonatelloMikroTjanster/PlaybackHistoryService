

INSERT IGNORE INTO user (id, user_name, email, created_at)
VALUES
    (1, 'kalle_anka', 'kalle@example.com', '2023-01-01 10:00:00'),
    (2, 'lisa_svensson', 'lisa@example.com', '2023-01-02 11:00:00'),
    (3, 'erik_eriksson', 'erik@example.com', '2023-01-03 12:00:00'),
    (4, 'anna_andersson', 'anna@example.com', '2023-01-04 13:00:00');

-- Complete media entries with matching IDs and user associations based on PlaybackHistory
INSERT IGNORE INTO media (id, title, media_type, genre_id, release_date, url, duration, user_id) VALUES
    (1, 'Tech Talk Episode 1', 'Podcast', 1, '2023-01-01', 'http://example.com/tech-talk-1', '00:30:00', 1),  -- Kalle (User 1)
    (2, 'Planet Earth II Episode 1', 'Documentary', 2, '2016-11-06', 'http://example.com/planet-earth-2-1', '01:00:00', 2),  -- Lisa (User 2)
    (3, 'Come Together', 'Song', 3, '1969-09-26', 'http://example.com/come-together', '00:04:20', 3),  -- Erik (User 3)
    (4, 'Billie Jean', 'Song', 4, '1982-11-30', 'http://example.com/billie-jean', '00:04:54', 4),  -- Anna (User 4)
    (5, 'So What', 'Song', 5, '1959-08-17', 'http://example.com/so-what', '00:09:22', NULL),
    (6, 'Beethoven Symphony No. 9', 'Song', 6, '1824-05-07', 'http://example.com/beethoven-9', '01:05:00', NULL),
    (7, 'Jazz Vibes Episode 2', 'Podcast', 5, '2022-06-08', 'http://example.com/jazz-vibes-2', '00:40:00', NULL),
    (8, 'The Future of Tech II', 'Podcast', 1, '2023-03-01', 'http://example.com/future-tech-2', '00:35:00', 1),  -- Kalle (User 1)
    (9, 'Nature Wonders', 'Documentary', 2, '2018-01-05', 'http://example.com/nature-wonders', '00:50:00', 2),  -- Lisa (User 2)
    (10, 'Rock Legends Vol 2', 'Music', 3, '1997-08-22', 'http://example.com/rock-legends-2', '00:03:50', 3),  -- Erik (User 3)
    (11, 'Pop Classics', 'Music', 4, '2021-09-30', 'http://example.com/pop-classics', '00:03:20', NULL),
    (12, 'Classical Masterpieces', 'Music', 6, '2023-04-01', 'http://example.com/classical-masterpieces', '01:20:00', 4),  -- Anna (User 4)
    (13, 'Technology Insights', 'Podcast', 1, '2023-04-05', 'http://example.com/tech-insights', '00:25:00', NULL),
    (14, 'The Nature Chronicles', 'Documentary', 2, '2021-07-12', 'http://example.com/nature-chronicles', '00:45:00', NULL),
    (15, 'Rock Legends Vol 3', 'Music', 3, '1999-10-10', 'http://example.com/rock-legends-3', '00:04:10', NULL),
    (16, 'Pop Forever', 'Music', 4, '2022-11-18', 'http://example.com/pop-forever', '00:03:30', NULL),
    (17, 'Jazz Beats', 'Podcast', 5, '2022-02-01', 'http://example.com/jazz-beats', '00:38:00', NULL),
    (18, 'Classical Elegance', 'Music', 6, '1810-12-20', 'http://example.com/classical-elegance', '01:30:00', NULL),
    (19, 'Tech Innovators', 'Podcast', 1, '2023-05-15', 'http://example.com/tech-innovators', '00:30:00', NULL),
    (20, 'Exploring Nature', 'Documentary', 2, '2021-05-20', 'http://example.com/exploring-nature', '00:55:00', NULL);


-- Insert PlaybackHistory

INSERT IGNORE INTO  playback_history (id, user_id, media_id, played_at)
VALUES
    (1, 1, 1, '2023-01-01T10:30:00'),  -- Kalle listened to Tech Talk Episode 1
    (2, 2, 2, '2023-01-02T12:00:00'),  -- Lisa listened to Planet Earth II Episode 1
    (3, 3, 3, '2023-01-03T12:30:00'),  -- Erik listened to Come Together
    (4, 4, 4, '2023-01-04T14:00:00'),  -- Anna listened to Billie Jean
    (5, 1, 8, '2023-03-05T10:00:00'),  -- Kalle listened to The Future of Tech II
    (6, 2, 9, '2023-03-15T12:00:00'),  -- Lisa listened to Nature Wonders
    (7, 3, 10, '2023-02-10T16:00:00'), -- Erik listened to Rock Legends Vol 2
    (8, 4, 12, '2023-04-01T10:30:00'); -- Anna listened to Classical Masterpieces