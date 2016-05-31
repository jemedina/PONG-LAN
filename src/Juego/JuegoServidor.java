
package Juego;

import Graficos.VentanaServidor;

public class JuegoServidor {
    private VentanaServidor ventanaServidor;
    public JuegoServidor() {      
        ventanaServidor = new VentanaServidor();
        ventanaServidor.setVisible(true);
        ventanaServidor.initServer();
        
    }
}
