<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta charset="utf-8">
    <title>
        Bienvenido - ${evento.nombre}!
    </title><!-- Behavioral Meta Data -->
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"><!-- Core Meta Data -->
    <meta content="ThemeWagon" name="author">
    <meta content="The most spectacular coming soon template!" name="description">
    <meta content="Comming Soon, Responsive, Landing Page, One Page" name="keywords"><!-- Open Graph Meta Data -->
    <meta content="The most spectacular coming soon template!">
    <meta content="ThemeWagon">
    <meta content="ThemeWagon">
    <meta content="website">
    <meta content="index.html"><!-- Twitter Card Meta Data -->
    <meta content="summary" name="twitter:card">
    <meta content="@themewagon" name="twitter:site">
    <meta content="@themewagon" name="twitter:creator">
    <meta content="ThemeWagon" name="twitter:title">
    <meta content="Imminent - The most spectacular coming soon template!" name="twitter:description">

    <link href="favicon.png" rel="shortcut icon" type="image/png">

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- CSS -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,900' rel='stylesheet' type='text/css'><!-- Styles -->
    <link href="<c:url value='/resources/bienvenida/css/loader.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/resources/bienvenida/css/normalize.css'/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/bienvenida/css/font-awesome.min.css'/>">
    <link href="<c:url value='/resources/bienvenida/css/style.css'/>" rel="stylesheet" type="text/css">


    <script src="<c:url value='/resources/bienvenida/js/jquery.js'/>"></script>

    <style>
        .playlist-section { position: fixed; right: 0; top: 50%; transform: translateY(-50%); z-index: 999; text-align: left; max-height: 90vh; overflow-y: auto; padding: 4px; }
        .playlist-section input {
            background: rgba(22,33,62,0.85) !important;
            color: white !important;
            border: 1px solid rgba(255,255,255,0.15) !important;
            width: 100% !important;
            padding: 8px 10px !important;
            border-radius: 4px !important;
            box-sizing: border-box !important;
            font-size: 13px !important;
            outline: none !important;
        }
        .playlist-section input::placeholder {
            color: #999 !important;
            opacity: 1 !important;
        }
        .playlist-section .btn-sugerir {
            background: #1DB954 !important;
            color: white !important;
            border: none !important;
            padding: 7px 16px !important;
            border-radius: 4px !important;
            font-size: 13px !important;
            cursor: pointer !important;
        }
        .playlist-section .btn-abrir {
            display: inline-block; color: #1DB954 !important; text-decoration: none !important; font-size: 13px !important;
        }
        .playlist-section .btn-abrir:hover { text-decoration: underline !important; }
    </style>
</head>
<body>
<div class="preloader">
    <div class="loading">
        <h2>
            Loading...
        </h2>
        <span class="progress"></span>
    </div>
</div>

<div class="wrapper">

    <input type="hidden" id="eventoDate" value="${evento.fechaDeEvento}"/>

    <ul class="scene unselectable" data-friction-x="0.1" data-friction-y="0.1" data-scalar-x="25" data-scalar-y="15" id="scene">
        <li class="layer" data-depth="0.00">
        </li>
        <!-- BG -->

        <li class="layer" data-depth="0.10">
            <div class="background">
            </div>
        </li>

        <!-- Hero -->

        <li class="layer" data-depth="0.20">
            <div class="title">
                <h2 class="titleGlam">
                    EVENTOS
                </h2>
                <%--<span class="line"></span>--%>
            </div>
        </li>

        <%--<li class="layer" data-depth="0.25">--%>
        <%--<div class="sphere">--%>
        <%--<img alt="sphere" src="images/sphere.png">--%>
        <%--</div>--%>
        <%--</li>--%>

        <li class="layer" data-depth="0.30">
            <div class="hero">
                <h1 id="countdown">
                    <%--<a class="mail" href="<c:url value='/evento/showCliente?id=${evento.id}'/>">Mira mas detalles del evento</a>--%>
                </h1>

                <p class="sub-title">
                    <%--<a class="mail" href="<c:url value='/evento/showCliente?id=${evento.id}'/>">Mira mas detalles del evento</a>--%>
                </p>
            </div>
        </li>
        <!-- Flakes -->

        <li class="layer" data-depth="0.40">
            <div class="depth-1 flake1">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth1/flakes1.png'/>">
            </div>

            <div class="depth-1 flake2">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth1/flakes2.png'/>">
            </div>

            <div class="depth-1 flake3">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth1/flakes3.png'/>">
            </div>

            <div class="depth-1 flake4">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth1/flakes4.png'/>">
            </div>

        </li>

        <li class="layer" data-depth="0.50">
            <div class="depth-2 flake1">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth2/flakes1.png'/>">
            </div>

            <div class="depth-2 flake2">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth2/flakes2.png'/>">
            </div>
        </li>

        <li class="layer" data-depth="0.60">
            <div class="depth-3 flake1">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth3/flakes1.png'/>">
            </div>

            <div class="depth-3 flake2">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth3/flakes2.png'/>">
            </div>

            <div class="depth-3 flake3">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth3/flakes3.png'/>">
            </div>

            <div class="depth-3 flake4">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth3/flakes4.png'/>">
            </div>
        </li>

        <li class="layer" data-depth="0.80">
            <div class="depth-4">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth4/flakes.png'/>">
            </div>
        </li>

        <li class="layer" data-depth="1.00">
            <div class="depth-5">
                <img alt="flake" src="<c:url value='/resources/bienvenida/images/flakes/depth5/flakes.png'/>">
            </div>
        </li>
        <!-- Contact -->

        <li class="layer" data-depth="0.20">
            <div class="contact">
                <ul class="icons">
                    <li>
                        <a class="behance" href="https://www.instagram.com/Glam.ok/" target="_blank"><i class="fa fa-instagram"></i></a>
                    </li>

                    <li>
                        <a class="twitter" href="https://www.twitter.com/" target="_blank"><i class="fa fa-twitter"></i></a>
                    </li>

                    <li>
                        <a class="dribbble" href="https://www.facebook.com/Glam.ok" target="_blank"><i class="fa fa-facebook"></i></a>
                    </li>

                </ul>
                <ul>
                    <li>
                        <a style="color:white" href="<c:url value='/evento/showCliente?id=${evento.id}'/>">Mira mas detalles de tu evento</a>
                    </li>
                </ul>

                <br/>
                <br/>

            </div>

        </li>

    </ul>
</div>

<div class="playlist-section">

    <div style="margin-bottom: 8px;">
        <span style="color: #1DB954; font-size: 13px; font-weight: 500;"><i class="fa fa-spotify"></i> Playlist del Evento</span>
    </div>

    <c:if test="${not empty evento.playlist}">
        <div style="margin-bottom: 8px;">
            <iframe src="https://open.spotify.com/embed?uri=spotify:${evento.playlist}" width="260" height="360" frameborder="0" allowtransparency="true" allow="encrypted-media" style="border-radius: 6px;"></iframe>
        </div>
    </c:if>

    <div style="margin-bottom: 8px;">
        <input type="text" name="nombreCancion" form="sug-form" placeholder="Canci&oacute;n" required/>
    </div>
    <div style="margin-bottom: 8px;">
        <input type="text" name="artista" form="sug-form" placeholder="Artista" required/>
    </div>
    <div>
        <button type="submit" form="sug-form" class="btn-sugerir"><i class="fa fa-plus"></i> Sugerir</button>
        <c:if test="${not empty evento.playlist}">
            <a href="${evento.playlistWebUrl}" target="_blank" class="btn-abrir" style="margin-left: 6px;"><i class="fa fa-spotify"></i> Abrir</a>
        </c:if>
    </div>

    <c:if test="${empty evento.playlist}">
        <p style="color: #888; font-size: 12px; margin: 4px 0 0;">Sin playlist por ahora &mdash; tus sugerencias se guardan igual.</p>
    </c:if>

    <form id="sug-form" action="<c:url value='/sugerenciaCancion/save'/>" method="post">
        <input type="hidden" name="eventoId" value="${evento.id}"/>
    </form>

</div>

<!-- Javascript -->
<script src="<c:url value='/resources/bienvenida/js/plugins.js'/>"></script>
<script src="<c:url value='/resources/bienvenida/js/jquery.countdown.min.js'/>"></script>
<script src="<c:url value='/resources/bienvenida/js/main.js'/>"></script>

<script>

</script>

</body>
</html>