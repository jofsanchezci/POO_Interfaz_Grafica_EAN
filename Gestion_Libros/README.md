
# Sistema de Gestión de Inventario de Biblioteca en Java

Este proyecto es un sistema básico de gestión de inventario de una biblioteca, desarrollado en Java utilizando la biblioteca **Swing** para la interfaz gráfica. Permite agregar y eliminar libros del inventario y visualizar la lista de libros actuales.

## Descripción del Proyecto

El sistema consta de tres clases principales:

1. **Clase `Libro`**: Representa un libro en el inventario, con propiedades como el título, el autor y el ISBN.
2. **Clase `InventarioBiblioteca`**: Contiene la lógica del inventario, permitiendo agregar, eliminar y obtener la lista de libros.
3. **Clase `InterfazInventario`**: Define la interfaz gráfica, permitiendo interactuar con el inventario mediante un panel visual donde se pueden agregar o eliminar libros.

### Estructura de la Aplicación

1. **Interfaz Gráfica (Swing)**: La clase `InterfazInventario` extiende `JFrame` para crear una ventana principal con los siguientes componentes:
   - **JTextField** para ingresar el título, autor e ISBN del libro.
   - **JButton** para agregar y eliminar libros del inventario.
   - **JList** y **DefaultListModel** para mostrar la lista de libros agregados.

2. **Manejo de Eventos**: Cada botón tiene un `ActionListener` para manejar las acciones del usuario:
   - **Agregar Libro**: Verifica que los campos estén completos, luego agrega el libro al inventario y actualiza la lista.
   - **Eliminar Libro**: Elimina el libro seleccionado en la lista tanto del inventario como de la vista.

## Código Java

```java
// Clase Libro
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn;
    }
}
```

```java
// Clase InventarioBiblioteca
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
```

```java
// Clase InterfazInventario
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazInventario extends JFrame {
    private InventarioBiblioteca inventario;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaLibros;

    public InterfazInventario() {
        inventario = new InventarioBiblioteca();

        // Configuración básica de la ventana
        setTitle("Gestión de Inventario de Biblioteca");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuración de la lista de libros
        modeloLista = new DefaultListModel<>();
        listaLibros = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaLibros);

        // Campos de entrada
        JTextField campoTitulo = new JTextField(20);
        JTextField campoAutor = new JTextField(20);
        JTextField campoIsbn = new JTextField(20);

        // Botones
        JButton botonAgregar = new JButton("Agregar Libro");
        JButton botonEliminar = new JButton("Eliminar Libro");

        // Paneles
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelCampos = new JPanel(new GridLayout(3, 2));
        JPanel panelBotones = new JPanel(new FlowLayout());

        // Añadir componentes a los paneles
        panelCampos.add(new JLabel("Título:"));
        panelCampos.add(campoTitulo);
        panelCampos.add(new JLabel("Autor:"));
        panelCampos.add(campoAutor);
        panelCampos.add(new JLabel("ISBN:"));
        panelCampos.add(campoIsbn);
        
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);

        // Añadir paneles al panel principal
        panelPrincipal.add(panelCampos, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        // Acciones de los botones
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                String isbn = campoIsbn.getText();
                if (!titulo.isEmpty() && !autor.isEmpty() && !isbn.isEmpty()) {
                    Libro libro = new Libro(titulo, autor, isbn);
                    inventario.agregarLibro(libro);
                    modeloLista.addElement(libro.toString());
                    campoTitulo.setText("");
                    campoAutor.setText("");
                    campoIsbn.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
                }
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaLibros.getSelectedIndex();
                if (index != -1) {
                    modeloLista.remove(index);
                    inventario.eliminarLibro(inventario.obtenerInventario().get(index));
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un libro para eliminar.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazInventario().setVisible(true);
            }
        });
    }
}
```

## Ejecución del Programa

1. Guarda cada clase en un archivo `.java` con el nombre correspondiente (`Libro.java`, `InventarioBiblioteca.java`, `InterfazInventario.java`).
2. Compila los archivos:
   ```bash
   javac Libro.java InventarioBiblioteca.java InterfazInventario.java
   ```
3. Ejecuta el programa:
   ```bash
   java InterfazInventario
   ```

## Recursos Adicionales

Para más información sobre el uso de **Swing** en Java, puedes visitar la [documentación oficial de Java](https://docs.oracle.com/javase/tutorial/uiswing/).
