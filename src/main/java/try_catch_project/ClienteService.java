package try_catch_project;

public class ClienteService {

    private final ClienteDao clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDao();
    }

    public ClienteService(ClienteDao clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /**
     * Regra de negócio responsável por validar a existência do cliente.
     * Caso não exista, lança uma exceção específica do domínio.
     */
    
    public void consultarCliente(String codigo)
            throws ClienteNaoEncontradoException {

        if (!clienteDAO.existe(codigo)) {
            throw new ClienteNaoEncontradoException(
                    "Cliente com código " + codigo + " não foi encontrado."
            );
        }
    }
}

