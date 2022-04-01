DROP FUNCTION IF EXISTS getNumEjemplares;

DELIMITER $$

/*
  Recibe como entrada el título del libro.
  Devuelve el nº de ejemplares del libro.
*/

CREATE FUNCTION getNumEjemplares (titulo VARCHAR(100))
RETURNS INT(11)
BEGIN

RETURN (
  SELECT libro.numEjemplares FROM libro
  WHERE libro.titulo = titulo
);

END $$


DELIMITER ;

-- PRUEBAS
SELECT libro.numEjemplares, getNumEjemplares(libro.titulo) 
  AS "Nº Ejemplares" FROM libro;