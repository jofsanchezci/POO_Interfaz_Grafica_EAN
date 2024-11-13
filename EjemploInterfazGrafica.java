import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploInterfazGrafica extends JFrame {

    public EjemploInterfazGrafica() {
        // Configuración básica de la ventana
        setTitle("Ejemplo de Interfaz Gráfica en Java");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear componentes
        JLabel etiqueta = new JLabel("¡Haz clic en el botón!", SwingConstants.CENTER);
        JButton boton = new JButton("Clic aquí");

        // Configurar layout de la ventana
        setLayout(new BorderLayout());
        add(etiqueta, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        // Añadir acción al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("¡Botón presionado!");
            }
        });
    }

    public static void main(String[] args) {
        // Crear y mostrar la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EjemploInterfazGrafica ventana = new EjemploInterfazGrafica();
                ventana.setVisible(true);
            }
        });
    }
}
