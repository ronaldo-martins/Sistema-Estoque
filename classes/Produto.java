package classes;
import java.util.Scanner;

public class Produto {

    private String nome;
    private double preco;
    private int codigo;
    private Estoque estoque;
    private Categoria categoria;

    Scanner entrada = new Scanner(System.in);

    public Produto(String nome, double preco, int codigo, Categoria categoria, Estoque estoque) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Estoque getEstoque() {
        return estoque;
    }
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
        public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    /* 
    private static void incluirNovoProduto() {
        Produto novoProduto = coletarInformacoesProduto();
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso.");
    }

    private static void consultarProduto() {
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }

        System.out.println("Informe o código do produto que deseja consultar: ");
        int codigoConsulta = new Scanner(System.in).nextInt();

        Produto produtoEncontrado = buscarProdutoPorCodigo(codigoConsulta);

        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado:");
            System.out.println("Nome: " + produtoEncontrado.getNome());
            System.out.println("Preço: " + produtoEncontrado.getPreco());
            System.out.println("Código: " + produtoEncontrado.getCodigo());
            System.out.println("Categoria: " + produtoEncontrado.getCategoria().getNomeCategoria());
            System.out.println("Estoque: " + produtoEncontrado.getEstoque().getQuantidadeDisponivel());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void alterarProduto() {
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }

        System.out.println("Informe o código do produto que deseja alterar: ");
        int codigoAlteracao = new Scanner(System.in).nextInt();

        Produto produtoParaAlterar = buscarProdutoPorCodigo(codigoAlteracao);

        if (produtoParaAlterar != null) {
            System.out.println("Produto encontrado. Informe os novos dados:");

            Produto novosDados = coletarInformacoesProduto();

            // Atualize os dados do produto
            produtoParaAlterar.setNome(novosDados.getNome());
            produtoParaAlterar.setPreco(novosDados.getPreco());
            produtoParaAlterar.setCategoria(novosDados.getCategoria());
            produtoParaAlterar.setEstoque(novosDados.getEstoque());

            System.out.println("Produto alterado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void excluirProduto() {
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }

        System.out.println("Informe o código do produto que deseja excluir: ");
        int codigoExclusao = new Scanner(System.in).nextInt();

        Produto produtoParaExcluir = buscarProdutoPorCodigo(codigoExclusao);

        if (produtoParaExcluir != null) {
            produtos.remove(produtoParaExcluir);
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void imprimirListaProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço: " + produto.getPreco());
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Categoria: " + produto.getCategoria().getNomeCategoria());
                System.out.println("Estoque: " + produto.getEstoque().getQuantidadeDisponivel());
                System.out.println("------------------------------");
            }
        }
    }

    private static Produto coletarInformacoesProduto() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o nome do produto: ");
        String nome = scanner.nextLine();
    
        System.out.println("Informe o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
    
        int codigo;
        while (true) {
            System.out.println("Informe o código do produto: ");
            codigo = scanner.nextInt();
    
            if (codigoRepetido(produtos, codigo)) {
                System.out.println("Erro: Código já existe. Escolha outro código.");
            } else {
                break;
            }
        }
    
        Categoria categoria = selecionarCategoriaExistenteOuCriarNova(categorias);
    
        Estoque estoque = coletarInformacoesEstoque();
    
        return new Produto(nome, preco, codigo, categoria, estoque);
    }
    */
}
