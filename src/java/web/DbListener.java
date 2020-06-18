/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import db.Question;
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
    public static final String jdbcUrl = "jdbc:sqlite:C:\\Users\\Alana\\dados.db";
    
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
            step = "Default questions creation";
            if (Question.getQuestions().isEmpty()){
                stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Normalmente, quantos litros de sangue uma pessoa tem?', 'Entre 4 a 6 litros', 'Tem 10 litros', 'Tem 7 litros', 'Entre 2 a 4 litros')");
               
                stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Qual o menor e o maior país do mundo?','Vaticano e Rússia','Mônaco e Canadá','Malta e Estados Unidos','São Marino e Índia')");
                
                stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Quais os países que têm a maior e a menor expectativa de vida do mundo?', 'Japão e Serra Leoa', 'Austrália e Afeganistão', 'Itália e Chade', 'Estados Unidos e Angola',)");
              
                stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Em qual local da Ásia o português é língua oficial?', 'Macau', 'Índia','Filipinas','Portugal')");
               
                stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Quais destas construções famosas ficam nos Estados Unidos?', 'Estátua da Liberdade, Golden Gate Bridge e Empire State Building.', 'Estátua da Liberdade, Big Ben e The High Line', 'Lincoln Memorial, Sidney Opera House e Burj Khalifa', '30 St Mary Axe, The High Line e Residencial 148 Spruce Street')");
               
                stmt.executeUpdate ( "INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Qual destes países é transcontinental?', 'Rússia', ' Filipinas', 'Istambul', 'Groenlândia',)");
                
               stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Qual foi o recurso utilizado inicialmente pelo homem para explicar a origem das coisas?', 'Mitologia', 'Biologia', 'Filosofia', 'Astronomia')");
                
                stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Em que estado australiano fica situada a cidade de Sydney?','Nova Gales do Sul','Norfolk','Queensland','Tasmânia')");
                
                stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Em que século o continente europeu foi devastado pela peste bubônica?', 'No século XIV', 'No século XIII', 'No século XI', 'No século X')");
                
               stmt.executeUpdate ("INSERT INTO questions(description, answer, wronganswer1, wronganswer2, wronganswer3) "
                    + "VALUES('Quem foi o criador da tragédia grega?', 'Ésquilo', 'Homero', 'Plutarco', 'Sófocles')");
                
                
            }
            
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
