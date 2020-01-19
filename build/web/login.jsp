<%-- 
    Document   : login
    Created on : 30-Jun-2018, 21:11:36
    Author     : Milly2
--%>

<%@page import="com.tenderplus.entities.LoginZaposleni"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"  />
        <title>TenderPLUS | Prijava </title>
        <link rel="stylesheet" href="resources/styles.css" />
    </head>
    <body class="body_login">
        <div class="container">
            <header>
                <%@ include file="header.jsp" %>
            </header> </div>
        <article class="container_article"> 
            <div class="col-sm-1"></div>
            <h3 class="page-header text-left ">Forma za prijavu</h3> 



            <form name="loginForm" class="form-horizontal" action="loginValid.jsp" method="post"> 
                <div class="form-group">
                    <label class="col-md-2 col-sm-2 control-label">Korisničko ime :</label>
                    <div class="col-md-4 col-sm-4">
                        <input type="text" class="form-control" name="username" placeholder="Unesite Korisničko ime"   required/> 
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 col-sm-2 control-label">Lozinka :</label>
                    <div class="col-md-4 col-sm-4">
                        <input type="password" class="form-control" name="password" placeholder="Unesite lozinku"  required/> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-2 col-sm-4 col-sm-offset 2">
                        <input type="submit" name="btnLogin" value="Prijavi se" class="btn btn-primary"/>
                    </div>
                </div>

            </form>
             





        </article>
        <footer>
            <%@ include file="footer.jsp" %>
        </footer>
    </div>

</body>
</html>
