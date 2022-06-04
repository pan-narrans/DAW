# Generador de menus y lista de la compra

> Este documento está escrito en markdown, se puede visualizar cómodamente [aquí](https://markdownlivepreview.com/) copiando y pegando su contenido.

- [Generador de menus y lista de la compra](#generador-de-menus-y-lista-de-la-compra)
  - [Idea](#idea)
  - [Funcionamiento](#funcionamiento)
    - [Generación del menú](#generación-del-menú)
    - [Elección de las recetas](#elección-de-las-recetas)
    - [Lista de la compra](#lista-de-la-compra)

## Idea

Escoger que hacer de comer es muy pesado, y hacer que la dieta sea equilibrada más. De ahí la idea de hacer una app que lo escoja por mi ~~(porque eso es más sencillo por alguna razón)~~.

La app tiene que:

- guardar las preferencias del usuario
- generar un menú
  - equilibrado
  - en base a los parámetros de una dieta
  - para un número indicado de días
- generar una lista de la compra

Dado que esto es un primer acercamiento a la base de datos del proyecto, no todas las funcionalidades van a estar presentes. Esto se debe a que programar en java es más cómodo que programar en SQL.

A raíz de esto va a haber tablas en la base de datos que no van a tener utilidad real por ahora, como la tabla `ingredient_type` que nos indica el tipo de alimento del que se trata. Esta tabla se usaría para asegurar que el ratio de los distintos tipos de alimentos que contiene un menú se ajuste al marcado por la dieta.

## Funcionamiento

> Todos los scripts tienen comentarios dentro explicando su lógica.

Al llamar al procedimiento `create_menu()` automáticamente se rellenan las tablas de recetas para la semana `menu_recipes` y la lista de la compra `menu_shopping_list`.

### Generación del menú

El número de días para los cuales se genera el menú depende de si el usuario quiere un menú para toda la semana o únicamente para los días laborales.

### Elección de las recetas

Las recetas son escogidas en función de la comida (desayuno, almuerzo, ...).

Por ahora la dieta escogida durante la creación de menú no tiene efecto alguno en la elección de las recetas. Esta lógica me ha resultado demasiado compleja y considero que resultará más cómodo realizarla en java que en SQL.

### Lista de la compra

La lista de la compra se genera en base a las recetas del menú. Los ingredientes de todas las recetas se van añadiendo y sumando a la lista.
