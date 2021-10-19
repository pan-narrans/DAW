Algoritmo DistanciaEntrePuntos
	Dimension p1[2]
	Dimension p2[2]
	Escribir 'Calcular la distancia entre dos puntos'
	Escribir 'Introduce las coordenadas del 1er punto.'
	Escribir 'X = ?'
	Leer p1[1]
	Escribir 'Y = ?'
	Leer p1[2]
	Escribir 'Introduce las coordenadas del 2do punto.'
	Escribir 'X = ?'
	Leer p2[1]
	Escribir 'Y = ?'
	Leer p2[2]
	c1 <- ABS(p2[1]-p1[1])
	c2 <- ABS(p2[2]-p1[2])
	h <- RAIZ(c1^2+c2^2)
	Escribir 'La distancia entre los dos puntos es de ',h,' unidades.'
FinAlgoritmo
