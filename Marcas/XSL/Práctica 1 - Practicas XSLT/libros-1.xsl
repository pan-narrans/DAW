<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output
  method="xml"
  version="1.0"
  encoding="UTF-8"
  indent="yes" />

  <xsl:template match="/repertorio">

    <repertorio>
      <xsl:for-each select="libro[autor='Miguel de Cervantes']">
        <libro>
          <titulo>
            <xsl:value-of select="titulo" />
          </titulo>
          <autor>
            <xsl:value-of select="autor" />
          </autor>
          <anyo_pub>
            <xsl:value-of select="anyo_pub" />
          </anyo_pub>
          <isbn>
            <xsl:value-of select="isbn" />
          </isbn>
        </libro>
      </xsl:for-each>
    </repertorio>

  </xsl:template>

</xsl:stylesheet>