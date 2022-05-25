DROP PROCEDURE IF EXISTS servir;
DELIMITER //


/*
Realiza el procedimiento Servir(nombreFabricante)
Recibe como parámetro el nombre de un Fabricante VARCHAR(40)

Este procedimiento sirve los pedidos pendientes de un fabricante. Para ello pone a false el campo pendiente de la tabla PedidoProveedor de todos los pedidos pendientes de ese fabricante.

RECUERDA QUE LA INSTRUCCIÓN UPDATE LLEVA UN PREDICADO WHERE,
ESTE PUEDE SER UNA SUBCONSULTA SI UTILIZA LOS OPEDORES IN, NOT IN,
EXITS....
*/

CREATE PROCEDURE servir (nombreFabricante VARCHAR(40))
BEGIN


DECLARE id_fabricante INT(10);

-- set id_fabricante
SELECT codigo INTO id_fabricante FROM fabricante
WHERE fabricante.nombre LIKE nombreFabricante;

UPDATE pedidoproveedor SET pendiente = 0 WHERE pedidoproveedor.idProducto IN (
  SELECT codigo FROM producto WHERE codigo_fabricante = id_fabricante
);


END //

DELIMITER ;

-- TESTS
CALL servir("Seagate");
CALL servir("Lenovo");