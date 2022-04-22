# Functions

- [Functions](#functions)
  - [Calling a function](#calling-a-function)
  - [Creating a function](#creating-a-function)

A function is a stored script returning a sole value. Their purpose is to encapsulate useful and commonly used pieces of code.

## Calling a function

To call a SQL function you need to put it inside a `SELECT` statement.

```sql
SELECT getIdLibro("Mort");
```

```sql
SELECT libro.titulo, libro.libro,
  getIdLibro(libro.titulo) 
  AS "Libro Calculado" FROM libro;
```

## Creating a function

You can do it from the mySQL interface or by coding.

```sql
CREATE FUNCTION <functionName> ([<parameter1>[,...]])
RETURNS datatype
```

If a functions doesn't receive any parameters, we leave the `()` blank.

```sql
DROP FUNCTION IF EXISTS getIdLibro;

DELIMITER $$

/*
  Recibe como parámetro el título del libro.
  Devuelve el id de un libro.
*/

CREATE FUNCTION getIdLibro (titulo VARCHAR(100))
RETURNS INT(11)
BEGIN

RETURN(
  SELECT libro.libro FROM libro
  WHERE LOWER(libro.titulo) LIKE LOWER(titulo)
);

END $$

DELIMITER ;

-- PRUEBAS
SELECT libro.titulo, libro.libro,
  getIdLibro(libro.titulo) 
  AS "Libro Calculado" FROM libro;
```

---

> Go back to the [index](.index.md#index).
