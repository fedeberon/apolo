<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Material Dashboard by Creative Tim</title>

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

                    <form:form action="/apolo/evento/save" modelAttribute="evento">

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header" data-background-color="purple">
                                    <h4 class="title">Nuevo Evento</h4>
                                    <p class="category">Complete los datos</p>
                                </div>

                                <div class="card-content">

                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group label-floating">
                                                <form:hidden path="id"/>
                                                <label class="control-label">Nombre</label>
                                                <label>${evento.nombre}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Fecha</label>
                                                <label>${evento.fechaDeEvento}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Ciudad</label>
                                                <label>${evento.ciudad}</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Domicilio</label>
                                                <label>${evento.domicilio}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Telefono</label>
                                                <label>${evento.telefono}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Lugar</label>
                                                <label>${evento.mail}</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">

                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Contratado por</label>
                                                <label>${evento.contratadoPor}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Email</label>
                                                <input type="email" class="form-control">
                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-primary pull-right">Aceptar</button>
                                    <div class="clearfix"></div>

                                </div>
                            </div>
                        </div>

                        <c:forEach items="${servicios}" var="bo" varStatus="status">
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-content">
                                        <h3>${bo.nombre}</h3>
                                        <input type="hidden" name="servicio.id" value="${bo.id}"/>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" name="servicios[${status.index}].servicio.id" value="${bo.id}"/>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons text-info">warning</i> <a href="#">${bo.proveedor.nombre}</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>


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
