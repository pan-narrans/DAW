/*
Crea una tabla llamada stock, dicha tabla contiene los campos 
  ◦idProducto    tipo int int(10) UNSIGNED,  autoincremental, foránea respecto a la tabla Producto. Si se borrara un producto de la tabla Producto desaparecerá todo registro de esta tabla que haga referencia a él.
  ◦precioVenta    tipo int(10,2). Ten en cuenta que el precio de venta puede ser null,  
  ◦cantidad    tipo int, no puede ser null  y  por defecto es 0, además nunca podrá ser negativo.
*/

DROP TABLE IF EXISTS stock;
CREATE TABLE stock(
  idProducto INT(10) UNSIGNED NOT NULL PRIMARY KEY,
  precioVenta DECIMAL(10,2),
  cantidad INT UNSIGNED NOT NULL DEFAULT 0,

  CONSTRAINT FK_STOCK_PRODUCTO_ID
  FOREIGN KEY (idProducto) REFERENCES producto(codigo)
  ON UPDATE CASCADE ON DELETE CASCADE
);


/*
Inserción masiva de datos.
*/

INSERT INTO stock 
SELECT codigo, precio_venta(codigo), 3 FROM producto;