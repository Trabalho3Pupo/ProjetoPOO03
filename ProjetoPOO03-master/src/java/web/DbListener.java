/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import db.Quiz;
import db.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author rlarg
 */
public class DbListener implements ServletContextListener {
    public static final String jdbcUrl = "jdbc:sqlite:C:\\Users\\cassi\\dados.db";
    
    public static String exceptionMessage = null;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String step = "Database creation";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement stmt = con.createStatement();
            
            step = "Table 'users' creation";
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users("
                    + "name VARCHAR(200) NOT NULL,"
                    + "login VARCHAR(20) PRIMARY KEY,"
                    + "password_hash LONG NOT NULL,"
                    + "role VARCHAR(20) NOT NULL"
                    + ")");
            
            if(User.getUsers().isEmpty()){
                step = "Default admin user creation";
                stmt.executeUpdate("INSERT INTO users(name, login, password_hash, role)"
                        + "VALUES ('Administrador', 'admin', "+"123456".hashCode()+", 'ADMIN')");
                step = "Default alana user creation";
                stmt.executeUpdate("INSERT INTO users(name, login, password_hash, role)"
                        + "VALUES ('Alana pagani', 'alana', "+"123456".hashCode()+", 'USER')");
                step = "Default cassio user creation";
                stmt.executeUpdate("INSERT INTO users(name, login, password_hash, role)"
                        + "VALUES ('cassio', 'cassio', "+"123456".hashCode()+", 'USER')");
            }   
                //CRIANDO TABELA QUESTIONS PARA ARMAZENAR PERGUNTASE E RESPOSTAS
            step = " Table 'questions' creation";
            stmt.executeUpdate ("CREATE TABLE IF NOT EXISTS questions("
                    + "description VARCHAR(250),"
                    + "answer VARCHAR(250) NOT NULL,"
                    + "wronganswer1 VARCHAR(250) NOT NULL,"
                    + "wronganswer2 VARCHAR(250) NOT NULL,"
                    + "wronganswer3 VARCHAR(250) NOT NULL"
                    + ")");
            
            
            //CRIANDO PERGUNTAS E RESPOSTAS

                
            
            stmt.close();
            con.close();
        }catch(Exception ex){
            exceptionMessage = step + ": " + ex.getMessage();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
