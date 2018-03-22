package clases;

import static clases.interfazPrincipal.panel;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author USRFENIX0103
 */
public class compras extends javax.swing.JInternalFrame {
    sSql sql = new sSql();
    compras cmpr;
    
    public compras() {
        initComponents();
        try{
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        libroCompras = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compras");

        jMenu1.setText("Reportes");

        libroCompras.setText("Libro de Compras");
        libroCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libroComprasActionPerformed(evt);
            }
        });
        jMenu1.add(libroCompras);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void libroComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libroComprasActionPerformed
        selectorFecha sf = new selectorFecha();
        interfazPrincipal.panel.add(sf);
        sf.toFront();
        sf.setVisible(true);
        Dimension desktopSize = panel.getSize();
        Dimension FrameSize = sf.getSize();
        sf.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        sf.show();
    }//GEN-LAST:event_libroComprasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem libroCompras;
    // End of variables declaration//GEN-END:variables
}
