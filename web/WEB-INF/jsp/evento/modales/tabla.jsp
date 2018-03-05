<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card card-nav-tabs">
    <div class="card-header" data-background-color="purple">
        <div class="nav-tabs-navigation">
            <div class="nav-tabs-wrapper">
                <ul class="nav nav-tabs" data-tabs="tabs">
                    <li class="active">
                        <a href="#profile" data-toggle="tab">
                            Servicios a Contratar
                            <div class="ripple-container"></div></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="card-content">
        <div class="tab-content">
            <div class="tab-pane active" id="profile">

                         <c:forEach items="${servicios}" var="bo" varStatus="status">
                             <div class="col-sm-3">
                                <input type="hidden" name="servicio.id" value="${bo.id}"/>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="servicios[${status.index}].servicio.id" value="${bo.id}"/>
                                        </label>
                                    </div>
                                    ${bo.nombre}
                              </div>
                        </c:forEach>

              </div>
        </div>
    </div>


</div>
