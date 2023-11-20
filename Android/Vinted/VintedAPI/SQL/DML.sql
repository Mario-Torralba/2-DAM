INSERT INTO ESTADO (NOMBRE_ESTADO) VALUES
    ('Nuevo con etiquetas'),
    ('Nuevo sin etiquetas'),
    ('Bueno'),
    ('Muy Bueno'),
    ('Satisfactorio');

INSERT INTO CATEGORIA (NOMBRE_CATEGORIA) VALUES
    ('Hombre'),
    ('Mujer'),
    ('Niño'),
    ('Niña'),
    ('Invierno'),
    ('Verano'),
    ('Ropa'),
    ('Calzado');

INSERT INTO COLOR (NOMBRE_COLOR) VALUES
    ('Negro'),
    ('Blanco'),
    ('Azul'),
    ('Rojo'),
    ('Verde'),
    ('Amarillo'),
    ('Naranja'),
    ('Morado');

INSERT INTO USUARIO (NICK, PASS, TLF_USUARIO, NOMBRE_USUARIO, APELLIDO_1_USUARIO, APELLIDO_2_USUARIO, EMAIL_USUARIO) VALUES
    ('Pinchauvas','1234','722100138','Mario','Torralba','Pardos','a26807@svalero.com'),
    ('SolLuna', '5678', '699200247', 'Ana', 'García', 'López', 'ana.garcia@example.com'),
    ('EstrellaFugaz', '9012', '655300356', 'Carlos', 'Fernández', 'Martín', 'carlos.fernandez@example.com'),
    ('ArcoIris', '3456', '611400465', 'Lucía', 'Pérez', 'Ruiz', 'lucia.perez@example.com'),
    ('RayoVeloz', '7890', '677500574', 'Jorge', 'Sánchez', 'Jiménez', 'jorge.sanchez@example.com');
INSERT INTO VALORACION (ID_USUARIO, ESTRELLAS, COMENTARIO) VALUES
    (1,5,' '),
    (1,4,' '),
    (1,5,' '),
    (1,5,' '),
    (1,5,' '),
    (2,4,' '),
    (2,3,' '),
    (3,2,' '),
    (3,1,' '),
    (3,3,' '),
    (4,4,' '),
    (4,1,' '),
    (4,2,' '),
    (4,2,' '),
    (5,1,' '),
    (5,1,' '),
    (5,5,' '),
    (5,3,' ');
-- ID_USUARIO 1: Rojo
INSERT INTO PRODUCTO (ID_USUARIO, ID_ESTADO, NOMBRE_PRODUCTO, DESCRIPCION_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, IMAGEN_PRODUCTO) VALUES
    (1, 1, 'Camiseta roja', 'Preciosa camiseta roja', 'ADIDAS', 10, 'camisetaRoja.jpg'),
    (1, 1, 'Pantalones rojos', 'Preciosos pantalones rojos', 'NIKE', 40, 'pantalonesRojos.jpg'),
    (1, 1, 'Sudadera roja', 'Preciosa sudadera roja', 'UNDER ARMOUR', 30, 'sudaderaRoja.jpg'),
    (1, 1, 'Calcetines rojos', 'Preciosos calcetines rojos', 'DOMYOS', 5, 'calcetinesRojos.jpg'),
    (1, 1, 'Zapatillas rojas', 'Preciosas zapatillas rojas', 'REEBOK', 60, 'zapatillasRojas.jpg');

-- ID_USUARIO 2: Azul
INSERT INTO PRODUCTO (ID_USUARIO, ID_ESTADO, NOMBRE_PRODUCTO, DESCRIPCION_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, IMAGEN_PRODUCTO) VALUES
    (2, 1, 'Camiseta azul', 'Preciosa camiseta azul', 'ADIDAS', 10, 'camisetaAzul.jpg'),
    (2, 1, 'Pantalones azules', 'Preciosos pantalones azules', 'NIKE', 40, 'pantalonesAzules.jpg'),
    (2, 1, 'Sudadera azul', 'Preciosa sudadera azul', 'UNDER ARMOUR', 30, 'sudaderaAzul.jpg'),
    (2, 1, 'Calcetines azules', 'Preciosos calcetines azules', 'DOMYOS', 5, 'calcetinesAzules.jpg'),
    (2, 1, 'Zapatillas azules', 'Preciosas zapatillas azules', 'REEBOK', 60, 'zapatillasAzules.jpg');

-- ID_USUARIO 3: Verde
INSERT INTO PRODUCTO (ID_USUARIO, ID_ESTADO, NOMBRE_PRODUCTO, DESCRIPCION_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, IMAGEN_PRODUCTO) VALUES
    (3, 1, 'Camiseta verde', 'Preciosa camiseta verde', 'ADIDAS', 10, 'camisetaVerde.jpg'),
    (3, 1, 'Pantalones verdes', 'Preciosos pantalones verdes', 'NIKE', 40, 'pantalonesVerdes.jpg'),
    (3, 1, 'Sudadera verde', 'Preciosa sudadera verde', 'UNDER ARMOUR', 30, 'sudaderaVerde.jpg'),
    (3, 1, 'Calcetines verdes', 'Preciosos calcetines verdes', 'DOMYOS', 5, 'calcetinesVerdes.jpg'),
    (3, 1, 'Zapatillas verdes', 'Preciosas zapatillas verdes', 'REEBOK', 60, 'zapatillasVerdes.jpg');

-- ID_USUARIO 4: Amarillo
INSERT INTO PRODUCTO (ID_USUARIO, ID_ESTADO, NOMBRE_PRODUCTO, DESCRIPCION_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, IMAGEN_PRODUCTO) VALUES
    (4, 1, 'Camiseta amarilla', 'Preciosa camiseta amarilla', 'ADIDAS', 10, 'camisetaAmarilla.jpg'),
    (4, 1, 'Pantalones amarillos', 'Preciosos pantalones amarillos', 'NIKE', 40, 'pantalonesAmarillos.jpg'),
    (4, 1, 'Sudadera amarilla', 'Preciosa sudadera amarilla', 'UNDER ARMOUR', 30, 'sudaderaAmarilla.jpg'),
    (4, 1, 'Calcetines amarillos', 'Preciosos calcetines amarillos', 'DOMYOS', 5, 'calcetinesAmarillos.jpg'),
    (4, 1, 'Zapatillas amarillas', 'Preciosas zapatillas amarillas', 'REEBOK', 60, 'zapatillasAmarillas.jpg');

-- ID_USUARIO 5: Negro
INSERT INTO PRODUCTO (ID_USUARIO, ID_ESTADO, NOMBRE_PRODUCTO, DESCRIPCION_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, IMAGEN_PRODUCTO) VALUES
    (5, 1, 'Camiseta negra', 'Preciosa camiseta negra', 'ADIDAS', 10, 'camisetaNegra.jpg'),
    (5, 1, 'Pantalones negros', 'Preciosos pantalones negros', 'NIKE', 40, 'pantalonesNegros.jpg'),
    (5, 1, 'Sudadera negra', 'Preciosa sudadera negra', 'UNDER ARMOUR', 30, 'sudaderaNegra.jpg'),
    (5, 1, 'Calcetines negros', 'Preciosos calcetines negros', 'DOMYOS', 5, 'calcetinesNegros.jpg'),
    (5, 1, 'Zapatillas negras', 'Preciosas zapatillas negras', 'REEBOK', 60, 'zapatillasNegras.jpg');


-- Direcciones para el Usuario 1
INSERT INTO DIRECCION_CLIENTE (ID_USUARIO, PAIS, PROVINCIA, CIUDAD, CP, DIRECCION) VALUES
    (1, 'España', 'Zaragoza', 'Zaragoza', 50001, 'Calle Falsa 123'),
    (1, 'España', 'Zaragoza', 'Zaragoza', 50002, 'Avenida de la Independencia 456'),
    (1, 'España', 'Zaragoza', 'Zaragoza', 50003, 'Paseo de la Constitución 789');

-- Direcciones para el Usuario 2
INSERT INTO DIRECCION_CLIENTE (ID_USUARIO, PAIS, PROVINCIA, CIUDAD, CP, DIRECCION) VALUES
    (2, 'España', 'Madrid', 'Madrid', 28001, 'Gran Vía 101'),
    (2, 'España', 'Madrid', 'Madrid', 28002, 'Calle Mayor 202'),
    (2, 'España', 'Madrid', 'Madrid', 28003, 'Paseo del Prado 303');

-- Direcciones para el Usuario 3
INSERT INTO DIRECCION_CLIENTE (ID_USUARIO, PAIS, PROVINCIA, CIUDAD, CP, DIRECCION) VALUES
    (3, 'España', 'Barcelona', 'Barcelona', 08001, 'Las Ramblas 111'),
    (3, 'España', 'Barcelona', 'Barcelona', 08002, 'Paseo de Gracia 222'),
    (3, 'España', 'Barcelona', 'Barcelona', 08003, 'Avenida Diagonal 333');

-- Direcciones para el Usuario 4
INSERT INTO DIRECCION_CLIENTE (ID_USUARIO, PAIS, PROVINCIA, CIUDAD, CP, DIRECCION) VALUES
    (4, 'España', 'Valencia', 'Valencia', 46001, 'Calle Colón 123'),
    (4, 'España', 'Valencia', 'Valencia', 46002, 'Avenida del Cid 456'),
    (4, 'España', 'Valencia', 'Valencia', 46003, 'Paseo de la Alameda 789');

-- Direcciones para el Usuario 5
INSERT INTO DIRECCION_CLIENTE (ID_USUARIO, PAIS, PROVINCIA, CIUDAD, CP, DIRECCION) VALUES
    (5, 'España', 'Sevilla', 'Sevilla', 41001, 'Calle Betis 101'),
    (5, 'España', 'Sevilla', 'Sevilla', 41002, 'Avenida de la Constitución 202'),
    (5, 'España', 'Sevilla', 'Sevilla', 41003, 'Paseo de Cristóbal Colón 303');


INSERT INTO VENTA (ID_USUARIO_VENDEDOR, ID_USUARIO_COMPRADOR, ID_PRODUCTO, ID_DIRECCION_CLIENTE, FECHA_VENTA) VALUES
    (1, 2, 1, 4, '2022-01-10'),
    (2, 3, 6, 7, '2022-01-15'),
    (3, 4, 11, 10, '2022-01-20'),
    (4, 5, 16, 13, '2022-01-25'),
    (5, 1, 21, 2, '2022-02-01'),
    (1, 3, 2, 8, '2022-02-05'),
    (5, 4, 24, 15, '2022-04-16');

INSERT INTO PRODUCTO_CATEGORIA (ID_PRODUCTO, ID_CATEGORIA) VALUES
    (1, 2), (1, 5),
    (2, 3), (2, 6),
    (3, 1), (3, 4),
    (4, 7), (4, 8),
    (5, 2), (5, 3),
    (6, 5), (6, 1),
    (7, 4), (7, 6),
    (8, 8), (8, 7),
    (9, 2), (9, 5),
    (10, 3), (10, 6),
    (11, 1), (11, 4),
    (12, 7), (12, 8),
    (13, 2), (13, 3),
    (14, 5), (14, 1),
    (15, 4), (15, 6),
    (16, 8), (16, 7),
    (17, 2), (17, 5),
    (18, 3), (18, 6),
    (19, 1), (19, 4),
    (20, 7), (20, 8),
    (21, 2), (21, 3),
    (22, 5), (22, 1),
    (23, 4), (23, 6),
    (24, 8), (24, 7);

INSERT INTO PRODUCTO_COLOR (ID_PRODUCTO, ID_COLOR) VALUES
    (1, 2), (1, 5),
    (2, 3), (2, 6),
    (3, 1), (3, 4),
    (4, 7), (4, 8),
    (5, 2), (5, 3),
    (6, 5), (6, 1),
    (7, 4), (7, 6),
    (8, 8), (8, 7),
    (9, 2), (9, 5),
    (10, 3), (10, 6),
    (11, 1), (11, 4),
    (12, 7), (12, 8),
    (13, 2), (13, 3),
    (14, 5), (14, 1),
    (15, 4), (15, 6),
    (16, 8), (16, 7),
    (17, 2), (17, 5),
    (18, 3), (18, 6),
    (19, 1), (19, 4),
    (20, 7), (20, 8),
    (21, 2), (21, 3),
    (22, 5), (22, 1),
    (23, 4), (23, 6),
    (24, 8), (24, 7);


