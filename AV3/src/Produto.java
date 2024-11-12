public class Produto {

    String nome;
    int codigo;
    int qtdDoProduto;
    float preco;
    String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdDoProduto() {
        return qtdDoProduto;
    }

    public void setQtdDoProduto(int qtdDoProduto) {
        this.qtdDoProduto = qtdDoProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\nnome: " + nome +
                ", \ncodigo: " + codigo +
                ", \nQuantidade Do Produto: " + qtdDoProduto +
                ", \npreco: " + preco;
    }
}

