ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

ALTER TABLE Vender_proveedor DROP CONSTRAINT FK_Vender_proveedor_PROVEEDOR;
ALTER TABLE Vender_proveedor DROP CONSTRAINT FK_Vender_proveedor_PRODUCTO;
ALTER TABLE HOJA_PEDIDO DROP CONSTRAINT FK_HOJA_PEDIDO_VENDER_PROVEEDOR;
ALTER TABLE ALBARAN DROP CONSTRAINT FK_ALBARAN_VENDER_PROVEEDOR;
ALTER TABLE Vender_particular DROP CONSTRAINT FK_Vender_particular_PARTICULAR;
ALTER TABLE Vender_particular DROP CONSTRAINT FK_Vender_particular_PRODUCTO;
ALTER TABLE DETALLE_NOTA_PAGO DROP CONSTRAINT FK_DETALLE_NOTA_PAGO_NOTA_PAGO;
ALTER TABLE DETALLE_NOTA_PAGO DROP CONSTRAINT FK_DETALLE_NOTA_PAGO_PRODUCTO;
ALTER TABLE NOTA_PAGO DROP CONSTRAINT FK_NOTA_PAGO_PARTICULAR;
ALTER TABLE DETALLE_HOJA_PEDIDO DROP CONSTRAINT FK_DETALLE_HOJA_PEDIDO_HOJA_PEDIDO;
ALTER TABLE DETALLE_HOJA_PEDIDO DROP CONSTRAINT FK_DETALLE_HOJA_PEDIDO_PRODUCTO;
ALTER TABLE DETALLE_ALBARAN DROP CONSTRAINT FK_DETALLE_ALBARAN_ALBARAN;
ALTER TABLE DETALLE_ALBARAN DROP CONSTRAINT FK_DETALLE_ALBARAN_PRODUCTO;

DROP TABLE Vender_particular;
DROP TABLE DETALLE_NOTA_PAGO;
DROP TABLE Vender_proveedor;
DROP TABLE DETALLE_HOJA_PEDIDO;
DROP TABLE DETALLE_ALBARAN;
DROP TABLE NOTA_PAGO;
DROP TABLE PARTICULAR;
DROP TABLE PRODUCTO;
DROP TABLE PROVEEDOR;
DROP TABLE HOJA_PEDIDO;
DROP TABLE ALBARAN;
DROP TABLE CLIENTE;

CREATE TABLE PARTICULAR (
                            ID_PARTICULAR NUMBER,
                            DNI_PARTICULAR VARCHAR2(10) NOT NULL,
                            NOMBRE_PARTICULAR VARCHAR2(100) NOT NULL,
                            TLF_PARTICULAR VARCHAR2(15),
                            DIRECCION_PARTICULAR VARCHAR2(200)
);
CREATE TABLE NOTA_PAGO (
                           ID_NOTA_PAGO NUMBER,
                           ID_PARTICULAR NUMBER,
                           FECHA DATE NOT NULL,
                           FIRMA VARCHAR2(200) NOT NULL
);
CREATE TABLE PRODUCTO (
                          ID_PRODUCTO NUMBER,
                          NOMBRE_PRODUCTO VARCHAR2(100) NOT NULL,
                          DESCRIPCION_PRODUCTO VARCHAR2(200),
                          PRECIO_UNIDAD NUMBER(10, 2) NOT NULL
);
CREATE TABLE PROVEEDOR (
                           ID_PROVEEDOR NUMBER,
                           NOMBRE_PROVEEDOR VARCHAR2(100) NOT NULL,
                           DIRECCION_PROVEEDOR VARCHAR2(200),
                           TLF_PROVEEDOR VARCHAR2(15),
                           URL_PROVEEDOR VARCHAR2(200)
);
CREATE TABLE HOJA_PEDIDO (
                             ID_HOJA_PEDIDO NUMBER,
                             ID_VENDER_PROVEEDOR NUMBER,
                             FECHA_PEDIDO DATE NOT NULL,
                             HORA_PEDIDO VARCHAR2(5),
                             DIRECCION_ENVIO VARCHAR2(200)
);
CREATE TABLE ALBARAN (
                         ID_ALBARAN NUMBER,
                         ID_VENDER_PROVEEDOR NUMBER,
                         FECHA_ALBARAN DATE NOT NULL,
                         HORA_ALBARAN VARCHAR2(5)
);
CREATE TABLE Vender_particular (
                                   ID_VENDER_PARTICULAR NUMBER,
                                   ID_PARTICULAR NUMBER,
                                   ID_PRODUCTO NUMBER
);
CREATE TABLE DETALLE_NOTA_PAGO (
                                   ID_DETALLE_NOTA_PAGO NUMBER,
                                   ID_NOTA_PAGO NUMBER,
                                   ID_PRODUCTO NUMBER,
                                   CANTIDAD_NOTA_PAGO NUMBER
);
CREATE TABLE Vender_proveedor (
                                   ID_VENDER_PROVEEDOR NUMBER,
                                   ID_PROVEEDOR NUMBER,
                                   ID_PRODUCTO NUMBER
);
CREATE TABLE DETALLE_HOJA_PEDIDO (
                                  ID_DETALLE_HOJA_PEDIDO NUMBER,
                                  ID_HOJA_PEDIDO NUMBER,
                                  ID_PRODUCTO NUMBER,
                                  CANTIDAD_PEDIDO NUMBER
);
CREATE TABLE DETALLE_ALBARAN (
                                  ID_DETALLE_ALBARAN NUMBER,
                                  ID_ALBARAN NUMBER,
                                  ID_PRODUCTO NUMBER,
                                  CANTIDAD_ALBARAN NUMBER
);
CREATE TABLE CLIENTE (
                                  ID_CLIENTE NUMBER,
                                  USUARIO VARCHAR2(30),
                                  PASS VARCHAR2(30),
                                  TLF VARCHAR2(9),
                                  NOMBRE VARCHAR2(30),
                                  APELLIDO_1 VARCHAR2(50),
                                  APELLIDO_2 VARCHAR2(50),
                                  EMAIL VARCHAR2(200)
);



ALTER TABLE PARTICULAR
ADD CONSTRAINT PK_PARTICULAR PRIMARY KEY (ID_PARTICULAR);



ALTER TABLE NOTA_PAGO
ADD CONSTRAINT PK_NOTA_PAGO PRIMARY KEY (ID_NOTA_PAGO);
ALTER TABLE NOTA_PAGO
ADD CONSTRAINT FK_NOTA_PAGO_PARTICULAR FOREIGN KEY (ID_PARTICULAR) REFERENCES PARTICULAR (ID_PARTICULAR);



ALTER TABLE PRODUCTO
ADD CONSTRAINT PK_PRODUCTO PRIMARY KEY (ID_PRODUCTO);



ALTER TABLE DETALLE_NOTA_PAGO
ADD CONSTRAINT PK_DETALLE_NOTA_PAGO PRIMARY KEY (ID_DETALLE_NOTA_PAGO);
ALTER TABLE DETALLE_NOTA_PAGO
ADD CONSTRAINT UK_DETALLE_NOTA_PAGO UNIQUE (ID_DETALLE_NOTA_PAGO, ID_PRODUCTO, ID_NOTA_PAGO);
ALTER TABLE DETALLE_NOTA_PAGO
ADD CONSTRAINT FK_DETALLE_NOTA_PAGO_NOTA_PAGO FOREIGN KEY (ID_NOTA_PAGO) REFERENCES NOTA_PAGO (ID_NOTA_PAGO);
ALTER TABLE DETALLE_NOTA_PAGO
ADD CONSTRAINT FK_DETALLE_NOTA_PAGO_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);



ALTER TABLE Vender_particular
ADD CONSTRAINT PK_Vender_particular PRIMARY KEY (ID_VENDER_PARTICULAR);
ALTER TABLE Vender_particular
ADD CONSTRAINT UK_Vender_particular UNIQUE (ID_VENDER_PARTICULAR, ID_PRODUCTO, ID_PARTICULAR);
ALTER TABLE Vender_particular
ADD CONSTRAINT FK_Vender_particular_PARTICULAR FOREIGN KEY (ID_PARTICULAR) REFERENCES PARTICULAR (ID_PARTICULAR);
ALTER TABLE Vender_particular
ADD CONSTRAINT FK_Vender_particular_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);



ALTER TABLE PROVEEDOR
ADD CONSTRAINT PK_PROVEEDOR PRIMARY KEY (ID_PROVEEDOR);



ALTER TABLE Vender_proveedor
ADD CONSTRAINT PK_Vender_proveedor PRIMARY KEY (ID_VENDER_PROVEEDOR);
ALTER TABLE Vender_proveedor
ADD CONSTRAINT UK_Vender_proveedor UNIQUE (ID_VENDER_PROVEEDOR, ID_PRODUCTO, ID_PROVEEDOR);
ALTER TABLE Vender_proveedor
ADD CONSTRAINT FK_Vender_proveedor_PROVEEDOR FOREIGN KEY (ID_PROVEEDOR) REFERENCES PROVEEDOR (ID_PROVEEDOR);
ALTER TABLE Vender_proveedor
ADD CONSTRAINT FK_Vender_proveedor_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);



ALTER TABLE HOJA_PEDIDO
ADD CONSTRAINT PK_HOJA_PEDIDO PRIMARY KEY (ID_HOJA_PEDIDO);
ALTER TABLE HOJA_PEDIDO
ADD CONSTRAINT FK_HOJA_PEDIDO_VENDER_PROVEEDOR FOREIGN KEY (ID_VENDER_PROVEEDOR) REFERENCES Vender_proveedor (ID_VENDER_PROVEEDOR);



ALTER TABLE ALBARAN
ADD CONSTRAINT PK_ALBARAN PRIMARY KEY (ID_ALBARAN);
ALTER TABLE ALBARAN
ADD CONSTRAINT FK_ALBARAN_VENDER_PROVEEDOR FOREIGN KEY (ID_VENDER_PROVEEDOR) REFERENCES Vender_proveedor (ID_VENDER_PROVEEDOR);



ALTER TABLE DETALLE_HOJA_PEDIDO
ADD CONSTRAINT PK_DETALLE_HOJA_PEDIDO PRIMARY KEY (ID_DETALLE_HOJA_PEDIDO);
ALTER TABLE DETALLE_HOJA_PEDIDO
ADD CONSTRAINT UK_DETALLE_HOJA_PEDIDO UNIQUE (ID_DETALLE_HOJA_PEDIDO, ID_PRODUCTO, ID_HOJA_PEDIDO);
ALTER TABLE DETALLE_HOJA_PEDIDO
ADD CONSTRAINT FK_DETALLE_HOJA_PEDIDO_HOJA_PEDIDO FOREIGN KEY (ID_HOJA_PEDIDO) REFERENCES HOJA_PEDIDO (ID_HOJA_PEDIDO);
ALTER TABLE DETALLE_HOJA_PEDIDO
ADD CONSTRAINT FK_DETALLE_HOJA_PEDIDO_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);



ALTER TABLE DETALLE_ALBARAN
ADD CONSTRAINT PK_DETALLE_ALBARAN PRIMARY KEY (ID_DETALLE_ALBARAN);
ALTER TABLE DETALLE_ALBARAN
ADD CONSTRAINT UK_DETALLE_ALBARAN UNIQUE (ID_DETALLE_ALBARAN, ID_PRODUCTO, ID_ALBARAN);
ALTER TABLE DETALLE_ALBARAN
ADD CONSTRAINT FK_DETALLE_ALBARAN_ALBARAN FOREIGN KEY (ID_ALBARAN) REFERENCES ALBARAN (ID_ALBARAN);
ALTER TABLE DETALLE_ALBARAN
ADD CONSTRAINT FK_DETALLE_ALBARAN_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);

ALTER TABLE CLIENTE
ADD CONSTRAINT PK_CLIENTE PRIMARY KEY (ID_CLIENTE);