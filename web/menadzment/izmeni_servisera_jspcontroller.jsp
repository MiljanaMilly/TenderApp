<%-- 
    Document   : izmeni_servisera_jspcontroller
    Created on : Jul 14, 2018, 12:31:22 PM
    Author     : Milly
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="com.tenderplus.controllers.ServiseriController"%>
<%@page import="com.tenderplus.entities.Serviseri"%>
<%@page import="com.tenderplus.entities.Role"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page import="com.tenderplus.entities.LoginZaposleni"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            
            String id = request.getParameter("id");
           
            
            ServiseriController sc = new ServiseriController();
           
            Serviseri s = sc.findServiseriBySID(Integer.valueOf(id));
            
            LoginZaposleniController lgzpc = new LoginZaposleniController();
            LoginZaposleni lgz = new LoginZaposleni();

            ZaposleniController zpc = new ZaposleniController();
            Zaposleni zap = new Zaposleni();
            
            lgz.setLoginZaposleniId(s.getZaposleniId().getLoginZaposleniId().getLoginZaposleniId());
            lgz.setUsername(request.getParameter("kime"));
            lgz.setPassword(request.getParameter("lozinka"));
            Role r = new Role();
            r.setRoleId(Integer.valueOf(request.getParameter("optradio")));
            lgz.setRoleId(r);
            LoginZaposleni lg = lgzpc.updateLoginPodatke(lgz);
            
           zap.setZaposleniId(s.getZaposleniId().getZaposleniId());
            zap.setIme(request.getParameter("ime"));
            zap.setPrezime(request.getParameter("prezime"));
            zap.setEmail(request.getParameter("email"));
            zap.setAdresa(request.getParameter("adresa"));
            zap.setTelefon(request.getParameter("telefon"));
            zap.setLoginZaposleniId(lg);
            Zaposleni z = zpc.updateZaposleni(zap);
            
            s.setServiseriId(Integer.valueOf(id));
            s.setBrojLicence(request.getParameter("licenca"));
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(request.getParameter("vazenje"));
            System.out.println(date.toString());
            s.setVaziDo(date);
            s.setZaposleniId(z);
            sc.updateServiser(s);
            response.sendRedirect("menadzment_page_zaposleni.jsp");


     %>
