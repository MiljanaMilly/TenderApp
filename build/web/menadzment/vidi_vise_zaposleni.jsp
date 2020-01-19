<%-- 
    Document   : vidi_vise_zaposleni
    Created on : Jul 10, 2018, 3:06:27 PM
    Author     : Milly
--%>

<%@page import="com.tenderplus.util.LoginBean"%>
<%@page import="com.tenderplus.entities.Serviseri"%>
<%@page import="com.tenderplus.controllers.ServiseriController"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Serviseri | TenderPlus</title>
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
                                        <li class="breadcrumb-item"><a href="menadzment_page_zaposleni.jsp">Menadžment</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Serviseri</li>
                                    </ol>
                                </nav>
                                <br/>
                                <br/>

                                <div class="card">
                                    <div class="card-header">
                                        Zaposleni
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Pregled servisera</h5>
                                        
                                    </div>

                                </div><br/>
                                <%
                                    String id = request.getParameter("id");
                                    ServiseriController sc = new ServiseriController();
                                    Serviseri s = sc.findServiseriByZID(Integer.valueOf(id));

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
                                            <th scope="col">Br.licence</th>
                                            <th scope="col">Važi Do </th>
                                            <th scope="col">Opcije </th>
                                        </tr>
                                    </thead> 

                                    <tr>

                                        <td> <%= s.getZaposleniId().getIme()%> </td> 
                                        <td> <%= s.getZaposleniId().getPrezime()%> </td> 
                                        <td> <%= s.getZaposleniId().getEmail()%> </td> 
                                        <td> <%= s.getZaposleniId().getAdresa()%> </td> 
                                        <td> <%= s.getZaposleniId().getTelefon()%> </td> 
                                        <td> <%= s.getZaposleniId().getLoginZaposleniId().getUsername()%> </td> 
                                        <td> <%= s.getZaposleniId().getLoginZaposleniId().getRoleId().getNaziv()%> </td> 
                                        <td><%= s.getBrojLicence()%></td>
                                        <td><%= s.getVaziDo()%></td>
                                        <td>  


                                            <a href="izmeni_servisera.jsp?id=<%= s.getServiseriId()%>">Izmeni</a>

                                        </td>
                                    </tr>


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
