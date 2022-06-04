
DROP TRIGGER IF EXISTS insertVenta;
DELIMITER //

/*
Crea el disparador insertVenta asociado a la tabla VENTA. 

Cada vez que se inserte un registro en la tabla VENTA se descontará sobre la tabla Stock la cantidad que hay de ese producto. 

Es decir Stock.cantidad=Stock.cantidad-VENTA.cantidad.
*/


CREATE TRIGGER insertVenta AFTER INSERT
ON venta FOR EACH ROW
BEGIN

UPDATE stock SET cantidad = cantidad - NEW.cantidad
WHERE idProducto = NEW.id_producto;

END //

DELIMITER ;

-- TESTS
INSERT INTO venta VALUES
(1, NOW(), 1, precioVenta(1) * 1);