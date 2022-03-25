<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <h1>Comentarios en la red</h1>
    <ul>
      <xsl:apply-templates select="//comentario" />
    </ul>
  </xsl:template>

  <xsl:template match="comentario">
    <li>
      <xsl:value-of select="autor" />
      :
      <xsl:value-of select="mensaje" />
      <br />
      A
      <xsl:value-of select="megusta/@numero" />
      personas les gusta esto.
    </li>
  </xsl:template>

</xsl:stylesheet>