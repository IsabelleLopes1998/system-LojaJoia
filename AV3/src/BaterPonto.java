public interface BaterPonto {
    static void baterPontoDeEntrada(String cpf, DonoDaLoja flavio){
        for (Funcionario aux : flavio.funcionarios) {
            if (aux.cpf.equalsIgnoreCase(cpf)) {
                System.out.println(aux.nome + " Confirmou a entrada");
            }
        }
    }
    static void baterPontoDeSaida(String cpf, DonoDaLoja flavio){
        for (Funcionario aux : flavio.funcionarios) {
            if (aux.cpf.equalsIgnoreCase(cpf)) {
                System.out.println(aux.nome + " Confirmou a saída");
            }
        }
    }
}
