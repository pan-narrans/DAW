<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/horario">
    <head>
      <title>Horario - 4</title>
    </head>

    <xsl:apply-templates select="dia">
      <xsl:sort
      select="numdia"
      order="descending" />
    </xsl:apply-templates>

  </xsl:template>

  <xsl:template match="dia">
    <h2>
      Día nº  
      <xsl:value-of select="numdia" />
    </h2>
    <ul>
      <xsl:apply-templates select="tarea" />
    </ul>
  </xsl:template>

  <xsl:template match="tarea">
    <h3>
      Tarea nº
      <xsl:value-of select="position()" />
    </h3>
    <ul>
      <xsl:for-each select="* | @*">
        <p>
          <xsl:value-of select="name()" />
          :
          <xsl:value-of select="." />
        </p>
      </xsl:for-each>
    </ul>
  </xsl:template>

</xsl:stylesheet>