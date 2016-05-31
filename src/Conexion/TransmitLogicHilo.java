
package Conexion;

import Juego.JuegoLogica;
import java.io.PrintWriter;

public class TransmitLogicHilo extends Thread {
    PrintWriter out1;
    PrintWriter out2;
    JuegoLogica logic;
    public TransmitLogicHilo(PrintWriter o1,PrintWriter o2,JuegoLogica l) {
       out1 = o1;
       out2 = o2;
       logic = l;
    }
    //EMISION DE LOS DATOS
    @Override
    public void run() {
        while(true) {
            out1.println("B;"+logic.pelota.getX()+";"+logic.pelota.getY());
            out2.println("B;"+logic.pelota.getX()+";"+logic.pelota.getY());
            out1.println("M;"+logic.jugador2.y);
            out2.println("M;"+logic.jugador1.y);
            out1.println("P;"+logic.vidas1+";"+logic.vidas2);
            out2.println("P;"+logic.vidas1+";"+logic.vidas2);
            try {
                //1000 / 25 = 40 (25 envios por segundo)
                Thread.sleep(40);
            } catch (InterruptedException ex) {}
        }
    }    
}
