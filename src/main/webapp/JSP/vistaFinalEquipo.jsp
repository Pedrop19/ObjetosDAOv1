<%-- 
    Document   : VistaFinalEquipo
    Created on : 16 nov. 2023, 23:19:14
    Author     : pedro
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<html lang="es">
<html>
    <head>
        <jsp:directive.include file="/INC/metas.inc"/>
        <link rel="shortcut icon" href="IMG/bbdd.png" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Equipos</title>
        <link rel="stylesheet" href="CSS/style.css">
    </head>
    <body>
        <div class="table-container">
            <h1>Información sobre los Equipos existentes</h1>
                <table>
                    <tr>
                        <th>Marca</th>
                        <th>Numero de Serie</th>
                    <tr>
                    <c:forEach var="equipo" items="${equipos}">
                        <tr>
                            <td>${equipo.marca}</td>
                            <td>${equipo.numSerie}</td>
                        </tr>
                    </c:forEach>
                </table>
                <form action="VueltaAEmpezar" method="post">
                    <button type="submit" value="volver">Inicio</button>
                </form>
            </div>
    </body>
</html>

