DROP FUNCTION IF EXISTS precioVenta;
DELIMITER //

/*
Crea una función “PrecioVenta” que recibe como parámetro  el idProducto int(10) y retorna el precio de venta: decimal(10,2) teniendo en cuenta:

Si el precio es menor o igual a 100 euros el precio se calcula con el precio de venta del producto multiplicado por la columna “Margen2”  de la tabla Fabricante, en caso contrario el precio de venta se calcula con el precio de venta del producto multiplicado por la columna “Margen1” de la tabla Fabricante.

Si el producto no existiese devuelve -1.
*/

CREATE FUNCTION precioVenta(id_producto INT)
RETURNS DECIMAL(10,2)
BEGIN

DECLARE ret_precio DECIMAL(10,2);
DECLARE marg1 DECIMAL(4,2);
DECLARE marg2 DECIMAL(4,2);

-- set ret_precio
SELECT precio INTO ret_precio
FROM producto WHERE codigo = id_producto;

-- set marg2
SELECT Margen2 INTO marg2
FROM fabricante WHERE codigo = (
  SELECT codigo_fabricante FROM producto
  WHERE codigo = id_producto
);

-- set marg1
SELECT Margen1 INTO marg1
FROM fabricante WHERE codigo = (
  SELECT codigo_fabricante FROM producto
  WHERE codigo = id_producto
);


IF ret_precio <= 100 THEN
  SET ret_precio = ret_precio + ret_precio * marg2;
ELSEIF ret_precio > 100 THEN
  SET ret_precio = ret_precio + ret_precio * marg1;
ELSE
  SET ret_precio = -1;
END IF;


RETURN ret_precio;

END //

DELIMITER ;

-- TESTS
SELECT precio_venta(codigo), precio FROM producto;
SELECT precio_venta(-100);