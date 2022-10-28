DROP FUNCTION IF EXISTS get_type_id;

DELIMITER //

/*
  Función que recibe como parámetro el nombre de una dieta y devuelve su id.
  
  Si la dieta pedida no existe la función devolverá -1.
*/

CREATE FUNCTION get_type_id (type_name VARCHAR(255))
RETURNS INT
BEGIN

  -- variables
  DECLARE type_id INT;

  -- sets
  SELECT id INTO type_id FROM types 
  WHERE name = LOWER(type_name);

  -- en caso de error, devuelve -1
  IF (type_id IS NULL) THEN
    SET type_id = -1;
  END IF;

  -- return
  RETURN type_id;

END //

DELIMITER ;

-- TESTS
SELECT get_type_id('red meat');
SELECT get_type_id('fruit');
SELECT get_type_id('test_value');