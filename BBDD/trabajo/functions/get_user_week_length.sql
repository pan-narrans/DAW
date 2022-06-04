DROP FUNCTION IF EXISTS get_user_week_length;

DELIMITER //

/*
  Función que escoge una receta de las disponibles en base al tipo de comida (desayuno, almuerzo, ...).
*/

CREATE FUNCTION get_user_week_length (user_id INT UNSIGNED)
RETURNS INT
BEGIN

  -- variables
  DECLARE week_length INT DEFAULT -1;
  DECLARE weekends    BOOLEAN;
 
  -- sets
  SELECT count_week_ends INTO weekends 
  FROM users WHERE id = user_id;

  -- asigna la longitud de la semana
  IF weekends = 1 THEN
    SET week_length = 7;
  ELSEIF weekends = 0 THEN
    SET week_length = 5;
  END IF;

  -- return
  RETURN week_length;

END //

DELIMITER ;

-- TESTS
SELECT get_user_week_length(1 );
SELECT get_user_week_length(-1);