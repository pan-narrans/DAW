<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" />
  <xsl:template match="/libro[titulo='Dos por tres calles']">

    <head>
      <title>Ejercicio 1</title>
    </head>

    <h1>
      Breve muestra del libro "
      <xsl:value-of select="titulo" />
      ":
    </h1>

    <xsl:apply-templates select="capitulo" />

    <!-- 
      Para mostrar únicamente el contenido del capítulo y no el de sus hijos tenemos que hacer uso de los templates.

      Como el contenido del párrafo también es mixto, tenemos que hacer uso también de los parámetros para decidir cuando mostrar el contenido y cuando no.

      Si no hicieramos esto, al mostrar el contenido del capítulo también se mostraría el contenido del párrafo tal y como lo tenemos formateado.
    -->
  </xsl:template>

  <xsl:template match="capitulo">
    <h2>
      CAPÍTULO
      <xsl:value-of select="@num" />
      :
      <xsl:apply-templates>
        <xsl:with-param
        name="show"
        select="false()" />
      </xsl:apply-templates>
    </h2>

    <xsl:if test="@num=2">
      <xsl:apply-templates select="parrafo">
        <xsl:with-param
        name="show"
        select="true()" />
      </xsl:apply-templates>
    </xsl:if>
  </xsl:template>

  <xsl:template match="parrafo">
    <xsl:param name="show" />
    <xsl:if test="$show">
      <p>
        <xsl:apply-templates />
      </p>
    </xsl:if>
  </xsl:template>

  <xsl:template match="enlace">
    <a href="@href">
      <xsl:value-of select="." />
    </a>
  </xsl:template>

</xsl:stylesheet>