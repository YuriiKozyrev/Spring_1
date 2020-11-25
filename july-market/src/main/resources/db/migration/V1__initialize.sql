drop table if exists categories cascade;
create table categories (id bigserial, title varchar(255), primary key(id));
insert into categories
(title) values
('Milkstuff'),
('Fruits'),
('Breadstuff'),
('Vegetables'),
('Grocery');

drop table if exists products cascade;
create table products (id bigserial, title varchar(255), description varchar(5000),
                        price int, category_id int REFERENCES categories(id), primary key(id));
insert into products
(title, description, price, category_id) values
('Cheese', 'Fresh cheese', 320, 1),
('Milk', 'Fresh milk', 80, 1),
('Apples', 'Fresh apples', 80, 2),
('Bread', 'Fresh bread', 30, 3),
('A1', '', 1, 1),
('A2', '', 2, 1),
('A3', '', 3, 1),
('A4', '', 4, 1),
('A5', '', 5, 1),
('A6', '', 6, 1),
('A7', '', 7, 1),
('A8', '', 8, 1),
('A9', '', 9, 1),
('A10', '', 10, 2),
('A11', '', 11, 2),
('A12', '', 12, 2),
('A13', '', 13, 2),
('A14', '', 14, 2),
('A15', '', 15, 2),
('A16', '', 16, 2),
('A17', '', 17, 2),
('A18', '', 18, 2),
('A19', '', 19, 2),
('A20', '', 20, 3);


