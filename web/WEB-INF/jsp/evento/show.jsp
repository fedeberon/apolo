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


    <style>
        .modal-content {
            width: 645px;
            margin: -60px auto 0px auto;
        }
        .btn.btn-primary.pull-right.ir-mapa {
            margin-top: -8%;
        }
    </style>


</head>

<body>

<div class="wrapper">

    <jsp:include page="../sidebar.jsp"/>

    <div class="main-panel">

        <jsp:include page="../menu.jsp"/>


        <div class="content">


            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header" data-background-color="purple">
                                <h4 class="title">Evento</h4>
                                <%--<p class="category">lista</p>--%>
                            </div>
                            <div class="card-content table-responsive">
                                <table class="table">
                                    <thead class="text-primary">
                                    <th></th>
                                    <th></th>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>Codigo</th>
                                        <td>${evento.id}</td>
                                    </tr>

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

                                    <%--<sec:authorize access="hasRole('ADMINISTRADOR')">--%>
                                    <tr>
                                        <th>Contratos</th>
                                        <td>
                                            <c:forEach items="${contratos}" var="bo">
                                                <li><a target="_blank" href="http://glameventos.com.ar/${bo.url}">${bo.nombre}</a></li>
                                            </c:forEach>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>Facturas</th>
                                        <td>
                                            <c:forEach items="${facturas}" var="bo">
                                                <li><a target="_blank" href="http://glameventos.com.ar/${bo.url}">${bo.nombre}</a></li>
                                            </c:forEach>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>Documentos</th>
                                        <td>
                                            <c:forEach items="${documentos}" var="bo">
                                                <li><a target="_blank" href="http://glameventos.com.ar/${bo.url}">${bo.nombre}</a></li>
                                            </c:forEach>
                                        </td>
                                    </tr>
                                    <%--</sec:authorize>--%>

                                    </tbody>
                                </table>

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
                                                        <div class="knob-label"><a href="<c:url value='/servicioContratado/show?id=${bo.id}'/>">${bo.servicio.nombre}</a></div>
                                                    </div>
                                                </c:forEach>
                                            </ul>
                                            <div class="col-xs-12 col-md-12">
                                                <input type="submit" class="btn btn-primary pull-right" value="Ordenar">
                                            </div>
                                        </form:form>
                                    </div>
                                    <!-- /.row -->
                                </div>
                                <!-- /.box-body -->

                            </div>
                        </div>
                        <a href="<c:url value='/evento/delete?id=${evento.id}'/>" class="btn btn-primary pull-right">Eliminar</a>
                        <a href="<c:url value='/evento/asignarServicio?id=${evento.id}'/>" class="btn btn-primary pull-right">Editar</a>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-documentos">Documentos</button>
                        <a href="<c:url value='/evento/timeline?id=${evento.id}'/>" class="btn btn-primary">Linea de tiempo</a>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-mapa">Ver Mapa</button>
                    </div>


                </div>
            </div>

            <jsp:include page="../footer.jsp"/>

    </div>

</div>

        <div  id="modal-mapa"  class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Ubicaci&oacute;n del Evento</h4>
                    </div>
                    <img src="https://maps.googleapis.com/maps/api/staticmap?center=&quot${evento.latitud},${evento.longitud}&quot&size=700x436&key=AIzaSyCtrCwwfYZPctgU4nsQLCFKa1ZB3SFMa1A&maptype=roadmap&markers=color:red%7Clabel:%7C${evento.latitud},${evento.longitud}"/>
                    <a href="<c:url value='https://www.google.com/maps/search/?api=1&query=${evento.latitud},${evento.longitud}'/>" target="_blank" class="btn btn-primary pull-right ir-mapa">Ir al Mapa</a>
                </div>
            </div>
        </div>

        <div id="modal-documentos" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Documentos</h4>
                    </div>

                    <form:form  action="/apolo/documento/uploadFile" modelAttribute="documento" method="post" enctype="multipart/form-data">
                        <div class="modal-body">

                            <input type="hidden" name="idEvento" value="${evento.id}"/>

                            <input type="file" name="file"/>

                            <input type="radio" name="carpeta" value="CONTRATOS">Contrato
                            <input type="radio" name="carpeta" value="FACTURAS">Factura
                            <input type="radio" name="carpeta" value="DOCUMENTOS">Documento

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-default">Guadar</button>
                        </div>

                    </form:form>

                </div>
            </div>
        </div>

</body>


<jsp:include page="../buttom.jsp"/>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- jQuery Knob -->
<script src="<c:url value='/resources/plugins/knob/jquery.knob.js'/>"></script>


<script type="application/javascript">

    $(function () {
        $(".knob").knob();
    });

</script>


<script>
    $( function() {
        $( "#sortable" ).sortable({
            stop: function(event, ui) {
                var $list = $('#div-orden-servicios input[class="orden"]');
                $list.each(function(i, el){
                    var inputOrden = $(this);
                    inputOrden.val(i + 1);
                });
            }
        });
        $( "#sortable" ).disableSelection();
    } );
</script>

</html>
