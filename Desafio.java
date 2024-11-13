import javax.swing.*;

public class Desafio{

    public static void main(String[] args) {
        // Exibe o menu de opções usando JOptionPane
        String menu = "Escolha uma opção de 1 a 6:\n"
                    + "1 - Conversor de Temperatura (Celsius para Fahrenheit)\n"
                    + "2 - Média Salarial\n"
                    + "3 - Quantidade de Azulejos para uma Parede\n"
                    + "4 - Cálculo de Volume de uma Lata de Óleo\n"
                    + "5 - Cálculo do Valor da Conta de Luz\n"
                    + "6 - Cálculo do Valor de Gasolina para Viagem";

        String opcaoStr = JOptionPane.showInputDialog(null, menu, "Desafio Calculadora", JOptionPane.QUESTION_MESSAGE);
        
        if (opcaoStr == null || opcaoStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Opção inválida ou cancelada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcao = Integer.parseInt(opcaoStr);

        switch (opcao) {
            case 1:
                conversorTemperatura();
                break;
            case 2:
                mediaSalarial();
                break;
            case 3:
                quantidadeAzulejos();
                break;
            case 4:
                volumeLataOleo();
                break;
            case 5:
                valorContaLuz();
                break;
            case 6:
                valorGasolina();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número de 1 a 6.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    // Função para converter Celsius para Fahrenheit
    public static void conversorTemperatura() {
        String input = JOptionPane.showInputDialog("Digite a temperatura em Celsius:");
        if (input == null || input.isEmpty()) return;
        
        double celsius = Double.parseDouble(input);
        double fahrenheit = (celsius * 9/5) + 32;
        JOptionPane.showMessageDialog(null, "Temperatura em Fahrenheit: " + fahrenheit);
    }

    // Função para calcular a média salarial
    public static void mediaSalarial() {
        String input = JOptionPane.showInputDialog("Quantos salários você deseja calcular?");
        if (input == null || input.isEmpty()) return;
        
        int n = Integer.parseInt(input);
        double soma = 0;
        
        for (int i = 1; i <= n; i++) {
            String salarioInput = JOptionPane.showInputDialog("Digite o valor do salário " + i + ":");
            if (salarioInput == null || salarioInput.isEmpty()) return;
            
            double salario = Double.parseDouble(salarioInput);
            soma += salario;
        }
        
        double media = soma / n;
        JOptionPane.showMessageDialog(null, "A média salarial é: R$ " + media);
    }

    // Função para calcular a quantidade de azulejos por parede
    public static void quantidadeAzulejos() {
        String alturaInput = JOptionPane.showInputDialog("Digite a altura da parede (em metros):");
        if (alturaInput == null || alturaInput.isEmpty()) return;

        double altura = Double.parseDouble(alturaInput);
        
        String larguraInput = JOptionPane.showInputDialog("Digite a largura da parede (em metros):");
        if (larguraInput == null || larguraInput.isEmpty()) return;

        double largura = Double.parseDouble(larguraInput);

        String tamanhoAzulejoInput = JOptionPane.showInputDialog("Digite o tamanho de um azulejo (em metros quadrados):");
        if (tamanhoAzulejoInput == null || tamanhoAzulejoInput.isEmpty()) return;

        double tamanhoAzulejo = Double.parseDouble(tamanhoAzulejoInput);

        double areaParede = altura * largura;
        int quantidadeAzulejos = (int) Math.ceil(areaParede / tamanhoAzulejo);
        JOptionPane.showMessageDialog(null, "Quantidade de azulejos necessária: " + quantidadeAzulejos);
    }

    // Função para calcular o volume de uma lata de óleo
    public static void volumeLataOleo() {
        String raioInput = JOptionPane.showInputDialog("Digite o raio da lata (em metros):");
        if (raioInput == null || raioInput.isEmpty()) return;

        double raio = Double.parseDouble(raioInput);

        String alturaInput = JOptionPane.showInputDialog("Digite a altura da lata (em metros):");
        if (alturaInput == null || alturaInput.isEmpty()) return;

        double altura = Double.parseDouble(alturaInput);

        // Fórmula do volume do cilindro: V = pi * r² * h
        double volume = Math.PI * Math.pow(raio, 2) * altura;
        JOptionPane.showMessageDialog(null, "O volume da lata de óleo é: " + volume + " metros cúbicos.");
    }

    // Função para calcular o valor da conta de luz
    public static void valorContaLuz() {
        String consumoInput = JOptionPane.showInputDialog("Digite o consumo de energia (em kWh):");
        if (consumoInput == null || consumoInput.isEmpty()) return;

        double consumo = Double.parseDouble(consumoInput);

        String valorKWhInput = JOptionPane.showInputDialog("Digite o valor do kWh (em R$):");
        if (valorKWhInput == null || valorKWhInput.isEmpty()) return;

        double valorKWh = Double.parseDouble(valorKWhInput);

        double valorConta = consumo * valorKWh;
        JOptionPane.showMessageDialog(null, "O valor da sua conta de luz é: R$ " + valorConta);
    }

    // Função para calcular o valor de gasolina para uma viagem
    public static void valorGasolina() {
        String distanciaInput = JOptionPane.showInputDialog("Digite a distância da viagem (em quilômetros):");
        if (distanciaInput == null || distanciaInput.isEmpty()) return;

        double distancia = Double.parseDouble(distanciaInput);

        String consumoCarroInput = JOptionPane.showInputDialog("Digite o consumo do carro (km/l):");
        if (consumoCarroInput == null || consumoCarroInput.isEmpty()) return;

        double consumoCarro = Double.parseDouble(consumoCarroInput);

        String precoGasolinaInput = JOptionPane.showInputDialog("Digite o preço da gasolina (R$ por litro):");
        if (precoGasolinaInput == null || precoGasolinaInput.isEmpty()) return;

        double precoGasolina = Double.parseDouble(precoGasolinaInput);

        double litrosNecessarios = distancia / consumoCarro;
        double valorGasolina = litrosNecessarios * precoGasolina;
        JOptionPane.showMessageDialog(null, "O valor estimado de gasolina para a viagem é: R$ " + valorGasolina);
    }
}
