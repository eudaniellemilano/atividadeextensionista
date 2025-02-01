package leituraeducativa;

import java.awt.*; // criar interface gráfica (fonte)
import javax.swing.*; // componentes (botoes)

public class LeituraEducativa {
    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Aprenda a Ler!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            exibirMenu();
        });
    }

    private static void exibirMenu() {
        frame.getContentPane().removeAll();
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1));

        JLabel titulo = new JLabel("Bem-vindo ao Treinador de Leitura!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        menuPanel.add(titulo);

        JButton exercicio1 = new JButton("Qual a palavra?");
        JButton exercicio2 = new JButton("Organize a Palavra");
        JButton exercicio3 = new JButton("Leia e Responda");
        JButton sair = new JButton("Sair");

        exercicio1.addActionListener(e -> Exercicio1.iniciarExercicio1(frame));
        exercicio2.addActionListener(e -> Exercicio2.iniciarExercicio());
        exercicio3.addActionListener(e -> Exercicio3.iniciarExercicio());
        sair.addActionListener(e -> System.exit(0));

        menuPanel.add(exercicio1);
        menuPanel.add(exercicio2);
        menuPanel.add(exercicio3);
        menuPanel.add(sair);

        frame.add(menuPanel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
}