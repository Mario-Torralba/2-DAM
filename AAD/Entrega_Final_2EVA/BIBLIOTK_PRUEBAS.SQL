-- 8 --

DECLARE
    salida VARCHAR(100);
BEGIN
    salida:= alta_obra('a',1);
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 9.0 --

DECLARE
    salida VARCHAR(100);
BEGIN
    salida:= borrado_obra('GEMCE');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 10 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= alta_autor('LALO','LOLEZ');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 11 --

DECLARE
    salida VARCHAR(100);
BEGIN
    salida:= borrado_autor('JYP8');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 12 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= vincular('95WO','41NCS');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 13 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= desvincular('IHE1','HTN8U');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 14 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= alta_edicion('IVTMQ','12345678901234567890');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 15 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= borrado_edicion('FN4CA1');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 16,17,18 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= alta_ejemplar('YLVB42');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 19,20,21,22 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= borrado_ejemplar('C6N3HI', 2);
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 23,24,25,26 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= baja_ejemplar('C6N3HI', 2);
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 29 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= apertura_prestamo(1,'YLVB42', 3);
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/

-- 31 --

DECLARE
    salida VARCHAR(250);
BEGIN
    salida:= cierre_prestamo('M4FYN2WK');
    DBMS_OUTPUT.PUT_LINE(salida);
END;
/