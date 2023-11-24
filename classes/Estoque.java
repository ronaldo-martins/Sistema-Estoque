package classes;
import java.util.Date;

public class Estoque {
    
    private int quantidadeDisponivel;
    private Date dataAtualizacao;

    public Estoque(int quantidadeDisponivel, Date dataAtualizacao) {
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    /*
    public static void incluirEstoqueProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o código do produto para incluir o estoque:");
        int codigoProduto = scanner.nextInt();
    
        Produto produtoSelecionado = encontrarProdutoPorCodigo(produtos, codigoProduto);
    
        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado com o código: " + codigoProduto);
            return;
        }
    
        // Solicitar informações do estoque
        Estoque novoEstoque = coletarInformacoesEstoque();
    
        // Vincular o novo estoque ao produto
        produtoSelecionado.setEstoque(novoEstoque);
    
        System.out.println("Estoque incluído com sucesso para o produto: " + produtoSelecionado.getNome() + produtoSelecionado.getCodigo());
    }
    
    public static Produto encontrarProdutoPorCodigo(List<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;  // Produto não encontrado
    }

    public static void consultarEstoqueProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o código do produto para consultar o estoque:");
        int codigoProduto = scanner.nextInt();
    
        Produto produtoSelecionado = encontrarProdutoPorCodigo(produtos, codigoProduto);
    
        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado com o código: " + codigoProduto);
            return;
        }
    
        if (produtoSelecionado.getEstoque() != null) {
            System.out.println("Nome do Produto: " + produtoSelecionado.getNome());
            System.out.println("Quantidade em Estoque: " + produtoSelecionado.getEstoque().getQuantidadeDisponivel());
            System.out.println("Data de Atualização: " + produtoSelecionado.getEstoque().getDataAtualizacao());
        } else {
            System.out.println("Produto não possui estoque registrado.");
        }
    }

    public static void alterarEstoqueProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o código do produto para alterar o estoque:");
        int codigoProduto = scanner.nextInt();
    
        Produto produtoSelecionado = encontrarProdutoPorCodigo(produtos, codigoProduto);
    
        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado com o código: " + codigoProduto);
            return;
        }
    
        if (produtoSelecionado.getEstoque() != null) {
            // Solicitar novas informações do estoque
            Estoque novoEstoque = coletarInformacoesEstoque();
    
            // Atualizar o estoque do produto
            produtoSelecionado.setEstoque(novoEstoque);
    
            System.out.println("Estoque alterado com sucesso para o produto: " + produtoSelecionado.getNome());
        } else {
            System.out.println("Produto não possui estoque registrado. Utilize a opção de inclusão.");
        }
    }

    public static void excluirEstoqueProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o código do produto para excluir o estoque:");
        int codigoProduto = scanner.nextInt();
    
        Produto produtoSelecionado = encontrarProdutoPorCodigo(produtos, codigoProduto);
    
        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado com o código: " + codigoProduto);
            return;
        }
    
        if (produtoSelecionado.getEstoque() != null) {
            // Remover o estoque do produto
            produtoSelecionado.setEstoque(null);
    
            System.out.println("Estoque excluído com sucesso para o produto: " + produtoSelecionado.getNome());
        } else {
            System.out.println("Produto não possui estoque registrado.");
        }
    }

    public static void imprimirListaEstoques(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }
    
        System.out.println("Lista de Estoques:");
        for (Produto produto : produtos) {
            if (produto.getEstoque() != null) {
                System.out.println("Produto: " + produto.getNome());
                System.out.println("Quantidade em Estoque: " + produto.getEstoque().getQuantidadeDisponivel());
                System.out.println("Data de Atualização: " + produto.getEstoque().getDataAtualizacao());
                System.out.println("------------------------------");
            }
        }
    }

    public static Estoque coletarInformacoesEstoque() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha pendente
    
        Date dataAtualizacao = coletarDataAtualizacao();
    
        // Crie um novo objeto Estoque com as informações coletadas
        Estoque estoque = new Estoque(quantidadeEstoque, dataAtualizacao);
    
        return estoque;
    }

    public static Date coletarDataAtualizacao() {
        Scanner scanner = new Scanner(System.in);
        Date dataAtualizacao = null;
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Define o formato de data como estrito
    
        while (dataAtualizacao == null) {
            System.out.println("Informe a data de atualização (no formato dd-MM-yyyy): ");
            String dataInput = scanner.nextLine();
    
            try {
                dataAtualizacao = dateFormat.parse(dataInput);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }
        return dataAtualizacao;
    }
    */
    
}
