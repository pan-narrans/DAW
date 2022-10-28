DROP PROCEDURE IF EXISTS add_ingredient_type;

DELIMITER //

/*
  Procedimiento que recibe los datos de un nuevo ingrediente y los introduce en la base de datos.
*/

CREATE PROCEDURE add_ingredient_type(
  IN in_ingredient_name        VARCHAR(255),
  IN in_type_name VARCHAR(255)
)

BEGIN

  INSERT INTO ingredient_types (`ingredient_id`, `type_id`) VALUES
  (get_ingredient_id(in_ingredient_name), get_type_id(in_type_name));

END // 

DELIMITER ;

-- TESTS
call add_ingredient_type('plátano', 'complex carbohydrate');
call add_ingredient_type('plátano', 'fruit');