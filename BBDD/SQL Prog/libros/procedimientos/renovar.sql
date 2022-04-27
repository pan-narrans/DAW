
-- Para poder ejecutar de forma directa el script entero
DROP PROCEDURE IF EXISTS renovar;

DELIMITER $$


/*
  Renueva un préstamo actualizando la fecha de devolución a 
  la fecha actual mas 15 días.
*/

CREATE PROCEDURE renovar (socio INT, libro INT)
BEGIN


DECLARE existePrestamo BOOLEAN;

IF EXISTS 
  SELECT 1 FROM prestamo 
  WHERE socio = socio AND libro = libro;
  LIMIT 1;
SET existePrestamo = TRUE;
ELSE
  SET existePrestamo = FALSE;
END IF;

IF EXISTS existePrestamo THEN
  UPDATE prestamo SET fechaDevolucion = DATE_ADD(CURDATE(), INTERVAL 15 DAY)
  WHERE socio = socio AND libro = libro;
END IF;

END $$


DELIMITER ;

-- PRUEBAS
CALL renovar(1, 'libro1');