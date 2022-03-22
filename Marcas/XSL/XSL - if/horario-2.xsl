<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <ol>
      <xsl:for-each select="*">
        <xsl:apply-templates select="*" />
      </xsl:for-each>
    </ol>

  </xsl:template>

  <xsl:template match="*">

    <li>
      <strong>
        <xsl:value-of select="name(.)" />
      </strong>
      <xsl:text> - Hijos </xsl:text>
      <xsl:value-of select="count(*)" />
    </li>

    <ol>
      <xsl:apply-templates select="*" />
    </ol>

  </xsl:template>

</xsl:stylesheet>