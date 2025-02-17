package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuZonaFit {
    public void mostrarClientes(ClienteDAO crud){
        List<Cliente> listaClientes=new ArrayList<>();
        listaClientes=crud.listarClientes();
        listaClientes.forEach(System.out::println);
    }
    public void clienteID(Scanner entrada,ClienteDAO crud,Cliente cliente){
        System.out.println("ingrese el id a consultar");
        var id=Integer.parseInt(entrada.nextLine());
        Cliente clienteID=new Cliente(id);
        crud.buscarClientePorId(clienteID);
        System.out.println(clienteID);
    }
    public void agregarCliente(Scanner entrada,ClienteDAO crud){
        System.out.println("ingrese el id del nuevo cliente");
        var id=Integer.parseInt(entrada.nextLine());
        System.out.println("ingrese el nombre del nuevo cliente");
        var nombre=entrada.nextLine();
        System.out.println("ingrese el apellido del nuevo cliente");
        var apellido=entrada.nextLine();
        System.out.println("ingrese el numero de membresia del nuevo cliente");
        var membresia=Integer.parseInt(entrada.nextLine());
        crud.agregarCliente(new Cliente(id,nombre,apellido,membresia));
    }
    public void actualizarCliente(Scanner entrada, ClienteDAO crud){
        System.out.println("ingrese el id del cliente");
        var id=Integer.parseInt(entrada.nextLine());
        System.out.println("ingrese el nuevo nombre");
        var nombre=entrada.nextLine();
        System.out.println("ingrese el nuevo apellido ");
        var apellido=entrada.nextLine();
        System.out.println("ingrese el nuevo numero de membresia");
        var membresia=Integer.parseInt(entrada.nextLine());
        crud.modificarCliente(new Cliente(id,nombre,apellido,membresia));
    }
    public void eliminarCliente(Scanner entrada, ClienteDAO crud){
        System.out.println("Ingrese el id del cliente a eliminar");
        var id=Integer.parseInt(entrada.nextLine());
        crud.eliminarCliente(new Cliente(id));
    }
    public void manejoDeClientes(Scanner entrada,ClienteDAO crud,Cliente cliente){
        var seleccion=0;
        try {
            while(seleccion!=6){
                seleccion=menu(entrada);
                switch (seleccion){
                    case 1 -> mostrarClientes(crud);
                    case 2 -> clienteID(entrada,crud,cliente);
                    case 3 -> agregarCliente(entrada,crud);
                    case 4 -> actualizarCliente(entrada,crud);
                    case 5 -> eliminarCliente(entrada,crud);
                }
            }

        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
    }
    public int menu(Scanner entrada){
        System.out.println("""
                BIENVENIDO A ZONA FIT
                A CONTINUACION INDICA LA OPERACION A REALIZAR:
                1)LISTAR CLIENTES
                2)MOSTRAR CLIENTE POR ID
                3)AGREGAR CLIENTE
                4)ACTUALIZAR CLIENTE
                5)ELIMINAR CLIENTE
                6)SALIR
                """);
        return Integer.parseInt(entrada.nextLine());
    }

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        ClienteDAO crud=new ClienteDAO();
        Cliente cliente=new Cliente();
        menuZonaFit funcionalidad=new menuZonaFit();
        funcionalidad.manejoDeClientes(entrada,crud,cliente);
        System.out.println("Vuelva pronto");

    }
}
