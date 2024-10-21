CREATE TABLE coffee_machines(
id serial primary key,
water_ml numeric not null,
milk_ml numeric not null,
coffee_grams numeric not null,
trash_grams numeric not null
);

CREATE TABLE coffee(
id serial primary key,
recipe_name varchar(255),
water_ml numeric not null,
milk_ml numeric not null,
coffee_grams numeric not null,
coffee_machine_id integer references coffee_machines(id)
);

CREATE TABLE orders(
id serial primary key,
coffee_machine_id integer references coffee_machines(id),
coffee_id integer,
create_date timestamp without time zone
);

INSERT INTO coffee (id, recipe_name, water_ml, milk_ml, coffee_grams) VALUES
(1, 'espresso', 80, 0, 20),
(2, 'americano', 160, 0, 20),
(3, 'cappuccino', 120, 80, 20);

INSERT INTO coffee_machines VALUES
(1, 1000, 1000, 1000, 0);

INSERT INTO coffee VALUES
(4, 'custom1', 81, 10, 30, 1),
(5, 'custom2', 150, 20, 10, 1);

insert into orders VALUES
(1, 1, 1, '2024-05-04 00:42:03.464797')

