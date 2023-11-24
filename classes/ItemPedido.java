package classes;
public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemPedido(Produto produto, int quantidade, double subtotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

   
}
