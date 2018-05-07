<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Apolo</title>

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

    <!--     Full Calendar     -->
    <link href="<c:url value='/resources/fullcalendar-3.9.0/fullcalendar.min.css'/>" rel="stylesheet"/>

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
                                <h4 class="title">Agenda</h4>
                                <p class="category">Cargue sus tareas</p>
                            </div>
                            <div class="card-content table-responsive">
                                <div id='calendar'></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

        <jsp:include page="../footer.jsp"/>

</div>




<%--<!-- Large modal -->--%>
<%--<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">--%>
    <%--<div class="modal-dialog modal-lg">--%>
        <%--<div class="modal-content">--%>
            <%--<div id="map" style="width:100%;height:500px;margin-top: 1px;"></div>--%>

            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>--%>
                <%--<button type="button" class="btn btn-primary" data-dismiss="modal">Seleccionar Ubicaci&oacute;n</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

</body>

<jsp:include page="../buttom.jsp"/>

<script type='text/javascript' src='<c:url value='/resources/fullcalendar-3.9.0/gcal.js'/>'></script>


<script>

    $(document).ready(function() {

        var calendar = $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,basicWeek,basicDay'
            },
            navLinks: true, // can click day/week names to navigate views
            editable: true,
            eventLimit: true, // allow "more" link when too many events
            events: '../agendaRest/events',
            googleCalendarApiKey: 'AIzaSyDBlXtPNXSLV2rJRL0aZSu_RJ3rQYkd2KA',
            eventSources: [
                {
                    googleCalendarId: 'aopd21js30lmhdh3se3jtgm8e0@group.calendar.google.com',
                    className: 'gcal-event',
                    url: '../agendaRest/events',
                },
            ],

            editable: true,
            selectable: true,
            selectHelper: true,
            droppable: true,
            axisFormat: 'h:mm',
            select: function(start, end, jsEvent, view) {
                var title = prompt('Event Title:');

                if (title) {
                    calendar.fullCalendar('renderEvent',
                            {
                                title: title,
                                start: start,
                                end: end
                            },
                            true // make the event "stick"
                    );

                    var fechaInicio = $.fullCalendar.formatDate(start, "yyyy-MM-dd");

                    var fechaFin = $.fullCalendar.formatDate(end, "yyyy-MM-dd");

                    saveEvent(title, fechaInicio);

                }
            }
    });

    function saveEvent(title,startdate){
        $.ajax({
            url: "../agendaRest/save?title=" + title + "&startdate=" + startdate
        });
    }
    });

</script>



</html>
