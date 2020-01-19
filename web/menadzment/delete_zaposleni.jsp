<%-- 
    Document   : delete_zaposleni
    Created on : Jul 5, 2018, 4:15:58 PM
    Author     : Milly
--%>

<%@page import="com.tenderplus.entities.Serviseri"%>
<%@page import="java.util.List"%>
<%@page import="com.tenderplus.controllers.ServiseriController"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page import="com.tenderplus.entities.LoginZaposleni"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <% String id = request.getParameter("id");
            ZaposleniController lz = new ZaposleniController();
            Zaposleni z = lz.findZaposleni(Integer.valueOf(id));
            lz.obrisiZaposlenog(Integer.valueOf(id));
            LoginZaposleniController lgzpc = new LoginZaposleniController();
            LoginZaposleni lgz = new LoginZaposleni(z.getLoginZaposleniId().getLoginZaposleniId(), z.getLoginZaposleniId().getUsername(), z.getLoginZaposleniId().getPassword());
            lgzpc.obrisiLoginPodatke(lgz);
            
            ServiseriController sc = new ServiseriController();
            List<Serviseri> lists = sc.findAllServiseri();
            for(Serviseri s:lists){
                if(s.getZaposleniId().equals(z)){
                   sc.obrisiServisera(s);
                }
            }
        %>
        <% response.setHeader("Refresh", "5");
            response.setStatus(response.SC_MOVED_PERMANENTLY);
            response.sendRedirect("menadzment_page_zaposleni.jsp");
        %>


