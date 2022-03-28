<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <h2>PEDIDOS:</h2>
    <xsl:apply-templates select="//pedido" />

    <h2>LIBROS CON PRECIO MENOR A 9:</h2>
    <ul>
      <xsl:apply-templates select="//libro[9>precio]" />
    </ul>

    <h2>LIBROS EN ORDEN DESCENDIENTE:</h2>
    <ul>
      <xsl:apply-templates select="//libro">
        <xsl:sort
        select="titulo"
        order="descending" />
      </xsl:apply-templates>
    </ul>
    <!-- Para mostrar todos los títulos en orden descendiente he aplicado el template de libro con un sort por título. -->
    <!-- Podría haberlo hecho de la misma forma con un for-each y un sort dentro del for-each. -->
  </xsl:template>

  <xsl:template match="pedido">
    <h3>
      PEDIDO:
      <xsl:value-of select="@idorden" />
    </h3>
    <ul>
      <li>
        <strong>
        REMITENTE: </strong>
        <xsl:value-of select="remitente" />
      </li>
      <li>
        <strong>
        RECEPTOR: </strong>
        <br />
        <xsl:value-of select="receptor/nombre" />
        <br />
        <xsl:value-of select="receptor/direccion" />
        -
        <xsl:value-of select="receptor/ciudad" />
      </li>
      <li>
        <strong>
        CONTENIDO DEL PAQUETE: </strong>
        <br />
        <xsl:for-each select="libro">
          Libro:
          <xsl:value-of select="titulo" />
          <br />
        </xsl:for-each>
      </li>
    </ul>
  </xsl:template>

  <xsl:template match="libro">
    <li>
      <xsl:value-of select="titulo" />
    </li>
  </xsl:template>

</xsl:stylesheet>