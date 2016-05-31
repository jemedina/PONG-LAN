
package Graficos;

import Conexion.ConexionCliente;
import Juego.JugadorInfo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Lienzo extends Canvas {
    private JFrame parent;
    boolean gameEnded = false;
    private BufferedImage bufferedImage; //Buffer secundario para evitar flicker
    private Graphics buffer;             //Objeto graphics proveniente del bufferedImage
    private int player;
    private ConexionCliente conexion;
    private JugadorInfo infoPlayer1;
    private JugadorInfo infoPlayer2;
    private int vidas1, vidas2;
    private Rectangle player1;
    private Rectangle player2;
    private Rectangle pelota;
    final int WIDTH = 600;
    final int HEIGHT = 400;
    final int JUGADOR_WIDTH = 20;
    final int JUGADOR_HEIGHT = 60;
    TeclasListener keyListener;
    @Override
    public void paint(Graphics g) {
        if(!gameEnded)
            update(g);  //Enviar el buffer a update para evitar que limpie la pantalla

    }
    private void checkWinner() {
        if(player == 1 && vidas2 <= 0){
            gameEnded = true;
            Dialogo dialogo = new Dialogo(parent,true,"Jugador 1 ["+infoPlayer1.username+"] Gano la partida!",Color.GREEN);
        }
        else if(player == 2 && vidas1 <= 0) {
            gameEnded = true;
            Dialogo dialogo = new Dialogo(parent,true,"Jugador 2 ["+infoPlayer2.username+"] Gano la partida!",Color.GREEN);

        } 
        else if(player == 1 && vidas1 <= 0) {
            gameEnded = true;
            Dialogo dialogo = new Dialogo(parent,true,"Jugador 1 ["+infoPlayer1.username+"] Has perdido :c!",Color.RED);
        } 
        else if(player == 2 && vidas2 <= 0) {
            gameEnded = true;
            Dialogo dialogo = new Dialogo(parent,true,"Jugador 2 ["+infoPlayer2.username+"]  Has perdido :c!",Color.RED);
        } 
    }
    private void stopGame() {
        if(gameEnded) {
            this.removeKeyListener(keyListener);
        }
    }
    @Override
    public void update(Graphics g) {
        
        if(!gameEnded) {
            //Pasar el buffer secundario al primario
            //Pintar todo sobre el buffer secundario
        
            checkWinner();
            stopGame();
            buffer.setColor(Color.BLACK);
            buffer.fillRect(0,0,WIDTH,HEIGHT);
            buffer.setColor(infoPlayer1.colorPlayer);
            buffer.fillRect(player1.x,player1.y,player1.width,player1.height);
            buffer.setColor(infoPlayer2.colorPlayer);
            buffer.fillRect(player2.x,player2.y,player2.width,player2.height);
            buffer.setColor(Color.WHITE);
            for(int i = 0; i < HEIGHT ; i+=10){
                buffer.drawLine(WIDTH/2, i, WIDTH/2, i+5);
            }
            buffer.fillOval(pelota.x, pelota.y, pelota.width, pelota.height);
            Graphics2D letters = (Graphics2D)buffer;
            letters.setFont(new Font("Comic Sans MS",Font.PLAIN,22));
            letters.drawString(String.valueOf(vidas1), 10,25);
            letters.drawString(String.valueOf(vidas2), WIDTH-30, 25);
            g.drawImage(bufferedImage, 0,0, null);
        
        }
    }
    Lienzo(ConexionCliente conexion,JugadorInfo info1,JugadorInfo info2, int player,JFrame par) {
        super();
        this.setSize(WIDTH,HEIGHT);//Asignar tamaño al lienzo (El mismo de la ventana)
        //Inicializacion del segundo buffer
        bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB); //Inicializacion de buffered image al tamaño del lienzo
        buffer = bufferedImage.getGraphics();//Extraer el buffer de bufferedImage
        this.infoPlayer1 = info1;
        this.infoPlayer2 = info2;
        parent = par;
        this.conexion = conexion;
        this.player = player;
        vidas1 = vidas2 = 10;
        player1 = new Rectangle(0,140,JUGADOR_WIDTH,JUGADOR_HEIGHT);
        player2 = new Rectangle(WIDTH-JUGADOR_WIDTH,140,JUGADOR_WIDTH,JUGADOR_HEIGHT);
        pelota = new Rectangle(WIDTH/2-5,HEIGHT/2-5,10,10);
        keyListener = new TeclasListener();
        addKeyListener(keyListener);//Escuchador de teclas
    }

    void moveOponent(Integer valueOf) {
        if(player == 1){
            player2.setLocation(player2.x, valueOf);
        }else if(player == 2){
            player1.setLocation(player1.x, valueOf);            
        }
        repaint();
    }

    void moveBall(Integer x, Integer y) 
    {
        pelota.x = x;
        pelota.y = y;
        repaint();
    }

    public void setVidas(int v1, int v2) {
        this.vidas1 = v1;
        this.vidas2 = v2;
    }
        
    
    class TeclasListener extends KeyAdapter implements ActionListener {
        private final Timer timerTeclas;
        private boolean keyup,keydown;
        public TeclasListener(){
            keyup = keydown = false;
            //1000/30 = 33
            timerTeclas = new Timer(12,this);
            timerTeclas.start();
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                keyup = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                keydown = true;
            }
        }

        
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                keyup = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                keydown = false;
            }
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(keyup){
                if(player == 1){
                    if(player1.getLocation().y >= 0 ){
                        
                    conexion.enviarDatos("M;1");
                        player1.setLocation(
                            player1.getLocation().x,
                            player1.getLocation().y-2
                        );
                    }
                } else if(player == 2){
                    
                     if(player2.getLocation().y >= 0){
                        conexion.enviarDatos("M;1");
                        player2.setLocation(
                        player2.getLocation().x,
                        player2.getLocation().y-2
                        );
                    }
                }
                repaint();
            }
            
            if(keydown){
                if(player == 1){
                    if(player1.getLocation().y+JUGADOR_HEIGHT <= HEIGHT ){
                    conexion.enviarDatos("M;2");
                
                        player1.setLocation(
                            player1.getLocation().x,
                            player1.getLocation().y+2
                        );
                    }
                 } else if(player == 2){
                     if(player2.getLocation().y+JUGADOR_HEIGHT <= HEIGHT){
                    conexion.enviarDatos("M;2");
                
                        player2.setLocation(
                        player2.getLocation().x,
                        player2.getLocation().y+2
                    );
                    }
                 }
                repaint();
            }
        }
    }
}