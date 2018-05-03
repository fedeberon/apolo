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

    <link href="<c:url value='/webjarslocator/bootstrap-x   datetimepicker/2.4.2/css/bootstrap-datetimepicker.css'/>" rel="stylesheet"/>

    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <%--<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <link href="<c:url value='/resources/css/agenda.css'/>" rel="stylesheet"/>
    <script src="<c:url value='/resources/js/gcal.js'/>" type="text/javascript"></script>
    <script type='text/javascript' src='<c:url value='/resources/plugins/fullcalendar/fullcalendar.js'/>'></script>
    <script type='text/javascript' src='<c:url value='/resources/js/moment.min.js'/>'></script>
    <script type='text/javascript' src='<c:url value='/resources/js/jquery.min.js'/>'></script>

    <style>
        .fc-event-time{
            display : none;
        }
        </style>

    <script>

        $(document).ready(function() {
            var date = new Date();
            var d = date.getDate();
            var m = date.getMonth();
            var y = date.getFullYear();

            /*  className colors

             className: default(transparent), important(red), chill(pink), success(green), info(blue)

             */


            /* initialize the external events
             -----------------------------------------------------------------*/


            $('#external-events div.external-event').each(function() {

                // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
                // it doesn't need to have a start or end
                var eventObject = {
                    title: $.trim($(this).text()) // use the element's text as the event title
                };

                // store the Event Object in the DOM element so we can get to it later
                $(this).data('eventObject', eventObject);

                // make the event draggable using jQuery UI
                $(this).draggable({
                    zIndex: 999,
                    revert: true,      // will cause the event to go back to its
                    revertDuration: 0  //  original position after the drag
                });

            });


            /* initialize the calendar
             -----------------------------------------------------------------*/

            var calendar =  $('#calendar').fullCalendar({
                googleCalendarApiKey: 'AIzaSyDBlXtPNXSLV2rJRL0aZSu_RJ3rQYkd2KA',
                events: {
                    googleCalendarId: 'aopd21js30lmhdh3se3jtgm8e0@group.calendar.google.com',
                    className: 'gcal-event'
                },
                header: {
                    left: 'title',
                    center: 'agendaDay,agendaWeek,month',
                    right: 'prev,next today'
                },
                editable: true,
                firstDay: 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
                selectable: true,
                defaultView: 'month',

                axisFormat: 'h:mm',
                columnFormat: {
                    month: 'ddd',    // Mon
                    week: 'ddd d', // Mon 7
                    day: 'dddd M/d',  // Monday 9/7
                    agendaDay: 'dddd d'
                },
                titleFormat: {
                    month: 'MMMM yyyy', // September 2009
                    week: "MMMM yyyy", // September 2009
                    day: 'MMMM yyyy'                  // Tuesday, Sep 8, 2009
                },
                allDaySlot: false,
                selectHelper: true,
                select: function(start, end, allDay) {
                    var title = prompt('Event Title:');
                    if (title) {
                        calendar.fullCalendar('renderEvent',
                                {
                                    title: title,
                                    start: start,
                                    end: end,
                                    allDay: allDay
                                },
                                true // make the event "stick"
                        );


                        var fechaInicio = $.fullCalendar.formatDate(start, "yyyy-MM-dd");

                        var fechaFin = $.fullCalendar.formatDate(end, "yyyy-MM-dd");

//                        alert(title + " start:" + fechaInicio + " end: " + fechaFin + " all Day: " + allDay);

//                        window.location.href = 'http://localhost:8080/apolo/agenda/create?titulo=' + title + '&inicio=' + fechaInicio + '&fin=' + fechaFin;

                        saveEvent(title, fechaInicio);

                    }
                    calendar.fullCalendar('unselect');
                },
                displayEventTime: false,
                droppable: true, // this allows things to be dropped onto the calendar !!!
                drop: function(date, allDay) { // this function is called when something is dropped

                    // retrieve the dropped element's stored Event Object
                    var originalEventObject = $(this).data('eventObject');

                    // we need to copy it, so that multiple events don't have a reference to the same object
                    var copiedEventObject = $.extend({}, originalEventObject);

                    // assign it the date that was reported
                    copiedEventObject.start = date;
                    copiedEventObject.allDay = allDay;

                    // render the event on the calendar
                    // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
                    $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

                    // is the "remove after drop" checkbox checked?
                    if ($('#drop-remove').is(':checked')) {
                        // if so, remove the element from the "Draggable Events" list
                        $(this).remove();
                    }

                },

                eventSources: [

                    // your event source
                    {
                        url: 'http://localhost:8080/apolo/agendaRest/events',
                        type: 'POST',
                        data: {
                            custom_param1: 'something',
                            custom_param2: 'somethingelse'
                        },
                        error: function() {
                            alert('there was an error while fetching events!');
                        },
                        color: 'yellow',   // a non-ajax option
                        textColor: 'black' // a non-ajax option
                    }

                    // any other sources...

                ]
            });
        });


        function saveEvent(title,startdate){
            $.ajax({
                url: "/apolo/agendaRest/save?title=" + title + "&startdate=" + startdate
            });
        }
    </script>
    <style>

        #wrap {
            width: 1100px;
            margin: 0 auto;
        }

        #external-events {
            float: left;
            width: 150px;
            padding: 0 10px;
            text-align: left;
        }

        #external-events h4 {
            font-size: 16px;
            margin-top: 0;
            padding-top: 1em;
        }

        .external-event { /* try to mimick the look of a real event */
            margin: 10px 0;
            padding: 2px 4px;
            background: #3366CC;
            color: #fff;
            font-size: .85em;
            cursor: pointer;
        }

        #external-events p {
            margin: 1.5em 0;
            font-size: 11px;
            color: #666;
        }

        #external-events p input {
            margin: 0;
            vertical-align: middle;
        }

        #calendar {
            /* 		float: right; */
            margin: 0 auto;
            width: 900px;
            background-color: #FFFFFF;
            border-radius: 6px;
            box-shadow: 0 1px 2px #C3C3C3;
            -webkit-box-shadow: 0px 0px 21px 2px rgba(0,0,0,0.18);
            -moz-box-shadow: 0px 0px 21px 2px rgba(0,0,0,0.18);
            box-shadow: 0px 0px 21px 2px rgba(0,0,0,0.18);
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

<script src="<c:url value='/webjarslocator/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.es.js'/>" type="text/javascript"></script>
<script src="<c:url value='/webjarslocator/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js'/>" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        $('.fecha').datetimepicker({
            locale: 'es'
        });
    });
</script>

<script src="<c:url value='/resources/js/agenda.js'/>" type="text/javascript"></script>



</html>
