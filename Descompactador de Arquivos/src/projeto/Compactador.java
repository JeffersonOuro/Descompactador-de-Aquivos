package projeto;

import java.io.*;
import java.util.Scanner;

public class Compactador {
    
    
    public static void main(String[] args) {

        String linha;
        String textoConteudo = "";

        ValidarDados tratar = new ValidarDados();
        ListaEncadeada texto = new ListaEncadeada();

        /* Lendo um arquivo existente */
        try {
            Scanner leitor = new Scanner(new FileInputStream("compactar.txt"));
            // Converetendo texto do arquivo em uma unica variavel de texto
            while (leitor.hasNextLine()) {
                linha = leitor.nextLine();
                textoConteudo += linha;
                
            }
            // Convetendo o texto em um vetor de palavras
            String linhas[] = textoConteudo.split(" ");

            /* Saida de texto compactado */
            PrintStream escrever = new PrintStream("descompactar.txt");

            // Auxiliar para inserir as palavras no inicio da lista
            String aux;

            for (String palavra : linhas) {
                
                if (texto.busca(palavra)) {
                    
                    escrever.print(" " + texto.buscaIndice(palavra));

                    // Lista Mover atualizada
                    aux = palavra;
                    texto.removeOrdenado(palavra);
                    texto.insereInicio(aux);

                } else if (tratar.validaEspecial(palavra)) {
                    String separados[] = tratar.separarEspecial(palavra);

                    for (String tratados : separados) {
                        if (!tratados.equals(" ") && !tratados.equals("")) {
                            if (tratar.validaEspecial(tratados)) {
                                escrever.print(tratados);

                            } else {
                                if (texto.busca(tratados)) {

                                    escrever.print(" " + texto.buscaIndice(tratados));
                                    // Lista Mover atualizada
                                    aux = tratados;
                                    texto.removeOrdenado(tratados);
                                    texto.insereInicio(aux);
                                } else {
                                    escrever.print(" " + tratados);
                                    texto.insereInicio(tratados);

                                }
                            }
                        }
                    }

                } else {
                    escrever.print(" " + palavra);
                    texto.insereInicio(palavra);

                }
            }

        } catch (FileNotFoundException erro) {
            System.out.println("arquivo não encontrado.");

        }
    }
}
