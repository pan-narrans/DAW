# Práctica 9 - subnetting

- [Práctica 9 - subnetting](#práctica-9---subnetting)
  - [Enunciado](#enunciado)
  - [Solución](#solución)
    - [Redes](#redes)
      - [Wifi](#wifi)
      - [Hardware](#hardware)
      - [Software](#software)
      - [Administración](#administración)
      - [Servidores](#servidores)

## Enunciado

Tenemos una empresa denominada FP, que desea implantar una red para centralizar la gestión de su organización. La empresa tendrá las siguientes restricciones de direccionamiento:

- La dirección de red disponible para toda la red interna de la empresa y sus subredes será: 172.20.0.0/16
- El Router tendrá la última IP de subred disponible.
- Los servidores empezarán por la última IP de la subred disponible (la anterior al Router).
- Los clientes empezarán por la primera IP de la subred

Por otro lado, la empresa cuenta con los siguientes departamentos:

- Administración. 12 equipos y 1 impresora
- Wifi: 70 equipos
- Hardware: 20 equipos
- Software: 40 equipos
- Servidores:
  - Servidor web y ftp
  - Servidor de almacenamiento

Se pide:

- Realizar el cálculo de las subredes existentes indicando: dirección de la red, máscara de subred (en nº de bits y y decimal), dirección de broadcast, rango de direcciones disponibles, dirección del router y direcciones asignadas a los equipos. (Nota: Se puede indicar en el propio ejercicio del simulador con un texto para cada red)

Se entregará el fichero del simulador de Packet Tracer (se aceptará zip con documento para el punto 1, si así se desea)

## Solución

### Redes

| Nombre              | Octeto 1  | Octeto 2  | Octeto 3  |  Octeto 4   | Base |
| ------------------- | :-------: | :-------: | :-------: | :---------: | ---- |
| Red Base            |    172    |    20     |     0     |      0      | /16  |
|                     | 1010 1100 | 0001 0100 | 0000 0000 |  0000 0000  |      |
| Wifi (70)           |    172    |    20     |     0     |      0      | /25  |
|                     | 1010 1100 | 0001 0100 | 0000 0000 | 0`000 0000` |      |
| Hardware (20)       |    172    |    20     |     0     |      0      | /27  |
|                     | 1010 1100 | 0001 0100 | 0000 0000 | 000`0 0000` |      |
| Software (40)       |    172    |    20     |     0     |      0      | /26  |
|                     | 1010 1100 | 0001 0100 | 0000 0000 | 00`00 0000` |      |
| Administración (13) |    172    |    20     |     0     |      0      | /28  |
|                     | 1010 1100 | 0001 0100 | 0000 0000 | 0000 `0000` |      |
| Servidores (3)      |    172    |    20     |     0     |      0      | /30  |
|                     | 1010 1100 | 0001 0100 | 0000 0000 | 0000 00`00` |      |

Wifi (70 hosts):

- 2 ^ 7 = 128
- Necesitamos 7 bits para los host

Hardware (20 hosts):

- 2 ^ 5 = 32
- Necesitamos 5 bits para los host

Software (40 hosts):

- 2 ^ 6 = 64
- Necesitamos 6 bits para los host

Administración (13 hosts):

- 2 ^ 4 = 16
- Necesitamos 4 bits para los host

Servidores (3 hosts):

- 2 ^ 2 = 4
- Necesitamos 2 bits para los host

#### Wifi

| Wifi                                 |                                                 |
| ------------------------------------ | ----------------------------------------------- |
| Dirección de la red:                 | **172.20.0.0 /25**                              |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0`000 0000` |
| Máscara de subred:                   | **255.255.255.128**                             |
|                                      | 1111 1111 - 1111 1111 - 1111 1111 - 1000 0000   |
| Dirección de broadcast:              | **172.20.0.127**                                |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0111 1111   |
| Rango de direcciones:                | **172.20.0.1 a 172.20.0.126**                   |
| Dirección del router:                | **172.20.0.126**                                |
| Direcciones asignadas a los equipos: | **172.20.0.1 a 172.20.0.125**                   |

#### Hardware

| Hardware                             |                                                 |
| ------------------------------------ | ----------------------------------------------- |
| Dirección de la red:                 | **172.20.0.0 /27**                              |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 000`0 0000` |
| Máscara de subred:                   | **255.255.255.224**                             |
|                                      | 1111 1111 - 1111 1111 - 1111 1111 - 1110 0000   |
| Dirección de broadcast:              | **172.20.0.31**                                 |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0001 1111   |
| Rango de direcciones:                | **172.20.0.1 a 172.20.0.30**                    |
| Dirección del router:                | **172.20.0.30**                                 |
| Direcciones asignadas a los equipos: | **172.20.0.1 a 172.20.0.29**                    |

#### Software

| Software                             |                                                 |
| ------------------------------------ | ----------------------------------------------- |
| Dirección de la red:                 | **172.20.0.0 /26**                              |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 00`00 0000` |
| Máscara de subred:                   | **255.255.255.192**                             |
|                                      | 1111 1111 - 1111 1111 - 1111 1111 - 1100 0000   |
| Dirección de broadcast:              | **172.20.0.63**                                 |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0011 1111   |
| Rango de direcciones:                | **172.20.0.1 a 172.20.0.62**                    |
| Dirección del router:                | **172.20.0.62**                                 |
| Direcciones asignadas a los equipos: | **172.20.0.1 a 172.20.0.61**                    |

#### Administración

| Administración                       |                                                 |
| ------------------------------------ | ----------------------------------------------- |
| Dirección de la red:                 | **172.20.0.0 /28**                              |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0000 `0000` |
| Máscara de subred:                   | **255.255.255.240**                             |
|                                      | 1111 1111 - 1111 1111 - 1111 1111 - 1111 0000   |
| Dirección de broadcast:              | **172.20.0.15**                                 |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0000 1111   |
| Rango de direcciones:                | **172.20.0.1 a 172.20.0.14**                    |
| Dirección del router:                | **172.20.0.14**                                 |
| Direcciones asignadas a los equipos: | **172.20.0.1 a 172.20.0.13**                    |

#### Servidores

| Servidores                           |                                                 |
| ------------------------------------ | ----------------------------------------------- |
| Dirección de la red:                 | **172.20.0.0 /30**                              |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0000 00`00` |
| Máscara de subred:                   | **255.255.255.252**                             |
|                                      | 1111 1111 - 1111 1111 - 1111 1111 - 1111 1100   |
| Dirección de broadcast:              | **172.20.0.3**                                  |
|                                      | 1010 1100 - 0001 0100 - 0000 0000 - 0000 0011   |
| Rango de direcciones:                | **172.20.0.1 a 172.20.0.2**                     |
| Dirección del router:                | **172.20.0.2**                                  |
| Direcciones asignadas a los equipos: | **172.20.0.1 a 172.20.0.1**                     |
