import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleUnaryOperator;

public class GraficadorFuncionesSwing extends JFrame {

    private JComboBox<String> comboFunciones;
    private JTextField campoParametros;
    private JPanel panelGrafico;

    public GraficadorFuncionesSwing() {
        setTitle("Graficador de Funciones Matemáticas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        comboFunciones = new JComboBox<>(new String[]{"Lineal", "Polinómica", "Exponencial", "Trigonométrica (Seno)"});
        campoParametros = new JTextField(20);
        JButton botonGraficar = new JButton("Graficar");

        JPanel panelControl = new JPanel();
        panelControl.add(new JLabel("Tipo de función:"));
        panelControl.add(comboFunciones);
        panelControl.add(new JLabel("Parámetros:"));
        panelControl.add(campoParametros);
        panelControl.add(botonGraficar);

        panelGrafico = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                graficarFuncion(g);
            }
        };
        panelGrafico.setBackground(Color.WHITE);

        add(panelControl, BorderLayout.NORTH);
        add(panelGrafico, BorderLayout.CENTER);

        botonGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGrafico.repaint();
            }
        });
    }

    private DoubleUnaryOperator obtenerFuncion(String tipoFuncion, String parametros) {
        switch (tipoFuncion) {
            case "Lineal":
                double pendiente = Double.parseDouble(parametros.split(",")[0]);
                double intercepto = Double.parseDouble(parametros.split(",")[1]);
                return x -> pendiente * x + intercepto;
            case "Polinómica":
                double a = Double.parseDouble(parametros.split(",")[0]);
                double b = Double.parseDouble(parametros.split(",")[1]);
                double c = Double.parseDouble(parametros.split(",")[2]);
                return x -> a * x * x + b * x + c;
            case "Exponencial":
                double base = Double.parseDouble(parametros);
                return x -> Math.pow(base, x);
            case "Trigonométrica (Seno)":
                double frecuencia = Double.parseDouble(parametros);
                return x -> Math.sin(frecuencia * x);
            default:
                throw new IllegalArgumentException("Función no soportada");
        }
    }

    private void graficarFuncion(Graphics g) {
        String tipoFuncion = (String) comboFunciones.getSelectedItem();
        String parametros = campoParametros.getText();

        DoubleUnaryOperator funcion;
        try {
            funcion = obtenerFuncion(tipoFuncion, parametros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Parámetros inválidos. Por favor, verifica el formato.");
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = panelGrafico.getWidth();
        int height = panelGrafico.getHeight();
        int originX = width / 2;
        int originY = height / 2;

        g2.setColor(Color.LIGHT_GRAY);
        g2.drawLine(0, originY, width, originY); // Eje X
        g2.drawLine(originX, 0, originX, height); // Eje Y

        g2.setColor(Color.BLUE);

        for (int i = -originX; i < originX; i++) {
            double x = i / 50.0; // Escalamos para mostrar más rango de valores en el eje X
            double y = funcion.applyAsDouble(x);
            int screenX = originX + i;
            int screenY = originY - (int) (y * 50); // Escalamos para mostrar más rango de valores en el eje Y

            if (screenX >= 0 && screenX < width && screenY >= 0 && screenY < height) {
                g2.fillRect(screenX, screenY, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraficadorFuncionesSwing graficador = new GraficadorFuncionesSwing();
            graficador.setVisible(true);
        });
    }
}
