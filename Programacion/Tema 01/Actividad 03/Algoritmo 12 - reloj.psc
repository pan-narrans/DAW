// Le pide al usuario que introduzca el tiempo
Funcion t <- PedirTiempo (t)
	tiempoValidado <- Falso
	Mientras !tiempoValidado Hacer
		Borrar Pantalla
		Escribir 'Reloj'
		Escribir '¿Cuantos segundos quieres esperar?'
		Leer t
		tiempoValidado <- ValidarTiempo(t)
	FinMientras
FinFuncion

// Valida que el tiempo sea un nº válido, no he conseguido validar que sea numérico de forma sencilla
Funcion tiempoValidado <- ValidarTiempo (t)
	tiempoValidado <- Verdadero
	Si t<=0 Entonces
		tiempoValidado <- Falso
		Escribir 'Introduce un número entero positivo por favor'
		Escribir 'Pulsa cualquier tecla para continuar'
		Esperar Tecla
	FinSi
FinFuncion

// Le pasas un nº y la cifra que quieres, 1 para decenas y 2 para unidades
Funcion return <- DosCifras (num,cifra)
	Si cifra=1 Entonces
		return <- TRUNC(num/10)
	SiNo
		Si cifra=2 Entonces
			return <- num MOD 10
		FinSi
	FinSi
FinFuncion

// Rellena los valores del array reloj
Funcion SetReloj (reloj,valores)
	Para fil<-1 Hasta 3 Hacer
		Para col<-1 Hasta 2 Hacer
			reloj[fil,col]<-DosCifras(valores[fil],col)
		FinPara
	FinPara
FinFuncion

// Calcula las horas y minutos a partir de los segundos
Funcion CalcularTiempo (valores)
	// valores[1] = h ; valores[2] = m ; valores[3] = s	
	// Segundos
	valores[3] <- valores[3]+1
	// Minutos
	Si valores[3]>=60 Entonces
		valores[2] <- valores[2]+1
		valores[3] <- 0
	FinSi
	// Horas
	Si valores[2]>=60 Entonces
		valores[1] <- valores[1]+1
		valores[2] <- 0
	FinSi
FinFuncion

Algoritmo SoyUnReloj
	// Tiempo
	t <- PedirTiempo(t)
	Dimension reloj[3,2]
	Dimension valores[3]
	// Contador
	c <- 0
	Mientras c<=t Hacer
		SetReloj(reloj,valores)
		Borrar Pantalla
		Escribir 'Reloj:'
		Escribir reloj[1,1],reloj[1,2],':',reloj[2,1],reloj[2,2],':',reloj[3,1],reloj[3,2]
		CalcularTiempo(valores)
		Esperar 1 Segundos
		c <- c+1
	FinMientras
FinAlgoritmo
