<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/test1">

    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta
        http-equiv="X-UA-Compatible"
        content="IE=edge" />
        <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0" />
        <title>
          <xsl:value-of select="titulo" />
        </title>
      </head>
      <body>
        <h2>
          <xsl:value-of select="fecha" />
        </h2>
        <h2>
          <xsl:value-of select="titulo" />
        </h2>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>