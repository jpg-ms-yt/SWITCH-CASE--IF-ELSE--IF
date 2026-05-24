import javax.swing.*;

public class SistemaCalificacion {
    public static void main(String[] args) {
        // Pedimos la letra al usuario
        String entrada = JOptionPane.showInputDialog(null, 
            "Ingresa una letra de calificación (A, B, C, D, F):", 
            "Sistema de Calificación", 
            JOptionPane.QUESTION_MESSAGE);

        // Verificamos si el usuario no canceló
        if (entrada != null && !entrada.isEmpty()) {
            // Tomamos solo la primera letra y la convertimos a MAYÚSCULA
            char letra = entrada.toUpperCase().charAt(0);
            String resultado;

            // 🔄 SWITCH con tipo CHAR, tal como lo pediste
            switch (letra) {
                case 'A':
                    resultado = "Excelente";
                    break;
                case 'B':
                    resultado = "Bueno";
                    break;
                case 'C':
                    resultado = "Regular";
                    break;
                case 'D':
                    resultado = "Deficiente";
                    break;
                case 'F':
                    resultado = "Reprobado";
                    break;
                default:
                    resultado = "Calificación inválida. Ingresa solo A, B, C, D o F.";
                    break;
            }

            // Mostramos el resultado
            JOptionPane.showMessageDialog(null, 
                "Calificación: " + letra + "\nSignificado: " + resultado, 
                "Resultado", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No ingresaste ninguna letra.");
        }
    }
}