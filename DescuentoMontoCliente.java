import javax.swing.JOptionPane;

public class DescuentoMontoCliente {
    public static void main(String[] args) {
        // 📥 PEDIR DATOS AL USUARIO
        String montoStr = JOptionPane.showInputDialog(null,
                "Ingrese el monto total de la compra:",
                "Sistema de Descuentos", JOptionPane.QUESTION_MESSAGE);

        String clienteTipo = JOptionPane.showInputDialog(null,
                "Ingrese tipo de cliente:\n\n- VIP\n- Normal",
                "Sistema de Descuentos", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (SOLO IF)
        if (montoStr == null || clienteTipo == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR Y LIMPIAR DATOS
            double monto = Double.parseDouble(montoStr.trim());
            String tipo = clienteTipo.trim().toUpperCase(); // Pasamos a mayúsculas para que acepte vip o Vip
            double descuento = 0.0;
            String mensajeDescuento = "Sin descuento aplicado";

            // 🔴 LÓGICA EXACTA PEDIDA - SOLO USO DE IF
            // REGLA 1: Si compra > 500 Y es VIP → 20%
            if (monto > 500 && tipo.equals("VIP")) {
                descuento = monto * 0.20;
                mensajeDescuento = "Descuento aplicado: 20% (Cliente VIP y compra mayor a S/ 500)";
            }

            // REGLA 2: Si compra > 500 PERO NO es VIP → 10%
            // (Usamos condición contraria al VIP para que no se junte con la anterior)
            if (monto > 500 && !tipo.equals("VIP")) {
                descuento = monto * 0.10;
                mensajeDescuento = "Descuento aplicado: 10% (Compra mayor a S/ 500)";
            }

            // REGLA 3: Si compra <= 500 → 0% (Sin descuento)
            // El descuento se quedó en 0.0 y el mensaje ya está definido arriba
            if (monto <= 500) {
                descuento = 0.0;
                mensajeDescuento = "Sin descuento (Compra menor o igual a S/ 500)";
            }

            // 🧮 CÁLCULOS FINALES
            double totalPagar = monto - descuento;

            // 📤 MOSTRAR RESULTADO
            String resultadoFinal = "=========================================\n" +
                                    "🧾 RESUMEN DE COMPRA\n" +
                                    "=========================================\n" +
                                    "Monto inicial:     S/ " + String.format("%.2f", monto) + "\n" +
                                    "Tipo de cliente:   " + tipo + "\n" +
                                    "-----------------------------------------\n" +
                                    mensajeDescuento + "\n" +
                                    "Valor del descuento: S/ " + String.format("%.2f", descuento) + "\n" +
                                    "-----------------------------------------\n" +
                                    "💰 TOTAL A PAGAR:   S/ " + String.format("%.2f", totalPagar) + "\n" +
                                    "=========================================";

            JOptionPane.showMessageDialog(null, resultadoFinal, "Detalle de Pago", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese un monto válido (solo números).",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}