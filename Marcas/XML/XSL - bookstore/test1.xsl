<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">

    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>XSL Test nº1</title>
      </head>
      <body>

        <h1>Books:</h1>

        <xsl:for-each select="catalog/book">

          <!-- sorts the books based on their title -->
          <xsl:sort select="title" />

          <!-- prints the title as header -->
          <h2>
            <xsl:value-of select="title" />
            :
          </h2>

          <ul>
            <!-- loops through the book's child elements -->
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

        </xsl:for-each>

      </body>
    </html>
  </xsl:template>

  <xsl:template match="//book/title">

  </xsl:template>

</xsl:stylesheet>