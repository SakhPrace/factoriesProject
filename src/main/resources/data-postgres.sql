DELETE FROM factory;
INSERT INTO factory(id, name, exportid) VALUES(0, 'Factory One', 0);
INSERT INTO factory(id, name, exportid) VALUES(1, 'Factory Two', 0);
INSERT INTO factory(id, name, exportid) VALUES(2, 'Factory Three', 0);
INSERT INTO factory(id, name, exportid) VALUES(3, 'Factory Four', 0);
INSERT INTO factory(id, name, exportid) VALUES(4, 'Factory Five', 0);

DELETE FROM product;
INSERT INTO product(id, name, price_per_unit) VALUES(0, 'Wood', 10);
INSERT INTO product(id, name, price_per_unit) VALUES(1, 'Iron', 15);
INSERT INTO product(id, name, price_per_unit) VALUES(2, 'Electrical components', 20);
INSERT INTO product(id, name, price_per_unit) VALUES(3, 'Car', 100);
INSERT INTO product(id, name, price_per_unit) VALUES(4, 'Furniture', 50);

DELETE FROM transport_operator;
INSERT INTO transport_operator(id, name, price_per_unit) VALUES(0, 'CCC', 0);
INSERT INTO transport_operator(id, name, price_per_unit) VALUES(1, 'CCC', 0);
INSERT INTO transport_operator(id, name, price_per_unit) VALUES(2, 'CCC', 0);
INSERT INTO transport_operator(id, name, price_per_unit) VALUES(3, 'CCC', 0);
INSERT INTO transport_operator(id, name, price_per_unit) VALUES(4, 'CCC', 0);

DELETE FROM ordering;
INSERT INTO ordering(id, id_factory, id_product) VALUES(0, 0, 1);
INSERT INTO ordering(id, id_factory, id_product) VALUES(1, 0, 2);
INSERT INTO ordering(id, id_factory, id_product) VALUES(2, 1, 0);
INSERT INTO ordering(id, id_factory, id_product) VALUES(3, 2, 4);
INSERT INTO ordering(id, id_factory, id_product) VALUES(4, 3, 1);
INSERT INTO ordering(id, id_factory, id_product) VALUES(5, 4, 1);
INSERT INTO ordering(id, id_factory, id_product) VALUES(6, 4, 2);
INSERT INTO ordering(id, id_factory, id_product) VALUES(7, 2, 1);

