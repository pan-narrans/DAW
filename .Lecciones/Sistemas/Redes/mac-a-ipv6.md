# Conversión de una dirección MAC a IPv6

``` cmd
@author: Alejandro Pérez
```

- [Conversión de una dirección MAC a IPv6](#conversión-de-una-dirección-mac-a-ipv6)
  - [Partimos la mac en dos](#partimos-la-mac-en-dos)
  - [Añadimos fffe en medio](#añadimos-fffe-en-medio)
  - [Invertimos el 7º bit](#invertimos-el-7º-bit)
  - [Añadimos fe80:: al principio y agrupamos en hextetos](#añadimos-fe80-al-principio-y-agrupamos-en-hextetos)

Vamos a trabajar con esta dirección MAC siguiendo el ejemplo realizado en clase:

> `5274f2b1a87f`

## Partimos la mac en dos

> `5274f2 - b1a87f`

## Añadimos fffe en medio

> `5274f2 - fffe - b1a87f`

## Invertimos el 7º bit

El 7º bit se encuentra en el segundo dígito de la MAC *(cada dígito corresponde a 4 bit)*.

| Sin invertir  | Invertido     |
| ------------- | ------------- |
| 5 - 2         | 5 - 0         |
| 0101 - 00`1`0 | 0101 - 00`0`0 |

> `5074f2 - fffe - b1a87f`

## Añadimos fe80:: al principio y agrupamos en hextetos

> `fe80::5074:f2ff:feb1:a87f`

---

> Go back to the [index](.index.md#index).
