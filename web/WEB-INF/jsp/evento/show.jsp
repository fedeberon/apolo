<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Nuevo Evento </title>

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
                                    <th>Nombre</th>
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

                                      <%--<tr>--%>
                                          <%--<th>Contratos</th>--%>
                                          <%--<td>--%>
                                              <%--<c:forEach items="contratos" var="bo">--%>
                                                <%--<li><a href="${bo.url}">${bo.nombre}</a></li>--%>
                                              <%--</c:forEach>--%>
                                          <%--</td>--%>
                                      <%--</tr>--%>

                                      <%--<tr>--%>
                                          <%--<th>Facturas</th>--%>
                                          <%--<td>--%>
                                              <%--<c:forEach items="facturas" var="bo">--%>
                                                  <%--<li><a href="${bo.url}">${bo.nombre}</a></li>--%>
                                              <%--</c:forEach>--%>
                                          <%--</td>--%>
                                      <%--</tr>--%>

                                    </tbody>
                                </table>

                                <!-- /.box-header -->
                                <div class="box-body">

                                    <div class="row">

                                        <c:forEach items="${serviciosContratados}" var="bo">
                                            <div class="col-xs-3 col-md-3 text-center">
                                                <input type="text" class="knob" value="${bo.porcentajeCompletado}" data-width="90" data-height="90" data-fgColor="#3c8dbc" data-skin="tron" data-thickness="0.2" data-readonly="true">

                                                <div class="knob-label"><a href="<c:url value='/servicioContratado/show?id=${bo.id}'/>">${bo.servicio.nombre}</a></div>
                                            </div>

                                        </c:forEach>
                                        <img src="https://maps.googleapis.com/maps/api/staticmap?center=&quot${evento.latitud},${evento.longitud}&quot&size=700x436&key=AIzaSyCtrCwwfYZPctgU4nsQLCFKa1ZB3SFMa1A&maptype=roadmap&markers=color:red%7Clabel:%7C${evento.latitud},${evento.longitud}"/>
                                    </div>
                                    <!-- /.row -->
                                </div>
                                <!-- /.box-body -->

                            </div>
                        </div>
                        <a href="<c:url value='/evento/delete?id=${evento.id}'/>" class="btn btn-primary pull-right">Eliminar</a>
                        <a href="<c:url value='/evento/asignarServicio?id=${evento.id}'/>" class="btn btn-primary pull-right">Editar</a>
                    </div>

                </div>
            </div>

            <jsp:include page="../footer.jsp"/>

    </div>

</div>
</body>


<jsp:include page="../buttom.jsp"/>

<!-- jQuery Knob -->
<script src="<c:url value='/resources/plugins/knob/jquery.knob.js'/>"></script>


<script type="application/javascript">

    $(function () {
        $(".knob").knob();
    });

</script>

</html>git commit
