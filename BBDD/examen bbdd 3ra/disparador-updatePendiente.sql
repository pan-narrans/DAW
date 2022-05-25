DROP TRIGGER IF EXISTS updatePendiente;
DELIMITER //

/*
Crea un disparador sobre la tabla PedidoProveedor asociado al evento Update.

Este disparador solo funciona cuando cambia el estado de la columna “Pendiente” de true a false. Cuando esto suceda se actualizará sobre la tabla Stock la columna cantidad, sumándose a esa cantidad la cantidad del producto servida.
*/

CREATE TRIGGER updatePendiente AFTER UPDATE
ON pedidoProveedor FOR EACH ROW
BEGIN

IF OLD.pendiente = 1 AND NEW.pendiente = 0 THEN
  UPDATE stock SET cantidad = cantidad + NEW.cantidad
  WHERE idProducto = NEW.idProducto;
END IF;


END //

DELIMITER ;

-- TESTS
INSERT INTO pedidoProveedor VALUES
();