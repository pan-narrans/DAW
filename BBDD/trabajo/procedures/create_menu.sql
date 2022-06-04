DROP PROCEDURE IF EXISTS create_menu;

DELIMITER //

/*
  Procedimiento que recibe como parámetro una dieta y crea un menú usando esa dieta para la semana que viene.

  Si ya existe un menú para la semana que viene con esa dieta se eliminará y creará de nuevo.
*/

CREATE PROCEDURE create_menu(
  IN diet_name VARCHAR(255)
)

BEGIN

  -- variables
  DECLARE diet_id INT;
  DECLARE menu_date DATE;
  DECLARE menu_already_exists INT DEFAULT 0;

  -- sets
  SET diet_id   = get_diet_id(diet_name);
  SET menu_date = get_next_monday(NOW());

  -- comprobar si ya existe el menú
  SELECT COUNT(*) INTO menu_already_exists FROM menus 
  WHERE date = menu_date AND diet_id = diet_id;

  -- eliminar el menú si ya existe
  IF menu_already_exists != 0 THEN
    DELETE FROM menus 
    WHERE date = menu_date AND diet_id = diet_id;
  END IF;

  -- crear el menú
  INSERT INTO menus (`id`, `diet_id`, `date`) VALUES
  (NULL, diet_id, menu_date);

END // 

DELIMITER ;

-- TESTS
-- call create_menu('normal');