
# Graficador de Funciones Matemáticas en Java

Este proyecto es un graficador básico de funciones matemáticas, desarrollado en Java utilizando **Swing** para la interfaz gráfica. El programa permite graficar funciones lineales, polinómicas, exponenciales y trigonométricas (seno) al ingresar los parámetros correspondientes.

## Descripción del Proyecto

El sistema permite al usuario seleccionar el tipo de función, ingresar sus parámetros en el formato correcto y graficar la función en un plano cartesiano. No se utilizan bibliotecas externas, por lo que el gráfico se dibuja directamente en un `JPanel` mediante el método `paintComponent`.

### Estructura de la Aplicación

1. **Interfaz Gráfica**:
   - Un `JComboBox` para seleccionar el tipo de función (Lineal, Polinómica, Exponencial, Trigonométrica).
   - Un `JTextField` para ingresar los parámetros necesarios para cada tipo de función.
   - Un `JButton` que permite generar la gráfica al hacer clic en "Graficar".

2. **Obtención de la Función**:
   - La función seleccionada se obtiene en el método `obtenerFuncion`, que recibe el tipo de función y los parámetros.

### Formato de Parámetros

Cada tipo de función espera parámetros en un formato específico:

- **Función Lineal**: `pendiente,intercepto`
  - Ejemplo: `2,1` (donde pendiente = 2 e intercepto = 1).

- **Función Polinómica**: `a,b,c`
  - Ejemplo: `1,0,-3` (para una función de la forma `y = ax^2 + bx + c`, donde a = 1, b = 0 y c = -3).

- **Función Exponencial**: `base`
  - Ejemplo: `2` (para una función de la forma `y = base^x`, donde base = 2).

- **Función Trigonométrica (Seno)**: `frecuencia`
  - Ejemplo: `1` (para una función de la forma `y = sin(frecuencia * x)`, donde frecuencia = 1).

### Graficación en el `JPanel`

El panel donde se dibuja el gráfico (`panelGrafico`) utiliza el método `paintComponent` para representar los puntos de la función. Los valores `x` e `y` se calculan para un rango de -10 a 10, escalados para ajustarse al tamaño del panel.

### Ejecución del Código

1. Asegúrate de tener Java instalado en tu sistema.
2. Guarda el código en un archivo llamado `GraficadorFuncionesSwing.java`.
3. Compila y ejecuta el programa:
   ```bash
   javac GraficadorFuncionesSwing.java
   java GraficadorFuncionesSwing
   ```

## Uso del Programa

1. Selecciona el tipo de función en el menú desplegable.
2. Ingresa los parámetros en el formato correcto.
3. Haz clic en el botón "Graficar" para ver la función en el panel de gráficos.

### Ejemplo de uso

- Para graficar una función lineal `y = 2x + 1`, selecciona "Lineal" e ingresa `2,1` en el campo de parámetros.
- Para una función seno `y = sin(x)`, selecciona "Trigonométrica (Seno)" e ingresa `1` como frecuencia.

## Errores Comunes

- **Mensaje de parámetros inválidos**: Asegúrate de ingresar los parámetros en el formato correcto para cada tipo de función. Por ejemplo, una función lineal requiere dos valores separados por coma, mientras que una función exponencial solo necesita un valor.

## Recursos Adicionales

Para más información sobre cómo trabajar con gráficos en Java, puedes consultar la [documentación oficial de Java](https://docs.oracle.com/javase/tutorial/2d/index.html).
