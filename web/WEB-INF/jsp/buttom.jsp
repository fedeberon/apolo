<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--   Core JS Files   -->
<script src="<c:url value='/resources/js/jquery-3.1.0.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/material.min.js'/>" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="<c:url value='/resources/js/chartist.min.js'/>"></script>

<!--  Notifications Plugin    -->
<script src="<c:url value='/resources/js/bootstrap-notify.js'/>"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Material Dashboard javascript methods -->
<script src="<c:url value='/resources/js/material-dashboard.js'/>"></script>

<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="<c:url value='/resources/js/demo.js'/>"></script>

<script type="text/javascript">
    $(document).ready(function(){

        // Javascript method's body can be found in assets/com.bolivarSoftware.apolo.web.js/demos.com.bolivarSoftware.apolo.web.js
        demo.initDashboardPageCharts();

    });
</script>