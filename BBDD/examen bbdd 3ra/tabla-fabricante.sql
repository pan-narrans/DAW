/*
Modifica la tabla fabricante añadiendo dos columnas Margen1 y Margen2 que son del tipo 
decimal(4,2) y son los porcentajes que deja el fabricante aplicar a sus productos.
*/

ALTER TABLE fabricante 
ADD Margen1 DECIMAL(4,2) NOT NULL AFTER nombre, 
ADD Margen2 DECIMAL(4,2) NOT NULL AFTER Margen1; 

UPDATE fabricante SET Margen1 = '0.1';
UPDATE fabricante SET Margen2 = '0.05';