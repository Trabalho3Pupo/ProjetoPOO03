<%-- 
    Document   : index
    Created on : 16/06/2020, 15:24:13
    Author     : Alana
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="db.Player"%>
<%@page import="db.Dbquiz"%>
<%@page import="db.Quiz"%>
<%@page import="web.DbListener"%>
<%@page import="db.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Início - Quiz</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        
        <body class="text-center">

           
                <strong>Top 10</strong>
                <table border="1">
                    <thead>
                      <tr>
                        <th>Ranking</th>
                        <th>Name</th>
                        <th>Score</th>
                      </tr>
                    </thead>
                    
                           <%int i =1; %>      
                    <tbody>
    //FAZER ORDENAÇAO                
                       <% for (Player p : Dbquiz.getPlayers()) { %>
                            <% if (i <= 10) {%>
                            <tr>    
                                <td><%= i++%>º</td>
                                <td><%= p.getName()%></td>
                                <td><%= p.getScore()%></td>
                            </tr>
                            <% } %>  
                            <%}%>
                    </tbody>
                  </table>
            
   

 
 <% 
                if (session.getAttribute("user.login") != null) {
                    %>
                      <strong>Historico</strong>
            <table border="1">
                <thead>
                    
                  <tr>
                    <th>Name</th>
                    <th>Score</th>
                    <th>Date</th>
                  </tr>
                </thead>          
                <tbody>
                    <% DateFormat df = new SimpleDateFormat("dd/MM/yyyy");%>
                  <% for (Player p :Dbquiz.getPlayers()) {%>
                    <tr>
                        <td><%= p.getName()%></td>
                        <td><%= p.getScore()%></td>
                        <td><%= df.format(p.getData())%></td>
                    </tr>
                    <%}%>
                  </tr>
                </tbody>
              </table>
                    <%
                }
                else {
                    %>
                            <strong>Top 10</strong>
                <table border="1">
                    <thead>
                      <tr>
                        <th>Ranking</th>
                        <th>Name</th>
                        <th>Score</th>
                      </tr>
                    </thead>
                    
                              
                    <tbody>
    //FAZER ORDENAÇAO                
                       <% for (Player p : Dbquiz.getPlayers()) { %>
                            <% if (i <= 10) {%>
                            <tr>    
                                <td><%= i++%>º</td>
                                <td><%= p.getName()%></td>
                                <td><%= p.getScore()%></td>
                            </tr>
                            <% } %>  
                            <%}%>
                    </tbody>
                  </table>
                    <%
                }

            %>
 
 
 
            
            
           
        
    </body>
</html>
