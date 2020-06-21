<%-- 
    Document   : Questoes
    Created on : 17/06/2020, 21:58:23
    Author     : Alana
--%>

<%@page import="db.Dbquiz"%>
<%@page import="db.Quiz"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <title>Quiz</title>
    </head>
    <body>
        
               <h1>Quiz</h1>
               
               
   <%
    if(request.getParameter("voltar") != null){
        response.sendRedirect("index.jsp");
    }if(request.getParameter("quizz") != null){
        String score = request.getParameter("score");

   //FAZER O BOTAO ENVIAR JOGAR O SCORE PRO HISTORICO E SEEE FOR O CASO PRO RANKING     
      
    }

%>            
               
               
               
               
           <% if (request.getParameter("quizz") != null){
            int score = 0;
            for (Quiz q: Dbquiz.getQuiz()){
                String userAnswer = request.getParameter(q.getQuiz());
                if(userAnswer.equals(q.getAnswer())){
                    score++;
                }
            } %>
            <div class="form-signin btn-outline-light">
            <h1 style="color:gold">
                Nota: <u><%= 100*((double)(score)/10.0) %></u>
            </h1>
            <% } %>
            </div> 
        <form>
            <%for(Quiz q: Dbquiz.getQuiz()){%>
            <h4><%=q.getQuiz()%></h4>
            <%for(int i=0; i<q.getAlternatives().length; i++){%>
            <input type="radio"
                name="<%=q.getQuiz()%>" 
                value="<%=q.getAlternatives()[i]%>"
                /><strong><%=q.getAlternatives()[i]%></strong>
            <%}%>
            <hr/>
            <%}%>
            <input type="submit" name="quizz" value="Enviar"/>
            <button type="submit" name="voltar" value="voltar"/>Voltar</button>

            
        </form>


    </body>
</html>
