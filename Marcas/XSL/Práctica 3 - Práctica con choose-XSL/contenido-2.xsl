<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- Realizar una hoja de estilos xsl que nos permita obtener la siguiente salida en el navegador: -->
  <!-- 1. Si el evento es opcional. Mostrar el título y en formato h3 mostrar el número del identificador del evento -->
  <!-- 2. Si el evento es obligatorio. Mostrar el título y el texto “Evento obligatorio” -->
  <!-- 3. En otro caso. Mostrar el título y el párrafo Evento sin parámetro opcional o con valor erróneo -->

  <xsl:template match="/">
    <xsl:apply-templates select="//evento" />
  </xsl:template>

  <xsl:template match="evento">

    <h3>
      <xsl:value-of select="titulo" />
    </h3>

    <xsl:choose>
      <xsl:when test="@opcional='no'">
        <p>Evento obligatorio.</p>
      </xsl:when>
      
      <xsl:when test="@opcional='si'">
        <p>
          <xsl:value-of select="@id_evento" />
        </p>
      </xsl:when>
      
      <xsl:otherwise>
        <p>Evento sin parámetro opcional o con valor erróneo.</p>
      </xsl:otherwise>
    </xsl:choose>

  </xsl:template>

</xsl:stylesheet>