# 1. Lista el nombre de todos los productos que hay en la tabla producto.
SELECT p.nombre FROM producto p;


# 2. Lista los nombres y los precios de todos los productos de la tabla producto.
SELECT p.nombre, p.precio FROM producto p;


# 3. Lista todas las columnas de la tabla producto.
SELECT * FROM producto p;


# 4. Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD).
SELECT p.nombre, p.precio, ROUND( p.precio * 1.13, 2) FROM producto p;


# 5. Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD). Utiliza los siguientes alias para las columnas: nombre de producto, euros, dólares.
SELECT 
    p.nombre as "nombre de producto", 
    p.precio as "euros", 
    ROUND( p.precio * 1.13, 2 ) as "dólares" 
  FROM producto p;


# 6. Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a mayúscula.
SELECT UPPER( p.nombre ), p.precio FROM producto p;


# 7. Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a minúscula.
SELECT LOWER( p.nombre ), p.precio FROM producto p;


# 8. Lista el nombre de todos los fabricantes en una columna, y en otra columna obtenga en mayúsculas los dos primeros caracteres del nombre del fabricante.
SELECT p.nombre, UPPER( SUBSTRING(p.nombre, 1, 2) ) FROM producto p;


# 9. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT p.nombre, ROUND( p.precio ) as "precio" FROM producto p;


# 10. Lista los nombres y los precios de todos los productos de la tabla producto, truncando el valor del precio para mostrarlo sin ninguna cifra decimal.
SELECT p.nombre, TRUNCATE( p.precio, 2 ) as "precio" FROM producto p;


# 11. Lista el código de los fabricantes que tienen productos en la tabla producto.
SELECT DISTINCT p.codigo_fabricante FROM producto p;


# 12. Lista el código de los fabricantes que tienen productos en la tabla producto, eliminando los códigos que aparecen repetidos.
SELECT DISTINCT p.codigo_fabricante FROM producto p;


# 13. Lista los nombres de los fabricantes ordenados de forma ascendente.
SELECT f.nombre
  FROM fabricante f
  ORDER by 1 ASC;


# 14. Lista los nombres de los fabricantes ordenados de forma descendente.
SELECT f.nombre
  FROM fabricante f
  ORDER by 1 DESC;


# 15. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
SELECT p.nombre
  FROM producto p
  ORDER BY 1 ASC, p.precio DESC;


# 16. Devuelve una lista con las 5 primeras filas de la tabla fabricante.
SELECT * 
  FROM fabricante f 
  LIMIT 5;


# 17. Devuelve una lista con 2 filas a partir de la cuarta fila de la tabla fabricante. La cuarta fila también se debe incluir en la respuesta.
SELECT * 
  FROM fabricante f 
  LIMIT 3,2;


# 18. Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT p.nombre, p.precio
  FROM producto p
  ORDER BY 1 ASC
  LIMIT 1;


# 19. Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT p.nombre, p.precio
  FROM producto p
  ORDER BY 1 DESC
  LIMIT 1;


#############################################################
# Nos muestra el código correcto porque los tenemos agrupados.
# El having es un where pero para la parte de agrupamientos.
# Los aliases del select se pueden usar en el having ya que este se ejecuta después.
#############################################################

SELECT 
  MAX(p.precio) as precioMax, p.codigo_fabricante 
  FROM producto p 
  
  GROUP BY p.codigo_fabricante
  HAVING precioMax > 200;

#############################################################
#############################################################


#############################################################
# Count nos permite contar cuantas ocurrencias de una columa aparecen.
# Ponemos * aquí porque en este caso nos da igual lo que cuente.
#############################################################

SELECT 
  COUNT(*) AS cuenta, p.codigo_fabricante
  FROM producto p
  GROUP BY p.codigo_fabricante;

#############################################################
#############################################################


# 20. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
SELECT p.nombre 
  FROM producto p 
  WHERE p.codigo_fabricante LIKE 2;


# 21. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
SELECT p.nombre 
  FROM producto p
  WHERE p.precio <= 120;


# 22. Lista el nombre de los productos que tienen un precio mayor o igual a 400€.
SELECT p.nombre 
  FROM producto p
  WHERE p.precio >= 400;


# 23. Lista el nombre de los productos que no tienen un precio mayor o igual a 400€.
SELECT p.nombre 
  FROM producto p
  WHERE NOT p.precio >= 400;


# 24. Lista todos los productos que tengan un precio entre 80€ y 300€. Sin utilizar el operador BETWEEN.
SELECT p.nombre 
  FROM producto p
  WHERE p.precio > 80 AND p.precio < 300;


# 25. Lista todos los productos que tengan un precio entre 60€ y 200€. Utilizando el operador BETWEEN.
SELECT p.nombre 
  FROM producto p
  WHERE p.precio BETWEEN 60 AND 200;


# 26. Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
SELECT p.nombre 
  FROM producto p
  WHERE p.precio > 200 AND p.codigo_fabricante LIKE 6;


# 27. Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Sin utilizar el operador IN.


# 28. Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN.


# 29. Lista el nombre y el precio de los productos en céntimos (Habrá que multiplicar por 100 el valor del precio). Cree un alias para la columna que contiene el precio que se llame céntimos.


# 30. Lista los nombres de los fabricantes cuyo nombre empiece por la letra S.


# 31. Lista los nombres de los fabricantes cuyo nombre termine por la vocal e.


# 32. Lista los nombres de los fabricantes cuyo nombre contenga el carácter w.


# 33. Lista los nombres de los fabricantes cuyo nombre sea de 4 caracteres.


# 34. Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre.


# 35. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.


# 36. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).