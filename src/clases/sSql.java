package clases;

import com.opencsv.CSVWriter;
import conexion.conectar;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USRFENIX0103
 */
public class sSql {

    conectar con = new conectar();
    String fecha;
    private String url;
    private String usuario;    
    private String pass;
    
    public String getUsuario() {
        return usuario;
    }

    public String getUrl() {
        return url;
    }

    public String getPass() {
        return pass;
    }
    // constructor de la clase
    public sSql() {
        Date catchFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formato.format(catchFecha);
    }
    //verifica que el archivo config.txt exista, caso contrario abrira la ventana de cargar conexion
    public static Object checkConfig(){             
        try{
            String ruta = "C:\\Users\\"+getUser()+"\\Documents\\NetBeansProjects\\efficacisReport\\config.txt";
            File file = new File(ruta);  
        if (file.exists()) {
           interfazPrincipal vent = new interfazPrincipal();
           vent.setVisible(true);           
        } else {           
           cargaConexion ventCC = new cargaConexion();
           ventCC.setVisible(true);
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    public String getFecha() {
        return fecha;
    }
    //Metodo que Obtiene el nombre de la maquina o host Ej: ESTFENIX0103
    public String getHost(){
        String hostName = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostName = address.getHostName();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return hostName;
    }
    //Obtiene el nombre de usuario que inicio sesion en la maquina Ej: USRFENIX0103
    public static String getUser(){
        String user = "";
        try {
            user = System.getProperty("user.name");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
    
    // genera el libro de compras
    public void reporteLibroCompras(String fdesde, String fhasta) {

        try {
            Map param = new HashMap();
            param.clear();
            param.put("fechaDesde", fdesde);
            param.put("fechaHasta", fhasta);

            String dir = "src\\reportes\\libroCompras.jrxml";
            File raiz = new File(dir);
            String ruta = "libroCompras.pdf";
            File libroCompras = new File(ruta);
            
            JFileChooser file=new JFileChooser(System.getProperty("user.home"));
            file.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.pdf", "pdf", "PDF"));
            file.setSelectedFile(libroCompras);
            int guarda = file.showSaveDialog(null);
            
            
            if(guarda == JFileChooser.APPROVE_OPTION){                
                 libroCompras = new File(file.getSelectedFile().toString());
                 if (libroCompras.exists()) {
                    int res = JOptionPane.showConfirmDialog(null, "¿Desea reemplazarlo?", "El archivo ya existe", JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        JasperReport reportes = JasperCompileManager.compileReport(raiz.toString());
                        JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
                        JasperExportManager.exportReportToPdfFile(print, libroCompras.toString());
                        JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                        }
                 }else{
                  JasperReport reportes = JasperCompileManager.compileReport(raiz.toString());
                  JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
                  JasperExportManager.exportReportToPdfFile(print, libroCompras.toString());
                  JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                 }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al guardar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    // genera el libro de compras con fecha menor a septiembre 2017 cuando no se manejaban 3 impuestos
    public void reporteLibroComprasII(String fdesde, String fhasta) {
        try {
            Map param = new HashMap();
            param.clear();
            param.put("fechaDesde", fdesde);
            param.put("fechaHasta", fhasta);
            
            String dir = "src\\reportes\\libroComprasII.jrxml";
            File raiz = new File(dir);
            String ruta = "libroCompras.pdf";
            File libroCompras = new File(ruta);           
            
            JFileChooser file=new JFileChooser(System.getProperty("user.home"));
            file.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.pdf", "pdf", "PDF"));
            file.setSelectedFile(libroCompras);
            int guarda = file.showSaveDialog(null);
            
            if (guarda == JFileChooser.APPROVE_OPTION) {
                libroCompras = new File(file.getSelectedFile().toString());
                if (libroCompras.exists()) {
                    int res = JOptionPane.showConfirmDialog(null, "¿Desea reemplazarlo?", "El archivo ya existe", JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        JasperReport reportes = JasperCompileManager.compileReport(raiz.toString());
                        JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
                        JasperExportManager.exportReportToPdfFile(print, libroCompras.toString());
                        JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JasperReport reportes = JasperCompileManager.compileReport(raiz.toString());
                    JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
                    JasperExportManager.exportReportToPdfFile(print, libroCompras.toString());
                    JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al guardar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
            JasperReport reportes = JasperCompileManager.compileReport(dir);
            JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
            JasperExportManager.exportReportToPdfFile(print, ruta);
            JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    // genera libro de ventas
    public void reporteLibroVentas(String fdesde, String fhasta) {
        try {
            Map param = new HashMap();
            param.clear();
            param.put("fechaDesde", fdesde);
            param.put("fechaHasta", fhasta);

            String dir = "C:\\Users\\usrfenix0103\\Documents\\NetBeansProjects\\efficacisReport\\src\\reportes\\relacionVentas.jrxml";
            String ruta = "C:\\Users\\usrfenix0103\\Documents\\NetBeansProjects\\efficacisReport\\src\\reportes\\libroVentas.pdf";
            JasperReport reportes = JasperCompileManager.compileReport(dir);
            JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
            JasperExportManager.exportReportToPdfFile(print, ruta);
            JasperViewer jviewer = new JasperViewer(print, false);
            jviewer.setTitle("Libro de Ventas");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    // genera TXT seniat
    public boolean generaTXT(String fdesde, String fhasta) {
        String fec = getFecha();
        try {
            ResultSet rs = con.consulta("select "
                    + "REPLACE(NuRIFCia,'-',''),"
                    + "CONVERT(VARCHAR(6),dbo.sfAA_FechaSQL(FeEmisDoc),112),"
                    + "CONVERT(VARCHAR(10),dbo.sfAA_FechaSQL(FeEmisDoc),120),"
                    + "case when TpDoc = 01 then 'C' end,"
                    + "TpDoc,"
                    + "NuRIF,"
                    + "NuDocComVen,"
                    + "NuCntrlImpto,"
                    + "MnDoc,"
                    + "MnBaseImptoML,"
                    + "MnImptoReten,"
                    + "CASE WHEN NuDocComVen <> NULL THEN 0 ELSE 0 END,"
                    + "NuComprob,"
                    + "MnExcentoIVA,"
                    + "Potarifaimpto,"
                    + "case when NuExpedienteImportac = null then 0 else NuExpedienteImportac end "
                    + "from AACompan INNER JOIN"
                    + " ImCmRetIvaCo ON ImCmRetIvaCo.Cocia = AACompan.CoCia INNER JOIN"
                    + " ImCmRetIvaCoDe ON ImCmRetIvaCo.Secuencia = ImCmRetIvaCoDe.Secuencia INNER JOIN"
                    + " CoMovimi ON CoMovimi.NuRefDocCom = ImCmRetIvaCoDe.NuDocComVen INNER JOIN"
                    + " CoProvee ON CoProvee.Coproveedor = CoMovimi.Coproveedor "
                    + "WHERE "
                    + "FeEmisDoc BETWEEN dbo.sfAA_FechaClarion('" + fdesde + "') AND dbo.sfAA_FechaClarion('" + fhasta + "')");            

            String ruta = "RET_IVA_" + fec + ".txt";
            File miArchivo = new File(ruta);
            JFileChooser file = new JFileChooser();
            file.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.txt", "txt", "TXT"));
            file.setSelectedFile(miArchivo);
            int selec = file.showSaveDialog(null);
            if (selec == JFileChooser.APPROVE_OPTION) {
                miArchivo = new File(file.getSelectedFile().toString());
                if (miArchivo.exists()) {
                    int res = JOptionPane.showConfirmDialog(null, "¿Desea reemplazarlo?", "El archivo ya existe", JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        try (CSVWriter csvOutput = new CSVWriter(new FileWriter(miArchivo, false), '\t')) {
                            csvOutput.writeAll(rs, false, true, false);
                        }
                    }
                } else {
                    try (CSVWriter csvOutput = new CSVWriter(new FileWriter(miArchivo, false), '\t')) {
                        csvOutput.writeAll(rs, false, true, false);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al guardar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    // genera libro de relacion de ventas
    public void relacionVentas(String fechaInicial, String fechaFinal){
        try {
            Map param = new HashMap();
            param.clear();
            param.put("fechaInicial", fechaInicial);
            param.put("fechaFinal", fechaFinal);
            
            String dir = "src\\reportes\\relacionVentas.jrxml";
            File raiz = new File(dir);
            String ruta = "relacionVentas.pdf";
            File libro = new File(ruta);
            
            JFileChooser file=new JFileChooser(System.getProperty("user.home"));
            file.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.pdf", "pdf", "PDF"));
            file.setSelectedFile(libro);
            int guarda = file.showSaveDialog(null);
            
            if (guarda == JFileChooser.APPROVE_OPTION) {
                libro = new File(file.getSelectedFile().toString());
                if (libro.exists()) {
                    int res = JOptionPane.showConfirmDialog(null, "¿Desea reemplazarlo?", "El archivo ya existe", JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        JasperReport reportes = JasperCompileManager.compileReport(raiz.toString());
                        JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
                        JasperExportManager.exportReportToPdfFile(print, libro.toString());
                        JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                        JasperReport reportes = JasperCompileManager.compileReport(raiz.toString());
                        JasperPrint print = JasperFillManager.fillReport(reportes, param, con.getConexion());
                        JasperExportManager.exportReportToPdfFile(print, libro.toString());
                        JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al guardar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
