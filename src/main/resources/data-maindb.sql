SET foreign_key_checks = 0;
DELETE FROM maindb.factory;
INSERT INTO factory(id, name, exportid, password) VALUES(1, 'Factory One', 1, '$2y$16$6tbZ.1cbSZyvPfS7KBjf1eDRYD5aiGUxSfijdkCqeJWaZj1aWnYR2'); /*pF1*/
INSERT INTO factory(id, name, exportid, password) VALUES(2, 'Factory Two', 1, '$2y$16$.oidnx809LReNTaR6P/3ouqW4btmNIAud8dwFzPUBfzXLHqfu180O'); /*pF2*/
INSERT INTO factory(id, name, exportid, password) VALUES(3, 'Factory Three', 1, '$2y$16$InrdRWShm1FmUmWTL0Rifu8ziY8s5mzYbkFIA/xJ2bP6PaeGMXZ9G'); /*pF3*/
INSERT INTO factory(id, name, exportid, password) VALUES(4, 'Factory Four', 1, '$2y$16$IV/xkYW2uIGerGm9PbA6kuC1sqydtJ2z95ptaqeFIn6Shx99JTO1i'); /*pF4*/
INSERT INTO factory(id, name, exportid, password) VALUES(5, 'Factory Five', 1, '$2y$16$tmGNZur/mo4i/WhoOTR40OjRIoLDQMQD.AYvb51dHbT.1cPc2ojDm'); /*pF5*/

DELETE FROM maindb.product;
INSERT INTO product(id, name, price_per_unit) VALUES(1, 'Wood', 10);
INSERT INTO product(id, name, price_per_unit) VALUES(2, 'Iron', 15);
INSERT INTO product(id, name, price_per_unit) VALUES(3, 'Electrical components', 20);
INSERT INTO product(id, name, price_per_unit) VALUES(4, 'Car', 100);
INSERT INTO product(id, name, price_per_unit) VALUES(5, 'Furniture', 50);

DELETE FROM maindb.transporter;
INSERT INTO transporter(id, name, price_per_unit,password) VALUES(1, 'CCC1', 1, '$2y$16$rNQMZBVxYeKuqp.0qpujSOjO0tg6yzSME9DV4VxXbDu0Dom/YTH2a'); /*pT1*/
INSERT INTO transporter(id, name, price_per_unit,password) VALUES(2, 'CCC2', 1, '$2y$16$.NP7.fYZSBCe9osNOIJjJOgsulr77qOle3ievVx7wne/FcgOIwA9q'); /*pT2*/
INSERT INTO transporter(id, name, price_per_unit,password) VALUES(3, 'CCC3', 1, '$2y$16$QeN/My.qOPCJ.F0izfE7FefTka6C7rq8YixYqAXu9/uIUb0Jp0sn2'); /*pT3*/
INSERT INTO transporter(id, name, price_per_unit,password) VALUES(4, 'CCC4', 1, '$2y$16$zcpleK/gEHiG5zhy1MHvZOAja3uBaWgdt1OsBCx2Qm2PC4.d1h4/2'); /*pT4*/
INSERT INTO transporter(id, name, price_per_unit,password) VALUES(5, 'CCC5', 1, '$2y$16$IDh1wV7Fk..Yvx..UGXtdeRAtXz7dYXPBfGgZaiyJQ0gOFq5UAAwK'); /*pT5*/

DELETE FROM maindb.ordering;
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(1, 1, 2, 1, 3000,true);
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(2, 1, 3, null, null,true);
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(3, 2, 1, 5, 4000,false);
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(4, 3, 5, 3, 6000,true);
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(5, 4, 2, 2, 3500,false);
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(6, 5, 2, null, null,true);
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(7, 5, 3, 4, 1000,false);
INSERT INTO ordering(id, id_factory, id_product, id_transport, price,accepted) VALUES(8, 3, 2, 1, 2500,true);


DELETE FROM maindb.roads_backing;
INSERT INTO roads_backing(origid, destid, weight) VALUES (1,2,1), (2,3,3), (3,4,2), (4,5,3), (2,4,8), (2,5,7),(3,5,1),(2,1,1), (3,2,3), (4,3,2), (5,4,3), (4,2,8), (5,2,7),(5,3,1);