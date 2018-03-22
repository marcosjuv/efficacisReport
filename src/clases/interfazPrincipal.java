package clases;

import conexion.conectar;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author USRFENIX0103
 */
public class interfazPrincipal extends javax.swing.JFrame {
    conectar cnx = new conectar();
    
    selectorFechaVentas slv;
    selectorFechaRV sfrv;
    retenciones rtn;
    selectorFecha slf;
    listaRetenciones listaR;
    String mensaje = "La ventana ya esta abierta";
    /**
     * Creates new form interfazPrincipal
     */
    public interfazPrincipal() {
        try{
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
            cnx.getInstancia();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public boolean estacerrado(Object obj){
    JInternalFrame[] activos=panel.getAllFrames();
    boolean cerrado=true;
    int i=0;
    while (i<activos.length && cerrado){
	if(activos[i]==obj){
		cerrado=false;
	}
	i++;
    }
    return cerrado;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        libroCompras = new javax.swing.JMenuItem();
        relacionCompras = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        libroVentas = new javax.swing.JMenuItem();
        relacionVentas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        consultaRetenciones = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        estadisticaCV = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenu();
        salirSistema = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de consultas  optimizadas de Efficacis3");
        setExtendedState(6);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setMinimumSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        jMenu.setText("Compras");

        libroCompras.setText("Libro de Compras");
        libroCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libroComprasActionPerformed(evt);
            }
        });
        jMenu.add(libroCompras);

        relacionCompras.setText("Relacion de Compras");
        jMenu.add(relacionCompras);

        jMenuBar1.add(jMenu);

        jMenu1.setText("Ventas");

        libroVentas.setText("Libro de Ventas");
        libroVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libroVentasActionPerformed(evt);
            }
        });
        jMenu1.add(libroVentas);

        relacionVentas.setText("Relacion de Ventas");
        relacionVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacionVentasActionPerformed(evt);
            }
        });
        jMenu1.add(relacionVentas);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Retencion");

        jMenuItem2.setText("Generar txt");
        jMenuItem2.setActionCommand("abreVtnTXT");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaTXTActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        consultaRetenciones.setText("Consulta de Retenciones");
        consultaRetenciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaRetencionesActionPerformed(evt);
            }
        });
        jMenu2.add(consultaRetenciones);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Gerencial");

        estadisticaCV.setText("Estadisticas de Compra y Venta");
        jMenu3.add(estadisticaCV);

        jMenuBar1.add(jMenu3);

        salir.setText("Sistema");

        salirSistema.setText("Salir");
        salirSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirSistemaActionPerformed(evt);
            }
        });
        salir.add(salirSistema);

        jMenuBar1.add(salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void libroComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libroComprasActionPerformed
        if (estacerrado(slf)) {
            slf = new selectorFecha();
            panel.add(slf);
            Dimension desktopSize = panel.getSize();
            Dimension FrameSize = slf.getSize();
            slf.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            slf.show();
        } else {
            JOptionPane.showMessageDialog(this,mensaje);
        }
    }//GEN-LAST:event_libroComprasActionPerformed

    private void generaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaTXTActionPerformed
        if (estacerrado(rtn)) {
            rtn = new retenciones();
            panel.add(rtn);
            Dimension desktopSize = panel.getSize();
            Dimension FrameSize = rtn.getSize();
            rtn.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            rtn.show();
        } else {
            JOptionPane.showMessageDialog(this,mensaje);
        }
    }//GEN-LAST:event_generaTXTActionPerformed

    private void salirSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirSistemaActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de salir del sistema?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) {
            System.exit(0);
        } 
    }//GEN-LAST:event_salirSistemaActionPerformed

    private void relacionVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacionVentasActionPerformed
        if (estacerrado(sfrv)) {
            sfrv = new selectorFechaRV();
            panel.add(sfrv);
            Dimension desktopSize = panel.getSize();
            Dimension FrameSize = sfrv.getSize();
            sfrv.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            sfrv.show();
        } else {
            JOptionPane.showMessageDialog(this,mensaje);
        }
    }//GEN-LAST:event_relacionVentasActionPerformed

    private void libroVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libroVentasActionPerformed
        // TODO add your handling code here:
        if (estacerrado(slv)) {
            slv = new selectorFechaVentas();
            panel.add(slv);
            Dimension desktopSize = panel.getSize();
            Dimension FrameSize = slv.getSize();
            slv.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            slv.show();
        } else {
            JOptionPane.showMessageDialog(this,mensaje);
        }
    }//GEN-LAST:event_libroVentasActionPerformed

    private void consultaRetencionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaRetencionesActionPerformed
         if (estacerrado(listaR)) {
            listaR = new listaRetenciones();
            panel.add(listaR);
            Dimension desktopSize = panel.getSize();
            Dimension FrameSize = listaR.getSize();
            listaR.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            listaR.show();
        } else {
            JOptionPane.showMessageDialog(this,mensaje);
        }
    }//GEN-LAST:event_consultaRetencionesActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new interfazPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem consultaRetenciones;
    private javax.swing.JMenuItem estadisticaCV;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem libroCompras;
    private javax.swing.JMenuItem libroVentas;
    public static javax.swing.JDesktopPane panel;
    private javax.swing.JMenuItem relacionCompras;
    private javax.swing.JMenuItem relacionVentas;
    private javax.swing.JMenu salir;
    private javax.swing.JMenuItem salirSistema;
    // End of variables declaration//GEN-END:variables
}
