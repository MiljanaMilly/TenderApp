<%-- 
    Document   : dodaj_zaposlenog
    Created on : Jul 5, 2018, 12:54:41 PM
    Author     : Milly
--%>

<%@page import="com.tenderplus.util.LoginBean"%>
<%@page import="com.tenderplus.dao.RoleDAOImpl"%>
<%@page import="com.tenderplus.dao.RoleDAO"%>
<%@page import="com.tenderplus.dao.RoleDAO"%>
<%@page import="com.tenderplus.entities.Role"%>
<%@page import="com.tenderplus.dao.LoginZaposleniDAOImpl"%>
<%@page import="com.tenderplus.dao.LoginZaposleniDAO"%>
<%@page import="com.tenderplus.entities.LoginZaposleni"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zaposleni | Forma za unos</title>
        <link rel="stylesheet" href="../resources/styles.css" />
    </head>
    <body>
        <div class="container">
            <header>
                <%@ include file="../header1.jsp" %>
            </header>
            <article>
                <% LoginBean lgb = (LoginBean) session.getAttribute("loginBean");%>

                <div class="row">
                    <div class="jumbotron">
                        <div class="row"> <div class=" col-md-10"> 
                                <h4 class="text-left">Prijavljeni ste kao  <%= lgb.getUsername()%>, </h4> </div>
                            <div class=" col-md-2"><form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
                                    <input type="submit" value="Log out" class="btn btn-outline-primary"  />
                                </form> </div>
                        </div>
                        <br/>

                        <div class="row">
                            <center>
                                <ul class="nav nav-pills nav-fill">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="menadzment_page_zaposleni.jsp">Menadžment</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="tenderi_page.jsp">Tenderi</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="oprema_page.jsp">Oprema</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link " href="servis_page.jsp">Servis</a>
                                    </li>
                                </ul>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="../index.jsp">Početna</a></li>
                                        <li class="breadcrumb-item"><a href="menadzment_page_zaposleni.jsp">Menadžment</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Zaposleni</li>
                                    </ol>
                                </nav>
                                <br/>
                                <br/>

                                <div class="card">
                                    <div class="card-header">
                                        Dodaj Menadzera
                                    </div>
                                    <br/>
                                    <br/>
                                    <% Zaposleni zap = new Zaposleni();%>
                                    <form class="needs-validation"  style="margin: 20px;" method="post"  action="dodaj_zaposlenog_jspcontroller.jsp" novalidate>
                                        <div class="form-row">
                                            <div class="col-md-4 mb-3">
                                                <label for="validationCustom01">Ime: </label>
                                                <input type="text" class="form-control" id="validationCustom01" placeholder="Ime" value="" name="ime" required>
                                                <div class="invalid-feedback">
                                                    Unesite ime.
                                                </div>
                                            </div>
                                            <div class="col-md-4 mb-3">
                                                <label for="validationCustom02">Prezime: </label>
                                                <input type="text" class="form-control" id="validationCustom02" placeholder="Prezime " value="" name="prezime" required>
                                                <div class="invalid-feedback">
                                                    Unesite prezime.
                                                </div>
                                            </div>
                                            <div class="col-md-4 mb-3">
                                                <label for="validationCustom03">Email: </label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                                                    </div>
                                                    <input type="email" class="form-control" id="validationCustom03" placeholder="Email" value="" name="email" required>
                                                    <div class="invalid-feedback">
                                                        Unesite ispravan email.
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="form-row">

                                            <div class="col-md-6 mb-3">
                                                <label for="validationCustom04">Adresa: </label>
                                                <input type="text" class="form-control" id="validationCustom04" placeholder="Adresa" value="" name="adresa" required>
                                                <div class="invalid-feedback">
                                                    Unesite adresu.
                                                </div>
                                            </div>
                                            <div class="col-md-6 mb-3">
                                                <label for="validationCustom05">Telefon: </label>
                                                <input type="text" class="form-control" id="validationCustom05" placeholder="Telefon" value="" name="telefon" required>
                                                <div class="invalid-feedback">
                                                    Unesite telefon.
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="col-md-4 mb-3">
                                                <label for="validationCustomUsername">Korisn. ime: </label>


                                                <input type="text" class="form-control" id="validationCustomUsername" placeholder="Korisničko ime" aria-describedby="inputGroupPrepend" value="" name="kime" required>
                                                <div class="invalid-feedback">
                                                    Unesite korisničko ime.
                                                </div>

                                            </div> 
                                            <div class="col-md-4 mb-3">
                                                <label for="validationCustomUsername">Lozinka: </label>
                                                <div class="input-group">

                                                    <input type="password" class="form-control" id="validationCustomUsername" placeholder="Lozinka" aria-describedby="inputGroupPrepend" value="" name="lozinka" required>
                                                    <div class="invalid-feedback">
                                                        Unesite lozinku.
                                                    </div>
                                                </div>
                                            </div> 
                                            <div class="col-md-4 mb-3">
                                                <br/>

                                                <div class="btn-group-lg btn_forma">
                                                    <label class="radio-inline btn_forma"><input type="radio" name="optradio" value="1" checked>  Menadžer      </label>
                                                </div> 
                                            </div>
                                            <div class="col-md-12"> <input type="submit" class="btn btn-primary" value="Dodaj Zaposlenog" /></div>
                                        </div>





                                    </form>
                                </div>






                                <script>
                                    // Example starter JavaScript for disabling form submissions if there are invalid fields
                                    (function () {
                                        'use strict';
                                        window.addEventListener('load', function () {
                                            // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                            var forms = document.getElementsByClassName('needs-validation');
                                            // Loop over them and prevent submission
                                            var validation = Array.prototype.filter.call(forms, function (form) {
                                                form.addEventListener('submit', function (event) {
                                                    if (form.checkValidity() === false) {
                                                        event.preventDefault();
                                                        event.stopPropagation();
                                                    }
                                                    form.classList.add('was-validated');
                                                }, false);
                                            });
                                        }, false);
                                    })();
                                </script>






                                <center style="width:1100px;"></center>




                            </center>
                        </div>


                    </div>
                </div>

            </article>   

        </div>
    </body>
</html>
