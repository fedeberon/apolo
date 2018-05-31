<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Nuevo Proveedor </title>

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
                                <h4 class="title">Nuevo Proveedor</h4>
                                <p class="category">Complete los datos</p>
                            </div>

                            <div class="card-content">
                                <form:form action="/apolo/proveedor/save" modelAttribute="proveedor">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Nombre</label>
                                                <form:input cssClass="form-control" path="nombre"/>
                                            </div>

                                            <div class="form-group label-floating">
                                                <label class="control-label">Telefono</label>
                                                <form:input cssClass="form-control" path="telefono"/>
                                            </div>

                                            <div class="form-group label-floating">
                                                <label class="control-label">Email</label>
                                                <form:input cssClass="form-control" path="email"/>
                                            </div>

                                            <div class="form-group label-floating">
                                                <label class="control-label">Direccion</label>
                                                <form:input cssClass="form-control" path="direccion"/>
                                            </div>

                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-primary pull-right">Aceptar</button>
                                    <div class="clearfix"></div>
                                </form:form>
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
