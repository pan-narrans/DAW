
-- Para poder ejecutar de forma directa el script entero
DROP TRIGGER IF EXISTS insertPrestamo;

DELIMITER $$


/*
  Actualiza la tabla de ejemplares (reservado y disponible) 
  cada vez que se realiza un nuevo prestamo.
*/

CREATE TRIGGER insertPrestamo AFTER INSERT
ON prestamo FOR EACH ROW
BEGIN

IF 
UPDATE ejemplares SET disponible = disponible - 1
WHERE libro = NEW.libro;

END $$


DELIMITER ;

-- PRUEBAS
INSERT INTO prestamo (socio, libro) VALUES (1, 1);
