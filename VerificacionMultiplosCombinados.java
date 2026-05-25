import javax.swing.JOptionPane;

public class VerificacionMultiplosCombinados {
    public static void main(String[] args) {
        // 📥 PEDIR NÚMERO AL USUARIO
        String numeroStr = JOptionPane.showInputDialog(null,
                "Ingrese un número entero positivo:",
                "Verificación de Múltiplos", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (SOLO IF)
        if (numeroStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMERO ENTERO
            int numero = Integer.parseInt(numeroStr.trim());
            String resultado = "";

            // 🚫 VALIDACIÓN: QUE SEA NÚMERO POSITIVO
            if (numero < 0) {
                resultado = "❌ ERROR: Ingrese solo números positivos.";
            }

            // 🔴 LÓGICA EXACTA PEDIDA - SOLO CON IF
            // NOTA: Primero verificamos la condición MÁS ESPECÍFICA (ambos), luego las individuales

            // CASO 1: Si es múltiplo de 3 Y de 5 → FizzBuzz
            if (numero > 0 && numero % 3 == 0 && numero % 5 == 0) {
                resultado = "✅ FizzBuzz\n→ Es múltiplo de 3 y también de 5.";
            }

            // CASO 2: Si SOLO es múltiplo de 3 → Fizz
            if (numero > 0 && numero % 3 == 0 && numero % 5 != 0) {
                resultado = "✅ Fizz\n→ Es múltiplo solo de 3.";
            }

            // CASO 3: Si SOLO es múltiplo de 5 → Buzz
            if (numero > 0 && numero % 5 == 0 && numero % 3 != 0) {
                resultado = "✅ Buzz\n→ Es múltiplo solo de 5.";
            }

            // CASO 4: Si NO es múltiplo de ninguno
            if (numero > 0 && numero % 3 != 0 && numero % 5 != 0) {
                resultado = "ℹ️ El número " + numero + " NO es múltiplo ni de 3 ni de 5.";
            }

            // 📤 MOSTRAR RESULTADO FINAL
            String mensajeFinal = "==================================\n" +
                                   "🔢 RESULTADO DE LA VERIFICACIÓN\n" +
                                   "==================================\n" +
                                   "Número ingresado: " + numero + "\n" +
                                   "----------------------------------\n" +
                                   resultado + "\n" +
                                   "==================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo un número entero válido (sin letras ni símbolos).",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}