<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sidebar" data-color="purple" data-image="<c:url value='/resources/assets/img/sidebar-1.jpg'/>">
    <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->

    <div class="logo">
        <a href="#" class="simple-text">
            Apolo
        </a>
    </div>

    <div class="sidebar-wrapper">
        <ul class="nav">
            <li class="active">
                <a href="<c:url value="/" />">
                    <i class="material-icons">dashboard</i>
                    <p>tablero de actividades</p>
                </a>
            </li>
            <li>
                <a href="<c:url value="/usuario/list/" />">
                    <i class="material-icons">person</i>
                    <p>Usuarios del sistema</p>
                </a>
            </li>
            <li>
                <a href="<c:url value="/servicio/list/" />">
                    <i class="material-icons">content_paste</i>
                    <p>servicios</p>
                </a>
            </li>
            <li>
                <a href="<c:url value="/proveedor/list/" />">
                    <i class="material-icons">library_books</i>
                    <p>proveedores</p>
                </a>
            </li>
            <li>
                <a href="<c:url value="/evento/list" />">
                    <i class="material-icons">bubble_chart</i>
                    <p>eventos</p>
                </a>
            </li>
            <li>
                <a href="<c:url value="/maps/" />">
                    <i class="material-icons">location_on</i>
                    <p>Mapa de Eventos</p>
                </a>
            </li>
            <li>
                <a href="notifications.html">
                    <i class="material-icons text-gray">notifications</i>
                    <p>notificaciones</p>
                </a>
            </li>
            <li class="active-pro">
                <a href="upgrade.html">
                    <i class="material-icons">unarchive</i>
                    <p>Bolivar Software</p>
                </a>
            </li>
        </ul>
    </div>
</div>