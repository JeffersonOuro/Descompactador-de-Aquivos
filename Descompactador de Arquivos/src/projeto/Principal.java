
package projeto;

import java.util.Scanner;


public class Principal {

    public static Scanner entrada;

    public static void main(String[] args) {
        CompactaDescompacta compactaDescompacta = new CompactaDescompacta();
        entrada = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("(1) Compactar arquivo ");
            System.out.println("(2) Descompactar arquivo");
            System.out.println("(3) Sair");
            System.out.print("Digite a Opção :");
            int escolha = entrada.nextInt();
            String nome;
            System.out.println();
            switch (escolha) {
                case 1:
                    System.out.print("Informe o nome do arquivo a ser compactado: ");
                    nome = entrada.next();
                    compactaDescompacta.compactar(nome);
                    System.out.println("\n------Arquivo Descompactado------");
                    ExibirArquivo arqCompacta = new ExibirArquivo();
                    arqCompacta.visualizar(nome);
                    System.out.println("\n------Arquivo Compactado------");
                    arqCompacta.visualizar("descompactar.txt");
                    break;
                    
                case 2:
                    System.out.print("Informe o nome do arquivo a ser descompactado: ");
                    nome = entrada.next();
                    compactaDescompacta.descompactar(nome);
                    ExibirArquivo arqDescompacta = new ExibirArquivo();
                    System.out.println("\n------Arquivo compactado------");
                    arqDescompacta.visualizar(nome);
                    System.out.println("\n------Arquivo descompactado------");
                    arqDescompacta.visualizar("compactar.txt");
                    break;
                    
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida ");
            }
            System.out.println();
        }
        System.out.println("Fim do programa ");

    }

}
