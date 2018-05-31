<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Linea de tiempo</title>

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

     <style>

         .timeline {
             list-style: none;
             padding: 20px 0 20px;
             position: relative;
         }

         .timeline:before {
             top: 0;
             bottom: 0;
             position: absolute;
             content: " ";
             width: 3px;
             background-color: #eeeeee;
             left: 50%;
             margin-left: -1.5px;
         }

         .timeline > li {
             margin-bottom: 20px;
             position: relative;
         }

         .timeline > li:before,
         .timeline > li:after {
             content: " ";
             display: table;
         }

         .timeline > li:after {
             clear: both;
         }

         .timeline > li:before,
         .timeline > li:after {
             content: " ";
             display: table;
         }

         .timeline > li:after {
             clear: both;
         }

         .timeline > li > .timeline-panel {
             width: 46%;
             float: left;
             border: 1px solid #d4d4d4;
             border-radius: 2px;
             padding: 20px;
             position: relative;
             -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
             box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
         }

         .timeline > li > .timeline-panel:before {
             position: absolute;
             top: 26px;
             right: -15px;
             display: inline-block;
             border-top: 15px solid transparent;
             border-left: 15px solid #ccc;
             border-right: 0 solid #ccc;
             border-bottom: 15px solid transparent;
             content: " ";
         }

         .timeline > li > .timeline-panel:after {
             position: absolute;
             top: 27px;
             right: -14px;
             display: inline-block;
             border-top: 14px solid transparent;
             border-left: 14px solid #fff;
             border-right: 0 solid #fff;
             border-bottom: 14px solid transparent;
             content: " ";
         }

         .timeline > li > .timeline-badge {
             color: #fff;
             width: 50px;
             height: 50px;
             line-height: 50px;
             font-size: 1.4em;
             text-align: center;
             position: absolute;
             top: 16px;
             left: 50%;
             margin-left: -25px;
             background-color: #999999;
             z-index: 100;
             border-top-right-radius: 50%;
             border-top-left-radius: 50%;
             border-bottom-right-radius: 50%;
             border-bottom-left-radius: 50%;
         }

         .timeline > li.timeline-inverted > .timeline-panel {
             float: right;
         }

         .timeline > li.timeline-inverted > .timeline-panel:before {
             border-left-width: 0;
             border-right-width: 15px;
             left: -15px;
             right: auto;
         }

         .timeline > li.timeline-inverted > .timeline-panel:after {
             border-left-width: 0;
             border-right-width: 14px;
             left: -14px;
             right: auto;
         }

         .timeline-badge.primary {
             background-color: #2e6da4 !important;
         }

         .timeline-badge.success {
             background-color: #3f903f !important;
         }

         .timeline-badge.warning {
             background-color: #f0ad4e !important;
         }

         .timeline-badge.danger {
             background-color: #d9534f !important;
         }

         .timeline-badge.info {
             background-color: #5bc0de !important;
         }

         .timeline-title {
             margin-top: 0;
             color: inherit;
         }

         .timeline-body > p,
         .timeline-body > ul {
             margin-bottom: 0;
         }

         .timeline-body > p + p {
             margin-top: 5px;
         }

         @media (max-width: 767px) {
             ul.timeline:before {
                 left: 40px;
             }

             ul.timeline > li > .timeline-panel {
                 width: calc(100% - 90px);
                 width: -moz-calc(100% - 90px);
                 width: -webkit-calc(100% - 90px);
             }

             ul.timeline > li > .timeline-badge {
                 left: 15px;
                 margin-left: 0;
                 top: 16px;
             }

             ul.timeline > li > .timeline-panel {
                 float: right;
             }

             ul.timeline > li > .timeline-panel:before {
                 border-left-width: 0;
                 border-right-width: 15px;
                 left: -15px;
                 right: auto;
             }

             ul.timeline > li > .timeline-panel:after {
                 border-left-width: 0;
                 border-right-width: 14px;
                 left: -14px;
                 right: auto;
             }
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
                                    <h4 class="title">Evento</h4>
                                    <%--<p class="category">lista</p>--%>
                                </div>
                                <div class="card-content table-responsive">

                                    <div class="card-content table-responsive">

                                        <div class="container">

                                            <ul class="timeline">


                                                <c:forEach items="${etapas}" var="bo">


                                                    <li>
                                                            <%--//representa al icono junto a la linea de tiempo--%>
                                                        <div class="timeline-badge"><i class="material-icons"> <c:if test="${bo.completada}">done</c:if> <c:if test="${!bo.completada}">clear</c:if>  </i></div>
                                                            <%--representa al modulo de informacion de la tarea--%>
                                                        <div class="timeline-panel">
                                                            <div class="timeline-heading">
                                                                    <%--representa al titulo de la tarea--%>
                                                                <h4 class="timeline-title">Servicio: ${bo.servicioContratado.servicio.nombre}</h4>
                                                                <h4 class="timeline-title">Etapa: ${bo.etapa.nombre}</h4>
                                                                    <%--representa a la fecha de la tarea--%>

                                                                <p><small class="text-muted"><i class="material-icons">alarm on</i>${bo.fecha}</small></p>
                                                            </div>
                                                                <%--representa al cuerpo de la tarea con las descripciones y los detalles--%>
                                                            <div class="timeline-body">
                                                                <p>${bo.descripcion}</p>
                                                            </div>
                                                        </div>
                                                    </li>


                                                </c:forEach>

                                            </ul>
                                        </div>

                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <jsp:include page="../footer.jsp"/>

            </div>
</body>


<jsp:include page="../buttom.jsp"/>


<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript">
    $(function() {

        var $sidescroll	= (function() {

            // the row elements
            var $rows			= $('#ss-container > div.ss-row'),
                    // we will cache the inviewport rows and the outside viewport rows
                    $rowsViewport, $rowsOutViewport,
                    // navigation menu links
                    $links			= $('#ss-links > a'),
                    // the window element
                    $win			= $(window),
                    // we will store the window sizes here
                    winSize			= {},
                    // used in the scroll setTimeout function
                    anim			= false,
                    // page scroll speed
                    scollPageSpeed	= 2000 ,
                    // page scroll easing
                    scollPageEasing = 'easeInOutExpo',
                    // perspective?
                    hasPerspective	= false,

                    perspective		= hasPerspective && Modernizr.csstransforms3d,
                    // initialize function
                    init			= function() {

                        // get window sizes
                        getWinSize();
                        // initialize events
                        initEvents();
                        // define the inviewport selector
                        defineViewport();
                        // gets the elements that match the previous selector
                        setViewportRows();
                        // if perspective add css
                        if( perspective ) {
                            $rows.css({
                                '-webkit-perspective'			: 600,
                                '-webkit-perspective-origin'	: '50% 0%'
                            });
                        }
                        // show the pointers for the inviewport rows
                        $rowsViewport.find('a.ss-circle').addClass('ss-circle-deco');
                        // set positions for each row
                        placeRows();

                    },
                    // defines a selector that gathers the row elems that are initially visible.
                    // the element is visible if its top is less than the window's height.
                    // these elements will not be affected when scrolling the page.
                    defineViewport	= function() {

                        $.extend( $.expr[':'], {

                            inviewport	: function ( el ) {
                                if ( $(el).offset().top < winSize.height ) {
                                    return true;
                                }
                                return false;
                            }

                        });

                    },
                    // checks which rows are initially visible
                    setViewportRows	= function() {

                        $rowsViewport 		= $rows.filter(':inviewport');
                        $rowsOutViewport	= $rows.not( $rowsViewport )

                    },
                    // get window sizes
                    getWinSize		= function() {

                        winSize.width	= $win.width();
                        winSize.height	= $win.height();

                    },
                    // initialize some events
                    initEvents		= function() {

                        // navigation menu links.
                        // scroll to the respective section.
                        $links.on( 'click.Scrolling', function( event ) {

                            // scroll to the element that has id = menu's href
                            $('html, body').stop().animate({
                                scrollTop: $( $(this).attr('href') ).offset().top
                            }, scollPageSpeed, scollPageEasing );

                            return false;

                        });

                        $(window).on({
                            // on window resize we need to redefine which rows are initially visible (this ones we will not animate).
                            'resize.Scrolling' : function( event ) {

                                // get the window sizes again
                                getWinSize();
                                // redefine which rows are initially visible (:inviewport)
                                setViewportRows();
                                // remove pointers for every row
                                $rows.find('a.ss-circle').removeClass('ss-circle-deco');
                                // show inviewport rows and respective pointers
                                $rowsViewport.each( function() {

                                    $(this).find('div.ss-left')
                                            .css({ left   : '0%' })
                                            .end()
                                            .find('div.ss-right')
                                            .css({ right  : '0%' })
                                            .end()
                                            .find('a.ss-circle')
                                            .addClass('ss-circle-deco');

                                });

                            },
                            // when scrolling the page change the position of each row
                            'scroll.Scrolling' : function( event ) {

                                // set a timeout to avoid that the
                                // placeRows function gets called on every scroll trigger
                                if( anim ) return false;
                                anim = true;
                                setTimeout( function() {

                                    placeRows();
                                    anim = false;

                                }, 10 );

                            }
                        });

                    },
                    // sets the position of the rows (left and right row elements).
                    // Both of these elements will start with -50% for the left/right (not visible)
                    // and this value should be 0% (final position) when the element is on the
                    // center of the window.
                    placeRows		= function() {

                        // how much we scrolled so far
                        var winscroll	= $win.scrollTop(),
                                // the y value for the center of the screen
                                winCenter	= winSize.height / 2 + winscroll;

                        // for every row that is not inviewport
                        $rowsOutViewport.each( function(i) {

                            var $row	= $(this),
                                    // the left side element
                                    $rowL	= $row.find('div.ss-left'),
                                    // the right side element
                                    $rowR	= $row.find('div.ss-right'),
                                    // top value
                                    rowT	= $row.offset().top;

                            // hide the row if it is under the viewport
                            if( rowT > winSize.height + winscroll ) {

                                if( perspective ) {

                                    $rowL.css({
                                        '-webkit-transform'	: 'translate3d(-75%, 0, 0) rotateY(-90deg) translate3d(-75%, 0, 0)',
                                        'opacity'			: 0
                                    });
                                    $rowR.css({
                                        '-webkit-transform'	: 'translate3d(75%, 0, 0) rotateY(90deg) translate3d(75%, 0, 0)',
                                        'opacity'			: 0
                                    });

                                }
                                else {

                                    $rowL.css({ left 		: '-50%' });
                                    $rowR.css({ right 		: '-50%' });

                                }

                            }
                            // if not, the row should become visible (0% of left/right) as it gets closer to the center of the screen.
                            else {

                                // row's height
                                var rowH	= $row.height(),
                                        // the value on each scrolling step will be proporcional to the distance from the center of the screen to its height
                                        factor 	= ( ( ( rowT + rowH / 2 ) - winCenter ) / ( winSize.height / 2 + rowH / 2 ) ),
                                        // value for the left / right of each side of the row.
                                        // 0% is the limit
                                        val		= Math.max( factor * 50, 0 );

                                if( val <= 0 ) {

                                    // when 0% is reached show the pointer for that row
                                    if( !$row.data('pointer') ) {

                                        $row.data( 'pointer', true );
                                        $row.find('.ss-circle').addClass('ss-circle-deco');

                                    }

                                }
                                else {

                                    // the pointer should not be shown
                                    if( $row.data('pointer') ) {

                                        $row.data( 'pointer', false );
                                        $row.find('.ss-circle').removeClass('ss-circle-deco');

                                    }

                                }

                                // set calculated values
                                if( perspective ) {

                                    var	t		= Math.max( factor * 75, 0 ),
                                            r		= Math.max( factor * 90, 0 ),
                                            o		= Math.min( Math.abs( factor - 1 ), 1 );

                                    $rowL.css({
                                        '-webkit-transform'	: 'translate3d(-' + t + '%, 0, 0) rotateY(-' + r + 'deg) translate3d(-' + t + '%, 0, 0)',
                                        'opacity'			: o
                                    });
                                    $rowR.css({
                                        '-webkit-transform'	: 'translate3d(' + t + '%, 0, 0) rotateY(' + r + 'deg) translate3d(' + t + '%, 0, 0)',
                                        'opacity'			: o
                                    });

                                }
                                else {

                                    $rowL.css({ left 	: - val + '%' });
                                    $rowR.css({ right 	: - val + '%' });

                                }

                            }

                        });

                    };

            return { init : init };

        })();

        $sidescroll.init();

    });
</script>



</html>
