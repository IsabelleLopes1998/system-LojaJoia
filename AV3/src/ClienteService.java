public interface ClienteService {
    void cadastrarCliente();
    Cliente buscarClientePorCpf(String cpf);
    void atualizarCliente(String cpf);
    void excluirCliente(String cpf);
}
