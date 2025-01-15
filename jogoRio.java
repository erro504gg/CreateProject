import java.util.Scanner;

public class jogoRio {
    private static boolean loboNoLadoEsquerdo = true;
    private static boolean ovelhaNoLadoEsquerdo = true;
    private static boolean repolhoNoLadoEsquerdo = true;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            mostrarEstado();
            
            System.out.println("Escolha uma ação:");
            System.out.println("1. Levar o lobo");
            System.out.println("2. Levar a ovelha");
            System.out.println("3. Levar o repolho");
            System.out.println("4. Sair");
            int escolha = scanner.nextInt();
            
            if (escolha == 1) {
                if (loboNoLadoEsquerdo) {
                    moverLobo();
                } else {
                    System.out.println("O lobo já está do outro lado.");
                }
            } else if (escolha == 2) {
                if (ovelhaNoLadoEsquerdo) {
                    moverOvelha();
                } else {
                    System.out.println("A ovelha já está do outro lado.");
                }
            } else if (escolha == 3) {
                if (repolhoNoLadoEsquerdo) {
                    moverRepolho();
                } else {
                    System.out.println("O repolho já está do outro lado.");
                }
            } else if (escolha == 4) {
                System.out.println("Saindo do jogo...");
                break;
            } else {
                System.out.println("Escolha inválida.");
            }
            
            if (loboNoLadoEsquerdo == false && ovelhaNoLadoEsquerdo == false && repolhoNoLadoEsquerdo == false) {
                System.out.println("Parabéns! Você conseguiu atravessar tudo com segurança.");
                break;
            }
        }
        
        scanner.close();
    }

    public static void mostrarEstado() {
        System.out.println("\nEstado atual:");
        System.out.print("Lado Esquerdo: ");
        if (loboNoLadoEsquerdo) System.out.print("Lobo ");
        if (ovelhaNoLadoEsquerdo) System.out.print("Ovelha ");
        if (repolhoNoLadoEsquerdo) System.out.print("Repolho ");
        System.out.println();
        
        System.out.print("Lado Direito: ");
        if (!loboNoLadoEsquerdo) System.out.print("Lobo ");
        if (!ovelhaNoLadoEsquerdo) System.out.print("Ovelha ");
        if (!repolhoNoLadoEsquerdo) System.out.print("Repolho ");
        System.out.println("\n");
    }

    public static void moverLobo() {
        if (ovelhaNoLadoEsquerdo) {
            System.out.println("Você não pode deixar o lobo sozinho com a ovelha!");
        } else {
            loboNoLadoEsquerdo = !loboNoLadoEsquerdo;
            System.out.println("Você levou o lobo para o outro lado.");
        }
    }

    public static void moverOvelha() {
        if (repolhoNoLadoEsquerdo && loboNoLadoEsquerdo) {
            System.out.println("Você não pode deixar a ovelha sozinha com o repolho!");
        } else {
            ovelhaNoLadoEsquerdo = !ovelhaNoLadoEsquerdo;
            System.out.println("Você levou a ovelha para o outro lado.");
        }
    }

    public static void moverRepolho() {
        if (ovelhaNoLadoEsquerdo) {
            System.out.println("Você não pode deixar o repolho sozinho com a ovelha!");
        } else {
            repolhoNoLadoEsquerdo = !repolhoNoLadoEsquerdo;
            System.out.println("Você levou o repolho para o outro lado.");
        }
    }
}
