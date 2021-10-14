
CREATE TABLE author(
        id SERIAL PRIMARY KEY,
        name_author TEXT,
        sex TEXT,
        birth DATE,
        death DATE
);

CREATE TABLE book(
        id SERIAL PRIMARY KEY,
        author_id INT REFERENCES author(id),
        name_book TEXT,
        type TEXT
);



INSERT INTO author(name_author, sex, birth, death) VALUES ('А. С. Пушкин', 'муж', '06-06-1799', '29-01-1837');
INSERT INTO author(name_author, sex, birth, death) VALUES ('Л. Н. Толстой ', 'муж', '09-09-1828', '20-11-1910');
INSERT INTO author(name_author, sex, birth, death) VALUES ('А. М. Пешков', 'муж', '28-03-1868', '18-06-1936');
INSERT INTO author(name_author, sex, birth, death) VALUES ('А. П. Чехов', 'муж', '29-01-1860', '15-07-1904');


INSERT INTO book(author_id, name_book, type) VALUES (1, 'Руслан и людмила', 'поэма');
INSERT INTO book(author_id, name_book, type) VALUES (1, 'Евгений Онегин', 'роман в стихах');
INSERT INTO book(author_id, name_book, type) VALUES (2, 'Анна Каренина', 'роман');
INSERT INTO book(author_id, name_book, type) VALUES (2, 'Воскресение', 'роман');
INSERT INTO book(author_id, name_book, type) VALUES (2, 'Хаджи-Мурат', 'повесть');
INSERT INTO book(author_id, name_book, type) VALUES (3, 'Мать', 'роман');
INSERT INTO book(author_id, name_book, type) VALUES (4, 'Восклицательный знак', 'рассказ');
INSERT INTO book(name_book, type) VALUES ('Илья Муромец', 'былина');


SELECT * FROM book INNER JOIN author a ON book.author_id = a.id;
SELECT * FROM book JOIN author a ON book.author_id = a.id;
SELECT bk.name_book AS Название_книги, a.name_author Имя_Автора FROM book AS bk JOIN author AS a ON bk.author_id = a.id;



