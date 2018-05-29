<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Nuevo Usuario</title>

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

  <link href="<c:url value='/webjarslocator/bootstrap-datetimepicker/2.4.2/css/bootstrap-datetimepicker.css'/>" rel="stylesheet"/>
</head>

<body>

<div class="wrapper">

    <jsp:include page="../sidebar.jsp"/>

    <div class="main-panel">

        <jsp:include page="../menu.jsp"/>

        <div class="content">
            <div class="container-fluid">
                <div class="row">

                    <form:form action="/apolo/usuario/save" modelAttribute="usuario">

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header" data-background-color="purple">
                                    <h4 class="title">Nuevo Usuario</h4>
                                    <p class="category">Complete los datos</p>
                                </div>

                                <div class="card-content">

                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Username</label>
                                                <form:input cssClass="form-control" path="username"/>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Password</label>
                                                <form:input cssClass="form-control" path="password" type="password"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Nombre</label>
                                                <form:input cssClass="form-control" path="nombre"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Apellido</label>
                                                <form:input cssClass="form-control" path="apellido"/>
                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-primary pull-right">Crear</button>
                                    <div class="clearfix"></div>

                                </div>
                            </div>
                        </div>
                    </form:form>

                </div>
            </div>
        </div>

        <jsp:include page="../footer.jsp"/>

    </div>

</div>
</body>



<jsp:include page="../buttom.jsp"/>

<script src="<c:url value='/webjarslocator/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.es.js'/>" type="text/javascript"></script>
<script src="<c:url value='/webjarslocator/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js'/>" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        $('.fecha').datetimepicker({
            locale: 'es'
        });
    });
</script>


</html>