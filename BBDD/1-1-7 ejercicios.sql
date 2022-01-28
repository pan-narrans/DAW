-- 1.1.7 Subconsultas (En la cláusula WHERE)



-- ##############################################
-- 1.1.7.1 Con operadores básicos de comparación
-- ##############################################

-- 1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT p1.nombre AS "Productos de Lenovo" FROM producto p1
  WHERE p1.codigo_fabricante = 
    (SELECT fab.codigo FROM fabricante fab 
    WHERE UPPER(fab.nombre) LIKE "LENOVO")
;

-- 2. Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT * FROM producto p1
  WHERE p1.precio = 
    (SELECT MAX(p2.precio) FROM producto p2
    WHERE p2.codigo_fabricante = 
      (SELECT f1.codigo FROM fabricante f1 
      WHERE UPPER(f1.nombre) LIKE "LENOVO"))
;

-- 3. Lista el nombre del producto más caro del fabricante Lenovo.
SELECT p1.nombre AS "Producto más caro de Lenovo" FROM producto p1
  WHERE p1.codigo_fabricante = 
    (SELECT f1.codigo FROM fabricante f1 
    WHERE UPPER(f1.nombre) LIKE "LENOVO")
  ORDER BY p1.precio DESC LIMIT 1
;

-- 4. Lista el nombre del producto más barato del fabricante Hewlett-Packard.
SELECT p1.nombre AS "Producto más barato de Hewlett-Packard" 
  FROM producto p1
  WHERE p1.codigo_fabricante = 
    (SELECT f1.codigo FROM fabricante f1 
    WHERE UPPER(f1.nombre) LIKE "HEWLETT-PACKARD")
  ORDER BY p1.precio ASC LIMIT 1
;

-- 5. Devuelve todos los productos de la base de datos que tienen un precio mayor o igual al producto más caro del fabricante Lenovo.
SELECT p1.nombre as "Productos => caros que el producto más caro de Lenovo" FROM producto p1
  WHERE p1.precio >= 
    (SELECT MAX(p2.precio) FROM producto p2
    WHERE p2.codigo_fabricante = 
      (SELECT f1.codigo FROM fabricante f1 
      WHERE UPPER(f1.nombre) LIKE "LENOVO"))
;

-- 6. Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.
SELECT p1.nombre AS "Productos de Asus con precio superior a la media" FROM producto p1
  WHERE p1.codigo_fabricante = 
    (SELECT fab.codigo FROM fabricante fab 
    WHERE UPPER(fab.nombre) LIKE "ASUS")
    AND p1.precio >
    (SELECT AVG(p2.precio) FROM producto p2
    WHERE p2.codigo_fabricante = 
      (SELECT fab.codigo FROM fabricante fab 
      WHERE UPPER(fab.nombre) LIKE "ASUS"))
;



-- ##############################################
-- 1.1.7.4 Subconsultas con EXISTS y NOT EXISTS
-- ##############################################

-- 14. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).
SELECT * FROM fabricante f1 WHERE EXISTS 
  (SELECT * FROM producto p1 WHERE p1.codigo_fabricante = f1.codigo);

-- 15. Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando EXISTS o NOT EXISTS)
SELECT * FROM fabricante f1 WHERE NOT EXISTS 
  (SELECT * FROM producto p1 WHERE p1.codigo_fabricante = f1.codigo);

