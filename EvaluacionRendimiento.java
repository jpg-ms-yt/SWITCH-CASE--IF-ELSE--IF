import javax.swing.JOptionPane;

public class EvaluacionRendimiento {
    public static void main(String[] args) {
        // 📥 INGRESAR DATOS
        String puntualidadStr = JOptionPane.showInputDialog(null,
                "Ingrese calificación de PUNTUALIDAD (1 - 10):",
                "Evaluación de Rendimiento", JOptionPane.QUESTION_MESSAGE);

        String productividadStr = JOptionPane.showInputDialog(null,
                "Ingrese calificación de PRODUCTIVIDAD (1 - 10):",
                "Evaluación de Rendimiento", JOptionPane.QUESTION_MESSAGE);

        String cumplimientoStr = JOptionPane.showInputDialog(null,
                "Ingrese calificación de CUMPLIMIENTO (1 - 10):",
                "Evaluación de Rendimiento", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN: Si cancela
        if (puntualidadStr == null || productividadStr == null || cumplimientoStr == null) {
            JOptionPane.showMessageDialog(null,
                    "Operación cancelada.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMEROS
            int puntualidad = Integer.parseInt(puntualidadStr.trim());
            int productividad = Integer.parseInt(productividadStr.trim());
            int cumplimiento = Integer.parseInt(cumplimientoStr.trim());
            String resultado;

            // ✅ VALIDAR RANGO 1-10
            if (puntualidad < 1 || puntualidad > 10 || 
                productividad < 1 || productividad > 10 || 
                cumplimiento < 1 || cumplimiento > 10) {

                JOptionPane.showMessageDialog(null,
                        "❌ ERROR: Todas las calificaciones deben ser entre 1 y 10.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 🔴 SOLO IF - ELSE ANIDADOS (TAL COMO LO PIDES)
            if (puntualidad >= 9 && productividad >= 9 && cumplimiento >= 9) {
                resultado = "Excelente";
            } else {
                if ((puntualidad >= 7 && puntualidad < 9) && 
                    (productividad >= 7 && productividad < 9) && 
                    (cumplimiento >= 7 && cumplimiento < 9)) {
                    resultado = "Bueno";
                } else {
                    if ((puntualidad >= 5 && puntualidad < 7) && 
                        (productividad >= 5 && productividad < 7) && 
                        (cumplimiento >= 5 && cumplimiento < 7)) {
                        resultado = "Regular";
                    } else {
                        if (puntualidad < 5 || productividad < 5 || cumplimiento < 5) {
                            resultado = "Deficiente";
                        } else {
                            // Evaluación mixta
                            if ((puntualidad >= 8 && cumplimiento >= 8) || (productividad >= 8 && cumplimiento >= 8)) {
                                resultado = "Bueno";
                            } else {
                                if ((puntualidad >= 6 && productividad >= 6) || (cumplimiento >= 6)) {
                                    resultado = "Regular";
                                } else {
                                    resultado = "Deficiente";
                                }
                            }
                        }
                    }
                }
            }

            // 📤 MOSTRAR RESULTADO
            String mensajeFinal = "==================================\n" +
                                   "EVALUACIÓN DE RENDIMIENTO\n" +
                                   "==================================\n" +
                                   "Puntualidad:    " + puntualidad + "/10\n" +
                                   "Productividad:  " + productividad + "/10\n" +
                                   "Cumplimiento:   " + cumplimiento + "/10\n" +
                                   "----------------------------------\n" +
                                   "CLASIFICACIÓN:  " + resultado.toUpperCase() + "\n" +
                                   "==================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo números válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}