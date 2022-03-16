# Queries en SQL

```cmd
    @author: Alejandro Pérez
```

- [Queries en SQL](#queries-en-sql)
  - [**SELECT**](#select)
    - [Subconsultas](#subconsultas)
    - [Ejemplos](#ejemplos)
  - [**JOIN**](#join)
    - [Tipos de **`JOIN`**](#tipos-de-join)
    - [Ejemplos](#ejemplos-1)
    - [Ejemplo **`JOIN`** con Subconsulta](#ejemplo-join-con-subconsulta)
  - [**UNION**](#union)
  - [**WHERE**](#where)
    - [Modificadores lógicos](#modificadores-lógicos)
    - [**LIKE** // **NOT LIKE**](#like--not-like)
    - [**IN**( )](#in-)
    - [**BETWEEN** . **AND**](#between--and)
    - [**EXISTS**](#exists)
    - [**ALL** // **ANY**](#all--any)
  - [**GROUP BY**](#group-by)
    - [**HAVING**](#having)
  - [**ORDER BY**](#order-by)
  - [Otras Funciones](#otras-funciones)
    - [**LIMIT**](#limit)
    - [Matemáticas](#matemáticas)
      - [Redondeo de valores](#redondeo-de-valores)
      - [Cálculo con **MAX**, **MIN**, **SUM**, **AVG** y **COUNT**](#cálculo-con-max-min-sum-avg-y-count)
    - [Cadenas](#cadenas)
      - [**UPPER()** y **LOWER()**](#upper-y-lower)
      - [**CONCAT_WS()**](#concat_ws)
      - [WILDCARDS (para búsqueda de cadenas)](#wildcards-para-búsqueda-de-cadenas)

<!--..%%%%...%%%%%%..%%......%%%%%%...%%%%...%%%%%%.-->
<!--.%%......%%......%%......%%......%%..%%....%%...-->
<!--..%%%%...%%%%....%%......%%%%....%%........%%...-->
<!--.....%%..%%......%%......%%......%%..%%....%%...-->
<!--..%%%%...%%%%%%..%%%%%%..%%%%%%...%%%%.....%%...-->
## **SELECT**

Permite hacer consultas, hay mil ejemplos en este documento.

### Subconsultas

Podemos realizar un select dentro de casi cualquier sitio para realizar una subconsulta dentro de otra consulta. Se pueden anidar de esta forma varias consultas una dentro de otra.

Se pueden hacer mil mierdas con esto y es un poco locura.

> Son **poco eficientes** 🙊
>
> Si podemos evitar hacer una subconsulta, lo evitamos y usamos **JOIN** donde se pueda, que es más eficiente.

---

Una subconsulta dentro de un **FROM** tiene que llevar un alias, si se realiza en otro lugar no tiene porqué llevarlo.

``` sql
-- Calcula el número de valores distintos de codigo_fabricante que aparecen en la tabla productos.
-- BBDD 1-1 (tienda)
SELECT COUNT(*) as "Nº de Fabricantes" FROM 
  (SELECT DISTINCT p.codigo_fabricante FROM producto p) c;
```

---

Pueden hacerse subconsultas con campos de la consulta madre, a esto se le llama consultas co-relacionadas.

~~(culturilla y ya 😬)~~

---

### Ejemplos

``` sql
-- Muestra los productos con precio superior a la media
-- Como se hace desde el FROM, tiene un alias
-- BBDD 1-1 (tienda)
SELECT p.nombre, p.precio, ROUND(p2.media, 2)
  FROM producto p, (SELECT AVG(precio) as media from producto) p2
  WHERE p.precio > p2.media;
```

Dentro de un JOIN:

``` sql
-- Devuelve los nombres de los fabricantes y el nº de productos que tiene cada uno con un precio superior o igual a 220 €.
-- BBDD 1-1 (tienda)
SELECT f.nombre as "Fabricante", COALESCE(p1.numero, 0) as "Nº productos" FROM fabricante f 
  LEFT JOIN (SELECT COUNT(*) as numero, codigo_fabricante, precio
            FROM producto WHERE precio >= 220
            GROUP BY codigo_fabricante ) p1  
  ON f.codigo = p1.codigo_fabricante;
```

Con NOT IN:

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
## **JOIN**

Realiza un producto cartesiano de las tablas incluidas y devuelve los valores en base a una cierta condición dada que es la que marca la unión de las tablas.

### Tipos de **`JOIN`**

| Tipo             | Comportamiento                         | Resultado                                                                     |
| ---------------- | -------------------------------------- | ----------------------------------------------------------------------------- |
| **`INNER JOIN`** | "A∩B" Intersección de dos tablas       | Records that have matching values in both tables                              |
| **`LEFT JOIN`**  | 1ra tabla y la intersección de las dos | All records from the left table, and the matched records from the right table |
| **`RIGHT JOIN`** | 2da tabla y la intersección de las dos | All records from the right table, and the matched records from the left table |

### Ejemplos

``` sql
-- Devuelve el nombre de todos los clientes, y en el caso de que tengan pedidos a su nombre, los muestra todos.
SELECT c.CustomerName, o.OrderID FROM Customers c
  LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
  ORDER BY c.CustomerName;
```

Se pueden concatenar sin problemas.
De esta forma podemos "saltar" de tabla en tabla.

```sql
-- Devuelve el nombre de todos los clientes y el de todos los productos que han pedido, al igual que el nº de unidades de cada producto.
-- BBDD 1-4 (jardinería)
SELECT 
    cliente.nombre_cliente as "Nombre Cliente", 
    producto.nombre as "Nombre Producto", 
    COUNT(producto.codigo_producto) as "Nº Productos"
  FROM cliente

  INNER JOIN pedido pe1 ON pedido.codigo_cliente = cliente.codigo_cliente
  INNER JOIN detalle_pedido dp ON dp.codigo_pedido = pedido.codigo_pedido
  INNER JOIN producto ON producto.codigo_producto = dp.codigo_producto

  GROUP BY cliente.nombre_cliente, producto.nombre 
  ORDER BY cliente.nombre_cliente, producto.nombre;
```

### Ejemplo **`JOIN`** con Subconsulta

El enunciado:

``` sql
-- Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
-- BBDD 1-4 (jardinería)
```

Con **`JOIN`**`s:

``` sql
SELECT ofi1.codigo_oficina, ofi1.ciudad FROM oficina ofi1
  -- Sacamos los que tienen frutales y nos aseguramos de no coger esos
  WHERE ofi1.codigo_oficina NOT IN (
    SELECT  emp1.codigo_oficina FROM empleado emp1
    INNER JOIN cliente cli1 ON cli1.codigo_empleado_rep_ventas = emp1.codigo_empleado
    INNER JOIN pedido ped1 ON ped1.codigo_cliente = cli1.codigo_cliente
    INNER JOIN detalle_pedido det1 ON det1.codigo_pedido = ped1.codigo_pedido
    INNER JOIN producto prod1 ON prod1.codigo_producto = det1.codigo_producto
    WHERE UPPER(prod1.gama) LIKE "FRUTALES" )
  GROUP BY ofi1.codigo_oficina
  ORDER BY 1;
```

El enunciado anterior se podría resolver únicamente con subconsultas. Es más lioso y menos eficiente, pero nos pueden pedir hacerlo en un examen 🤷‍♂️
> ⛔ Recordamos que esta forma de resolverlo es terriblemente ineficiente y debe de hacerse con **`INNER JOIN`**`s.

``` sql
SELECT ofi1.codigo_oficina, ofi1.ciudad FROM oficina ofi1
  WHERE ofi1.codigo_oficina NOT IN (
  SELECT emp1.codigo_oficina FROM empleado emp1  
  WHERE emp1.codigo_empleado IN(
    SELECT cli1.codigo_empleado_rep_ventas FROM cliente cli1 
    WHERE cli1.codigo_cliente IN(
      SELECT ped1.codigo_cliente FROM pedido ped1
      WHERE ped1.codigo_pedido IN(
        SELECT det1.codigo_pedido FROM detalle_pedido det1
        WHERE det1.codigo_producto IN(
          SELECT prod1.codigo_producto FROM producto prod1
          WHERE UPPER(prod1.gama) LIKE "FRUTALES" ) ) ) ) )
  ORDER BY 1;
```

<!--.%%..%%..%%..%%..%%%%%%...%%%%...%%..%%.-->
<!--.%%..%%..%%%.%%....%%....%%..%%..%%%.%%.-->
<!--.%%..%%..%%.%%%....%%....%%..%%..%%.%%%.-->
<!--.%%..%%..%%..%%....%%....%%..%%..%%..%%.-->
<!--..%%%%...%%..%%..%%%%%%...%%%%...%%..%%.-->
## **UNION**

Permite unir los resultados de dos o más consultas **`SELECT`** en una sola tabla.

Para unir más de dos **`SELECT`** únicamente tenemos que concatenar los **`UNION`** uno detrás de otro.

**Requisitos:**

- las dos consultas tienen que tener el mismo nº de columnas
- las columnas tienen que tener un tipo de datos similar
- las columnas tienen que estar en el mismo orden

``` sql
-- Devuelve los clientes y comerciales que no tienen ningún producto relacionado.
-- BBDD 1-3 (ventas)
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
## **WHERE**

Marca condiciones que deben cumplir los resultados de la consulta. Permite hacer criba de los datos de las tablas.

### Modificadores lógicos

<table>
<tr><th/><th/></tr>
<tr><td>

|   Símbolo   | Significado      |
| :---------: | ---------------- |
|     `=`     | igual            |
| `<>` / `!=` | diferente        |
|     `<`     | inferior         |
|     `>`     | superior         |
|    `<=`     | inferior o igual |
|    `>=`     | superior o igual |

</td><td>

| Símbolo | Significado |
| :-----: | ----------- |
|  `AND`  | and lógico  |
|  `OR`   | or lógico   |
|  `NOT`  | negación    |

</td></tr>
</table>

``` sql
SELECT * FROM table_name
  WHERE condition1 OR condition2 AND NOT condition3 ...; 
```

### **LIKE** // **NOT LIKE**

Similar a los comparadores `=` y `<>`, se usan para comparar cadenas.

Permite búsqueda de patrones con wildcards.

``` sql
SELECT DISTINCT  p.codigo_cliente as "Cliente"  FROM pago p
  WHERE p.fecha_pago LIKE "2008%";
```  

### **IN**( )

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

### **BETWEEN** . **AND**

Comprueba que la variable se encuentre dentro de un rango

``` sql
SELECT p.nombre FROM producto p
  WHERE p.precio BETWEEN 60 AND 200;
```

<!--.%%%%%%..%%..%%..%%%%%%...%%%%...%%%%%%...%%%%..-->
<!--.%%.......%%%%.....%%....%%........%%....%%.....-->
<!--.%%%%......%%......%%.....%%%%.....%%.....%%%%..-->
<!--.%%.......%%%%.....%%........%%....%%........%%.-->
<!--.%%%%%%..%%..%%..%%%%%%...%%%%.....%%.....%%%%..-->
### **EXISTS**

Comprueba si existe el dato comprobado.

Lo podemos usar para comprobar si una subconsulta ha devuelto
algún resultado.

``` sql
-- Devuelve los nombres de los fabricantes que tienen productos asociados.
-- BBDD 1-1 (tienda)
SELECT * FROM fabricante f1 WHERE EXISTS 
  (SELECT * FROM producto p1 
  WHERE p1.codigo_fabricante = f1.codigo);
```

``` sql
-- Devuelve los nombres de los fabricantes que no tienen productos asociados.
-- BBDD 1-1 (tienda)
SELECT * FROM fabricante f1 WHERE NOT EXISTS 
  (SELECT * FROM producto p1 WHERE p1.codigo_fabricante = f1.codigo);
```

<!--..%%%%...%%......%%..........%%%%...%%..%%..%%..%%.-->
<!--.%%..%%..%%......%%.........%%..%%..%%%.%%...%%%%..-->
<!--.%%%%%%..%%......%%.........%%%%%%..%%.%%%....%%...-->
<!--.%%..%%..%%......%%.........%%..%%..%%..%%....%%...-->
<!--.%%..%%..%%%%%%..%%%%%%.....%%..%%..%%..%%....%%...-->
### **ALL** // **ANY**

Nos permite comprobar si de un grupo de elementos (obtenido a partir de una subconsulta) todos o alguno de ellos cumple una condición.

---

Devuelve `true` si se cumple la condición marcada al comparar con **todos** los elementos.

``` sql
-- Devuelve el nombre del departamento con menor presupuesto y la cantidad que tiene asignada.
-- BBDD 1-2 (empleados)
SELECT dep.nombre, dep.presupuesto FROM departamento dep
  WHERE dep.presupuesto <= ALL 
  (SELECT dep.presupuesto FROM departamento dep);
```

Devuelve `true` si se cumple la condición marcada con **al menos uno** de los elementos.

``` sql
-- Devuelve los nombres de los departamentos que tienen empleados asociados.
-- BBDD 1-2 (empleados)
SELECT dep.nombre FROM departamento dep
  WHERE dep.codigo = ANY 
  (SELECT emp.codigo_departamento FROM empleado emp);
```

<!--..%%%%...%%%%%....%%%%...%%..%%..%%%%%......%%%%%...%%..%%.-->
<!--.%%......%%..%%..%%..%%..%%..%%..%%..%%.....%%..%%...%%%%..-->
<!--.%%.%%%..%%%%%...%%..%%..%%..%%..%%%%%......%%%%%.....%%...-->
<!--.%%..%%..%%..%%..%%..%%..%%..%%..%%.........%%..%%....%%...-->
<!--..%%%%...%%..%%...%%%%....%%%%...%%.........%%%%%.....%%...-->

## **GROUP BY**

Agrupa los resultados según los valores de una columna dada.
Se suele usar junto con funciones que nos agrupan varios valores en uno solo.

Tales como:

- **`COUNT()`** : cuenta el nº de ocurrencias
- **`MAX()`** : muestra la ocurrencia más alta
- **`MIN()`** : muestra la ocurrencia más baja
- **`SUM()`** : suma todas las ocurrencias
- **`AVG()`** : calcula la media de las ocurrencias

Para evitar que la consulta nos devuelva un único valor realizamos un **`GROUP BY`** por el valor por el cual nos interesa diferenciar.

```sql
-- Devuelve el número de empleados que hay en cada departamento.
-- BBDD 1-2 (empleados)
SELECT dep.nombre, COUNT(emp.codigo) FROM empleado emp
  INNER JOIN departamento dep ON emp.codigo_departamento = dep.codigo
  GROUP BY dep.nombre;
```

> En este caso el **`COUNT`** nos contaría a priori el nº total de empleados.
>
> Al agrupar por departamento, lo que hace es contar el nº de empleados por departamento.

### **HAVING**

El having es un **`WHERE`** pero para la parte de agrupamientos. Es menos eficiente por lo que debe usarse únicamente cuando sea necesario.

Los aliases del **`SELECT`** se pueden usar en el **`HAVING`** ya que este se ejecuta después. Recordamos que en el **`WHERE`** no se podían usar ya que este se ejecutaba antes.

``` sql
-- BBDD 1-1 (tienda)
SELECT 
  MAX(p.precio) as precioMax, p.codigo_fabricante 
  FROM producto p 
  
  GROUP BY p.codigo_fabricante
  HAVING precioMax > 200;
```

<!--..%%%%...%%%%%...%%%%%...%%%%%%..%%%%%......%%%%%...%%..%%.-->
<!--.%%..%%..%%..%%..%%..%%..%%......%%..%%.....%%..%%...%%%%..-->
<!--.%%..%%..%%%%%...%%..%%..%%%%....%%%%%......%%%%%.....%%...-->
<!--.%%..%%..%%..%%..%%..%%..%%......%%..%%.....%%..%%....%%...-->
<!--..%%%%...%%..%%..%%%%%...%%%%%%..%%..%%.....%%%%%.....%%...-->

## **ORDER BY**

Ordena en base a una columna dada de forma ASC o DESC.
Pueden concatenarse con una "`,`" .
Por defecto ordena de forma ascendente.

``` sql
SELECT p.nombre
  FROM producto p
  ORDER BY 1 ASC, p.precio DESC;
```

## Otras Funciones

### **LIMIT**

Devuelve las 5 primeras filas:

``` sql
-- BBDD 1-1 (tienda)
SELECT * FROM fabricante f LIMIT 5;
```

Devuelve dos filas empezando por la 3ºa, devuelve entonces las filas cuatro y tres:

``` sql
-- BBDD 1-1 (tienda)
SELECT * FROM fabricante f LIMIT 3,2;
```

### Matemáticas

#### Redondeo de valores

| Comando      | Comportamiento                       |
| ------------ | ------------------------------------ |
| `ROUND()`    | redondea de forma normal             |
| `FLOOR()`    | redondea hacia abajo siempre         |
| `CEILING()`  | redondea hacia arriba siempre        |
| `TRUNCATE()` | trunca hasta un nº dado de decimales |

``` SQL
SELECT 
    p.nombre, 
    TRUNCATE( p.precio, 2 ) as "precio" 
  FROM producto p;
```

#### Cálculo con **MAX**, **MIN**, **SUM**, **AVG** y **COUNT**

Agrupan los resultados de la consulta en un único valor. Por esta razón se suelen usan junto con el [**`GROUP BY`**](#group-by).

| Comando   | Comportamiento                      |
| --------- | ----------------------------------- |
| `COUNT()` | cuenta el nº de ocurrencias         |
| `MAX()`   | muestra la ocurrencia más alta      |
| `MIN()`   | muestra la ocurrencia más baja      |
| `SUM()`   | suma todas las ocurrencias          |
| `AVG()`   | calcula la media de las ocurrencias |

``` sql
SELECT 
    p.nombre as "nombre de producto", 
    p.precio as "euros", 
    ROUND( p.precio * 1.13, 2 ) as "dólares" 
  FROM producto p;
```

### Cadenas

#### **UPPER()** y **LOWER()**

Transforman una string a uppercase o lowercase.

> Lo usamos principalmente para comparar strings sin preocuparnos por la capitalización de los datos.

``` sql
SELECT UPPER( p.nombre ), p.precio FROM producto p;
```

#### **CONCAT_WS()**

Concatena una serie de datos separándolos con el separador
dado.

``` sql
SELECT 
  p.nombre AS "Nombre",
  CONCAT_WS(" ", ROUND(p.precio * 1.21), "€") AS "Precio" 
  FROM producto p;
```

#### WILDCARDS (para búsqueda de cadenas)

| Symbol | Explicación                                      | Ejemplo                                  |
| :----: | ------------------------------------------------ | ---------------------------------------- |
|  `%`   | Zero or more characters.                         | `bl%` finds bl, black, blue, and blob    |
|  `_`   | A single character.                              | `h_t` finds hot, hat, and hit            |
|  `[]`  | Any single character within the brackets.        | `h[oa]t` finds hot and hat, but not hit  |
|  `^`   | Any character not in the brackets.               | `h[^oa]t` finds hit, but not hot and hat |
|  `_`   | Any single character within the specified range. | `c[a-b]t` finds cat and cbt              |

Ejemplillos:

```sql
-- Devuelve todas las ciudades empezando por cualquier letra y acabando en "ondon".
SELECT * FROM Customers
WHERE City LIKE '_ondon';
```

```sql
-- Devuelve todas las ciudades que empiezan por "b", "s" o "p".
SELECT * FROM Customers
WHERE City LIKE '[bsp]%';
```
