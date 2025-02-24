package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*++++++INSTRUCCIONES IMPORTANTES PARA MANEJO DE DB DESDE JAVA SIN FRAMEWORKS:++++++++
        PreparedStatement ps;//OBJ DE LA CLASE PreparedStatement para usar sus metodos
        ResultSet rs;//OBJ DE LA CLASE ResultSet para usar sus metodos
        Connection con= Conexion.getConexion();//ABRIMOS LA CONEXION CON LA BD
        var sql="SELECT * FROM cliente WHERE id=?";//INSTRUCCION SQL A EJECUTAR
        DENTRO DE UN TRY CATCH:
        ps=con.prepareStatement(sql);//PREPARA LA INSTRUCCION SQL QUE SE VA A EJECUTAR
        ps.setInt(1,cliente.getId());//SE ASIGNAN LOS PARAMETROS PENDIENTES EN SQL '?'
        rs=ps.executeQuery();//ENVIA EL REQUERIMIENTO A LA BASE DE DATOS Y DEVUELVE EL RESULTADO
* */



import static zona_fit.conexion.Conexion.getConexion;
public class ClienteDAO implements IClienteDAO{
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes=new ArrayList<>();
        PreparedStatement ps;//OBJ DE LA CLASE PreparedStatement para usar sus metodos
        ResultSet rs;//OBJ DE LA CLASE ResultSet para usar sus metodos

        Cliente prueba;//OPCIONALMENTE DE ESTA MANERA CREO UN OBJETO DE UNA CLASE

        Connection con= Conexion.getConexion();//ABRIMOS LA CONEXION CON LA BD
        var sql="SELECT * FROM cliente ORDER BY ID";//INSTRUCCION SQL A EJECUTAR
        try {
         ps=con.prepareStatement(sql);//PREPARA LA INSTRUCCION SQL QUE SE VA A EJECUTAR
         rs=ps.executeQuery();//ENVIA EL REQUERIMIENTO A LA BASE DE DATOS Y DEVUELVE EL RESULTADO
                            //DE LA OPERACION YA SEA LOS DATOS SOLICITADOS O UN ERROR, EN ESTE CASO
                            //LOS DATOS RECIBIDOS SON LAS FILAS DE LAS BASES DE DATOS
            while (rs.next()){//VOY A ITERAR MIENTRAS HAYAN FILAS POR LEER
                //CREO UN OBJETO DE LA CLASE Cliente PARA ASIGNAR LOS VALORES RECIBIDOS A LOS ATRIBUTOS
                Cliente cliente=new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);//ASIGNO A LA LISTA EL OBJETO CREADO ANTERIORMENTE
            }
        }
        catch (Exception e) {
            System.out.println("error al leer clientes" + e);
        }
        finally {
            try {
                con.close();//CERRAMOS LA CONEXION CON LA BD
            }
            catch (Exception e){
                System.out.println("Error al cerrar DB");
            }
        }
        return clientes;
    }



    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;//OBJ DE LA CLASE PreparedStatement para usar sus metodos
        ResultSet rs;//OBJ DE LA CLASE ResultSet para usar sus metodos
        Connection con= Conexion.getConexion();//ABRIMOS LA CONEXION CON LA BD
        var sql="SELECT * FROM cliente WHERE id=?";//INSTRUCCION SQL A EJECUTAR
        try {
            ps=con.prepareStatement(sql);//PREPARA LA INSTRUCCION SQL QUE SE VA A EJECUTAR
            ps.setInt(1,cliente.getId());//SE ASIGNAN LOS PARAMETROS PENDIENTES EN SQL '?'
            rs=ps.executeQuery();//ENVIA EL REQUERIMIENTO A LA BASE DE DATOS Y DEVUELVE EL RESULTADO
            //DE LA OPERACION YA SEA LOS DATOS SOLICITADOS O UN ERROR, EN ESTE CASO
            //LOS DATOS RECIBIDOS SON LAS FILAS DE LAS BASES DE DATOS
            if (rs.next()){//VOY A ITERAR MIENTRAS HAYAN FILAS POR LEER
                //CREO UN OBJETO DE LA CLASE Cliente PARA ASIGNAR LOS VALORES RECIBIDOS A LOS ATRIBUTOS
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("error al leer clientes" + e);
        }
        finally {
            try {
                con.close();//CERRAMOS LA CONEXION CON LA BD
            }
            catch (Exception e){
                System.out.println("Error al cerrar DB");
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;//OBJ DE LA CLASE PreparedStatement para usar sus metodos
        ResultSet rs;//SOLO SE UTILIZA CUANDO SE QUIEREN EXTRAER DATOS DE LA BS
        Connection con= Conexion.getConexion();//ABRIMOS LA CONEXION CON LA BD
        var sql="INSERT INTO cliente (nombre, apellido, membresia)" +"VALUES (?,?,?)";//INSTRUCCION SQL A EJECUTAR
        try {
            ps=con.prepareStatement(sql);//PREPARA LA INSTRUCCION SQL QUE SE VA A EJECUTAR
            ps.setString(1,cliente.getNombre());//SE ASIGNAN LOS PARAMETROS PENDIENTES EN SQL '?'
            ps.setString(2,cliente.getApellido());
            ps.setInt(3,cliente.getMembresia());
            ps.execute();//ENVIA EL REQUERIMIENTO A LA BASE DE DATOS
            return true;

        }
        catch (Exception e) {
            System.out.println("error al leer clientes" + e);
        }
        finally {
            try {
                con.close();//CERRAMOS LA CONEXION CON LA BD
            }
            catch (Exception e){
                System.out.println("Error al cerrar DB");
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con= getConexion();
        var instruccionSQL="UPDATE cliente SET NOMBRE=?,APELLIDO=?,MEMBRESIA=? WHERE id=?";
        try {
            ps=con.prepareStatement(instruccionSQL);
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setInt(3,cliente.getMembresia());
            ps.setInt(4,cliente.getId());
            ps.execute();
            return true;
        }
        catch (Exception e){
            System.out.println("Error al actualizar DB"+e);
        }
        finally {
            try {
            con.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion");
            }
        }

        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql="DELETE FROM cliente WHERE id=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar fila"+e);
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion");
            }
        }
        return false;
    }

    //    public static void main(String[] args) {
//        var clientes = new ClienteDAO();
//        var listaCientes=clientes.listarClientes();
//        listaCientes.forEach(System.out::println);
//    }

//        public static void main(String[] args) {
//        var clienteId=new Cliente(10);
//        var clientes = new ClienteDAO();
//        if(clientes.buscarClientePorId(clienteId))
//                System.out.println(clienteId);
//        }

//        public static void main(String[] args) {
//            var clienteId = new Cliente(10);
//            var clientes = new ClienteDAO();
//            clientes.eliminarCliente(clienteId);
//        }
}
