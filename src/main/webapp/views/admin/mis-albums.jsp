<%-- 
    Document   : mis-albums
    Created on : 17 mar 2026, 7:26:05 p.m.
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
            
        </main>
        <%@include file="/WEB-INF/jsp/fragments/footer.jspf" %>
    </body>
</html>
