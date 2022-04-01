DROP FUNCTION IF EXISTS getNumDisponible;

DELIMITER $$

/*
  Recibe como entrada el título del libro.
  Devuelve el nº de ejemplares disponibles del libro.
    -> numEjemplares - numPrestados
*/

CREATE FUNCTION getNumDisponible (titulo VARCHAR(100))
RETURNS INT(11)
BEGIN

RETURN (
  getNumEjemplares(titulo) -
  COALESCE((
    SELECT COUNT(*) FROM prestamo
    WHERE prestamo.fdevolucion > NOW()
    AND prestamo.libro = getIdLibro(titulo)
    GROUP BY prestamo.libro
    ),0)
);

END $$

DELIMITER ;

-- PRUEBAS
SELECT 
  libro.libro, libro.titulo, libro.numEjemplares,
  getNumDisponible(libro.titulo) AS "Ejemplares disponibles"
  FROM libro;