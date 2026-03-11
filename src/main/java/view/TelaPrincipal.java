package view;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(){
        setTitle("Tela Principal");
        setSize(700,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImagemdeFundo papeldeParede = new ImagemdeFundo();
        setContentPane(papeldeParede);
        setVisible(true);


    }

    class ImagemdeFundo extends JPanel {
        private Image imagem;

        public ImagemdeFundo(){
            imagem = new ImageIcon(getClass().getResource("/fundorosa.png")).getImage();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //Garante que o painel seja limpo corretamente antes de desenhar qualquer coisa.
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
