DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial, title VARCHAR(255), price INT, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Milk', 150),('Potatoes', 80),('Eggs', 90), ('Pancake', 75),('Paper', 150);

DROP TABLE IF EXISTS consumers CASCADE;
CREATE TABLE consumers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO consumers (name) VALUES ('Alexander'),('Dima'),('Bob');

DROP TABLE IF EXISTS consumers_products CASCADE;
CREATE TABLE consumers_products (consumer_id bigint, product_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (consumer_id) REFERENCES consumers (id));
INSERT INTO consumers_products (consumer_id, product_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 2), (2, 3), (3, 3), (3, 4), (3, 5);