DELETE FROM roles;
INSERT INTO roles (id, name) VALUES ('1', 'ROLE_USER');
INSERT INTO roles (id, name) VALUES ('2', 'ROLE_MODERATOR');
INSERT INTO roles (id, name) VALUES ('3', 'ROLE_ADMIN');
INSERT INTO users (
        id,
        email,
        password,
        username)
    VALUES (
        '1',
        'admin@mail.com',
        '$2a$10$vmqmLq.Q1dJgomfu9je7C.I9nbnCuXTahCgrSN9BT7IdINNtIHRsa', -- P@ssw0rd
        'admin'
);
INSERT INTO user_roles (user_id, role_id) VALUES ('1', '3');
INSERT INTO movies (id, author, title, description, year, country, duration) VALUES ('1', 'Quentin Tarantino', 'Koronaświrus', 'opis', 'rok', 'kraj', '144');
INSERT INTO movies (id, author, title, description, year, country, duration) VALUES ('2', 'Ron Łesli', 'Harry Potter', 'opis', 'rok', 'kraj', '145');
INSERT INTO halls (id) VALUES ('1');
INSERT INTO halls (id) VALUES ('2');
INSERT INTO halls (id) VALUES ('3');
INSERT INTO halls (id) VALUES ('4');
INSERT INTO halls (id) VALUES ('5');
INSERT INTO halls (id) VALUES ('6');
INSERT INTO halls (id) VALUES ('7');
INSERT INTO halls (id) VALUES ('8');
INSERT INTO halls (id) VALUES ('9');
INSERT INTO halls (id) VALUES ('10');
INSERT INTO screenings (id, movie_id, date, hall_id) VALUES ('1', '2', '09-05-2020 19:30', '1');
INSERT INTO screenings (id, movie_id, date, hall_id) VALUES ('2', '1', '10-05-2020 15:00', '1');
