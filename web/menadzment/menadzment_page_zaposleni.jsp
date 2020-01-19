<%-- 
    Document   : menadzment_page_zaposleni
    Created on : Jul 3, 2018, 7:05:51 PM
    Author     : Milly
--%>

<%@page import="com.tenderplus.util.LoginBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="com.tenderplus.dao.ZaposleniDAOImpl"%>
<%@page import="com.tenderplus.dao.ZaposleniDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menadžment | Zaposleni</title>
        <link rel="stylesheet" href="resources/styles.css" />
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
                                        <a class="nav-link active" href="#">Menadžment</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="../tenderi/tenderi_page.jsp">Tenderi</a>
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
                                        <li class="breadcrumb-item"><a href="../index.jsp">Početna</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Menadžment</li>
                                    </ol>
                                </nav>
                                <br/>
                                <br/>

                                <div class="card">
                                    <div class="card-header">
                                        Zaposleni
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Pregled svih radnika</h5>
                                        <p class="card-text">Ovde možete dodavati, brisati i menjati podatke o zaposlenima i serviserima.</p>
                                        <a href="dodaj_zaposlenog.jsp" class="btn btn-primary">Dodaj novog zaposlenog</a> 
                                        <a href="dodaj_servisera.jsp" class="btn btn-primary">Dodaj novog servisera</a>
                                    </div>

                                </div><br/>
                                <%
                                    ZaposleniController zc = new ZaposleniController();
                                    List lista = zc.findAllZaposleni();
                                    Iterator li = lista.iterator();
                                %>

                                <table class="table">
                                    <thead class="thead-dark">
                                        <tr>

                                            <th scope="col">Ime</th>
                                            <th scope="col">Prezime</th>
                                            <th scope="col">E-mail</th>
                                            <th scope="col">Adresa </th>
                                            <th scope="col">Telefon </th>
                                            <th scope="col">Korisn.ime</th>
                                            <th scope="col">Rola </th>
                                            <th scope="col">Opcije </th>
                                        </tr>
                                    </thead> 
                                    <% while (li.hasNext()) {
                                            Zaposleni z = (Zaposleni) li.next();
                                    %>
                                    <tr>

                                        <td> <%= z.getIme()%> </td> 
                                        <td> <%= z.getPrezime()%> </td> 
                                        <td> <%= z.getEmail()%> </td> 
                                        <td> <%= z.getAdresa()%> </td> 
                                        <td> <%= z.getTelefon()%> </td> 
                                        <td> <%= z.getLoginZaposleniId().getUsername()%> </td> 
                                        <td> <%= z.getLoginZaposleniId().getRoleId().getNaziv()%> </td> 
                                        <td>  <a href="delete_zaposleni.jsp?id=<%= z.getZaposleniId()%>">Obriši</a>

                                            <br/> 
                                            <% if (z.getLoginZaposleniId().getRoleId().getNaziv().equalsIgnoreCase("Serviser")) {%> 
                                            <a href="vidi_vise_zaposleni.jsp?id=<%= z.getZaposleniId()%>">Vidi više </a> 
                                            <% } else {%>
                                            <a href="izmeni_zaposlenog.jsp?id=<%= z.getZaposleniId()%>">Izmeni</a>

                                            <% }%>
                                        </td>
                                    </tr>
                                    <% }%>

                                </table>








                                <center style="width:1100px;"></center>



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
