INSERT INTO ESTADO (NOMBRE_ESTADO) VALUES
    ('Nuevo con etiquetas'),
    ('Nuevo sin etiquetas'),
    ('Bueno'),
    ('Muy Bueno'),
    ('Satisfactorio');

INSERT INTO USUARIO (NICK, PASS, TLF_USUARIO, NOMBRE_USUARIO, APELLIDO_1_USUARIO, APELLIDO_2_USUARIO, EMAIL_USUARIO) VALUES
    ('Pinchauvas','1234','722100138','Mario','Torralba','Pardos','a26807@svalero.com'),
    ('SolLuna', '5678', '699200247', 'Ana', 'García', 'López', 'ana.garcia@example.com'),
    ('EstrellaFugaz', '9012', '655300356', 'Carlos', 'Fernández', 'Martín', 'carlos.fernandez@example.com'),
    ('ArcoIris', '3456', '611400465', 'Lucía', 'Pérez', 'Ruiz', 'lucia.perez@example.com'),
    ('RayoVeloz', '7890', '677500574', 'Jorge', 'Sánchez', 'Jiménez', 'jorge.sanchez@example.com');

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
    (2, 4, 7, 11, '2022-02-10'),
    (3, 5, 12, 14, '2022-02-15'),
    (4, 1, 17, 3, '2022-02-20'),
    (5, 2, 22, 5, '2022-02-25'),
    (1, 4, 3, 9, '2022-03-02'),
    (2, 5, 8, 12, '2022-03-07'),
    (3, 1, 13, 1, '2022-03-12'),
    (4, 2, 18, 6, '2022-03-17'),
    (5, 3, 23, 7, '2022-03-22'),
    (1, 5, 4, 13, '2022-03-27'),
    (2, 1, 9, 2, '2022-04-01'),
    (3, 2, 14, 8, '2022-04-06'),
    (4, 3, 19, 9, '2022-04-11'),
    (5, 4, 24, 15, '2022-04-16');

