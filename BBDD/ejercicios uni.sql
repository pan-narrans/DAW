#1 
SELECT persona.nombre as "Nombre" 
  FROM persona
	WHERE persona.tipo LIKE "alumno" AND
        UPPER(persona.apellido1) LIKE "MARTINEZ"
;

#2
SELECT *
  FROM persona
  WHERE persona.tipo LIKE "alumno" AND
        persona.id = 9
;

#3 NO FUNCIONA
SELECT
    persona.nombre as "Nombre",
    persona.fecha_nacimiento as "Fecha de Nacimiento"
  FROM persona
  WHERE persona.fecha_nacimiento > 1997-01-01
;


#4
SELECT *
  FROM persona
  WHERE persona.tipo LIKE "alumno" AND
        persona.id = 1
;


#5
SELECT *
  FROM persona
  WHERE persona.tipo LIKE "alumno" AND
        persona.telefono LIKE "692735409"