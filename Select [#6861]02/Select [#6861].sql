CREATE TABLE fauna (
    id SERIAL PRIMARY KEY,
    name TEXT,
    avg_age INT,
    discovery_date DATE
    );


INSERT INTO fauna(name, avg_age, discovery_date) VALUES('fish', 5, '17-12-2015');
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('fish_pig', 5, '17-12-1949');
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('elephan', 5, null);
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('crocodile', 5, '17-12-1814');
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('leon', 5, '17-12-1965');
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('monkey', 5, '17/12/1950');

SELECT * FROM fauna WHERE name LIKE '%fish%';
idea_db=> SELECT avg_age FROM fauna WHERE avg_age BETWEEN 0 AND 5;
SELECT * FROM fauna WHERE discovery_date IS null;
SELECT * FROM fauna WHERE discovery_date <'01.01.1950';

