-- 7. 
CREATE DATABASE mans_frends;
USE mans_frends;
-- 8. 
-- Таблица "Животные"
CREATE TABLE animals (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), team VARCHAR(255), date_of_birth DATE);
-- Таблица "Домашние животные"
CREATE TABLE home_pets (id INT PRIMARY KEY, FOREIGN KEY (id) REFERENCES animals (id));
-- Таблица "Вьючные животные"
CREATE TABLE pack_animals (id INT PRIMARY KEY, FOREIGN KEY (id) REFERENCES animals (id));
-- 9. 
-- Заполнение таблицы "Животные"
INSERT INTO animals (name, team, date_of_birth)
VALUES ('Собака', 'Лаять', '2020-01-01'),
       ('Кошка', 'Мяукать', '2019-05-10'),
       ('Хомяк', 'Крутиться в колесе', '2022-03-15');

-- Заполнение таблиц "Домашние животные" и "Вьючные животные" соответственно
INSERT INTO home_pets (id) VALUES (1), (2), (3);
INSERT INTO pack_animals (id) VALUES (4), (5), (6);

-- 10. 
-- Удаление верблюдов из таблицы "Вьючные животные"
DELETE FROM pack_animals WHERE `id` IN (4, 5, 6);

-- Объединение таблиц "Лошади" и "Ослы" в одну таблицу "Лошади_и_ослы"
CREATE TABLE horse_donkey AS
SELECT * FROM horse
UNION
SELECT * FROM donkey;

-- Удаление таблиц "Лошади" и "Ослы", если они больше не нужны
DROP TABLE horse;
DROP TABLE donkey;

-- 11. 
-- Создание таблицы "Молодые животные"
CREATE TABLE young_animals AS
SELECT *,
       TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) AS age
FROM animals
WHERE date_of_birth > DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND date_of_birth <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

--12.
-- Создание таблицы "Все_животные" с сохранением прошлой принадлежности
CREATE TABLE all_animals AS
SELECT id, name, team, date_of_birth, animals AS belong
FROM animals
UNION
SELECT id, NULL, NULL, NULL, home_pets AS belong
FROM home_pets
UNION
SELECT id, NULL, NULL, NULL, pack_animals AS belong
FROM pack_animals
UNION
SELECT id, NULL, NULL, NULL, horse_donkey AS belong
FROM horse_donkey
UNION
SELECT id, NULL, NULL, NULL, young_animals AS belong
FROM young_animals;