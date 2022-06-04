DROP FUNCTION IF EXISTS get_next_monday;

DELIMITER //

/*
  Función que devuelve el siguiente lunes a partir de la fecha introducida.
*/

CREATE FUNCTION get_next_monday (in_date DATE)
RETURNS DATE
BEGIN

  -- variables y sets
  DECLARE day_of_week INT;
  SET day_of_week = WEEKDAY(in_date);
  
  -- return
  RETURN DATE_ADD(in_date, INTERVAL (7 - day_of_week) DAY);

END //

DELIMITER ;

-- TESTS
SELECT get_next_monday(NOW());
SELECT get_next_monday(DATE_ADD(NOW(), INTERVAL 6 DAY));