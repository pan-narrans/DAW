DROP FUNCTION IF EXISTS getNumPrestamos;

DELIMITER $$

/*
  Recibe como entrada la id del socio.
  Devuelve el nº de prestamos activos de un socio.
*/

CREATE FUNCTION getNumPrestamos (socio INT)
RETURNS INT (11)
BEGIN

RETURN(
  SELECT COUNT(*) FROM prestamo
  WHERE prestamo.fdevolucion > NOW()
  AND prestamo.socio = socio
);

END $$

DELIMITER ;

-- PRUEBAS
SELECT socio.socio, getNumPrestamos(socio.socio) 
  AS "Nº Prestamos Activos" FROM socio;