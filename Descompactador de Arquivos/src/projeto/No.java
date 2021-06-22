package projeto;


public class No {

    private String elemento;
    private No prox;

    public No(String elemento, No prox) {
        this.elemento = elemento;
        this.prox = prox;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

}
