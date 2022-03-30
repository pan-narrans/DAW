
-- Para poder ejecutar de forma directa el script entero
DROP FUNCTION IF EXISTS getLibroMasLeido;
DROP FUNCTION IF EXISTS getMejorLector;


DELIMITER $$

/*
 TODO: no hace lo que debe hacer
*/
CREATE FUNCTION getLibroMasLeido ()
RETURNS INT(11)
BEGIN

RETURN (
  SELECT libro.libro  FROM libro
  WHERE libro.numpag >= 
  (SELECT MAX(libro.numpag) FROM libro)
);
 
END$$

/*
Devuelve el lector que más libros ha leido.
*/
CREATE FUNCTION getMejorLector ()
RETURNS VARCHAR(50)
BEGIN

RETURN(
  SELECT socio.nombre from socio 
  INNER JOIN (Select prestamo.socio, count(prestamo.socio) from prestamo
    GROUP by prestamo.socio
    order by 2 DESC
    Limit 1) as mejorLector
    on mejorLector.socio = socio.socio
);

END$$


DELIMITER ;