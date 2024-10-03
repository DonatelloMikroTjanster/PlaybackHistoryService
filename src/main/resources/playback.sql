-- Insert Users
INSERT INTO user (id, username, email, created_at)
VALUES
    (1, 'kalle_anka', 'kalle@example.com', '2023-01-01T10:00:00'),
    (2, 'lisa_svensson', 'lisa@example.com', '2023-01-02T11:00:00'),
    (3, 'erik_eriksson', 'erik@example.com', '2023-01-03T12:00:00'),
    (4, 'anna_andersson', 'anna@example.com', '2023-01-04T13:00:00');


-- Insert Genres
INSERT INTO genre (id, name)
VALUES
    (1, 'Technology'),
    (2, 'Nature'),
    (3, 'Rock'),
    (4, 'Pop'),
    (5, 'Jazz'),
    (6, 'Classical');

-- Insert Media
INSERT INTO media (id, title, media_type, genre_id, release_date, url, duration, user_id)
VALUES
    (1, 'Tech Talk Episode 1', 'Podcast', 1, '2023-01-01', 'http://example.com/tech-talk-1', '30:00', 1),  -- Kalle, Technology
    (2, 'Planet Earth II Episode 1', 'Documentary', 2, '2016-11-06', 'http://example.com/planet-earth-2-1', '60:00', 2),  -- Lisa, Nature
    (3, 'Come Together', 'Song', 3, '1969-09-26', 'http://example.com/come-together', '4:20', 3),  -- Erik, Rock
    (4, 'Billie Jean', 'Song', 4, '1982-11-30', 'http://example.com/billie-jean', '4:54', 4),  -- Anna, Pop
    (5, 'So What', 'Song', 5, '1959-08-17', 'http://example.com/so-what', '9:22', NULL),  -- No user, Jazz
    (6, 'Beethoven Symphony No. 9', 'Song', 6, '1824-05-07', 'http://example.com/beethoven-9', '65:00', NULL),  -- No user, Classical

    -- Additional Media Entries for Genre Coverage
    (7, 'Jazz Vibes Episode 2', 'Podcast', 5, '2022-06-08', 'http://example.com/jazz-vibes-2', '40:00', NULL),  -- Jazz genre
    (8, 'The Future of Tech II', 'Podcast', 1, '2023-03-01', 'http://example.com/future-tech-2', '35:00', NULL),  -- Technology genre
    (9, 'Nature Wonders', 'Documentary', 2, '2018-01-05', 'http://example.com/nature-wonders', '50:00', NULL),  -- Nature genre
    (10, 'Rock Legends Vol 2', 'Music', 3, '1997-08-22', 'http://example.com/rock-legends-2', '3:50', NULL),  -- Rock genre
    (11, 'Pop Classics', 'Music', 4, '2021-09-30', 'http://example.com/pop-classics', '3:20', NULL),  -- Pop genre
    (12, 'Classical Gems', 'Music', 6, '1805-01-01', 'http://example.com/classical-gems', '80:00', NULL),  -- Classical genre

    -- New media entries to ensure diversity
    (13, 'Technology Insights', 'Podcast', 1, '2023-04-05', 'http://example.com/tech-insights', '25:00', NULL),  -- Technology genre
    (14, 'The Nature Chronicles', 'Documentary', 2, '2021-07-12', 'http://example.com/nature-chronicles', '45:00', NULL),  -- Nature genre
    (15, 'Rock Legends Vol 3', 'Music', 3, '1999-10-10', 'http://example.com/rock-legends-3', '4:10', NULL),  -- Rock genre
    (16, 'Pop Forever', 'Music', 4, '2022-11-18', 'http://example.com/pop-forever', '3:30', NULL),  -- Pop genre
    (17, 'Jazz Beats', 'Podcast', 5, '2022-02-01', 'http://example.com/jazz-beats', '38:00', NULL),  -- Jazz genre
    (18, 'Classical Elegance', 'Music', 6, '1810-12-20', 'http://example.com/classical-elegance', '90:00', NULL),  -- Classical genre
    (19, 'Tech Innovators', 'Podcast', 1, '2023-05-15', 'http://example.com/tech-innovators', '30:00', NULL),  -- Technology genre
    (20, 'Exploring Nature', 'Documentary', 2, '2021-05-20', 'http://example.com/exploring-nature', '55:00', NULL);  -- Nature genre

-- Insert PlaybackHistory

INSERT INTO playback_history (id, user_id, media_id, played_at)
VALUES
    (1, 1, 1, '2023-01-01T10:30:00'),  -- Kalle listened to Tech Talk Episode 1
    (2, 2, 2, '2023-01-02T12:00:00'),  -- Lisa listened to Planet Earth II Episode 1
    (3, 3, 3, '2023-01-03T12:30:00'),  -- Erik listened to Come Together
    (4, 4, 4, '2023-01-04T14:00:00'),  -- Anna listened to Billie Jean
    (5, 1, 8, '2023-03-05T10:00:00'),  -- Kalle listened to The Future of Tech II
    (6, 2, 9, '2023-03-15T12:00:00'),  -- Lisa listened to Nature Wonders
    (7, 3, 10, '2023-02-10T16:00:00'), -- Erik listened to Rock Legends Vol 2
    (8, 4, 12, '2023-04-01T10:30:00'); -- Anna listened to Classical Masterpieces
