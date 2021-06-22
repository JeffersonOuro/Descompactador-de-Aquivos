package projeto;

import java.io.*;
import java.util.Scanner;

public class Descompactador {

    public static void main(String[] args) {

        String linha;
        String textoConteudo = "";

        ValidarDados tratar = new ValidarDados();
        ListaEncadeada desco = new ListaEncadeada();

        try {
            Scanner leitor = new Scanner(new FileInputStream("descompactar.txt"));

            // Converetendo texto do arquivo em uma unica variavel de texto
            while (leitor.hasNextLine()) {
                linha = leitor.nextLine();
                textoConteudo += linha;
            }

            // Convetendo o texto em um vetor de palavras
            String linhas[] = textoConteudo.split(" ");

            /* Saida de texto compactado */
            PrintStream escrever = new PrintStream("compactar.txt");

            /* 
                Auxiliar para inserir as palavras no inicio da lista
                Indice para indicar onde esta a palavra
             */
            String aux;
            int indice;
            for (String palavra : linhas) {

                if (tratar.verificaInt(palavra)) {

                    // Convertendo o numero String para inteiro Int
                    indice = Integer.parseInt(palavra);

                    /* Usando o indice para retornar a palavra e guardando 
                     * em auxiliar. */
                    aux = desco.buscaValor(indice);
                    escrever.print(aux + " ");

                    // Removendo o indice( palavra ) e a palavra repetida( aux )
                    desco.removeOrdenado(palavra);
                    desco.removeOrdenado(aux);
                    // Inserindo valor no inicio da lista
                    desco.insereInicio(aux);

                } else if (tratar.validaEspecial(palavra)) {
                    String separados[] = tratar.separarEspecial(palavra);

                    for (String tratados : separados) {
                        if (!tratados.equals(" ") && !tratados.equals("")) {
                            if (tratar.validaEspecial(tratados)) {
                                escrever.print(tratados);
                            } else {
                                if (desco.busca(tratados)) {

                                    indice = Integer.parseInt(tratados);

                                    /* Usando o indice para retornar a palavra e guardando 
                                     * em auxiliar. */
                                    aux = desco.buscaValor(indice);
                                    escrever.print(aux + " ");

                                    // Removendo o indice( palavra ) e a palavra repetida( aux )
                                    desco.removeOrdenado(tratados);
                                    desco.removeOrdenado(aux);
                                    // Inserindo valor no inicio da lista
                                    desco.insereInicio(aux);
                                } else if (tratar.verificaInt(tratados)) {

                                    // Convertendo o numero String para inteiro Int
                                    indice = Integer.parseInt(tratados);

                                    /* Usando o indice para retornar a palavra e guardando 
                                     * em auxiliar. */
                                    aux = desco.buscaValor(indice);
                                    escrever.print(aux + " ");

                                    // Removendo o indice( palavra ) e a palavra repetida( aux )
                                    desco.removeOrdenado(tratados);
                                    desco.removeOrdenado(aux);
                                    // Inserindo valor no inicio da lista
                                    desco.insereInicio(aux);

                                } else {
                                    desco.insereInicio(tratados);
                                    escrever.print(tratados + " ");
                                }
                            }
                        }
                    }

                } else {

                    /* Caso o valor não seja um Int significa que não é um indice
                 * E insere diretamente no inicio da lista e escreve 
                 * no arquivo */
                    desco.insereInicio(palavra);
                    escrever.print(palavra + " ");
                }
            }
        } catch (FileNotFoundException erro) {
            System.out.println("arquivo não encontrado.");

        }
    }
}
