DROP PROCEDURE IF EXISTS inscribir;

DELIMITER //

/*
  Recibe como parámetro de entrada el id de la competición e inserta en la tabla CompeticionParticipante todos los participantes de esa competición.

  Por ejemplo:
  CALL inscribir(9) dará como resultado la inserción en la tabla de CompeticionParticipante de todos los participantes de categoría Adulto, porque la competición 9 es de la categoria adultos.
*/

CREATE PROCEDURE inscribir (competicion_id INT)
BEGIN

DECLARE cat VARCHAR(20);

SELECT categoria INTO cat FROM competicion 
WHERE id = competicion_id;

INSERT INTO competicionparticipante
SELECT competicion_id, id, NOW() FROM participante
WHERE getCategory(fecha) = cat;

END //

DELIMITER ;

-- TESTS

INSERT INTO competicion VALUES 
(10, "Torneo de Ajedez", NOW(), "ADULTO"),
(11, "Maratón Solidaria", NOW(), "INFANTIL"),
(12, "Exibición de Baile", NOW(), "CADETE"),
(13, "Maratón Solidaria", NOW(), "JUVENIL");