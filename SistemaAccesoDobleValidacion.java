import javax.swing.JOptionPane;

public class SistemaAccesoDobleValidacion {
    public static void main(String[] args) {
        // 📥 PEDIR DATOS AL USUARIO
        String usuario = JOptionPane.showInputDialog(null,
                "Ingrese su Usuario:",
                "Sistema de Acceso", JOptionPane.QUESTION_MESSAGE);

        String contrasena = JOptionPane.showInputDialog(null,
                "Ingrese su Contraseña:",
                "Sistema de Acceso", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (solo if)
        if (usuario == null || contrasena == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 🧹 LIMPIAMOS ESPACIOS
        usuario = usuario.trim();
        contrasena = contrasena.trim();

        // 🔴 LÓGICA SOLO CON IF (TAL COMO LO PIDIERON)
        // Condición correcta: usuario = admin Y contraseña = 1234
        if (usuario.equals("admin") && contrasena.equals("1234")) {
            JOptionPane.showMessageDialog(null,
                    "✅ ACCESO CORRECTO\n\nBienvenido al sistema.",
                    "Ingreso exitoso", JOptionPane.INFORMATION_MESSAGE);
        }

        // Condición incorrecta: cualquier otra combinación
        if (!usuario.equals("admin") || !contrasena.equals("1234")) {
            JOptionPane.showMessageDialog(null,
                    "❌ ACCESO DENEGADO\n\nUsuario o contraseña incorrectos.",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}