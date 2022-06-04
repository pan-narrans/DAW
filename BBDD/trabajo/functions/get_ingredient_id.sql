DROP FUNCTION IF EXISTS get_ingredient_id;

DELIMITER //

/*
  Función que recibe como parámetro el nombre de una dieta y devuelve su id.
  
  Si la dieta pedida no existe la función devolverá -1.
*/

CREATE FUNCTION get_ingredient_id (ingredient_name VARCHAR(255))
RETURNS INT
BEGIN

  -- variables
  DECLARE ingredient_id INT;

  -- sets
  SELECT id INTO ingredient_id FROM ingredients 
  WHERE name = LOWER(ingredient_name);

  -- en caso de error, devuelve -1
  IF (ingredient_id IS NULL) THEN
    SET ingredient_id = -1;
  END IF;

  -- return
  RETURN ingredient_id;

END //

DELIMITER ;

-- TESTS
SELECT get_ingredient_id('tomato');
SELECT get_ingredient_id('bread');
SELECT get_ingredient_id('test_value');