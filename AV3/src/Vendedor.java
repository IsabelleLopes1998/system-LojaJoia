import java.util.ArrayList;
import java.util.Scanner;

public abstract class Vendedor extends Funcionario implements ClienteService{

    @Override
    public String toString() {
        return  "nome: " + nome +
                ", sexo: " + sexo  +
                ", idade: " + idade +
                ", cpf: " + cpf  +
                ", cargo: " + cargo  +
                ", salario: " + salario;
    }

}
