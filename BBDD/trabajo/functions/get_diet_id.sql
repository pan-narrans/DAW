DROP FUNCTION IF EXISTS get_diet_id;

DELIMITER //

/*
  Función que recibe como parámetro el nombre de una dieta y devuelve su id.
  
  Si la dieta pedida no existe la función devolverá -1.
*/

CREATE FUNCTION get_diet_id (diet_name VARCHAR(255))
RETURNS INT
BEGIN

  -- variables
  DECLARE diet_id INT;

  -- sets
  SELECT id INTO diet_id FROM diets 
  WHERE name = LOWER(diet_name);

  -- en caso de error, devuelve -1
  IF (diet_id IS NULL) THEN
    SET diet_id = -1;
  END IF;

  -- return
  RETURN diet_id;

END //

DELIMITER ;

-- TESTS
SELECT get_diet_id('normal');
SELECT get_diet_id('Vegetarian');
SELECT get_diet_id('test_value');