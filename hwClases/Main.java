package hwClases;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Transito transito = new Transito();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestor de Multas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton agregarButton = new JButton("Agregar Multa");
        panel.add(agregarButton);
        JButton pagarButton = new JButton("Pagar Multa");
        panel.add(pagarButton);
        JButton informacionButton = new JButton("Información del Sistema");
        panel.add(informacionButton);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarMulta();
            }
        });

        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagarMulta();
            }
        });

        informacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInfo();
            }
        });

        frame.setVisible(true);
    }

    private static void agregarMulta() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingresar código: "));
            String nombre = JOptionPane.showInputDialog("Ingresar nombre:");
            String tipo = JOptionPane.showInputDialog("Ingrese el tipo de la multa (LEVE, MEDIO, GRAVE):");

            String resultado = transito.agregarMulta(codigo, nombre, tipo);
            JOptionPane.showMessageDialog(null, resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, valor inexistente");
        }
    }

    private static void pagarMulta() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingresar código: "));
            String resultado = transito.pagarMulta(codigo);
            JOptionPane.showMessageDialog(null, resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, valor inexistente");
        }
    }

    private static void mostrarInfo() {
        String info = transito.imprimirInfo();
        JOptionPane.showMessageDialog(null, info);
    }
}
