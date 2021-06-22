package projeto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class CompactaDescompacta {

    public void compactar(String arqCompactar) {

        String linha;
        String textoConteudo = "";

        ValidarDados tratar = new ValidarDados();
        ListaEncadeada texto = new ListaEncadeada();
        
        /* Lendo um arquivo existente */
        try {
            Scanner leitor = new Scanner(new FileInputStream(arqCompactar));

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
                    //escrever.print(texto.buscaIndice(palavra) + "\n");
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

    public void descompactar(String arqDescompactar) {

        String linha;
        String textoConteudo = "";

        ValidarDados tratar = new ValidarDados();
        ListaEncadeada desco = new ListaEncadeada();

        try {
            Scanner leitor = new Scanner(new FileInputStream(arqDescompactar));

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
                    escrever.print(aux + "\n");

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
