import java.util.ArrayList;

public class InventarioBiblioteca {
    private ArrayList<Libro> inventario;

    public InventarioBiblioteca() {
        inventario = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        inventario.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        inventario.remove(libro);
    }

    public ArrayList<Libro> obtenerInventario() {
        return inventario;
    }
}
