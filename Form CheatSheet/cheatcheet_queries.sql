# Comandos fantásticos de SQL y cómo usarlos:
# Author: Alejandro Pérez

##############################################################
# ========================= WHERE ========================= #
# Permite marcar condiciones que deben cumplir los resultados
# de la consulta.
#
# Disponemos de varios modificadores:
##############################################################
#   -'=':
#   -'<>': differente
#   -'<=':
#   -'>=':
#   -'<':
#   -'>':
##############################################################
#   - AND:
#   - OR:
#   - NOT:
##############################################################
# ==================== LIKE // NOT LIKE ==================== #
# Similar a los comparadores '=' y '<>' y casi siempre hacen 
# lo mismo.
# Permite búsqueda de patrones con wildcards
##############################################################
# ======================= WILDCARDS ======================= #
#   -'%': Represents zero or more characters  
#       -- bl% finds bl, black, blue, and blob
#   -'_': Represents a single character 
#       -- h_t finds hot, hat, and hit
#   -'[]': Represents any single character within the brackets 
#       -- h[oa]t finds hot and hat, but not hit
#   -'^': Represents any character not in the brackets 
#       -- h[^oa]t finds hit, but not hot and hat
#   -'-': Represents any single character within the specified range 
#       -- c[a-b]t finds cat and cbt
##############################################################
# ========================== IN() ========================== #
# Comprueba que la variable se encuentre dentro de un conjunto
# dado de elementos.
# Es lo mismo que decir var == 1 AND var == 2 AND ...
##############################################################
# ======================== BETWEEN ======================== #
# Comprueba que la variable se encuentre dentro de un rango
##############################################################
SELECT * FROM table_name
  WHERE condition1 OR condition2 AND NOT condition3 ...; 
  
SELECT DISTINCT  p.codigo_cliente as "Cliente"  FROM pago p
  WHERE p.fecha_pago LIKE "2008%";
  
SELECT * FROM cliente
  WHERE codigo_empleado_rep_ventas IN (11, 30, 23);

SELECT p.nombre FROM producto p
  WHERE p.precio BETWEEN 60 AND 200;
##############################################################





##############################################################
# ======================== ORDER BY ======================== #
# Ordena en base a una columna dada de forma ASC o DESC.
# Pueden concatenarse con una ','.
# Por defecto ordena de forma ascendente.
##############################################################
SELECT p.nombre
  FROM producto p
  ORDER BY 1 ASC, p.precio DESC;
##############################################################





##############################################################
# ======================== GROUP BY ======================== #
# Agrupa los resultados según los valores de una columna dada.
# Se suele usar junto con: 
#   - COUNT(): cuenta el nº de ocurrencias
#   - MAX(): muestra la ocurrencia más alta
#   - MIN(): muestra la ocurrencia más baja
#   - SUM(): suma todas las ocurrencias
#   - AVG(): calcula la media de las ocurrencias
##############################################################
# ========================= HAVING ========================= #
# El having es un where pero para la parte de agrupamientos.
# Los aliases del select se pueden usar en el having ya que 
# este se ejecuta después.
##############################################################
SELECT 
  MAX(p.precio) as precioMax, p.codigo_fabricante 
  FROM producto p 
  
  GROUP BY p.codigo_fabricante
  HAVING precioMax > 200;
##############################################################





##############################################################
# ========================= LIMIT ========================= #
# Devuelve las x primeras filas de una consulta
##############################################################
# Devuelve 2 filas empezando por la 3ºra
# Devuelve la fila cuatro y tres
##############################################################
SELECT * FROM fabricante f LIMIT 5;

SELECT * FROM fabricante f LIMIT 3,2;
##############################################################





##############################################################
# ========================== JOIN ========================== #
# Realiza un producto cartesiano de las tablas incluídas y 
# devuelve los valores en base a una cierta condición dada.
##############################################################
# Hay varios tipos:
#  - INNER JOIN: A∩B es la intersección de las dos tablas,
#       -- Returns records that have matching values in both 
#       -- tables                 
#  - LEFT JOIN: 1ra tabla y la intersección de las dos
#       -- Returns all records from the left table, and the 
#       -- matched records from the right table
#  - RIGHT JOIN: 2da tabla y la intersección de las dos
#       -- Returns all records from the right table, and the 
#       -- matched records from the left table
#  - FULL OUTER JOIN: A∪B es la unión de las dos tablas
#       -- Returns all records when there is a match in either 
#       -- left or right table
##############################################################
-- Devuelve el nº de productos <> que fabrica cada fabricante
SELECT f.nombre, COUNT(p.codigo) as "Nº Productos" FROM producto p
  INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
  GROUP BY f.nombre;

-- Devuelve el nombre de todos los clientes, y en el caso de
-- que tengan pedidos a su nombre, los muestra todos.
SELECT c.CustomerName, o.OrderID FROM Customers c
  LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
  ORDER BY c.CustomerName;

-- Devuelve el nombre de todos los clientes y el de todos los 
-- productos que han pedido, al igual que el nº de unidades
-- de cada producto.
SELECT 
    cliente.nombre_cliente as "Nombre Cliente", 
    producto.nombre as "Nombre Producto", 
    COUNT(producto.codigo_producto) as "Nº Productos"
  FROM cliente
  INNER JOIN pedido ON pedido.codigo_cliente = cliente.codigo_cliente
  INNER JOIN detalle_pedido dp ON dp.codigo_pedido = pedido.codigo_pedido
  INNER JOIN producto ON producto.codigo_producto = dp.codigo_producto
  GROUP BY cliente.nombre_cliente, producto.nombre 
  ORDER BY cliente.nombre_cliente, producto.nombre
##############################################################





##############################################################
# ========================= SELECT ========================= #
# Permite hacer consultas, hay mil ejemplos en este documento.
##############################################################
# Podemos realizar un select dentro de casi cualquier sitio 
# para realizar una subconsulta dentro de otra consulta.
#
# Se pueden hacer mil mierdas con esto y es una locura, por 
# ahora nos faltan cosas por ver.
#
# Una subconsulta dentro de un FROM tiene que llevar un alias,
# si se realiza en otro lugar no tiene porqué llevarlo.
##############################################################
-- Calcula el número de valores distintos de codigo_fabricante
-- que aparecen en la tabla productos.
-- Tiene que llevar un alias en este caso.
SELECT COUNT(*) as "Nº de Fabricantes"
  FROM ( SELECT DISTINCT p.codigo_fabricante FROM producto p ) c;

-- Cuenta el nº de productos fabricados por "Asus"
-- Se podría hacer esto mismo con un INNER JOIN
SELECT COUNT(codigo) as "Nº de productos de Asus" FROM producto
  WHERE codigo_fabricante = 
    ( SELECT codigo FROM fabricante WHERE nombre LIKE "Asus" );

-- Muestra los productos con precio superior a la media
SELECT p.nombre, p.precio, ROUND(p2.media, 2)
  FROM producto p, (SELECT AVG(precio) as media from producto) p2
  WHERE p.precio > p2.media;

  # 27. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. El listado debe mostrar el nombre de todos los fabricantes, es decir, si hay algún fabricante que no tiene productos con un precio superior o igual a 220€ deberá aparecer en el listado con un valor igual a 0 en el número de productos.
SELECT f.nombre as "Fabricante",  p1.numero as "Nº productos"
FROM fabricante f, 
    (SELECT 
      COUNT(codigo) as numero, 
      codigo_fabricante,
      precio
      FROM producto 
      WHERE precio >= 220
      GROUP BY codigo_fabricante
    ) p1
  WHERE f.codigo = p1.codigo_fabricante;
##############################################################





##############################################################
# =================== UPPER() // LOWER() =================== #
# Transforman una string a uppercase o lowercase
##############################################################
SELECT UPPER( p.nombre ), p.precio FROM producto p;
##############################################################





##############################################################
# ============ ROUND() // FLOOR() // CEILING() ============ #
#   - ROUND(): redondea de forma normal
#   - FLOOR(): redondea hacia abajo siempre
#   - CEILING(): redondea hacia arriba siempre
##############################################################
SELECT 
    p.nombre as "nombre de producto", 
    p.precio as "euros", 
    ROUND( p.precio * 1.13, 2 ) as "dólares" 
  FROM producto p;
##############################################################





##############################################################
# ======================= TRUNCATE() ======================= #
# Redondea hasta un nº dado de decimales.
##############################################################  
SELECT 
    p.nombre, 
    TRUNCATE( p.precio, 2 ) as "precio" 
  FROM producto p;
##############################################################





##############################################################
# ====================== CONCAT_WS() ====================== #
# concatenar con espaciador.
# Concatena una serie de datos separándolos con el separador
# dado.
##############################################################  
SELECT 
    producto.nombre AS "Nombre",
    CONCAT_WS(" ", ROUND(producto.precio * 1.21), "€") AS "Precio Final" 
  FROM producto;
##############################################################