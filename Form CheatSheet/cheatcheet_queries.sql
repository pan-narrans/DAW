


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
SELECT * 
  FROM fabricante f 
  LIMIT 5;
##############################################################
# Devuelve 2 filas empezando por la 3ºra
# Devuelve la fila cuatro y tres
##############################################################
SELECT * 
  FROM fabricante f 
  LIMIT 3,2;
##############################################################



##############################################################
# ======================= INNER JOIN ======================= #
#
##############################################################
SELECT
##############################################################



##############################################################
# ========================= SELECT ========================= #
# Permite hacer consultas, hay mil ejemplos en este documento.
##############################################################
# Podemos realizar un select dentro de casi cualquier sitio 
# para realizar una subconsulta.
##############################################################
-- Calcula el número de valores distintos de codigo_fabricante
-- que aparecen en la tabla productos.
-- Tiene que llevar un alias en este caso.
SELECT COUNT(*) as "Nº de Fabricantes"
  FROM ( SELECT DISTINCT p.codigo_fabricante FROM producto p ) c;
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