<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/ciudades">

    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta
        http-equiv="X-UA-Compatible"
        content="IE=edge" />
        <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0" />
        <title>Ejemplo XSLT</title>
      </head>
      <body>
        <xsl:for-each select="ciudad">
          <p>
            <xsl:value-of select="nombre" />
          </p>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>