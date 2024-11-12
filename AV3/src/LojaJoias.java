import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LojaJoias implements BaterPonto, ProdutoService {
    DonoDaLoja flavio = new DonoDaLoja();
    ArrayList<Produto> produtos = new ArrayList();
    ArrayList<Cliente> clientes = new ArrayList();
    ArrayList<Funcionario> vendedores = new ArrayList();
    ArrayList<Vendedor> vendas = new ArrayList();


    public void acoesDonoDaLoja(){
        Scanner res = new Scanner(System.in);
        flavio.criarFuncionario();
        for (int i = 0; i < 10000; i++) {
            System.out.println("\nDigite a ação que deseja realizar:" +
                    "\n[1]-Cadastrar funcionário " +
                    "\n[2]-Demitir um funcionário " +
                    "\n[3]-Calcular Bonus do vendedor " +
                    "\n[4]-Lista de funcionários " +
                    "\n[5]-Voltar");
            String resposta = res.nextLine();
            if (resposta.equalsIgnoreCase("1")) {
                flavio.contratarFuncionario();
            } else if (resposta.equalsIgnoreCase("2")) {
                System.out.println("Qual o cpf do funcionário?");
                String cpf = res.nextLine();
                flavio.demitirFuncionario(cpf);
            } else if(resposta.equalsIgnoreCase("3")){
                flavio.aplicarBonusVendedor();
            } else if(resposta.equalsIgnoreCase("4")){
                flavio.mostrarFuncionarios();
                flavio.mostraListaVendedores();
            }else if(resposta.equalsIgnoreCase("5")) {
                System.out.println("-------------Voltando...-------------\n");
                break;
            } else {
                System.out.println("\n-------------Sua reposta não é válida!-------------\n");
            }
        }
    }
    public void acoesFuncionario(){
        Scanner res = new Scanner(System.in);
        criarProduto();
        for (int i = 0; i < 10000; i++) {
            System.out.println("\nQual ação você deseja fazer?" +
                    "\n[1]-bater o ponto de entrada." +
                    "\n[2]-bater ponto de saída." +
                    "\n[3]-Ações sobre o pronduto." +
                    "\n[4]-Ações sobre o cliente" +
                    "\n[5]-Sair do sistema");
            String respostaAcao = res.nextLine();
            if(respostaAcao.equalsIgnoreCase("1")){
                System.out.println("Digite seu cpf: ");
                String cpfEntrada = res.nextLine();
                BaterPonto.baterPontoDeEntrada(cpfEntrada, flavio);
            } else if(respostaAcao.equalsIgnoreCase("2")){
                System.out.println("Digite seu cpf: ");
                String cpfSaida = res.nextLine();
                BaterPonto.baterPontoDeSaida(cpfSaida, flavio);
            }else if (respostaAcao.equalsIgnoreCase("3")) {
                acoesSobreProduto();
            }else if(respostaAcao.equalsIgnoreCase("4")){
                acoesSobreCliente();
            }else if(respostaAcao.equalsIgnoreCase("5")){
                System.out.println("\n-------------Sistema finalizado-------------\n");
                break;
            }
        }
    }
    public void acoesVendedor(){
        Scanner res = new Scanner(System.in);
        for (int i = 0; i < 1000000; i++) {
            System.out.println("Digite uma das opções: \n[1]-Vender um produto \n[2]-Ações sobre o produto \n[3]-Cancelar operação");
            int resposta = res.nextInt();
            if (resposta == 1) {
                res.nextLine();
                System.out.println("Qual o cpf do vendedor?");
                String cpf = res.nextLine();
                if (flavio.buscarVendedor(cpf)) {
                    System.out.println("Qual o código do produto que você irá vender?");
                    int codigo = res.nextInt();
                    venderProduto(codigo);
                }else{
                    System.out.println("\n------------ Vendedor não encontradon ------------\n");
                }
            }else if (resposta == 2) {
                acoesSobreProduto();
            } else if (resposta == 3) {
                System.out.println("\n------------ Ação cancelada com sucesso ------------\n");
                break;
            } else {
                System.out.println("\n------------Resposta invalida------------\n");
            }
        }

    }

    public void acoesSobreProduto(){
        for (int j = 0; j < 10000; j++) {
            Scanner res = new Scanner(System.in);
            System.out.println("\nDigite uma das opções: " +
                    "\n[1]-Cadastrar " +
                    "\n[2]-Excluir " +
                    "\n[3]-Mostrar informações do produto " +
                    "\n[4]-Lista de produtos " +
                    "\n[5]-Voltar?");
            String resposta = res.nextLine();
            if (resposta.equalsIgnoreCase("1")) {
                cadastrarProduto();
            } else if (resposta.equalsIgnoreCase("2")) {
                System.out.println("Qual o código do produto você deseja do excluir?");
                int codigo = res.nextInt();
                excluirProduto(codigo);
            } else if (resposta.equalsIgnoreCase("3")) {
                mostrarUnicoProduto();
            } else if(resposta.equalsIgnoreCase("4")){
                mostrarProdutos();
            }else if (resposta.equalsIgnoreCase("5")) {
                System.out.println("\n-------------Voltando...-------------");
                break;
            } else {
                System.out.println("\n-------------Sua reposta não é válida!-------------\n");
            }
        }
    }

    public void cadastrarProduto(){
        Scanner res = new Scanner(System.in);
        Produto p = new Produto();
        System.out.println("Digite o cógido do produto: ");
        p.codigo = res.nextInt();
        res.nextLine();
        System.out.println("Qual o tipo do produto: ");
        p.tipo = res.nextLine();
        System.out.println("Qual o nome do produto: ");
        p.nome = res.nextLine();
        System.out.println("Qual o preço do produto: ");
        p.preco = res.nextFloat();
        System.out.println("Digite a quantidade do produto: ");
        p.qtdDoProduto = res.nextInt();
        produtos.add(p);
    }


    public void excluirProduto(int codigo) {
        if (buscarProduto(codigo)) {
            Iterator<Produto> iterator = produtos.iterator();
            while (iterator.hasNext()) {
                Produto aux = iterator.next();
                if (aux.codigo == codigo) {
                    iterator.remove();
                    System.out.println(aux.nome + " foi retirado do sistema");
                    break;
                }
            }
        } else {
            System.out.println("\n------------ Produto não encontrado! ------------\n");
        }

    }

    public boolean buscarProduto(int codigo) {
        for(Produto aux:produtos){
            if(aux.codigo == codigo){
                return true;
            }
        }
        return false;
    }

    public void mostrarUnicoProduto(){
        Scanner res = new Scanner(System.in);
        System.out.println("Qual o código do produto?");
        int codigo = res.nextInt();
        if(buscarProduto(codigo)){
            for(Produto aux: produtos){
                if(aux.codigo == codigo){
                    System.out.println(aux);
                }
            }
        }
    }

    public void mostrarProdutos() {
        System.out.println("\n------------ Lista de Produto -------------\n");
        for(Produto aux:produtos){
                System.out.println(aux);
        }
    }
    public void verPrecoDoProduto(){
        Scanner res = new Scanner(System.in);
        System.out.println("Qual o código do produto");
        int codigo = res.nextInt();
        if(buscarProduto(codigo)) {
            for (Produto aux : produtos) {
                if (aux.codigo == codigo) {
                    System.out.println("O preço do produto,  " + aux.codigo + " é: " + aux.preco);
                }
            }
        }
    }

    public void cadastrarCliente() {
        Scanner res = new Scanner(System.in);
        Cliente novoCliente = new Cliente();
        System.out.println("Qual o nome do novo cliente?");
        novoCliente.nome = res.nextLine();
        System.out.println("Qual o sexo do novo cliente?");
        novoCliente.sexo = res.nextLine();
        System.out.println("Qual a idade do novo cliente?");
        novoCliente.idade = res.nextInt();
        res.nextLine();
        System.out.println("Qual o cpf do novo cliente?");
        novoCliente.cpf = res.nextLine();
        System.out.println("Qual a data de nascimento do novo cliente?");
        novoCliente.dataNascimento = res.nextLine();
        clientes.add(novoCliente);
        System.out.println("\n------------Cliente cadastrado com Sucesso!---------------\n");
    }


    public Cliente buscarClientePorCpf() {
        Scanner res = new Scanner(System.in);
        System.out.println("Digite o cpf do cliente");
        String cpf = res.nextLine();
        for(Cliente aux:clientes){
            if(aux.cpf.equalsIgnoreCase(cpf)){
                System.out.println("Cliente encontrado. \nInformações do cliente:" + "\n" + aux);
            }else if(!aux.cpf.equalsIgnoreCase(cpf)){
                System.out.println("Cliente não encontrado. Deseja cadastrar o novo cliente?");
                String resposta = res.nextLine();
                if(resposta.equalsIgnoreCase("sim")){
                    cadastrarCliente();
                }else{
                    System.out.println("!!!!!!----Operação cancelada----!!!!!!");
                }
            }
        }
        return null;
    }
    public boolean buscarCliente(String cpf) {
        for(Cliente aux:clientes){
            if(aux.cpf.equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
    public void atualizarCliente() {
        Scanner res = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente");
        String cpf = res.nextLine();

        boolean clienteEncontrado = false;

        for (Cliente aux : clientes) {
            if (aux.cpf.equalsIgnoreCase(cpf)) {
                clienteEncontrado = true;
                System.out.println("Deseja atualizar as informações do cliente: " + aux.nome + "?" +
                        "\n[1]-Sim\n[2]-Não");
                String resposta = res.nextLine();
                if (resposta.equalsIgnoreCase("1")) {
                    atualizarDadosCliente(aux);
                    System.out.println("\n------------- Informações do cliente atualizadas -------------\n");
                }
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("\n------------- Cliente não encontrado -------------\n");
        }
    }

    public void atualizarDadosCliente(Cliente clienteExistente) {
        Scanner res = new Scanner(System.in);
        System.out.println("Atualizando informações do cliente: " + clienteExistente.nome);
        System.out.println("Qual o nome do cliente? (atual: " + clienteExistente.nome + ")");
        clienteExistente.nome = res.nextLine();
        System.out.println("Qual o sexo do cliente? (atual: " + clienteExistente.sexo + ")");
        clienteExistente.sexo = res.nextLine();
        System.out.println("Qual a idade do cliente? (atual: " + clienteExistente.idade + ")");
        clienteExistente.idade = res.nextInt();
        res.nextLine();
        System.out.println("Qual o cpf do cliente? (atual: " + clienteExistente.cpf + ")");
        clienteExistente.cpf = res.nextLine();
        System.out.println("Qual a data de nascimento do cliente? (atual: " + clienteExistente.dataNascimento + ")");
        clienteExistente.dataNascimento = res.nextLine();
        System.out.println("Cliente atualizado com sucesso!\n");
    }
    public void excluirCliente(String cpf) {
        if (buscarCliente(cpf)) {
            Iterator<Cliente> iterator = clientes.iterator();
            while (iterator.hasNext()) {
                Cliente aux = iterator.next();
                if (aux.cpf.equalsIgnoreCase(cpf)) {
                    iterator.remove();
                    System.out.println("\n"+ aux.nome + " foi retirado do sistema\n");
                    break;
                }
            }
        } else {
            System.out.println("\n------------ Cliente não encontrado! ------------\n");
        }
    }

    public void mostrarClientes(){
        for(Cliente aux:clientes){
                System.out.println(aux);
        }
    }

    public void acoesSobreCliente(){
        for (int j = 0; j < 10000; j++) {
            Scanner res = new Scanner(System.in);
            System.out.println("Digite uma das opções: " +
                    "\n[1]-Cadastrar Cliente " +
                    "\n[2]-Excluir Cliente " +
                    "\n[3]-Atualizar Cliente " +
                    "\n[4]-Buscar Cliente " +
                    "\n[5]-Mostrar Todos os Clientes " +
                    "\n[6]-Voltar");
            String resposta = res.nextLine();
            if (resposta.equalsIgnoreCase("1")) {
                cadastrarCliente();
            } else if (resposta.equalsIgnoreCase("2")) {
                System.out.println("Digite o cpf do cliente");
                String cpf = res.nextLine();
                excluirCliente(cpf);
            } else if (resposta.equalsIgnoreCase("3")) {
                atualizarCliente();
            } else if(resposta.equalsIgnoreCase("4")){
                buscarClientePorCpf();
            }else if (resposta.equalsIgnoreCase("5")) {
                mostrarClientes();
            }else if(resposta.equalsIgnoreCase("6")){
                System.out.println("Sistema finalizado");
                break;
            }else {
                System.out.println("Sua reposta não é válida!");
            }
        }
    }
    public void confirmarVenda(){
        Scanner res = new Scanner(System.in);
        System.out.println("O pagamento foi realizado com sucesso? [1]-Sim ou [2]-Não");
        String resposta = res.nextLine();
        if(resposta.equalsIgnoreCase("1")){
            System.out.println("Venda realizada com sucesso");
        }

    }

    public void venderProduto(int codigo){
        if (buscarProduto(codigo)) {
            for (Produto aux:produtos){
                Scanner res = new Scanner(System.in);
                System.out.println("Quantidade do produto que será vendida: ");
                int qtd = res.nextInt();
                res.nextLine();
                if(qtd < aux.qtdDoProduto){
                    System.out.println("Produto pronto para venda. Finalize com pagamento");
                    confirmarVenda();
                    int novaQtd = aux.qtdDoProduto - qtd;
                    aux.qtdDoProduto = novaQtd;
                    System.out.println("Nova quantidade em estoque do produto " + aux.nome + ": " + novaQtd);
                    break;
                } else if(qtd == aux.qtdDoProduto){
                    System.out.println("AVISO: A quantidade da venda é igual a do estoque. Deseja continuar?\n[1]-Sim \n[2]-Não");
                    String resposta = res.nextLine();
                    if(resposta.equalsIgnoreCase("1")){
                        System.out.println("Produto pronto para venda. Finalize com pagamento");
                        confirmarVenda();
                        int novaQtd = aux.qtdDoProduto - qtd;
                        aux.qtdDoProduto = novaQtd;
                        System.out.println("Nova quantidade em estoque do produto " + aux.nome + ": " + novaQtd);
                        break;
                    }else{
                        System.out.println("Venda cancelada");
                    }
                }else if(qtd > aux.qtdDoProduto){
                    System.out.println("A quantidade do pedido ultrapassa a quantidade do estoque. " +
                            "\nA quantidade do estoque é: " + aux.qtdDoProduto);
                }
            }
        } else{
            System.out.println("Produto com o código " + codigo + " não encontrado!");
        }
    }

    //public void atualizarQtdDoProduto(Produto produto, int qtdVendida)

    public void criarProduto(){
        Produto p1 = new Produto();
        p1.codigo = 1;
        p1.tipo = "Colar";
        p1.nome = "Colar de rosas";
        p1.preco = 15;
        p1.qtdDoProduto = 12;
        produtos.add(p1);
        Produto p2 = new Produto();
        p2.codigo = 2;
        p2.tipo = "Anel";
        p2.nome = "Anel de rosas";
        p2.preco = 15;
        p2.qtdDoProduto = 12;
        produtos.add(p2);
        Produto p3 = new Produto();
        p3.codigo = 3;
        p3.tipo = "Pulseira";
        p3.nome = "Pulseira de rosas";
        p3.preco = 15;
        p3.qtdDoProduto = 12;
        produtos.add(p3);
    }
}



