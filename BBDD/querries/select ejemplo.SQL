

SELECT persona.nombre FROM persona
	WHERE persona.tipo LIKE "alumno" AND persona.apellido1 LIKE "sánchez";

SELECT persona.nombre FROM persona 
	WHERE persona.tipo LIKE "alumno" AND persona.apellido1 LIKE "s%";

#  Primero ordena y luego concatena
SELECT concat_ws(' ',persona.nombre, persona.apellido1, persona.apellido2) as "Nombre y Apellidos" 	
	FROM persona 
	WHERE persona.tipo = "Alumno"
	ORDER BY persona.apellido1;	# ORDER BY 1 -> ordena en base a la 1ra columna
	LIMIT 5				# nº de elementos a mostrar

# Saca la persona más mayor de la tabla
SELECT concat_ws(' ',persona.nombre, persona.apellido1, persona.apellido2) as "Nombre y Apellidos" 	
	FROM persona 
	ORDER BY persona.fecha_nacimiento ASC
	LIMIT 1

# Fancy stuff
SELECT 
    producto.nombre AS "Nombre",
    ROUND( producto.precio, 2) AS "Precio", 
    ROUND( producto.beneficio, 2) AS " Benecifio", 
    ROUND( producto.precio + producto.beneficio, 2) AS "Precio de Venta", 
    CONCAT_WS(" ", ROUND(( producto.precio + producto.beneficio) * 1.21), "€") AS "Precio Final" 
  FROM producto
  ORDER BY 5 ASC

# M
select DISTINCT fabricante.nombre as "Nombre"
  FROM fabricante, producto
  WHERE fabricante.codigo LIKE producto.codigo_fabricante