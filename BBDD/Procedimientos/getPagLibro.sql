BEGIN
DECLARE ret Int;

SELECT l.numpag INTO ret
FROM libro l
WHERE l.libro = id;

RETURN ret;
END