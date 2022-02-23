-- EXAMEN DE BASES DE DATOS DIOSSSSS

-- 1
-- Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en K. (tipo puede ser “profesor” o “alumno”).
-- nombre, apellido1 y apellido1
SELECT per1.nombre, per1.apellido1, per1.apellido2 FROM persona per1
  WHERE UPPER(per1.nif) LIKE "%K" AND
  UPPER(per1.tipo) LIKE "PROFESOR" AND
  per1.telefono IS NULL;



-- 2
-- Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados.
-- El listado debe devolver cuatro columnas, primer apellido, segundo apellido, nombre y nombre del departamento. 
-- El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.
SELECT 
  per1.apellido1, per1.apellido2, 
  per1.nombre, d1.nombre AS "departamento"
  FROM persona per1
  INNER JOIN profesor prof1 ON prof1.id_profesor = per1.id
  INNER JOIN departamento d1 ON d1.id = prof1.id_departamento
  ORDER BY 1, 2, 3;



-- 3
-- 3-1 
-- Devuelve un listado del nombre de asignatura y id del departamento que la imparte (0,75 PTOS)
SELECT a1.nombre, prof1.id_departamento FROM asignatura a1
  INNER JOIN profesor prof1 ON prof1.id_profesor = a1.id_profesor;


-- 3-2 
-- Devuelve un listado con el nombre de la asignatura y el nombre del departamento que la imparte(0,75 PTOS)
SELECT a1.nombre, d1.nombre FROM asignatura a1
  INNER JOIN profesor prof1 ON prof1.id_profesor = a1.id_profesor
  INNER JOIN departamento d1 ON d1.id = prof1.id_departamento;


-- 3-3 
-- Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya impartido en ningún curso escolar. 
-- Es decir, que no se haya matriculado ningún alumno. 
-- El resultado debe mostrar el nombre del departamento y el nombre de la asignatura que no se haya impartido nunca. (1 PTO)
SELECT
  d2.nombre AS "Departamento", a2.nombre AS "Asignatura"
  FROM departamento d2
  INNER JOIN profesor prof2 ON prof2.id_departamento = d2.id
  INNER JOIN asignatura a2 ON a2.id_profesor = prof2.id_profesor
  WHERE a2.id NOT IN (    
    SELECT a1.id FROM asignatura a1
    INNER JOIN alumno_se_matricula_asignatura m1 ON m1.id_asignatura = a1.id
    INNER JOIN curso_escolar c1 ON c1.id = m1.id_curso_escolar
    GROUP BY a1.id    
  );

-- 4
-- Calcula cuántos profesores hay en cada departamento. 
-- El resultado sólo debe mostrar dos columnas, una con el nombre del departamento y otra con el número de profesores que hay en ese departamento. 
-- El resultado sólo debe incluir los departamentos que tienen profesores asociados y deberá estar ordenado de mayor a menor por el número de profesores.
SELECT d1.nombre AS "departamento", count(prof1.id_profesor) as "nº profesores"
  FROM persona per1
  INNER JOIN profesor prof1 ON prof1.id_profesor = per1.id
  INNER JOIN departamento d1 ON d1.id = prof1.id_departamento
  GROUP BY d1.nombre
  ORDER BY 2 DESC;


-- 5 
-- Devuelve todos los datos del alumno más joven.(Utilizando subconsultas)
SELECT per1.* FROM persona per1
  WHERE UPPER(per1.tipo) LIKE "ALUMNO" AND
  per1.fecha_nacimiento >= ALL (
    SELECT per2.fecha_nacimiento FROM persona per2
    WHERE UPPER(per2.tipo) LIKE "ALUMNO"
  );


-- 6
-- 6-1
-- Realiza un consulta que liste el id deL departamento “INFORMATICA”  (0,5)
SELECT d1.id FROM departamento d1
  WHERE UPPER(d1.nombre) LIKE "INFORMATICA";

-- 6-2
-- Utilizando la consulta anterior realiza un consulta que visualice el id_profesores que pertenece al departamento de "informática" (0,75 PTO)
SELECT prof1.id_profesor FROM departamento d1
  INNER JOIN profesor prof1 ON prof1.id_departamento = d1.id
  WHERE UPPER(d1.nombre) LIKE "INFORMATICA";

-- 6-3
-- Utilizando la consulta anterior visualiza el nombre de las asignaturas que sean impartidas por algún profesor del departamento de informática. (0,75 PTO)
SELECT a1.nombre FROM departamento d1
  INNER JOIN profesor prof1 ON prof1.id_departamento = d1.id
  INNER JOIN asignatura a1 ON a1.id_profesor = prof1.id_profesor
  WHERE UPPER(d1.nombre) LIKE "INFORMATICA";


