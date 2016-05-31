/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.awt.Color;

/*
    Esta clase extiende de la que esta en el package "Juego"
    se le agregan atributos
*/
public class JugadorInfoNetwork extends Juego.JugadorInfo {
    public String ip;
    public JugadorInfoNetwork(String [] info) {
        this.setInfo(info);
    }
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
