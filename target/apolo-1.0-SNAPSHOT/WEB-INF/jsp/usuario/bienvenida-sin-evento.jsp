<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8">
    <title>Bienvenido</title>
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <meta content="ThemeWagon" name="author">
    <link href="<c:url value='/resources/bienvenida/css/loader.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/resources/bienvenida/css/normalize.css'/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/bienvenida/css/font-awesome.min.css'/>">
    <link href="<c:url value='/resources/bienvenida/css/style.css'/>" rel="stylesheet" type="text/css">
    <script src="<c:url value='/resources/bienvenida/js/jquery.js'/>"></script>
</head>
<body>
<div class="wrapper">
    <ul class="scene unselectable" data-friction-x="0.1" data-friction-y="0.1" data-scalar-x="25" data-scalar-y="15" id="scene">
        <li class="layer" data-depth="0.00"></li>
        <li class="layer" data-depth="0.10">
            <div class="background"></div>
        </li>
        <li class="layer" data-depth="0.20">
            <div class="title">
                <h2 class="titleGlam">EVENTOS</h2>
            </div>
        </li>
        <li class="layer" data-depth="0.30">
            <div class="hero">
                <h1>Aun no tienes ningun evento asignado</h1>
                <p class="sub-title">Contacta a tu gestor de eventos para mas informacion</p>
            </div>
        </li>
        <li class="layer" data-depth="0.20">
            <div class="contact">
                <ul class="icons">
                    <li><a class="behance" href="https://www.instagram.com/Glam.ok/" target="_blank"><i class="fa fa-instagram"></i></a></li>
                    <li><a class="twitter" href="https://www.twitter.com/" target="_blank"><i class="fa fa-twitter"></i></a></li>
                    <li><a class="dribbble" href="https://www.facebook.com/Glam.ok" target="_blank"><i class="fa fa-facebook"></i></a></li>
                </ul>
            </div>
        </li>
    </ul>
</div>
<script src="<c:url value='/resources/bienvenida/js/plugins.js'/>"></script>
<script src="<c:url value='/resources/bienvenida/js/main.js'/>"></script>
</body>
</html>
