
package Conexion;

import Graficos.VentanaCliente;
import Graficos.VentanaJuego;
import Juego.JugadorInfo;
import java.io.IOException;

public class HiloClientes extends Thread {
    private ConexionCliente conexion;
    private VentanaCliente ventanaCliente;
    private VentanaJuego ventanaJuego;
    private JugadorInfo jugadorInfo1;
    private JugadorInfo jugadorInfo2;
    int player;
    public HiloClientes(ConexionCliente con, VentanaCliente vc,JugadorInfo jugadorInfo1,JugadorInfo jugadorInfo2, int player) {
        conexion = con;
        this.player = player;
        ventanaCliente  = vc;
        this.jugadorInfo1 = jugadorInfo1;
        this.jugadorInfo2 = jugadorInfo2;
    }
    @Override
    public void run() {
        String dato;
        try {
            System.out.println("Esperando algun ACK");
            dato = conexion.esperarDatos();
            System.out.println(dato);
            ventanaCliente.setVisible(false);
            ventanaJuego = new VentanaJuego(jugadorInfo1,jugadorInfo2,player,conexion);
            while(true) {
                String [] data = conexion.esperarDatos().split(";");
                switch(data[0]){
                    case "M":
                        ventanaJuego.moveOponent(Integer.valueOf(data[1]));
                        break;
                        
                    case "B":  
                        ventanaJuego.moveBall(Integer.valueOf(data[1]),Integer.valueOf(data[2]));
                        break;
                        
                    case "P":
                        ventanaJuego.setVidas(Integer.valueOf(data[1]),Integer.valueOf(data[2]));
                        break;
                }
            }
        } catch (IOException ex) {
          
        }
        
    }
}
