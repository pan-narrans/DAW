-- Obtener todos los datos de los administrativos (su trabajo es, en ingles, 'CLERK'), ordenado por el nombre.
SELECT * FROM empleado e
    WHERE UPPER(e.job) LIKE 'CLERK'
    ORDER BY e.eName;

-- Lista toda la información sobre los empleados cuyo nombre completo tenga mas de  5 caracteres.
SELECT * FROM empleado e
    WHERE LENGTH(eName) > 5;

-- Obtén los empleados que no son supervisados por ningún otro
SELECT * FROM empleado e
    WHERE e.mgr IS NULL;

-- Para los empleados que tengan comisión, obtén sus nombres y el cociente entre su salario y su comisión (excepto cuando la comisión sea cero ), ordenando el resultado por nombre.
SELECT 
    e.eName,
    e.salario / e.comision
    FROM empleado e
    WHERE e.comision IS NOT NULL AND e.comision <> 0
    ORDER BY e.eName;

-- Halla los datos de los empleados que, o bien su nombre empieza por A y su salario es superior a 1000, o bien reciben comisión y trabajan en el departamento 30.
SELECT * FROM empleado e
    WHERE
    UPPER(e.eName) LIKE "A%" AND e.salario > 1000
    OR e.comision IS NOT NULL AND e.comision <> 0 AND e.deptNo = 30;

-- Obtén el nombre, salario y la comisión de los empleados que tengan comisión y esté por debajo del 10% de su salario.
SELECT e.eName, e.salario, e.comision FROM empleado e
    WHERE 
    e.comision IS NOT NULL AND e.comision <> 0
    AND e.comision < e.salario * 0.1;

-- Obtén el salario MÁXIMO de todos los empleados y el nombre del empleado que más gana.
SELECT e1.eName, e1.salario FROM empleado e1
    WHERE (SELECT MAX(e2.salario) FROM empleado e2) = e1.salario;

-- Obtén el nombre de los empleados que trabajan en Dallas o New York. Visualiza el nombre y la localidad.
SELECT e.eName, d.Loc FROM empleado e
    INNER JOIN departamento d ON d.deptNo = e.deptNo
    WHERE UPPER(d.Loc) IN ('DALLAS', 'NEW YORK');

-- Obtén eN una sola columna el código de departamento, los dos primeros caracteres de su localidad y los tres primeros códigos de su localidad. Por ejemplo el departamento 10 será 10ACNEW
-- Nota: concat_w("cadena de unión", "cadena1 a unir", "cadena2 a unir",....)
-- SUBSTR(string, start, length)
SELECT
    CONCAT_WS("", d.deptNo, SUBSTR(d.dName, 1, 2), SUBSTR(d.Loc, 1, 3))
    FROM departamento d;

--  Haya el salario mínimo y máximo de cada uno de los departamentos. Visualiza el código de departamento,  el salario mínimo y el salario máximo.
SELECT d.deptNo, MIN(e.salario), MAX(e.salario)
    FROM departamento d
    INNER JOIN empleado e ON d.deptNo = e.deptNo
    GROUP BY d.deptNo;

