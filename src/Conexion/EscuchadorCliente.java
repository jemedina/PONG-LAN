
package Conexion;

import Juego.JuegoCliente;
import Juego.JuegoLogica;
import Juego.JuegoServidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class EscuchadorCliente extends Thread {
    private BufferedReader input;
    private JuegoLogica logic;
    private int player;
    public EscuchadorCliente(BufferedReader in, JuegoLogica logicGame, int player) {
        input = in;
        logic = logicGame;
        this.player = player;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                String data = input.readLine();
                //System.out.println(player + ": " + data);
                String [] commands = data.split(";");
                switch(commands[0]){
                    case "M":
                        if(commands[1].equals("1")){
                            if(player == 1){
                                logic.movePlayer1UP();
                            }else {
                                logic.movePlayer2UP();
                            }
                        } else if(commands[1].equals("2")) {
                            if(player == 1){
                                logic.movePlayer1DOWN();
                            }else {
                                logic.movePlayer2DOWN();
                            }
                        }
                    case "E":
                        
                        break;
                }
            } catch (IOException ex) {
               System.err.println("Error de comunicacion...");
               System.exit(1);
                
            }
        }
    }
}
