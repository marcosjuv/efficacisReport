/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author USRFENIX0103
 */
public class selectorFechaRV extends javax.swing.JInternalFrame {

   sSql sql = new sSql();
   Calendar myCal = Calendar.getInstance();

    public selectorFechaRV() {
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

        jCPanel1 = new com.bolivia.panel.JCPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateHasta = new com.toedter.calendar.JDateChooser();
        jDateDesde = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btnProcesar = new javax.swing.JButton();

        setClosable(true);

        jCPanel1.setUseMode(com.bolivia.panel.USEMODE.TRANSPARENCY);
        jCPanel1.setVisibleLogo(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccione la fecha del libro a consultar");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Desde");

        jDateHasta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jDateDesde.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jDateDesde.setMaxSelectableDate(new java.util.Date(253370782864000L));

        jLabel4.setText("Hasta");

        btnProcesar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jCPanel1Layout = new javax.swing.GroupLayout(jCPanel1);
        jCPanel1.setLayout(jCPanel1Layout);
        jCPanel1Layout.setHorizontalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jCPanel1Layout.setVerticalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        myCal.set(2017, 9, 01);
        try {
            if (jDateDesde.getDate() == null && jDateHasta.getDate() == null) {
                JOptionPane.showMessageDialog(null, "¡¡Los campos no pueden estar vacios!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                String formato1 = jDateDesde.getDateFormatString();
                Date fDesde = jDateDesde.getDate();
                SimpleDateFormat sdf1 = new SimpleDateFormat(formato1);                
                String desde = sdf1.format(fDesde);
                
                String formato2 = jDateHasta.getDateFormatString();
                Date fHasta = jDateHasta.getDate();
                SimpleDateFormat sdf2 = new SimpleDateFormat(formato2);
                String hasta = sdf2.format(fHasta);
                
                sql.relacionVentas(desde, hasta);
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProcesarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private com.bolivia.panel.JCPanel jCPanel1;
    private com.toedter.calendar.JDateChooser jDateDesde;
    private com.toedter.calendar.JDateChooser jDateHasta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}