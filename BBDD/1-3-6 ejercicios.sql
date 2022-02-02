-- 1.3.6 Consultas resumen

-- 1. Calcula la cantidad total que suman todos los pedidos que aparecen en la tabla pedido.
SELECT SUM(p1.total) as "Suma total pedidos" FROM pedido p1;

-- 2. Calcula la cantidad media de todos los pedidos que aparecen en la tabla pedido.
SELECT AVG(p1.total) as "Media total pedidos"  FROM pedido p1;

-- 3. Calcula el número total de comerciales distintos que aparecen en la tabla pedido.
SELECT COUNT(DISTINCT p1.id_comercial) as "Nº comerciales" FROM pedido p1;

-- 4. Calcula el número total de clientes que aparecen en la tabla cliente.
SELECT COUNT(c1.id) as "Nº clientes" FROM cliente c1;

-- 5. Calcula cuál es la mayor cantidad que aparece en la tabla pedido.
SELECT MAX(p1.total) as "Mayor total pedidos"  FROM pedido p1;

-- 6. Calcula cuál es la menor cantidad que aparece en la tabla pedido.
SELECT MIN(p1.total) as "Menor total pedidos"  FROM pedido p1;

-- 7. Calcula cuál es el valor máximo de categoría para cada una de las ciudades que aparece en la tabla cliente.
SELECT c1.ciudad, MAX(c1.categoría) as "categoria"  FROM cliente c1
  GROUP BY c1.ciudad;

-- 8. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los clientes. Es decir, el mismo cliente puede haber realizado varios pedidos de diferentes cantidades el mismo día. Se pide que se calcule cuál es el pedido de máximo valor para cada uno de los días en los que un cliente ha realizado un pedido. Muestra el identificador del cliente, nombre, apellidos, la fecha y el valor de la cantidad.
SELECT 
  c1.id, c1.nombre, CONCAT_WS(" ", c1.apellido1, c1.apellido2) as "Apellidos",
  p1.fecha, MAX(p1.total)
  FROM cliente c1
  INNER JOIN pedido p1 ON p1.id_cliente = c1.id
  GROUP BY p1.fecha, c1.id
  ORDER BY 1 ASC;

-- 9. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los clientes, teniendo en cuenta que sólo queremos mostrar aquellos pedidos que superen la cantidad de 2000 €.
SELECT 
  c1.id, c1.nombre, CONCAT_WS(" ", c1.apellido1, c1.apellido2) as "Apellidos",
  p1.fecha, MAX(p1.total)
  FROM cliente c1
  INNER JOIN pedido p1 ON p1.id_cliente = c1.id
  WHERE p1.total > 2000
  GROUP BY p1.fecha, c1.id
  ORDER BY 1 ASC;

-- 10. Calcula el máximo valor de los pedidos realizados para cada uno de los comerciales durante la fecha 2016-08-17. Muestra el identificador del comercial, nombre, apellidos y total.
SELECT 
  cm1.id, cm1.nombre, CONCAT_WS(" ", cm1.apellido1, cm1.apellido2) as "Apellidos",
  p1.total
  FROM comercial cm1
  INNER JOIN pedido p1 ON p1.id_comercial = cm1.id
  WHERE p1.fecha LIKE "2016-08-17";

-- 11. Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos que ha realizado cada uno de clientes. Tenga en cuenta que pueden existir clientes que no han realizado ningún pedido. Estos clientes también deben aparecer en el listado indicando que el número de pedidos realizados es 0.
SELECT 
  c1.id, c1.nombre, CONCAT_WS(" ", c1.apellido1, c1.apellido2) as "Apellidos",
  COUNT(p1.id) as "Nº pedidos"
  FROM cliente c1
  LEFT JOIN pedido p1 ON p1.id_cliente = c1.id
  GROUP BY c1.id
  ORDER BY 1 ASC;

-- 12. Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos que ha realizado cada uno de clientes durante el año 2017.
SELECT 
  c1.id, c1.nombre, CONCAT_WS(" ", c1.apellido1, c1.apellido2) as "Apellidos",
  COUNT(p1.id) as "Nº pedidos"
  FROM cliente c1
  INNER JOIN pedido p1 ON p1.id_cliente = c1.id
  WHERE YEAR(p1.fecha) = 2017
  GROUP BY c1.id
  ORDER BY 1 ASC;

-- 13. Devuelve un listado que muestre el identificador de cliente, nombre, primer apellido y el valor de la máxima cantidad del pedido realizado por cada uno de los clientes. El resultado debe mostrar aquellos clientes que no han realizado ningún pedido indicando que la máxima cantidad de sus pedidos realizados es 0. Puede hacer uso de la función IFNULL.

-- 14. Devuelve cuál ha sido el pedido de máximo valor que se ha realizado cada año.

-- 15. Devuelve el número total de pedidos que se han realizado cada año.