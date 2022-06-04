DROP FUNCTION IF EXISTS select_recipe;

DELIMITER //

/*
  Función que escoge una receta de las disponibles en base al tipo de comida (desayuno, almuerzo, ...).
*/

CREATE FUNCTION select_recipe (comida VARCHAR(255))
RETURNS INT
BEGIN

  -- variables
  DECLARE recipe_id INT DEFAULT -1;
 
  -- seleccionamos una receta concorde con el tipo de comida
  SELECT id INTO recipe_id FROM recipes 
  INNER JOIN recipe_categories ON recipe_categories.recipe_id = recipes.id
  WHERE recipe_categories.category LIKE comida
  LIMIT 1;

  -- return
  RETURN recipe_id;

END //

DELIMITER ;

-- TESTS
SELECT select_recipe('breakfast'  );
SELECT select_recipe('lunch'      );
SELECT select_recipe('meal'       );
SELECT select_recipe('snack'      );
SELECT select_recipe('dinner'     );
SELECT select_recipe('test_value' );