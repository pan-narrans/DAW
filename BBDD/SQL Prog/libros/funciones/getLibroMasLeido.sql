DROP FUNCTION IF EXISTS getLibroMasLeido;

DELIMITER $$

/*
  Devuelve el título libro más leido.
*/

CREATE FUNCTION getLibroMasLeido ()
RETURNS VARCHAR(50)
BEGIN

RETURN (
  SELECT libro.titulo from libro 
  INNER JOIN (Select prestamo.libro, count(prestamo.libro) from prestamo
    GROUP by prestamo.libro
    order by 2 DESC
    Limit 1) as mejorLibro
    on mejorLibro.libro = libro.libro
);
 
END $$

DELIMITER ;

-- PRUEBAS
SELECT getLibroMasLeido();