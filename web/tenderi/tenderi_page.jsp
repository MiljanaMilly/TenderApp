<%-- 
    Document   : tenderi_page
    Created on : Jul 2, 2018, 2:25:46 PM
    Author     : Milly
--%>
<%@page import="com.tenderplus.entities.Tenderi"%>
<%@page import="com.tenderplus.controllers.TenderiController"%>
<%@page import="com.tenderplus.util.LoginBean"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="java.util.List"%>
<%@page import="com.tenderplus.dao.ZaposleniDAOImpl"%>
<%@page import="com.tenderplus.dao.ZaposleniDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tenderi</title>
        <link rel="stylesheet" href="resources/styles.css" />
    </head>
    <body >
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
                                        <a class="nav-link " href="../menadzment/menadzment_page_zaposleni.jsp">Menadzment</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#">Tenderi</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="../oprema/oprema_page.jsp">Oprema</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link " href="../servis/servis_page.jsp">Servis</a>
                                    </li>
                                </ul>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="../index.jsp">Pocetna</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Tenderi</li>
                                    </ol>
                                </nav>




                                <br/>
                                <br/>
                                <div class="card">
                                    <div class="card-header">
                                        Tenderi
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Pregled tendera</h5>
                                        <p class="card-text">Ovde mozete dodavati, brisati i menjati podatke o tenderima.</p>
                                        <a href="dodaj_zaposlenog.jsp" class="btn btn-primary">Dodaj nov tender</a>
                                    </div>

                                </div>
                                <br/>

                                <div class="row">
                                    <%
                                        TenderiController tc = new TenderiController();
                                        List lista = tc.pregledTendera();
                                        Iterator li = lista.iterator();
                                    %>

                                    <table class="table">
                                        <thead class="thead-dark">
                                            <tr>

                                                <th scope="col">Kupac</th>
                                                <th scope="col">Odgovorno lice kupca</th>
                                                <th scope="col">Datum Podn. Dokument.</th>
                                                <th scope="col">Datum resenja</th>
                                                <th scope="col">Uspesan </th>
                                                <th scope="col">Odgovorno lice </th>

                                                <th scope="col">Opcije</th>

                                            </tr>
                                        </thead> 
                                        <% while (li.hasNext()) {
                                                Tenderi t = (Tenderi) li.next();
                                        %>
                                        <tr>

                                            <td> <%= t.getKupciId().getNazivKupca()%> </td> 
                                            <td> <%= t.getKupciId().getOdgovornoLice()%> </td> 
                                            <td> <%= t.getDatumPodnosenjaDokumenata()%> </td> 
                                            <td> <%= t.getDatumDonosenjaResenja()%> </td> 
                                            <td> <% if (t.getTenderProsao().toString().equalsIgnoreCase("true")) {%>
                                                <div class="form-check">
                                                    <input type="checkbox" class="form-check-input" id="customCheck1" checked>

                                                </div> <% } else {%>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" id="disabledFieldsetCheck" disabled>

                                                </div>

                                                <% }%>

                                            </td> 
                                            <td> <%= t.getOdgovornoLiceId().getIme() + " " + t.getOdgovornoLiceId().getPrezime()%> </td> 
                                            <td>  <a href="%>">Obriši</a>
                                                <br/> 
                                                <a href="">Izmeni</a>


                                            </td>
                                        </tr>

                                        <% }%>
                                    </table>
                                </div>
                            </center>
                        </div>


                    </div>
                </div>
                <footer>
                    <%@ include file="../footer1.jsp" %>
                </footer> 
            </article>   

        </div>
    </body>

</html>
