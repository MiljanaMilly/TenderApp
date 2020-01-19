<%-- 
    Document   : loginerror
    Created on : 01-Jul-2018, 11:47:14
    Author     : Milly2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <header>
                <%@ include file="/header1.jsp" %>
            </header>
            <article>


                <div class="row">
                    <div class="jumbotron">
                        <br/>
                        <br/>

                        <div class="row">
                            <center>
                                
                                <br/>
                                <br/>
                               
                                <div class="card">
                                    <div class="card-header">
                                        Greska! 
                                    </div>
                                    
                                    <div class="card-body">
                                        <img class="col-sm-2 img-fluid" src="images/error.png"/>
                                        Vratite se na stranu za prijavu <br/>

                                        <a href="login.jsp"> Prijava </a>
                                    </div>
                                    
                                </div><br/>
                                
                                
                                <center style="width:1100px;"></center>


                              
                            </center>
                        </div>


                    </div>
                </div>
                <footer>
                    <%@ include file="footer1.jsp" %>
                </footer> 
            </article>   

        </div>
    </body>
</html>
