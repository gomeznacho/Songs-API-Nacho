INSERT INTO composer(artistic_name) VALUES('Jimbo Jonez');
INSERT INTO composer(artistic_name) VALUES('Aitortxu');
INSERT INTO album(name, composer_id) VALUES('El Caso Jonez', 1);

INSERT INTO song(release_date, tittle, url, videoclip, album_id)
VALUES('2017-11-17', 'Introspective Revolution', 'https://open.spotify.com/track/4S9aDnIoqLgMfJTSJugyEw?si=5a4f77b5e63b4c82', null, 1);
INSERT INTO song_composer(song_id, composer_id)
VALUES(1,1);

INSERT INTO song(release_date, tittle, url, videoclip, album_id)
VALUES('2017-11-17', 'Crear Por Crear', 'https://open.spotify.com/track/5Y7dSQrBHCEo3FaAL7UoEo?si=250cdf66130d4666', 'https://www.youtube.com/watch?v=hA9cRoTlUGE', 1);
INSERT INTO song_composer(song_id, composer_id)
VALUES(2,1);
INSERT INTO song_composer(song_id, composer_id)
VALUES(2,2);

INSERT INTO song(release_date, tittle, url, videoclip, album_id)
VALUES('2017-11-17', 'No Te Conocías', 'https://open.spotify.com/track/2Caq4k0aYrQwPrJaUO4RIR?si=217f728c224d4114', null, 1);
INSERT INTO song_composer(song_id, composer_id)
VALUES(3,1);

INSERT INTO song(release_date, tittle, url, videoclip, album_id)
VALUES('2017-11-17', 'Eres', 'https://open.spotify.com/track/1xY7RIWTGSFz0IxfHfuaLg?si=2c554e4d9a69402c', null, 1);
INSERT INTO song_composer(song_id, composer_id)
VALUES(4,1);

INSERT INTO composer(artistic_name) VALUES('Mehding');

INSERT INTO song(release_date, tittle, url, videoclip, album_id)
VALUES('2017-11-17', 'Insternship Inna Dub', 'https://open.spotify.com/track/1tTppgxHAFh9qcagAJ1axk?si=a52a5eed53404b76', null, 1);
INSERT INTO song_composer(song_id, composer_id)
VALUES(5,1);

INSERT INTO song(release_date, tittle, url, videoclip, album_id)
VALUES('2017-11-17', 'Blood Borders', 'https://open.spotify.com/track/69nqQUvsW8Ldkno8TaFNRy?si=a1c7ff4383464227', null, 1);
INSERT INTO song_composer(song_id, composer_id)
VALUES(6,1);

