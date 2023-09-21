ALTER TABLE PRODUCTO
DROP CONSTRAINT FK_PRODUCTO_PROVEEDOR;
ALTER TABLE CLIENTE_PRODUCTO
DROP CONSTRAINT FK_CLIENTE_PRODUCTO_idcliente;
ALTER TABLE CLIENTE_PRODUCTO
DROP CONSTRAINT FK_CLIENTE_PRODUCTO_idproducto;

DROP TABLE PROVEEDOR;
DROP TABLE CLIENTE_PRODUCTO;
DROP TABLE PRODUCTO;
DROP TABLE CLIENTE;

CREATE TABLE PRODUCTO(
    idProducto INT GENERATED ALWAYS AS IDENTITY,
    idProveedor INT,
    nombreProducto VARCHAR2(100),
    precioProducto INT
);

CREATE TABLE CLIENTE(
    idCliente INT GENERATED ALWAYS AS IDENTITY,
    nombreCliente VARCHAR2(50),
    apellidosCliente VARCHAR2(100),
    dniCliente VARCHAR2(9),
    direccionCliente VARCHAR2(200),
    fechaNacimiento DATE
);

CREATE TABLE CLIENTE_PRODUCTO(
    idClienteProducto INT GENERATED ALWAYS AS IDENTITY,
    idCliente INT,
    idProducto INT
);


CREATE TABLE PROVEEDOR(
    idProveedor INT GENERATED ALWAYS AS IDENTITY,
    NIF VARCHAR2(9),
    nombreProveedor VARCHAR2(100),
    direccionProveedor VARCHAR2(200)
);
ALTER TABLE PROVEEDOR
ADD CONSTRAINT PK_PROVEEDOR PRIMARY KEY (idProveedor);

ALTER TABLE PRODUCTO
ADD CONSTRAINT PK_PRODUCTO PRIMARY KEY (idProducto);

ALTER TABLE CLIENTE
ADD CONSTRAINT PK_CLIENTE PRIMARY KEY (idCliente);

ALTER TABLE CLIENTE_PRODUCTO
ADD CONSTRAINT PK_CLIENTE_PRODUCTO PRIMARY KEY (idClienteProducto);


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

INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Paco','Paco','11111111A','C/Paco Paco', '20-10-2000');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Peco','Peco','11111111A','C/Peco Peco', '21-10-2000');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Pico','Pico','11111111A','C/Pico Pico', '22-10-2000');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Poco','Poco','11111111A','C/Poco Poco', '23-10-2000');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Puco','Puco','11111111A','C/Puco Puco', '24-10-2000');
INSERT INTO CLIENTE (nombreCliente, apellidosCliente, dniCliente, direccionCliente, fechaNacimiento) VALUES ('Pueco','Pueco','11111111A','C/Pueco Pueco', '25-10-2000');

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


