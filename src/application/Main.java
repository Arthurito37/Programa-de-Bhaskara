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