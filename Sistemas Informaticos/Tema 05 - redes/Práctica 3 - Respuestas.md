# Práctica 3

- [Práctica 3](#práctica-3)
  - [Conversiones Binario - Decimal](#conversiones-binario---decimal)
  - [Identificación de la Clase de Red](#identificación-de-la-clase-de-red)
  - [Máscaras de Red por Defecto](#máscaras-de-red-por-defecto)
  - [Máscaras de Subred Adaptadas](#máscaras-de-subred-adaptadas)
    - [Problema Adaptadas 4](#problema-adaptadas-4)
    - [Problema Adaptadas 5](#problema-adaptadas-5)
    - [Problema Adaptadas 6](#problema-adaptadas-6)
  - [Subredes](#subredes)
    - [Problema Subredes 3](#problema-subredes-3)
    - [Problema Subredes 4](#problema-subredes-4)

## Conversiones Binario - Decimal

|  Binario | Decimal |   -   | Decimal | Binario  |
| -------: | :------ | :---: | ------: | :------- |
| 10010010 | 146     |       |     238 | 11101110 |
| 01110111 | 119     |       |      24 | 00011000 |
| 11111111 | 255     |       |     123 | 01111011 |
| 11000101 | 197     |       |      50 | 00110010 |
| 11110110 | 246     |       |     255 | 11111111 |
| 00010011 | 35      |       |     200 | 11001000 |
| 10000001 | 129     |       |      10 | 00001010 |
| 01111000 | 120     |       |     138 | 10001010 |
| 11110000 | 240     |       |       1 | 00000001 |
| 00111011 | 59      |       |      13 | 00001101 |
| 00000111 | 7       |       |     250 | 11111010 |
| 00011011 | 28      |       |     107 | 01101011 |
| 10101010 | 170     |       |     224 | 11100000 |
| 01101111 | 111     |       |     114 | 01110010 |
| 11111000 | 248     |       |     192 | 11000000 |
| 00100000 | 32      |       |     172 | 10101100 |
| 01010101 | 85      |       |     100 | 01100100 |
| 00111110 | 62      |       |     119 | 01110111 |
| 00000011 | 3       |       |      57 | 00111001 |
| 11101101 | 237     |       |      98 | 01100010 |
| 11000000 | 190     |       |     179 | 10110011 |

## Identificación de la Clase de Red

- Clase **A** : 1 -127
- Clase **B** : 128 - 191
- Clase **C** : 192 - 223
- Clase **D** : 224 - 239
- Clase **E** : 240 - 255

|     Dirección | Clase |
| ------------: | :---- |
|    10.250.1.1 | A     |
|   150.10.15.0 | B     |
|    192.14.2.0 | C     |
|    148.17.9.1 | B     |
|    193.42.1.1 | C     |
|   126.8.156.0 | A     |
|  220.200.23.1 | C     |
| 230.230.45.58 | D     |
|  177.100.18.4 | B     |
|   119.18.45.0 | B     |
| 249.240.80.78 | E     |
| 199.155.77.56 | C     |
|  117.89.56.45 | A     |
|   215.45.45.0 | C     |
|  199.200.15.0 | C     |
|    95.0.21.90 | A     |
|      33.0.0.0 | A     |
|   158.98.80.0 | B     |
|   219.21.56.0 | C     |

## Máscaras de Red por Defecto

|       Dirección | Máscara       |
| --------------: | :------------ |
|    177.100.18.4 | 255.255.0.0   |
|     119.18.45.0 | 255.0.0.0     |
| 191.249.234.191 | 255.255.0.0   |
|  223.23.223.109 | 255.255.255.0 |
|     10.10.250.1 | 255.0.0.0     |
|    126.123.23.1 | 255.0.0.0     |
|  223.69.230.250 | 255.255.0.0   |
|   192.12.35.105 | 255.255.255.0 |
|   77.251.200.51 | 255.0.0.0     |
|    189.210.50.1 | 255.255.0.0   |
|     88.45.65.35 | 255.0.0.0     |
| 128.212.250.254 | 255.255.0.0   |
|   193.100.77.83 | 255.255.0.0   |
|   125.125.250.1 | 255.0.0.0     |
|       1.1.10.50 | 255.0.0.0     |
|   220.90.130.45 | 255.255.0.0   |
|    134.125.34.9 | 255.255.0.0   |
|    95.250.91.99 | 255.0.0.0     |

## Máscaras de Subred Adaptadas

No he tenido en cuenta la subredes adaptadas, por lo mencionado en clase.

### Problema Adaptadas 4

|                                      |                 |
| ------------------------------------ | --------------- |
| Nº  de  subredes  útiles  necesarias | 6               |
| Nº  de  hosts  útiles  necesarios    | 30              |
| Dirección  de Red                    | 210.100.56.0    |
| Clase                                | C               |
|                                      |                 |
| Máscara de Subred (por defecto)      | 255.255.255.0   |
| Máscara de  Subred (adaptada)        | 255.255.255.224 |
| Nº  total de  subredes               | 8               |
|                                      |                 |
| Nº  total  de  direcciones  de  host | 32              |
| Nº  de  direcciones  útiles          | 30              |
| Nº  de  bits  cogidos                | 3               |

Muestre  aquí  su  forma  de  proceder  para  el  Problema  4:  

- nº de subredes necesarios: 6 < 2^3
- nº de hosts necesarios: 30 < 2^5
- 3 + 5 = 8 -> nos cabe en los bits reservados a host de una red C
- al nº de host siempre le restamos los 2 reservados (nombre de red y dirección de broadcast)
  
### Problema Adaptadas 5

|                                      |                 |
| ------------------------------------ | --------------- |
| Nº  de  subredes  útiles  necesarias | 6               |
| Nº  de  hosts  útiles  necesarios    | 30              |
| Dirección  de Red                    | 195.85.8.0      |
| Clase                                | C               |
|                                      |                 |
| Máscara de Subred (por defecto)      | 255.255.255.0   |
| Máscara de  Subred (adaptada)        | 255.255.255.224 |
| Nº  total de  subredes               | 8               |
|                                      |                 |
| Nº  total  de  direcciones  de  host | 32              |
| Nº  de  direcciones  útiles          | 30              |
| Nº  de  bits  cogidos                | 3               |

Muestre  aquí  su  forma  de  proceder  para  el  Problema  5:  

- exactamente lo mismo que el anterior.
  
### Problema Adaptadas 6

|                                      |             |
| ------------------------------------ | ----------- |
| Nº  de  subredes  útiles  necesarias | 126         |
| Nº  de  hosts  útiles  necesarios    | 131,070     |
| Dirección  de Red                    | 118.0.0.0   |
| Clase                                | A           |
|                                      |             |
| Máscara de Subred (por defecto)      | 255.0.0.0   |
| Máscara de  Subred (adaptada)        | 255.254.0.0 |
| Nº  total de  subredes               | 128         |
|                                      |             |
| Nº  total  de  direcciones  de  host | 131,072     |
| Nº  de  direcciones  útiles          | 131,070     |
| Nº  de  bits  cogidos                | 7           |

Muestre  aquí  su  forma  de  proceder  para  el  Problema  6:  

- nº de subredes necesarios: 126 < 2^7
- nº de hosts necesarios: 131,070 < 2^17
- 7 + 17 = 24 -> nos cabe en los bits reservados a host de una red C
- al nº de host siempre le restamos los 2 reservados (nombre de red y dirección de broadcast)
  
## Subredes

### Problema Subredes 3

|                                      |                 |
| ------------------------------------ | --------------- |
| Nº  de  subredes  útiles  necesarias | 1               |
| Dirección  de  Red                   | 195.223.50.0    |
| Clase                                | C               |
|                                      |                 |
| Máscara de Subred  (por defecto)     | 255.255.255.0   |
| Máscara de  Subred  (adaptada)       | 255.255.255.128 |
| Nº  total  de  subredes              | 2               |
|                                      |                 |
| Nº  total  de  direcciones  de  host | 128             |
| Nº  de  direcciones  útiles          | 124             |
|                                      |                 |
| Nº  de  bits  cogidos                | 7               |

 ¿Cuál es el 2º rango útil de subredes?

- 195.223.50.129 a  195.223.50.254

### Problema Subredes 4

|                                      |                 |
| ------------------------------------ | --------------- |
| Nº  de  subredes  útiles  necesarias | 1               |
| Dirección  de  Red                   | 195.223.50.0    |
| Clase                                | C               |
|                                      |                 |
| Máscara de Subred  (por defecto)     | 255.255.255.0   |
| Máscara de  Subred  (adaptada)       | 255.255.255.128 |
| Nº  total  de  subredes              | 2               |
|                                      |                 |
| Nº  total  de  direcciones  de  host | 128             |
| Nº  de  direcciones  útiles          | 124             |
|                                      |                 |
| Nº  de  bits  cogidos                | 7               |

 ¿Cuál es el 2º rango útil de subredes?

- 195.223.50.129 a  195.223.50.254
