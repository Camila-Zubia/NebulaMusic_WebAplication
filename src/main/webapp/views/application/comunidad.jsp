<%-- 
    Document   : comunidad
    Created on : 5 mar 2026, 6:24:10 p.m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nébula music</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="styles/styles.css">
    </head>
    <body>
        <%@include file="fragments/header.jsp" %>
        <main>
            <section class="comunidad">
                <h3>Bienvenidos los nuevos usuarios</h3>
                <div class="tarjetas">
                    <article class="usuario">
                        <div class="info-usuario">
                            <img src="./imgs/user.jpg" alt="Foto de John Wick" />
                            <div class="texto-usuario">
                                <h4>John Wick</h4>
                                <span>john.wick@gmail.com</span>
                            </div>
                        </div>
                        <div class="datos-usuario">
                            <p><strong>Usuario:</strong> johny.kill</p>
                            <p><strong>Registro:</strong> 11 de septiembre del 2025</p>
                        </div>
                        <span class="premium">Premium</span>
                    </article>

                    <article class="usuario destello">
                        <div class="info-usuario">
                            <img src="./imgs/user.jpg" alt="Foto de Steve Rogers" />
                            <div class="texto-usuario">
                                <h4>Steve Rogers</h4>
                                <span>steve.rogers@gmail.com</span>
                            </div>
                        </div>
                        <div class="datos-usuario">
                            <p><strong>Usuario:</strong> capitan123</p>
                            <p><strong>Registro:</strong> 09 de agosto del 2025</p>
                        </div>
                        <span class="basica">Básica</span>
                    </article>

                    <article class="usuario">
                        <div class="info-usuario">
                            <img src="./imgs/user.jpg" alt="Foto de Natasha Romanoff" />
                            <div class="texto-usuario">
                                <h4>Natasha Romanoff</h4>
                                <span>black.widow@gmail.com</span>
                            </div>
                        </div>
                        <div class="datos-usuario">
                            <p><strong>Usuario:</strong> naty.black</p>
                            <p><strong>Registro:</strong> 07 de agosto del 2025</p>
                        </div>
                        <span class="premium">Premium</span>
                    </article>
                </div>
            </section>
        </main>

        <%@include file="fragments/footer.jsp" %>

    </body>
</html>
