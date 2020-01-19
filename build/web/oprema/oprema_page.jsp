<%-- 
    Document   : oprema_page
    Created on : Jul 2, 2018, 2:25:58 PM
    Author     : Milly
--%>

<%@page import="com.tenderplus.entities.Delovi"%>
<%@page import="com.tenderplus.controllers.DeloviController"%>
<%@page import="com.tenderplus.entities.PotrosniMaterijal"%>
<%@page import="com.tenderplus.controllers.PotrosniMController"%>
<%@page import="com.tenderplus.controllers.PotrosniMController"%>
<%@page import="com.tenderplus.entities.Oprema"%>
<%@page import="com.tenderplus.controllers.OpremaController"%>
<%@page import="com.tenderplus.util.LoginBean"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="java.util.List"%>
<%@page import="com.tenderplus.dao.ZaposleniDAOImpl"%>
<%@page import="com.tenderplus.dao.ZaposleniDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                <% LoginBean logbean = (LoginBean) session.getAttribute("loginBean");%>
                                <c:choose>

                                    <c:when test="<%= logbean.getRola().equalsIgnoreCase("Menadzer")%>"  >

                                        <ul class="nav nav-pills nav-fill">
                                            <li class="nav-item">
                                                <a class="nav-link " href="../menadzment/menadzment_page_zaposleni.jsp">Menadzment</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="../tenderi/tenderi_page.jsp">Tenderi</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link active" href="#">Oprema</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link " href="../servis/servis_page.jsp">Servis</a>
                                            </li>
                                        </ul>
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="../index.jsp">Pocetna</a></li>
                                                <li class="breadcrumb-item active" aria-current="page">Oprema</li>
                                            </ol>
                                        </nav>
                                    </c:when>
                                    <c:otherwise >

                                        <ul class="nav nav-pills nav-fill">

                                            <li class="nav-item">
                                                <a class="nav-link active" href="#">Oprema</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link " href="../servis/servis_page.jsp">Servis</a>
                                            </li>
                                        </ul>
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="../index.jsp">Pocetna</a></li>
                                                <li class="breadcrumb-item active" aria-current="page">Oprema</li>
                                            </ol>
                                        </nav>

                                    </c:otherwise>
                                </c:choose>
                                <br/>
                                <br/>
                                <div class="card">
                                    <div class="card-header">
                                        Oprema,Postrosni materijal i Delovi
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Pregled opreme</h5>
                                        <p class="card-text">Ovde mozete dodavati, brisati i menjati podatke o opremi.</p>
                                        <a href="dodaj_zaposlenog.jsp" class="btn btn-primary">Dodaj novu opremu</a>
                                    </div>

                                </div>
                                <br/>

                                <div class="row">
                                    <%
                                        OpremaController oc = new OpremaController();
                                        List lista = oc.pregledOpreme();
                                        Iterator li = lista.iterator();
                                    %>

                                    <table class="table">
                                        <thead class="thead-dark">
                                            <tr>

                                                <th scope="col">Naziv</th>
                                                <th scope="col">Resenje Alims</th>
                                                <th scope="col">Serijski broj</th>
                                                <th scope="col">Lager </th>
                                                <th scope="col">Tip Opreme </th>
                                                <th scope="col">Proizvodjac</th>
                                                <th scope="col">Opcije</th>

                                            </tr>
                                        </thead> 
                                        <% while (li.hasNext()) {
                                                Oprema o = (Oprema) li.next();
                                        %>
                                        <tr>

                                            <td> <%= o.getNazivOpreme()%> </td> 
                                            <td> <%= o.getAlimsresenjebroj()%> </td> 
                                            <td> <%= o.getSerijskiBroj()%> </td> 
                                            <td> <%= o.getLager()%> </td> 
                                            <td> <%= o.getTipOpreme().toString()%> </td> 
                                            <td> <%= o.getProizvodjacId().getNazivProizvodjaca()%> </td> 
                                            <td>  <a href="%>">Obriši</a>
                                                <br/> 
                                                <a href="">Izmeni</a>


                                            </td>
                                        </tr>

                                        <% }%>
                                    </table>
                                </div>
                                <br/>
                                <br/>

                                <div class="card"><div class="card-body">
                                        <h5 class="card-title">Pregled potrosnog materijala</h5>
                                        <p class="card-text">Ovde mozete dodavati, brisati i menjati podatke o potrosnom materijalu.</p>
                                        <a href="dodaj_zaposlenog.jsp" class="btn btn-primary">Dodaj novi potrosni materijal</a>
                                    </div></div>
                                <div class="row">
                                    <%
                                        PotrosniMController mc = new PotrosniMController();
                                        List listaPM = mc.pregledPotrosnogMaterijala();
                                        Iterator liA = listaPM.iterator();
                                    %>

                                    <table class="table">
                                        <thead class="thead-dark">
                                            <tr>

                                                <th scope="col">Naziv</th>
                                                <th scope="col">Serijski broj</th>
                                                <th scope="col">Cena po komadu</th>
                                                <th scope="col">Proizvodjac </th>
                                                <th scope="col">Opcije</th>


                                            </tr>
                                        </thead> 
                                        <% while (liA.hasNext()) {
                                                PotrosniMaterijal pm = (PotrosniMaterijal) liA.next();
                                        %>
                                        <tr>

                                            <td> <%= pm.getNazivMaterijala()%> </td> 
                                            <td> <%= pm.getSerijskiBroj()%> </td> 
                                            <td> <%= pm.getCenaPoKomadu()%> </td> 
                                            <td> <%= pm.getProizvodjacId().getNazivProizvodjaca()%> </td> 

                                            <td>  <a href="%>">Obriši</a>
                                                <br/> 
                                                <a href="">Izmeni</a>


                                            </td>
                                        </tr>

                                        <% }%>
                                    </table>
                                </div>

                                <br/>
                                <br/>

                                <div class="card"><div class="card-body">
                                        <h5 class="card-title">Pregled delova</h5>
                                        <p class="card-text">Ovde mozete dodavati, brisati i menjati podatke o delovima.</p>
                                        <a href="dodaj_zaposlenog.jsp" class="btn btn-primary">Dodaj nove delove</a>
                                    </div> </div>
                                <div class="row">
                                    <%
                                        DeloviController dc = new DeloviController();
                                        List listaD = dc.pregledDelova();
                                        Iterator liD = listaD.iterator();
                                    %>

                                    <table class="table">
                                        <thead class="thead-dark">
                                            <tr>

                                                <th scope="col">Naziv</th>
                                                <th scope="col">Serijski broj</th>
                                                <th scope="col">Cena po komadu</th>
                                                <th scope="col">Proizvodjac </th>
                                                <th scope="col">Opcije</th>


                                            </tr>
                                        </thead> 
                                        <% while (liD.hasNext()) {
                                                Delovi d = (Delovi) liD.next();
                                        %>
                                        <tr>

                                            <td> <%= d.getNaziv()%> </td> 
                                            <td> <%= d.getSerijskiBroj()%> </td> 
                                            <td> <%= d.getCenaPoKomadu()%> </td> 
                                            <td> <%= d.getProizvodjacId().getNazivProizvodjaca()%> </td> 

                                            <td>  <a href="%>">Obriši</a>
                                                <br/> 
                                                <a href="">Izmeni</a>


                                            </td>
                                        </tr>

                                        <% }%>
                                    </table>
                                </div>


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
