CREATE TABLE coffee_machines(
id serial primary key,
water_ml numeric not null,
milk_ml numeric not null,
coffee_grams numeric not null,
trash_grams numeric not null
);

CREATE TABLE coffee_custom(
id serial primary key,
recipe_name varchar(255),
water_ml numeric not null,
milk_ml numeric not null,
coffee_grams numeric not null,
coffee_machine_id integer references coffee_machines(id)
);

CREATE TABLE coffee(
id serial primary key,
recipe_name varchar(255),
water_ml numeric not null,
milk_ml numeric not null,
coffee_grams numeric not null
);

CREATE TABLE orders(
id serial primary key,
coffee_machine_id integer references coffee_machines(id),
coffee_id integer,
create_date date,
is_custom_coffee boolean
);

INSERT INTO coffee VALUES
(1, 'espresso', 80, 0, 20),
(2, 'americano', 160, 0, 20),
(3, 'cappuccino', 120, 80, 20);

INSERT INTO coffee_machines VALUES
(1, 1000, 1000, 1000, 0);

