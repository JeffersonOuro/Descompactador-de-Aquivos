package projeto;


public class ListaEncadeada {

    No ini;

    public ListaEncadeada() {
        this.ini = null;
    }

    public boolean vazia() {
        return ini == null;
    }

    @Override
    public String toString() {
        String strLista = "";
        No temp = ini;

        while (temp != null) {
            strLista += temp.getElemento() + " ";
            temp = temp.getProx();
        }

        return strLista;
    }

    public void insereInicio(String elemento) {
        No novo = new No(elemento, ini);
        ini = novo;
    }

    /* Procura paralvra */
    public boolean busca(String x) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento().equals(x)) {
                return true; //achou
            }
            temp = temp.getProx();
        }
        return false; //Não achou
    }

    public String buscaIndice(String x) {
        No temp = ini;
        int i = 1;

        while (temp != null) {
            if (temp.getElemento().equals(x)) {
                return i + ""; //achou
            }
            i++;
            temp = temp.getProx();
        }
        return null; //Não achou
    }

    public String buscaValor(int indice) {
        No temp = ini;

        for (int i = 1; i < indice; i++) {
            temp = temp.getProx();
        }

        return temp.getElemento();
    }

    public void removeOrdenado(String x) {
        if (vazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        No temp = ini;
        No anterior = null;

        while (temp != null && !(temp.getElemento().equals(x))) {
            anterior = temp;
            temp = temp.getProx();
        }
        if (anterior == null) {
            ini = ini.getProx();
            return;
        }
        if (temp != null && temp.getElemento().equals(x)) {
            anterior.setProx(temp.getProx());
        }
    }

}
