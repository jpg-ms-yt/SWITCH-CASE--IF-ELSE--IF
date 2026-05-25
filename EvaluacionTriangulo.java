import javax.swing.JOptionPane;

public class EvaluacionTriangulo {
    public static void main(String[] args) {
        // 📥 PEDIR LOS 3 LADOS AL USUARIO
        String lado1Str = JOptionPane.showInputDialog(null,
                "Ingrese la longitud del Primer lado:",
                "Evaluación de Triángulo", JOptionPane.QUESTION_MESSAGE);

        String lado2Str = JOptionPane.showInputDialog(null,
                "Ingrese la longitud del Segundo lado:",
                "Evaluación de Triángulo", JOptionPane.QUESTION_MESSAGE);

        String lado3Str = JOptionPane.showInputDialog(null,
                "Ingrese la longitud del Tercer lado:",
                "Evaluación de Triángulo", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (SOLO IF)
        if (lado1Str == null || lado2Str == null || lado3Str == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMEROS
            double lado1 = Double.parseDouble(lado1Str.trim());
            double lado2 = Double.parseDouble(lado2Str.trim());
            double lado3 = Double.parseDouble(lado3Str.trim());
            String resultado = "";

            // 🔴 REGLA MATEMÁTICA: PARA SER TRIÁNGULO
            // La suma de dos lados cualquiera debe ser MAYOR que el tercero
            boolean esTriangulo = false;

            if ((lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1) && (lado1 > 0) && (lado2 > 0) && (lado3 > 0)) {
                esTriangulo = true;
                resultado = "✅ SÍ FORMA UN TRIÁNGULO\n\n";
            }

            if (!esTriangulo) {
                resultado = "❌ NO ES UN TRIÁNGULO VÁLIDO\n\n" +
                            "Regla: La suma de dos lados debe ser mayor al tercero\ny los valores deben ser mayores a cero.";
            }

            // 🔴 CLASIFICACIÓN (SOLO SI ES TRIÁNGULO - TODO CON IF)

            // EQUILÁTERO: Todos los lados iguales
            if (esTriangulo && lado1 == lado2 && lado2 == lado3) {
                resultado += "🔹 Tipo: EQUILÁTERO\n→ Tiene sus 3 lados exactamente iguales.";
            }

            // ISÓSCELES: Exactamente 2 lados iguales (y 1 distinto)
            if (esTriangulo && ((lado1 == lado2 && lado1 != lado3) || 
                                (lado1 == lado3 && lado1 != lado2) || 
                                (lado2 == lado3 && lado2 != lado1))) {
                resultado += "🔹 Tipo: ISÓSCELES\n→ Tiene exactamente 2 lados iguales y 1 diferente.";
            }

            // ESCALENO: Todos los lados diferentes entre sí
            if (esTriangulo && (lado1 != lado2 && lado1 != lado3 && lado2 != lado3)) {
                resultado += "🔹 Tipo: ESCALENO\n→ Tiene sus 3 lados completamente distintos.";
            }

            // 📤 MOSTRAR RESULTADO FINAL
            String mensajeFinal = "==================================\n" +
                                   "📐 EVALUACIÓN DE LADOS\n" +
                                   "Lado 1: " + lado1 + " | Lado 2: " + lado2 + " | Lado 3: " + lado3 + "\n" +
                                   "==================================\n" +
                                   resultado + "\n" +
                                   "==================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo números válidos.",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}