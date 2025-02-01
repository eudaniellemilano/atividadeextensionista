package leituraeducativa;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Exercicio2 {
    private static JFrame frame;
    private static int perguntaIndex = 0;
    private static String[] palavras = {"GATO", "BOLA", "CASA"}; // Array de palavras
    private static String[] respostas = {"GATO", "BOLA", "CASA"}; // Array de respostas corretas

    public static void iniciarExercicio() {
        frame = new JFrame("Aprenda a ler!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Organize a palavra!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        painel.add(titulo, BorderLayout.NORTH);
        
        // Embaralhamento da palavra atual
        String palavraEmbaralhada = embaralharPalavra(palavras[perguntaIndex]);
        // Label para a palavra já embaralhada
        JLabel palavraEmbaralhadaLabel = new JLabel(palavraEmbaralhada);
        palavraEmbaralhadaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        palavraEmbaralhadaLabel.setHorizontalAlignment(JLabel.CENTER);
        painel.add(palavraEmbaralhadaLabel, BorderLayout.CENTER);

        JTextField resposta = new JTextField(10);
        resposta.setFont(new Font("Arial", Font.BOLD, 18));
        painel.add(resposta, BorderLayout.SOUTH);

        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(e -> {
            String respostaUsuario = resposta.getText().trim().toUpperCase();
            
         // Verifica se a resposta está certa
            if (respostaUsuario.equals(respostas[perguntaIndex])) {
                JOptionPane.showMessageDialog(frame, "Parabéns! Você acertou!");
                perguntaIndex++;
                
             // Verifica se o usuário concluiu o exercício
                if (perguntaIndex >= palavras.length) {
                    JOptionPane.showMessageDialog(frame, "Parabéns! Você concluiu o exercício!");
                    frame.dispose();
                } else {
                	// Embaralha a próxima palavra
                    palavraEmbaralhadaLabel.setText(embaralharPalavra(palavras[perguntaIndex]));
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
    // Função para embaralhar uma palavra
    private static String embaralharPalavra(String palavra) {
        char[] letras = palavra.toCharArray(); // Transforma a palavra em uma array de caracteres
        Random rand = new Random(); // Random para gerar números aleatórios
        for (int i = 0; i < letras.length; i++) {
            int j = rand.nextInt(letras.length); // Índice aleatório para trocar as letras
            // Troca das letras
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }
        return new String(letras); // Conversao de array para string
    }
}