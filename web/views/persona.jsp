<%-- 
    Document   : persona
    Created on : 27 jun 2024, 9:57:53
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>JSP Page</title>
        <link rel="shortcut icon" href="./assets/images/pagina.png" type="image/x-icon">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
        <%@include file="../WEB-INF/sjsp/header.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/sjsp/body.jspf" %>
        <!-- end: Navbar -->

        <!-- start: Content -->
        <div class="container" style="padding-left: 200px;">
            <h3 class="container text-xl-center p-4">MANTENER PERSONA</h3>
            <div class="py-4">
                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Agregar</button>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Id</th>
                            <th scope="col">Persona</th>
                            <th scope="col">Apellido Paterno</th>
                            <th scope="col">Apellido Materno</th>
                            <th scope="col">Número</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Estado</th>
                            <th scope="col" colspan="2">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Nueva Persona</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="mb-3">
                                            <label for="recipient-name" class="col-form-label">Nombre: </label>
                                            <input type="text" class="form-control" id="nombre" name="">
                                            <label for="recipient-name" class="col-form-label">Apepat: </label>
                                            <input type="text" class="form-control" id="apepat" name="">
                                            <label for="recipient-name" class="col-form-label">Apemat: </label>
                                            <input type="text" class="form-control" id="apemat" name="">
                                            <label for="recipient-name" class="col-form-label">Numero: </label>
                                            <input type="text" class="form-control" id="numero" name="">
                                            <label for="recipient-name" class="col-form-label">Correo: </label>
                                            <input type="text" class="form-control" id="correo" name="">
                                            <label for="recipient-name" class="col-form-label">Fecha: </label>
                                            <input type="text" class="form-control" id="fecha" name="">
                                            
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" id="guardar">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Editar Persona</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="mb-3">
                                            <label for="recipient-name" class="col-form-label">Nombre: </label>
                                            <input type="text" class="form-control" id="nombre_edit" name="">
                                            <label for="recipient-name" class="col-form-label">Apepat: </label>
                                            <input type="text" class="form-control" id="apepat_edit" name="">
                                            <label for="recipient-name" class="col-form-label">Apemat: </label>
                                            <input type="text" class="form-control" id="apemat_edit" name="">
                                            <label for="recipient-name" class="col-form-label">Numero: </label>
                                            <input type="text" class="form-control" id="numero_edit" name="">
                                            <label for="recipient-name" class="col-form-label">Correo: </label>
                                            <input type="text" class="form-control" id="correo_edit" name="">
                                            <label for="recipient-name" class="col-form-label">Fecha: </label>
                                            <input type="text" class="form-control" id="fecha_edit" name="">
                                            <label for="recipient-name" class="col-form-label">Estado: </label>
                                            <input type="text" class="form-control" id="estado_edit" name="">
                                            <input type="hidden" class="form-control" id="id_persona_edit" name="">
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" id="editar">Editar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../WEB-INF/sjsp/footer.jspf" %>
        <script src="./assets/js/persona.js"></script>

    </body>
</html>
<%}%>