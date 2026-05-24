import javax.swing.*;
import java.awt.*;

public class ControlAccesoRol extends JFrame {
    public ControlAccesoRol() {
        setTitle("Control de Acceso por Rol");
        setSize(350, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes
        JLabel etiqueta = new JLabel("Ingrese tipo de usuario (ADMIN / USER / GUEST):");
        JTextField campoRol = new JTextField(15);
        JButton btnVerificar = new JButton("Ver Permisos");
        JTextArea areaResultado = new JTextArea(6, 25);
        areaResultado.setEditable(false);

        // Lógica principal
        btnVerificar.addActionListener(e -> {
            String rol = campoRol.getText().trim().toUpperCase(); // Convertimos a mayúsculas
            String permisos = "";

            // Switch con String tal como lo pediste
            switch (rol) {
                case "ADMIN":
                    permisos = "Rol: ADMIN\nPermisos: Acceso total";
                    break;
                case "USER":
                    permisos = "Rol: USER\nPermisos: Acceso parcial";
                    break;
                case "GUEST":
                    permisos = "Rol: GUEST\nPermisos: Solo lectura";
                    break;
                default:
                    permisos = "Error: Rol no reconocido.\nIngrese solo: ADMIN, USER o GUEST";
                    break;
            }

            areaResultado.setText(permisos);
        });

        // Agregamos al marco
        add(etiqueta);
        add(campoRol);
        add(btnVerificar);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ControlAccesoRol());
    }
}