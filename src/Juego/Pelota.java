package Juego;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota {
    private Vector2 velocidad;
    private float x , y;
    private Rectangle jugador1,jugador2;
    public final int WIDTH = 10;
    public final int HEIGHT = 10;
    private int j1y0,j1y1,j2y0,j2y1,j1dy,j2dy;
    private Rectangle region;
    private boolean viva;
    private long dt,t0,t1,ct;
    private final JuegoLogica logic;
    public Pelota(Rectangle jugador1,Rectangle jugador2,JuegoLogica parent) {
        x = JuegoLogica.WIDTH/2;
        y = JuegoLogica.HEIGHT/2;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        velocidad = new Vector2();
        region = new Rectangle();
        j1y0 = j2y0 = 0;
        t0=System.currentTimeMillis();
        ct=0;
        region.setSize(WIDTH,HEIGHT);
        velocidad.setAngleAndMagnitude(130,6);
        this.logic = parent;
        viva = true;
    }
    private void deltaTime(){
        t1 = System.currentTimeMillis();
        dt = t1-t0;
        t0 = t1;
    }
    
    public void update() {
        deltaTime();
        checkAngle();
        if(viva) {
            j1y1 = (int) jugador1.getY();
            j2y1 = (int) jugador2.getY();
            j1dy = (j1y1-j1y0);
            j2dy = (j2y1-j2y0);
            j1y0 = j1y1;
            j2y0 = j2y1;

            x+= velocidad.getX();
            y+= -velocidad.getY();
            checkBoundsColission();
            updateRegion();
            if(jugador1.intersects(region)){ 
                velocidad.invertXComponent();
                x=jugador1.width+1;
                //Comportamiento de la pelota al chocar con las paletas
                if((j1dy > 0 && velocidad.getY() > 0) ){
                    velocidad.invertYComponent();
                    velocidad.setAngle(velocidad.getAngle()-20);
                    velocidad.setMagnitude(velocidad.getMagnitude()-0.5f);
                }
                else if (j1dy < 0 && velocidad.getY() < 0) {
                    velocidad.invertYComponent();
                    velocidad.setAngle(velocidad.getAngle()+20);

                    velocidad.setMagnitude(velocidad.getMagnitude()-0.5f);
                }
                else if((j1dy > 0 && velocidad.getY() < 0) ){
                    velocidad.setAngle(velocidad.getAngle()+20);
                    velocidad.setMagnitude(velocidad.getMagnitude()+0.5f);
                }
                else if (j1dy < 0 && velocidad.getY() > 0) {
                    velocidad.setAngle(velocidad.getAngle()-20);
                    velocidad.setMagnitude(velocidad.getMagnitude()+0.5f);
                }

             // collideP1= true;<
             // collideP2= false; 
          }

           if(jugador2.intersects(region)){ 
                velocidad.invertXComponent();
                x=JuegoLogica.WIDTH-jugador2.width-WIDTH-1;
                if((j2dy > 0 && velocidad.getY() > 0) ){
                    velocidad.invertYComponent();
                    velocidad.setAngle(velocidad.getAngle()-20);
                    velocidad.setMagnitude(velocidad.getMagnitude()-0.5f);
                }else if (j2dy < 0 && velocidad.getY() < 0) {
                    velocidad.invertYComponent();
                    velocidad.setAngle(velocidad.getAngle()+20);
                    velocidad.setMagnitude(velocidad.getMagnitude()-0.5f);
                }
                else if((j2dy > 0 && velocidad.getY() < 0) ){
                    velocidad.setAngle(velocidad.getAngle()+20);
                    velocidad.setMagnitude(velocidad.getMagnitude()+0.5f);
                }
                else if (j2dy < 0 && velocidad.getY() > 0) {
                    velocidad.setAngle(velocidad.getAngle()-20);
                    velocidad.setMagnitude(velocidad.getMagnitude()+0.5f);
                }
            // collideP2= true; 
             // collideP1= false;
            }
        } else {
               x= -20;
               ct+=dt;
               if(ct > 2000){
                   x= (JuegoLogica.WIDTH/2);
                   y= (JuegoLogica.HEIGHT/2);
                   ct = 0;
                   viva=true;
               }
        }
    }
    
    public int getX() {
        return (int)x;
    }
    
    public int getY() {
        return (int)y;
    }
    private void invertXAngle() {
        viva = false;
        ct = 0;
    }
    private void invertYAngle() {
        velocidad.invertYComponent();
    }
    private void checkBoundsColission() {
        if(x < 0) {
            invertXAngle();
            logic.puntos2();
        }
        
        if( (x+WIDTH) > JuegoLogica.WIDTH) {
            
            invertXAngle();
            logic.puntos1();
        }
        
        if(y < 0) {
            y = 0;
            invertYAngle();
        }
        
        if( (y+HEIGHT) > JuegoLogica.HEIGHT ){
            y = JuegoLogica.HEIGHT-HEIGHT;
            invertYAngle();
        }
    }

    private void updateRegion() {
        region.setLocation((int)x,(int)y);
    }

    private void checkAngle() {
        if(velocidad.getAngle() == 0 || velocidad.getAngle() == 180 || velocidad.getAngle() == 90 || velocidad.getAngle() == 270 ){
            velocidad.setAngle((float) (velocidad.getAngle()+(5+Math.random()*20)));
        }
    }
}   
