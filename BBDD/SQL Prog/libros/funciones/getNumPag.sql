DROP FUNCTION IF EXISTS getNumPag;

DELIMITER $$

/*
  Recibe como parámetro la id del libro.
  Devuelve el nº de pag de un libro.
*/

CREATE FUNCTION getNumPag (libro INT)
RETURNS INT(11)
BEGIN

RETURN(
  SELECT libro.numpag FROM libro 
  WHERE libro.libro = libro
);

END $$

DELIMITER ;

-- PRUEBAS
SELECT libro.titulo, libro.numpag,
  getNumPag(libro.libro) 
  AS "Nº Páginas Calculado" FROM libro;