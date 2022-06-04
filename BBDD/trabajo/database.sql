DROP DATABASE IF EXISTS what_to_eat;
CREATE DATABASE what_to_eat;
USE what_to_eat;


--   dP            dP       dP                   
--   88            88       88                   
-- d8888P .d8888b. 88d888b. 88 .d8888b. .d8888b. 
--   88   88'  `88 88'  `88 88 88ooood8 Y8ooooo. 
--   88   88.  .88 88.  .88 88 88.  ...       88 
--   dP   `88888P8 88Y8888' dP `88888P' `88888P'   


CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  repeat_recipe BOOLEAN DEFAULT TRUE,
  count_week_ends BOOLEAN DEFAULT TRUE,

  PRIMARY KEY (id)
);

-- ===============
-- ingredients
-- ===============

CREATE TABLE ingredients (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE,
  description TEXT,

  PRIMARY KEY (id)
);

CREATE TABLE types (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description TEXT,

  PRIMARY KEY (id)
);

CREATE TABLE ingredient_type (
  ingredient_id INT NOT NULL,
  type_id INT NOT NULL,

  PRIMARY KEY (ingredient_id, type_id),
  CONSTRAINT FK_ingredient_type_ingredient_id
    FOREIGN KEY (ingredient_id) REFERENCES ingredients(id)
    ON DELETE CASCADE,
  CONSTRAINT FK_ingredient_type_type_id
    FOREIGN KEY (type_id) REFERENCES types(id)
);


-- ===============
-- recipes 
-- ===============

CREATE TABLE recipes (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  steps TEXT NOT NULL,
  prep_time INT NOT NULL,
  cook_time INT,
  servings INT,
  photo VARCHAR(255),
  season VARCHAR(255),

  PRIMARY KEY (id)
);

/*
  For separating the recipes into what time of day they ought to be eaten.
*/
CREATE TABLE recipe_categories (
  recipe_id INT NOT NULL,
  category VARCHAR(255) NOT NULL,

  PRIMARY KEY (recipe_id, category),
  CONSTRAINT FK_recipe_categories_recipe_id
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
    ON DELETE CASCADE
);


/*
  Allows for more search options on recipes
*/
CREATE TABLE recipe_tags (
  recipe_id INT NOT NULL,
  tag VARCHAR(255) NOT NULL,

  PRIMARY KEY (recipe_id, tag),
  CONSTRAINT FK_recipe_tags_recipe_id
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
    ON DELETE CASCADE
);

CREATE TABLE recipe_ingredients (
  recipe_id INT NOT NULL,
  ingredient_id INT NOT NULL,
  quantity INT NOT NULL,
  unit VARCHAR(255) NOT NULL,

  PRIMARY KEY (recipe_id, ingredient_id),
  CONSTRAINT FK_recipe_ingredients_recipe_id
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
    ON DELETE CASCADE,
  CONSTRAINT FK_recipe_ingredients_ingredient_id
    FOREIGN KEY (ingredient_id) REFERENCES ingredients(id)
);


-- ===============
-- diets
-- ===============

CREATE TABLE diets (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE,
  description TEXT,

  PRIMARY KEY (id)
);

CREATE TABLE diet_specifics (
  diet_id INT NOT NULL,
  type_id INT NOT NULL,
  percent DECIMAL(5,2) NOT NULL,

  PRIMARY KEY (diet_id, type_id),
  CONSTRAINT FK_diet_specifics_diet_id
    FOREIGN KEY (diet_id) REFERENCES diets(id)
    ON DELETE CASCADE,
  CONSTRAINT FK_diet_specifics_type_id
    FOREIGN KEY (type_id) REFERENCES types(id)
);

/*
  Pizza Friday Night
*/
CREATE TABLE fixed_foods (
  recipe_id INT NOT NULL,
  day VARCHAR(255) NOT NULL,
  time VARCHAR(255) NOT NULL,

  PRIMARY KEY (recipe_id, day, time),
  CONSTRAINT FK_fixed_foods_recipe_id
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
    ON DELETE CASCADE
);

-- ===============
-- menu // output
-- ===============

/*
  Stores the history of menus.
*/
CREATE TABLE menus (
  id INT NOT NULL AUTO_INCREMENT,
  diet_id INT NOT NULL,
  date DATE,

  PRIMARY KEY (id),
  CONSTRAINT FK_menu_diet_id 
    FOREIGN KEY (diet_id) REFERENCES diets(id)
);

/*
  Links the recipes to the menus.
*/
CREATE TABLE menu_recipes (
  menu_id INT NOT NULL,
  recipe_id INT NOT NULL,
  day INT NOT NULL,
  time ENUM('breakfast', 'lunch', 'meal', 'snack', 'dinner') NOT NULL,

  PRIMARY KEY (menu_id, day, time),
  CONSTRAINT FK_menu_recipes_menu 
    FOREIGN KEY (menu_id) REFERENCES menus(id)
    ON DELETE CASCADE,
  CONSTRAINT FK_menu_recipes_recipe 
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
);

/*
  Shopping list. It ties ingredientes to a menu based on the recipes it holds.
*/
CREATE TABLE menu_shopping_list (
  menu_id INT NOT NULL,
  ingredient_id INT NOT NULL,
  ingredient_name VARCHAR(255) NOT NULL,
  quantity INT NOT NULL,
  unit VARCHAR(255) NOT NULL,
  bought BOOLEAN DEFAULT FALSE,

  PRIMARY KEY (menu_id, ingredient_id),
  CONSTRAINT FK_menu_shopping_list_list_id 
    FOREIGN KEY (menu_id) REFERENCES menus(id)
    ON DELETE CASCADE,
  CONSTRAINT FK_menu_shopping_list_ingredient_id 
    FOREIGN KEY (ingredient_id) REFERENCES ingredients(id)
);


--       dP            dP            
--       88            88            
-- .d888b88 .d8888b. d8888P .d8888b. 
-- 88'  `88 88'  `88   88   88'  `88 
-- 88.  .88 88.  .88   88   88.  .88 
-- `88888P8 `88888P8   dP   `88888P8 

-- users
INSERT INTO `users` (`id`, `username`, `password`, `repeat_recipe`, `count_week_ends`) 
VALUES (NULL, 'alex', '1234', '1', '1');

-- ===============
-- ingredients
-- ===============

-- ingredients
INSERT INTO `ingredients` (`id`, `name`, `description`) VALUES
(NULL, 'tomato', 'tomato'),
(NULL, 'cheese', 'cheese'),
(NULL, 'garlic', 'garlic'),
(NULL, 'olive oil', 'olive oil'),
(NULL, 'bread', 'bread'),
(NULL, 'pizza dough', 'bread');

-- types
INSERT INTO `types` (`id`, `name`, `description`) VALUES 
(NULL, 'simple carbohydrate', 'Simple carbohydrates are carbohydrates that are not sugar or starch'),
(NULL, 'rice', 'Rice is a grain or cereal grain that is the principal source of protein in many cultures.'),
(NULL, 'cereal', 'Cereal is a food made from starches such as wheat, oats, barley, rye, and oats.'),
(NULL, 'complex carbohydrate', 'Complex carbohydrates are carbohydrates that are sugar or starch'),
(NULL, 'vegetables', 'Vegetables are plants that are eaten as food.'),
(NULL, 'fruit', 'Fruit is the edible part of a plant.'),
(NULL, 'vegetal protein', 'Vegetal proteins are proteins that are found in vegetables'),
(NULL, 'legume', 'Legumes are vegetables that are not part of the plant'),
(NULL, 'animal protein', 'Animal proteins are proteins that are found in animals'),
(NULL, 'red meat', 'Red meat is so full of blood'),
(NULL, 'white meat', 'White meat is good for your health'),
(NULL, 'blue fish', 'Blue fish is good for you'),
(NULL, 'white fish', 'White fish is good for you'),
(NULL, 'dairy', 'Dairy is a food made from milk and other dairy products.'),
(NULL, 'saturated fat', 'Saturated fats are fats that are saturated'),
(NULL, 'unsaturated fat', 'Unsaturated fats are fats that are not saturated');

-- ingredient_type
INSERT INTO `ingredient_type` (`ingredient_id`, `type_id`) VALUES
(1, 4),
(1, 5),
(2, 9),
(2, 14),
(3, 4),
(3, 5),
(4, 16),
(5, 1),
(5, 3),
(6, 1),
(6, 3);


-- ===============
-- recipes
-- ===============

-- recipes
INSERT INTO `recipes` (`id`, `name`, `description`, `steps`, `prep_time`, `cook_time`,`servings`, `photo`, `season`) VALUES
(NULL, 'Pizza', 'Pizza is a savory dish of Italian origin, consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients baked at a high temperature, traditionally in a wood-fired oven.', 'make a pizza', 30, 40, 2, 'https://upload.wikimedia.org/wikipedia/commons/e/e3/Pizza_16.jpg', NULL),
(NULL, 'Garlic and tomato sandwich', 'Really this is just some toasted bread with oil, garlic and tomatoes.', '-toast the bread \n-scratch the garlic over the bread \n- pour some oil (wherever) \n- put the tomato over the garlicked face of the bread \nBone apple tea!', 5, NULL, 1, 'https://upload.wikimedia.org/wikipedia/commons/2/2f/Untado_Tomate.jpg', 'summer');

-- recipe_categories
INSERT INTO `recipe_categories` (`recipe_id`, `category`) VALUES
(1, 'meal'),
(1, 'dinner'),
(2, 'breakfast'),
(2, 'lunch'),
(2, 'snack');

-- recipe_tags
INSERT INTO `recipe_tags` (`recipe_id`, `tag`) VALUES
(1, 'pizza'),
(1, 'italian'),
(1, 'fast'),
(1, 'easy'),
(2, 'sandwich'),
(2, 'fast'),
(2, 'easy'),
(2, 'vegetarian'),
(2, 'vegan');

-- recipe_ingredients
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`, `quantity`, `unit`) VALUES
(1, 1, 100, 'g'),
(1, 2, 150, 'g'),
(1, 6, 1, 'unit'),
(2, 1, 1, 'piece'),
(2, 3, 1, 'garlic head'),
(2, 4, 10, 'mL'),
(2, 5, 2, 'slices');


-- ===============
-- diets
-- ===============

-- diets
INSERT INTO `diets` (`id`, `name`, `description`) VALUES
(NULL, 'normal', 'Normal diet is a diet that is not too high in fat or calories.'),
(NULL, 'vegetarian', 'Vegetarian is a diet that is based on the principle that the body should be able to tolerate the absence of meat, fish, dairy, eggs, and processed meat products.'),
(NULL, 'vegan', 'Vegan is a diet that is based on the principle that the body should be able to tolerate the absence of animal products.');

-- diet_specifics
INSERT INTO `diet_specifics` (`diet_id`, `type_id`, `percent`) VALUES
(1, 1, 16.67),
(1, 4, 16.67),
(1, 7, 16.67),
(1, 10, 8.33),
(1, 11, 16.67),
(1, 12, 16.67),
(1, 13, 8.33);

-- fixed_foods
INSERT INTO `fixed_foods` (`recipe_id`, `day`, `time`) VALUES
(1, 'Friday', 'dinner');

-- ===============
-- output
-- ===============

-- menus

-- menu_recipes

-- menu_shopping_list



-- .8888b                              dP   oo
-- 88   "                              88
-- 88aaa  dP    dP 88d888b. .d8888b. d8888P dP .d8888b. 88d888b. .d8888b.
-- 88     88    88 88'  `88 88'  `""   88   88 88'  `88 88'  `88 Y8ooooo.
-- 88     88.  .88 88    88 88.  ...   88   88 88.  .88 88    88       88
-- dP     `88888P' dP    dP `88888P'   dP   dP `88888P' dP    dP `88888P'

DROP FUNCTION IF EXISTS get_diet_id;
DROP FUNCTION IF EXISTS get_next_monday;
DROP FUNCTION IF EXISTS get_ingredient_id;
DROP FUNCTION IF EXISTS select_recipe;
DROP FUNCTION IF EXISTS get_user_week_length;

DELIMITER //

/*
  Función que recibe como parámetro el nombre de una dieta y devuelve su id.
  
  Si la dieta pedida no existe la función devolverá -1.
*/

CREATE FUNCTION get_diet_id (diet_name VARCHAR(255))
RETURNS INT
BEGIN

  DECLARE diet_id INT;

  SELECT id INTO diet_id FROM diets 
  WHERE name = LOWER(diet_name);

  IF (diet_id IS NULL) THEN
    SET diet_id = -1;
  END IF;

  RETURN diet_id;

END //


/*
  Función que devuelve el siguiente lunes a partir de la fecha introducida.
*/

CREATE FUNCTION get_next_monday (in_date DATE)
RETURNS DATE
BEGIN

  DECLARE day_of_week INT;
  SET day_of_week = WEEKDAY(in_date);
  
  RETURN DATE_ADD(in_date, INTERVAL (7 - day_of_week) DAY);

END //


/*
  Función que recibe como parámetro el nombre de una dieta y devuelve su id.
  
  Si la dieta pedida no existe la función devolverá -1.
*/

CREATE FUNCTION get_ingredient_id (ingredient_name VARCHAR(255))
RETURNS INT
BEGIN

  DECLARE ingredient_id INT;

  SELECT id INTO ingredient_id FROM ingredients 
  WHERE name = LOWER(ingredient_name);

  IF (ingredient_id IS NULL) THEN
    SET ingredient_id = -1;
  END IF;

  RETURN ingredient_id;

END //


/*
  Función que escoge una receta de las disponibles en base al tipo de comida (desayuno, almuerzo, ...).
*/

CREATE FUNCTION select_recipe (comida VARCHAR(255))
RETURNS INT
BEGIN

  -- variables
  DECLARE recipe_id INT DEFAULT -1;
 
  -- 
  SELECT id INTO recipe_id FROM recipes 
  INNER JOIN recipe_categories ON recipe_categories.recipe_id = recipes.id
  WHERE recipe_categories.category LIKE comida
  LIMIT 1;

  -- return
  RETURN recipe_id;

END //


/*
  Función que escoge una receta de las disponibles en base al tipo de comida (desayuno, almuerzo, ...).
*/

CREATE FUNCTION get_user_week_length (user_id INT UNSIGNED)
RETURNS INT
BEGIN

  -- variables
  DECLARE week_length INT DEFAULT -1;
  DECLARE weekends    BOOLEAN;
 
  -- sets
  SELECT count_week_ends INTO weekends 
  FROM users WHERE id = user_id;

  -- asigna la longitud de la semana
  IF weekends = 1 THEN
    SET week_length = 7;
  ELSEIF weekends = 0 THEN
    SET week_length = 5;
  END IF;

  -- return
  RETURN week_length;

END //

DELIMITER ;


                                                   -- dP
                                                   -- 88
-- 88d888b. 88d888b. .d8888b. .d8888b. .d8888b. .d888b88 dP    dP 88d888b. .d8888b.
-- 88'  `88 88'  `88 88'  `88 88'  `"" 88ooood8 88'  `88 88    88 88'  `88 88ooood8
-- 88.  .88 88       88.  .88 88.  ... 88.  ... 88.  .88 88.  .88 88       88.  ...
-- 88Y888P' dP       `88888P' `88888P' `88888P' `88888P8 `88888P' dP       `88888P'
-- 88
-- dP

DROP PROCEDURE IF EXISTS create_menu;
DROP PROCEDURE IF EXISTS insert_in_shopping_list;

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
  SET diet_id = get_diet_id(diet_name);
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


/*/*
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

  IF ( SELECT COUNT(*) FROM menu_shopping_list 
      WHERE menu_id = in_menu_id AND ingredient_id = in_ingredient_id ) = 0
  THEN
    -- if the ingredient is not in the shopping list, insert it
    INSERT INTO menu_shopping_list 
      (`menu_id`, `ingredient_id`,`ingredient_name`, `quantity`, `unit`,`bought`)
    VALUES (in_menu_id, in_ingredient_id, ingredient_name, in_quantity, in_unit, 0);
  ELSE
    -- if the ingredient is in the shopping list, update it
    UPDATE menu_shopping_list SET quantity = in_quantity + quantity 
    WHERE menu_id = in_menu_id AND ingredient_id = in_ingredient_id;
  END IF;


END // 
DELIMITER ;



--   dP            oo
--   88
-- d8888P 88d888b. dP .d8888b. .d8888b. .d8888b. 88d888b. .d8888b.
--   88   88'  `88 88 88'  `88 88'  `88 88ooood8 88'  `88 Y8ooooo.
--   88   88       88 88.  .88 88.  .88 88.  ... 88             88
--   dP   dP       dP `8888P88 `8888P88 `88888P' dP       `88888P'
--                         .88      .88
--                     d8888P   d8888P


DROP TRIGGER IF EXISTS fill_menu_recipes;
DROP TRIGGER IF EXISTS fill_menu_shopping_list;

DELIMITER //

/*
  Disparador que cada vez que se inserte un nuevo menú, le asigne una receta a todas las comidas del día para cada día de la semana.

  Por defecto ahora asigna únicamente la receta nº 2.
*/

CREATE TRIGGER fill_menu_recipes AFTER INSERT
ON menus FOR EACH ROW
BEGIN

  -- variables
  DECLARE day INT;
  DECLARE day_limit INT;

  -- sets
  SET day = WEEKDAY(NEW.date);
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


/*
  Disparador que cada vez que se inserte una nueva receta en un menú, automáticamente añada sus ingredientes en la lista de la compra.
*/

CREATE TRIGGER fill_menu_shopping_list AFTER INSERT
ON menu_recipes FOR EACH ROW
BEGIN
 
  -- variables
  DECLARE var_ingredient_id INT;
  DECLARE var_quantity INT;
  DECLARE var_unit VARCHAR(255);
	DECLARE finished INTEGER DEFAULT 0;

  -- cursor para recorrer los ingredientes
  DECLARE ingredient_it CURSOR FOR
    SELECT 
      ingredient_id, quantity, unit
    FROM 
      recipe_ingredients
    WHERE
      recipe_id = NEW.recipe_id;

  -- handler para la NOT FOUND exception
  DECLARE CONTINUE HANDLER 
  FOR NOT FOUND SET finished = 1;

  OPEN ingredient_it;

  -- para cada ingrediente llamamos al procedimiento que añade el ingrediente a la lista de la compra o actualiza su cantidad si ya estaba en la lista
  WHILE finished = 0 DO
    FETCH ingredient_it INTO var_ingredient_id, var_quantity, var_unit;
    CALL insert_in_shopping_list(NEW.menu_id, var_ingredient_id, var_quantity, var_unit) ;
  END WHILE;
  
  CLOSE ingredient_it;

END //

DELIMITER ;
