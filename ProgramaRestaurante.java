import javax.swing.*;
import java.awt.*;

public class ProgramaRestaurante extends JFrame {
    public ProgramaRestaurante() {
        setTitle("Menú de Restaurante");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        JLabel etiquetaPrincipal = new JLabel("Elige una opción del Menú Principal:");
        JLabel opcionesTexto = new JLabel("1 = Desayuno  |  2 = Almuerzo  |  3 = Cena");

        JTextField campoOpcion = new JTextField(5); // Aquí escribes 1, 2 o 3
        JButton btnMostrar = new JButton("Ver Menú");
        JTextArea areaResultado = new JTextArea(8, 30); // Área más grande para mostrar lista
        areaResultado.setEditable(false);
        areaResultado.setWrapStyleWord(true);
        areaResultado.setLineWrap(true);

        // Acción del botón → AQUÍ ESTÁ EL SWITCH ANIDADO
        btnMostrar.addActionListener(e -> {
            try {
                int opcionPrincipal = Integer.parseInt(campoOpcion.getText().trim());
                String informacion = "";

                // SWITCH PRINCIPAL (NIVEL 1)
                switch (opcionPrincipal) {
                    case 1: // DESAYUNO
                        informacion = "🍽️ MENÚ DE DESAYUNO" + "------------------------\n";
                        
                        // Cambios exactos que me mostraste en la imagen 👇
                        int subOpcion1 = JOptionPane.showConfirmDialog(null,
                                "¿Qué deseas ver?\nSí = Ver Platos  |  No = Ver Precios",
                                "Submenú Desayuno", JOptionPane.YES_NO_OPTION);

                        switch (subOpcion1) {
                            case JOptionPane.YES_OPTION:
                                informacion += "🥞 Platos disponibles:\n"
                                             + "+ Huevos revueltos\n"
                                             + "+ Pan con jamón y queso\n"
                                             + "+ Avena con frutas\n"
                                             + "+ Tostadas con mermelada";
                                break;

                            case JOptionPane.NO_OPTION:
                                informacion += "💲 Precios:\n"
                                             + "+ Huevos revueltos: S/ 8.50\n"
                                             + "+ Pan con jamón y queso: S/ 6.00\n"
                                             + "+ Avena con frutas: S/ 7.20\n"
                                             + "+ Tostadas con mermelada: S/ 5.50";
                                break;

                            default:
                                informacion = "❌ Subopción cancelada";
                                break;
                        }
                        break;

                    // DEJO LOS OTROS CASOS (Almuerzo y Cena) TAL COMO ESTABAN
                    case 2: // ALMUERZO
                        informacion = "🍽️ MENÚ DE ALMUERZO\n------------------------\n";
                        int subOpcion2 = JOptionPane.showConfirmDialog(null,
                                "¿Qué deseas ver?\nSí = Ver Platos  |  No = Ver Precios",
                                "Submenú Almuerzo", JOptionPane.YES_NO_OPTION);

                        switch (subOpcion2) {
                            case JOptionPane.YES_OPTION:
                                informacion += "🍲 Platos disponibles:\n"
                                             + "- Ají de gallina\n"
                                             + "- Lomo saltado\n"
                                             + "- Arroz con pollo\n"
                                             + "- Ceviche de pescado";
                                break;
                            case JOptionPane.NO_OPTION:
                                informacion += "💲 Precios:\n"
                                             + "- Ají de gallina: S/ 15.00\n"
                                             + "- Lomo saltado: S/ 18.50\n"
                                             + "- Arroz con pollo: S/ 12.00\n"
                                             + "- Ceviche de pescado: S/ 20.00";
                                break;
                            default:
                                informacion = "❌ Subopción cancelada";
                                break;
                        }
                        break;

                    case 3: // CENA
                        informacion = "🍽️ MENÚ DE CENA\n------------------------\n";
                        int subOpcion3 = JOptionPane.showConfirmDialog(null,
                                "¿Qué deseas ver?\nSí = Ver Platos  |  No = Ver Precios",
                                "Submenú Cena", JOptionPane.YES_NO_OPTION);

                        switch (subOpcion3) {
                            case JOptionPane.YES_OPTION:
                                informacion += "🥗 Platos disponibles:\n"
                                             + "- Sopa de verduras\n"
                                             + "- Pollo a la parrilla\n"
                                             + "- Ensalada mixta\n"
                                             + "- Pasta alfredo";
                                break;
                            case JOptionPane.NO_OPTION:
                                informacion += "💲 Precios:\n"
                                             + "- Sopa de verduras: S/ 9.00\n"
                                             + "- Pollo a la parrilla: S/ 14.50\n"
                                             + "- Ensalada mixta: S/ 10.00\n"
                                             + "- Pasta alfredo: S/ 13.50";
                                break;
                            default:
                                informacion = "❌ Subopción cancelada";
                                break;
                        }
                        break;

                    default:
                        informacion = "❌ Opción inválida. Ingresa solo 1, 2 o 3.";
                        break;
                }

                // Mostramos todo el texto generado
                areaResultado.setText(informacion);

            } catch (NumberFormatException ex) {
                areaResultado.setText("❌ Error: Ingresa solo números (1, 2 o 3)");
            }
        });

        // Agregamos todos los elementos al marco
        add(etiquetaPrincipal);
        add(opcionesTexto);
        add(campoOpcion);
        add(btnMostrar);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProgramaRestaurante());
    }
}