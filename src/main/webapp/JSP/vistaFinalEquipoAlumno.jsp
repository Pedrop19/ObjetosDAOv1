<%-- 
    Document   : vistaFinalEquipoAlumno
    Created on : 16 nov. 2023, 23:19:14
    Author     : pedro
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<html lang="es">
<html>
    <head>
        <jsp:directive.include file="/INC/metas.inc"/>
        <link rel="shortcut icon" href="IMG/bbdd.png" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Equipos y Alumnos</title>
        <link rel="stylesheet" href="CSS/style.css">
    </head>
    <body>
        <div class="table-container">
            <h1>Información sobre los equipos existentes y sus alumnos</h1>
                <table>
                    <tr>
                        <th>Marca</th>
                        <th>Nombre</th>
                        <th>Grupo</th>
                    <tr>
                    <c:forEach var="equipo" items="${equipos}">
                    <c:set var="numAlumnos" value="${fn:length(equipo.alumnos)}" />
                        <tr>
                            <td rowspan="${numAlumnos}">${equipo.marca}</td>
                            <c:forEach var="alumno" items="${equipo.alumnos}">
                                <td>${alumno.nombre}</td>
                                <td>${alumno.grupo}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
                <form action="VueltaAEmpezar" method="post">
                    <button type="submit" value="volver">Inicio</button>
                </form>
            </div>
    </body>
</html>

