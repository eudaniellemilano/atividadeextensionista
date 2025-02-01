package leituraeducativa;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent; // Classe para os eventos (cliques)
import java.awt.event.ActionListener; // Definição de um listener de eventos

public class Exercicio1 {
    private static String[] palavras = {"GATO", "CASA", "CARRO"};
    private static String[] palavrasIncompletas = {"GA_ _", "CA_ _", "C_RR_"};
    private static int index = 0;

    public static void iniciarExercicio1(JFrame frame) {
    	// Nova janela, para o usuário ter a escolha de sair do exercício
        JFrame exercicioFrame = new JFrame("Exercício 1");
        exercicioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exercicioFrame.setSize(400, 300);
        
        // Painel do exercicío
        JPanel exercicioPanel = new JPanel();
        exercicioPanel.setLayout(new BorderLayout());

        // Titulo do exercício
        JLabel titulo = new JLabel("Qual a palavra?", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        exercicioPanel.add(titulo, BorderLayout.NORTH);

        // Label para quando a palavra for a errada
        JLabel palavraIncompletaLabel = new JLabel(palavrasIncompletas[index], SwingConstants.CENTER);
        palavraIncompletaLabel.setFont(new Font("Arial", Font.BOLD, 36));
        exercicioPanel.add(palavraIncompletaLabel, BorderLayout.CENTER);
        
        // Painel para o input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        inputField.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(inputField);

        exercicioPanel.add(inputPanel, BorderLayout.SOUTH);
        
        // criaçao do botão confirmar
        JButton confirmarButton = new JButton("Confirmar");
        
     // Adiciona um listener para o botão confirmar
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resposta = inputField.getText().trim().toUpperCase();
                if (resposta.equals(palavras[index])) {
                    JOptionPane.showMessageDialog(exercicioFrame, "Parabéns! Você acertou!");
                    index = (index + 1) % palavras.length; // Avança para a próxima quando a resposta for respondida corretamente
                    palavraIncompletaLabel.setText(palavrasIncompletas[index]); // Atualiza o label da palvra
                    inputField.setText("");
                    if (index == 0) {
                        JOptionPane.showMessageDialog(exercicioFrame, "Você concluiu o exercício!");
                        exercicioFrame.dispose(); // Quando a questao for respondida corretamente
                    }
                } else {
                    JOptionPane.showMessageDialog(exercicioFrame, "Tente novamente!"); // Mostra uma mensagem de erro quando a resposta for incorreta
                }
            }
        });
     // Adiciona o botão confirmar ao painel principal
        exercicioPanel.add(confirmarButton, BorderLayout.EAST); 

     // Adiciona o painel principal à janela do exercício
        exercicioFrame.add(exercicioPanel);
        exercicioFrame.setVisible(true);
    }
}