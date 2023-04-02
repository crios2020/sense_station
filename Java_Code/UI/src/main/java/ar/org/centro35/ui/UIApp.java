package ar.org.centro35.ui;

/**
 * UI para Version del protocolo 1
 * @author carlos
 */
public class UIApp extends javax.swing.JFrame {

    public UIApp() {
        initComponents();
        
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        //inicializador de fecha y hora
        new Thread(new HoraThread(txtFecha,txtHora)).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIncli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTemp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMQ5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMQ7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRuido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLlama = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtLuz = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAvoid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estación de Sensado");
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Fecha: ");

        txtFecha.setEditable(false);
        txtFecha.setForeground(new java.awt.Color(0, 153, 51));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("Hora:");

        txtHora.setEditable(false);
        txtHora.setForeground(new java.awt.Color(0, 153, 51));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Versión de protocolo:");

        txtProto.setEditable(false);
        txtProto.setForeground(new java.awt.Color(0, 153, 51));
        txtProto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("Inclinación:");

        txtIncli.setEditable(false);
        txtIncli.setForeground(new java.awt.Color(0, 153, 51));
        txtIncli.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Temperatura:");

        txtTemp.setEditable(false);
        txtTemp.setForeground(new java.awt.Color(0, 153, 51));
        txtTemp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("Humedad:");

        txtHum.setEditable(false);
        txtHum.setForeground(new java.awt.Color(0, 153, 51));
        txtHum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setText("MQ5 (Gas):");

        txtMQ5.setEditable(false);
        txtMQ5.setForeground(new java.awt.Color(0, 153, 51));
        txtMQ5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setText("MQ7(Monoxido de Carbono)");

        txtMQ7.setEditable(false);
        txtMQ7.setForeground(new java.awt.Color(0, 153, 51));
        txtMQ7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel9.setForeground(new java.awt.Color(0, 153, 51));
        jLabel9.setText("Evento de ruido:");

        txtRuido.setEditable(false);
        txtRuido.setForeground(new java.awt.Color(0, 153, 51));
        txtRuido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("Sensor de Llama:");

        txtLlama.setEditable(false);
        txtLlama.setForeground(new java.awt.Color(0, 153, 51));
        txtLlama.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setText("Iluminación:");

        txtLuz.setEditable(false);
        txtLuz.setForeground(new java.awt.Color(0, 153, 51));
        txtLuz.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel12.setForeground(new java.awt.Color(0, 153, 51));
        jLabel12.setText("Obstáculos:");

        txtAvoid.setEditable(false);
        txtAvoid.setForeground(new java.awt.Color(0, 153, 51));
        txtAvoid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 51));
        jLabel13.setText("Sense Station");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtProto, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtMQ5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtRuido, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtLuz, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIncli, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHum, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMQ7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLlama, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAvoid, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(txtProto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIncli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMQ5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMQ7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRuido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLlama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLuz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAvoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAvoid;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtHum;
    private javax.swing.JTextField txtIncli;
    private javax.swing.JTextField txtLlama;
    private javax.swing.JTextField txtLuz;
    private javax.swing.JTextField txtMQ5;
    private javax.swing.JTextField txtMQ7;
    private javax.swing.JTextField txtProto;
    private javax.swing.JTextField txtRuido;
    private javax.swing.JTextField txtTemp;
    // End of variables declaration//GEN-END:variables
}
