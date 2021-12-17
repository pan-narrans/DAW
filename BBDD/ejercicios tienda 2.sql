# 1. Calcula el número total de productos que hay en la tabla productos.
SELECT COUNT(p.codigo)
  FROM producto p;


# 2. Calcula el número total de fabricantes que hay en la tabla fabricante.
SELECT COUNT(f.codigo)
  FROM fabricante f;


# 3. Calcula el número de valores distintos de código de fabricante aparecen en la tabla productos.

#############################################################
# Esto es trampa porque otros lenguajes no lo pillan
#############################################################
#SELECT COUNT(DISTINCT p.codigo_fabricante)
#  FROM producto p;
#############################################################

#############################################################
# Esto es la forma correcta de hacerlo, con subconsultas.
# La subconsulta en el FROM tiene que llevar un alias:
#     -> "consulta" en este caso
# Así es como funcionan las vistas.
#############################################################
SELECT COUNT(*) as "Nº de Fabricantes"
  FROM (
    SELECT DISTINCT p.codigo_fabricante
      FROM producto p
    ) consulta;


# 4. Calcula la media del precio de todos los productos.
SELECT ROUND(AVG(p.precio), 2) AS "Precio medio €"
  FROM producto p;


# 5. Calcula el precio más barato de todos los productos.
SELECT MAX(p.precio)
  FROM producto p;


# 6. Calcula el precio más caro de todos los productos.
SELECT MIN(p.precio)
  FROM producto p;


# 7. Lista el nombre y el precio del producto más barato.
SELECT p.nombre
  FROM producto p
  ORDER BY p.precio
  LIMIT 1;


# 8. Lista el nombre y el precio del producto más caro.
SELECT p.nombre
  FROM producto p
  ORDER BY p.precio DESC
  LIMIT 1;


# 9. Calcula la suma de los precios de todos los productos.
SELECT SUM(p.precio)
  FROM producto p;


# 10. Calcula el número de productos que tiene el fabricante Asus.
SELECT COUNT(p.codigo) as "Nº de productos de Asus"
  FROM producto p
  WHERE p.codigo_fabricante LIKE 1;


# 11. Calcula la media del precio de todos los productos del fabricante Asus.
SELECT ROUND(AVG(p.precio), 2) as "Precio medio Asus"
  FROM producto p
  WHERE p.codigo_fabricante LIKE 1;


# 12. Calcula el precio más barato de todos los productos del fabricante Asus.
SELECT MIN(p.precio) AS "Asus más barato"
  FROM producto p
  WHERE p.codigo_fabricante LIKE 1;


# 13. Calcula el precio más caro de todos los productos del fabricante Asus.
SELECT MAX(p.precio) AS "Asus más caro"
  FROM producto p
  WHERE p.codigo_fabricante LIKE 1;


# 14. Calcula la suma de todos los productos del fabricante Asus.
SELECT SUM(p.precio) AS "Suma precios Asus"
  FROM producto p
  WHERE p.codigo_fabricante LIKE 1;


#############################################################
# Lo mismo pero con una subconsulta para hacerlo con nombre y no código 
#############################################################

SELECT COUNT(codigo) as "Nº de productos de Asus"
  FROM producto
  WHERE codigo_fabricante = (
    SELECT codigo FROM fabricante
      WHERE nombre LIKE "Asus"
  );


# 15. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
SELECT 
  MAX(p.precio) AS "Max precio Crucial", 
  MIN(p.precio) AS "Min precio Crucial", 
  ROUND(AVG(p.precio),2) AS "Avg precio Crucial",
  COUNT(p.codigo) AS "Nº productos"

  FROM producto p
  WHERE p.codigo_fabricante LIKE 6;


# 16. Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir los fabricantes que no tienen ningún producto. El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene. Ordene el resultado descendentemente por el número de productos.

#############################################################
# Ejemplo de consulta a dos tablas
#############################################################

SELECT f.nombre as "Fabricante", COUNT(p.codigo) as "Productos"
  FROM producto p
  INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
  GROUP BY f.nombre;


# 17. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. El resultado mostrará el nombre del fabricante junto con los datos que se solicitan.
SELECT 
  f.nombre AS "Fabricante",
  MAX(p.precio) AS "Max precio", 
  MIN(p.precio) AS "Min precio", 
  ROUND(AVG(p.precio),2) AS "Avg precio"

  FROM producto p
  INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
  GROUP BY f.nombre;


# 18. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. No es necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
SELECT 
  f.nombre AS "Fabricante",
  MAX(p.precio) AS "Max precio", 
  MIN(p.precio) AS "Min precio", 
  ROUND(AVG(p.precio),2) AS Avg_precio

  FROM producto p
  INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo

  GROUP BY f.nombre
  HAVING Avg_precio > 200;


## Sacar productos cuyo precio está por encima de la media de todos los productos
SELECT p.nombre, p.precio
  FROM producto p
  WHERE p.precio > (
    SELECT Avg(p1.precio) FROM producto p1
  );

## Lo mismo pero mostrando la media
#############################################################
# AVG saca un único valor, para mostrar la media a la par que todos los registros tenemos que hacer el producto cartesiano de nuestra tabla con otra conteniendo solo la media.
# Esto se hace con una subconsulta desde el FROM (tiene que llevar un alias sí o sí).
#############################################################
SELECT p.nombre, p.precio, ROUND(p2.media, 2)
  FROM producto p, (SELECT AVG(precio) as media from producto) p2
  WHERE p.precio > (
    SELECT Avg(p1.precio) FROM producto p1
  );



# 19. Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. Es necesario mostrar el nombre del fabricante.
SELECT 
  f.nombre AS "Fabricante",
  MAX(p.precio) AS "Max precio", 
  MIN(p.precio) AS "Min precio", 
  ROUND(AVG(p.precio),2) AS Avg_precio

  FROM producto p
  INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo

  GROUP BY f.nombre
  HAVING Avg_precio > 200;


# 20. Calcula el número de productos que tienen un precio mayor o igual a 180€.
SELECT COUNT(codigo) FROM producto
  WHERE precio >= 180;


# 21. Calcula el número de productos que tiene cada fabricante con un precio mayor o igual a 180€.
SELECT 
  f.nombre as "Fabricante",
  COUNT(p.codigo) as "Nº productos" 

  FROM producto p  
  INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo

  WHERE precio >= 180
  GROUP BY codigo_fabricante;


# 22. Lista el precio medio los productos de cada fabricante, mostrando solamente el código del fabricante.
SELECT 
  p.codigo_fabricante as "Fabricante",
  ROUND(AVG(p.precio), 2) as "Precio medio del producto" 
  
  FROM producto p

  GROUP BY codigo_fabricante;


# 23. Lista el precio medio los productos de cada fabricante, mostrando solamente el nombre del fabricante.
SELECT 
  f.nombre as "Fabricante",
  ROUND(AVG(p.precio), 2) as "Precio medio del producto" 
  
  FROM producto p
  INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo

  GROUP BY codigo_fabricante;


# 24. Lista los nombres de los fabricantes cuyos productos tienen un precio medio mayor o igual a 150€.
SELECT
  f.nombre as "Fabricante"

  FROM fabricante f

  WHERE ( 
    SELECT AVG(precio) 
      FROM producto 
      GROUP BY codigo_fabricante 
      HAVING codigo_fabricante = f.codigo
  ) >= 150;


# 25. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
SELECT 
  f.nombre as "Fabricante" 
  FROM fabricante f

  WHERE (
    SELECT COUNT(codigo) 
      FROM producto 
      WHERE codigo_fabricante = f.codigo 
  ) > 1;


# 26. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. No es necesario mostrar el nombre de los fabricantes que no tienen productos que cumplan la condición.
SELECT
  f.nombre as "Fabricante", 
  p1.numero as "Nº productos"

  FROM 
    fabricante f, 
    (SELECT 
      COUNT(codigo) as numero, 
      codigo_fabricante,
      precio
      FROM producto 
      WHERE precio >= 220
      GROUP BY codigo_fabricante
    ) p1
  
  WHERE f.codigo = p1.codigo_fabricante;



# 27. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. El listado debe mostrar el nombre de todos los fabricantes, es decir, si hay algún fabricante que no tiene productos con un precio superior o igual a 220€ deberá aparecer en el listado con un valor igual a 0 en el número de productos.
SELECT
  f.nombre as "Fabricante", 
  p1.numero as "Nº productos"

  FROM 
    fabricante f, 
    (SELECT 
      COUNT(codigo) as numero, 
      codigo_fabricante,
      precio
      FROM producto 
      WHERE precio >= 220
      GROUP BY codigo_fabricante
    ) p1
  
  WHERE f.codigo = p1.codigo_fabricante;


# 28. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €.


# 29. Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante. El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.



#############################################################
# Insertar datos con un SELECT
#############################################################

CREATE TABLE fabricante_productos(
  numero_fabricante INT,
  numero_producto INT,
  precio DOUBLE,
  
  PRIMARY KEY (numero_fabricante, numero_producto)
);

INSERT INTO fabricante_productos(numero_fabricante, numero_producto, precio)
SELECT P.codigo_fabricante, P.codigo, P.precio FROM PRODUCTO P;
