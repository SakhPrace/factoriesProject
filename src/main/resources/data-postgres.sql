DELETE FROM factory;
INSERT INTO factory(id, name, exportid) VALUES(0, 'AAA', 0);

DELETE FROM product;
INSERT INTO product(id, name, price_per_unit) VALUES(0, 'BBB', 0);

DELETE FROM transport_operator;
INSERT INTO transport_operator(id, name, price_per_unit) VALUES(0, 'CCC', 0);

DELETE FROM ordering;
INSERT INTO ordering(id, id_factory, id_product) VALUES(0, 0, 0);