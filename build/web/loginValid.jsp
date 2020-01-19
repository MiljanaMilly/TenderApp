<%-- 
    Document   : loginValid
    Created on : Jul 12, 2018, 9:48:27 AM
    Author     : Milly
--%>

<%@page import="com.tenderplus.util.LoginBean"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    LoginBean lgb = new LoginBean();
    lgb.setUsername(request.getParameter("username"));
    lgb.setPassword(request.getParameter("password"));
    session.setAttribute("loginBean", lgb);

    System.out.println(request.getParameter("username"));
    LoginZaposleniController lgzco = new LoginZaposleniController();
    response.sendRedirect(lgzco.proveraLogin(request.getParameter("username"), request.getParameter("password")));

%>


