import javax.swing.JOptionPane;

public class EdadCategoria {
    public static void main(String[] args) {
        // 📥 PEDIR LA EDAD AL USUARIO
        String edadStr = JOptionPane.showInputDialog(null,
                "Ingrese su edad en años:",
                "Clasificación por Edad", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (SOLO IF)
        if (edadStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMERO ENTERO
            int edad = Integer.parseInt(edadStr.trim());
            String categoria = "";

            // 🔴 MÚLTIPLES CONDICIONALES IF (TAL COMO LO PIDIERON)

            // NIÑO: 0 – 12 años
            if (edad >= 0 && edad <= 12) {
                categoria = "👶 NIÑO\n→ Edad comprendida entre 0 y 12 años.";
            }

            // ADOLESCENTE: 13 – 17 años
            if (edad >= 13 && edad <= 17) {
                categoria = "👦 ADOLESCENTE\n→ Edad comprendida entre 13 y 17 años.";
            }

            // ADULTO: 18 – 64 años
            if (edad >= 18 && edad <= 64) {
                categoria = "🧑 ADULTO\n→ Edad comprendida entre 18 y 64 años.";
            }

            // ADULTO MAYOR: 65 años en adelante
            if (edad >= 65) {
                categoria = "👴 ADULTO MAYOR\n→ Edad de 65 años o más.";
            }

            // EDAD INVÁLIDA (menor a 0)
            if (edad < 0) {
                categoria = "❌ EDAD INVÁLIDA\n→ No existen edades negativas.";
            }

            // 📤 MOSTRAR RESULTADO FINAL
            String mensajeFinal = "==================================\n" +
                                   "📋 CLASIFICACIÓN POR EDAD\n" +
                                   "==================================\n" +
                                   "Edad ingresada: " + edad + " años\n" +
                                   "----------------------------------\n" +
                                   categoria + "\n" +
                                   "==================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo un número entero válido.",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}