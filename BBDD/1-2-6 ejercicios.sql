-- 1.2.6 Consultas resumen


-- 1. Calcula la suma del presupuesto de todos los departamentos.
SELECT SUM(dep.presupuesto) FROM departamento dep;

-- 2. Calcula la media del presupuesto de todos los departamentos.
SELECT AVG(dep.presupuesto) FROM departamento dep;


-- 3. Calcula el valor mínimo del presupuesto de todos los departamentos.
SELECT MIN(dep.presupuesto) FROM departamento dep;


-- 4. Calcula el nombre del departamento y el presupuesto que tiene asignado, del departamento con menorpresupuesto.
SELECT dep.nombre, dep.presupuesto FROM departamento dep
  WHERE dep.presupuesto = 
    (SELECT MIN(dep.presupuesto) FROM departamento dep);


-- 5. Calcula el valor máximo del presupuesto de todos los departamentos.
SELECT MAX(dep.presupuesto) FROM departamento dep;


-- 6. Calcula el nombre del departamento y el presupuesto que tiene asignado, del departamento con mayorpresupuesto.
SELECT dep.nombre, dep.presupuesto FROM departamento dep
  WHERE dep.presupuesto = 
    (SELECT MAX(dep.presupuesto) FROM departamento dep);



-- 7. Calcula el número total de empleados que hay en la tabla empleado.
SELECT COUNT(emp.codigo) FROM empleado emp;


-- 8. Calcula el número de empleados que no tienen NULL en su segundo apellido.
SELECT COUNT(emp.codigo) FROM FROM departamento dep
  WHERE emp.apellido2 IS NOT NULL;


-- 9. Calcula el número de empleados que hay en cada departamento. Tienes que devolver dos columnas, una con el nombre del departamento y otra con el número de empleados que tiene asignados.
SELECT dep.nombre, COUNT(emp.codigo) FROM empleado emp
  INNER JOIN departamento dep ON emp.codigo_departamento = dep.codigo
  GROUP BY dep.nombre;


-- 10. Calcula el nombre de los departamentos que tienen más de 2 empleados. El resultado debe tener dos columnas, una con el nombre del departamento y otra con el número de empleados que tiene asignados.
SELECT dep.nombre, COUNT(emp.codigo) as "nEmpleados" FROM empleado emp
  INNER JOIN departamento dep ON emp.codigo_departamento = dep.codigo
  GROUP BY dep.nombre
  HAVING nEmpleados > 2;


-- 11. Calcula el número de empleados que trabajan en cada uno de los departamentos. El resultado de esta consulta también tiene que incluir aquellos departamentos que no tienen ningún empleado asociado.
SELECT dep.nombre, COUNT(emp.codigo) as "nEmpleados" FROM empleado emp
  RIGHT JOIN departamento dep ON emp.codigo_departamento = dep.codigo
  GROUP BY dep.codigo;


-- 12. Calcula el número de empleados que trabajan en cada unos de los departamentos que tienen un presupuesto mayor a 200000 euros.
SELECT dep.nombre, COUNT(emp.codigo) as "nEmpleados" FROM departamento dep
  RIGHT JOIN empleado emp ON emp.codigo_departamento = dep.codigo
  WHERE dep.presupuesto > 200000
  GROUP BY dep.codigo;





-- SUBCONSULTAS
SELECT d1.nombre, d1.presupuesto FROM departamento d1
	WHERE d1.presupuesto >= ALL (SELECT d2.presupuesto FROM departamento d2);
    
SELECT d1.nombre, d1.presupuesto  FROM departamento d1
	WHERE d1.presupuesto = (SELECT MAX(d2.presupuesto) FROM departamento d2);
    
-- departamentos con presupueto por encima de la media