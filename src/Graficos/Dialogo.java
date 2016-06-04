/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Edgardo
 */
public class Dialogo  extends JDialog implements WindowListener {
     
    Dialogo(JFrame jframe, boolean modal,String title,Color c){ 
          super(jframe, modal);
          this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
          this.setTitle(title);
          this.setResizable(false);
          this.setBounds(400, 200, 300, 300);
          JLabel label = new JLabel(title);
          label.setOpaque(true);
          label.setBackground(c);
          addWindowListener(this);
          add(label);
          this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}

