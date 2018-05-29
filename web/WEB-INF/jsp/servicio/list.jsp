<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Lista de Servicios</title>

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
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet'
          type='text/css'>
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
                                <h4 class="title">Servicios</h4>
                                <p class="category">lista</p>
                            </div>
                            <div class="card-content table-responsive">
                                <table class="table">
                                    <thead class="text-primary">
                                    <th>Nombre</th>
                                    <th>Proveedor</th>
                                    <th></th>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${servicios}" var="bo">
                                        <tr>
                                            <td>${bo.nombre}</td>
                                            <td>${bo.proveedor.nombre}</td>
                                            <td class="text-primary"><a href="<c:url value='/servicio/show?id=${bo.id}'/>"> ver etapas</a></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>

                                <a href="<c:url value='/servicio/create'/>" class="btn btn-primary pull-right">Nuevo</a>
                            </div>


                        </div>


                    </div>

                </div>
            </div>
        </div>
        <jsp:include page="../footer.jsp"/>

    </div>

</div>
</body>


<jsp:include page="../buttom.jsp"/>


</html>
