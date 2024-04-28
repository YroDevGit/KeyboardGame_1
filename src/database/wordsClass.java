
package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class wordsClass {
    public LinkedList<String> list(String wordsFile){
        LinkedList<String> lst = new LinkedList<>();
        lst.clear();
        try {
            FileReader file = new FileReader("src/database/MyWords/"+wordsFile);
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            while((line=reader.readLine())!=null){
                if(lst.contains(line)){
                    //Skip
                }
                else{
                    line = line.toUpperCase();
                    lst.add(line);
                }
            }
            Collections.shuffle(lst);
            Collections.shuffle(lst);
            Collections.shuffle(lst);
            Collections.shuffle(lst);
            file.close();
            reader.close();
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lst;
    }
    
    
     public static int score(){
        int x =0;
        try {
            FileReader file = new FileReader("src/database/mydata/score.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            while((line=reader.readLine())!=null){
              x = Integer.parseInt(line);
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
  return x;
    }
     
     public String activities(){
         LinkedList<String> lst = new LinkedList<>();
       String x ="";
        try {
            FileReader file = new FileReader("src/database/mydata/actvty.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = "";
            while((line=reader.readLine())!=null){
             lst.add(line);
            }
            int size = lst.size()-1;
            for(int lstz = size; lstz >=0; lstz--){
                x = x+lst.get(lstz)+"\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
  return x;
    }
     
     public LinkedList<String> actv(){
         LinkedList<String> lst = new LinkedList<>();
       
        try {
            FileReader file = new FileReader("src/database/mydata/actvty.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = "";
            while((line=reader.readLine())!=null){
             lst.add(line);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
  return lst;
    }
     
     
     public  void SetScore(int score){
        try {
            FileWriter file = new FileWriter("src/database/mydata/score.txt");
            BufferedWriter write = new BufferedWriter(file);
            PrintWriter pr = new PrintWriter(write);
            pr.println(score);
            pr.close();
            write.close();
            
        } catch (IOException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
     
     public String getDate(){
         String txt ="";
         Date d = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
         SimpleDateFormat h = new SimpleDateFormat("HH");
         SimpleDateFormat m = new SimpleDateFormat("mm");
         txt = sdf.format(d);
         String hour = "";
         String ap = "";
         
         int hr = Integer.parseInt(h.format(d));
         
         if(hr==12){
             ap = "pm";
             hour = hr+"";
         }
         else{
             if(hr>=13){
                 hour = hr-12+"";
                 ap = "pm";    
             }
             else{
                 hour = hr+"";
                 ap = "am";
             }
         }
         
        String txtx = txt+" "+hour+":"+m.format(d)+""+ap;
         return txtx;
     }
     
     public  void SetActivity(String act){
        LinkedList lst = actv();
        try {
            //FileWriter file = new FileWriter("src/database/mydata/actvty.txt", true);
            FileWriter file = new FileWriter("src/database/mydata/actvty.txt", false);
            BufferedWriter write = new BufferedWriter(file);
            PrintWriter pr = new PrintWriter(write);
            pr.println(getDate()+" : "+act+".");
            int size = lst.size()-1;
            for(int x =0 ; x<=size; x++){
             pr.println(lst.get(x));   
            }
            pr.close();
            write.close();
            
        } catch (IOException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
     
     public  void resetActivity(){
        try {
            //FileWriter file = new FileWriter("src/database/mydata/actvty.txt", true);
            FileWriter file = new FileWriter("src/database/mydata/actvty.txt", false);
            BufferedWriter write = new BufferedWriter(file);
            PrintWriter pr = new PrintWriter(write);
            pr.print("");
            pr.close();
            write.close();
            
        } catch (IOException ex) {
            Logger.getLogger(wordsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
     
     
     public static void main(String[] asdas){
       
     }
    
    
    
    
}
