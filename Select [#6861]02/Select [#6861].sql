CREATE TABLE fauna (
    id SERIAL PRIMARY KEY,
    name TEXT,
    avg_age INT,
    discovery_date DATE
    );

INSERT INTO fauna(name, avg_age, discovery_date) VALUES('fish', 5, TO_DATE('17/12/2015', 'DD/MM/YYYY'));
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('flish', 5, TO_DATE('17/12/2015', 'DD/MM/YYYY'));
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('flosh', 5, TO_DATE('17/12/2015', 'DD/MM/YYYY'));
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('fish_pig', 5, TO_DATE('17/12/1949', 'DD/MM/YYYY'));
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('elephan', 5, null);
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('crocodile', 5, TO_DATE('17/12/1814', 'DD/MM/YYYY'));
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('leon', 5, TO_DATE('17/12/1965', 'DD/MM/YYYY'));
INSERT INTO fauna(name, avg_age, discovery_date) VALUES('monkey', 5, TO_DATE('17/12/1950', 'DD/MM/YYYY'));

SELECT * FROM fauna WHERE name LIKE '%fish%';
SELECT * FROM fauna WHERE avg_age > 0 AND avg_age < 10;
SELECT * FROM fauna WHERE discovery_date IS null;
SELECT * FROM fauna WHERE discovery_date <'01.01.1950';

