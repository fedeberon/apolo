<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Lista de Usuarios</title>

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
                                <h4 class="title">Usuarios</h4>
                                <p class="category">lista</p>
                            </div>
                            <div class="card-content table-responsive">
                                <table class="table">
                                    <thead class="text-warning">
                                    <th>Username</th>
                                    <th>Contrase&ntildea</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th></th>
                                    <th></th>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${usuarios}" var="bo">
                                        <tr>
                                            <td><a href="/apolo/usuario/show?username=${bo.username}">${bo.username}</a></td>
                                            <td>${bo.password}</td>
                                            <td>${bo.nombre}</td>
                                            <td>${bo.apellido}</td>
                                            <td><button  style="float:right" type="button" id="${bo.username}" class="btn btn-primary btn-usuario" data-toggle="modal" data-target="#modal-documentos">Asociar un Evento</button></td>
                                            <td><a href="../../eventoUsuario/show?username=${bo.username}"><button  style="float:right" type="button" id="${bo.username}" class="btn btn-primary btn-usuario">Ver eventos asociados</button></a></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>



                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="col-xs-12">
                <div class="col-xs-2">
                    <a href="/apolo/evento/list?page=${page - 1}" class="btn btn-block btn-primary">Atras</a>
                </div>
                <div class="col-xs-2">
                    <a href="/apolo/evento/list?page=${page + 1}" class="btn btn-block btn-primary">Siguiente</a>
                </div>
                <div class="col-xs-2">
                    <a href="<c:url value='/usuario/create'/>" class="btn btn-block btn-primary">Nuevo</a>
                </div>
            </div>

        </div>
        <jsp:include page="../footer.jsp"/>

    </div>

</div>

<div id="modal-documentos" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Asociar evento</h4>
            </div>

            <form:form action="../../eventoUsuario/save" modelAttribute="eventoUsuario" method="post">
                <div class="modal-body">
                        <div class="form-group">
                            <label class="control-label">Usuario</label>
                            <form:input cssClass="form-control" id="username-evento" path="usuario.username"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Ingresar Cod Int del Evento</label>
                            <form:input cssClass="form-control" path="evento.id"/>
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-default">Asociar</button>
                </div>
            </form:form>

        </div>
    </div>
</div>

</body>


<jsp:include page="../buttom.jsp"/>

<script>
    $( ".btn-usuario" ).click(function() {
            var id = $( this ).attr('id');

        $('#username-evento').val(id);

        $('#lbl-username-evento').html(id);

    });
</script>


</html>
