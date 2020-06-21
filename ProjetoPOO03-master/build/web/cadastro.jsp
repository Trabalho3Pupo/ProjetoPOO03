
<%@page import="web.DbListener"%>
<%@page import="db.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Exception requestException = null;
    if(request.getParameter("insert")!=null){
        try{
            String name = request.getParameter("name");
            String login = request.getParameter("login");
            String role = request.getParameter("role");
            String password = request.getParameter("password");
            User.addUser(name, login, role, password);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception ex){
            requestException = ex;
        }
    }
    if(request.getParameter("delete")!=null){
        try{
            String login = request.getParameter("login");
            User.removeUser(login);
            
            response.sendRedirect(request.getRequestURI());
        }catch(Exception ex){
            requestException = ex;
        }
    }
%>

</script>


</td>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
        
        <h2>Cadastrar Usuario :</h2>
<fieldset>
                    <legend>Novo usuário</legend>
                    <%if(requestException!=null){%>
                    <div style="color:red"><%=requestException.getMessage()%></div>
                    <%}%>
                    <form method="post">
                        Nome: <input type="text" name="name">
                        <br>
                        Login: <input type="text" name="login">
                        <br>
                        Role: <select name="role">
                            <option value="USER">USER</option>
                        
                        </select>
                        <br>
                        Password: <input type="password" name="password">
                        <br>
                        <input type="submit" name="insert" value="Inserir" >
                        <input class="bnt" type="submit" value ="Voltar" formaction="index.jsp"/>
                    
            </form>
                </fieldset>
                <hr/>
                
                