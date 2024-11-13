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
