-- PARTICULAR
INSERT INTO PARTICULAR VALUES(1, 'DNI001', 'Juan Perez', '555-5555', 'Calle 1 #1');
INSERT INTO PARTICULAR VALUES(2, 'DNI002', 'Ana Maria', '555-5556', 'Calle 2 #2');
INSERT INTO PARTICULAR VALUES(3, 'DNI003', 'Luis Fernandez', '555-5557', 'Calle 3 #3');
INSERT INTO PARTICULAR VALUES(4, 'DNI004', 'Maria Hernandez', '555-5558', 'Calle 4 #4');
INSERT INTO PARTICULAR VALUES(5, 'DNI005', 'Pedro Rojas', '555-5559', 'Calle 5 #5');


-- NOTA_PAGO
INSERT INTO NOTA_PAGO VALUES(1, 1, '2023-10-14', 'Firma1');
INSERT INTO NOTA_PAGO VALUES(2, 2, '2023-10-13', 'Firma2');
INSERT INTO NOTA_PAGO VALUES(3, 3, '2023-10-12', 'Firma3');
INSERT INTO NOTA_PAGO VALUES(4, 4, '2023-10-11', 'Firma4');
INSERT INTO NOTA_PAGO VALUES(5, 5, '2023-10-10', 'Firma5');


--PRODUCTO
INSERT INTO PRODUCTO VALUES(1, 'Producto1', 'Descripcion1', 100.00);
INSERT INTO PRODUCTO VALUES(2, 'Producto2', 'Descripcion2', 150.00);
INSERT INTO PRODUCTO VALUES(3, 'Producto3', 'Descripcion3', 200.00);
INSERT INTO PRODUCTO VALUES(4, 'Producto4', 'Descripcion4', 250.00);
INSERT INTO PRODUCTO VALUES(5, 'Producto5', 'Descripcion5', 300.00);


--PROVEEDOR
INSERT INTO PROVEEDOR VALUES(1, 'Proveedor1', 'Direccion1', '555-5560', 'http://proveedor1.com');
INSERT INTO PROVEEDOR VALUES(2, 'Proveedor2', 'Direccion2', '555-5561', 'http://proveedor2.com');
INSERT INTO PROVEEDOR VALUES(3, 'Proveedor3', 'Direccion3', '555-5562', 'http://proveedor3.com');
INSERT INTO PROVEEDOR VALUES(4, 'Proveedor4', 'Direccion4', '555-5563', 'http://proveedor4.com');
INSERT INTO PROVEEDOR VALUES(5, 'Proveedor5', 'Direccion5', '555-5564', 'http://proveedor5.com');


--Vender_particular
INSERT INTO Vender_particular VALUES(1, 1, 1);
INSERT INTO Vender_particular VALUES(2, 2, 2);
INSERT INTO Vender_particular VALUES(3, 3, 3);
INSERT INTO Vender_particular VALUES(4, 4, 4);
INSERT INTO Vender_particular VALUES(5, 5, 5);


--Vender_proveedor
INSERT INTO Vender_proveedor VALUES(1, 1, 1);
INSERT INTO Vender_proveedor VALUES(2, 2, 2);
INSERT INTO Vender_proveedor VALUES(3, 3, 3);
INSERT INTO Vender_proveedor VALUES(4, 4, 4);
INSERT INTO Vender_proveedor VALUES(5, 5, 5);


--DETALLE_NOTA_PAGO
INSERT INTO DETALLE_NOTA_PAGO VALUES(1, 1, 1, 10);
INSERT INTO DETALLE_NOTA_PAGO VALUES(2, 2, 2, 11);
INSERT INTO DETALLE_NOTA_PAGO VALUES(3, 3, 3, 12);
INSERT INTO DETALLE_NOTA_PAGO VALUES(4, 4, 4, 13);
INSERT INTO DETALLE_NOTA_PAGO VALUES(5, 5, 5, 14);


--HOJA_PEDIDO
INSERT INTO HOJA_PEDIDO VALUES(1, 1, '2023-10-14', '10:00', 'DireccionEnvio1');
INSERT INTO HOJA_PEDIDO VALUES(2, 2, '2023-10-13', '11:00', 'DireccionEnvio2');
INSERT INTO HOJA_PEDIDO VALUES(3, 3, '2023-10-12', '12:00', 'DireccionEnvio3');
INSERT INTO HOJA_PEDIDO VALUES(4, 4, '2023-10-11', '13:00', 'DireccionEnvio4');
INSERT INTO HOJA_PEDIDO VALUES(5, 5, '2023-10-10', '14:00', 'DireccionEnvio5');


--ALBARAN
INSERT INTO ALBARAN VALUES(1, 1, '2023-10-14', '05:00');
INSERT INTO ALBARAN VALUES(2, 2, '2023-10-13', '06:00');
INSERT INTO ALBARAN VALUES(3, 3, '2023-10-12', '07:00');
INSERT INTO ALBARAN VALUES(4, 4, '2023-10-11', '08:00');
INSERT INTO ALBARAN VALUES(5, 5, '2023-10-10', '09:00');


--DETALLE_HOJA_PEDIDO
INSERT INTO DETALLE_HOJA_PEDIDO VALUES(1, 1, 1, 10);
INSERT INTO DETALLE_HOJA_PEDIDO VALUES(2, 2, 2, 11);
INSERT INTO DETALLE_HOJA_PEDIDO VALUES(3, 3, 3, 12);
INSERT INTO DETALLE_HOJA_PEDIDO VALUES(4, 4, 4, 13);
INSERT INTO DETALLE_HOJA_PEDIDO VALUES(5, 5, 5, 14);


--DETALLE_ALBARAN
INSERT INTO DETALLE_ALBARAN VALUES(1, 1, 1, 10);
INSERT INTO DETALLE_ALBARAN VALUES(2, 2, 2, 11);
INSERT INTO DETALLE_ALBARAN VALUES(3, 3, 3, 12);
INSERT INTO DETALLE_ALBARAN VALUES(4, 4, 4, 13);
INSERT INTO DETALLE_ALBARAN VALUES(5, 5, 5, 14);