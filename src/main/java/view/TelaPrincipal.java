package view;

import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    int xMouse, yMouse;
    public TelaPrincipal(){
        setTitle("Tela Principal");
        setSize(700,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);



        ImagemdeFundo papeldeParede = new ImagemdeFundo();
        setContentPane(papeldeParede);

        BotoesTelaPrincipal botaoPlanner = new BotoesTelaPrincipal("Planner de Aulas", "/moranguinho01.jpg");
        BotoesTelaPrincipal botaoAlunos = new BotoesTelaPrincipal("Alunos","/moranguinho03.jpg");
        BotoesTelaPrincipal botaoHorarios = new BotoesTelaPrincipal("Horários","/moranguinho04.jpg");
        BotoesTelaPrincipal botaoDocumentacao = new BotoesTelaPrincipal("Documentações","/moranguinho06.jpg");
        BotoesTelaPrincipal botaoPlaylist = new BotoesTelaPrincipal("Playlist","/moranguinho02.jpg");
        BotoesTelaPrincipal botaoPlannerFinanceiro = new BotoesTelaPrincipal("Planner Financeiro","/moranguinho05.jpg");

        botaoPlanner.setBounds(100,40,450,100);
        botaoPlanner.addActionListener(e -> {
            new TelaPlannerDeAulas();
            dispose();
        });
        botaoAlunos.setBounds(100,180,450,100);
        botaoAlunos.addActionListener(e -> {
            new TelaAlunos();
            dispose();
        });
        botaoHorarios.setBounds(100,320,450,100);
        botaoHorarios.addActionListener(e->{
            new TelaHorarios();
            dispose();
        });
        botaoDocumentacao.setBounds(100,460,450,100);
        botaoDocumentacao.addActionListener(e -> {
                    new TelaDocumentacoes();
                    dispose();
                });
        botaoPlaylist.setBounds(100,600,450,100);
        botaoPlaylist.addActionListener(e -> {
            new TelaPlaylist();
            dispose();
        });
        botaoPlannerFinanceiro.setBounds(100,740,450,100);
        botaoPlannerFinanceiro.addActionListener(e -> {
            new TelaPlannerFinanceiro();
            dispose();
        });

        add(botaoPlanner);
        add(botaoAlunos);
        add(botaoHorarios);
        add(botaoDocumentacao);
        add(botaoPlaylist);
        add(botaoPlannerFinanceiro);

        setLayout(null); // Permite mover as labels e alterar tamanho
        setVisible(true);


    }

    public class BotoesTelaPrincipal extends JButton {
        private int raio = 120;
        private Image imagemFundo;



        public BotoesTelaPrincipal(String texto, String caminhoImagem) {
            super(texto);

            if (caminhoImagem != null) {
                imagemFundo = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
            }

            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setForeground(Color.BLACK);
            setFont(new Font("Strawberry", Font.BOLD, 40));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Shape formaArredondada = new RoundRectangle2D.Float(
                    0, 0, getWidth(), getHeight(), raio, raio
            );

            g2.setClip(formaArredondada);

            // 🔥 Desenha a imagem como fundo
            if (imagemFundo != null) {
                int imgW = imagemFundo.getWidth(null);
                int imgH = imagemFundo.getHeight(null);

                int btnW = getWidth();
                int btnH = getHeight();

                // 🔥 calcula escala mantendo proporção
                double escala = Math.max(
                        (double) btnW / imgW,
                        (double) btnH / imgH
                );

                int novaW = (int) (imgW * escala);
                int novaH = (int) (imgH * escala);

                // centraliza
                int x = (btnW - novaW) / 2;
                int y = (btnH - novaH) / 2;

                g2.drawImage(imagemFundo, x, y, novaW, novaH, this);
            } else {
                // fallback (caso não tenha imagem)
                g2.setColor(new Color(70, 130, 180));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), raio, raio);
            }
            // desenha o texto manualmente
            g2.setClip(null);
            g2.setColor(getForeground());
            g2.setFont(getFont());



            FontMetrics fm = g2.getFontMetrics();
            String texto = getText();

            int textX = (getWidth() - fm.stringWidth(texto)) / 2;
            int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(texto, textX, textY);
            g2.dispose();

            super.paintComponent(g);
        }


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
