
package Conexion;

import Graficos.UpdateLogicHilo;
import Graficos.VentanaJuego;
import Graficos.VentanaServidor;
import Juego.JuegoLogica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    private TransmitLogicHilo hiloTransmision;
    private UpdateLogicHilo hiloActualizarLogica;
    private JuegoLogica logic;  //Objeto controlador de la logica del juego
    private ServerSocket serverSocket;
    private final int PORT = 6767;
    private VentanaServidor guiServer;
    private int numOfConnections;   //Guardara el numero de conexiones recibidas
    //Objetos necesarios para establecer la conexion (SOCKETS, ENTRADAS y SALIDAS)
    private Socket socketClient1;           //Canal de conexion para el jugador 1
    private Socket socketClient2;           //Canal de conexion para el jugador 2
    private BufferedReader inputClient1;    //Lector de entrada para el jugador 1
    private BufferedReader inputClient2;    //Lector de entrada para el jugador 2
    private PrintWriter outputClient1;      //Salida de datos para el jugador 1
    private PrintWriter outputClient2;      //Salida de datos para el jugador 2
    private JugadorInfoNetwork jugadorInfo1;    //Informacion del jugador 1
    private JugadorInfoNetwork jugadorInfo2;    //Informacion del jugador 2
    
    private EscuchadorCliente escuchadorCliente1;
    private EscuchadorCliente escuchadorCliente2;
    //Al construhir el servidor lo inicializaremos
    public Servidor(VentanaServidor guiServer) {
        this.guiServer = guiServer;
        this.guiServer.log("Inicializando servidor...");
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.err.println("El puerto ["+PORT+"] esta ocupado por otra aplicacion");
        }
        
        this.guiServer.log("Servidor iniciado!");
        esperarJugador1();
        esperarJugador2();
        logic = new JuegoLogica();
        
        hiloTransmision = new TransmitLogicHilo(this.outputClient1,this.outputClient2,logic);
        hiloActualizarLogica = new UpdateLogicHilo(logic);
        escuchadorCliente1 = new EscuchadorCliente(inputClient1,logic,1);
        escuchadorCliente2 = new EscuchadorCliente(inputClient2,logic,2);
        escuchadorCliente1.start();
        escuchadorCliente2.start();
        hiloActualizarLogica.start();
        hiloTransmision.start();        
    }
    
    public void esperarJugador1()  {
        guiServer.log("Esperando al jugador 1...");
        try {
            socketClient1 = serverSocket.accept();
            inputClient1 = new BufferedReader(new InputStreamReader(socketClient1.getInputStream()));
            outputClient1 = new PrintWriter(socketClient1.getOutputStream(),true);
            String [] info = inputClient1.readLine().split(";");
            jugadorInfo1 = new JugadorInfoNetwork(info);
            jugadorInfo1.player = 1;
            //Thread.sleep(1000);
            outputClient1.println(1);
            guiServer.log("Jugador 1 ["+jugadorInfo1.username+"] conectado desde ["+socketClient1.getInetAddress().getHostAddress()+"]");
        
        } catch (IOException ex) {
            guiServer.log("Error al establecer la conexion con el jugador 1");
       // } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void esperarJugador2()  {
        guiServer.log("Esperando al jugador 2...");
        try {
            socketClient2 = serverSocket.accept();
            inputClient2 = new BufferedReader(new InputStreamReader(socketClient2.getInputStream()));
            outputClient2 = new PrintWriter(socketClient2.getOutputStream(),true);
            String [] info = inputClient2.readLine().split(";");
            jugadorInfo2 = new JugadorInfoNetwork(info);
            jugadorInfo2.player = 2;
            outputClient2.println(2);
            guiServer.log("Jugador 2 ["+jugadorInfo2.username+"] conectado desde ["+socketClient2.getInetAddress().getHostAddress()+"]");
            guiServer.log("Iniciando partida...");
            outputClient1.println(jugadorInfo2.username+";"+jugadorInfo2.colorPlayer.getRed()+","+jugadorInfo2.colorPlayer.getGreen()+","+jugadorInfo2.colorPlayer.getBlue());
            
            outputClient2.println(jugadorInfo1.username+";"+jugadorInfo1.colorPlayer.getRed()+","+jugadorInfo1.colorPlayer.getGreen()+","+jugadorInfo1.colorPlayer.getBlue());
            
            Thread.sleep(2000);
            outputClient1.println(0);
            outputClient2.println(0);
             guiServer.log("Partida iniciada!");
        } catch (IOException ex) {
            guiServer.log("Error al establecer la conexion con el jugador 2");
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
