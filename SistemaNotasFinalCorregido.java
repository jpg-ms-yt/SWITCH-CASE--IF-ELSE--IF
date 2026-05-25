import javax.swing.JOptionPane;

public class SistemaNotasFinalCorregido {
    public static void main(String[] args) {
        // 📥 PEDIR LAS 3 NOTAS AL USUARIO
        String nota1Str = JOptionPane.showInputDialog(null,
                "Ingrese la nota 1 (SOLO entre 0 y 20):",
                "Sistema de Notas", JOptionPane.QUESTION_MESSAGE);

        String nota2Str = JOptionPane.showInputDialog(null,
                "Ingrese la nota 2 (SOLO entre 0 y 20):",
                "Sistema de Notas", JOptionPane.QUESTION_MESSAGE);

        String nota3Str = JOptionPane.showInputDialog(null,
                "Ingrese la nota 3 (SOLO entre 0 y 20):",
                "Sistema de Notas", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA
        if (nota1Str == null || nota2Str == null || nota3Str == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMEROS
            double nota1 = Double.parseDouble(nota1Str.trim());
            double nota2 = Double.parseDouble(nota2Str.trim());
            double nota3 = Double.parseDouble(nota3Str.trim());

            // 🔴 SOLUCIÓN: Quitar signos negativos y asegurar valores positivos
            nota1 = Math.abs(nota1);
            nota2 = Math.abs(nota2);
            nota3 = Math.abs(nota3);

            // 🚫 NUEVO: FILTRO PARA QUE NO ACEPTE MAYOR A 20 NI MENOR A 0
            boolean notasCorrectas = true;
            String mensajeError = "";

            if (nota1 > 20 || nota1 < 0) {
                notasCorrectas = false;
                mensajeError = "❌ ERROR: La Nota 1 está fuera del rango permitido (0 - 20).";
            }
            if (nota2 > 20 || nota2 < 0) {
                notasCorrectas = false;
                mensajeError = "❌ ERROR: La Nota 2 está fuera del rango permitido (0 - 20).";
            }
            if (nota3 > 20 || nota3 < 0) {
                notasCorrectas = false;
                mensajeError = "❌ ERROR: La Nota 3 está fuera del rango permitido (0 - 20).";
            }

            // ❌ SI ALGUNA NOTA ESTÁ MAL, SE DETIENE AQUÍ
            if (!notasCorrectas) {
                JOptionPane.showMessageDialog(null, mensajeError, "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String resultado = "";

            // 🧮 CALCULAR PROMEDIO
            double promedio = (nota1 + nota2 + nota3) / 3;

            // 🔴 LÓGICA DE EVALUACIÓN (SOLO IF)
            if (promedio >= 11) {
                resultado = "✅ APROBADO\n→ Promedio igual o mayor a 11.";
            }
            if (promedio < 11 && promedio > 8) {
                resultado = "⚠️ RECUPERACIÓN\n→ Promedio mayor a 8 pero menor a 11.";
            }
            if (promedio <= 8) {
                resultado = "❌ DESAPROBADO\n→ Promedio igual o menor a 8.";
            }

            // 📤 MOSTRAR RESULTADO (AHORA TODO PERFECTO)
            String mensajeFinal = "==================================\n" +
                                   "📊 BOLETÍN DE NOTAS\n" +
                                   "==================================\n" +
                                   "Nota 1: " + String.format("%.2f", nota1) + "\n" +
                                   "Nota 2: " + String.format("%.2f", nota2) + "\n" +
                                   "Nota 3: " + String.format("%.2f", nota3) + "\n" +
                                   "----------------------------------\n" +
                                   "Promedio obtenido: " + String.format("%.2f", promedio) + "\n" +
                                   "----------------------------------\n" +
                                   resultado + "\n" +
                                   "==================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo números válidos, sin letras ni símbolos.",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}