<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <HTML>
      <BODY>
        <TABLE border="1" cellspacing="0" cellpadding="2">
          <xsl:apply-templates select="customers/customer">
            <xsl:sort select="state" />
            <xsl:sort select="name" />
          </xsl:apply-templates>
        </TABLE>
      </BODY>
    </HTML>
  </xsl:template>

  <xsl:template match="customer">
    <TR>
      <xsl:apply-templates select="name" />
      <xsl:apply-templates select="address" />
      <xsl:apply-templates select="state" />
      <xsl:apply-templates select="phone" />
      <xsl:apply-templates select="phone" mode="accountNumber" />
    </TR>
  </xsl:template>

  <xsl:template match="name">
    <TD STYLE="font-size:14pt font-family:serif">
      <xsl:apply-templates />
    </TD>
  </xsl:template>

  <xsl:template match="address">
    <TD>
      <xsl:apply-templates />
    </TD>
  </xsl:template>

  <xsl:template match="state">
    <TD>
      <xsl:apply-templates />
    </TD>
  </xsl:template>

  <xsl:template match="phone">
    <TD>
      <xsl:apply-templates />
    </TD>
  </xsl:template>

  <xsl:template match="phone" mode="accountNumber">
    <TD STYLE="font-style:italic">
      1-
      <xsl:value-of select="." />
      -001
    </TD>
  </xsl:template>

</xsl:stylesheet>