
package Juego;

import java.awt.Rectangle;

public class JuegoLogica {
    public Rectangle jugador1, jugador2/*, pelota*/;
    public int /*dx,dy,*/ p1=0, p2=0;
    public static final int WIDTH = 600 , HEIGHT = 400;
    public boolean collideP1= false, collideP2= false; 
    public Pelota pelota;
    final int JUGADOR_WIDTH = 20;
    final int JUGADOR_HEIGHT = 60;
    public int vidas1=6,vidas2=6;
    public  void puntos1() {
        vidas2--;
        System.out.println("Vidas J1["+vidas1+"] , J2["+vidas2+"]");
    }
    public  void puntos2() {
        vidas1--;
       System.out.println("Vidas J1["+vidas1+"] , J2["+vidas2+"]");
    }
    public JuegoLogica() {
        jugador1 = new Rectangle();
        jugador2 = new Rectangle();
        jugador1.setSize(JUGADOR_WIDTH,JUGADOR_HEIGHT);
        jugador2.setSize(JUGADOR_WIDTH,JUGADOR_HEIGHT);
        jugador1.setLocation(0,140);
        jugador2.setLocation(WIDTH-JUGADOR_WIDTH,140);
        pelota = new Pelota(jugador1,jugador2,this);
    }
     
    public void update(){
        pelota.update();
    }
     
    public void movePlayer1UP(){
          
        jugador1.setLocation(
                jugador1.getLocation().x,
                jugador1.getLocation().y-2
        );
    }
    public void movePlayer2UP(){
         
        jugador2.setLocation(
                jugador2.getLocation().x,
                jugador2.getLocation().y-2
        );
    }
    
     
    public void movePlayer1DOWN(){ 
        
            jugador1.setLocation(
                jugador1.getLocation().x,
                jugador1.getLocation().y+2
        );
        
        
    }
     
    public void movePlayer2DOWN(){
      
            jugador2.setLocation(
                jugador2.getLocation().x,
                jugador2.getLocation().y+2
        );
       
         
    } 
     
   public boolean ganoJ1(){ 
       return p1==5; 
   }
    
   public boolean ganoJ2(){ 
       return p2==5; 
   }
}
