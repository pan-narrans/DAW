DROP PROCEDURE IF EXISTS venta;
DELIMITER //

/*
Crea el procedimiento venta(nombre, cantidad), recibe como parámetro el nombre del producto VARCHAR(40) y la cantidad INT que se desea comprar.

Este procedimiento insertará en la tabla VENTA un registro siempre y cuando haya stock suficiente. Es decir stock.cantidad >=cantidad.
*/

CREATE PROCEDURE venta (nombre VARCHAR(40), cantidad INT(10) UNSIGNED)
BEGIN

DECLARE cantidad_stock INT(10);
DECLARE id_producto INT(10);

-- set id_producto
SELECT codigo INTO id_producto FROM producto
WHERE producto.nombre LIKE nombre;

-- set cantidad_stock
SELECT stock.cantidad INTO cantidad_stock FROM stock
WHERE idProducto = id_producto;

IF cantidad <= cantidad_stock THEN
  INSERT INTO venta VALUES
  (id_producto, NOW(), cantidad, precioVenta(id_producto) * cantidad);
  SELECT "Venta realizada.";
ELSE  
  SELECT "No hay suficientes unidades a la venta";
END IF;

END //

DELIMITER ;

-- TESTS
CALL venta("Portátil Ideapd 320", 2);
CALL venta("Disco duro SATA3 1TB", 5);