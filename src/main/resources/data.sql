

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