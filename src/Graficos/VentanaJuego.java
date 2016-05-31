
package Graficos;

import Conexion.ConexionCliente;
import Juego.JugadorInfo;
import java.awt.Color;
import javax.swing.JFrame;

/*
    Esta clase es una extension de JFrame y nos permitira
    la creacion de una ventana grafica que contendra nuestro
    juego.
*/
public class VentanaJuego extends JFrame {
    Lienzo lienzo;
    
    public void setVidas(int v1, int v2) 
    {
        lienzo.setVidas(v1,v2);
    }
    public VentanaJuego(JugadorInfo jugadorInfo1,JugadorInfo jugadorInfo2,int player, ConexionCliente conexion) {
        lienzo = new Lienzo(conexion,jugadorInfo1,jugadorInfo2,player,this);
        //Asignamos atributos de la ventana
        setBounds(0,0,lienzo.WIDTH+6,lienzo.HEIGHT+29);                 //Dimensiones de la venatan
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Evento de cierre de ventana
        setResizable(false);                        //Evitar que se pueda redimensionar la ventana
        if(player == 1)
            setTitle("Lan Pong! Jugador "+player+": " + jugadorInfo1.username);  //Asignar titulo de la ventana
        else if(player == 2)
            setTitle("Lan Pong! Jugador "+player+": " + jugadorInfo2.username);  //Asignar titulo de la ventana    
        add(lienzo);
        lienzo.setBackground(Color.BLACK);
        setVisible(true);                           //Hacer visible la ventana
    }

    public void moveOponent(Integer valueOf) {
        lienzo.moveOponent(valueOf);
    }

    public void moveBall(Integer x, Integer y) {
        lienzo.moveBall(x,y);
    }
}
