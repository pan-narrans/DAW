BEGIN
DECLARE ret INT;

SELECT SUM(l.numpag) INTO ret
FROM libro l
INNER JOIN prestamo p ON p.libro = l.libro
WHERE p.socio = soc;

RETURN ret;
END