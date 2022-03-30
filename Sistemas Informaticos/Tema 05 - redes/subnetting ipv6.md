# Subnetting ipv6

- [Subnetting ipv6](#subnetting-ipv6)
  - [Información General](#información-general)
  - [Subredes Nacionales](#subredes-nacionales)
  - [Subredes Departamentales](#subredes-departamentales)
  - [Subredes dentro del Departamento](#subredes-dentro-del-departamento)

## Información General

|                                |                |
| -----------------------------: | :------------- |
|                    red Renata: | 2001:13F8::/32 |
| redes para cobertura nacional: | 256            |
|          redes departamentales | 16             |
|         redes por departamento | 60             |

## Subredes Nacionales

Este es el nombre completo de la red:

- 2001:13F8:0000::0000:0000:0000:0000:0000

Queremos 256 redes:

- `256 = 2^8`
- necesitamos 8 bits (2 nibble) para nombrar todas las redes 
  - teniendo en cuenta que en este ejercicio no nos piden que reservemos dos redes, si fuera ese el caso necesitaríamos coger 9 bits, 3 nibble

Cogemos entonces los dos nibble al nombre de la red para las subredes:

- 2001:13F8:`00`00::0000:0000:0000:0000:0000
- la nueva red es:
  - `2001:13F8::/40`
  - le sumamos los 8 bit de subred a los 32 de red originales
  - `32 + 8 = 40`
- la dirección de la 1ra subred es:
  - `2001:13F8::/40`
- la dirección de la última subred es:
  - `2001:13F8:FF::/40`

## Subredes Departamentales

Trabajamos con esta red:

- 2001:12F8:50::/40

Necesitamos 16 redes:

- `16 = 2^4`
- necesitamos 4 bit, 1 nibble para representar las 16 redes

Cogiendo el nibble necesario:

- la nueva red es:
  - `2001:12F8:50:/44`
  - 44 = 40 + 4 (los 4 bit que necesitamos para la red)
- la dirección de la 1ra subred es:
  - `2001:13F8:50:/44`
- la dirección de la última subred es:
  - `2001:13F8:50F::/44`

## Subredes dentro del Departamento

Tomamos como base la red:

- 2001:13F8:512::/44

Necesitamos 60 redes:

- 62 = 2^6
- necesitamos 6 bit, 2 nibble, para representar las redes

Cogiendo los dos nibble necesarios:

- la nueva red es:
  - `2001:13F8:512::/52`
  - 52 = 44 + 8 (los 8 bit de los dos nibble)
- la dirección de la 1ra subred es:
  - `2001:13F8:512::/52`
- la dirección de la última subred es:
  - `2001:13F8:5123:C::/52`
