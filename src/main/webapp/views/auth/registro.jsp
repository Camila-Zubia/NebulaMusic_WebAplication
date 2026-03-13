<%-- 
    Document   : registro
    Created on : 5 mar 2026, 6:27:38 p.m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Nébula Music - Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- NECESARIO para que funcione el diseño responsive (Mobile First) -->
        <link rel="stylesheet" type="text/css" href="./styles/styles.css"/>
    </head>
    <body>


        <main>


            <section class="auth-container">

                <form class="auth-card"
                      name="form_nuevo_usuario"
                      method="post"
                      action="/usuarios"
                      enctype="application/x-www-form-urlencoded">

                    <div class="form-logo">
                        <img src="./imgs/nebula-03.svg" alt="Logo Nébula">
                    </div>

                    <div class="form-header"> 
                        <h3>Nuevo usuario</h3>
                        <p class="form-subtitle">Completa la información y envía tus datos</p> 
                    </div>

                    <div class="form-group">
                        <label for="txt_nombre">Nombre</label>
                        <input id="txt_nombre" name="txt_nombre" type="text"
                               required minlength="10" maxlength="100"
                               placeholder="Ej. Martín Guadalupe Bernal Lugo">
                    </div>

                    <div class="form-group">
                        <label for="txt_correo">Correo</label>
                        <input id="txt_correo" name="txt_correo" type="email"
                               required minlength="5" maxlength="100"
                               placeholder="correo@ejemplo.com">
                    </div>

                    <div class="form-group">
                        <label for="txt_contrasenia">Contraseña</label>
                        <input id="txt_contrasenia" name="txt_contrasenia"
                               type="password" required
                               placeholder="Mínimo 8 caracteres">
                    </div>

                    <div class="form-group">
                        <label for="txt_pseudonimo">Pseudónimo</label>
                        <input
                            id="txt_pseudonimo"
                            name="txt_pseudonimo"
                            type="text"
                            required
                            pattern="[a-zA-Z]{3,10}-[0-9]{2,10}"
                            placeholder="Nebula-2025">
                    </div>

                    <div class="form-group">
                        <label>Estado</label>

                        <div class="radio-group">
                            <input type="radio" value="activo" id="rad_activo" name="rad_estado" required>
                            <label for="rad_activo">Activo</label>

                            <input type="radio" value="inactivo" id="rad_inactivo" name="rad_estado">
                            <label for="rad_inactivo">Inactivo</label>

                            <input type="radio" value="pendiente" id="rad_pendiente" name="rad_estado">
                            <label for="rad_pendiente">Pendiente</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sel_cuenta">Cuenta</label>
                        <select id="sel_cuenta" name="sel_cuenta" required>
                            <option value="">-Selecciona-</option>
                            <option value="gratis">Gratis</option>
                            <option value="basica">Básica</option>
                            <option value="premium">Premium</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="txt_fecha_nacimiento">Fecha de nacimiento</label>
                        <input type="date" id="txt_fecha_nacimiento"
                               name="txt_fecha_nacimiento" required>
                    </div>

                    <div class="form-group checkbox-group">
                        <input name="chk_terminos"
                               id="chk_terminos"
                               type="checkbox"
                               value="aceptado"
                               required>

                        <label for="chk_terminos">
                            Aceptar términos y condiciones
                        </label>
                    </div>

                    <div class="form-group">
                        <p style="text-align:center; font-size:0.85rem;">
                            ¿Ya tienes una cuenta?
                            <a href="./iniciar-sesion.jsp">Inicia sesión</a>
                        </p>

                        <button type="submit" class="btn-primary">
                            Registrar
                        </button>

                        <button type="reset" class="btn-secondary">
                            Cancelar
                        </button>
                    </div>

                </form>
            </section>
        </main>

        <footer>

            <div>
                <p>Síguenos en nuestras redes.</p>

                <div>
                    <a href="https://www.instagram.com" target="_blank">Instagram</a>
                    <a href="https://www.facebook.com" target="_blank">Facebook</a>
                    <a href="https://www.tiktok.com" target="_blank">TikTok</a>
                </div>
            </div>

            <p>Copyright © Nébula 2025.</p>
            <a href="./tyc.jsp" target="_blank">Términos y condiciones</a>

        </footer>

    </body>
</html>
