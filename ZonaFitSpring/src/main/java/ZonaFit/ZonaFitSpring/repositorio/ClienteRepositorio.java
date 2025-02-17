package ZonaFit.ZonaFitSpring.repositorio;

import ZonaFit.ZonaFitSpring.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository <Cliente,Integer> {
    //AL SER DE UN GENERICO JpaRepository SE DEBE PROPORCIONAR LA CLASE QUE CONTIENE
    //EL ORM=OBJECT RELATIONAL MAPPING Y EL TIPO DE DATO DE LA LLAVE PRIMARIA
}
