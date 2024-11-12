import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        LojaJoias novaLoja = new LojaJoias();

        for (int i = 0; i < 10000; i++) {
            System.out.println("Qual o seu cargo? \n[1]-Dono \n[2]-Funcionário \n[3]-Vendedor");
            Scanner res = new Scanner(System.in);
            String resposta = res.nextLine();
            if(resposta.equalsIgnoreCase("1")){
                novaLoja.acoesDonoDaLoja();
            } else if(resposta.equalsIgnoreCase("2")){
                novaLoja.acoesFuncionario();
            } else if(resposta.equalsIgnoreCase("3")){
                novaLoja.acoesVendedor();
            }else {
                System.out.println("Resposta inválida");
            }
        }
    }
}
