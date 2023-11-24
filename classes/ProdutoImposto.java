package classes;
public class ProdutoImposto extends Produto {

    private double imposto;

    public ProdutoImposto(String nome, double preco, int codigo, Categoria categoria, Estoque estoque, Double imposto) {
        super(nome, preco, codigo, categoria, estoque);
        this.imposto = imposto;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
}