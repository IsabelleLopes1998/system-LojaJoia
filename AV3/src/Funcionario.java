import java.util.ArrayList;
import java.util.Scanner;

public  class  Funcionario extends Pessoa{
    protected String cargo;
    protected float salario;


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  "\nnome = " + nome  +
                ", \nsexo = " + sexo  +
                ", \nidade =" + idade +
                ", \ncpf = " + cpf  +
                ", \ncargo= " + cargo +
                ", \nsalario = " + salario;
    }

}