-- 1.5.6 Consultas multitabla (Composición externa)
-- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.


# 1. Devuelve un listado con los nombres de todos los profesores y los departamentos que tienen vinculados. 
# El listado también debe mostrar aquellos profesores que no tienen ningún departamento asociado. 
# El resultado estará ordenado alfabéticamente de menor a mayor por el nombre del departamento, apellidos y el nombre.
select pe1.nombre, d1.nombre from persona pe1
  inner join profesor pr1 on pr1.id_profesor = pe1.id
  left join departamento d1 on d1.id = pr1.id_departamento
  group by 1
  order by 2, 1;


# 2. Devuelve un listado con los profesores que no están asociados a un departamento.
select pe1.* from persona pe1
  inner join profesor pr1 on pr1.id_profesor = pe1.id
  where pr1.id_departamento is null;


# 3. Devuelve un listado con los departamentos que no tienen profesores asociados.
select d1.nombre from departamento d1
  left join profesor pr1 on pr1.id_departamento = d1.id
  where pr1.id_profesor is null;


# 4. Devuelve un listado con los profesores que no imparten ninguna asignatura.


# 5. Devuelve un listado con las asignaturas que no tienen un profesor asignado.


# 6. Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya impartido en ningún curso escolar. # El resultado debe mostrar el nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.