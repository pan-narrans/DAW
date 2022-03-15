<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <body>
        <xsl:for-each select="catalog/cd">
          <p>
            <xsl:value-of select="/TITLE" />
          </p>
          <!-- <xsl:call-template name="show_title">
            <xsl:with-param name="title" select="title" />
          </xsl:call-template> -->
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>

  <!-- <xsl:template name="show_title">
    <xsl:param name="title" />
    <p>
      Title:
      <xsl:value-of select="$title" />
    </p>
  </xsl:template> -->

</xsl:stylesheet> 