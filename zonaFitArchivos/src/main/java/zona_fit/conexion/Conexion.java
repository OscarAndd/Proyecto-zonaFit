package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/*ESTA CLASE PERMITIRA HACER UNA CONEXION ENTRE JAVA Y MySQL, LOS PARAMETROS
SOLICITADOS SE ENCUENTRAN EL LOS DETALLES DE LA BASE DE DATOS QUE TENGAMOS EN MYSQL*/
public class Conexion {
    public static Connection getConexion(){
        Connection conexion=null;
        var nombre_DB="zona_fit_db";
        var url="jdbc:mysql://localhost:3306/"+nombre_DB;//CADENA DE CONEXION QUE INCLUYE LOS DATOS:
                                                         //UNA CADENA CONSTANTE=jdbc:mysql
                                                         //DELA BASE DE DATOS, COMO LA IP=LOCALHOST
                                                         //EL PUERTO:3306 Y EL NOMBRE DE LA DB
        //CADA BASE DE DATOS TIENE SU CADENA DE CONEXION, SE DEBE BUSCAR DEPENDIENDO DEL GESTOR DE BD
        var usuario="root";
        var password="1023OscarMySQL";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//CLASE DE CONEXIOM "RUTA DEL DRIVER DE MYSQL"
            conexion= DriverManager.getConnection(url,usuario,password);//INTENTA CONECTARSE A BD
        }
        catch (Exception e){
            System.out.println("Error al conectar con base de datos"+e);
        }
    return conexion;

    }
}
