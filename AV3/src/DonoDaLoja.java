import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DonoDaLoja extends Funcionario {
    ArrayList<Funcionario> funcionarios = new ArrayList();
    ArrayList<Funcionario> vendedores = new ArrayList();


    public void demitirFuncionario(String cpf) {
        if (buscarFuncionario(cpf)) {
            Iterator<Funcionario> iterator = funcionarios.iterator();
            while (iterator.hasNext()) {
                Funcionario aux = iterator.next();
                if (aux.cpf.equalsIgnoreCase(cpf)) {
                    iterator.remove();
                    System.out.println(aux.nome + " foi retirado do sistema");
                    break;
                }
            }
        } else {
            System.out.println("\n-------------Funcionário não encontrado!-------------\n");
        }
    }

    public void contratarFuncionario(){
        Scanner res = new Scanner(System.in);
        Funcionario f = new Funcionario();
        System.out.println("Digite o nome do novo funcionário: ");
        f.nome = res.nextLine();
        System.out.println("Digite o sexo do novo funcionário: ");
        f.sexo = res.nextLine();
        System.out.println("Digite o CPF do novo funcionário: ");
        f.cpf = res.nextLine();
        System.out.println("Qual o cargo do novo funcionário ");
        f.cargo = res.nextLine();
        System.out.println("Qual a idade do novo funcionário ");
        f.idade = res.nextInt();
        System.out.println("Qual o salario do novo funcionário: ");
        f.salario = res.nextFloat();
        System.out.println("Novo funcionario(a) " + f.nome + " cadastrado com sucesso");
        funcionarios.add(f);
        if(f.cargo.equalsIgnoreCase("vendedor")){
            vendedores.add(f);
        }
    }

    public boolean buscarFuncionario(String cpf) {
        for(Funcionario aux:funcionarios){
            if(aux.cpf.equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
    public void mostrarFuncionarios(){
        System.out.println("\n-------------Lista dos funcionários da loja-------------\n");
        for(Funcionario aux:funcionarios){
            System.out.println("Lista dos funcionários da loja:");
            System.out.println(aux);
        }
    }

    @Override
    public String toString() {
        return "DonoDaLoj[" +
                ", nome='" + nome +
                ", sexo='" + sexo +
                ", idade=" + idade +
                ", cpf='" + cpf + "]";
    }

    public double calcularSalarioComBonusVendedor(double porcentagem, float salario) {
        if(porcentagem<=0) {
            try {
                throw new ValorInvalidoException("O valor deve ser maior que zero");
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return salario + (salario * (porcentagem / 100));
    }

    public boolean buscarVendedor(String cpf) {
        for(Funcionario aux:vendedores){
            if(aux.cpf.equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
    public void mostraListaVendedores(){
        System.out.println("\n------------- Lista dos vendedores da loja -------------\n");
        for(Funcionario aux:vendedores){
            System.out.println(aux);
        }
    }
     public void aplicarBonusVendedor(){
         Scanner res = new Scanner(System.in);
         System.out.println("Qual o cpf do funcionario que você deseja calcular o bonus?");
         String cpf = res.nextLine();
         if(buscarVendedor(cpf)){
            for (Funcionario aux:vendedores) {
                if(aux.cpf.equalsIgnoreCase(cpf)) {
                    System.out.println("Qual a porcentegagem que deseja aplicar?");
                    double porcentagem = res.nextDouble();
                    float salario = aux.salario;
                    float novoSalario = (float) calcularSalarioComBonusVendedor(porcentagem, salario);
                    System.out.println("O salário com bonus do vendendor " + aux.nome + " é: " + novoSalario);
                    break;
                }
            }
         }else{
             System.out.println("\n-------------Esse funciónario não é um vendedor-------------\n");
         }

     }

     public void criarFuncionario(){
         Funcionario f1 = new Funcionario();
         f1.nome = "João da Silva";
         f1.sexo = "M";
         f1.cpf = "123456789";
         f1.cargo = "vendedor";
         f1.idade = 24;
         f1.salario = 1500;
         funcionarios.add(f1);
         vendedores.add(f1);

         Funcionario f2 = new Funcionario();
         f2.nome = "Mario da Silva";
         f2.sexo = "M";
         f2.cpf = "222";
         f2.cargo = "Repositor";
         f2.idade = 24;
         f2.salario = 1500;
         funcionarios.add(f2);

         Funcionario f3 = new Funcionario();
         f3.nome = "Joana Dark";
         f3.nome = "Mario da Silva";
         f3.sexo = "333";
         f3.cpf = "123456789";
         f3.cargo = "Gerente";
         f3.idade = 32;
         f3.salario = 2000;
         funcionarios.add(f3);

         Funcionario f4 = new Funcionario();
         f4.nome = "Rodrigo Fernando Santos";
         f4.sexo = "M";
         f4.cpf = "444";
         f4.cargo = "vendedor";
         f4.idade = 24;
         f4.salario = 1500;
         funcionarios.add(f4);
         vendedores.add(f4);
     }




}
