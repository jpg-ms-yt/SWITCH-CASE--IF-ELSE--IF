import javax.swing.JOptionPane;

public class ValidacionContrasenaNumerica {
    public static void main(String[] args) {
        // 📥 PEDIR LA CONTRASEÑA AL USUARIO
        String contrasenaStr = JOptionPane.showInputDialog(null,
                "Ingrese su contraseña (solo números):\n\n" +
                "Requisito: Debe ser mayor a 1000 y menor a 9999",
                "Validación de Contraseña", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (SOLO IF)
        if (contrasenaStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMERO ENTERO
            int contrasena = Integer.parseInt(contrasenaStr.trim());
            String resultado = "";

            // 🔴 LÓGICA EXACTA - SOLO CON IF
            // Condición correcta: Mayor a 1000 Y Menor a 9999
            if (contrasena > 1000 && contrasena < 9999) {
                resultado = "✅ CONTRASEÑA VÁLIDA\n\n" +
                            "El número " + contrasena + " cumple con el rango establecido.";
            }

            // Condición incorrecta: Si es menor o igual a 1000, O mayor o igual a 9999
            if (contrasena <= 1000 || contrasena >= 9999) {
                resultado = "❌ CONTRASEÑA INVÁLIDA\n\n" +
                            "El número " + contrasena + " NO cumple el requisito.\n" +
                            "Debe ser mayor a 1000 y menor a 9999.";
            }

            // 📤 MOSTRAR RESULTADO FINAL
            String mensajeFinal = "==================================\n" +
                                   "🔐 RESULTADO DE LA VALIDACIÓN\n" +
                                   "==================================\n" +
                                   resultado + "\n" +
                                   "==================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo números, sin letras ni símbolos.",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}