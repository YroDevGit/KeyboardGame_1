/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sounds;

import java.io.File;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Acer
 */
public class Sounds {
    public Clip clip = null;
    public void playClip(String clipname){
        
        File file = new File("src/Sounds/"+clipname);
        
        boolean run = true;
        int count =1;
        while(run){
            try {
                
                Thread.sleep(0);
                if(count==1){   
                    this.sound(file);
                }
                else{
                    run=false;                    
                }
                count++;
            } catch (InterruptedException ex) {
                System.exit(0);
                Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void sound(File f){
        
        try {
            clip = AudioSystem.getClip();
            clip.stop();
            clip.close();
            clip.open(AudioSystem.getAudioInputStream(f));
           
            clip.start();
            
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}



