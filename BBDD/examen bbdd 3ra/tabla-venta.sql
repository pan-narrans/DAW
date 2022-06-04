/*
Crea la tabla VENTA con las siguientes columnas :
IdProducto: Entero(10), clave primaria compuesta y foránea la columna código de la tabla 
Producto.
Fecha:TimeStamp, clave primaria compuesta, Fecha en la que se realiza la venta.
Cantidad: Entero. Cantidad de la venta de ese producto.
PVP_total: Precio total de la venta.
*/

DROP TABLE IF EXISTS venta;
CREATE TABLE venta(
  id_producto INT(10) UNSIGNED,
  fecha TIMESTAMP,
  cantidad INT,
  pvp_total DECIMAL(10,2),

  PRIMARY KEY (id_producto, fecha)
);