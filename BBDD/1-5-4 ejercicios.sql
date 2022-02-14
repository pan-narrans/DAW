-- 1.5.4 Consultas sobre una tabla

# 1. Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor a mayor por el primer apellido, segundo apellido y nombre.
SELECT p1.apellido1, p1.apellido2, p1.nombre FROM persona p1
  WHERE UPPER(p1.tipo) LIKE "ALUMNO"
  ORDER BY 1, 2, 3;


# 2. Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfonoen la base de datos.
SELECT p1.apellido1, p1.apellido2, p1.nombre FROM persona p1
  WHERE UPPER(p1.tipo) LIKE "ALUMNO"
    AND p1.telefono IS NULL;


# 3. Devuelve el listado de los alumnos que nacieron en 1999.
SELECT * FROM persona p1
  WHERE UPPER(p1.tipo) LIKE "ALUMNO"
    AND YEAR(p1.fecha_nacimiento) = 1999;


# 4. Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en K.
SELECT * FROM persona p1
  WHERE UPPER(p1.tipo) LIKE "PROFESOR"
    AND p1.telefono IS NULL
    AND p1.nif LIKE "%K";


# 5. Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, en el tercer curso del grado que tiene el identificador 7.
SELECT * FROM asignatura a1
  WHERE cuatrimestre = 1
    AND curso = 3
    AND id_grado = 7;