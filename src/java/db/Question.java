/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import web.DbListener;

/**
 *
 * @author Alana
 */
public class Question {
   private  String description;
   private  String answer;
   private  String wronganswer1;
   private  String wronganswer2;
   private  String wronganswer3;
   
   public static ArrayList<Question> getQuestions() throws Exception{
        ArrayList<Question> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(DbListener.jdbcUrl);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM questions ");
        while(rs.next()){
            list.add(new Question(
                    rs.getString("description"), 
                    rs.getString("answer"), 
                    rs.getString("wronganswer1"), 
                    rs.getString("wronganswer2"), 
                    rs.getString("wronganswer3")));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

    public Question(String description, String answer, String wronganswer1, String wronganswer2, String wronganswer3) {
        this.description = description;
        this.answer = answer;
        this.wronganswer1 = wronganswer1;
        this.wronganswer2 = wronganswer2;
        this.wronganswer3 = wronganswer3;
    }
   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getWronganswer1() {
        return wronganswer1;
    }

    public void setWronganswer1(String wronganswer1) {
        this.wronganswer1 = wronganswer1;
    }

    public String getWronganswer2() {
        return wronganswer2;
    }

    public void setWronganswer2(String wronganswer2) {
        this.wronganswer2 = wronganswer2;
    }

    public String getWronganswer3() {
        return wronganswer3;
    }

    public void setWronganswer3(String wronganswer3) {
        this.wronganswer3 = wronganswer3;
    }
}
