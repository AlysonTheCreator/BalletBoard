package view;

import dao.UsuarioDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JButton botaoOlho;
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private boolean senhaVisivel = false;

    public TelaLogin(){

        setTitle("Login");
        setSize(750,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Parar código após fechar a tela
        setResizable(false); // Define com que não possa alterar o tamanho da tela
        setLocationRelativeTo(null); // Centraliza no meio da tela

        imagemdeFundo papeldeParede= new imagemdeFundo();
        setContentPane(papeldeParede);

// Label de boas vindas

        JLabel labelBemVindo = new JLabel("Seja Bem-Vinda, Nina!");
        labelBemVindo.setBounds(163, 20, 450, 150);
        labelBemVindo.setFont(new Font("Strawberry", Font.BOLD, 70));
        add(labelBemVindo);
        labelBemVindo.setForeground(Color.red);
// Label Usuário
        JLabel labelLogin = new JLabel("Usuário:");
        labelLogin.setBounds(220,130,100,50);
        labelLogin.setFont(new Font("Segoe UI",Font.BOLD, 16));
        labelLogin.setForeground(Color.red);

        add(labelLogin);

// Campo Usuario
        campoLogin = new JTextField();
        campoLogin.setBounds(290,143,200,25);
        add(campoLogin);

// Label Senha
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(220,190,80,25);
        labelSenha.setFont(new Font("Segoe UI",Font.BOLD, 16));
        labelSenha.setForeground(Color.red);
        add(labelSenha);

// Campo Senha
        campoSenha = new JPasswordField();
        campoSenha.setBounds(290,190,200,25);
        add(campoSenha);

        setLocationRelativeTo(null);

        // Botão Ocultar/Mostrar
        botaoOlho = new JButton("👁");
        botaoOlho.setBounds(480,185,60,40);
        botaoOlho.setOpaque(false);          // não pinta o fundo
        botaoOlho.setContentAreaFilled(false); // remove o preenchimento
        botaoOlho.setBorderPainted(false);     // remove borda
        botaoOlho.setFocusPainted(false);    // remove contorno ao focar
        add(botaoOlho);

        botaoOlho.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            if (senhaVisivel) {
                                                campoSenha.setEchoChar('•'); // esconde senha
                                                senhaVisivel = false;
                                            } else {
                                                campoSenha.setEchoChar((char) 0); // mostra senha
                                                senhaVisivel = true;
                                            }
                                        }
                                    });




                // Botão Entrar

        JButton botaoentrar = new JButton("Entrar");
        botaoentrar.setBounds(338,230,80,35);
        // Faz o Enter acionar o botão automaticamente
        getRootPane().setDefaultButton(botaoentrar);
        add(botaoentrar);

        // Ação do botão
        botaoentrar.addActionListener(e -> {

            String nome = campoLogin.getText();
            String senha = new String(campoSenha.getPassword());

            UsuarioDao usuarioDAO = new UsuarioDao();

            boolean acesso = usuarioDAO.verificarLogin(nome, senha);

            if(acesso){

                JOptionPane.showMessageDialog(null,"Login realizado!");

                new TelaPrincipal();
                dispose();

            }else{

                JOptionPane.showMessageDialog(null,"Usuário ou senha incorretos");

            }

        });

        setLayout(null); // Controle do Posicionamento de Label e Campos
        setVisible(true);


    }

    class imagemdeFundo extends JPanel{
        private Image imagem;

        public imagemdeFundo(){
            imagem = new ImageIcon(getClass().getResource("/hellokitty.png")).getImage();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
        }

    }
}
