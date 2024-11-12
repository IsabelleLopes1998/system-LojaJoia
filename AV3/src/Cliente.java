public class Cliente extends Pessoa {
   protected String dataNascimento;

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return  "\nNome: " + nome +
                ", Sexo: " + sexo +
                ", Data de nascimento: " + dataNascimento +
                ", Idade: " + idade +
                ", cpf: " + cpf;
    }
}
