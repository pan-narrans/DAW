<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- Crea un xsl donde se, muestre el identificador del evento siempre y cuando este sea opcional . En la página resultante no saldrá nada relacionada con el elemento noticias -->

  <xsl:template match="/">
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta
        http-equiv="X-UA-Compatible"
        content="IE=edge" />
        <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
      </head>

      <body>

        <xsl:for-each select="contenido/eventos/evento">
          <!-- titulo -->
          <h2>
            Evento nº
            <xsl:value-of select="count(/*)" />
          </h2>

          <!-- mostrar opcional -->
          <xsl:if test="@opcional = 'yes'">
            <xsl:call-template name="mostrar">
              <xsl:with-param
              name="cosa"
              select="@opcional" />
            </xsl:call-template>
          </xsl:if>

          <!-- mostrar contenido -->
          <xsl:for-each select="*">
            <xsl:call-template name="mostrar">
              <xsl:with-param
              name="cosa"
              select="." />
            </xsl:call-template>
          </xsl:for-each>
        </xsl:for-each>

      </body>

    </html>
  </xsl:template>

  <xsl:template name="mostrar">
    <xsl:param name="cosa" />
    <p>
      <strong>
        <xsl:value-of select="name($cosa)" />
        :
      </strong>
      <xsl:value-of select="$cosa" />
    </p>
  </xsl:template>

</xsl:stylesheet>