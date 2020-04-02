<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/devices">
        <html>
            <body>
                <h2>Devices that are critical for computer usage</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Name</th>
                        <th>Price</th>
                        <th>Origin</th>
                        <th>Power</th>
                        <th>Group</th>
                        <th>Port</th>
                    </tr>
                    <xsl:for-each select="device">
                        <xsl:if test="critical='true'">
                            <tr>
                                <td><xsl:value-of select="name"/></td>
                                <td><xsl:value-of select="price"/></td>
                                <td><xsl:value-of select="origin"/></td>
                                <td><xsl:value-of select="type/power"/></td>
                                <td><xsl:value-of select="type/group"/></td>
                                <td><xsl:value-of select="type/port"/></td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <h2>Devices that are  not critical for computer usage</h2>
                <table border="1">
                    <tr bgcolor="#901090">
                        <th>Name</th>
                        <th>Price</th>
                        <th>Origin</th>
                        <th>Power</th>
                        <th>Group</th>
                        <th>Port</th>
                    </tr>
                    <xsl:for-each select="device">
                        <xsl:if test="critical='false'">
                            <tr>
                                <td><xsl:value-of select="name"/></td>
                                <td><xsl:value-of select="price"/></td>
                                <td><xsl:value-of select="origin"/></td>
                                <td><xsl:value-of select="type/power"/></td>
                                <td><xsl:value-of select="type/group"/></td>
                                <td><xsl:value-of select="type/port"/></td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>