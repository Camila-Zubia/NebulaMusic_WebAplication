<%-- 
    Document   : moderno
    Created on : 5 mar 2026, 6:26:44 p.m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HTML Moderno - Introdución</title>
        <link rel="stylesheet" href="./styles/styles.css">
    </head>
    <body>
        <%
            if (session.getAttribute("usuario") == null) {
                response.sendRedirect("iniciar-sesion.jsp");
            }
        %>
        <!-- USar figcaption cuando la imagen necesita contexto -->
        <figure>
            <img src="https://tse3.mm.bing.net/th/id/OIP.Tj-2Ax_NCBY1eRcp-ybesAHaFj?rs=1&pid=ImgDetMain&o=7&rm=3" alt="imagen de prueba" width="100%">
            <figcaption>
                Figura 1: Fotografía de prueba
            </figcaption>
        </figure>
        <!-- Utiliza para imagenes responsivas - Permite definir distintas  -->
    <picture>
        <source srcset="https://tse3.mm.bing.net/th/id/OIP.Tj-2Ax_NCBY1eRcp-ybesAHaFj?rs=1&pid=ImgDetMain&o=7&rm=3" media="(min-width: 768px)">
        <source srcset="https://cdn0.geoenciclopedia.com/es/posts/8/0/0/montanas_8_orig.jpg" media="(max-width: 767px)">

        <img src="https://www.xtrafondos.com/wallpapers/montana-en-la-naturaleza-canada-10154.jpg" alt="imagen de prueba con source">
    </picture><br>
    <!-- SVG es un vectorial - independependientemente del tamaño nunca se pixea -->
    <svg>
    <circle cx="60" cy="60" r="50" stroke="black" stroke-width="2" fill="lightblue"></circle>
    </svg><br>
    <label>
        Lenguaje favorito
        <input list="languages">
    </label>
    <datalist id="languages">
        <option value="Java"></option>
        <option value="JavaScript"></option>
        <option value="Python"></option>
        <option value="C#"></option>
    </datalist>
    <!-- Contenido desplegable -->
    <details>
        <summary>¿Que es HTML semantico?</summary>
        <p>
            Es el uso de etiquetas que despliegan el significado del contenido <br> y no solo su apariencia
        </p>
    </details>
    <video autoplay muted loop poster="">
        <source src="https://www.w3schools.com/html/mov_bbb.mp4" type="video/mp4">
        <track kind="subtitles"></track>
    </video><br>
    <audio src="https://www.w3schools.com/html/horse.mp3" controls></audio><br>
    <iframe width="560" height="315" src="https://www.youtube-nocookie.com/embed/dQw4w9WgXcQ?si=oggpIa9JOgvMS49M" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe><br>
    <button onclick="abrirModal()">Abrir</button>
    <dialog id="miDialogo">
        <p>Este es un dialogo HTML nativo</p>
        <button onclick="cerrarModal()">Cerrar</button>
    </dialog>
</html>
