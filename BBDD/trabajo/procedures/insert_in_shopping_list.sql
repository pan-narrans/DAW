DROP PROCEDURE IF EXISTS insert_in_shopping_list;

DELIMITER //

/*
  Procedimiento que recibe un ingrediente a introducir en la lista de la compra.

  Si el ingrediente ya se encuentra en la lista de la compra se actualizará su cantidad. Si no se encuentra en la lista este será añadido.
*/

CREATE PROCEDURE insert_in_shopping_list(
  IN in_menu_id       INT,
  IN in_ingredient_id INT,
  IN in_quantity      INT,
  IN in_unit          VARCHAR(255)
)

BEGIN

  -- variables
  DECLARE ingredient_name VARCHAR(255);

  -- sets
  SELECT name INTO ingredient_name FROM ingredients WHERE id = in_ingredient_id;

  -- comprobamos si el ingrediente ya se encuentra en la lista
  IF ( SELECT COUNT(*) FROM menu_shopping_list 
      WHERE menu_id = in_menu_id AND ingredient_id = in_ingredient_id ) = 0
  THEN
    -- si el ingrediente no se encuentra en la lista, se añade
    INSERT INTO menu_shopping_list 
      (`menu_id`, `ingredient_id`,`ingredient_name`, `quantity`, `unit`,`bought`)
    VALUES (in_menu_id, in_ingredient_id, ingredient_name, in_quantity, in_unit, 0);
  ELSE
    -- si el ingrediente se encuentra en la lista, se actualiza la cantidad
    UPDATE menu_shopping_list SET quantity = in_quantity + quantity 
    WHERE menu_id = in_menu_id AND ingredient_id = in_ingredient_id;
  END IF;


END // 

DELIMITER ;

-- TESTS
call create_menu('normal');