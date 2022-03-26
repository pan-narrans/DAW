<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <h1>Matemáticas</h1>
    <xsl:apply-templates select="//alumno">
      <xsl:sort select="nombre" />
    </xsl:apply-templates>
  </xsl:template>

  <xsl:template match="alumno">
    <!-- DATOS DEL ALUMNO -->
    <h2>
      <xsl:value-of select="nombre" />
      : exp
      <xsl:value-of select="expediente" />
    </h2>

    <!-- NOTAS -->
    <ul>
      <xsl:for-each select="*[contains(name(), 'nota')]">
        <li>
          <strong>
            <xsl:value-of select="name()" />
          </strong>
          :
          <xsl:value-of select="." />
        </li>
      </xsl:for-each>
    </ul>
  </xsl:template>

</xsl:stylesheet>