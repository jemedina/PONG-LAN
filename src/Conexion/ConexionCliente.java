
package Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionCliente {
    private Socket socket;                //Objeto socket para realizar la comunicacion con el server
    private final int PORT = 6767;              //Constante para el puerto
    private BufferedReader input;
    private PrintWriter output;
    public ConexionCliente() {
        socket = new Socket();                  //Inicializar le objeto socket     
    }
    public boolean conectarse(String ipServer) {
        boolean connected = false;
        try {
            socket.connect(new InetSocketAddress(ipServer, PORT));      //Intentar conectarse a la IP y puerto definidos
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(),true);
            connected = true;
        } catch (IOException ex) {
            socket = new Socket();              //Si la conexion fallo, renovar el objeto socket
        }
        return connected;
    }
    
    public void enviarDatos(String data) {
        output.println(data);
    }
    public String esperarDatos() throws IOException {
       
             return input.readLine();
       
      
    }
}
