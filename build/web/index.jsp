<%-- 
    Document   : index
    Created on : 30-Jun-2018, 14:53:12
    Author     : Milly2
--%>

<%@page import="com.tenderplus.util.LoginBean"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="com.tenderplus.dao.ZaposleniDAOImpl"%>
<%@page import="com.tenderplus.dao.ZaposleniDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Početna strana</title>

    </head>
    <body >
        <div class="container">
            <header>
                <%@ include file="header1.jsp" %>
            </header>
            <article>

                <% LoginBean lgb = (LoginBean) session.getAttribute("loginBean");%>




                <div class="row">
                    <div class="jumbotron">
                        <div class="row"> <div class=" col-md-10"> 
                                <h4 class="text-left">Dobrodosli  <%= lgb.getUsername()%>, </h4> </div>
                            <div class=" col-md-2"><form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
                                    <input type="submit" value="Log out" class="btn btn-outline-primary"  />
                                </form> </div>
                        </div>
                        <br/>

                        <div class="row">
                            <center>

                                <% LoginZaposleniController lgz = new LoginZaposleniController();%>
                                <c:choose>

                                    <c:when test="<%= lgz.proveraRole(lgb.getUsername(), lgb.getPassword())%>"  >
                                        <% lgb.setRola("Menadzer"); %>
                                        <ul class="nav nav-pills nav-fill">
                                            <li class="nav-item">
                                                <a class="nav-link " href="menadzment/menadzment_page_zaposleni.jsp">Menadzment</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="tenderi/tenderi_page.jsp">Tenderi</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="oprema/oprema_page.jsp">Oprema</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link " href="servis/servis_page.jsp">Servis</a>
                                            </li>
                                        </ul>
                                        


                                    </c:when>
                                    <c:otherwise >
                                        <% lgb.setRola("Serviser"); %>
                                        <ul class="nav nav-pills nav-fill">

                                            <li class="nav-item">
                                                <a class="nav-link" href="oprema/oprema_page.jsp">Oprema</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link " href="servis/servis_page.jsp">Servis</a>
                                            </li>
                                        </ul>
                                        

                                    </c:otherwise>
                                </c:choose>



                                <br/>

                                <center class="text-center"><h3> Danasnji datum i vreme: </h3>  
                                    <%

                                        Date dNow = new Date();
                                        SimpleDateFormat ft = new SimpleDateFormat(" dd.MM.yyyy 'u' HH:mm:ss");
                                        out.print(" <h3 align=\"center\">" + ft.format(dNow) + "</h3>");
                                    %>  </center>
                                <div class="row "> <img class="img-fluid" src="images/Emergency4.jpg"></div> 
                            </center>
                        </div>


                    </div>
                </div>

            </article>   
            <footer>
                <%@ include file="footer1.jsp" %>
            </footer>     

        </div>
    </body>
</html>
