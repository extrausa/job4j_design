INSERT INTO type (name) VALUES ('сыр');
INSERT INTO type (name) VALUES ('молоко');
INSERT INTO type (name) VALUES ('хлебобулочные');
INSERT INTO type (name) VALUES ('консервы');
INSERT INTO type (name) VALUES ('овощи');
INSERT INTO type (name) VALUES ('фрукты');
INSERT INTO type (name) VALUES ('товары для дома');
INSERT INTO type (name) VALUES ('мороженное');

INSERT INTO product (name, type_id, expired_date, price) VALUES
('Сыр плавленный', 1, false, 1.5);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Сыр моцарелла', 1, true, 0.5);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Сыр пармезан', 1, true, 3.9);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Сыр Dorblu', 1, false, 3.5);

INSERT INTO product (name, type_id, expired_date, price) VALUES
('Молоко 3,5%', 2, false, 0.5);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Молоко 4,5%', 2, true, 1.5);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Молоко 4,8%', 2, true, 2.9);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Молоко 5%', 2, false, 4.5);

INSERT INTO product (name, type_id, expired_date, price) VALUES
('Булочка Московская', 3, false, 0.1);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Хлеб', 3, true, 0.2);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Хлеб нарезной', 3, true, 0.3);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Батон', 3, false, 0.4);

INSERT INTO product (name, type_id, expired_date, price) VALUES
('Эскимо', 8, false, 2.9);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Стаканчик', 8, true, 0.7);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Брикет', 8, true, 1.3);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Big-pack', 8, false, 4.4);

INSERT INTO product (name, type_id, expired_date, price) VALUES
('Мороженное Mars', 8, false, 6.9);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Мороженное Oreo', 8, true, 4.7);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Мороженное Snikers', 8, true, 11.5);
INSERT INTO product (name, type_id, expired_date, price) VALUES
('Мороженное Bounty', 8, false, 14.4);
