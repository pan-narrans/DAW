DROP FUNCTION IF EXISTS getIdLibro;

DELIMITER $$

/*
  Recibe como parámetro el título del libro.
  Devuelve el id de un libro.
*/

CREATE FUNCTION getIdLibro (titulo VARCHAR(100))
RETURNS INT(11)
BEGIN

RETURN(
  SELECT libro.libro FROM libro
  WHERE LOWER(libro.titulo) LIKE LOWER(titulo)
);

END $$

DELIMITER ;

-- PRUEBAS
SELECT libro.titulo, libro.libro,
  getIdLibro(libro.titulo) 
  AS "Libro Calculado" FROM libro;