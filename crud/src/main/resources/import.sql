INSERT INTO tb_user (email, password) VALUES ('diego@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, password) VALUES ('alice@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);



INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Diego Vicente Pereira','058889532', 200.00, TIMESTAMP WITH TIME ZONE '1988-09-14T20:50:07.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Albert Tesla','056889532', 2000.00, TIMESTAMP WITH TIME ZONE '1980-10-01T20:30:00.12345Z', 6);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('David Waters','056775433', 4000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 3);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Bill Jobs','066785222', 5000.00, TIMESTAMP WITH TIME ZONE '1950-03-13T10:36:00.12345Z', 5);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Steve Gates','056874432', 4000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Jimmy Hendrix','056164321', 1000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 2);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Janis Joplin','045765422', 2000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 7);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Alan Broke','055275132', 7000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Lucas Silva','056725331', 3000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Milena Wins','052715229', 6000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 4);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Blanca Rosa','057777431', 2000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 3);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Cindy Roberts','053615412', 6000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 2);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Robert Brown','052885433', 9000.00, TIMESTAMP WITH TIME ZONE '1958-02-10T23:11:00.12345Z', 2);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Milli Molli','051985431', 3000.00, TIMESTAMP WITH TIME ZONE '1966-11-11T12:26:00.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Jessica More','051715230', 14000.00, TIMESTAMP WITH TIME ZONE '1950-03-11T21:21:21.12345Z', 5);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Eduard Star','051895131', 10000.00, TIMESTAMP WITH TIME ZONE '1990-11-12T22:26:00.12345Z', 8);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Marilyn Miza','053664122', 2000.00, TIMESTAMP WITH TIME ZONE '1960-01-10T20:26:00.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Bianca Rodrigues','056775432', 9000.00, TIMESTAMP WITH TIME ZONE '1966-05-10T22:26:00.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Raphael Loyal','056775432', 1000.00, TIMESTAMP WITH TIME ZONE '1960-03-10T12:26:00.12345Z', 3);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Minerva Street','056775432', 4400.00, TIMESTAMP WITH TIME ZONE '1972-06-10T22:26:00.12345Z', 2);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('James Ingram','056775432', 4200.00, TIMESTAMP WITH TIME ZONE '1970-01-10T21:26:00.12345Z', 2);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Lionel Richie','056775432', 1400.00, TIMESTAMP WITH TIME ZONE '1980-07-10T20:26:00.12345Z', 4);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Chris Morning','056775432', 2300.00, TIMESTAMP WITH TIME ZONE '1961-02-10T17:26:00.12345Z', 1);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Vera Lynn','056775432', 7400.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 0);
INSERT INTO tb_client (name, cpf, income, birth_Date, children ) VALUES ('Alice Beauty','056775432', 1900.00, TIMESTAMP WITH TIME ZONE '1960-01-10T22:26:00.12345Z', 2);