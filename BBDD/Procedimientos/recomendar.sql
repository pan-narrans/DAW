CREATE PROCEDURE `recomendar` (IN `soc` INT) 
NOT DETERMINISTIC CONTAINS SQL SQL SECURITY DEFINER BEGIN

BEGIN

SELECT l.libro FROM libro l
WHERE l.libro NOT IN (
  SELECT p.libro  from prestamo p
  where p.socio = soc )

END