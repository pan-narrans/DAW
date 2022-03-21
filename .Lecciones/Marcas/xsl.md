# XSL

```cmd
@author: Alejandro Pérez
```

- [XSL](#xsl)
  - [Basics](#basics)
    - [Connect to XML](#connect-to-xml)
    - [Preview changes](#preview-changes)
    - [Move around the XML doc](#move-around-the-xml-doc)
    - [HTML](#html)
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

Open the XML document in internet explorer.

### Move around the XML doc

---

We move around the XML and select items like we would in a console, using:
| symbol | meaning                     |
| :----: | --------------------------- |
|   .    | the current node            |
|   ..   | parent node                 |
|   *    | all elements of the level   |
|   @*   | all attributes of the level |
| e1/e2  | e2, direct child of e1      |
| e1//e2 | all e2, children of e1      |

It's possible to use both **absolute paths** and **relative paths** when selecting elements. When working with relative paths it's really important to be aware of where exactly we are on the XML tree.

Examples:

- The root of the XML is: `/root`
- All children of the root are: `/root/*`
- All siblings of an element from that same element: `../*`

### HTML

---

We can add HTML syntax almost anywhere inside the XML document.

## XSL elements

### Template

They come in two (2) flavors, `call` and `apply`. Their syntax goes like this:

```xsl
<!-- Used with CALL -->
<xsl:template name="mostrar_hijos" />

<!-- Used with APPLY -->
<xsl:template match="/horario" />
```

#### call-template

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

Allows to send parameters to the templates while calling them.

```xsl
<xsl:call-template name="mostrar_hijos">
  <xsl:with-param name="node" select="." />
</xsl:call-template>
```

### for-each

### if

### choose (switch)

## XSL functions

### sort

### value-of

### count

``` xsl
<xsl:value-of select="title" />
```
