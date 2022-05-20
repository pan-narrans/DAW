# Subnetting IPV4

``` cmd
@author: Alejandro Pérez
```

- [Subnetting IPV4](#subnetting-ipv4)
  - [Introducción](#introducción)
  - [Direcciones IPv4](#direcciones-ipv4)
  - [Clasificación de direcciones IP](#clasificación-de-direcciones-ip)
    - [Accesibilidad](#accesibilidad)
    - [Perdurabilidad](#perdurabilidad)
    - [Según clase](#según-clase)
  - [Máscara de red y nombre de dominio](#máscara-de-red-y-nombre-de-dominio)
    - [Máscara de red](#máscara-de-red)
    - [Nombre de dominio (DNS)](#nombre-de-dominio-dns)
  - [Planificaciones de direcciones IP](#planificaciones-de-direcciones-ip)
  - [Cómo se comunican dos host](#cómo-se-comunican-dos-host)
    - [Dentro de una misma red](#dentro-de-una-misma-red)
    - [A través de dos redes distintas](#a-través-de-dos-redes-distintas)

## Introducción

El papel de la capa IP es averiguar cómo encaminar paquetes a su destino final. Cada interfaz en la red necesita una dirección IP, que **identifica tanto un ordenador concreto como la red a la que éste pertenece**. Se trata de una dirección única a nivel mundial.

> ℹ Las IPv4 se acabaron *(literalmente)* y ahora usamos [IPv6](subnetting-ipv6.md) para poder acomodar el nº tan grande de equipos conectados a la red.

## Direcciones IPv4

Una IPv4 son 32 bits de información normalmente expresados de forma decimal `167.216.245.249`. Cada nº está entre el 0 y el 255 inclusive. A nivel binario tenemos 4 grupos de 8 bit.

Hay IP's que no son válidas. No puede haber direcciones aisladas ya que todas tienen que depender de una red. Los 1ros bits de una IP identifica la red a la que pertenece y el resto identifican a los hosts de esa red.

Dentro de una misma red no puede haber direcciones duplicadas, pero nada impide que en dos redes que no estén conectadas existan dos IP con el mismo nombre *(dentro de dos redes privadas por ejemplo)*.

## Clasificación de direcciones IP

### Accesibilidad

- **Publicas**
  - Visibles por todos los host conectados a internet, no puede haber dos host con la misma dirección pública.
- **Privadas**
  - Visibles únicamente por los host de la propia red u otra red privada interconectada.
  - No pueden salir a internet, por lo que para acceder a la web necesitan pasar por un router o proxy que si que tenga asignada una dirección pública.

### Perdurabilidad

- **Estáticas**
  - Asignadas de forma fija a un host concreto, cuando una máquina con este tipo de IP se conecte a la red lo hará siempre con la misma dirección.
- **Dinámicas**
  - Se asignan sobre la marcha cada vez que el equipo se conecta a la red.

### Según clase

A la hora de crear una dirección para una red se tiene que tener en cuenta el tamaño de esta (el nº de host que va a albergar). Distinguimos principalmente entre 3 tipos de redes:

| Clase | ID  | Bits red | Bits host | 1er octeto |
| :---: | --- | :------: | :-------: | ---------- |
| **A** | 0   |    7     |    24     | 0 a 127    |
| **B** | 10  |    14    |    12     | 128 a 191  |
| **C** | 110 |    21    |     8     | 192 a 223  |

> 🙊 Es una tontería pero hay que acordarse, para sacar el nº de bits de red tenemos que restar los bits reservados para definir la clase.

Hay valores red reservados para usos concretos:

- del 223 al 255 *(1er octeto)* corresponden a las clases especiales D y E
- los valores 0 y 255 *(4to octeto)* no se le pueden asignar a ningún host de la red ya que están reservados para la máscara de red y para el broadcast respectivamente.
- `127.0.0.1` es la dirección de loopback y hace referencia a nuestro propio host, también se puede acceder a él con la palabra reservada *localhost*.

## Máscara de red y nombre de dominio

### Máscara de red

Para poder enrutar los paquetes necesitamos saber el nombre de la red de destino, para ello usamos la máscara de red.

> Consiste en poner todos los bits de red de la IP a 1 y los de host a 0.

De esta forma:

|         |                                               |
| ------- | --------------------------------------------- |
| IP      | 182.14.0.0 /16                                |
|         | 1011 0110 - 0000 1110 - 0000 0000 - 0000 0000 |
| Máscara | 255.255.0.0                                   |
|         | 1111 1111 - 1111 1111 - 0000 0000 - 0000 0000 |
|         |                                               |
| IP      | 182.14.0.0 /18                                |
|         | 1011 0110 - 0000 1110 - 0000 0000 - 0000 0000 |
| Máscara | 255.255.192.0                                 |
|         | 1111 1111 - 1111 1111 - 1100 0000 - 0000 0000 |

> 👍 Cuando tenemos direcciones de red que se salen de sus octetos, para sacar la máscara sin cagadas ayuda pasarlo todo a binario.

Al combinar con un AND la máscara de red y la dirección IP obtenemos la dirección de la red.

### Nombre de dominio (DNS)

Para no tener que recordar la retalía de números que es una dirección IP se optó por poder asignarles un nombre a las direcciones. Los nombres están registrados en el **DNS** (Domain Name System), tablas que relacionan las direcciones con su nombre de dominio.

## Planificaciones de direcciones IP

> No voy a explicar como se hace esto de forma detallada porque voy corto de tiempo 🐒

- Cuantos dispositivos tendrá la red
- Crea las subredes necesarias
- Especifica la máscara de subred
- Especifica las direcciones IP de las subredes
- Define las direcciones de broadcast de las subredes
- Define el rango de las máquinas en cada subred

---

Este sería el resultado final para una red que necesite 14 subredes con máximo 14 host, a partir de la red C 192.168.1.0:

| Red           | Direcciones de las maquinas   | Broadcast     |
| ------------- | ----------------------------- | ------------- |
| 192.168.1.0   | 192.168.1.1 - 192.168.1.14    | 192.168.1.15  |
| 192.168.1.16  | 192.168.1.1 - 192.168.1.30    | 192.168.1.31  |
| 192.168.1.32  | 192.168.1.33 - 192.168.1.46   | 192.168.1.47  |
| 192.168.1.48  | 192.168.1.49 - 192.168.1.62   | 192.168.1.63  |
| 192.168.1.64  | 192.168.1.65 - 192.168.1.78   | 192.168.1.79  |
| 192.168.1.80  | 192.168.1.81 - 192.168.1.94   | 192.168.1.95  |
| 192.168.1.96  | 192.168.1.97 - 192.168.1.110  | 192.168.1.111 |
| 192.168.1.112 | 192.168.1.113 - 192.168.1.126 | 192.168.1.127 |
| 192.168.1.128 | 192.168.1.129 - 192.168.1.142 | 192.168.1.143 |
| 192.168.1.144 | 192.168.1.145 - 192.168.1.158 | 192.168.1.159 |
| 192.168.1.160 | 192.168.1.161 - 192.168.1.174 | 192.168.1.175 |
| 192.168.1.176 | 192.168.1.177 - 192.168.1.190 | 192.168.1.191 |
| 192.168.1.192 | 192.168.1.193 - 192.168.1.206 | 192.168.1.207 |
| 192.168.1.208 | 192.168.1.209 - 192.168.1.222 | 192.168.1.223 |
| 192.168.1.224 | 192.168.1.225 - 192.168.1.238 | 192.168.1.239 |
| 192.168.1.240 | 192.168.1.241 - 192.168.1.254 | 192.168.1.25  |

## Cómo se comunican dos host

> Se ha visto de [forma teórica](intro-arquitectura-redes.md) y de [forma "práctica"](packet-transfer.md) en estos otros archivos.

Un paquete es enviado a través de las capas de la arquitectura implementada, pasa por el medio físico y llega finalmente hasta la máquina de destino.

### Dentro de una misma red

El host A le envía una query a toda la red preguntando por el host C. Todos los equipos salvo el interesado ignoran la query y el host C le responde a A de forma directa con su dirección **MAC**.

Una vez realizado este intercambio A y C ya tienen un canal de comunicación abierto.

### A través de dos redes distintas

Si A y C no se encuentran en la misma red, cuando A envíe el broadcast preguntando por C no le responderá nadie. Aquí entra en juego el router, que se encarga de conectar redes distintas.

Cuando nadie conteste a A, este le enviará la query al router que usará la máscara de red de C para buscar la red a la que pertenece y enviarle la query.

C recibirá el mensaje y responderá a A con su dirección MAC. Al igual que si estuvieran en la misma red, esto solo hace falta hacerlo una vez.

El router actuará como intermediario siempre para para conectar equipos enredes distintas.

---

> Go back to the [index](.index.md#index).
