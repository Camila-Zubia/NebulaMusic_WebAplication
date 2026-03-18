<%-- 
    Document   : comunidad
    Created on : 5 mar 2026, 6:24:10 p.m.
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="/views/error/error.jsp" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Nosotros - Nébula</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>

    <body>
        <%
            if (session.getAttribute("usuario") == null) {
                response.sendRedirect("/iniciar-sesion.jsp");
            }
        %>
        <%@include file="/WEB-INF/jsp/fragments/header.jspf" %>
        <section>
            <div style="text-align:center; margin-bottom: 20px;">
                <p>
                    Total de ussuario registrados:
                    <strong><c:out value="${requestScope.totalUsuarios}" /></strong>
                </p>

                <c:if test="${not empty sesssionScope.usuario}">
                    <p>
                        Bienvenido,
                        <strong><c:out value="${sessionScope.usuario.nombre}" /></strong>
                    </p>
                </c:if>
                <p>
                    Aplicacion:
                    <strong><c:out value="${applicationScope.appNombre}" /></strong>
                </p>
            </div>
            <c:if test="${empty requestScope.usuarios}">
                <div style="text-align:center; margin: 30px 0;">
                    <p>No hay usuarios regirados todavía.</p>
                </div>
            </c:if>
            <c:if test="${not empty requestScope.usuarios}">
                <div class="users-grid">
                    <c:forEach var="usuario" items="${requestScope.usuarios}">
                        <div class="user-card">
                            <div class="user-avatar">
                                <img src="${pageContext.requesst.contextPath}/assets/img/user.jpg"
                                     alt="${usuario.nombre}">
                            </div>
                            <div class="user-info">
                                <h4>
                                    <c:out value="${usuario.nombre}" />
                                </h4>
                                <span class="email">
                                    <c:out value="${usuario.correo}" />
                                </span>
                            </div>

                            <div class="user-data">
                                <span>
                                    <strong>Usuario:</strong>
                                    <c:out value="${usuario.estado}" />
                                </span>
                                <span>
                                    <strong>Fecha de nacimiento:</strong>
                                    <c:out value="${usuario.fechaNacimiento}" />
                                </span>

                                <c:choose>
                                    <c:when test="${usuario.cuenta eq 'premium'}">
                                        <span class="badge premium">Premium</span>
                                    </c:when>
                                    <c:when test="${usuario.cuenta eq 'basica'}">
                                        <span class="badge basic">Básica</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge free">Gratis</span>
                                    </c:otherwise> 
                                </c:choose>
                                <c:if test="${not empty sessionScope.usuario and sessionScope.usuario.correo eq usuario.correo}" >
                                    <span class="badge" style="backgfround-color: #d4edda; color: #155724;">
                                        Este eres tú
                                    </span>
                                </c:if>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>

            <div class="paginacion" style="text-align: center;margin-top: 30px">
                <c:if test="${requestScope.paginaActual > 1}"> 
                    <a href="${pageContext.request.contextPath}/comunidad?pagina=${requestScope.paginaActual - 1}" style="margin: 0 8px">
                        Anterior
                    </a>
                </c:if>

                <c:forEach var="1" begin="1" end="${requestScope.totalPaginas}">
                    <c:choose>
                        <c:when test="${i == requestScope.paginaActual}">
                            <span style="margin: 0 6px; font-weight: bold; text-decoration: underline;">
                                <c:out value="${i}" />
                            </span>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/comunidad?pagina=${i}" style="margin: 0 6px;">
                                <c:out value="${i}" />
                            </a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${requestScope.paginaActual < requestScope.totalPaginas}">
                    <a href="${pageContext.request.contextPath}/comunidad?pagina=${requestScope.paginaActual + 1}" style="margin: 0 8px">
                        Siguiente

                    </a>
                </c:if>
            </div>

            <%@include file="/WEB-INF/jsp/fragments/footer.jspf" %>
    </body>

</html>