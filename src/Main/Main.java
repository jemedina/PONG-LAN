package Main;
import Juego.JuegoCliente;
import Juego.JuegoServidor;
import java.util.Scanner;
        
public class Main {
    public static void main(String[] args) {
        System.out.print("Ingrese 'S' para servidor o 'C' para cliente > ");
        char i = new Scanner(System.in).next().toUpperCase().charAt(0);
        if(i == 'S'){
            JuegoServidor servidor = new JuegoServidor();
        } else if(i == 'C'){
            JuegoCliente cliente = new JuegoCliente();
        }
    }  
}    
           