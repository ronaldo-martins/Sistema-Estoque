package classes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int escolhaPrincipal;

        System.out.println("Bem-vindo ao Sistema de Gerenciamento!");

        // Criando listas
        List<Categoria> categorias = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();


        // Adicionando algumas categorias à lista
        categorias.add(new Categoria("Eletrônicos", "Produtos eletrônicos"));
        categorias.add(new Categoria("Roupas", "Vestuário"));

        // Loop para exibir o menu principal continuamente
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Produtos");
            System.out.println("2. Categorias");
            System.out.println("3. Pedidos");
            System.out.println("4. Estoque");
            System.out.println("0. Sair");

            escolhaPrincipal = entrada.nextInt();

            switch (escolhaPrincipal) {
                case 1:
                    menuProdutos(categorias, produtos);
                    break;
                case 2:
                    menuCategorias(categorias);
                    break;
                case 3:
                    menuPedidos(pedidos);
                    break;
                case 4:
                    menuEstoque(produtos);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    entrada.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    // Menú de produtos


    public static void menuProdutos(List<Categoria> categorias, List<Produto> produtos) {
        Scanner entrada = new Scanner(System.in);
        int escolhaProdutos;

        while (true) {
            System.out.println("Menu de Produtos:");
            System.out.println("1. Incluir novo produto");
            System.out.println("2. Consultar um produto");
            System.out.println("3. Alterar dados de um produto");
            System.out.println("4. Excluir dados de um produto");
            System.out.println("5. Imprimir lista de produtos");
            System.out.println("0. Voltar para o menu principal");

            escolhaProdutos = entrada.nextInt();

            switch (escolhaProdutos) {
                case 1:
                    
                    incluirNovoProduto(produtos, categorias);
                    break;
                case 2:
                    
                    consultarProduto(produtos);
                    break;
                case 3:
                    
                    alterarProduto(produtos, categorias);
                    break;
                case 4:
                    
                    excluirProduto(produtos);
                    break;
                case 5:
                    
                    imprimirListaProdutos(produtos);
                    break;
                case 0:
                    return; // Voltar para o menu principal.
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



    private static void incluirNovoProduto(List<Produto>produtos, List<Categoria>categorias) {
    
        Produto novoProduto = coletarInformacoesProduto(produtos, categorias);
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso.");
                
    
        
    }



    private static void consultarProduto(List<Produto>produtos) {
        Scanner entrada = new Scanner(System.in);

        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            entrada.close();
            return;
        }

        System.out.println("Informe o código do produto que deseja consultar: ");
        
        int codigoConsulta = entrada.nextInt();

        Produto produtoEncontrado = encontrarProdutoPorCodigo(produtos, codigoConsulta);

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
        entrada.close();
    }



    private static void alterarProduto(List<Produto>produtos, List<Categoria>categorias) {
        Scanner entrada = new Scanner(System.in);
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            entrada.close();
            return;
        }

        System.out.println("Informe o código do produto que deseja alterar: ");
        int codigoAlteracao = entrada.nextInt();

        Produto produtoParaAlterar = encontrarProdutoPorCodigo(produtos, codigoAlteracao);

        if (produtoParaAlterar != null) {
            System.out.println("Produto encontrado. Informe os novos dados:");

            Produto novosDados = coletarInformacoesProduto(produtos, categorias);

            // Atualiza os dados do produto
            produtoParaAlterar.setNome(novosDados.getNome());
            produtoParaAlterar.setPreco(novosDados.getPreco());
            produtoParaAlterar.setCategoria(novosDados.getCategoria());
            produtoParaAlterar.setEstoque(novosDados.getEstoque());

            System.out.println("Produto alterado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
        entrada.close();
    }



    private static void excluirProduto(List<Produto>produtos) {
        Scanner entrada = new Scanner(System.in);
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            entrada.close();
            return;
        }

        System.out.println("Informe o código do produto que deseja excluir: ");
        int codigoExclusao = entrada.nextInt();

        Produto produtoParaExcluir = encontrarProdutoPorCodigo(produtos, codigoExclusao);

        if (produtoParaExcluir != null) {
            produtos.remove(produtoParaExcluir);
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
        entrada.close();
    }



    private static void imprimirListaProdutos(List<Produto>produtos) {
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



    //AUXILIAR

    /*private static Produto coletarInformacoesProduto(List<Produto>produtos, List<Categoria>categorias) {
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
                scanner.close();
                break;
            }
        }
    
        Categoria categoria = selecionarCategoriaExistenteOuCriarNova(categorias);
    
        Estoque estoque = coletarInformacoesEstoque();
    
        return new Produto(nome, preco, codigo, categoria, estoque);

    }*/



    public static Produto coletarInformacoesProduto(List<Produto> produtos, List<Categoria> categorias) {
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

        System.out.println("Produto sem imposto digite 0, com imposto digite 1");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            // Lógica específica para produtos com imposto
            System.out.println("Informe a taxa de imposto para o produto (em percentual): ");
            double taxaImposto = scanner.nextDouble();
    
            // Cria um novo objeto ProdutoImposto com as informações coletadas
            ProdutoImposto novoProdutoImposto = new ProdutoImposto(nome, preco, codigo, categoria, estoque, taxaImposto);
    
            return novoProdutoImposto;
        } else {
            // Cria um novo objeto Produto com as informações coletadas
            Produto novoProduto = new Produto(nome, preco, codigo, categoria, estoque);
    
            return novoProduto;
        }
    }


    // Menú de categorias

    public static void menuCategorias(List<Categoria> categorias) {
        Scanner entrada = new Scanner(System.in);
        int escolhaCategorias;
    
        while (true) {
            System.out.println("Menu de Categorias:");
            System.out.println("1. Incluir nova categoria");
            System.out.println("2. Consultar uma categoria");
            System.out.println("3. Alterar dados de uma categoria");
            System.out.println("4. Excluir dados de uma categoria");
            System.out.println("5. Imprimir lista de categorias");
            System.out.println("0. Voltar para o menu principal");
    
            escolhaCategorias = entrada.nextInt();
    
            switch (escolhaCategorias) {
                case 1:
                    Categoria novaCategoria = selecionarCategoriaExistenteOuCriarNova(categorias);
                // Adiciona a novaCategoria à lista de categorias
                    categorias.add(novaCategoria);
                    System.out.println("Categoria adicionada com sucesso.");
                    break;
                case 2:
                    consultarCategoria(categorias);
                    break;
                case 3:
                    alterarCategoria(categorias);
                    break;
                case 4:
                    excluirCategoria(categorias);
                    break;
                case 5:
                    imprimirListaCategorias(categorias);
                    break;
                case 0:
                    return; // Voltar para o menu principal.
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



    public static void consultarCategoria(List<Categoria> categorias) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o nome da categoria que deseja consultar: ");
        String nomeCategoria = scanner.nextLine();
    
        Categoria categoriaEncontrada = null;
    
        // Busca a categoria na lista pelo nome
        for (Categoria categoria : categorias) {
            if (categoria.getNomeCategoria().equalsIgnoreCase(nomeCategoria)) {
                categoriaEncontrada = categoria;
                break;
            }
        }
    
        // Exibe os detalhes da categoria encontrada ou informa que não foi encontrada
        if (categoriaEncontrada != null) {
            System.out.println("Detalhes da Categoria:");
            System.out.println("Nome: " + categoriaEncontrada.getNomeCategoria());
            System.out.println("Descrição: " + categoriaEncontrada.getDescricao());
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }



    public static void alterarCategoria(List<Categoria> categorias) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o nome da categoria que deseja alterar: ");
        String nomeCategoria = scanner.nextLine();
    
        Categoria categoriaEncontrada = null;
    
        // Busca a categoria na lista pelo nome
        for (Categoria categoria : categorias) {
            if (categoria.getNomeCategoria().equalsIgnoreCase(nomeCategoria)) {
                categoriaEncontrada = categoria;
                break;
            }
        }
    
        // Exibe os detalhes da categoria encontrada ou informa que não foi encontrada
        if (categoriaEncontrada != null) {
            System.out.println("Detalhes da Categoria:");
            System.out.println("Nome: " + categoriaEncontrada.getNomeCategoria());
            System.out.println("Descrição: " + categoriaEncontrada.getDescricao());
    
            // Solicita novos dados para a categoria
            System.out.println("Informe a nova descrição da categoria: ");
            String novaDescricao = scanner.nextLine();
            categoriaEncontrada.setDescricao(novaDescricao);
    
            System.out.println("Categoria alterada com sucesso.");
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }



    public static void excluirCategoria(List<Categoria> categorias) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe o nome da categoria que deseja excluir: ");
        String nomeCategoria = scanner.nextLine();
    
        Categoria categoriaEncontrada = null;
    
        // Busca a categoria na lista pelo nome
        for (Categoria categoria : categorias) {
            if (categoria.getNomeCategoria().equalsIgnoreCase(nomeCategoria)) {
                categoriaEncontrada = categoria;
                break;
            }
        }
    
        // Exclui a categoria se encontrada
        if (categoriaEncontrada != null) {
            categorias.remove(categoriaEncontrada);
            System.out.println("Categoria excluída com sucesso.");
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }



    public static void imprimirListaCategorias(List<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("A lista de categorias está vazia.");
        } else {
            System.out.println("Lista de Categorias:");
            for (Categoria categoria : categorias) {
                System.out.println("Nome: " + categoria.getNomeCategoria());
                System.out.println("Descrição: " + categoria.getDescricao());
                System.out.println("------------------------------");
            }
        }
    }


    // Menú de pedidos


    private static void menuPedidos(List<Pedido>pedidos) {
        Scanner entrada = new Scanner(System.in);
        int escolhaPedidos;
    
        while (true) {
            System.out.println("Menu de Pedidos:");
            System.out.println("1. Criar novo pedido");
            System.out.println("2. Consultar um pedido");
            System.out.println("3. Alterar dados de um pedido");
            System.out.println("4. Excluir um pedido");
            System.out.println("5. Imprimir lista de pedidos");
            System.out.println("0. Voltar para o menu principal");
    
            escolhaPedidos = entrada.nextInt();
    
            switch (escolhaPedidos) {
                case 1:
                    criarNovoPedido(pedidos);
                    break;
                case 2:
                    consultarPedido(pedidos);
                    break;
                case 3:
                    alterarPedido(pedidos);
                    break;
                case 4:
                    excluirPedido(pedidos);
                    break;
                case 5:
                    imprimirListaPedidos(pedidos);
                    break;
                case 0:
                    return; // Voltar para o menu principal.
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



    public static void criarNovoPedido(List<Pedido> pedidos) {
        Scanner entrada = new Scanner(System.in);
    
        System.out.println("Informe o ID do produto para o pedido: ");
        int produtoID = entrada.nextInt();
        entrada.nextLine(); // Consumir a quebra de linha
    
        Date dataPedido = coletarDataAtualizacao();
    
        System.out.println("Informe a situação do pedido: ");
        String situacaoPedido = entrada.nextLine();
    
        // Lista de itens do pedido (pode ser vazia ou conter itens)
        ArrayList<ItemPedido> itensPedido = new ArrayList<>();
    
        // Cria um novo pedido com as informações coletadas
        Pedido novoPedido = new Pedido(produtoID, itensPedido, dataPedido, situacaoPedido);
    
        // Adiciona o novo pedido à lista de pedidos
        pedidos.add(novoPedido);
    
        System.out.println("Novo pedido criado com sucesso!");
    }
    


    public static void consultarPedido(List<Pedido> pedidos) {
        Scanner entrada = new Scanner(System.in);

        if (pedidos.isEmpty()) {
            System.out.println("A lista de pedidos está vazia.");
            return;
        }

        System.out.println("Informe o ID do pedido que deseja consultar: ");
        int idPedidoConsulta = entrada.nextInt();

        Optional<Pedido> pedidoConsultado = pedidos.stream()
                .filter(pedido -> pedido.getProdutoID() == idPedidoConsulta)
                .findFirst();

        if (pedidoConsultado.isPresent()) {
            // Se o pedido foi encontrado, imprima suas informações
            Pedido pedido = pedidoConsultado.get();
            System.out.println("ID do Produto: " + pedido.getProdutoID());
            System.out.println("Data do Pedido: " + pedido.getDataPedido());
            System.out.println("Situação do Pedido: " + pedido.getSituacaoPedido());
        } else {
            System.out.println("Pedido não encontrado com o ID informado.");
        }
    }


    
    public static void alterarPedido(List<Pedido> pedidos) {
        Scanner entrada = new Scanner(System.in);
    
        if (pedidos.isEmpty()) {
            System.out.println("A lista de pedidos está vazia.");
            return;
        }
    
        System.out.println("Informe o ID do pedido que deseja alterar: ");
        int idPedidoAlteracao = entrada.nextInt();
    
        // Busque o pedido na lista com base no ID informado
        Optional<Pedido> pedidoParaAlteracao = pedidos.stream()
                .filter(pedido -> pedido.getProdutoID() == idPedidoAlteracao)
                .findFirst();
    
        if (pedidoParaAlteracao.isPresent()) {
            // Se o pedido foi encontrado, permita a alteração de dados
            Pedido pedido = pedidoParaAlteracao.get();
    
            // Exemplo: Alterar a situação do pedido
            System.out.println("Situação atual do Pedido: " + pedido.getSituacaoPedido());
            System.out.println("Informe a nova situação do Pedido: ");
            String novaSituacao = entrada.next();
            pedido.setSituacaoPedido(novaSituacao);
    
            System.out.println("Pedido alterado com sucesso.");
        } else {
            System.out.println("Pedido não encontrado com o ID informado.");
        }
    }



    public static void excluirPedido(List<Pedido> pedidos) {
        Scanner scanner = new Scanner(System.in);
    
        if (pedidos.isEmpty()) {
            System.out.println("A lista de pedidos está vazia.");
            return;
        }
    
        System.out.println("Informe o ID do pedido que deseja excluir: ");
        int idPedidoExclusao = scanner.nextInt();
    
        // Utilize um loop for para percorrer a lista de pedidos
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getProdutoID() == idPedidoExclusao) {
                pedidos.remove(i); // Remove o pedido da lista
                System.out.println("Pedido excluído com sucesso.");
                return;
            }
        }
    
        // Se o fluxo chegou aqui, o pedido não foi encontrado na lista
        System.out.println("Pedido não encontrado com o ID informado.");
    }



    public static void imprimirListaPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("A lista de pedidos está vazia.");
            return;
        }
    
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("ID do Pedido: " + pedido.getProdutoID());
            System.out.println("Data do Pedido: " + pedido.getDataPedido());
            System.out.println("Situação do Pedido: " + pedido.getSituacaoPedido());
            
            // Se desejar imprimir detalhes dos itens do pedido, pode percorrer a lista de itens aqui
            // Exemplo: for (ItemPedido item : pedido.getListaDeItens()) { ... }
    
            System.out.println("------------------------------");
        }
    }


    //Menú de estoque


    private static void menuEstoque(List<Produto>produtos) {
        Scanner entrada = new Scanner(System.in);
        int escolhaEstoque;
    
        while (true) {
            System.out.println("Menu de Estoque:");
            System.out.println("1. Incluir novo estoque");
            System.out.println("2. Consultar um estoque");
            System.out.println("3. Alterar dados de um estoque");
            System.out.println("4. Excluir um estoque");
            System.out.println("5. Imprimir lista de estoques");
            System.out.println("0. Voltar para o menu principal");
    
            escolhaEstoque = entrada.nextInt();
    
            switch (escolhaEstoque) {
                case 1:
                    incluirEstoqueProduto(produtos);
                    break;
                case 2:
                    consultarEstoqueProduto(produtos);
                    break;
                case 3:
                    alterarEstoqueProduto(produtos);
                    break;
                case 4:
                    excluirEstoqueProduto(produtos);
                    break;
                case 5:
                    imprimirListaEstoques(produtos);
                    break;
                case 0:
                    return; // Voltar para o menu principal.
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



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

    

    public static void consultarEstoqueProduto(List<Produto> produtos) {
        Scanner entrada = new Scanner(System.in);
    
        System.out.println("Informe o código do produto para consultar o estoque:");
        int codigoProduto = entrada.nextInt();
    
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
        Scanner entrada = new Scanner(System.in);
    
        System.out.println("Informe o código do produto para alterar o estoque:");
        int codigoProduto = entrada.nextInt();
    
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
        Scanner entrada = new Scanner(System.in);
    
        System.out.println("Informe o código do produto para excluir o estoque:");
        int codigoProduto = entrada.nextInt();
    
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


    // Métodos Auxiliares


    public static Estoque coletarInformacoesEstoque() {
        Scanner entrada = new Scanner(System.in);
    
        System.out.println("Informe a quantidade em estoque: ");
        int quantidadeEstoque = entrada.nextInt();
        entrada.nextLine();
    
        Date dataAtualizacao = coletarDataAtualizacao();
    
        // Cria um novo objeto Estoque com as informações coletadas
        Estoque estoque = new Estoque(quantidadeEstoque, dataAtualizacao);
    
        return estoque;
    }



    public static Produto encontrarProdutoPorCodigo(List<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;  // Produto não encontrado
    }



    public static Date coletarDataAtualizacao() {
        Scanner entrada = new Scanner(System.in);
        Date dataAtualizacao = null;
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Define o formato de data como estrito
    
        while (dataAtualizacao == null) {
            System.out.println("Informe a data (no formato dd-MM-yyyy): ");
            String dataInput = entrada.nextLine();
    
            try {
                dataAtualizacao = dateFormat.parse(dataInput);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }
        return dataAtualizacao;
    }



    
    public static boolean codigoRepetido(List<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return true; // Código já existe
            }
        }
        return false; // Código é único
    }



    public static Categoria selecionarCategoriaExistenteOuCriarNova(List<Categoria> categorias) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome da categoria: ");
        String nomeCategoria = entrada.nextLine();

        for (Categoria categoria : categorias) {
            if (categoria.getNomeCategoria().equalsIgnoreCase(nomeCategoria)) {
                return categoria;
            }
        }

        System.out.println("Informe a descrição da categoria: ");
        String descricaoCategoria = entrada.nextLine();

        Categoria novaCategoria = new Categoria(nomeCategoria, descricaoCategoria);
        categorias.add(novaCategoria);
        return novaCategoria;
    }
    


    public static void consultarProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }
    
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
    
    public static void consultarCategorias(List<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("A lista de categorias está vazia.");
            return;
        }
    
        System.out.println("Lista de Categorias:");
        for (Categoria categoria : categorias) {
            System.out.println("Nome: " + categoria.getNomeCategoria());
            System.out.println("Descrição: " + categoria.getDescricao());
            System.out.println("------------------------------");
        }
    }
}

