    Resumen XML y XSD:
    @author: Alejandro Pérez


- [**XML**](#xml)
  - [Conectar **XML** y **XSD**](#conectar-xml-y-xsd)
- [**XSD**](#xsd)
- [Template](#template)
  - [Pluggin](#pluggin)


# **XML**

## Conectar **XML** y **XSD**

La 1ra parte no tengo claro aún que significa ("``xmlns:xsi``").

La 2da parte ("``xsi:noNamespaceSchemaLocation``") es el path a nuestro archivo XSL.

XML:
``` XML
<vehiculos xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="vehiculos.xsd">
```
---

Esto importa los tipos definidos en la URL proporcionada.
 > xs:string, xs:float, ect...

XSD:
``` XML
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
```

# **XSD**

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


# Template


XML
``` XML
<?xml version="1.0" encoding="ISO-8859-1"?>
<root xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="shcema.xsd">
  <element>
  </element>
</root>
```

XSD
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

## Pluggin
El pluggin 
[XML de Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.vscode-xml) 
en vscode permite realizar todo esto de forma quasi automática. Llegando al punto de generar un schema a partir de un archivo XML. 

Se encarga de realizar la validación del XML y da información pertinente en caso de error.