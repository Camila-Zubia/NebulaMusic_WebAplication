<%-- 
    Document   : iniciar-sesion
    Created on : 5 mar 2026, 6:25:59 p.m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nébula music</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./styles/styles.css"/>
    </head>
    <body>
        <main class="auth-container">

            <section class="auth-card">

                <form class="auth-form"
                      name="form_iniciar_sesion" 
                      method="post" 
                      action="/autenticacion"
                      enctype="application/x-www-form-urlencoded">

                    <div name="logo_usuario" class="form-logo">
                        <img src="./imgs/nebula-03.svg" alt="Logo de nebula music">
                    </div>

                    <div name="titulo" class="form-header">
                        <h3>Inicia sesión</h3>
                        <span class="form-subtitle">Utiliza tus credenciales para iniciar</span>
                    </div>

                    <div name="correo" class="form-group">
                        <label for="correo">Correo</label>
                        <input id="correo" name="correo" type="email" required minlength="5" maxlength="100">
                    </div>

                    <div name="contrasenia" class="form-group">
                        <label for="contrasenia">Contraseña</label>
                        <input id="contrasenia" name="contrasenia" type="password" required>
                    </div>                    
                    <div name="options">
                        <p>¿Aún no tienes una cuenta? <a href="./registro.jsp">Regístrate</a></p>
                        <button type="submit" class="btn-primary">Iniciar</button>
                        <button type="reset" class="btn-secondary">Cancelar</button>
                    </div>
                </form>
            </section>
        </main>
        <footer>
            <div>
                Síguenos en nuestras redes.
                <div>
                    <a href="www.instagram.com" target="_blank">Instagram</a>
                    <a href="www.facebook.com" target="_blank">Facebook</a>
                    <a href="wwwtiktok.com" target="_blank">Tiktok</a>
                </div>
            </div>

            <p>Copyright Nébula 2025.</p>
            <a href="./tyc.jsp" target="_blank">Términos y condiciones</a>
        </footer>

    </body>
</html>
