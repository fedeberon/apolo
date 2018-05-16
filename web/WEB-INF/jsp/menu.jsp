<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <nav class="navbar navbar-transparent navbar-absolute">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Gestion de Eventos</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#pablo" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="material-icons">dashboard</i>
                            <p class="hidden-lg hidden-md">Dashboard</p>
                        </a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="material-icons">notifications</i>
                            <span class="notification">5</span>
                            <p class="hidden-lg hidden-md">Notifications</p>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Evento 15 a&ntilde;os.</a></li>
                            <li><a href="#">Evento fiesta fin de a&ntilde;o.</a></li>
                            <li><a href="#">Vencimientos.</a></li>
                            <li><a href="#">Tareas programadas para hoy</a></li>
                            <li><a href="#">Proximos eventos.</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="material-icons">person</i>
                            <p class="hidden-lg hidden-md">Profile</p>
                        </a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="isAuthenticated()">
                                 <li><a href="#"><sec:authentication property="principal.username" /></a></li>
                                 <li><a href="<c:url value="/logout" />">Logout</a></li>
                            </sec:authorize>

                            <sec:authorize access="!isAuthenticated()">
                                <li><a href="<c:url value="/login" />">Login</a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                </ul>

                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group  is-empty">
                        <input type="text" class="form-control" placeholder="Buscar lo que quiera ..">
                        <span class="material-input"></span>
                    </div>
                    <button type="submit" class="btn btn-white btn-round btn-just-icon">
                        <i class="material-icons">search</i><div class="ripple-container"></div>
                    </button>
                </form>
            </div>
        </div>
    </nav>
