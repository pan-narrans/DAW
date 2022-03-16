<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- CALL TEMPLATE WITH PARAMETER -->

  <xsl:template match="/">

    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>XSL Test nº3</title>
      </head>

      <body>

        <h1>
          <xsl:value-of select="name(/*)" />
        </h1>

        <xsl:for-each select="catalog/book">
          <xsl:value-of select="name(../../*)" />
          <xsl:call-template name="show_item">
            <xsl:with-param name="item" select="." />
          </xsl:call-template>
        </xsl:for-each>

        <xsl:for-each select="catalog/magazine">
          <xsl:call-template name="show_item">
            <xsl:with-param name="item" select="." />
          </xsl:call-template>
        </xsl:for-each>

      </body>
    </html>
  </xsl:template>

  <xsl:template name="show_item">
    <xsl:param name="item" />

    <!-- prints the title as header -->
    <h2>
      <xsl:value-of select="name(.)" />
      -
      <xsl:value-of select="title" />
      :
    </h2>

    <ul>
      <xsl:for-each select="*">
        <li>
          <!-- gets the element name -->
          <xsl:value-of select="name(.)" />
          :
          <!-- gets the element value -->

          <xsl:value-of select="." />
        </li>
      </xsl:for-each>
    </ul>

  </xsl:template>

</xsl:stylesheet>