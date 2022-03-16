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
  - [XSL functions](#xsl-functions)
    - [template](#template)
    - [call-template](#call-template)
      - [with-param](#with-param)
    - [for-each](#for-each)
    - [if](#if)
    - [sort](#sort)
    - [value-of](#value-of)

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

## XSL functions

### template

### call-template

#### with-param

### for-each

### if

### sort

### value-of

``` xsl
<xsl:value-of select="title" />
```
