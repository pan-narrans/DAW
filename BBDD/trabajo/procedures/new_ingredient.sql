DROP PROCEDURE IF EXISTS new_ingredient;

DELIMITER //

/*
  Procedimiento que recibe los datos de un nuevo ingrediente y los introduce en la base de datos.
*/

CREATE PROCEDURE new_ingredient(
  IN in_name        VARCHAR(255),
  IN in_description VARCHAR(255)
)

BEGIN

  INSERT INTO ingredients (`id`, `name`, `description`) VALUES
  (NULL, in_name, in_description);

END // 

DELIMITER ;

-- TESTS
call new_ingredient('plátano', 'es amarillo');