-- 1.2.7.2 Subconsultas con ALL y ANY


-- 4. Devuelve el nombre del departamento con mayor presupuesto y la cantidad que tiene asignada. Sin hacer uso de MAX, ORDER BY ni LIMIT.
SELECT dep.nombre, dep.presupuesto FROM departamento dep
  WHERE dep.presupuesto >= ALL (SELECT dep.presupuesto FROM departamento dep);

-- 5. Devuelve el nombre del departamento con menor presupuesto y la cantidad que tiene asignada. Sin hacer uso de MIN, ORDER BY ni LIMIT.
SELECT dep.nombre, dep.presupuesto FROM departamento dep
  WHERE dep.presupuesto <= ALL 
    (SELECT dep.presupuesto FROM departamento dep);


-- 6. Devuelve los nombres de los departamentos que tienen empleados asociados. (Utilizando ALL o ANY).
SELECT dep.nombre FROM departamento dep
  WHERE dep.codigo = ANY 
    (SELECT emp.codigo_departamento FROM empleado emp);



#### NO FUNCIONA
-- 7. Devuelve los nombres de los departamentos que no tienen empleados asociados. (Utilizando ALL o ANY).
SELECT dep.nombre FROM departamento dep
  WHERE dep.codigo <> ALL 
    (SELECT emp.codigo_departamento FROM empleado emp);