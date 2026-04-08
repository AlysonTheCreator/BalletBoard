package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TelaHorarios extends JFrame {
    int xMouse, yMouse;
    public TelaHorarios() {

        setSize(700, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel painel = new JPanel(null);
        painel.setBackground(new Color(32, 27, 55));
        setContentPane(painel);

        // Tela de Titulo Personalizada
        JPanel barra = new JPanel();
        barra.setBounds(0, 0, 700, 40);
        barra.setBackground(new Color(81, 72, 105));
        barra.setLayout(null);

        painel.add(barra);

        // Titulo
        JLabel titulo = new JLabel("Tela Horários");
        titulo.setBounds(10, 5, 200, 30);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        //  Botão fechar
        JLabel fechar = new JLabel("X");
        fechar.setBounds(660, 5, 30, 30);
        fechar.setForeground(Color.WHITE);
        fechar.setFont(new Font("Arial", Font.BOLD, 16));
        fechar.setHorizontalAlignment(SwingConstants.CENTER);
        barra.add(fechar);

        fechar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                fechar.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                fechar.setForeground(Color.WHITE);
            }
        });

        // 🟡 Permitir arrastar a janela
        barra.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });

        barra.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });

        setVisible(true);



    }
}
