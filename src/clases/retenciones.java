package clases;

import conexion.conectar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author USRFENIX0103
 */
public class retenciones extends javax.swing.JInternalFrame {
sSql txt = new sSql();
conectar cn = new conectar(); 

    public retenciones() {        
        initComponents();
        Calendar calendario = new GregorianCalendar();
        fecha1.setCalendar(calendario);
        fecha2.setCalendar(calendario);
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCPanel1 = new com.bolivia.panel.JCPanel();
        fecha2 = new com.toedter.calendar.JDateChooser();
        fecha1 = new com.toedter.calendar.JDateChooser();
        generaTXT = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione las fechas para generar el txt de Retencion de Iva");

        jCPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jCPanel1.setFirstColor(new java.awt.Color(0, 0, 102));
        jCPanel1.setSecondColor(new java.awt.Color(255, 255, 255));
        jCPanel1.setUseMode(com.bolivia.panel.USEMODE.TRANSPARENCY);
        jCPanel1.setVisibleLogo(false);

        fecha2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha2.setMaxSelectableDate(new java.util.Date(253370782880000L));

        fecha1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha1.setMaxSelectableDate(new java.util.Date(253370782919000L));

        generaTXT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generaTXT.setText("Generar txt");
        generaTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaTXTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jCPanel1Layout = new javax.swing.GroupLayout(jCPanel1);
        jCPanel1.setLayout(jCPanel1Layout);
        jCPanel1Layout.setHorizontalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jCPanel1Layout.createSequentialGroup()
                        .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(generaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jCPanel1Layout.setVerticalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jCPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaTXTActionPerformed
        try{
            SimpleDateFormat forma = new SimpleDateFormat("yyyy/dd/MM");
            SimpleDateFormat forma2 = new SimpleDateFormat("yyyy/dd/MM");
            Date fec1 = fecha1.getDate();
            Date fec2 = fecha2.getDate();
            String miFecha = forma.format(fec1);
            String miFecha2 = forma2.format(fec2);
            boolean res = txt.generaTXT(miFecha,miFecha2);
            if (res == true) {
                JOptionPane.showMessageDialog(null, "El archivo se genero con exito","PROCESADO",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_generaTXTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fecha1;
    private com.toedter.calendar.JDateChooser fecha2;
    private javax.swing.JButton generaTXT;
    private com.bolivia.panel.JCPanel jCPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}