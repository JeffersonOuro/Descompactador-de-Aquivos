
package projeto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ValidarDados {

    // Verifica se o valor é um inteiro
    public boolean verificaInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static int countMatches(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    public boolean validaEspecial(String palavra) {
        Pattern pattern = Pattern.compile("[\\WÀ-ú\\[!#@$%¨&*[]],.]");
        Matcher match = pattern.matcher(palavra);
        return match.find();
    }

    public String[] separarEspecial(String palavra) {
        Pattern pattern = Pattern.compile("[\\WÀ-ú\\[!#@$%¨&*[]],.]");
        Matcher match = pattern.matcher(palavra);

        String charsEspeciais[] = new String[countMatches(match)];

        match = pattern.matcher(palavra);

        // Colocando os caracteres especiais em um array
        for (int i = 0; match.find(); i++) {
            charsEspeciais[i] = match.group();
        }

        // Váriavel onde vai ser armazenado o texto formatado
        String textFormat = "";
        int cont = 0;
        boolean aux = false;

        for (int i = 0; i < palavra.length(); i++) {

            String letra = palavra.charAt(i) + "";

            /* Quando o vetor ser 100% percorrido esse if ira prevenir que
             * o código quebre na proxima verifiação */
            if (cont == charsEspeciais.length) {
                cont = 0;
            }

            if (letra.equals(charsEspeciais[cont])) {
                textFormat += " " + letra;
                cont++;
                if (!aux) {
                    aux = true;
                }
            } else {
                if (aux) {
                    textFormat += " " + "";
                    aux = false;
                }
                textFormat += letra;
            }
        }
        String formatFinal[] = textFormat.split(" ");

        return formatFinal;
    }
}
