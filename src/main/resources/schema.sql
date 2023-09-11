CREATE SCHEMA jdata36;
	
--CREATE SCHEMA JDATA36 lache;

CREATE TABLE customers (
		id SERIAL PRIMARY KEY,
		name VARCHAR(32) NOT NULL,
		surname VARCHAR(32) NOT NULL,
		age SMALLINT NOT NULL CHECK (age >= 0),
		phone_number VARCHAR(15)
	);

CREATE TABLE orders (
		id SERIAL PRIMARY KEY,
		dat DATE NOT NULL,
		customer_id integer REFERENCES customers (id),
		product_name VARCHAR(100) NOT NULL,
		amount numeric CHECK (amount > 0)
	);


INSERT INTO customers (name, surname, age, phone_number) VALUES ('Peter', 'Petrov', 29, '+79151034554');
INSERT INTO customers (name, surname, age, phone_number) VALUES ('Ivan', 'Ivanov', 29, '+79151034554');
INSERT INTO customers (name, surname, age, phone_number) VALUES ('Sergey', 'Majorov', 29, '+79151034554');
INSERT INTO customers (name, surname, age, phone_number) VALUES ('Irina', 'Petrova', 29, '+79151034554');

INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-08', 1, 'Cheese', 299.99);
INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-08', 1, 'Butter', 199.99);
INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-08', 1, 'Bread', 69.99);

INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-12', 2, 'Jam', 139.99);
INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-12', 2, 'Juice', 189);
INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-12', 2, 'Cookies', 57.55);


INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-13', 3, 'Jam', 139.99);
INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-13', 3, 'Butter', 199.99);


INSERT INTO orders (dat, customer_id, product_name,  amount) VALUES ('2023-08-17', 4, 'Jam', 139.99);
