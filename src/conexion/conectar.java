package conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author USRFENIX0103
 */
public class conectar {
    static Connection conectate = null;
    static String url = "jdbc:sqlserver://";
    static String puerto = "";
    static String bd = "efficacis3";
    static String clave = "";
    static String usuario = "";    
    Statement st;
    ResultSet rs;
    
    //Metodo que Obtiene el nombre de la maquina o host Ej: ESTFENIX0103
    private String getHost(){
        String hostName = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostName = address.getHostName();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return hostName;
    }
    // Metodo que rma y obtiene la url de conexion Ej: jdbc:sqlserver://ESTFENIX0103:1433;databaseName=efficacis3
    public String getURL(){
        return url+getHost()+":"+puerto+";databaseName="+bd;
    }
    
    public String getUser(){
        String user = "";
        try {
            user = System.getProperty("user.name");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
    
    //metodo para obtener la conexion
    public Connection getConexion(){            
        try {
            //se cargan los driver para la conexion
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //se procede a ejecutar la conexion y cargar los parametros para la coenxion que son url,usuario y clave
            conectate = DriverManager.getConnection(getURL(),usuario,clave);
            if (conectate != null) {
                System.out.println("La conexion a la  base de datos "+bd+ ".listo");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuario o Clave de acceso a MSSQLSERVER incorrectos","ERROR",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conectate;
    }
        
        // obtiene la instancia con los parametros establecidos para la coenexion a la base de datos
        public String getInstancia(){
        String campo = null;
        try {
            int i = 0;
            String path = "C:\\Users\\"+getUser()+"\\Documents\\NetBeansProjects\\efficacisReport\\config.txt";
            BufferedReader read = new BufferedReader(new FileReader(path));
            while((campo = read.readLine()) != null){
                
                switch(i){                    
                    case 0:
                        url = campo;
                        break;
                    case 1:
                        usuario = campo;
                        break;
                    case 2:
                        clave = campo;
                        break;                        
                }                
                i++;                
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return campo;
    }

    
    //metodo para desconectarse    
    public void desconectar(){
        conectate = null;
        System.out.println("La conexion a la  base de datos "+bd+" a terminado");
    }
    
    public ResultSet consulta(String sql){
        try {
        st = getConexion().createStatement();       
        rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        return rs;
    }

    public static void setClave(String clave) {
        conectar.clave = clave;
    }

    public static void setUsuario(String usuario) {
        conectar.usuario = usuario;
    }
    
    
}
