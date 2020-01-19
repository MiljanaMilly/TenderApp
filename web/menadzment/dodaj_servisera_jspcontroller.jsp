<%-- 
    Document   : dodaj_servisera_jspcontroller
    Created on : Jul 15, 2018, 12:25:17 PM
    Author     : Milly
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.tenderplus.entities.Serviseri"%>
<%@page import="com.tenderplus.controllers.ServiseriController"%>
<%@page import="com.tenderplus.entities.Role"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page import="com.tenderplus.entities.LoginZaposleni"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    LoginZaposleniController lgzpc = new LoginZaposleniController();
    LoginZaposleni lgz = new LoginZaposleni();

    ZaposleniController zpc = new ZaposleniController();
    Zaposleni zap = new Zaposleni();

    ServiseriController sc = new ServiseriController();
    Serviseri s = new Serviseri();

    lgz.setUsername(request.getParameter("kime"));
    lgz.setPassword(request.getParameter("lozinka"));
    Role r = new Role();
    r.setRoleId(Integer.valueOf(request.getParameter("optradio")));
    lgz.setRoleId(r);
    LoginZaposleni lg = lgzpc.sacuvajLoginPodatke(lgz);

    zap.setIme(request.getParameter("ime"));
    zap.setPrezime(request.getParameter("prezime"));
    zap.setEmail(request.getParameter("email"));
    zap.setAdresa(request.getParameter("adresa"));
    zap.setTelefon(request.getParameter("telefon"));
    zap.setLoginZaposleniId(lg);
    zpc.dodajZaposlenog(zap);

    s.setBrojLicence(request.getParameter("licenca"));
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date date = format.parse(request.getParameter("vazenje"));
    System.out.println(date.toString());
    s.setVaziDo(date);
    s.setZaposleniId(zap);
    
    response.sendRedirect(sc.sacuvajServisera(s));


%>
