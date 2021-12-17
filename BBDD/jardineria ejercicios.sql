###################################################
# Autor: Alejandro Pérez Álvarez
###################################################

# 1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
SELECT 
  ofi.codigo_oficina as "Oficina",
  ofi.ciudad as "Ciudad"
  FROM oficina ofi;


# 2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
SELECT
  ofi.ciudad as "Ciudad",
  ofi.telefono as "Telefono"
  FROM oficina ofi

  WHERE ofi.pais LIKE "España";


# 3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
SELECT
  e.nombre as "Nombre",
  CONCAT_WS(" ", e.apellido1, e.apellido2) as "Apellidos",
  e.email as "E-mail"
  FROM empleado e

  WHERE e.codigo_jefe = 7;


# 4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
SELECT
  e.puesto as "Puesto",
  e.nombre as "Nombre",
  CONCAT_WS(" ", e.apellido1, e.apellido2) as "Apellidos",
  e.email as "E-mail"
  FROM empleado e

  WHERE e.codigo_jefe IS NULL;


# 5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
SELECT
  e.nombre as "Nombre",
  CONCAT_WS(" ", e.apellido1, e.apellido2) as "Apellidos",
  e.puesto as "Puesto"
  FROM empleado e 

  WHERE UPPER(e.puesto) NOT LIKE "REPRESENTANTE VENTAS";


# 6. Devuelve un listado con el nombre de los todos los clientes españoles.
SELECT
 cli.nombre_cliente as "Nombre"
 FROM cliente cli

 WHERE UPPER(cli.pais) LIKE "SPAIN";


# 7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.
SELECT DISTINCT 
  p.estado as "Estado"
  FROM pedido p;


# 8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:
# • Utilizando la función YEAR de MySQL.
SELECT DISTINCT
  p.codigo_cliente as "Cliente"
  FROM pago p

  WHERE YEAR(p.fecha_pago) = 2008;

# • Utilizando la función DATE_FORMAT de MySQL.
SELECT DISTINCT
  p.codigo_cliente as "Cliente"
  FROM pago p

  WHERE DATE_FORMAT(p.fecha_pago, "%Y") = 2008;

# • Sin utilizar ninguna de las funciones anteriores.
SELECT DISTINCT
  p.codigo_cliente as "Cliente"
  FROM pago p

  WHERE p.fecha_pago LIKE "2008%";


# 9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.
SELECT
  p.codigo_pedido as "Pedido",
  p.codigo_cliente as "Cliente",
  p.fecha_esperada as "Fecha Esperada",
  p.fecha_entrega as "Fecha de Entrega"
  FROM pedido p

  WHERE p.fecha_esperada < p.fecha_entrega;
  

# 10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
# • Utilizando la función ADDDATE de MySQL.
SELECT
  p.codigo_pedido as "Pedido",
  p.codigo_cliente as "Cliente",
  p.fecha_esperada as "Fecha Esperada",
  p.fecha_entrega as "Fecha de Entrega"
  FROM pedido p

  WHERE ADDDATE(p.fecha_entrega, 1) < p.fecha_esperada;

# • Utilizando la función DATEDIFF de MySQL.
SELECT
  p.codigo_pedido as "Pedido",
  p.codigo_cliente as "Cliente",
  p.fecha_esperada as "Fecha Esperada",
  p.fecha_entrega as "Fecha de Entrega"
  FROM pedido p

  WHERE DATEDIFF(p.fecha_esperada, p.fecha_entrega) > 1;


# 11. Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
SELECT 
  p.codigo_pedido as "Pedido"
  FROM pedido p

  WHERE
    YEAR(p.fecha_pedido) = 2009 AND
    UPPER(p.estado) LIKE "RECHAZADO";


# 12. Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
SELECT 
  p.codigo_pedido as "Pedido"
  FROM pedido p

  WHERE
    MONTH(p.fecha_pedido) = 1 AND
    UPPER(p.estado) LIKE "ENTREGADO";


# 13. Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
SELECT 
  p.id_transaccion as "Pago"
  FROM PAGO p

  WHERE
    YEAR(p.fecha_pago) = 2008 AND
    UPPER(p.forma_pago) LIKE "PAYPAL"

  ORDER BY 1 ASC;


# 14. Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
SELECT DISTINCT
  p.forma_pago as "Formas de Pago"
  FROM PAGO p;


# 15. Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.
SELECT 
  p.nombre as "Nombre",
  CONCAT(p.precio_venta, "€") as "Precio"
  FROM producto p

  WHERE
    UPPER(p.gama) LIKE "ORNAMENTALES" AND
    p.cantidad_en_stock > 100

  ORDER BY 2 DESC;


# 16. Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 11 o 30.
SELECT * FROM cliente
  WHERE codigo_empleado_rep_ventas IN (11, 30);