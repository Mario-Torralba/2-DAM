DROP TABLE socio;
CREATE TABLE socio(
    id_socio CHAR(4),
    nombre VARCHAR(30),
    apellidos VARCHAR(60),
    alta_socio DATE,
    baja_socio DATE DEFAULT NULL,
    CONSTRAINT PK_socio PRIMARY KEY (id_socio),
    CONSTRAINT NN_socio_nombre CHECK (nombre IS NOT NULL),
    CONSTRAINT NN_socio_apellidos CHECK (apellidos IS NOT NULL),
    CONSTRAINT NN_socio_alta CHECK (alta_socio IS NOT NULL)
);

INSERT INTO SOCIO (id_socio, nombre, apellidos, alta_socio) VALUES ('AAAA','LALA', 'LOPEZ', SYSDATE);
INSERT INTO SOCIO (id_socio, nombre, apellidos, alta_socio) VALUES ('BBBB', 'LALE', 'LOPEZ', SYSDATE);
INSERT INTO SOCIO (id_socio, nombre, apellidos, alta_socio) VALUES ('CCCC', 'LALI', 'LOPEZ', SYSDATE);
INSERT INTO SOCIO (id_socio, nombre, apellidos, alta_socio) VALUES ('DDDD', 'LALO', 'LOPEZ', SYSDATE);
INSERT INTO SOCIO (id_socio, nombre, apellidos, alta_socio) VALUES ('EEEE', 'LALU', 'LOPEZ', SYSDATE);

DROP TABLE prestamo;
CREATE TABLE prestamo (
    id_prestamo CHAR(8),
    id_socio NUMBER,
    id_edicion CHAR(6),
    numero INTEGER,
    fecha_entrega DATE,
    fecha_devolucion DATE DEFAULT NULL,
    CONSTRAINT PK_prestamo PRIMARY KEY (id_prestamo),
    CONSTRAINT FK_prestamo_socio FOREIGN KEY (id_socio) REFERENCES socio(id_socio),
    CONSTRAINT FK_prestamo_edicion FOREIGN KEY (id_edicion) REFERENCES edicion(id),
    CONSTRAINT NN_prestamo_numero CHECK (numero IS NOT NULL),
    CONSTRAINT NN_prestamo_entrega CHECK (fecha_entrega IS NOT NULL)
);