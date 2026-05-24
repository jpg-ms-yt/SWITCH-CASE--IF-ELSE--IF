import javax.swing.*;
import java.awt.*;

public class CalculoImpuesto extends JFrame {
    public CalculoImpuesto() {
        setTitle("Cálculo de Impuesto Progresivo");
        setSize(380, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de entrada
        JLabel etiqueta = new JLabel("Ingrese el monto total (S/):");
        JTextField campoMonto = new JTextField(10);
        JButton btnCalcular = new JButton("Calcular Impuesto");
        JTextArea areaResultado = new JTextArea(8, 30);
        areaResultado.setEditable(false);

        // ⚙️ LÓGICA CON RANGOS Y VALIDACIONES
        btnCalcular.addActionListener(e -> {
            try {
                // Leer y convertir el valor
                double monto = Double.parseDouble(campoMonto.getText().trim());
                double impuesto = 0.0;
                String detalle = "";

                // ✅ VALIDACIÓN: No permite montos negativos
                if (monto < 0) {
                    areaResultado.setText("Error: El monto no puede ser negativo.");
                    return;
                }

                // ✅ APLICACIÓN DE TRAMOS (Impuesto Progresivo)
                if (monto <= 1000) {
                    // Tramo 1: 0 - 1000 → 5%
                    impuesto = monto * 0.05;
                    detalle = "Aplicado: Tramo 1 (0 - 1000) → 5%";
                } 
                else if (monto <= 5000) {
                    // Tramo 2: 1001 - 5000 → 10%
                    impuesto = monto * 0.10;
                    detalle = "Aplicado: Tramo 2 (1001 - 5000) → 10%";
                } 
                else {
                    // Tramo 3: Más de 5000 → 20%
                    impuesto = monto * 0.20;
                    detalle = "Aplicado: Tramo 3 (mayor a 5000) → 20%";
                }

                // Cálculo del total a pagar (monto + impuesto)
                double total = monto + impuesto;

                // 📄 MOSTRAR RESULTADO
                String resumen = "==================================\n" +
                                 "Monto ingresado: S/ " + String.format("%.2f", monto) + "\n" +
                                 detalle + "\n" +
                                 "----------------------------------\n" +
                                 "Impuesto calculado: S/ " + String.format("%.2f", impuesto) + "\n" +
                                 "Total a pagar: S/ " + String.format("%.2f", total) + "\n" +
                                 "==================================";

                areaResultado.setText(resumen);

            } catch (NumberFormatException ex) {
                // ✅ VALIDACIÓN: Solo números
                areaResultado.setText("Error: Ingrese solo valores numéricos válidos.");
            }
        });

        // Agregamos componentes al marco
        add(etiqueta);
        add(campoMonto);
        add(btnCalcular);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculoImpuesto());
    }
}