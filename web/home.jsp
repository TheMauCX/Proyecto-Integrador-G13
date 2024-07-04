<%-- 
    Document   : index
    Created on : 6 jun 2024, 7:18:27
    Author     : Docente
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
    String user = "";
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("username") == null) {
%>
<jsp:forward page="index.jsp">
    <jsp:param name="error" value="Ud. debe autenticarse...!"/>
</jsp:forward>
<%
} else {
    user = (String) sesion.getAttribute("username");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
        <%@include file="WEB-INF/sjsp/header.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/sjsp/body.jspf" %>
        <div class="container" style="padding-left: 200px;">
            
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <script th:inline="javascript">            
            $(function(){
            Highcharts.chart('container', {
            chart: {
            type: 'column'
            },
                    title: {
                    text: 'Personas por Rol'
                    },
                    subtitle: {
                    text: 'Sistema de Practicas Pre Profesionales'
                    },
                    xAxis: {
                    categories: ${titulos},
                            crosshair: true
                    },
                    yAxis: {
                    min: 0,
                            max:50,
                            title: {
                            text: 'Cantidad de Personas'
                            }
                    },
                    tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
                            footerFormat: '</table>',
                            shared: true,
                            useHTML: true
                    },
                    plotOptions: {
                    column: {
                    pointPadding: 0.2,
                            borderWidth: 0
                    }
                    },
                    series: [{
                    name: 'Personas',
                            data: ${cantidad}
                    }]
            });
          });
        </script>
        <%@include file="WEB-INF/sjsp/footer.jspf" %>
    </body>
</html>
<%}%>