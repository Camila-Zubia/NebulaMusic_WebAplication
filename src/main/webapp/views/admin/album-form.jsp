<%-- 
    Document   : album-form
    Created on : 17 mar 2026, 7:14:44 p.m.
    Author     : Usuario
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nosotros - Nébula</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css"/>
    </head>
    <body>
        <%
            if (session.getAttribute("usuario") == null) {
                response.sendRedirect("/iniciar-sesion.jsp");
            }
        %>
        <%@include file="/WEB-INF/jsp/fragments/header.jspf" %>
        <header> 
            <img src="./imgs/header2.jpg"/>
            <h1>Mis Albums</h1>
        </header>
        <main class="about-main">
            <c:if test="${album == null}">
                Nuevo album
            </c:if>
            <c:if test="${album != null}">
                Editar album
            </c:if>
                <c:if test="${error != null}">
                    <p style="color: red">${Error}</p>
                </c:if>
                    <form action="albums" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${album.id}">
                        <label>Titulo</label>
                        <br>
                        <input type="text" name="titulo" value="${album.titulo}" required="">
                        <label>Descripcion</label>
                        <br>
                        <textarea name="descripcion" required>${album.descripcion}</textarea>
                        <br><br>
                        <label>Portada</label>
                        <br>
                        <input type="file" name="imagen" accept="image/png" required>
                        <br><br>
                        <button type="submit">Guardar</button>
                    </form>
                        <a href="albums">Volver</a>
        </main>
        <%@include file="/WEB-INF/jsp/fragments/footer.jspf" %>
    </body>
</html>
