/*
Crea la tabla pedidoProveedor, con los campos
idProducto: Integer(10) primary key y foránea de la clave primaria de Productos.
Fecha: TimeStamp primary Key. Es la fecha en la que se realiza el pedido.
Cantidad: Integer. Es la cantidad que se hace de dicho pedido al proveedor.
Pendiente: Lógico. Si true indica que ese pedido está pendiente de ser servido.
Inserta varios pedidos a proveedor.
*/

DROP TABLE IF EXISTS pedidoProveedor;
CREATE TABLE pedidoProveedor(
  idProducto INT(10) UNSIGNED,
  fecha TIMESTAMP,
  cantidad INT(10),
  pendiente BOOLEAN NOT NULL,

  PRIMARY KEY (idProducto, fecha),

  CONSTRAINT FK_PEDIDOPROVEEDOR_PRODUCTO_IDPRODUCTO
  FOREIGN KEY (idProducto) REFERENCES producto(codigo)
  ON UPDATE CASCADE ON DELETE CASCADE
);
