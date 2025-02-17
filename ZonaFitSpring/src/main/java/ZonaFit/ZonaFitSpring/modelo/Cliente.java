package ZonaFit.ZonaFitSpring.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//GENERA UNA ORM DE LA BASE DE DATOS
@Data//GENERA LOS GETTERS DE ESTA CLASE INTERNAMENTE
@NoArgsConstructor//GENERA UN CONSTRUCTOR VACIO
@AllArgsConstructor//GENERA UN CONSTRUCTOR CON TODOS LOS PARAMETROS
public class Cliente {

    @Id//DETERMINA LA COLUMNA id DE LA BD, LA CUAL ES EL SIGUIENTE ATRIBUTO
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ID AUTOINCREMENTABLE
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer membresia;
}
