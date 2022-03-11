<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Detalles del Salon ${salon.nombre}</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>

    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <!--  Material Dashboard CSS    -->
    <link href="<c:url value='/resources/css/material-dashboard.css'/>" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="<c:url value='/resources/css/demo.css'/>" rel="stylesheet"/>
    
    <!-- Bootstrap core CSS     -->
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>



    <!--     Fonts and icons     -->
    <link href="<c:url value='/resources/plugins/knob/jquery.knob.js'/>" rel="stylesheet"/>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>

   
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
                                <h4 class="title">Salon</h4>
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
                                        <td>${salon.id}</td>
                                    </tr>

                                    <tr>
                                        <th>Nombre</th>
                                        <td>${salon.nombre}</td>
                                    </tr>

                                    <tr>
                                        <th>Direccion</th>
                                        <td>${salon.direccion}</td>
                                    </tr>

                                    <tr>
                                        <th>Telefono</th>
                                        <td>${salon.telefono}</td>
                                    </tr>

                                    <tr>
                                        <th>Email</th>
                                        <td>${salon.email}</td>
                                    </tr>

                                    <tr>
                                        <th>Comentario</th>
                                        <td>${salon.comentario}</td>
                                    </tr>

                                    <tr>
                                        <th>Descripcion</th>
                                        <td>${salon.descripcion}</td>
                                    </tr>



                                    </tbody>
                                </table>

                                <hr>


                            </div>
                        </div>
                        <a href="<c:url value='/salon/edit?id=${salon.id}'/>" class="btn btn-primary pull-right">Editar</a>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-documentos">Cargar Imagenes</button>
                        <button class="btn btn-default" data-toggle="modal" data-target="#carousel-img">Ver Imagenes</button>
                    </div>


                </div>
            </div>

            <jsp:include page="../footer.jsp"/>

        </div>

    </div>

    <div id="modal-documentos" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Imagenes</h4>
                </div>

                <form:form  action="/apolo/documento/uploadFile" modelAttribute="documento" enctype="multipart/form-data">
                    <div class="modal-body">

                        <input type="hidden" name="subCarpeta" value="${salon.id}"/>

                        <input type="file" name="file"/>
                        <input type="hidden" name="carpeta" value="IMAGENES"/>
                        <input type="hidden" name="urlRedirect" value="salon/show?id=${salon.id}"/>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-default">Guardar</button>
                    </div>
                </form:form>

            </div>
        </div>
    </div>

            <!-- Large modal -->
            <div id="carousel-img" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" style="margin-top: auto;">
                    <div class="modal-content-img">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <c:forEach items="${imagenes}" var="imagen" varStatus="status">
                                    <div class="d-flex justify-content-between  item   <c:if test="${status.first}">active</c:if>">
                                        <img class="d-block w-100" src="http://localhost/IMAGENES/1/${imagen.url}" style="height:100vh; margin:auto ;" alt="...">
                                        <div class="carousel-caption"></div>
                                    </div>
                                </c:forEach>
                                
                            </div>

                            <!-- Controls -->
                            <a class="left carousel-control" href="#carousel-example-generic"  role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
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
