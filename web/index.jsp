<%-- 
    Document   : index
    Created on : 01/06/2020, 13:49:36
    Author     : rlarg
--%>

<%@page import="db.Question"%>
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
        <h2>Ranking melhores 10 notas</h2>
        
            <table border='1' width="700" style="text-align: center">
                <tr>
                    <th>Índice</th>
                    <th>Nome </th>
                    <th>Media</th>
                    
                </tr>
                
        
        </table>
        <h2>Ultimos 10 Quizes</h2>
        
        
            <table border='1' width="700" style="text-align: center">
                <tr>
                    <th>Índice</th>
                    <th>Nome </th>
                    <th>Media</th>
                    
                </tr>
                
                   
                
        
        </table>
    </body>
</html>
