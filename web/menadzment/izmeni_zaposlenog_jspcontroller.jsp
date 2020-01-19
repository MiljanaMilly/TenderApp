<%-- 
    Document   : izmeni_zaposlenog_jspcontroller
    Created on : Jul 9, 2018, 1:20:32 PM
    Author     : Milly
--%>

<%@page import="com.tenderplus.entities.Role"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page import="com.tenderplus.entities.LoginZaposleni"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            
            String id = request.getParameter("id");
            
                
            LoginZaposleniController lgzpc = new LoginZaposleniController();
            LoginZaposleni lgz = new LoginZaposleni();

            ZaposleniController zpc = new ZaposleniController();
            Zaposleni zap = new Zaposleni();
            lgz.setLoginZaposleniId(Integer.parseInt(id));
            lgz.setUsername(request.getParameter("kime"));
            lgz.setPassword(request.getParameter("lozinka"));
            Role r = new Role();
            r.setRoleId(Integer.valueOf(request.getParameter("optradio")));
            lgz.setRoleId(r);
            LoginZaposleni lg = lgzpc.updateLoginPodatke(lgz);
            
           zap.setZaposleniId(Integer.parseInt(id));
            zap.setIme(request.getParameter("ime"));
            zap.setPrezime(request.getParameter("prezime"));
            zap.setEmail(request.getParameter("email"));
            zap.setAdresa(request.getParameter("adresa"));
            zap.setTelefon(request.getParameter("telefon"));
            zap.setLoginZaposleniId(lgz);

             zpc.updateZaposleni(zap);

            response.sendRedirect("menadzment_page_zaposleni.jsp");


     %>
        <%--
        ${loginZaposleniController.loginKorisnik.setLoginZaposleniId(Integer.valueOf(request.getParameter("id")))}
        ${loginZaposleniController.loginKorisnik.setUsername(request.getParameter("kime"))}
        ${loginZaposleniController.loginKorisnik.setPassword(request.getParameter("lozinka"))}
        ${loginZaposleniController.loginKorisnik.setRoleId(role.setRoleId(Integer.valueOf(request.getParameter("optradio"))))}
        ${loginZaposleniController.updateLoginPodatke(loginKorisnik)}
        
        ${zaposleniController.zaposleni.setIme(request.getParameter("ime"))}
        ${zaposleniController.zaposleni.setPrezime(request.getParameter("prezime"))}
        ${zaposleniController.zaposleni.setEmail(request.getParameter("email"))}
        ${zaposleniController.zaposleni.setAdresa(request.getParameter("adresa"))}
        ${zaposleniController.zaposleni.setTelefon(request.getParameter("telefon"))}
        ${zaposleniController.zaposleni.setLoginZaposleniId(loginZaposleni)}
        
        ${ zaposleniController.updateZaposleni(zaposleni)} --%>
        
        
  
