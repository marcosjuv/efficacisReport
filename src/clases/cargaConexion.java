
package clases;

import java.io.FileWriter;
import java.sql.*;
import javax.swing.JOptionPane;
import conexion.conectar;
import java.io.File;

public class cargaConexion extends javax.swing.JFrame {

    static sSql sql = new sSql();
    conectar cn = new conectar();
    static Connection conectate = null;
    Statement st;
    ResultSet rs;
   
    
    public cargaConexion() {
        initComponents();
        setLocationRelativeTo(null);
        txtPort.setText("1433");
        
    }
    
    //Metodo que obtiene la URL de conexion Ej: jdbc:sqlserver://ESTFENIX0103:1433;databaseName=efficacis3
    public String getURL(String puerto,String bd){
        String host = sql.getHost();
        String url = "jdbc:sqlserver://";
        return url+host+":"+puerto+";databaseName="+bd;
    }    
    
    //genera el archivo config.txt que contiene la instansia de conexion
    private boolean escribirInstancia(String strRuta, String strTexto){
        try {
            File archivo = new File(strRuta);
            FileWriter escribir = new FileWriter(archivo, false);
            escribir.write(strTexto);
            escribir.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCPanel1 = new com.bolivia.panel.JCPanel();
        txtbd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnprobarConexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parametros de Conexión");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Introduzca los parametros para la conexion");

        jCPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jCPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        jCPanel1.setUseMode(com.bolivia.panel.USEMODE.TRANSPARENCY);
        jCPanel1.setVisibleLogo(false);

        txtbd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtbd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Base de Datos:");

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        txtClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtClave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Clave:");

        txtPort.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPort.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Puerto:");

        javax.swing.GroupLayout jCPanel1Layout = new javax.swing.GroupLayout(jCPanel1);
        jCPanel1.setLayout(jCPanel1Layout);
        jCPanel1Layout.setHorizontalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbd, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(txtClave)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPort))
                .addContainerGap())
        );

        jCPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        jCPanel1Layout.setVerticalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jCPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtClave, txtPort, txtUsuario, txtbd});

        jCPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        btnprobarConexion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnprobarConexion.setText("generar instancia de conexion");
        btnprobarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprobarConexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            .addComponent(jCPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnprobarConexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnprobarConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprobarConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprobarConexionActionPerformed
        try {                
                if (txtbd.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtClave.getText().isEmpty() || txtPort.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios","ERROR",JOptionPane.ERROR_MESSAGE);
            } else {
                    String ruta = "C:\\Users\\"+sql.getUser()+"\\Documents\\NetBeansProjects\\efficacisReport\\config.txt";
                    String db = txtbd.getText();
                    String port = txtPort.getText();
                    String url = getURL(port, db);
                    String user = txtUsuario.getText();
                    String pass = txtClave.getText();
                boolean run = escribirInstancia(ruta,url+"\r\n"+user+"\r\n"+pass);
                if (!run) {
                    JOptionPane.showMessageDialog(null, "problemas al generar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);                    
                } else {
                    JOptionPane.showMessageDialog(null, "el archivo se generó con exito","EXITO",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    interfazPrincipal IP = new interfazPrincipal();
                    IP.setVisible(true);
                    } 
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_btnprobarConexionActionPerformed

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
            java.util.logging.Logger.getLogger(cargaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cargaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cargaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cargaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//               cargaConexion var = new cargaConexion();
                 sql.checkConfig();
//                new cargaConexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnprobarConexion;
    private com.bolivia.panel.JCPanel jCPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtbd;
    // End of variables declaration//GEN-END:variables
}
