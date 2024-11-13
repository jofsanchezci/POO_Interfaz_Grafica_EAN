
# Ejemplo de Interfaz Gráfica en Java

Este proyecto es un ejemplo básico de cómo crear una interfaz gráfica en Java utilizando la biblioteca **Swing**. La aplicación muestra una ventana con un botón y una etiqueta. Al hacer clic en el botón, el texto de la etiqueta cambia.

## Descripción del Código

### Estructura de la Aplicación
- La clase `EjemploInterfazGrafica` extiende `JFrame`, que representa la ventana principal de la aplicación.
- Contiene un **JLabel** para mostrar un mensaje y un **JButton** que, al ser presionado, cambia el texto de la etiqueta.

### Componentes
1. **JFrame**: Es la ventana principal de la aplicación.
2. **JLabel**: Una etiqueta que muestra el texto "¡Haz clic en el botón!" en el centro de la ventana.
3. **JButton**: Un botón que al hacer clic cambia el texto de la etiqueta.

### Layout
Usamos el `BorderLayout` para organizar los componentes:
- La etiqueta (`JLabel`) se coloca en el centro.
- El botón (`JButton`) se coloca en la parte inferior de la ventana.

### Manejo de Eventos
Se agrega un `ActionListener` al botón para que realice una acción cuando el usuario haga clic en él. En este caso, cambia el texto de la etiqueta.

## Código Java

```java
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
```

## Ejecutar el Programa

1. Guarda el código en un archivo llamado `EjemploInterfazGrafica.java`.
2. Compila el archivo:
   ```bash
   javac EjemploInterfazGrafica.java
   ```
3. Ejecuta el programa:
   ```bash
   java EjemploInterfazGrafica
   ```

Al ejecutar el programa, aparecerá una ventana con un botón. Al hacer clic en el botón, la etiqueta cambiará su mensaje a "¡Botón presionado!".

## Recursos Adicionales
Para obtener más información sobre **Swing** en Java, puedes consultar la [documentación oficial de Java](https://docs.oracle.com/javase/tutorial/uiswing/).
