DROP FUNCTION IF EXISTS checkTieneElLibro;

DELIMITER $$

/*
  Recibe la id del socio.
  Devuelve los títulos de los libros prestados a un socio.
*/

CREATE FUNCTION checkTieneElLibro (socio INT, libro VARCHAR(100))
RETURNS BOOLEAN
BEGIN

DECLARE loTiene BOOLEAN;
SET loTiene = FALSE;

IF libro IN (
  SELECT libro.titulo FROM prestamo
	INNER JOIN libro ON libro.libro = prestamo.libro
	WHERE prestamo.fdevolucion > NOW()
    AND prestamo.socio = socio
) THEN
  SET loTiene = TRUE;
END IF;

RETURN  loTiene;
 
END $$

DELIMITER ;

-- PRUEBAS
SELECT checkTieneElLibro(1, "Job");