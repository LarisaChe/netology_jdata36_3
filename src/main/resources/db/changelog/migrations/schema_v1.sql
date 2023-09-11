-- changeset lache:1
CREATE TABLE customers (
		id SERIAL PRIMARY KEY,
		name VARCHAR(32) NOT NULL,
		surname VARCHAR(32) NOT NULL,
		age SMALLINT NOT NULL CHECK (age >= 0),
		phone_number VARCHAR(15),
		city VARCHAR(150)
	);
-- rollback drop table customers;

-- changeset lache:2
ALTER TABLE customers DROP COLUMN city;
-- rollback

-- changeset lache:3
CREATE TABLE orders (
		id SERIAL PRIMARY KEY,
		dat DATE NOT NULL,
		customer_id integer REFERENCES customers (id),
		product_name VARCHAR(100) NOT NULL,
		amount numeric CHECK (amount > 0)
	);
-- rollback drop table orders;
