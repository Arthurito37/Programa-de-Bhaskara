package application;
/**
 * Este programa tem como objetivo realizar os calculos da formula de Bhaskara
 *
 * Data: 18/05/2024
 * Atualizado em: 01/03/2025
 * Criado por Arthur de Sousa Santana
 **/
import entities.valores;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;



public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        // Criação da janela
        JFrame tela = new JFrame("Minha Janela"); //Cria a Janela Principal
        tela.setSize(700, 500); // Definindo o tamanho da janela
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quando fechar a janela, o programa termina
        tela.setLocationRelativeTo(null); // Centraliza a janela na tela
        tela.setVisible(true); // Isso garante que a janela apareça para o usuário

        // Criando os painéis
        JPanel painelEsquerdo = new JPanel();
        JPanel painelDireito = new JPanel();

        // Definindo tamanho preferido para o painel esquerdo
        painelEsquerdo.setPreferredSize(new Dimension(350, 500));  // Definindo largura de 500px e altura de 500px

        // Configurando o Layout

        painelEsquerdo.setLayout(new FlowLayout(FlowLayout.LEFT)); // Organiza os componentes à esquerda
        painelDireito.setLayout(new GridLayout(4, 3, 5, 5));  // GridLayout para os botões numéricos

        // Adicionando componentes no painel direito (botões numéricos)
        JButton botao1 = new JButton("1");
        JButton botao2 = new JButton("2");
        JButton botao3 = new JButton("3");
        JButton botao4 = new JButton("4");
        JButton botao5 = new JButton("5");
        JButton botao6 = new JButton("6");
        JButton botao7 = new JButton("7");
        JButton botao8 = new JButton("8");
        JButton botao9 = new JButton("9");
        JButton botao0 = new JButton("0");
        JButton botaoigual = new JButton("=");

        painelDireito.add(botao1);
        painelDireito.add(botao2);
        painelDireito.add(botao3);
        painelDireito.add(botao4);
        painelDireito.add(botao5);
        painelDireito.add(botao6);
        painelDireito.add(botao7);
        painelDireito.add(botao8);
        painelDireito.add(botao9);
        painelDireito.add(botao0);
        painelDireito.add(botaoigual);


        painelEsquerdo.add(new JLabel("Tela de Exibição:"));
        JTextArea areaTexto = new JTextArea(2, 10);  // Área de texto para mostrar a mensagem
        painelEsquerdo.add(new JScrollPane(areaTexto));

        // Configurando a cor de fundo dos painéis
        painelEsquerdo.setBackground(Color.LIGHT_GRAY);
        painelDireito.setBackground(Color.white);

        // Criando um painel principal (com o Layout do tipo BorderLayout)
        JPanel painelPrincipal = new JPanel();  // Agora a declaração do painelPrincipal
        painelPrincipal.setLayout(new BorderLayout());  // Layout que divide a tela em 5 áreas (Norte, Sul, Leste, Oeste, Centro)

        painelPrincipal.add(painelEsquerdo, BorderLayout.WEST);  // Painel esquerdo
        painelPrincipal.add(painelDireito, BorderLayout.CENTER); // Painel direito no centro

        // Adicionando o painel principal na janela
        tela.add(painelPrincipal);

        // Tornando a janela visível
        tela.setVisible(true);

        // Adicionando o ActionListener para cada botão numérico
        botao1.addActionListener(e -> areaTexto.append("1"));
        botao2.addActionListener(e -> areaTexto.append("2"));
        botao3.addActionListener(e -> areaTexto.append("3"));
        botao4.addActionListener(e -> areaTexto.append("4"));
        botao5.addActionListener(e -> areaTexto.append("5"));
        botao6.addActionListener(e -> areaTexto.append("6"));
        botao7.addActionListener(e -> areaTexto.append("7"));
        botao8.addActionListener(e -> areaTexto.append("8"));
        botao9.addActionListener(e -> areaTexto.append("9"));
        botao0.addActionListener(e -> areaTexto.append("0"));
        botao0.addActionListener(e -> areaTexto.append("="));

        valores x = new valores();
        x.d = 0;
        while (x.d >= 0){
            x.a = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor de A")); //Abre um dialogo pedindo o valor de A
            x.b = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor de B")); //Abre um dialogo pedindo o valor de B
            x.c = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor de C")); //Abre um dialogo pedindo o valor de C

            double delta = x.b * x.b - 4 * x.a * x.c; //Faz o calculo de delta
            JOptionPane.showMessageDialog(null, String.format("O valor de delta é: %.2f", delta));// Abre um dialogo onde mostra o valor de delta para o usuario
            if (delta > 0) { // Se o delta for maior que xeor ele faz o calculo de x1 e x2.
                double x1 = ((-x.b) + Math.sqrt(delta)) / 2 * x.a; // faz o calculo de x1.
                double x2 = ((-x.b) - Math.sqrt(delta)) / 2 * x.a; // faz o calculo de x2.

                JOptionPane.showMessageDialog(null, String.format("O valor de x1 é: %.2f", x1)); // Abre um dialogo onde mostra o valor de x1 para o usuario
                JOptionPane.showMessageDialog(null, String.format("O valor de x2 é: %.2f", x2)); // Abre um dialogo onde mostra o valor de x2 para o usuario
            } else { // Se o delta for menor que 0 executa o codigo abaixo
                JOptionPane.showMessageDialog(null, "O delta nao pode ser menor que zero", "Erro", JOptionPane.ERROR_MESSAGE); // Abre uma mensagem de erro ao usuario onde mostra que o delta e menor que zero
            }
            x.confirm =JOptionPane.showConfirmDialog(null, String.format("Deseja realizar mais utilizando a fórmula de baskhara?")); //Pergunta ao usuario se deseja realizar mais calculos
            if (x.confirm == JOptionPane.NO_OPTION){ //Se a resposta for nao executa o codigo abaixo
                JOptionPane.showMessageDialog(null, "Ok, tenha um ótimo dia."); // apresenta essa mensagem ao usuario
                x.d = -10; // atribui o valor a 10 que faz com que o programa se encerre
                System.exit(0); //encerra o programa
            }
        }
        // Tornando a janela visível

    }
}