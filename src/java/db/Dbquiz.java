/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Alana
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Dbquiz {
    public static ArrayList<Quiz> getQuiz(){
        ArrayList<Quiz> quiz = new ArrayList<>();
        quiz.add(new Quiz("Normalmente, quantos litros de sangue uma pessoa tem?", "Entre 4 a 6 litros", new String[]{"Entre 4 a 6 litros","Tem 7 litros","Tem 10 litros"}));
        quiz.add(new Quiz("Qual o menor e o maior país do mundo?", "Vaticano e Rússia", new String[]{"Malta e Estados Unidos","Mônaco e Canadá","Vaticano e Rússia"}));
        quiz.add(new Quiz("Quais os países que têm a maior e a menor expectativa de vida do mundo?", "Japão e Serra Leoa", new String[]{"Austrália e Afeganistão","Japão e Serra Leoa","Estados Unidos e Brasil"}));
        quiz.add(new Quiz("Em qual local da Ásia o português é língua oficial?", "Macau", new String[]{"Macau","Portugal","Índia"}));
        quiz.add(new Quiz("Quais destas construções famosas ficam nos Estados Unidos?", "Estátua da Liberdade, Golden Gate Bridge e Empire State Building.", new String[]{"Estátua da Liberdade, Big Ben e The High Line","Estátua da Liberdade, Golden Gate Bridge e Empire State Building.","Lincoln Memorial, Sidney Opera House e Burj Khalifa"}));
        quiz.add(new Quiz("Qual destes países é transcontinental?", "Rússia", new String[]{"Filipinas","Groenlândia","Rússia"}));
        quiz.add(new Quiz("Qual foi o recurso utilizado inicialmente pelo homem para explicar a origem das coisas?", "Mitologia", new String[]{"Mitologia","Astronomia","Filosofia"}));
        quiz.add(new Quiz("Em que estado australiano fica situada a cidade de Sydney?", "Nova Gales do Sul", new String[]{"Queensland","Norfolk","Nova Gales do Sul"}));
        quiz.add(new Quiz("Em que século o continente europeu foi devastado pela peste bubônica?", "No século XIV", new String[]{"No século X","No século XX","No século XIV"}));
        quiz.add(new Quiz("Quem foi o criador da tragédia grega?", "Ésquilo", new String[]{"Ésquilo","Homero","Sófocles"}));
   
        Collections.shuffle(quiz);
        
        return quiz;
        
    }
     private static  ArrayList<Player> player = new ArrayList<Player>();
        public static ArrayList<Player> getPlayers(){
        
         
            Calendar c = Calendar.getInstance();
            
            if (player.isEmpty()){          
            c.set(2020, 6, 20);
            player.add(new Player("Ana", 10.0 , c.getTime()));
            
            c.set(2020, 6 , 19);
            player.add(new Player("Raquel", 10.0 , c.getTime()));
            
            c.set(2020, 5, 19);
            player.add(new Player("Jorge", 9.0 , c.getTime()));
            
            c.set(2020, 5, 16);
            player.add(new Player("Rafael", 8.0 , c.getTime()));
            
            c.set(2020, 5, 14, 20, 39);
            player.add(new Player("Samanta", 7.0 , c.getTime()));
            
            c.set(2020, 4, 26);
            player.add(new Player("Gabriela", 6.0 , c.getTime()));
            
            c.set(2020, 4, 15, 20, 39);
            player.add(new Player("Luiza", 6.0 , c.getTime()));
            
            c.set(2020, 3, 13);
            player.add(new Player("Camila", 5.0 , c.getTime()));
            
            c.set(2020, 3, 11, 20, 39);
            player.add(new Player("Beatriz", 4.0 , c.getTime()));
            
            c.set(2020, 2, 3, 20, 39);
            player.add(new Player("Monica", 3.0 , c.getTime()));
            
            } 
         
         return player;
     }
}
