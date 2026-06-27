<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Detalles Evento | ${evento.nombre} </title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>

    <!-- Bootstrap core CSS     -->
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>

    <!--  Material Dashboard CSS    -->
    <link href="<c:url value='/resources/css/material-dashboard.css'/>" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="<c:url value='/resources/css/demo.css'/>" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>

    <link href="<c:url value='/resources/plugins/knob/jquery.knob.js'/>" rel="stylesheet"/>
    <!-- CSS -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,900' rel='stylesheet' type='text/css'>
    <!-- Styles -->
    <link href="<c:url value='/resources/bienvenida/css/normalize.css'/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/bienvenida/css/font-awesome.min.css'/>">


    <script src="/resources/js/jquery-3.1.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script async defer src="//assets.pinterest.com/js/pinit.js"></script>

    <style>
        .modal-content {
            width: 645px;
            margin: -60px auto 0px auto;
        }
        .btn.btn-primary.pull-right.ir-mapa {
            margin-top: -8%;
        }

        h3 {
            font-size: 60px;
            font-weight: 600;
            line-height: 60px;
            letter-spacing: -0.08em;
            color: #161a1b;

        }

        #countdown div span {
            display:block;
            font-size: 30px;
            line-height: 30px;
            letter-spacing: initial;
            font-weight: 100;
            text-transform: uppercase;
            text-align: center;
            margin: auto;
        }

        #countdown div {
            display:inline-block;
            margin: 0 34px;
        }
    </style>


</head>

<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="<c:url value='/resources/assets/img/sidebar-1.jpg'/>"  >

        <div class="logo">
            <a class="simple-text">
                Datos del Evento
            </a>
        </div>

        <div class="sidebar-wrapper">
            <table class="table nav">
                <thead class="text-primary">
                <th></th>
                <th></th>
                </thead>
                <tbody>
                <tr>
                    <th>Nombre</th>
                    <td>${evento.nombre}</td>
                </tr>

                <tr>
                    <th>Ciudad</th>
                    <td>${evento.ciudad}</td>
                </tr>

                <tr>
                    <th>Direccion</th>
                    <td>${evento.domicilio}</td>
                </tr>

                <tr>
                    <th>Contratado por</th>
                    <td>${evento.contratadoPor}</td>
                </tr>

                <tr>
                    <th>Fecha</th>
                    <td>${evento.fechaDeEvento}</td>
                </tr>

                <tr>
                    <th>Email</th>
                    <td>${evento.mail}</td>
                </tr>

                <tr>
                    <th>Lugar</th>
                    <td>${evento.lugar}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="main-panel">
        <div class="content" style="margin-top: 0px;">
            <div class="container-fluid">
                    <div class="row">

                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header" data-background-color="purple">
                                    <h4 class="title">Evento ${evento.nombre}</h4>
                                    <%--<p class="category">lista</p>--%>
                                </div>


                                <div class="card-content">
                                    <input type="hidden" id="eventoDate" value="${evento.fechaDeEvento}"/>
                                    <h3 id="countdown"> </h3>


                                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

                                        <!-- Wrapper for slides -->
                                        <div class="carousel-inner">
                                            <c:forEach items="${imagenes}" var="imagen" varStatus="status">
                                                <div class="item   <c:if test="${status.first}">active</c:if>">
                                                    <img class="img-responsive" src="http://glameventos.com.ar/${imagen.url}" style="width: 100%; height: auto; margin:auto;" alt="...">
                                                    <div class="carousel-caption">
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>

                                        <!-- Controls -->
                                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                            <span class="glyphicon glyphicon-chevron-left"></span>
                                        </a>
                                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                            <span class="glyphicon glyphicon-chevron-right"></span>
                                        </a>
                                    </div>

                                </div>

                                    <hr>

                                    <!-- /.box-header -->
                                    <div class="box-body">

                                        <div class="row">

                                            <form:form action="saveServiciosContratados" modelAttribute="evento">
                                                <form:hidden path="id"/>
                                                <ul id="sortable">
                                                    <c:forEach items="${serviciosContratados}" var="bo" varStatus="status">
                                                        <form:hidden path="servicios[${status.index}].id"/>
                                                        <form:hidden path="servicios[${status.index}].servicio.id"/>
                                                        <div class="col-xs-3 col-md-3 text-center" id="div-orden-servicios" >
                                                            <input type="text" class="knob" value="${bo.porcentajeCompletado}" data-width="90" data-height="90" data-fgColor="#3c8dbc" data-skin="tron" data-thickness="0.2" data-readonly="true">
                                                            <form:hidden path="servicios[${status.index}].orden" cssClass="orden"/>
                                                            <div class="knob-label">${bo.servicio.nombre}</div>
                                                        </div>
                                                    </c:forEach>
                                                </ul>
                                            </form:form>
                                        </div>
                                        <!-- /.row -->
                                    </div>
                                    <!-- /.box-body -->

                                </div>
                            </div>


                        <div class="col-md-4">
                            <div style="width: 100%">
                                <a data-pin-do="embedBoard" data-pin-board-width="900" data-pin-scale-height="480" data-pin-scale-width="115" href="https://www.pinterest.com/pinterest/official-news/"></a>                            </div>
                        </div>
                    </div>

                    </div>
            <div/>
        </div>
</div>




</body>


<jsp:include page="../buttom.jsp"/>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<!-- Javascript -->
<script src="<c:url value='/resources/bienvenida/js/plugins.js'/>"></script>
<script src="<c:url value='/resources/bienvenida/js/jquery.countdown.min.js'/>"></script>
<script src="<c:url value='/resources/bienvenida/js/main.js'/>"></script>

<!-- jQuery Knob -->
<script src="<c:url value='/resources/plugins/knob/jquery.knob.js'/>"></script>


<script type="application/javascript">

    $(function () {
        $(".knob").knob();
    });

</script>




</html>