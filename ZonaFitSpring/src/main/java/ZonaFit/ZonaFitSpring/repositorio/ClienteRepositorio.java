package ZonaFit.ZonaFitSpring.repositorio;

import ZonaFit.ZonaFitSpring.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//ESTA INTERFAZ EXTENDERA DE LA INTERFAZ JpaRepository LA CUAL CONTIENE LOS METODOS CRUD
// NECESARIOS PARA EL FUNCIONAMIENTO. SpringBoot LO HACE DE MANERA AUTOMATICA Y
//LOS GENERICOS QUE RECIBE SON Cliente: CLASE MARCADA CON @entity O LA CLASE DE LOS DATOS/MODELO Y ADEMAS
//RECIBE EL TIPO DE DATO DE LA LLAVE PRIMARIA DE LA MISMA CLASE.
public interface ClienteRepositorio extends JpaRepository <Cliente,Integer> {
    //AL SER DE UN GENERICO JpaRepository SE DEBE PROPORCIONAR LA CLASE QUE CONTIENE
    //EL ORM=OBJECT RELATIONAL MAPPING Y EL TIPO DE DATO DE LA LLAVE PRIMARIA
}
