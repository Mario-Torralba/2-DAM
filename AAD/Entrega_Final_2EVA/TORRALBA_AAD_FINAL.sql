DROP TABLE EJEMPLAR_HISTORICO;
DROP TABLE EDICION_HISTORICO;
DROP TABLE AUTOR_HISTORICO;
DROP TABLE OBRA_HISTORICO;
DROP TABLE ejemplar;
DROP TABLE edicion;
DROP TABLE autor_obra;
DROP TABLE autor;
DROP TABLE obra;


CREATE TABLE obra (
id CHAR(5),
titulo VARCHAR(100),
anyo INTEGER,
CONSTRAINT PK_obra PRIMARY KEY (id),
CONSTRAINT NN_titulo CHECK (titulo IS NOT NULL)
);

CREATE TABLE autor (
id CHAR(4),
nombre VARCHAR(30),
apellidos VARCHAR(60),
nacimiento DATE,
CONSTRAINT PK_autor PRIMARY KEY (id),
CONSTRAINT NN_nombre CHECK (nombre IS NOT NULL),
CONSTRAINT NN_apellidos CHECK (apellidos IS NOT NULL)
);

CREATE TABLE autor_obra (
id_autor CHAR(4),
id_obra CHAR(5),
CONSTRAINT PK_autor_obra PRIMARY KEY (id_autor, id_obra),
CONSTRAINT FK_autor_obra_id_autor FOREIGN KEY (id_autor) REFERENCES
autor(id),
CONSTRAINT FK_autor_obra_id_obra FOREIGN KEY (id_obra)
REFERENCES obra(id)
);

CREATE TABLE edicion (
id CHAR(6),
id_obra CHAR(5),
isbn VARCHAR(20),
anyo INTEGER,
CONSTRAINT PK_edicion PRIMARY KEY (id),
CONSTRAINT NN_id_obra CHECK (id_obra IS NOT NULL),
CONSTRAINT NN_isbn CHECK (isbn IS NOT NULL),
CONSTRAINT FK_edicion FOREIGN KEY (id_obra) REFERENCES
obra(id)
);

CREATE TABLE ejemplar (
id_edicion CHAR(6),
numero INTEGER,
alta DATE,
baja DATE,
CONSTRAINT PK_ejemplar PRIMARY KEY (id_edicion, numero),
CONSTRAINT FK_ejemplar FOREIGN KEY (id_edicion) REFERENCES
edicion(id),
CONSTRAINT NN_alta CHECK (alta IS NOT NULL)
);

CREATE TABLE OBRA_HISTORICO (
    ID_OBRA_HISTORICO VARCHAR(5),
    TITULO VARCHAR(100),
    ANYO INTEGER,
    FECHA_BORRADO TIMESTAMP
);

CREATE TABLE AUTOR_HISTORICO (
    ID_AUTOR_HISTORICO VARCHAR(5),
    NOMBRE VARCHAR(30),
    APELLIDOS VARCHAR(60),
    NACIMIENTO DATE,
    FECHA_BORRADO TIMESTAMP
);

CREATE TABLE EDICION_HISTORICO (
    ID_EDICION_HISTORICO CHAR(6),
    ID_OBRA_HISTORICO CHAR(5),
    ISBN VARCHAR(20),
    ANYO INTEGER,
    FECHA_BORRADO TIMESTAMP
);

CREATE TABLE EJEMPLAR_HISTORICO (
    ID_EDICION_HISTORICO CHAR(6),
    NUMERO INTEGER,
    ALTA DATE,
    BAJA DATE,
    FECHA_BORRADO TIMESTAMP
);



-- 8 --


CREATE OR REPLACE FUNCTION alta_obra(p_titulo VARCHAR, p_anyo INTEGER DEFAULT
NULL)

RETURN VARCHAR IS
    same_name_exception EXCEPTION;
    id5 CHAR(5);
    v_obra obra%ROWTYPE;
    CURSOR v_cursor_titulo IS
        SELECT * FROM obra
        WHERE titulo = p_titulo
        AND anyo = p_anyo;
BEGIN

    OPEN v_cursor_titulo;
    FETCH v_cursor_titulo INTO v_obra;
    WHILE v_cursor_titulo %FOUND LOOP
        RAISE same_name_exception;
    END LOOP;

    id5:= dbms_random.string('X', 5);
    INSERT INTO obra (id, titulo, anyo) VALUES (id5, p_titulo, p_anyo);
    RETURN id5;

EXCEPTION

    WHEN same_name_exception THEN
        RETURN '-1';

END;
/

-- DECLARE
--     salida VARCHAR(100);
-- BEGIN
--     salida:= alta_obra('a',1);
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 9.0 --


CREATE OR REPLACE FUNCTION borrado_obra(P_ID VARCHAR) 
RETURN INTEGER IS

    NO_EXISTE EXCEPTION;
    CURSOR V_CURSOR_OBRA IS
        SELECT * FROM obra
        WHERE ID = P_ID;
    V_OBRA OBRA%ROWTYPE;
    contador INTEGER;

BEGIN
    CONTADOR:= 0;
    OPEN V_CURSOR_OBRA;
    FETCH V_CURSOR_OBRA INTO V_OBRA;
    WHILE V_CURSOR_OBRA %FOUND LOOP
        contador := contador + 1;
        FETCH V_CURSOR_OBRA INTO V_OBRA;
    END LOOP;

    IF contador = 0 THEN
        RAISE NO_EXISTE;
    ELSE
        DELETE FROM obra WHERE ID = P_ID;
        RETURN 1;
    END IF;

EXCEPTION

    WHEN NO_EXISTE THEN
        RETURN 0;
    WHEN OTHERS THEN
        RETURN -1;

END;
/

-- DECLARE
--     salida VARCHAR(100);
-- BEGIN
--     salida:= borrado_obra('GEMCE');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 9.1 --

CREATE OR REPLACE TRIGGER auditar_borrado_obra BEFORE DELETE ON OBRA
    FOR EACH ROW
BEGIN
    INSERT INTO OBRA_HISTORICO (ID_OBRA_HISTORICO, TITULO, ANYO, FECHA_BORRADO)
    VALUES(:OLD.ID, :OLD.TITULO, :OLD.ANYO, CURRENT_TIMESTAMP);
END;
/

-- 10 --


CREATE OR REPLACE FUNCTION alta_autor(P_NOMBRE VARCHAR, P_APELLIDOS VARCHAR, P_NACIMIENTO DATE DEFAULT NULL)
RETURN VARCHAR IS

    id5 CHAR(4);

BEGIN

    id5:= dbms_random.string('X', 4);
    INSERT INTO autor (id, nombre, apellidos, nacimiento) VALUES (id5, P_NOMBRE, P_APELLIDOS, P_NACIMIENTO);
    RETURN id5;

EXCEPTION

    WHEN OTHERS THEN
        RETURN '-1';

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= alta_autor('LALO','LOLEZ');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 11 --


CREATE OR REPLACE FUNCTION borrado_autor(P_ID VARCHAR) 
RETURN INTEGER IS
    NO_EXISTE EXCEPTION;
    CURSOR V_CURSOR_AUTOR IS
        SELECT * FROM autor
        WHERE ID = P_ID;
    V_AUTOR AUTOR%ROWTYPE;
    contador INTEGER;
BEGIN
    CONTADOR := 0;
    OPEN V_CURSOR_AUTOR;
    FETCH V_CURSOR_AUTOR INTO V_AUTOR;
    WHILE V_CURSOR_AUTOR %FOUND LOOP
        CONTADOR := CONTADOR + 1;
        FETCH V_CURSOR_AUTOR INTO V_AUTOR;
    END LOOP;

    IF CONTADOR = 0 THEN
        RAISE NO_EXISTE;
    ELSE
        DELETE FROM autor WHERE ID = P_ID;
        RETURN 1;
    END IF;

EXCEPTION
    WHEN NO_EXISTE THEN
        RETURN 0;
    WHEN OTHERS THEN
        RETURN -1;
END;
/

-- DECLARE
--     salida VARCHAR(100);
-- BEGIN
--     salida:= borrado_autor('JYP8');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 12 --


CREATE OR REPLACE FUNCTION vincular(p_id_autor VARCHAR, p_id_obra VARCHAR) 
RETURN INTEGER IS

    v_autor_existente INTEGER := 0;
    v_obra_existente INTEGER := 0;

BEGIN

    SELECT COUNT(*) INTO v_autor_existente FROM autor WHERE id = p_id_autor;
    SELECT COUNT(*) INTO v_obra_existente FROM obra WHERE id = p_id_obra;
    
    IF v_autor_existente = 1 AND v_obra_existente = 1 THEN
        INSERT INTO autor_obra (id_autor, id_obra) VALUES (p_id_autor, p_id_obra);
        RETURN 1; 
    ELSE
        RETURN -1; 
    END IF;

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= vincular('95WO','41NCS');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 13 --


CREATE OR REPLACE FUNCTION desvincular(p_id_autor VARCHAR, p_id_obra VARCHAR) 
RETURN INTEGER IS

    v_vinculo_existente INTEGER := 0;

BEGIN

    SELECT COUNT(*) INTO v_vinculo_existente 
    FROM autor_obra 
    WHERE id_autor = p_id_autor 
    AND id_obra = p_id_obra;

    IF v_vinculo_existente = 1 THEN
        DELETE FROM autor_obra 
        WHERE id_autor = p_id_autor 
        AND id_obra = p_id_obra;
        RETURN 1; 
    ELSIF v_vinculo_existente = 0 THEN
        RETURN 0; 
    ELSE
        RETURN -1; 
    END IF;

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= desvincular('IHE1','HTN8U');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 14 --


CREATE OR REPLACE FUNCTION alta_edicion(p_id_obra VARCHAR, p_isbn VARCHAR, p_año INTEGER DEFAULT NULL) 
RETURN VARCHAR IS

    v_id_edicion VARCHAR(6);

BEGIN

    v_id_edicion := dbms_random.string('X', 6);
    INSERT INTO edicion (id, id_obra, isbn, anyo) VALUES (v_id_edicion, p_id_obra, p_isbn, p_año);
    RETURN v_id_edicion; 

EXCEPTION

    WHEN OTHERS THEN
        RETURN '-1'; 

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= alta_edicion('IVTMQ','12345678901234567890');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 15 --


CREATE OR REPLACE FUNCTION borrado_edicion(p_id VARCHAR) 
RETURN INTEGER IS

    v_existe INTEGER := 0;

BEGIN

    SELECT COUNT(*) INTO v_existe FROM edicion WHERE id = p_id;
    
    IF v_existe = 1 THEN
        DELETE FROM edicion WHERE id = p_id;
        RETURN 1; 
    ELSE
        RETURN 0; 
    END IF;

EXCEPTION

    WHEN OTHERS THEN
        RETURN -1; 

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= borrado_edicion('FN4CA1');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 16,17,18 --


CREATE OR REPLACE FUNCTION alta_ejemplar(p_id_edicion VARCHAR) 
RETURN INTEGER IS

    v_numero_ejemplar INTEGER;

BEGIN

    SELECT COUNT(*) INTO v_numero_ejemplar FROM edicion WHERE id = p_id_edicion;
    
    IF v_numero_ejemplar = 1 THEN
        SELECT COALESCE(MAX(numero), 0) + 1 INTO v_numero_ejemplar FROM ejemplar WHERE id_edicion = p_id_edicion;
        INSERT INTO ejemplar (id_edicion, numero, alta) VALUES (p_id_edicion, v_numero_ejemplar, CURRENT_DATE);
        RETURN v_numero_ejemplar; 
    ELSE
        RETURN -1; 
    END IF;

EXCEPTION

    WHEN OTHERS THEN
        RETURN -1; 

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= alta_ejemplar('YLVB42');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 19,20,21,22 --


CREATE OR REPLACE FUNCTION borrado_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) 
RETURN INTEGER IS

    CURSOR V_CURSOR_EXISTENCIA IS
        SELECT * FROM EJEMPLAR WHERE id_edicion = p_id_edicion
        AND numero = p_numero;
    CURSOR V_CURSOR_NUMERO_MAXIMO IS
        SELECT * FROM EJEMPLAR WHERE id_edicion = p_id_edicion;
    V_EJEMPLAR EJEMPLAR%ROWTYPE;
    V_CONTADOR INTEGER := 0;
    V_BAJA DATE;
    V_ALTA DATE;
    V_DIAS_TRANSURRIDOS INTEGER;

BEGIN

    OPEN V_CURSOR_EXISTENCIA;
    FETCH V_CURSOR_EXISTENCIA INTO V_EJEMPLAR;
    WHILE V_CURSOR_EXISTENCIA %FOUND LOOP
        V_CONTADOR := V_CONTADOR + 1;
        FETCH V_CURSOR_EXISTENCIA INTO V_EJEMPLAR;
    END LOOP;

    IF V_CONTADOR = 0 THEN
        RETURN 0;
    END IF;

    V_CONTADOR := 0;
    OPEN V_CURSOR_NUMERO_MAXIMO;
    FETCH V_CURSOR_NUMERO_MAXIMO INTO V_EJEMPLAR;
    WHILE V_CURSOR_NUMERO_MAXIMO %FOUND LOOP
        V_CONTADOR := V_CONTADOR + 1;
        FETCH V_CURSOR_NUMERO_MAXIMO INTO V_EJEMPLAR;
    END LOOP;

    IF V_CONTADOR = p_numero THEN

        SELECT baja INTO V_BAJA FROM EJEMPLAR WHERE id_edicion = p_id_edicion AND numero = p_numero;
        IF V_BAJA IS null THEN

            SELECT alta INTO V_ALTA FROM ejemplar WHERE id_edicion = p_id_edicion AND numero = p_numero;
            V_DIAS_TRANSURRIDOS := TRUNC(SYSDATE) - TRUNC(V_ALTA);
            IF V_DIAS_TRANSURRIDOS <= 30 THEN

                DELETE FROM ejemplar WHERE  id_edicion = p_id_edicion AND numero = p_numero;
                RETURN 1; 

            ELSE
                RETURN -1; 
            END IF;

        ELSE
            RETURN -1;
        END IF;

    ELSE
        RETURN -1;  
    END IF;

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= borrado_ejemplar('C6N3HI', 2);
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 23,24,25,26 --


CREATE OR REPLACE FUNCTION baja_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) 
RETURN INTEGER IS

    CURSOR V_CURSOR_EXISTENCIA IS
        SELECT * FROM EJEMPLAR WHERE id_edicion = p_id_edicion
        AND numero = p_numero;
    V_EJEMPLAR EJEMPLAR%ROWTYPE;
    V_CONTADOR INTEGER := 0;
    V_BAJA DATE;
BEGIN

    OPEN V_CURSOR_EXISTENCIA;
    FETCH V_CURSOR_EXISTENCIA INTO V_EJEMPLAR;
    WHILE V_CURSOR_EXISTENCIA %FOUND LOOP
        V_CONTADOR := V_CONTADOR + 1;
        FETCH V_CURSOR_EXISTENCIA INTO V_EJEMPLAR;
    END LOOP;

    IF V_CONTADOR = 0 THEN
        RETURN 0;
    END IF;

    SELECT baja INTO V_BAJA FROM EJEMPLAR WHERE id_edicion = p_id_edicion AND numero = p_numero;

    IF V_BAJA IS NULL THEN
        UPDATE EJEMPLAR SET baja = SYSDATE WHERE id_edicion = p_id_edicion AND numero = p_numero;
        RETURN 1;
    ELSE
        RETURN -1;
    END IF;

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= baja_ejemplar('C6N3HI', 2);
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 27 --

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


-- 28 --

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

INSERT INTO PRESTAMO (id_prestamo, id_socio, id_edicion, numero, fecha_entrega) VALUES (1, 1, 'YLVB42', 1, SYSDATE);
INSERT INTO PRESTAMO (id_prestamo, id_socio, id_edicion, numero, fecha_entrega) VALUES (1, 2, 'YLVB42', 2, SYSDATE);
INSERT INTO PRESTAMO (id_prestamo, id_socio, id_edicion, numero, fecha_entrega) VALUES (1, 3, 'YLVB42', 3, SYSDATE);
INSERT INTO PRESTAMO (id_prestamo, id_socio, id_edicion, numero, fecha_entrega) VALUES (1, 4, 'YLVB42', 4, SYSDATE);
INSERT INTO PRESTAMO (id_prestamo, id_socio, id_edicion, numero, fecha_entrega) VALUES (1, 5, 'YLVB42', 5, SYSDATE);

-- 29 --

-- EXISTE LA EDICION, EL NUMERO Y NO HAY NINGUN PRESTAMO CON FECHA DE DEVOLUCION EN NULL DE ESTE = 1 --
-- NO EXISTE EL EJEMPLAR = 0 --
-- EL EJEMPLAR ESTA EN MANOS DE OTRO SOCIO = -1 --
-- CUALQUIER OTRO ERROR = -2 --

CREATE OR REPLACE FUNCTION apertura_prestamo (p_id_socio INTEGER, p_id_edicion VARCHAR, p_numero INTEGER)
RETURN INTEGER IS

    CURSOR V_CURSOR_EXISTE IS
        SELECT * FROM EJEMPLAR WHERE id_edicion = p_id_edicion AND numero = p_numero;
    CURSOR V_CURSOR_OTRAS_MANOS IS
        SELECT * FROM PRESTAMO WHERE id_edicion = p_id_edicion AND numero = p_numero AND fecha_devolucion IS NULL;

    id8 VARCHAR(8);
    V_CONTADOR INTEGER := 0;
    V_EJEMPLAR ejemplar%ROWTYPE;
    V_PRESTAMO prestamo%ROWTYPE;
    NO_EJEMPLAR EXCEPTION;
    OTRAS_MANOS EXCEPTION;

BEGIN

    OPEN V_CURSOR_EXISTE;
    FETCH V_CURSOR_EXISTE INTO V_EJEMPLAR;
    WHILE V_CURSOR_EXISTE %FOUND LOOP
        V_CONTADOR := V_CONTADOR + 1;
        FETCH V_CURSOR_EXISTE INTO V_EJEMPLAR;
    END LOOP;

    IF V_CONTADOR = 0 THEN
        RAISE NO_EJEMPLAR;
    END IF;

    V_CONTADOR := 0;
    OPEN V_CURSOR_OTRAS_MANOS;
    FETCH V_CURSOR_OTRAS_MANOS INTO V_PRESTAMO;
    WHILE V_CURSOR_OTRAS_MANOS %FOUND LOOP
        V_CONTADOR := V_CONTADOR + 1;
        FETCH V_CURSOR_OTRAS_MANOS INTO V_PRESTAMO;
    END LOOP;

    IF V_CONTADOR = 1 THEN
        RAISE OTRAS_MANOS;
    END IF;


    id8:= dbms_random.string('X', 8);
    INSERT INTO PRESTAMO (id_prestamo, id_socio, id_edicion, numero, fecha_entrega) VALUES (id8, p_id_socio, p_id_edicion, p_numero, SYSDATE);
    RETURN 1;

EXCEPTION

    WHEN NO_EJEMPLAR THEN
        RETURN 0;
    WHEN OTRAS_MANOS THEN
        RETURN -1;
    WHEN OTHERS THEN
        RETURN -2;

END;
/

-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= apertura_prestamo(1,'YLVB42', 3);
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /


-- 30 --


CREATE OR REPLACE TRIGGER auditar_borrado_autor BEFORE DELETE ON AUTOR
    FOR EACH ROW
BEGIN
    INSERT INTO AUTOR_HISTORICO (ID_AUTOR_HISTORICO, NOMBRE, APELLIDOS, NACIMIENTO, FECHA_BORRADO)
    VALUES(:OLD.ID, :OLD.NOMBRE, :OLD.APELLIDOS, :OLD.NACIMIENTO, CURRENT_TIMESTAMP);
END;
/

CREATE OR REPLACE TRIGGER auditar_borrado_edicion BEFORE DELETE ON EDICION
    FOR EACH ROW
BEGIN
    INSERT INTO EDICION_HISTORICO (ID_EDICION_HISTORICO, ID_OBRA_HISTORICO, ISBN, ANYO, FECHA_BORRADO)
    VALUES(:OLD.id, :OLD.id_obra, :OLD.isbn, :OLD.anyo, CURRENT_TIMESTAMP);
END;
/

CREATE OR REPLACE TRIGGER auditar_borrado_ejemplar BEFORE DELETE ON EJEMPLAR
    FOR EACH ROW
BEGIN
    INSERT INTO EJEMPLAR_HISTORICO (ID_EDICION_HISTORICO, NUMERO, ALTA, BAJA, FECHA_BORRADO)
    VALUES(:OLD.id_edicion, :OLD.numero, :OLD.alta, :OLD.baja, CURRENT_TIMESTAMP);
END;
/


-- 31 --

-- CERRAR EL PRESTAMO CON EXITO --> 1 --
-- NO EXISTE ESE ID_PRESTAMO --> 0 --
-- EL PRESTAMO YA ESTA CERRADO --> -1 --
-- CUALQUIER OTRO ERROR --> -2 -- 

CREATE OR REPLACE FUNCTION cierre_prestamo (p_id_prestamo VARCHAR)
RETURN INTEGER IS

    CURSOR V_CURSOR_EXISTE IS
        SELECT * FROM PRESTAMO WHERE id_prestamo = p_id_prestamo;
    CURSOR V_CURSOR_CERRADO_ALREADY IS
        SELECT * FROM PRESTAMO WHERE id_prestamo = p_id_prestamo AND fecha_devolucion IS NOT NULL;

    V_CONTADOR INTEGER := 0;
    V_PRESTAMO prestamo%ROWTYPE;
    NO_EXISTE EXCEPTION;
    CERRADO_ALREADY EXCEPTION;

BEGIN

    OPEN V_CURSOR_EXISTE;
    FETCH V_CURSOR_EXISTE INTO V_PRESTAMO;
    WHILE V_CURSOR_EXISTE %FOUND LOOP
        V_CONTADOR := V_CONTADOR + 1;
        FETCH V_CURSOR_EXISTE INTO V_PRESTAMO;
    END LOOP;

    IF V_CONTADOR = 0 THEN
        RAISE NO_EXISTE;
    END IF;

    V_CONTADOR := 0;
    OPEN V_CURSOR_CERRADO_ALREADY;
    FETCH V_CURSOR_CERRADO_ALREADY INTO V_PRESTAMO;
    WHILE V_CURSOR_CERRADO_ALREADY %FOUND LOOP
        V_CONTADOR := V_CONTADOR + 1;
        FETCH V_CURSOR_CERRADO_ALREADY INTO V_PRESTAMO;
    END LOOP;

    IF V_CONTADOR = 1 THEN
        RAISE CERRADO_ALREADY;
    END IF;

    UPDATE PRESTAMO SET fecha_devolucion = CURRENT_TIMESTAMP WHERE id_prestamo = p_id_prestamo;
    RETURN 1;

EXCEPTION

    WHEN NO_EXISTE THEN
        RETURN 0;
    WHEN CERRADO_ALREADY THEN
        RETURN -1;
    WHEN OTHERS THEN
        RETURN -2;

END;
/


-- DECLARE
--     salida VARCHAR(250);
-- BEGIN
--     salida:= cierre_prestamo('M4FYN2WK');
--     DBMS_OUTPUT.PUT_LINE(salida);
-- END;
-- /