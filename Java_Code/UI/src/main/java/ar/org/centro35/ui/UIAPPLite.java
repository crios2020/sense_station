package ar.org.centro35.ui;

import java.awt.Color;

/**
 * UI App Lite protocolo versión 2
 * 
 * @author carlos
 */
public class UIAPPLite extends javax.swing.JFrame {

    /**
     * Creates new form UIAPPLite
     */
    public UIAPPLite() {
        initComponents();
        // jProgressBar1.setMinimum(0);
        // jProgressBar1.setMaximum(1023);
        // jProgressBar1.setValue(800);
        // jProgressBar1.setString("temperatura 20 C");
        // jProgressBar1.setBackground(Color.red);
        // jProgressBar1.setForeground(Color.red);

        // jProgressBar1.setStringPainted(true);
        // jProgressBar1.setForeground(Color.blue);
        // jProgressBar1.setForeground(Color.red);
        // jProgressBar1.setBackground(Color.red);
        // jProgressBar1.setString("10%");

        // jProgressBar1.setToolTipText("ttttt");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVersion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        prbTemperatura = new javax.swing.JProgressBar();
        prbHumedad = new javax.swing.JProgressBar();
        prbGases = new javax.swing.JProgressBar();
        prbIluminacion = new javax.swing.JProgressBar();

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha:");

        jTextField5.setEditable(false);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Hora:");

        jTextField6.setEditable(false);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sense_Station");

        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Estado del dispositivo:");

        txtEstado.setEditable(false);
        txtEstado.setForeground(new java.awt.Color(51, 51, 255));
        txtEstado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Versión de protocolo:");

        txtVersion.setEditable(false);
        txtVersion.setForeground(new java.awt.Color(51, 51, 255));
        txtVersion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha:");

        txtFecha.setEditable(false);
        txtFecha.setForeground(new java.awt.Color(51, 51, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Hora:");

        txtHora.setEditable(false);
        txtHora.setForeground(new java.awt.Color(51, 51, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Temperatura:");

        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Humedad:");

        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Gases Peligrosos:");

        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Iluminación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
                                                        Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbGases, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(prbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(prbHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10))
                                        .addComponent(prbGases, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prbIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        //Se quito la piel ninbus por que no permite cambiar los colores en los componentes JProgressBar

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIAPPLite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JProgressBar prbGases;
    private javax.swing.JProgressBar prbHumedad;
    private javax.swing.JProgressBar prbIluminacion;
    private javax.swing.JProgressBar prbTemperatura;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtVersion;
    // End of variables declaration//GEN-END:variables
}
