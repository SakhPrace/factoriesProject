DELETE FROM factory;
INSERT INTO factory(id, name, exportid, password) VALUES(0, 'Factory One', 0, '$2y$16$VMBpeMOvWKFHvLF/3EO68e1uFeOMm/OWP3unVAgsOwPOxBPVIwtyK'); /*passwordFactoryOne*/
INSERT INTO factory(id, name, exportid, password) VALUES(1, 'Factory Two', 0, 'abc2d');
INSERT INTO factory(id, name, exportid, password) VALUES(2, 'Factory Three', 0, 'abc3d');
INSERT INTO factory(id, name, exportid, password) VALUES(3, 'Factory Four', 0, 'abc4d');
INSERT INTO factory(id, name, exportid, password) VALUES(4, 'Factory Five', 0, 'abc5d');

DELETE FROM product;
INSERT INTO product(id, name, price_per_unit) VALUES(0, 'Wood', 10);
INSERT INTO product(id, name, price_per_unit) VALUES(1, 'Iron', 15);
INSERT INTO product(id, name, price_per_unit) VALUES(2, 'Electrical components', 20);
INSERT INTO product(id, name, price_per_unit) VALUES(3, 'Car', 100);
INSERT INTO product(id, name, price_per_unit) VALUES(4, 'Furniture', 50);

DELETE FROM transport_operator;
INSERT INTO transport_operator(id, name, price_per_unit, password) VALUES(0, 'CCC1', 0, 'dcb1a');
INSERT INTO transport_operator(id, name, price_per_unit, password) VALUES(1, 'CCC2', 0, 'dcb2a');
INSERT INTO transport_operator(id, name, price_per_unit, password) VALUES(2, 'CCC3', 0, 'dcb3a');
INSERT INTO transport_operator(id, name, price_per_unit, password) VALUES(3, 'CCC4', 0, 'dcb4a');
INSERT INTO transport_operator(id, name, price_per_unit, password) VALUES(4, 'CCC5', 0, 'dcb5a');

DELETE FROM ordering;
INSERT INTO ordering(id, id_factory, id_product) VALUES(0, 0, 1);
INSERT INTO ordering(id, id_factory, id_product) VALUES(1, 0, 2);
INSERT INTO ordering(id, id_factory, id_product) VALUES(2, 1, 0);
INSERT INTO ordering(id, id_factory, id_product) VALUES(3, 2, 4);
INSERT INTO ordering(id, id_factory, id_product) VALUES(4, 3, 1);
INSERT INTO ordering(id, id_factory, id_product) VALUES(5, 4, 1);
INSERT INTO ordering(id, id_factory, id_product) VALUES(6, 4, 2);
INSERT INTO ordering(id, id_factory, id_product) VALUES(7, 2, 1);

