public interface ProdutoService {

    void cadastrarProduto();
    void excluirProduto(int codigo);
    boolean buscarProduto(int codigo);
    void mostrarProdutos();
    void verPrecoDoProduto();
    void mostrarUnicoProduto();
}
