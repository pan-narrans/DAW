Algoritmo BottlesOfBeer
	numBottles <- 99
	bottle <- 'bottles'
	Mientras numBottles>0 Hacer
		Escribir numBottles,' ',bottle,' of beer on the wall, ',numBottles,' ',bottle,' of beer'
		numBottles <- numBottles-1
		Si numBottles<2 Entonces
			bottle <- 'bottle'
		FinSi
		Si numBottles>1 Entonces
			Escribir 'Take one down and pass it around, ',numBottles,' ',bottle,' of beer on the wall'
		SiNo
			Escribir 'Take one down and pass it around, no bottles of beer on the wall'
		FinSi
	FinMientras
FinAlgoritmo
