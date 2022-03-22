<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/horario">
    <ul>
      <xsl:apply-templates select="*" />
    </ul>
  </xsl:template>

  <xsl:template match="*">

    <li>
      <strong>
        <xsl:value-of select="position()" />
        <xsl:text> </xsl:text>
        <xsl:value-of select="name()" />
      </strong>
      <xsl:text> - Hijos </xsl:text>
      <xsl:value-of select="count(*)" />
    </li>

    <ul>
      <xsl:apply-templates select="*" />
    </ul>

  </xsl:template>

</xsl:stylesheet>