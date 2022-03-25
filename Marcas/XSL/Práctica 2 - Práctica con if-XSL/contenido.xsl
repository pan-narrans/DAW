<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- Crea un xsl donde se, muestre el identificador del evento siempre y cuando este sea opcional . En la página resultante no saldrá nada relacionada con el elemento noticias -->

  <xsl:template match="/">
    <xsl:apply-templates select="//evento[@opcional='yes']" />
  </xsl:template>

  <xsl:template match="evento">
    <p>
      <xsl:value-of select="@id_evento" />
    </p>
  </xsl:template>

</xsl:stylesheet>