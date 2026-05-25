import javax.swing.JOptionPane;

public class AnioBisiesto {
    public static void main(String[] args) {
        // 📥 PEDIR EL AÑO AL USUARIO
        String anioStr = JOptionPane.showInputDialog(null,
                "Ingrese un año para verificar si es bisiesto:\n\n" +
                "Regla: \n" +
                "• Divisible entre 4 pero no entre 100, O BIEN\n" +
                "• Divisible entre 400",
                "Verificar Año Bisiesto", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (SOLO IF)
        if (anioStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMERO ENTERO
            int anio = Integer.parseInt(anioStr.trim());
            String resultado = "";

            // 🔴 LÓGICA EXACTA PEDIDA - SOLO CON IF
            // Condición: (divisible entre 4 Y NO entre 100) O (divisible entre 400)
            if ( (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0) ) {
                resultado = "✅ EL AÑO " + anio + " ES BISIESTO\n\n" +
                            "Cumple con la regla establecida.";
            }

            // Condición contraria: NO cumple la regla
            if ( !((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) ) {
                resultado = "❌ EL AÑO " + anio + " NO ES BISIESTO\n\n" +
                            "No cumple con las condiciones requeridas.";
            }

            // 📤 MOSTRAR RESULTADO FINAL
            String mensajeFinal = "==================================\n" +
                                   "📅 RESULTADO DE LA VERIFICACIÓN\n" +
                                   "==================================\n" +
                                   resultado + "\n" +
                                   "==================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo un número entero válido.",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}