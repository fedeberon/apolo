<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Detalles del proveedor ${proveedor.nombre}</title>

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
                                <h4 class="title">Proveedor</h4>
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
                                            <td>${proveedor.id}</td>
                                        </tr>

                                        <tr>
                                             <th>Nombre</th>
                                             <td>${proveedor.nombre}</td>
                                        </tr>

                                        <tr>
                                            <th>Direccion</th>
                                            <td>${proveedor.direccion}</td>
                                        </tr>

                                        <tr>
                                            <th>Telefono</th>
                                            <td>${proveedor.telefono}</td>
                                        </tr>

                                        <tr>
                                            <th>Email</th>
                                            <td>${proveedor.email}</td>
                                        </tr>

                                        <tr>
                                            <th colspan="2">Servicios</th>
                                        </tr>

                                        <c:forEach items="${proveedor.servicios}" var="servicio">
                                            <tr>
                                                <td colspan="2">
                                                    <li>${servicio.nombre}</li>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <a href="<c:url value='/servicioContratado/comentariosDeProveedor?id=${proveedor.id}'/>" class="btn btn-primary pull-right">Comentarios</a>
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

</html>
