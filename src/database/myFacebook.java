
package database;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class myFacebook {
    public void TyroneLeeEmz(){
        try {
            //Automatically send you to Tyrone Lee Emz's Facebook Profile
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start chrome http://facebook.com/Crush.mo05"});
        } catch (IOException ex) {
            Logger.getLogger(myFacebook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
