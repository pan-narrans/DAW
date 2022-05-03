DROP FUNCTION IF EXISTS getCategory;

DELIMITER //

/*
  Función que toma como parámetro una fecha y devuelve a que categoría pertenece. 

  Esta  función debe calcular la edad con respecto a la fecha actual.

  INFANTIL  → de 8 a 10 años
  CADETE    → de 11 años a 14 años
  JUVENIL   → de 15 a 17 años.
  ADULTO    → mayores de 18 años.

  Para calcular la diferencia entre fechas usaremos:
  TIMESTAMPDIFF(YEAR,Fec,NOW()) 
*/

CREATE FUNCTION getCategory (fecha DATE)
RETURNs VARCHAR(20)
BEGIN

  DECLARE edad INT;
  DECLARE categoria VARCHAR(20);

  SET edad = TIMESTAMPDIFF(YEAR,fecha,NOW());

  IF edad >= 8 AND edad <= 10 THEN
    SET categoria = "INFANTIL";
  ELSEIF edad >= 11 AND edad <= 14 THEN
    SET categoria = "CADETE";
  ELSEIF edad >= 15 AND edad <= 17 THEN
    SET categoria = "JUVENIL";
  ELSEif edad >= 18 THEN
    SET categoria = "ADULTO";
  ELSE
    SET categoria = "ERROR";
  END IF;

  RETURN categoria;

END //

DELIMITER ;

-- TESTS

-- Muestra la cagetogría de todos los participantes
SELECT getCategory(fecha) FROM participante;