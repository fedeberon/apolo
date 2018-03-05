<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>" />
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Material Dashboard by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet" />

    <!--  Material Dashboard CSS    -->
    <link href="<c:url value='/resources/css/material-dashboard.css'/>" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="<c:url value='/resources/css/demo.css'/>" rel="stylesheet" />

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>

<body>

<div class="wrapper">

    <jsp:include page="sidebar.jsp"/>

    <div class="main-panel">

      <jsp:include page="menu.jsp"/>

        <div class="content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="green">
                                <i class="material-icons">content_copy</i>
                            </div>
                            <div class="card-content">
                                <p class="category">Eventos pr&oacute;ximos</p>
                                <h3 class="title">49/50<small></small></h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <i class="material-icons text-danger">warning</i> <a href="#pablo">Mas info...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="green">
                                <i class="material-icons">store</i>
                            </div>
                            <div class="card-content">
                                <p class="category">Visitas</p>
                                <h3 class="title">10</h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <i class="material-icons">date_range</i> &Eacute;sta semana
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="red">
                                <i class="material-icons">info_outline</i>
                            </div>
                            <div class="card-content">
                                <p class="category">Tareas por vences</p>
                                <h3 class="title">75</h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <i class="material-icons">local_offer</i> Revisar Calendario
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="blue">
                                <i class="fa fa-twitter"></i>
                            </div>
                            <div class="card-content">
                                <p class="category">Seguidores</p>
                                <h3 class="title">+245</h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <i class="material-icons">update</i> Twitear
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header card-chart" data-background-color="green">
                                <div class="ct-chart" id="dailySalesChart"></div>
                            </div>
                            <div class="card-content">
                                <h4 class="title">Tareas programadas para esta semana</h4>
                                <p class="category"><span class="text-success"><i class="fa fa-long-arrow-up"></i> 55%  </span> tareas programadas para &eacute;sta semana.</p>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <i class="material-icons">access_time</i> actualizado hace 4 minutos
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header card-chart" data-background-color="orange">
                                <div class="ct-chart" id="emailsSubscriptionChart"></div>
                            </div>
                            <div class="card-content">
                                <h4 class="title">Tareas por mes</h4>
                                <p class="category">Revisar eventos mensuales</p>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <i class="material-icons">access_time</i>Calendarizaci&oacute; de eventos
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header card-chart" data-background-color="red">
                                <div class="ct-chart" id="completedTasksChart"></div>
                            </div>
                            <div class="card-content">
                                <h4 class="title">Tareas completadas</h4>
                                <p class="category">tareas realizadas en tiempo</p>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <i class="material-icons">access_time</i> revisar tareas realizadas.
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-lg-6 col-md-12">
                        <div class="card">
                            <div class="card-header" data-background-color="purple">
                                <h4 class="title">Tareas a Realizar</h4>
                                <p class="category">tareas a realizar prioritarias</p>
                            </div>
                            <div class="card-content table-responsive">
                                <table class="table table-hover">
                                    <thead class="text-warning">
                                    <th>Cod Int</th>
                                    <th>Nombre</th>
                                    <th>Servicio</th>
                                    <th>Dias</th>
                                    <th>Evento</th>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${tareasProximas}" var="etapaConfigurada">
                                        <tr>
                                            <td><a href="/apolo/servicioContratado/show?id=${etapaConfigurada.servicioContratado.id}">${etapaConfigurada.servicioContratado.id}</a></td>
                                            <td>${etapaConfigurada.etapa.nombre}</td>
                                            <td>${etapaConfigurada.servicioContratado.servicio.nombre}</td>
                                            <td>${etapaConfigurada.cantidadDiasLimiteDeResolucion}</td>
                                            <td><a href="/apolo/evento/show?id=${etapaConfigurada.servicioContratado.evento.id}">${etapaConfigurada.servicioContratado.evento.nombre}</a></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-12">
                        <div class="card">
                            <div class="card-header" data-background-color="orange">
                                <h4 class="title">Eventos proximos</h4>
                                <p class="category">eventos proximos para el mes de Julsio</p>
                            </div>
                            <div class="card-content table-responsive">
                                <table class="table table-hover">
                                    <thead class="text-warning">
                                    <th>Cod Int</th>
                                    <th>Nombre</th>
                                    <th>Contrato</th>
                                    <th>Lugar</th>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${eventosProximos}" var="evento">
                                        <tr>
                                            <td><a href="/apolo/evento/show?id=${evento.id}">${evento.id}</a></td>
                                            <td>${evento.nombre}</td>
                                            <td>${evento.ciudad}</td>
                                            <td>${evento.fechaDeEvento}</td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

        <jsp:include page="footer.jsp"/>

    </div>

</div>

</body>

<!--   Core JS Files   -->
<script src="<c:url value='/resources/js/jquery-3.1.0.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/material.min.js'/>" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="<c:url value='/resources/js/chartist.min.js'/>"></script>

<!--  Notifications Plugin    -->
<script src="<c:url value='/resources/js/bootstrap-notify.js'/>"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Material Dashboard javascript methods -->
<script src="<c:url value='/resources/js/material-dashboard.js'/>"></script>

<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="<c:url value='/resources/js/demo.js'/>"></script>

<script type="text/javascript">
    $(document).ready(function(){

        // Javascript method's body can be found in assets/com.bolivarSoftware.apolo.web.js/demos.com.bolivarSoftware.apolo.web.js
        demo.initDashboardPageCharts();

    });
</script>

</html>
