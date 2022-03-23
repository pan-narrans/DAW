<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/horario">
    <head>
      <title>Horario - 1</title>
    </head>
    <h2>
      Número de días:
      <xsl:value-of select="count(*)" />
    </h2>
  </xsl:template>
</xsl:stylesheet>