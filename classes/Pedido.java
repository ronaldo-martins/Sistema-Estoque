package classes;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    
    private int produtoID;
    private Date dataPedido;
    private String situacaoPedido;
    private ArrayList<ItemPedido> listaDeItens;
    
    public Pedido(int produtoID, ArrayList<ItemPedido> listaDeItens, Date dataPedido, String situacaoPedido) {
        this.produtoID = produtoID;
        this.listaDeItens = listaDeItens;
        this.dataPedido = dataPedido;
        this.situacaoPedido = situacaoPedido;
    }


    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }
    
    public ArrayList<ItemPedido> getListaDeItens() {
        return listaDeItens;
    }
    public void setListaDeItens(ArrayList<ItemPedido> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }
    

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(String situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }


}
