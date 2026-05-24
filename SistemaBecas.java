import javax.swing.*;
import java.awt.*;

public class SistemaBecas extends JFrame {
    public SistemaBecas() {
        setTitle("Sistema de Asignación de Becas");
        setSize(400, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de entrada de datos
        JLabel lPromedio = new JLabel("Promedio académico (0 - 20):");
        JTextField txtPromedio = new JTextField(5);

        JLabel lIngresos = new JLabel("Ingresos familiares (S/ mensuales):");
        JTextField txtIngresos = new JTextField(10);

        JLabel lDesaprobados = new JLabel("Número de cursos desaprobados:");
        JTextField txtDesaprobados = new JTextField(5);

        JButton btnVerificar = new JButton("Verificar Beca");
        JTextArea areaResultado = new JTextArea(8, 30);
        areaResultado.setEditable(false);

        // ⚙️ LÓGICA: Condiciones combinadas y estructuras anidadas
        btnVerificar.addActionListener(e -> {
            try {
                // Leer y convertir datos
                double promedio = Double.parseDouble(txtPromedio.getText().trim());
                double ingresos = Double.parseDouble(txtIngresos.getText().trim());
                int desaprobados = Integer.parseInt(txtDesaprobados.getText().trim());
                String resultado = "";

                // ✅ CONDICIONES PRINCIPALES con && y ||
                // Requisito base: promedio alto Y pocos o ningún curso desaprobado
                if (promedio >= 16 && desaprobados == 0) {

                    // 📍 ESTRUCTURA ANIDADA: Evaluamos situación económica
                    if (ingresos < 1500) {
                        // Caso 1: Muy buen promedio + bajos ingresos + sin cursos perdidos
                        resultado = "RESULTADO: BECA COMPLETA\n" +
                                    "Motivo: Alto rendimiento y bajos recursos económicos.";
                    } 
                    else if (ingresos >= 1500 && ingresos <= 3000) {
                        // Caso 2: Buenos ingresos pero dentro del límite + buen promedio
                        resultado = "RESULTADO: BECA PARCIAL\n" +
                                    "Motivo: Buen rendimiento, ingresos moderados.";
                    } 
                    else {
                        // Caso 3: Ingresos altos, aunque tenga buen promedio
                        resultado = "RESULTADO: SIN BECA\n" +
                                    "Motivo: Rendimiento excelente, pero ingresos familiares altos.";
                    }
                } 
                // ✅ USO DE OPERADOR || (OR) en condición secundaria
                else if (promedio >= 14 && promedio < 16 && desaprobados <= 1 && ingresos < 1000) {
                    // Promedio regular, máximo 1 curso perdido y ingresos muy bajos
                    resultado = "RESULTADO: BECA DE APOYO\n" +
                                "Motivo: Rendimiento aceptable, pocos cursos desaprobados y situación económica crítica.";
                } 
                else {
                    // Cualquier otro caso que no cumpla las reglas anteriores
                    resultado = "RESULTADO: NO APTO PARA BECA\n" +
                                "Motivo: No cumple con los requisitos mínimos.\n" +
                                "(Promedio menor a 14 o más de 1 curso desaprobado)";
                }

                // Mostrar resumen y resultado
                String resumen = "==================================\n" +
                                 "Promedio: " + promedio + "\n" +
                                 "Ingresos Familiares: S/ " + ingresos + "\n" +
                                 "Cursos Desaprobados: " + desaprobados + "\n" +
                                 "----------------------------------\n" +
                                 resultado + "\n" +
                                 "==================================";

                areaResultado.setText(resumen);

            } catch (NumberFormatException ex) {
                areaResultado.setText("Error: Ingrese solo números válidos en todos los campos.");
            }
        });

        // Agregamos todo al marco
        add(lPromedio);
        add(txtPromedio);
        add(lIngresos);
        add(txtIngresos);
        add(lDesaprobados);
        add(txtDesaprobados);
        add(btnVerificar);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaBecas());
    }
}