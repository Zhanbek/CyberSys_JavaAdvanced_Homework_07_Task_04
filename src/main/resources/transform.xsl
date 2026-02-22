<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    
    <!-- Головний шаблон -->
    <xsl:template match="/">
        <cities>
            <xsl:apply-templates select="cities/city"/>
        </cities>
    </xsl:template>
    
    <!-- Шаблон для міста -->
    <xsl:template match="city">
        <city size="{size}">
            <xsl:value-of select="name"/>
            <xsl:apply-templates select="street"/>
        </city>
    </xsl:template>
    
    <!-- Шаблон для вулиці -->
    <xsl:template match="street">
        <street>
            <name><xsl:value-of select="name"/></name>
            <xsl:apply-templates select="house"/>
        </street>
    </xsl:template>
    
    <!-- Шаблон для будинку -->
    <xsl:template match="house">
        <house>
            <number><xsl:value-of select="number"/></number>
            <floors><xsl:value-of select="floors"/></floors>
        </house>
    </xsl:template>
</xsl:stylesheet>