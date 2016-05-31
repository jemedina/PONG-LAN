/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;

public class JugadorInfo {
    public int player;
    public Color colorPlayer;
    public String username;
    
    public void setInfo(String [] info) {
        this.username = info[0];
        String [] color = info[1].split(",");
        this.colorPlayer = new Color(
            Integer.parseInt(color[0]),
            Integer.parseInt(color[1]),
            Integer.parseInt(color[2])
        );
    }
}
