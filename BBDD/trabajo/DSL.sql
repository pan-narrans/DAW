
/*
  Recipe:
    - id: id of the recipe
    - name: name of the recipe
    - description: short description of the recipe
    - steps: instructions
    - prep_time: preparation time in minutes
    - cook_time: cooking time in minutes
    - photo: url of the photo
    - category: salad, sandwich, etc...
    - temporada: verano / invierno
*/
table recipe{
  id int [pk]
  name varchar [not null]
  description text
  steps text [not null]
  prep_time int [not null]
  cook_time int
  photo varchar
  category varchar [not null]
  temporada varchar
}

table tags_recipe{
  recipe_id int [pk, ref: > recipe.id]
  tag varchar
}

/*
  Ingredientes:
    - id: id of the ingredient
    - name: name of the ingredient
    - type: (vegetable, fruit, etc)
    - parent: parent ingredient, can inherit its type
*/
table ingredient{
  id int [pk]
  name varchar [not null]
  description text
  }
  
table types{
  id int [pk]
  name varchar [not null]
  description text
}

/*
  Ingredients of a recipe.
    - recipe_id: id of the recipe
    - ingredient_id: id of the ingredient
    - quantity: quantity of the ingredient
    - unit: unit of measurement
*/
table recipe_ingredient{
  recipe_id int [pk, ref: > recipe.id]
  ingredient_id int [pk, ref: > ingredient.id]
  quantity int [not null]
  unit unit [not null]
}


table menu{
  id int [pk]
  diet_id int [ref: > diet.id]
  date date [not null]
}

enum unit {
  mL
  L
  g
  Kg
  spoon
  coffe_spoon
}

table menu_recipes{
  menu int [pk, ref: > menu.id]
  recipe int [pk, ref: > recipe.id]
  day int 
  time eat_time /* comida, cena */
}


/*
  Stores the shopping list items pertaining to a specific list.
*/
table shopping_list_ingredients{
  list_id int [pk, ref: > menu.id]
  ingredient inf [pk, ref: > ingredient.id]
  quantity int [not null]
  unit unit [ref: > recipe_ingredient.unit]
  bought boolean
}

/*
  Pizza Friday.
*/
table fixed_foods{
  recipe_id int [pk, ref: > recipe.id]
  day int [pk]  
}

/*
  For different diets. Such as normal, weight loss, muscle gain, ...
*/
table diet{
  id int [pk]
  name varchar [not null]
  description text
}

table diet_specifics{
  diet_id int [pk, ref: > diet.id]
  tipe_food varchar [pk]
  percent int [not null]
}


enum eat_time{
  desayuno
  almuerzo
  comida
  merienda
  cena
}

table user{
  id int [pk]
  username varchar [not null]
  password varchar [not null]
  repeat_recipe boolean
}

table ingredient_type{
  ingredient_id int [pk, ref: > ingredient.id]
  tipe_id int [pk, ref: > types.id]
}