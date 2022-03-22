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

        <table>
          <tr>
            <th>Ciudad</th>
            <th>Habitantes</th>
          </tr>

          <xsl:for-each select="ciudad">
            <tr>
              <td>
                <xsl:value-of select="nombre" />
              </td>
              <td>
                <xsl:value-of select="habitantes" />
              </td>
            </tr>
          </xsl:for-each>

        </table>
      </body>

    </html>
  </xsl:template>

</xsl:stylesheet>