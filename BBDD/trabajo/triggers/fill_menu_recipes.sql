DROP TRIGGER IF EXISTS fill_menu_recipes;

DELIMITER //

/*
  Disparador que cada vez que se inserte un nuevo menú, le asigne una receta a todas las comidas del día para cada día de la semana.

  Por defecto ahora asigna únicamente la receta nº 2.
*/

CREATE TRIGGER fill_menu_recipes AFTER INSERT
ON menus FOR EACH ROW
BEGIN

  -- variables
  DECLARE day       INT;
  DECLARE day_limit INT;

  -- sets
  SET day       = WEEKDAY(NEW.date);
  SET day_limit = day + get_user_week_length(1);

  -- para cada día de la semana
  WHILE day < day_limit DO
    -- asigna la receta a todas las comidas del día
    INSERT INTO menu_recipes (`menu_id`, `recipe_id`, `day`, `time`)
    VALUES 
      (NEW.id, select_recipe('breakfast'), day, 'breakfast'),
      (NEW.id, select_recipe('lunch'    ), day, 'lunch'    ),
      (NEW.id, select_recipe('meal'     ), day, 'meal'     ),
      (NEW.id, select_recipe('snack'    ), day, 'snack'    ),
      (NEW.id, select_recipe('dinner'   ), day, 'dinner'   );

    SET day = day + 1;
  END WHILE;

END //

DELIMITER ;
