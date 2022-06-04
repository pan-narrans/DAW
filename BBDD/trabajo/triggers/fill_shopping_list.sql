DROP TRIGGER IF EXISTS fill_menu_shopping_list;

DELIMITER //

/*
  Disparador que cada vez que se inserte una nueva receta en un menú, automáticamente añada sus ingredientes en la lista de la compra.
*/

CREATE TRIGGER fill_menu_shopping_list AFTER INSERT
ON menu_recipes FOR EACH ROW
BEGIN
 
  -- variables
  DECLARE var_ingredient_id INT;
  DECLARE var_quantity      INT;
  DECLARE var_unit          VARCHAR(255);
	DECLARE finished          INTEGER DEFAULT 0;

  -- cursor para recorrer los ingredientes
  DECLARE ingredient_it CURSOR FOR
    SELECT  ingredient_id, quantity, unit
    FROM    recipe_ingredients
    WHERE   recipe_id = NEW.recipe_id;

  -- handler para la NOT FOUND exception
  DECLARE CONTINUE HANDLER 
  FOR NOT FOUND SET finished = 1;

  OPEN ingredient_it;

  -- para cada ingrediente llamamos al procedimiento que añade el ingrediente a la lista de la compra o actualiza su cantidad si ya estaba en la lista
  WHILE finished = 0 DO
    FETCH ingredient_it INTO var_ingredient_id, var_quantity, var_unit;
    CALL  insert_in_shopping_list(NEW.menu_id, var_ingredient_id, var_quantity, var_unit) ;
  END WHILE;
  
  CLOSE ingredient_it;

END //

DELIMITER ;
