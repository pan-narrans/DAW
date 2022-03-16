<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>XSL Test nº2</title>
      </head>
    </html>
    <body>
      <h1>
        <xsl:value-of select="name(/catalog)" />
      </h1>
    </body>
  </xsl:template>
</xsl:stylesheet>