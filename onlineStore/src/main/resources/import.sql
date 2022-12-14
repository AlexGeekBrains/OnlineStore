DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price INT, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Milk', 150),('Potatoes', 80), ('Eggs', 90), ('Pancake', 75),('Paper', 150);


