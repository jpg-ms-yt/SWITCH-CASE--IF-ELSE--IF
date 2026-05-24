import javax.swing.*;
import java.awt.*;

public class Programa3Calculadora extends JFrame {

    public Programa3Calculadora() {
        setTitle("Calculadora avanzada");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5)); // Ajustamos filas para mejor orden

        // Componentes
        JLabel l1 = new JLabel("Número 1:");
        JTextField a = new JTextField();
        JLabel l2 = new JLabel("Número 2:");
        JTextField b = new JTextField();
        JLabel l3 = new JLabel("Operación:");
        
        // ✅ AGREGADA LA OPCIÓN DE POTENCIA
        JComboBox<String> op = new JComboBox<>(new String[]{"+", "-", "*", "/", "^"});
        
        JLabel r1 = new JLabel("Resultado:");
        JTextField r = new JTextField();
        r.setEditable(false); // Para que no se pueda editar el resultado

        JButton btn = new JButton("Calcular");

        // Acción del botón
        btn.addActionListener(e -> {
            try {
                // Leer y convertir valores
                double x = Double.parseDouble(a.getText().trim());
                double y = Double.parseDouble(b.getText().trim());
                String operacion = (String) op.getSelectedItem();
                double res = 0;
                boolean operacionValida = true;

                // 🔄 SWITCH CON TODAS LAS OPERACIONES
                switch (operacion) {
                    case "+": // Sumar
                        res = x + y;
                        break;
                    case "-": // Restar
                        res = x - y;
                        break;
                    case "*": // Multiplicar
                        res = x * y;
                        break;
                    case "/": // Dividir
                        // ⚠️ VALIDACIÓN: División por cero
                        if (y == 0) {
                            JOptionPane.showMessageDialog(null, "❌ Error: No se puede dividir entre cero.", "Error", JOptionPane.ERROR_MESSAGE);
                            operacionValida = false;
                        } else {
                            res = x / y;
                        }
                        break;
                    case "^": // ✅ POTENCIA (elevar un número al otro)
                        res = Math.pow(x, y);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "❌ Operación no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                        operacionValida = false;
                        break;
                }

                // Mostrar resultado si todo fue correcto
                if (operacionValida) {
                    r.setText(String.format("%.2f", res)); // Mostramos con 2 decimales
                } else {
                    r.setText(""); // Limpiamos si hubo error
                }

            } catch (NumberFormatException ex) {
                // ⚠️ VALIDACIÓN: Entrada inválida (letras o vacío)
                JOptionPane.showMessageDialog(null, "❌ Error: Ingresa solo números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                r.setText("");
            }
        });

        // Agregar componentes al marco
        add(l1); add(a);
        add(l2); add(b);
        add(l3); add(op);
        add(r1); add(r);
        add(new JLabel()); add(btn); // Espacio vacío para centrar el botón

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Programa3Calculadora());
    }
}