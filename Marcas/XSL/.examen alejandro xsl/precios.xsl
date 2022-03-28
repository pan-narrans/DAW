<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" />
  <xsl:template match="/">
    <h2>TODOS LOS PRECIOS:</h2>
    <ul>
      <xsl:apply-templates select="//precio" />
    </ul>

    <h2>PRECIOS MENORES A 5:</h2>
    <ul>
      <xsl:apply-templates select="//precio[5>.]" />
    </ul>
  </xsl:template>

  <xsl:template match="precio">
    <li>
      <xsl:value-of select="." />
      <xsl:if test=".>100">
        : error, revisar precio.
      </xsl:if>
    </li>
  </xsl:template>

</xsl:stylesheet>