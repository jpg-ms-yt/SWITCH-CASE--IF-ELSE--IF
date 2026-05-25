import javax.swing.JOptionPane;

public class ValidacionContrasena {
    public static void main(String[] args) {
        // 📥 Pedir contraseña al usuario
        String contrasena = JOptionPane.showInputDialog(null,
                "Ingrese una contraseña para verificar:\n\n" +
                "Requisitos:\n" +
                "• Mínimo 8 caracteres\n" +
                "• Al menos una letra MAYÚSCULA\n" +
                "• Al menos un NÚMERO\n" +
                "• Al menos un SÍMBOLO (@, #, $, %, &, !, etc.)",
                "Validación de Contraseña Segura", JOptionPane.QUESTION_MESSAGE);

        // ✅ Validación si cancela
        if (contrasena == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 🔍 VARIABLES DE VERIFICACIÓN
        int longitud = contrasena.length();
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;
        String mensajeError = "";
        boolean esValida = true;

        // 🔄 RECORREMOS CADA CARÁCTER PARA VERIFICAR
        for (int i = 0; i < contrasena.length(); i++) {
            char c = contrasena.charAt(i);

            if (c >= 'A' && c <= 'Z') tieneMayuscula = true;
            if (c >= '0' && c <= '9') tieneNumero = true;
            // Verifica símbolos (puedes agregar más si quieres)
            if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126)) {
                tieneSimbolo = true;
            }
        }

        // 🔴 SOLO IF - ELSE PARA EVALUAR Y DAR MENSAJES
        if (longitud < 8) {
            mensajeError += "❌ Debe tener al menos 8 caracteres.\n";
            esValida = false;
        } else {
            mensajeError += "✅ Longitud correcta (" + longitud + " caracteres).\n";
        }

        if (tieneMayuscula == false) {
            mensajeError += "❌ Falta al menos una letra MAYÚSCULA.\n";
            esValida = false;
        } else {
            mensajeError += "✅ Contiene letra mayúscula.\n";
        }

        if (tieneNumero == false) {
            mensajeError += "❌ Falta al menos un NÚMERO.\n";
            esValida = false;
        } else {
            mensajeError += "✅ Contiene número.\n";
        }

        if (tieneSimbolo == false) {
            mensajeError += "❌ Falta al menos un SÍMBOLO especial (@, #, $, %, etc.).\n";
            esValida = false;
        } else {
            mensajeError += "✅ Contiene símbolo especial.\n";
        }

        // 📤 RESULTADO FINAL
        if (esValida) {
            mensajeError = "==================================\n" +
                            "🔒 CONTRASEÑA SEGURA\n" +
                            "==================================\n" +
                            mensajeError +
                            "----------------------------------\n" +
                            "✅ Cumple TODOS los requisitos.";
        } else {
            mensajeError = "==================================\n" +
                            "⚠️ CONTRASEÑA INSEGURA\n" +
                            "==================================\n" +
                            mensajeError +
                            "----------------------------------\n" +
                            "❌ Corrige los puntos indicados.";
        }

        JOptionPane.showMessageDialog(null, mensajeError, "Resultado de Validación", JOptionPane.INFORMATION_MESSAGE);
    }
}