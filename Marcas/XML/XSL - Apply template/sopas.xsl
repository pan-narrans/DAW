<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h1>Restaurante Sopero</h1>
        <h2>Sopas</h2>

        <ul>

          <xsl:for-each select="cocina/sopas/sopa">
            <xsl:sort select="@precio" />
            <li>
              <xsl:value-of select="@nombre" />
              -
              <xsl:value-of select="@precio" />
              <br />
              Ingredientes:
              <xsl:for-each select="./ingredientes/ingrediente">
                <xsl:value-of select="." />
                -
              </xsl:for-each>

            </li>
          </xsl:for-each>

        </ul>

        <h2>Postres</h2>
        <ul>
          <xsl:for-each select="cocina/postres/titulo">
            <xsl:sort select="@precio" />
            <li>
              <xsl:value-of select="." />
              -
              <xsl:value-of select="@precio" />

            </li>
          </xsl:for-each>
        </ul>

      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>