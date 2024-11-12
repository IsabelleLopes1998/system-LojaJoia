public class Produto {

    String nome;
    int codigo;
    int qtdDoProduto;
    float preco;
    String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ValorInvalidoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValorInvalidoException("O nome do produto não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ValorInvalidoException {
        if (codigo <= 0) {
            throw new ValorInvalidoException("O código do produto deve ser um número positivo.");
        }
        this.codigo = codigo;
    }

    public int getQtdDoProduto() {
        return qtdDoProduto;
    }

    public void setQtdDoProduto(int qtdDoProduto) throws ValorInvalidoException {
        if (qtdDoProduto < 0) {
            throw new ValorInvalidoException("A quantidade do produto não pode ser negativa.");
        }
        this.qtdDoProduto = qtdDoProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) throws ValorInvalidoException {
        if (preco <= 0) {
            throw new ValorInvalidoException("O preço do produto deve ser um valor positivo.");
        }
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
