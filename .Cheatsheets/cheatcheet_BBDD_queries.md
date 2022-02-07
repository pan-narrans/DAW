    Comandos de SQL y cómo usarlos:    
    @author: Alejandro Pérez

- [**SELECT**](#select)
  - [Subconsultas](#subconsultas)
- [JOIN](#join)
  - [Hay varios tipos:](#hay-varios-tipos)
- [UNION](#union)
  - [Tiene un par de requisitos:](#tiene-un-par-de-requisitos)
- [WHERE](#where)
  - [Modificadores lógicos:](#modificadores-lógicos)
  - [LIKE // NOT LIKE](#like--not-like)
  - [WILDCARDS](#wildcards)
  - [IN()](#in)
  - [BETWEEN . AND .](#between--and-)
- [ORDER BY](#order-by)
- [GROUP BY](#group-by)
  - [HAVING](#having)
- [LIMIT](#limit)
- [EXISTS](#exists)
- [Otras Funciones Auxiliares](#otras-funciones-auxiliares)
  - [UPPER() // LOWER()](#upper--lower)
  - [ROUND() // FLOOR() // CEILING()](#round--floor--ceiling)
  - [MOAR MATES](#moar-mates)
  - [TRUNCATE()](#truncate)
  - [CONCAT_WS()](#concat_ws)


<!--..%%%%...%%%%%%..%%......%%%%%%...%%%%...%%%%%%.-->
<!--.%%......%%......%%......%%......%%..%%....%%...-->
<!--..%%%%...%%%%....%%......%%%%....%%........%%...-->
<!--.....%%..%%......%%......%%......%%..%%....%%...-->
<!--..%%%%...%%%%%%..%%%%%%..%%%%%%...%%%%.....%%...-->
#  **SELECT** 
Permite hacer consultas, hay mil ejemplos en este documento.

## Subconsultas
Podemos realizar un select dentro de casi cualquier sitio para realizar una subconsulta dentro de otra consulta. Se pueden anidar de esta forma varias consultas una dentro de otra.

``Se pueden hacer mil mierdas con esto y es una locura, por ahora nos faltan cosas por ver.``

> 🛑  Son poco eficientes

Si podemos evitar hacer una subconsulta, lo evitamos y usamos **JOIN** donde se pueda, que es más eficiente.

---

Una subconsulta dentro de un **FROM** tiene que llevar un alias, si se realiza en otro lugar no tiene porqué llevarlo.
``` sql
-- Calcula el número de valores distintos de codigo_fabricante que aparecen en la tabla productos.
SELECT COUNT(*) as "Nº de Fabricantes"
  FROM ( SELECT DISTINCT p.codigo_fabricante FROM producto p ) c;
```

Pueden hacerse subconsultas con campos de la consulta madre, 
a esto se le llama consultas co-relacionadas.

---

Ejemplos subconsultas:

``` sql
-- Calcula el número de valores distintos de codigo_fabricante que aparecen en la tabla productos.
SELECT COUNT(*) as "Nº de Fabricantes"
  FROM ( SELECT DISTINCT p.codigo_fabricante FROM producto p ) c;
```
``` sql
-- Muestra los productos con precio superior a la media
-- Como se hace desde el FROM, tiene un alias
SELECT p.nombre, p.precio, ROUND(p2.media, 2)
  FROM producto p, (SELECT AVG(precio) as media from producto) p2
  WHERE p.precio > p2.media;
```
``` sql
-- Devuelve los nombres de los fabricantes y el nº de productos que tiene cada uno con un precio superior o igual a 220 €.
SELECT f.nombre as "Fabricante", COALESCE(p1.numero, 0) as "Nº productos" FROM fabricante f 
  LEFT JOIN 
    (SELECT COUNT(*) as numero, codigo_fabricante, precio
    FROM producto WHERE precio >= 220
    GROUP BY codigo_fabricante ) p1
  ON f.codigo = p1.codigo_fabricante;
```
``` sql
-- El nombre de los clientes que no hayan realizado pagos y el nombre de sus representantes de ventas.
SELECT cl1.nombre_cliente, e.nombre FROM cliente cl1
  INNER JOIN empleado e ON cl1.codigo_empleado_rep_ventas = e.codigo_empleado
  WHERE cl1.codigo_cliente NOT IN (
    SELECT DISTINCT cl.codigo_cliente FROM cliente cl
    INNER JOIN pago p on cl.codigo_cliente = p.codigo_cliente);
```




<!--.%%%%%%...%%%%...%%%%%%..%%..%%.-->
<!--.....%%..%%..%%....%%....%%%.%%.-->
<!--.....%%..%%..%%....%%....%%.%%%.-->
<!--.%%..%%..%%..%%....%%....%%..%%.-->
<!--..%%%%....%%%%...%%%%%%..%%..%%.-->
# JOIN 
Realiza un producto cartesiano de las tablas incluídas y  devuelve los valores en base a una cierta condición dada.

## Hay varios tipos:
- **INNER JOIN**: A∩B es la intersección de las dos tablas,
  - Returns records that have matching values in both tables                 
- **LEFT JOIN**: 1ra tabla y la intersección de las dos
  - Returns all records from the left table, and the matched records from the right table
- **RIGHT JOIN**: 2da tabla y la intersección de las dos
  - Returns all records from the right table, and the matched records from the left table
- **FULL OUTER JOIN**: AUB es la unión de las dos tablas
  - Returns all records when there is a match in either left or right table

``` sql
-- Devuelve el nombre de todos los clientes, y en el caso de que tengan pedidos a su nombre, los muestra todos.
SELECT c.CustomerName, o.OrderID FROM Customers c
  LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
  ORDER BY c.CustomerName;
```
```sql
-- Devuelve el nombre de todos los clientes y el de todos los productos que han pedido, al igual que el nº de unidades de cada producto.
SELECT 
    cliente.nombre_cliente as "Nombre Cliente", 
    producto.nombre as "Nombre Producto", 
    COUNT(producto.codigo_producto) as "Nº Productos"
  FROM cliente
  INNER JOIN pedido ON pedido.codigo_cliente = cliente.codigo_cliente
  INNER JOIN detalle_pedido dp ON dp.codigo_pedido = pedido.codigo_pedido
  INNER JOIN producto ON producto.codigo_producto = dp.codigo_producto
  GROUP BY cliente.nombre_cliente, producto.nombre 
  ORDER BY cliente.nombre_cliente, producto.nombre;
```



<!--.%%..%%..%%..%%..%%%%%%...%%%%...%%..%%.-->
<!--.%%..%%..%%%.%%....%%....%%..%%..%%%.%%.-->
<!--.%%..%%..%%.%%%....%%....%%..%%..%%.%%%.-->
<!--.%%..%%..%%..%%....%%....%%..%%..%%..%%.-->
<!--..%%%%...%%..%%..%%%%%%...%%%%...%%..%%.-->
# UNION
Permite unir los resultados de dos o más consultas SELECT en una sola tabla.
## Tiene un par de requisitos:
  - las dos consultas tienen que tener el mismo nº de columnas
  - las columnas tienen que tener un tipo de datos similar
  - las columnas tienen que estar en el mismo orden

``` sql
-- Devuelve los clientes y comerciales que no tienen ningún producto relacionado.
-- BBDD 1-3
SELECT cliente.nombre, "Cliente" as "Tipo" FROM cliente
  LEFT JOIN pedido ON pedido.id_cliente = cliente.id
  WHERE pedido.id IS NULL
UNION
SELECT comercial.nombre, "Comercial" as "Tipo"  FROM comercial
  LEFT JOIN pedido p1 ON p1.id_comercial = comercial.id
  WHERE p1.id IS NULL
ORDER BY 1;
```




<!--.%%...%%..%%..%%..%%%%%%..%%%%%...%%%%%%.-->
<!--.%%...%%..%%..%%..%%......%%..%%..%%.....-->
<!--.%%.%.%%..%%%%%%..%%%%....%%%%%...%%%%...-->
<!--.%%%%%%%..%%..%%..%%......%%..%%..%%.....-->
<!--..%%.%%...%%..%%..%%%%%%..%%..%%..%%%%%%.-->
#  WHERE 
Permite marcar condiciones que deben cumplir los resultados de la consulta.

## Modificadores lógicos:

|   Símbolo   | Significado      |
| :---------: | ---------------- |
|     `=`     | igual            |
| `<>` / `!=` | differente       |
|     `<`     | inferior         |
|     `>`     | superior         |
|    `<=`     | inferior o igual |
|    `>=`     | superior o igual |

| Símbolo | Significado |
| :-----: | ----------- |
|  `AND`  | and lógico  |
|  `OR`   | or lógico   |
|  `NOT`  | negación    |


## LIKE // NOT LIKE
Similar a los comparadores '=' y '<>' y casi siempre hacen lo mismo. 
Permite búsqueda de patrones con wildcards

``` sql
SELECT * FROM table_name
  WHERE condition1 OR condition2 AND NOT condition3 ...; 
``` 

##  WILDCARDS 

| Symbol | Explicación                                      | Ejemplo                                  |
| :----: | ------------------------------------------------ | ---------------------------------------- |
|  `%`   | Zero or more characters.                         | `bl%` finds bl, black, blue, and blob    |
|  `_`   | A single character.                              | `h_t` finds hot, hat, and hit            |
|  `[]`  | Any single character within the brackets.        | `h[oa]t` finds hot and hat, but not hit  |
|  `^`   | Any character not in the brackets.               | `h[^oa]t` finds hit, but not hot and hat |
|  `-`   | Any single character within the specified range. | `c[a-b]t` finds cat and cbt              |


``` sql
SELECT DISTINCT  p.codigo_cliente as "Cliente"  FROM pago p
  WHERE p.fecha_pago LIKE "2008%";
```  

##  IN()
Comprueba que la variable se encuentre dentro de un conjunto
dado de elementos.
``` sql
SELECT * FROM cliente
  WHERE codigo_empleado_rep_ventas IN (11, 30, 23);
```

Es lo mismo que decir:
``` sql
var == 1 AND var == 2 AND ...
```

##  BETWEEN . AND .
Comprueba que la variable se encuentre dentro de un rango

``` sql
SELECT p.nombre FROM producto p
  WHERE p.precio BETWEEN 60 AND 200;
```






<!--..%%%%...%%%%%...%%%%%...%%%%%%..%%%%%......%%%%%...%%..%%.-->
<!--.%%..%%..%%..%%..%%..%%..%%......%%..%%.....%%..%%...%%%%..-->
<!--.%%..%%..%%%%%...%%..%%..%%%%....%%%%%......%%%%%.....%%...-->
<!--.%%..%%..%%..%%..%%..%%..%%......%%..%%.....%%..%%....%%...-->
<!--..%%%%...%%..%%..%%%%%...%%%%%%..%%..%%.....%%%%%.....%%...-->

#  ORDER BY
Ordena en base a una columna dada de forma ASC o DESC.
Pueden concatenarse con una "`,`" .
Por defecto ordena de forma ascendente.

``` sql
SELECT p.nombre
  FROM producto p
  ORDER BY 1 ASC, p.precio DESC;
```




<!--..%%%%...%%%%%....%%%%...%%..%%..%%%%%......%%%%%...%%..%%.-->
<!--.%%......%%..%%..%%..%%..%%..%%..%%..%%.....%%..%%...%%%%..-->
<!--.%%.%%%..%%%%%...%%..%%..%%..%%..%%%%%......%%%%%.....%%...-->
<!--.%%..%%..%%..%%..%%..%%..%%..%%..%%.........%%..%%....%%...-->
<!--..%%%%...%%..%%...%%%%....%%%%...%%.........%%%%%.....%%...-->

#  GROUP BY
Agrupa los resultados según los valores de una columna dada.
Se suele usar junto con: 
  - **COUNT()**: cuenta el nº de ocurrencias
  - **MAX()**: muestra la ocurrencia más alta
  - **MIN()**: muestra la ocurrencia más baja
  - **SUM()**: suma todas las ocurrencias
  - **AVG()**: calcula la media de las ocurrencias


## HAVING 
El having es un where pero para la parte de agrupamientos.

Los aliases del select se pueden usar en el having ya que 
este se ejecuta después.
``` sql
SELECT 
  MAX(p.precio) as precioMax, p.codigo_fabricante 
  FROM producto p 
  
  GROUP BY p.codigo_fabricante
  HAVING precioMax > 200;
```




<!--.%%......%%%%%%..%%...%%..%%%%%%..%%%%%%.-->
<!--.%%........%%....%%%.%%%....%%......%%...-->
<!--.%%........%%....%%.%.%%....%%......%%...-->
<!--.%%........%%....%%...%%....%%......%%...-->
<!--.%%%%%%..%%%%%%..%%...%%..%%%%%%....%%...-->

# LIMIT
Devuelve las 5 primeras filas:
``` sql
SELECT * FROM fabricante f LIMIT 5;
```
Devuelve dos filas empezando por la 3ºa, devuelve entonces las filas cuatro y tres:
``` sql
SELECT * FROM fabricante f LIMIT 3,2;
```




<!--.%%%%%%..%%..%%..%%%%%%...%%%%...%%%%%%...%%%%..-->
<!--.%%.......%%%%.....%%....%%........%%....%%.....-->
<!--.%%%%......%%......%%.....%%%%.....%%.....%%%%..-->
<!--.%%.......%%%%.....%%........%%....%%........%%.-->
<!--.%%%%%%..%%..%%..%%%%%%...%%%%.....%%.....%%%%..-->
# EXISTS
Comprueba si existe el dato comprobado.

Lo podemos usar para comprobar si una subconsulta ha devuelto
algún resultado.

``` sql
-- 14. Devuelve los nombres de los fabricantes que tienen productos asociados.
SELECT * FROM fabricante f1 WHERE EXISTS 
  (SELECT * FROM producto p1 WHERE p1.codigo_fabricante = f1.codigo);
```

``` sql
-- 15. Devuelve los nombres de los fabricantes que no tienen productos asociados.
SELECT * FROM fabricante f1 WHERE NOT EXISTS 
  (SELECT * FROM producto p1 WHERE p1.codigo_fabricante = f1.codigo);
```






# Otras Funciones Auxiliares
##  UPPER() // LOWER()
Transforman una string a uppercase o lowercase
``` sql
SELECT UPPER( p.nombre ), p.precio FROM producto p;
```


## ROUND() // FLOOR() // CEILING()
   - ROUND(): redondea de forma normal
   - FLOOR(): redondea hacia abajo siempre
   - CEILING(): redondea hacia arriba siempre

## MOAR MATES
   - COUNT(): cuenta el nº de ocurrencias
   - MAX(): muestra la ocurrencia más alta
   - MIN(): muestra la ocurrencia más baja
   - SUM(): suma todas las ocurrencias
   - AVG(): calcula la media de las ocurrencias

``` sql
SELECT 
    p.nombre as "nombre de producto", 
    p.precio as "euros", 
    ROUND( p.precio * 1.13, 2 ) as "dólares" 
  FROM producto p;
```

## TRUNCATE()
Redondea hasta un nº dado de decimales.
``` SQL
SELECT 
    p.nombre, 
    TRUNCATE( p.precio, 2 ) as "precio" 
  FROM producto p;
```

## CONCAT_WS()  
concatenar con espaciador.
Concatena una serie de datos separándolos con el separador
dado.
``` sql
SELECT 
    producto.nombre AS "Nombre",
    CONCAT_WS(" ", ROUND(producto.precio * 1.21), "€") AS "Precio Final" 
  FROM producto;
```