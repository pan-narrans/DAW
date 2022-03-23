<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/horario">
    <head>
      <title>Horario - 2</title>
    </head>

    <xsl:for-each select="dia[numdia>3]">
      <h2>
        Día
        <xsl:value-of select="numdia" />
      </h2>
      <ol>
        <xsl:for-each select="tarea">
          <li>
            <xsl:value-of select="nombre" />
          </li>
        </xsl:for-each>
      </ol>
      <hr />
    </xsl:for-each>

  </xsl:template>

</xsl:stylesheet>