-- 1.5.5 Consultas multitabla (Composición interna)

# 1. Devuelve un listado con los datos de todas las alumnas que se han matriculado alguna vez en el Grado en Ingeniería Informática (Plan 2015).
select p1.* from persona p1
  inner join alumno_se_matricula_asignatura m1 on m1.id_alumno = p1.id
  inner join asignatura a1 on a1.id = m1.id_asignatura
  inner join grado g1 on g1.id = a1.id_grado
  where upper(p1.sexo) like "M"
    and upper(g1.nombre) like "GRADO EN INGENIERÍA INFORMÁTICA (PLAN 2015)"
  group by p1.id;


# 2. Devuelve un listado con todas las asignaturas ofertadas en el Grado en Ingeniería Informática ( Plan 2015).
select a1.* from asignatura a1
  inner join grado g1 on g1.id = a1.id_grado
  where upper(g1.nombre) like "GRADO EN INGENIERÍA INFORMÁTICA (PLAN 2015)";


# 3. Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados. 
# El listado debe devolver cuatro columnas, primer apellido, segundo apellido, nombre y nombre del departamento. 
# El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.
select pe1.apellido1, pe1.apellido2, pe1.nombre, d1.nombre 
  from persona pe1
  inner join profesor pr1 on pr1.id_profesor = pe1.id
  inner join departamento d1 on d1.id = pr1.id_departamento
  order by pe1.apellido1, pe1.apellido2, pe1.nombre;


# 4. Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno con nif 26902806M.
select a1.nombre, c1.anyo_inicio, c1.anyo_fin from persona p1
  inner join alumno_se_matricula_asignatura m1 on m1.id_alumno = p1.id
  inner join asignatura a1 on a1.id = m1.id_asignatura
  inner join curso_escolar c1 on c1.id = m1.id_curso_escolar
  where upper(p1.nif) like "26902806M";


# 5. Devuelve un listado con el nombre de todos los departamentos que tienen profesores que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).
select d1.nombre from departamento d1
  inner join profesor pr1 on pr1.id_departamento = d1.id
  inner join asignatura a1 on a1.id_profesor = pr1.id_profesor
  inner join grado g1 on g1.id = a1.id_grado
  where upper(g1.nombre) like "GRADO EN INGENIERÍA INFORMÁTICA (PLAN 2015)"
  group by 1;


# 6. Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2018/2019.
select pe1.id, pe1.nombre, c1.anyo_inicio, c1.anyo_fin from persona pe1
  inner join alumno_se_matricula_asignatura m1 on m1.id_alumno = pe1.id
  inner join curso_escolar c1 on c1.id = m1.id_curso_escolar
  where c1.anyo_inicio = 2018 and c1.anyo_fin = 2019
  group by 1
  order by 2;