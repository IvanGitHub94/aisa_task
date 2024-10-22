CREATE TABLE coffee_machines(
id uuid primary key,
water_ml numeric not null,
milk_ml numeric not null,
coffee_grams numeric not null,
trash_grams numeric not null
);

CREATE TABLE coffee(
id uuid primary key,
recipe_name varchar(255),
water_ml numeric not null,
milk_ml numeric not null,
coffee_grams numeric not null,
coffee_machine_id uuid references coffee_machines(id)
);

CREATE TABLE orders(
id uuid primary key,
coffee_machine_id uuid references coffee_machines(id),
coffee_id uuid references coffee(id),
create_date timestamp without time zone
);

INSERT INTO coffee (id, recipe_name, water_ml, milk_ml, coffee_grams) VALUES
('f58741e9-3068-438c-a0b9-17e244bd6053', 'espresso', 80, 0, 20),
('d52bb7f9-a9c0-42f7-a157-f8dd84715f72', 'americano', 160, 0, 20),
('4eaf2e96-4db7-4fb4-a0f1-eada1741336f', 'cappuccino', 120, 80, 20);

INSERT INTO coffee_machines VALUES
('b4f75be9-943d-40d6-88dc-e1d7d4e5a81b', 1000, 1000, 1000, 0);

INSERT INTO coffee VALUES
('4defdc27-45b5-4c18-89db-1cad1a89b9a8', 'custom1', 81, 10, 30, 'b4f75be9-943d-40d6-88dc-e1d7d4e5a81b'),
('e2cce872-ea06-45e1-8d68-71cd5524950f', 'custom2', 150, 20, 10, 'b4f75be9-943d-40d6-88dc-e1d7d4e5a81b');

insert into orders VALUES
('9e12712e-50e9-44ed-8412-01af21c63c42', 'b4f75be9-943d-40d6-88dc-e1d7d4e5a81b', '4defdc27-45b5-4c18-89db-1cad1a89b9a8', '2024-05-04 00:42:03.464797')

