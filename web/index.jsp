<%-- 
    Document   : home
    Created on : 6 jun 2024, 7:18:49
    Author     : Docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="shortcut icon" href="assets/images/pagina.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/style.css"/>
        <style>
            body {
                background-image: url('assets/images/lamb-cover-all.png');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
            
            .bg-custom { background-color: #152145 !important; }
            .text-custom { color: #152145 !important; }
        </style>
    </head>
    <body class="d-flex justify-content-center align-items-center vh-100">
        <div
            class="bg-white p-5 rounded-5 text-secondary shadow"
            style="width: 25rem"
            >
            <div class="d-flex justify-content-center">
                <img
                    src="assets/images/login-icon.svg"
                    alt="login-icon"
                    style="height: 7rem"/>
            </div>
            <div class="text-center fs-1 fw-bold">Iniciar Sesión</div>
            <form action="lc" method="post">
                <div class="input-group mt-4">
                    <div class="input-group-text bg-custom">
                        <img
                            src="assets/images/username-icon.svg"
                            alt="username-icon"
                            style="height: 1rem"
                            />
                    </div>
                    <input
                        class="form-control bg-light"
                        type="text"
                        name="nombre"
                        placeholder="Codigo o correo"
                        />
                </div>
                <div class="input-group mt-1">
                    <div class="input-group-text bg-custom">
                        <img
                            src="assets/images/password-icon.svg"
                            alt="password-icon"
                            style="height: 1rem"
                            />
                    </div>
                    <input
                        class="form-control bg-light"
                        type="password"
                        name="clave"
                        placeholder="Contraseña"
                        />
                </div>
                <div class="d-flex justify-content-around mt-1">
                    <div class="d-flex align-items-center gap-1">
                        <input class="form-check-input" type="checkbox" />
                        <div class="pt-1 text-custom" style="font-size: 0.9rem">Recordarme</div>
                    </div>
                    <div class="pt-1">
                        <a
                            href="#"
                            class="text-decoration-none text-custom fw-semibold fst-italic"
                            style="font-size: 0.9rem"
                            >¿Olvidaste tu contraseña?</a
                        >
                    </div>

                </div>
                <div class="d-grid gap-2 mt-4">
                    <button type="submit" class="btn bg-custom text-white">Ingresar</button>
                </div>
            </form>
            <!--
            <div class="d-flex gap-1 justify-content-center mt-1">
                <div>Don't have an account?</div>
                <a href="#" class="text-decoration-none text-custom fw-semibold"
                   >Register</a
                >
            </div> -->
            <div class="p-3">
                <div class="border-bottom text-center" style="height: 0.9rem">
                    <span class="bg-white px-3">o usar</span>
                </div>
            </div>  
            
            <div class="d-grid gap-2 mt-4">
                    <button type="submit" class="btn bg-warning text-white">Cuenta de Microsoft</button>
                </div>
            
        </div>

    </body>
</html>
