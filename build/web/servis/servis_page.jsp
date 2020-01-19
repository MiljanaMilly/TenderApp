<%-- 
    Document   : Servis
    Created on : Jul 2, 2018, 2:26:08 PM
    Author     : Milly
--%>
<%@page import="com.tenderplus.util.LoginBean"%>
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
        <title>Servis</title>
        <link rel="stylesheet" href="resources/styles.css" />
    </head>
    <body >
        <div class="container">
            <header>
                <%@ include file="../header1.jsp" %>
            </header>
            <article>
                 <% LoginBean lgb = (LoginBean)session.getAttribute("loginBean"); %>

                <div class="row">
                    <div class="jumbotron">
                        <div class="row"> <div class=" col-md-10"> 
                                <h4 class="text-left">Prijavljeni ste kao  <%= lgb.getUsername() %>, </h4> </div>
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
                                                <a class="nav-link" href="../oprema/oprema_page.jsp">Oprema</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link active" href="#">Servis</a>
                                            </li>
                                        </ul>
                                        <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="../index.jsp">Pocetna</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Servis</li>
                                    </ol>
                                </nav>


                                    </c:when>
                                    <c:otherwise >

                                        <ul class="nav nav-pills nav-fill">

                                            <li class="nav-item">
                                                <a class="nav-link" href="../oprema/oprema_page.jsp">Oprema</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link active" href="#">Servis</a>
                                            </li>
                                        </ul>
                                        <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="../index.jsp">Pocetna</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Servis</li>
                                    </ol>
                                </nav>

                                    </c:otherwise>
                                </c:choose>




                                <div class="row"><% ZaposleniDAO zp = new ZaposleniDAOImpl();
                                    List<Zaposleni> lista = zp.readAll(Zaposleni.class);
                                    for (Zaposleni z : lista) {%>

                                    <h3/> ID: <%= z.getZaposleniId()%> </h3>
                                    <h3> Ime: <%= z.getIme()%> </h3>
                                    <h3> Prezime : <%= z.getPrezime()%></h3>
                                    <br/>



                                    <%}%></div>
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
