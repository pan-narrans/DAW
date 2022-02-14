    Resumen XML y XSD:
    @author: Alejandro Pérez


- [**XML**](#xml)
  - [Conectar **XML** y **XSD**](#conectar-xml-y-xsd)
  - [Caracteres especiales](#caracteres-especiales)
- [**XSD** basics](#xsd-basics)
  - [Elementos y atributos](#elementos-y-atributos)
    - [default / fixed](#default--fixed)
  - [Tipos](#tipos)
    - [simple / complex](#simple--complex)
    - [secuencia / all](#secuencia--all)
  - [refs / name](#refs--name)
- [**XSD** Restricciones](#xsd-restricciones)
  - [pattern](#pattern)
  - [enum](#enum)
  - [min / max](#min--max)
  - [length](#length)
  - [whitespace](#whitespace)
- [Init Template](#init-template)
  - [**XML**](#xml-1)
  - [**XSD**](#xsd)
  - [Plugin](#plugin)
- [**XSD** old](#xsd-old)
  - [refs](#refs)
  - [Restricciones](#restricciones)


# **XML**

## Conectar **XML** y **XSD**

La 1ra parte no tengo claro aún que significa ("``xmlns:xsi``").

La 2da parte ("``xsi:noNamespaceSchemaLocation``") es el path a nuestro archivo XSL.

XML:
``` XML
<vehiculos xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="vehiculos.xsd">
```
---

XSD:
``` XML
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
```

Esto importa los tipos definidos en la URL proporcionada
(xs:string, xs:float, ect...).


## Caracteres especiales

Algunos caracteres están reservados a la sintaxis de XML y el usarlos nos puede ~~joder~~ descuadrar el documento. Para ponerlos sin liarla podemos hacer uso de los códigos de la siguiente tabla.

| Código   | Char |                |
| -------- | ---: | :------------- |
| `&lt;  ` |  < : | less than      |
| `&gt;  ` |  > : | greater than   |
| `&amp; ` |  & : | ampersand      |
| `&apos;` |  ' : | apostrophe     |
| `&quot;` |  " : | quotation mark |



# **XSD** basics
## Elementos y atributos

``` XML
<root num="56">
  <ciudad>Madrid</ciudad>
  <fecha_nacimiento>09/06/1996</fecha_nacimiento>
</root>
```

``` XSD
</xs:sequence>
  <xs:element name="ciudad" type="xs:string" />
  <xs:element name="fecha_nacimiento" type="xs:date" />
</xs:sequence>
<xs:attribute name="num" type="xs:integer" use="required" />
```

Los atributos se definen después de los elementos y fuera del `sequence`. Al igual que estos, dependen del elemento directamente superior. En este ejemplo, el root.

### default / fixed

Valor por defecto o valor fijo. No tiene mucho más. Valen tanto para atributos como para elementos.

``` XSD
<xs:element name="1" type="xs:boolean" default="false" />
<xs:attribute name="2" type="xs:boolean" fixed="true" />
``` 

## Tipos
### simple / complex



### secuencia / all
## refs / name

# **XSD** Restricciones
## pattern
## enum
## min / max
## length
## whitespace



# Init Template

## **XML**
``` XML
<?xml version="1.0" encoding="ISO-8859-1"?>
<root xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema.xsd">
  <element>
  </element>
</root>
```

## **XSD**
``` XML
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">  
<xs:element name="root">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="element" type="xs:string" />
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
```

## Plugin
El plugin 
[XML de Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.vscode-xml) 
en vscode permite realizar todo esto de forma casi automática. Llegando al punto de generar un schema a partir de un archivo XML. 

Se encarga de realizar la validación del XML y da información pertinente en caso de error ~~no como XML copy~~.














# **XSD** old
## refs
Podemos declarar un **tipo**:
``` XML
  <xs:complexType name="date">
    <xs:sequence>
      <xs:element name="dia" type="xs:string" />
      <xs:element name="mes" type="xs:string" />
      <xs:element name="anyo" type="xs:string" />
    </xs:sequence>
  </xs:complexType>
```
Y reutilizarlo posteriormente para no duplicar código:
``` XML
  <xs:element name="fabricacion">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="inicio" type="date" />
        <xs:element name="fin" type="date" />
      </xs:sequence>
    </xs:complexType>
  </xs:element>
```
---
De la misma forma, podemos declarar un **elemento**:
``` XML
  <xs:element name="modificaciones">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="modificacion" maxOccurs="unbounded" type="xs:string" />
      </xs:sequence>
    </xs:complexType>
  </xs:element>
```
``` XML
  <xs:element name="vehiculo">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="nombre" type="xs:string" maxOccurs="unbounded" />
        <xs:element name="modelo" type="xs:string" />
        <xs:element ref="fabricacion" />
        <xs:element ref="modificaciones" />
      </xs:sequence>
    </xs:complexType>
  </xs:element>
```
Para luego referenciarlo:
``` XML
  <xs:element name="vehiculos">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="vehiculo" maxOccurs="unbounded" />
      </xs:sequence>
    </xs:complexType>
  </xs:element>
```
De esta forma podemos organizar mejor nuestro código para no perdernos y hacerlo más reutilizable.


## Restricciones

``` xml
  <xs:simpleType name="edad">
    <xs:restriction base="xs:integer">
      <xs:minInclusive value="0" />
      <xs:maxInclusive value="130" />
    </xs:restriction>
  </xs:simpleType>

  <xs:complexType name="ficha_datos">
    <xs:sequence>
      <xs:element name="edad" type="edad" />
    </xs:sequence>
    <xs:attribute name="numero" type="xs:integer" use="required" />
  </xs:complexType>
```


