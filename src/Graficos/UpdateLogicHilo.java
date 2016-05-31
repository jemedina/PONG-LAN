/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Juego.JuegoLogica;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class UpdateLogicHilo extends Thread {
    JuegoLogica logic;
    private Container contenedor;
    //Dialogo1 dialog1=new Dialogo1(new javax.swing.JFrame(), true); 
   
    public UpdateLogicHilo(JuegoLogica l) {
       logic = l;
    }
    //EMISION DE LOS DATOS
    @Override
    public void run() {
        while(true) {
           /* if(logic.ganoJ1()){ 
                Dialogo1 d1= new Dialogo1(new JFrame(), true); 
                System.out.println("gano j1");
                d1.setVisible(true);
                this.stop();
            }
            if(logic.ganoJ2()){ 
                Dialogo2 d2= new Dialogo2(new JFrame(), true); 
                System.out.println("gano j2");
                d2.setVisible(true);
                this.stop();
            }*/
            logic.update();
            try {
                //1000 / 50 = 20 (50 fps)
                Thread.sleep(20);
            } catch (InterruptedException ex) {}
        }
    }    
    
    
    
    
}
