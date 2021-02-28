package Modelo;

//import java.awt.List;
import java.util.List;

public interface CRUD {

    public List listar();

    public int add(Object[] o);

    public int actualizar(Object[] o);

    public void eliminar(int id);

}
