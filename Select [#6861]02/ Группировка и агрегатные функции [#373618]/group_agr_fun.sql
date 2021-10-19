 
create table devices(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    price FLOAT
);

create table people(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

create table devices_people(
    id SERIAL PRIMARY KEY,
    device_id INT REFERENCES devices(id),
    people_id INT REFERENCES people(id)
);

INSERT INTO devices (name, price) VALUES ('headphones', 1.5);
INSERT INTO devices (name, price) VALUES ('tv', 2.25);
INSERT INTO devices (name, price) VALUES ('x-box', 11.4);
INSERT INTO devices (name, price) VALUES ('keyboard', 154.8);
INSERT INTO devices (name, price) VALUES ('mouse', 17.53);
INSERT INTO devices (name, price) VALUES ('usb flash', 12.22);
INSERT INTO devices (name, price) VALUES ('dishwasher', 7.67);
INSERT INTO devices (name, price) VALUES ('a vacuum cleaner', 9.52);
INSERT INTO devices (name, price) VALUES ('electric shaver', 2.75);
INSERT INTO devices (name, price) VALUES ('washing machine', 4.9);

INSERT INTO people(name) VALUES ('Ivan');
INSERT INTO people(name) VALUES ('Oleg');
INSERT INTO people(name) VALUES ('Jon');
INSERT INTO people(name) VALUES ('Peter');
INSERT INTO people(name) VALUES ('Mikel');
INSERT INTO people(name) VALUES ('Nayjel');
INSERT INTO people(name) VALUES ('Bany');
INSERT INTO people(name) VALUES ('Stefany');
INSERT INTO people(name) VALUES ('Rom');
INSERT INTO people(name) VALUES ('Afon');

INSERT INTO devices_people (people_id, device_id) VALUES (1, 2), (1, 3), (1, 7), (1, 9);
INSERT INTO devices_people (people_id, device_id) VALUES (2, 1), (2, 2), (2, 6), (2, 5);
INSERT INTO devices_people (people_id, device_id) VALUES (3, 3), (3, 4), (3, 8), (3, 10);
INSERT INTO devices_people (people_id, device_id) VALUES (4, 2), (4, 2), (4, 7), (4, 9);
INSERT INTO devices_people (people_id, device_id) VALUES (5, 1), (5, 4), (5, 6), (5, 5);
INSERT INTO devices_people (people_id, device_id) VALUES (6, 3), (6, 2), (6, 8), (6, 10);
INSERT INTO devices_people (people_id, device_id) VALUES (7, 2), (7, 4), (7, 8), (7, 5);
INSERT INTO devices_people (people_id, device_id) VALUES (8, 1), (8, 2), (8, 8), (8, 9);
INSERT INTO devices_people (people_id, device_id) VALUES (9, 3), (9, 4), (9, 6), (9, 10);
INSERT INTO devices_people (people_id, device_id) VALUES (10, 2), (10, 3), (10, 7), (10, 5);

SELECT * FROM devices_people AS dp JOIN devices d ON dp.device_id = d.id;

SELECT AVG(d.price) AS "Средняя цена устройств" FROM devices AS d;

SELECT AVG(d.price), dp.people_id FROM devices_people AS dp JOIN people p ON dp.people_id = p.id JOIN devices d ON dp.device_id = d.id GROUP BY dp.people_id;

SELECT AVG(d.price), dp.people_id FROM devices_people AS dp JOIN people p ON dp.people_id = p.id JOIN devices d ON dp.device_id = d.id GROUP BY dp.people_id HAVING AVG(d.price) > 4;

