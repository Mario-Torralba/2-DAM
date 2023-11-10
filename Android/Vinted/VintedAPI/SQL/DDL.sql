DROP TABLE PRODUCTO_COLOR;
DROP TABLE PRODUCTO_CATEGORIA;
DROP TABLE COLOR;
DROP TABLE CATEGORIA;
DROP TABLE FAVORITO;
DROP TABLE VENTA;
DROP TABLE PRODUCTO;
DROP TABLE DIRECCION_CLIENTE;
DROP TABLE VALORACION;
DROP TABLE USUARIO;


CREATE TABLE USUARIO(
    ID_USUARIO SMALLSERIAL,
    NICK VARCHAR(30) NOT NULL,
    PASS VARCHAR(30) NOT NULL,
    TLF_USUARIO VARCHAR(15),
    NOMBRE_USUARIO VARCHAR(30) NOT NULL,
    APELLIDO_1_USUARIO VARCHAR(30) NOT NULL,
    APELLIDO_2_USUARIO VARCHAR(30) NOT NULL,
    EMAIL_USUARIO VARCHAR(150) NOT NULL
);

CREATE TABLE VALORACION(
    ID_VALORACION SMALLSERIAL,
    ID_USUARIO SMALLSERIAL,
    ESTRELLAS NUMERIC(1,0) NOT NULL,
    COMENTARIO VARCHAR(255)
);

CREATE TABLE DIRECCION_CLIENTE(
    ID_DIRECCION_CLIENTE SMALLSERIAL,
    ID_USUARIO SMALLSERIAL,
    PAIS VARCHAR(50) NOT NULL,
    PROVINCIA VARCHAR(50) NOT NULL,
    CIUDAD VARCHAR(50) NOT NULL,
    CP NUMERIC(6,0) NOT NULL,
    DIRECCION VARCHAR(255) NOT NULL
);
DROP TYPE hola;
CREATE TYPE hola AS ENUM ('Nuevo con etiquetas','Nuevo sin etiquetas','Muy bueno','Bueno','Satisfactorio');

CREATE TABLE PRODUCTO(
    ID_PRODUCTO SMALLSERIAL,
    ID_USUARIO SMALLSERIAL,
    NOMBRE_PRODUCTO VARCHAR(100) NOT NULL,
    DESCRIPCION_PRODUCTO VARCHAR(100) NOT NULL,
    MARCA_PRODUCTO VARCHAR(100) NOT NULL,
    PRECIO_PRODUCTO INTEGER NOT NULL,
    IMAGEN_PRODUCTO VARCHAR(250) NOT NULL,
    ESTADO hola
);

CREATE TABLE VENTA(
    ID_VENTA SMALLSERIAL,
    ID_USUARIO SMALLSERIAL,
    ID_PRODUCTO SMALLSERIAL,
    ID_DIRECCION_CLIENTE SMALLSERIAL,
    FECHA_VENTA DATE NOT NULL
);

CREATE TABLE FAVORITO(
    ID_FAVORITO SMALLSERIAL,
    ID_PRODUCTO SMALLSERIAL,
    ID_USUARIO SMALLSERIAL
);

CREATE TABLE CATEGORIA(
    ID_CATEGORIA SMALLSERIAL,
    NOMBRE_CATEGORIA VARCHAR(100)
);

CREATE TABLE COLOR(
    ID_COLOR SMALLSERIAL,
    NOMBRE_COLOR VARCHAR(100)
);

CREATE TABLE PRODUCTO_CATEGORIA(
    ID_PRODUCTO_CATEGORIA SMALLSERIAL,
    ID_PRODUCTO SMALLSERIAL,
    ID_CATEGORIA SMALLSERIAL
);

CREATE TABLE PRODUCTO_COLOR(
    ID_PRODUCTO_COLOR SMALLSERIAL,
    ID_PRODUCTO SMALLSERIAL,
    ID_COLOR SMALLSERIAL
);



ALTER TABLE USUARIO
ADD CONSTRAINT PK_USUARIO PRIMARY KEY (ID_USUARIO);



ALTER TABLE VALORACION
ADD CONSTRAINT PK_VALORACION PRIMARY KEY (ID_VALORACION);
ALTER TABLE VALORACION
ADD CONSTRAINT FK_VALORACION_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO);


ALTER TABLE DIRECCION_CLIENTE
ADD CONSTRAINT PK_DIRECCION_CLIENTE PRIMARY KEY (ID_DIRECCION_CLIENTE);
ALTER TABLE DIRECCION_CLIENTE
ADD CONSTRAINT FK_DIRECCION_CLIENTE_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO);



ALTER TABLE PRODUCTO
ADD CONSTRAINT PK_PRODUCTO PRIMARY KEY (ID_PRODUCTO);
ALTER TABLE PRODUCTO
ADD CONSTRAINT FK_PRODUCTO_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO);



ALTER TABLE COLOR
ADD CONSTRAINT PK_COLOR PRIMARY KEY (ID_COLOR);



ALTER TABLE CATEGORIA
ADD CONSTRAINT PK_CATEGORIA PRIMARY KEY (ID_CATEGORIA);


ALTER TABLE VENTA
ADD CONSTRAINT PK_VENTA PRIMARY KEY (ID_VENTA);
ALTER TABLE VENTA
ADD CONSTRAINT FK_VENTA_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO);
ALTER TABLE VENTA
ADD CONSTRAINT FK_VENTA_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);
ALTER TABLE VENTA
ADD CONSTRAINT FK_VENTA_DIRECCION_CLIENTE FOREIGN KEY (ID_DIRECCION_CLIENTE) REFERENCES DIRECCION_CLIENTE (ID_DIRECCION_CLIENTE);



ALTER TABLE FAVORITO
ADD CONSTRAINT PK_FAVORITO PRIMARY KEY (ID_FAVORITO);
ALTER TABLE FAVORITO
ADD CONSTRAINT FK_FAVORITO_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO);
ALTER TABLE FAVORITO
ADD CONSTRAINT FK_FAVORITO_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);
ALTER TABLE FAVORITO
ADD CONSTRAINT UK_FAVORITO UNIQUE (ID_PRODUCTO, ID_FAVORITO, ID_USUARIO);



ALTER TABLE PRODUCTO_CATEGORIA
ADD CONSTRAINT PK_PRODUCTO_CATEGORIA PRIMARY KEY (ID_PRODUCTO_CATEGORIA);
ALTER TABLE PRODUCTO_CATEGORIA
ADD CONSTRAINT FK_PRODUCTO_CATEGORIA_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);
ALTER TABLE PRODUCTO_CATEGORIA
ADD CONSTRAINT FK_PRODUCTO_CATEGORIA_CATEGORIA FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA (ID_CATEGORIA);
ALTER TABLE PRODUCTO_CATEGORIA
ADD CONSTRAINT UK_PRODUCTO_CATEGORIA UNIQUE (ID_PRODUCTO, ID_CATEGORIA, ID_PRODUCTO_CATEGORIA);



ALTER TABLE PRODUCTO_COLOR
ADD CONSTRAINT PK_PRODUCTO_COLOR PRIMARY KEY (ID_PRODUCTO_COLOR);
ALTER TABLE PRODUCTO_COLOR
ADD CONSTRAINT FK_PRODUCTO_COLOR_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO);
ALTER TABLE PRODUCTO_COLOR
ADD CONSTRAINT FK_PRODUCTO_COLOR_COLOR FOREIGN KEY (ID_COLOR) REFERENCES COLOR (ID_COLOR);
ALTER TABLE PRODUCTO_COLOR
ADD CONSTRAINT UK_PRODUCTO_COLOR UNIQUE (ID_PRODUCTO, ID_COLOR, ID_PRODUCTO_COLOR);