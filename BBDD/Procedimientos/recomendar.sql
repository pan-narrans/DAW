BEGIN

SELECT l.titulo,
IF (getPagMax(soc) >= l.numpag * 0.25, "RECOMENDADO", "NO RECOMENDADO")
FROM libro l
WHERE l.libro NOT IN (
  SELECT p.libro  from prestamo p
  where p.socio = soc );

END









BEGIN
DECLARE string VARCHAR(100); 

CASE
	getPagMax(soc) >= getPagLibro(lib) * 0.25


IF getPagMax(soc) >= getPagLibro(lib) * 0.25
	SELECT string = "RECOMENDADO";
ELSE
	SELECT string = "NO RECOMENDADO";

RETURN string;
END



BEGIN
DECLARE string VARCHAR(100); 
SET string = "";

CASE
	WHEN getPagMax(soc) >= getPagLibro(lib) * 0.25
	THEN SET string = "RECOMENDADO";
ELSE
	SET string = "NO RECOMENDADO";

RETURN string;
END





BEGIN
DECLARE @string VARCHAR(100); 
SET @string = "no valido";

CASE
	WHEN getPagMax(soc) >= getPagLibro(lib) * 0.25
	THEN SET @string = "RECOMENDADO";
ELSE
	SET @string = "NO RECOMENDADO";
END CASE

RETURN @string;
END