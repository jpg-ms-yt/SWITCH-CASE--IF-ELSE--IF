import javax.swing.*;
import java.awt.*;

public class ProgramaMesesAño extends JFrame {
    public ProgramaMesesAño() {
        setTitle("Sistema de Meses del Año - Perú 🇵🇪");
        setSize(380, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 📋 COMPONENTES DE LA INTERFAZ
        JLabel etiqueta = new JLabel("Ingresa un número del 1 al 12:");
        JTextField campoNumero = new JTextField(5);
        JButton btnMostrar = new JButton("Ver Mes");
        JTextArea areaResultado = new JTextArea(8, 30);
        areaResultado.setEditable(false);

        // ⚙️ LÓGICA PRINCIPAL
        btnMostrar.addActionListener(e -> {
            try {
                // Leer el número ingresado
                int numero = Integer.parseInt(campoNumero.getText().trim());
                String nombreMes = "";
                int cantidadDias = 0;

                // 🔄 SWITCH para asignar nombre y días (Febrero = 28 días, sin bisiesto)
                switch (numero) {
                    case 1:
                        nombreMes = "Enero";
                        cantidadDias = 31;
                        break;
                    case 2:
                        nombreMes = "Febrero";
                        cantidadDias = 28; // ✅ Tal como pediste, sin año bisiesto
                        break;
                    case 3:
                        nombreMes = "Marzo";
                        cantidadDias = 31;
                        break;
                    case 4:
                        nombreMes = "Abril";
                        cantidadDias = 30;
                        break;
                    case 5:
                        nombreMes = "Mayo";
                        cantidadDias = 31;
                        break;
                    case 6:
                        nombreMes = "Junio";
                        cantidadDias = 30;
                        break;
                    case 7:
                        nombreMes = "Julio";
                        cantidadDias = 31;
                        break;
                    case 8:
                        nombreMes = "Agosto";
                        cantidadDias = 31;
                        break;
                    case 9:
                        nombreMes = "Septiembre";
                        cantidadDias = 30;
                        break;
                    case 10:
                        nombreMes = "Octubre";
                        cantidadDias = 31;
                        break;
                    case 11:
                        nombreMes = "Noviembre";
                        cantidadDias = 30;
                        break;
                    case 12:
                        nombreMes = "Diciembre";
                        cantidadDias = 31;
                        break;
                    default:
                        areaResultado.setText("❌ ERROR: Solo números del 1 al 12");
                        return; // Salimos si el número es incorrecto
                }

                // 📄 MOSTRAR RESULTADO
                String informacion = "==================================\n" +
                                    "Mes: " + nombreMes + "\n" +
                                    "Número: " + numero + "\n" +
                                    "Cantidad de días: " + cantidadDias + " días\n" +
                                    "==================================\n" +
                                    "¡Gracias por usar el programa de meses del año! 🇵🇪";

                areaResultado.setText(informacion);

            } catch (NumberFormatException ex) {
                // Si ingresa letras o símbolos
                areaResultado.setText("❌ ERROR: Ingresa solo números válidos");
            }
        });

        // AGREGAMOS TODO AL MARCO
        add(etiqueta);
        add(campoNumero);
        add(btnMostrar);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProgramaMesesAño());
    }
}