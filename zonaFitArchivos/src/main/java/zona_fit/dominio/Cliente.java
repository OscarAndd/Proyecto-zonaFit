package zona_fit.dominio;

import java.util.Objects;

/*EN ESTA CLASE HAREMOS UN MAPEO DE 1 A 1 DE TODOS LOS ATRIBUTOS O VALORES QUE CONTENGA
* LA BASE DE DATOS, ESTO ES, CREAR LAS MISMA VARIABLES O ATRIBUTOS QUE ESTEN DEFINIDAS EN
* NUESTRA TABLA DE DB. TAMBIEN SE CONOCE COMO ORM=OBJECT RELATIONAL MAPPING*/
public class Cliente {
    private  int id;
    private String nombre;
    private String apellido;
    private int membresia;

    //CONSTRUCTORES
    public Cliente(){}

    public Cliente(int id){
        this.id=id;
    }

    public Cliente(String nombre, String apellido, int membresia){
        this.nombre=nombre;
        this.apellido=apellido;
        this.membresia=membresia;
    }

    public Cliente(int id, String nombre, String apellido, int membresia){
        this(nombre,apellido,membresia);
        this.id=id;
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    //toString

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", membresia=" + membresia +
                '}';
    }

    //EQUALS AND HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente dominio = (Cliente) o;
        return id == dominio.id && membresia == dominio.membresia && Objects.equals(nombre, dominio.nombre) && Objects.equals(apellido, dominio.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, membresia);
    }
}
