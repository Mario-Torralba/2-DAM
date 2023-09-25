ALTER TABLE PRODUCTO
DROP CONSTRAINT FK_PRODUCTO_PROVEEDOR;
ALTER TABLE CLIENTE_PRODUCTO
DROP CONSTRAINT FK_CLIENTE_PRODUCTO_idcliente;
ALTER TABLE CLIENTE_PRODUCTO
DROP CONSTRAINT FK_CLIENTE_PRODUCTO_idproducto;

DROP TABLE if exists PROVEEDOR;
DROP TABLE if exists CLIENTE_PRODUCTO;
DROP TABLE if exists PRODUCTO;
DROP TABLE if exists CLIENTE;

CREATE TABLE PRODUCTO(
                         idProducto SERIAL PRIMARY KEY,
                         idProveedor INT NOT NULL,
                         nombreProducto VARCHAR(100) NOT NULL,
                         precioProducto INT NOT NULL
);

CREATE TABLE CLIENTE(
                        idCliente SERIAL PRIMARY KEY,
                        nombreCliente VARCHAR(50),
                        apellidosCliente VARCHAR(100),
                        dniCliente VARCHAR(9),
                        direccionCliente VARCHAR(200),
                        fechaNacimiento DATE
);

CREATE TABLE CLIENTE_PRODUCTO(
                                 idClienteProducto SERIAL PRIMARY KEY,
                                 idCliente INT,
                                 idProducto INT
);


CREATE TABLE PROVEEDOR(
                          idProveedor SERIAL PRIMARY KEY,
                          NIF VARCHAR(9),
                          nombreProveedor VARCHAR(100),
                          direccionProveedor VARCHAR(200)
);

ALTER TABLE PRODUCTO
    ADD CONSTRAINT FK_PRODUCTO_PROVEEDOR FOREIGN KEY (idProveedor) REFERENCES PROVEEDOR (idProveedor);
ALTER TABLE CLIENTE_PRODUCTO
    ADD CONSTRAINT FK_CLIENTE_PRODUCTO_idcliente FOREIGN KEY (idCliente) REFERENCES CLIENTE (idCliente);
ALTER TABLE CLIENTE_PRODUCTO
    ADD CONSTRAINT FK_CLIENTE_PRODUCTO_idproducto FOREIGN KEY (idProducto) REFERENCES PRODUCTO (idProducto);
ALTER TABLE CLIENTE_PRODUCTO
    ADD CONSTRAINT UK_CLIENTE_PRODUCTO UNIQUE(idCliente, idProducto);

INSERT INTO PROVEEDOR (NIF, nombreProveedor, direccionProveedor) VALUES ('111111111','Proveedor-1','C/Proveedor-1');
INSERT INTO PROVEEDOR (NIF, nombreProveedor, direccionProveedor) VALUES ('222222222','Proveedor-2','C/Proveedor-2');
INSERT INTO PROVEEDOR (NIF, nombreProveedor, direccionProveedor) VALUES ('333333333','Proveedor-3','C/Proveedor-3');
INSERT INTO PROVEEDOR (NIF, nombreProveedor, direccionProveedor) VALUES ('444444444','Proveedor-4','C/Proveedor-4');
INSERT INTO PROVEEDOR (NIF, nombreProveedor, direccionProveedor) VALUES ('555555555','Proveedor-5','C/Proveedor-5');
INSERT INTO PROVEEDOR (NIF, nombreProveedor, direccionProveedor) VALUES ('666666666','Proveedor-6','C/Proveedor-6');

INSERT INTO PRODUCTO (idProveedor, nombreProducto, precioProducto) VALUES (1,'Producto-Proveedor-1',10);
INSERT INTO PRODUCTO (idProveedor, nombreProducto, precioProducto) VALUES (2,'Producto-Proveedor-2',20);
INSERT INTO PRODUCTO (idProveedor, nombreProducto, precioProducto) VALUES (3,'Producto-Proveedor-3',30);
INSERT INTO PRODUCTO (idProveedor, nombreProducto, precioProducto) VALUES (4,'Producto-Proveedor-4',40);
INSERT INTO PRODUCTO (idProveedor, nombreProducto, precioProducto) VALUES (5,'Producto-Proveedor-5',50);
INSERT INTO PRODUCTO (idProveedor, nombreProducto, precioProducto) VALUES (6,'Producto-Proveedor-6',60);

INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Paco','Paco','11111111A','C/Paco Paco', '2000-10-20');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Peco','Peco','11111111A','C/Peco Peco', '2000-10-21');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Pico','Pico','11111111A','C/Pico Pico', '2000-10-22');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Poco','Poco','11111111A','C/Poco Poco', '2000-10-23');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Puco','Puco','11111111A','C/Puco Puco', '2000-10-24');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Pueco','Pueco','11111111A','C/Pueco Pueco', '2000-10-25');

INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (1,1);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (1,2);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (2,3);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (2,4);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (3,5);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (3,6);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (4,1);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (4,2);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (5,3);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (5,4);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (6,5);
INSERT INTO CLIENTE_PRODUCTO (idCliente, idProducto) VALUES (6,6);


