<%@page import="com.tenderplus.entities.Role"%>
<%@page import="com.tenderplus.entities.Zaposleni"%>
<%@page import="com.tenderplus.controllers.ZaposleniController"%>
<%@page import="com.tenderplus.entities.LoginZaposleni"%>
<%@page import="com.tenderplus.controllers.LoginZaposleniController"%>
<%-- email regex("\\w+@\\w+\\.\\w+"); --%>
<%
    
    LoginZaposleniController lgzpc = new LoginZaposleniController();
    LoginZaposleni lgz = new LoginZaposleni();
    
    ZaposleniController zpc = new ZaposleniController();
    Zaposleni zap = new Zaposleni();
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
    
    response.sendRedirect(zpc.dodajZaposlenog(zap));
  

%>
