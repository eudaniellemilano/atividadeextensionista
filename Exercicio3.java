package leituraeducativa;

import java.awt.*;
import javax.swing.*;

public class Exercicio3 {
    private static JFrame frame;
    private static int perguntaIndex = 0;
    private static String[] perguntas = {"Qual é o nome do nosso planeta?", "Qual a cor do céu?", "O que usamos no pé?"}; // Array de perguntas
    private static String[] respostas = {"terra", "azul", "sapato"}; // Array de respostas

    public static void iniciarExercicio() {
        frame = new JFrame("Aprenda a ler!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Labels para o painel, titulo e para a pergunta atual:
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Leia e Responda!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        painel.add(titulo, BorderLayout.NORTH);

        JLabel perguntaLabel = new JLabel(perguntas[perguntaIndex]);
        perguntaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        perguntaLabel.setHorizontalAlignment(JLabel.CENTER);
        painel.add(perguntaLabel, BorderLayout.CENTER);
        
     // Campo de texto para a resposta
        JTextField resposta = new JTextField(10);
        resposta.setFont(new Font("Arial", Font.BOLD, 18));
        painel.add(resposta, BorderLayout.SOUTH);
        
        // Botão da confirmação da resposta
        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(e -> {
            String respostaUsuario = resposta.getText().trim().toUpperCase();
            if (respostaUsuario.equalsIgnoreCase(respostas[perguntaIndex])) {
                JOptionPane.showMessageDialog(frame, "Parabéns! Você acertou!");
                perguntaIndex++;
                if (perguntaIndex >= perguntas.length) {
                    JOptionPane.showMessageDialog(frame, "Parabéns! Você concluiu o exercício!");
                    frame.dispose();
                } else {
                    perguntaLabel.setText(perguntas[perguntaIndex]);
                    resposta.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Tente novamente!");
            }
        });
        painel.add(confirmar, BorderLayout.EAST);

        frame.add(painel);
        frame.setVisible(true);
    }
}