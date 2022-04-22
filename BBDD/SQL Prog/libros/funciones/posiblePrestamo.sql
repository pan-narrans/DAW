
-- Para poder ejecutar de forma directa el script entero
DROP FUNCTION IF EXISTS posiblePrestamo;

DELIMITER $$


/*
  Devuelve TRUE si se puede realizar un préstamo, FALSE en caso contrario.
  Recibe el id del socio y el título del libro.
  Un préstamo es posible si:
    - el socio no tiene más de 3 préstamos activos
    - el socio no tiene ya un ejemplar del libro
    - quedan copias disponibles del libro
*/
CREATE FUNCTION posiblePrestamo (socio INT, libro VARCHAR(100))
RETURNS BOOLEAN
BEGIN

DECLARE canLend BOOLEAN;
SET canLend = TRUE;

IF getNumPrestamos(socio) > 3 THEN
  SET canLend = FALSE;
ELSEIF checkTieneElLibro(socio, libro) THEN
  SET canLend = FALSE;
ELSEIF getNumEjemplares(libro) = 0 THEN
  SET canLend = FALSE;
END IF;

RETURN canLend;

END $$


DELIMITER ;

-- PRUEBAS
SELECT socio.nombre, libro.titulo, 
  posiblePrestamo(socio.socio, libro.libro) AS "Prestamo Posible"
  FROM socio, libro
  GROUP BY 1, 2