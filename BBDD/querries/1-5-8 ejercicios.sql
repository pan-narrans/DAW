-- 1.5.8 Subconsultas
# 1. Devuelve todos los datos del alumno más joven.
Select p1.* from persona p1
  where p1.fecha_nacimiento >= all (
    select p2.fecha_nacimiento from persona p2
  );


# 2. Devuelve un listado con los profesores que no están asociados a un departamento.
select per1.* from persona per1
  inner join profesor prof1  on per1.id =  prof1.id_profesor
  where prof1.id_departamento is null;


# 3. Devuelve un listado con los departamentos que no tienen profesores asociados.
select d1.* from departamento d1
  left join profesor prof1 on prof1.id_departamento = d1.id
  where prof1.id_profesor is null;

select d1.* from departamento d1
  where d1.id not in (
    select prof1.id_departamento from profesor prof1
  );


# 4. Devuelve un listado con los profesores que tienen un departamento asociado y que no imparten ninguna asignatura.
select prof1.* from profesor prof1
  where prof1.id_profesor not in (
    select a1.id_profesor from asignatura a1
  )and prof1.id_departamento is not null;


# 5. Devuelve un listado con las asignaturas que no tienen un profesor asignado.
select a1.* from asignatura a1
  where a1.id_profesor is null;


# 6. Devuelve un listado con todos los departamentos que no han impartido asignaturas en ningún curso escolar.
select d1.* from departamento d1
  where d1.id not in (
    select d2.id from departamento d2
    inner join profesor prof1 on prof1.id_departamento = d2.id
    inner join asignatura a1 on a1.id_profesor = prof1.id_profesor
    inner join alumno_se_matricula_asignatura m1 on m1.id_asignatura = a1.id
  )




















#6. Devuelve un listado con todos los departamentos que no han impartido asignaturas en ningún curso escolar.

SELECT D.* FROM departamento D
WHERE D.id NOT IN
  (SELECT P.id_departamento FROM profesor P 
    INNER JOIN asignatura A on P.id_profesor = A.id_profesor 
    INNER JOIN alumno_se_matricula_asignatura AL on A.id = AL.id_asignatura 
    INNER JOIN curso_escolar C on AL.id_curso_escolar = c.id
  );

select * from departamento
where id in
  (select id_departamento from profesor p 
  where not exists 
    (select a.id_profesor from asignatura a
    where p.id_profesor = id_profesor and not exists 
      (select id_asignatura from alumno_se_matricula_asignatura 
      where a.id = id_asignatura) ) ) ;