SELECT C1.*, C2.mas_caro, C2.precio_mas_caro FROM
	(SELECT 
		f1.codigo, f1.nombre, 
    p1.nombre as "mas barato", 
    p1.precio as "precio mas barato"
    FROM fabricante f1
    
    INNER JOIN producto p1 ON p1.codigo_fabricante = f1.codigo
    WHERE p1.precio = (SELECT MIN(producto.precio) FROM producto WHERE producto.codigo_fabricante = p1.codigo_fabricante)
    GROUP BY 1) AS C1,
  
  (SELECT 
	  p1.codigo_fabricante, 
    p1.nombre as "mas_caro",
    p1.precio as "precio_mas_caro"  
    FROM producto p1
      
    WHERE p1.precio = (SELECT MAX(producto.precio) FROM producto WHERE producto.codigo_fabricante = p1.codigo_fabricante)
    GROUP BY 1) AS C2
  
  WHERE C1.codigo = C2.codigo_fabricante
  ORDER BY 1;




DROP VIEW IF EXISTS VProdFabMin;
CREATE VIEW VProdFabMin AS
SELECT 
  f1.codigo, f1.nombre, 
  p1.nombre as "mas barato", 
  p1.precio as "precio mas barato"
  FROM fabricante f1
  
  INNER JOIN producto p1 ON p1.codigo_fabricante = f1.codigo
  WHERE p1.precio = (SELECT MIN(producto.precio) FROM producto WHERE producto.codigo_fabricante = p1.codigo_fabricante)
  GROUP BY 1; 

DROP VIEW IF EXISTS VProdFabMax;
CREATE VIEW VProdFabMax AS
SELECT 
  p1.codigo_fabricante,
  p1.nombre as "mas_caro",
  p1.precio as "precio_mas_caro"  
  FROM producto p1
    
  WHERE p1.precio = (SELECT MAX(producto.precio) FROM producto WHERE producto.codigo_fabricante = p1.codigo_fabricante)
  GROUP BY p1.codigo_fabricante;

DROP VIEW IF EXISTS cosa;
CREATE VIEW cosa AS
SELECT * FROM VProdFabMin, VProdFabMax
WHERE VProdFabMax.codigo_fabricante = VProdFabMin.codigo;