CREATE SCHEMA jdata36;

CREATE TABLE jdata36.customers (
		id SERIAL PRIMARY KEY,
		name VARCHAR(32) NOT NULL,
		surname VARCHAR(32) NOT NULL,
		age SMALLINT NOT NULL CHECK (age >= 0),
		phone_number VARCHAR(15)
	);

CREATE TABLE jdata36.orders (
		id SERIAL PRIMARY KEY,
		dat DATE NOT NULL,
		customer_id integer REFERENCES jdata36.customers (id),
		product_name VARCHAR(100) NOT NULL,
		amount numeric CHECK (amount > 0)
	);
