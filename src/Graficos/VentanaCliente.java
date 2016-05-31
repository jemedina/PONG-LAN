
package Graficos;

import Conexion.ConexionCliente;
import Conexion.HiloClientes;
import Juego.JugadorInfo;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VentanaCliente extends javax.swing.JFrame {
    private JugadorInfo jugadorInfo1;    //Variable para guardar la informacion del juego
    private JugadorInfo jugadorInfo2;    //Variable para guardar la informacion del juego
    JugadorInfo jugadorInfo = new JugadorInfo();//TMP
    private String ip;                  //IP de donde estara el servidor
    private ConexionCliente conexion;
    private int player;
    private HiloClientes hiloClientes;
    public VentanaCliente() {
        initComponents();
        jugadorInfo1 = new JugadorInfo();
        jugadorInfo2 = new JugadorInfo();
        conexion = new ConexionCliente();
    }
    
   /*Comienzan los eventos:*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        textFieldUsername = new javax.swing.JTextField();
        textFieldIP = new javax.swing.JTextField();
        labelIP = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        testColor = new javax.swing.JLabel();
        botonConectarse = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lan Pong!");
        setBounds(new java.awt.Rectangle(150, 60, 0, 0));
        setPreferredSize(new java.awt.Dimension(440, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("OCR A Extended", 2, 36)); // NOI18N
        labelTitulo.setText("Lan Pong!");
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 11, 221, -1));

        labelUsername.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        labelUsername.setText("Nombre de usuario:");
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 69, 315, -1));
        labelUsername.getAccessibleContext().setAccessibleName("eee");

        textFieldUsername.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        textFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldUsernameKeyTyped(evt);
            }
        });
        getContentPane().add(textFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 101, 315, -1));

        textFieldIP.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(textFieldIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 177, 315, -1));

        labelIP.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        labelIP.setText("Dir. IP del servidor:");
        getContentPane().add(labelIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 145, -1, -1));

        labelColor.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        labelColor.setText("Seleccione su color:");
        getContentPane().add(labelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 221, -1, -1));

        jSlider1.setMaximum(255);
        jSlider1.setMinimum(80);
        jSlider1.setValue(180);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 253, -1, -1));

        jSlider2.setMaximum(255);
        jSlider2.setMinimum(80);
        jSlider2.setToolTipText("");
        jSlider2.setValue(100);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        getContentPane().add(jSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 299, -1, -1));

        jSlider3.setMaximum(255);
        jSlider3.setMinimum(80);
        jSlider3.setValue(150);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });
        getContentPane().add(jSlider3, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 343, -1, -1));

        jLabel1.setText("Rojo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 253, -1, -1));

        jLabel2.setText("Verde");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 299, -1, -1));

        jLabel3.setText("Azul");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 343, -1, -1));

        testColor.setBackground(new java.awt.Color(180, 100, 150));
        testColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        testColor.setOpaque(true);
        getContentPane().add(testColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 43, 35));

        botonConectarse.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        botonConectarse.setText("Unirse a una partida");
        botonConectarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonConectarseMousePressed(evt);
            }
        });
        botonConectarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarseActionPerformed(evt);
            }
        });
        getContentPane().add(botonConectarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 455, -1, -1));

        statusLabel.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        getContentPane().add(statusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 330, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gif.gif"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -20, 540, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldUsernameKeyTyped
        if(textFieldUsername.getText().length() >= 20){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldUsernameKeyTyped

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        testColor.setBackground(new Color(
                jSlider1.getValue(),
                testColor.getBackground().getGreen(),
                testColor.getBackground().getBlue()
        ));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        testColor.setBackground(new Color(
                testColor.getBackground().getRed(),
                jSlider2.getValue(),
                testColor.getBackground().getBlue()
        ));
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        testColor.setBackground(new Color(
                testColor.getBackground().getRed(),
                testColor.getBackground().getGreen(),
                jSlider3.getValue()
        ));
    }//GEN-LAST:event_jSlider3StateChanged
    /*
        Evento de click del boton "Unirse a una partida"
        *Obtiene la informacion del jugador (su username y el color que tendra)
        *Muestra el mensaje de 'Conectandose al servidor'
        *Intenta realizar la conexion a la ip obtenida en la GUI
    */
    private void botonConectarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarseActionPerformed
       
        if( conexion.conectarse(ip) ){
            botonConectarse.setEnabled(false);
            statusLabel.setText("     Conectado!");
            conexion.enviarDatos(jugadorInfo.username+";"+jugadorInfo.colorPlayer.getRed()+","+jugadorInfo.colorPlayer.getGreen()+","+jugadorInfo.colorPlayer.getBlue());
            
            try {
                String dato = conexion.esperarDatos();
                        
                if(dato.equals("1")){
                    statusLabel.setText("   Conectado!   Esperando al jugador 2");
                    player=1;
                    jugadorInfo1 = jugadorInfo;
                    jugadorInfo1.player = 1;
                } else if(dato.equals("2")){
                    player=2;
                    jugadorInfo2 = jugadorInfo;
                    jugadorInfo2.player = 2;
                    statusLabel.setText("   Listo!");
                }
                
                String dato2 = conexion.esperarDatos();
                if(player==1){
                    jugadorInfo2.setInfo(dato2.split(";"));
                }else if(player==2){
                    jugadorInfo1.setInfo(dato2.split(";"));
                }
                //ConexionCliente con, VentanaCliente vc,JugadorInfo jugadorInfo1,JugadorInfo jugadorInfo2, int player
    
                hiloClientes = new HiloClientes(conexion,this,jugadorInfo1,jugadorInfo2,player);
                hiloClientes.start();
            } catch (IOException ex) {
                Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            statusLabel.setText("La conexion con el servidor ha fallado.");
        }
    }//GEN-LAST:event_botonConectarseActionPerformed

    private void botonConectarseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonConectarseMousePressed
        if(botonConectarse.isEnabled()){
            jugadorInfo.username = textFieldUsername.getText();
            jugadorInfo.colorPlayer = testColor.getBackground();
            ip = textFieldIP.getText();
            statusLabel.setText("    Conectandose al servidor...");
        }
    }//GEN-LAST:event_botonConectarseMousePressed

   /*Fin de los eventos*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConectarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel testColor;
    private javax.swing.JTextField textFieldIP;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables
    //Funcion que realiza operaciones despues de inicializar los objetos de swing
    private void postInit() {
        textFieldUsername.setColumns(10);
        testColor.setBackground(new java.awt.Color(0, 0, 0));
    }

}

