# XSL

```cmd
@author: Alejandro Pérez, W3 Schools
```

- [XSL](#xsl)
  - [Basics](#basics)
    - [Connect to XML](#connect-to-xml)
    - [Preview changes](#preview-changes)
    - [HTML](#html)
  - [XPATH](#xpath)
    - [Basic Expressions](#basic-expressions)
      - [Examples of basic expressions](#examples-of-basic-expressions)
    - [Predicates](#predicates)
    - [Selecting Unknown Nodes](#selecting-unknown-nodes)
    - [Selecting Several Paths](#selecting-several-paths)
  - [XSL elements](#xsl-elements)
    - [Template](#template)
      - [call-template](#call-template)
      - [apply-templates](#apply-templates)
      - [with-param](#with-param)
    - [for-each](#for-each)
    - [if](#if)
    - [choose (switch)](#choose-switch)
  - [XSL functions](#xsl-functions)
    - [sort](#sort)
    - [value-of](#value-of)
    - [count](#count)

## Basics

### Connect to XML

---

This goes at the top of the XML file:

```xml
<?xml-stylesheet href="test1.xsl" type="text/xsl"?>
```

### Preview changes

---

Open the XML document in internet explorer. It works better if we open it in a private window, the cookies don't give us such a hard time thus.

### HTML

---

We can add HTML syntax almost anywhere inside the XML document.

## XPATH

Used to move around the XML document.

It's possible to use both **absolute paths** and **relative paths** when selecting elements. When working with relative paths it's really important to be aware of where exactly we are on the XML tree.

### Basic Expressions

| Expression | Description                                                                                            |
| :--------- | ------------------------------------------------------------------------------------------------------ |
| `nodename` | Selects all nodes with the name "_nodename_."                                                          |
| `/`        | Selects from the root node.                                                                            |
| `//`       | Selects nodes in the document from the current node that match the selection no matter where they are. |
| `.`        | Selects the current node.                                                                              |
| `..`       | Selects the parent of the current node.                                                                |
| `@`        | Selects attributes.                                                                                    |

#### Examples of basic expressions

| Path Expression   | Result                                                                                                       |
| ----------------- | ------------------------------------------------------------------------------------------------------------ |
| bookstore         | All nodes with the name "bookstore".                                                                         |
| `/`bookstore      | The root element bookstore<br>**Note:** If the path starts with a slash `/` it represents an absolute path!  |
| bookstore`/`book  | All book elements that are children of bookstore.                                                            |
| `//`book          | All book elements no matter where they are in the document.                                                  |
| bookstore`//`book | All book elements descendant of the bookstore element, no matter where they are under the bookstore element. |
| `//@`lang         | All attributes that are named lang.                                                                          |

### Predicates

Predicates are used to find a specific node or a node that contains a specific value.

| Path Expression                      | Result                                                                                                                     |
| ------------------------------------ | -------------------------------------------------------------------------------------------------------------------------- |
| /bookstore/book`[1]`                 | The first book element child of the bookstore element..                                                                    |
| /bookstore/book`[last()]`            | The last book element child of the bookstore element.                                                                      |
| /bookstore/book`[last()-1]`          | The last but one book element child of the bookstore element.                                                              |
| /bookstore/book`[position()<3]`      | The first two book elements children of the bookstore element.                                                             |
| //title`[@lang]`                     | All the title elements with an attribute named lang.                                                                       |
| //title`[@lang='en']`                | All the title elements with a "lang" attribute with a value of "en."                                                       |
| /bookstore/book`[price>35.00]`       | All the book elements of the bookstore element with a price element with a value greater than 35.00.                       |
| /bookstore/book`[price>35.00]`/title | All the title elements of the book elements of the bookstore element with a price element with a value greater than 35.00. |

### Selecting Unknown Nodes

XPath wildcards can be used to select unknown XML nodes.

| Wildcard | Description                  |
| -------- | ---------------------------- |
| `*`      | Matches any element node     |
| `@*`     | Matches any attribute node   |
| `node()` | Matches any node of any kind |

In the table below we have listed some path expressions and the result of the expressions:

| Path Expression | Result                                                                   |
| --------------- | ------------------------------------------------------------------------ |
| /bookstore/*    | Selects all the child element nodes of the bookstore element             |
| //*             | Selects all elements in the document                                     |
| //title[@*]     | Selects all title elements which have at least one attribute of any kind |

### Selecting Several Paths

By using the `|` operator in an XPath expression you can select several paths.

In the table below we have listed some path expressions and the result of the expressions:

| Path Expression                         | Result                                                                                                                 |
| --------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| //book/title          `\|` //book/price | Selects all the title AND price elements of all book elements                                                          |
| //title               `\|` //price      | Selects all the title AND price elements in the document                                                               |
| /bookstore/book/title `\|` //price      | Selects all the title elements of the book element of the bookstore element AND all the price elements in the document |

## XSL elements

### Template

---

They come in two (2) flavors, `call` and `apply`. Their syntax goes like this:

```xsl
<!-- Used with CALL -->
<xsl:template name="mostrar_hijos" />

<!-- Used with APPLY -->
<xsl:template match="/horario" />
```

#### call-template

---

Behaves like a **function**. You declare a template with a name attribute anywhere in your file and then call it with the call-template element.

```xsl
<!-- Declaration -->
<xsl:template name="show_children">
  <p>I'm a child!</p>
</template>

<!-- Application -->
<xsl:call-template name="show_children" />
```

#### apply-templates

---

Applies the template that best matches the given selection.

For example, for the given XML document:

```xml
<xml>
  <foo />
  <bar />
  <baz />
</xml>
```

And XSL document:

```xsl
<xsl:template match="xml">
  <xsl:apply-templates select="*" /> 
  <!-- Three nodes selected here, foo, bar and baz. -->
</xsl:template>

<!-- Will be called once (foo). -->
<xsl:template match="foo"> 
  <xsl:text>foo element encountered</xsl:text>
</xsl:template>

<!-- Will be called twice (bar and baz). -->
<xsl:template match="*"> 
  <xsl:text>other element countered</xsl:text>
</xsl:template>
```

#### with-param

---

Allows to send parameters to the templates while calling them.

```xsl
<xsl:call-template name="mostrar_hijos">
  <xsl:with-param name="node" select="." />
</xsl:call-template>
```

### for-each

---

### if

---

### choose (switch)

---

## XSL functions

### sort

---

### value-of

---

``` xsl
<xsl:value-of select="title" />
```

### count

---
