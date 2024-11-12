public abstract class Pessoa {
    protected String  nome;
    protected String sexo;
    protected int idade;
    protected String cpf;

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
