DROP FUNCTION IF EXISTS getMejorLector;

DELIMITER $$

/*
  Devuelve el nombre lector que más libros ha leido.
*/

CREATE FUNCTION getMejorLector ()
RETURNS VARCHAR(50)
BEGIN

RETURN (
  SELECT socio.nombre from socio 
  INNER JOIN (Select prestamo.socio, count(prestamo.socio) from prestamo
    GROUP by prestamo.socio
    order by 2 DESC
    Limit 1) as mejorLector
    on mejorLector.socio = socio.socio
);

END $$

DELIMITER ;

-- PRUEBAS
SELECT getMejorLector();