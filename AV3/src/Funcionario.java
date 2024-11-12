import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    protected String cargo;
    protected float salario;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws ValorInvalidoException {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new ValorInvalidoException("O cargo não pode ser nulo ou vazio.");
        }
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) throws ValorInvalidoException {
        if (salario <= 0) {
            throw new ValorInvalidoException("O salário deve ser um valor positivo.");
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  "\nnome = " + nome  +
                ", \nsexo = " + sexo  +
                ", \nidade = " + idade +
                ", \ncpf = " + cpf  +
                ", \ncargo = " + cargo +
                ", \nsalario = " + salario;
    }
}
