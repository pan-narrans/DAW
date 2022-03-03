-- 8. Devuelve el nombre del cliente con mayor límite de crédito.
SELECT * FROM cliente c1
  WHERE c1.limite_credito >= ALL (SELECT c2.limite_credito FROM cliente c2);
  
-- 8. Devuelve el nombre del cliente con mayor límite de crédito.
SELECT * FROM cliente c1
  WHERE c1.limite_credito != ANY (SELECT mAX(c2.limite_credito) FROM cliente c2);

-- 9. Devuelve el nombre del producto que tenga el precio de venta más caro.
SELECT p1.nombre FROM producto p1
  WHERE p1.precio_venta >= ALL (SELECT p2.precio_venta FROM producto p2);

-- 10. Devuelve el producto que menos unidades tiene en stock
SELECT p1.nombre FROM producto p1
  WHERE p1.cantidad_en_stock <= ALL (SELECT p2.cantidad_en_stock FROM producto p2);




-- Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.

SELECT ofi1.codigo_oficina, ofi1.ciudad FROM oficina ofi1
  -- Sacamos los que tienen frutales y nos aseguramos de no coger esos
  WHERE ofi1.codigo_oficina NOT IN (
    SELECT  emp1.codigo_oficina FROM empleado emp1
    INNER JOIN cliente cli1 ON cli1.codigo_empleado_rep_ventas = emp1.codigo_empleado
    INNER JOIN pedido ped1 ON ped1.codigo_cliente = cli1.codigo_cliente
    INNER JOIN detalle_pedido det1 ON det1.codigo_pedido = ped1.codigo_pedido
    INNER JOIN producto prod1 ON prod1.codigo_producto = det1.codigo_producto
    WHERE UPPER(prod1.gama) LIKE "FRUTALES"
  )
  GROUP BY ofi1.codigo_oficina
  ORDER BY 1;



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
          WHERE UPPER(prod1.gama) LIKE "FRUTALES"
          )
        )
      )
    )
  )
  ORDER BY 1;

