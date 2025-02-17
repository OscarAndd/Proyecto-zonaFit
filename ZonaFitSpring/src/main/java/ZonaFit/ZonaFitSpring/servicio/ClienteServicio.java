package ZonaFit.ZonaFitSpring.servicio;

import ZonaFit.ZonaFitSpring.modelo.Cliente;
import ZonaFit.ZonaFitSpring.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//PARA QUE SPRING SEPA QUE ESTA CLASE USARA PARA COMUNICARSE CON LA BD
public class ClienteServicio implements IClienteServicio{

    @Autowired//INYECCION DE DEPENDENCIAS, COMUNICARSE ENTRE CLASES SIN CREAR OBJETOS
                //DE MANERA EXPLICITA
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes =clienteRepositorio.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        Cliente cliente=clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
    clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
    clienteRepositorio.delete(cliente);
    }
}
