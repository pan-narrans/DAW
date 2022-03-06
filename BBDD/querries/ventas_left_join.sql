-- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.


-- 1. Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. Este listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.
SELECT * FROM cliente
  LEFT JOIN pedido ON pedido.id_cliente = cliente.id
  ORDER BY cliente.apellido1, cliente.apellido2, cliente.nombre;

-- 2. Devuelve un listado con todos los comerciales junto con los datos de los pedidos que han realizado. Este listado también debe incluir los comerciales que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los comerciales.
SELECT * FROM comercial
  LEFT JOIN pedido ON pedido.id_comercial = comercial.id
  ORDER BY comercial.apellido1, comercial.apellido2, comercial.nombre;

-- 3. Devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido.
SELECT * FROM cliente
  LEFT JOIN pedido ON pedido.id_cliente = cliente.id
  WHERE pedido.id IS NULL;

-- 4. Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.
SELECT * FROM comercial
  LEFT JOIN pedido p1 ON p1.id_comercial = comercial.id
  WHERE p1.id IS NULL;


-- 5. Devuelve un listado con los clientes que no han realizado ningún pedido y de los comerciales que no han participado en ningún pedido. Ordene el listado alfabéticamente por los apellidos y el nombre. En en listado deberá diferenciar de algún modo los clientes y los comerciales.
SELECT 
  CONCAT_WS(" ", cliente.nombre, cliente.apellido1, cliente.apellido2) as "Gente sin pedidos", 
  "Cliente" as "Tipo" FROM cliente
  LEFT JOIN pedido ON pedido.id_cliente = cliente.id
  WHERE pedido.id IS NULL
UNION
SELECT 
  CONCAT_WS(" ", comercial.nombre, comercial.apellido1, comercial.apellido2) as "Gente sin pedidos", 
  "Comercial" as "Tipo"  FROM comercial
  LEFT JOIN pedido p1 ON p1.id_comercial = comercial.id
  WHERE p1.id IS NULL
ORDER BY 1;


-- 6. ¿Se podrían realizar las consultas anteriores con NATURAL LEFT JOIN o NATURAL RIGHT JOIN? Justifique su respuesta.