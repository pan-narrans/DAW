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

SELECT ofi1.codigo_oficina FROM oficina ofi1
  INNER JOIN empleado emp1 ON emp1.codigo_oficina = ofi1.codigo_oficina
  INNER JOIN cliente cli1 ON cli1.codigo_empleado_rep_ventas = emp1.codigo_empleado
  INNER JOIN pedido ped1 ON ped1.codigo_cliente = cli1.codigo_cliente
  INNER JOIN detalle_pedido det1 ON det1.codigo_pedido = ped1.codigo_pedido
  INNER JOIN producto prod1 ON prod1.codigo_producto = det1.codigo_producto

  WHERE UPPER(prod1.gama) NOT LIKE "FRUTALES"
  GROUP BY ofi1.codigo_oficina 