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

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <style>
        #custom-handle {
            width: 3em;
            height: 1.6em;
            top: 50%;
            margin-top: -.8em;
            text-align: center;
            line-height: 1.6em;
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
                                <h4 class="title">Servicio Contratado: ${servicioContratado.servicio.nombre}</h4>
                                <p class="category">Evento <a href="<c:url value='/evento/show?id=${servicioContratado.evento.id}'/>">${servicioContratado.evento.nombre} - Fecha del Evento ${servicioContratado.evento.fechaDeEvento} </a></p>
                            </div>
                            <div class="card-content table-responsive">

                                <form:form action="/apolo/servicioContratado/save" modelAttribute="servicioContratado">
                                    <form:hidden path="id"/>
                                    <form:hidden path="servicio.id"/>
                                    <form:hidden path="evento.id"/>

                                    <table class="table">
                                        <thead class="text-primary">
                                        <th>Tarea</th>
                                        <th>Estado</th>
                                        <th>Cantidad de dias</th>
                                        <th>Importancia</th>
                                        <th></th>
                                        <th>Descripcion</th>
                                        </thead>
                                        <tbody>

                                        <c:forEach items="${servicioContratado.etapas}" var="etapa" varStatus="status">
                                            <form:hidden path="etapas[${status.index}].id"/>
                                            <form:hidden path="etapas[${status.index}].servicioContratado.id"/>
                                            <form:hidden path="etapas[${status.index}].etapa.id"/>

                                            <tr>
                                                <td>${etapa.etapa.nombre}</td>
                                                <td>
                                                    <div class="checkbox">
                                                        <label>
                                                            <form:checkbox path="etapas[${status.index}].completada"/>
                                                        </label>
                                                    </div>
                                                </td>

                                                <td>
                                                    <form:input path="etapas[${status.index}].cantidadDiasLimiteDeResolucion" cssStyle="width:30px;"/>
                                                </td>

                                                <td>
                                                    <form:input path="etapas[${status.index}].pesoEspecifico" id="valor-${etapa.id}" cssStyle="width:30px;"/>
                                                </td>

                                                <td>
                                                    <div class="slider" id="${etapa.id}" style="width:150px;" value="${etapa.pesoEspecifico}">
                                                        <div id="custom-handle" class="ui-slider-handle"></div>
                                                    </div>
                                                </td>

                                                <td>
                                                    <form:textarea path="etapas[${status.index}].descripcion" />
                                                </td>

                                                <td>
                                                    <a href="<c:url value='/tareas/delete?id=${etapa.id}&idServicio=${servicioContratado.id}'/>" class="material-icons">delete</a>
                                                </td>

                                            </tr>

                                        </c:forEach>

                                        <tr>
                                            <td colspan="6">
                                                <form:textarea path="comentario" placeholder="Comentarios" cssStyle="width: 100%" />
                                            </td>
                                        </tr>

                                        </tbody>
                                    </table>


                                    <a href="<c:url value='/servicioContratado/delete?id=${servicioContratado.id}&idEvento=${servicioContratado.evento.id}'/>" class="btn btn-primary pull-right">Eliminar</a>
                                    <button type="submit" class="btn btn-primary pull-right">Guardar</button>


                                </form:form>
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

<!-- jQuery Knob -->
<script src="<c:url value='/resources/plugins/knob/jquery.knob.js'/>"></script>

<script src="<c:url value='/resources/plugins/jQueryUI/jquery-ui.js'/>"></script>

<script type="application/javascript">
    $(function () {
        $(".knob").knob();
    });
</script>

<script>
    $( function() {
        var handle = $( ".custom-handle" );
        $( ".slider" ).slider({
            create: function() {
                $( this ).slider( "value" , $( this ).attr('value'));
            },
            slide: function( event, ui ) {
                handle.text( ui.value );
                cargarValor(this, ui);
            },
        });
    } );


    function cargarValor(element, ui){
        var id = $( element ).attr('id');
        $("#valor-"+id).val(ui.value);
    }


</script>

</html>
