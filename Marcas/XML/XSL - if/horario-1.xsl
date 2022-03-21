<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/horario">

    <ol>
      <xsl:for-each select="*">
        <xsl:call-template name="mostrar_hijos">
          <xsl:with-param
          name="node"
          select="." />
        </xsl:call-template>
      </xsl:for-each>
    </ol>

  </xsl:template>

  <xsl:template name="mostrar_hijos">
    <xsl:param name="node" />

    <li>
      <strong>
        <xsl:value-of select="name(.)" />
      </strong>
      <xsl:text> - Hijos </xsl:text>
      <xsl:value-of select="count(*)" />
    </li>

    <ol>
      <xsl:for-each select="*">
        <xsl:call-template name="mostrar_hijos">
          <xsl:with-param
          name="node"
          select="." />
        </xsl:call-template>
      </xsl:for-each>
    </ol>
   

  </xsl:template>

</xsl:stylesheet>