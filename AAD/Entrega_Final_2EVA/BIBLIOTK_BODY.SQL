CREATE OR REPLACE PACKAGE BODY BiblioTK AS

    FUNCTION alta_obra(p_titulo VARCHAR, p_anyo INTEGER DEFAULT
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
    

    FUNCTION borrado_obra(P_ID VARCHAR) 
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
    

    FUNCTION alta_autor(P_NOMBRE VARCHAR, P_APELLIDOS VARCHAR, P_NACIMIENTO DATE DEFAULT NULL)
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
    

    FUNCTION borrado_autor(P_ID VARCHAR) 
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
    

    FUNCTION vincular(p_id_autor VARCHAR, p_id_obra VARCHAR) 
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
    

    FUNCTION desvincular(p_id_autor VARCHAR, p_id_obra VARCHAR) 
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
    

    FUNCTION alta_edicion(p_id_obra VARCHAR, p_isbn VARCHAR, p_año INTEGER DEFAULT NULL) 
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
    

    FUNCTION borrado_edicion(p_id VARCHAR) 
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
    

    FUNCTION alta_ejemplar(p_id_edicion VARCHAR) 
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
    

    FUNCTION borrado_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) 
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
    

    FUNCTION baja_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) 
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

    -- EXISTE LA EDICION, EL NUMERO Y NO HAY NINGUN PRESTAMO CON FECHA DE DEVOLUCION EN NULL DE ESTE = 1 --
    -- NO EXISTE EL EJEMPLAR = 0 --
    -- EL EJEMPLAR ESTA EN MANOS DE OTRO SOCIO = -1 --
    -- CUALQUIER OTRO ERROR = -2 --
    FUNCTION apertura_prestamo (p_id_socio INTEGER, p_id_edicion VARCHAR, p_numero INTEGER)
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

    -- CERRAR EL PRESTAMO CON EXITO --> 1 --
    -- NO EXISTE ESE ID_PRESTAMO --> 0 --
    -- EL PRESTAMO YA ESTA CERRADO --> -1 --
    -- CUALQUIER OTRO ERROR --> -2 -- 

    FUNCTION cierre_prestamo (p_id_prestamo VARCHAR)
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


    

END;
/



CREATE OR REPLACE TRIGGER auditar_borrado_obra BEFORE DELETE ON OBRA
    FOR EACH ROW
BEGIN
    INSERT INTO OBRA_HISTORICO (ID_OBRA_HISTORICO, TITULO, ANYO, FECHA_BORRADO)
    VALUES(:OLD.ID, :OLD.TITULO, :OLD.ANYO, CURRENT_TIMESTAMP);
END;
/

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